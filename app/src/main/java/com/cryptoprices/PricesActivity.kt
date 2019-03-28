package com.cryptoprices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.cryptoprices.adapters.PricesAdapter
import com.cryptoprices.data.TheApiService
import com.cryptoprices.model.Listings
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_prices.*

class PricesActivity : AppCompatActivity() {

    private val mAdapter: PricesAdapter = PricesAdapter()
    private var disposable: Disposable? = null
    private val theApiService by lazy {
        TheApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prices)

        recycler_prices.setHasFixedSize(true)
        recycler_prices.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recycler_prices.adapter = mAdapter

        getListings()
    }

    private fun getListings() {
        disposable = theApiService.getListings("1", "10")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> populateRecycler(result) },
                { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
            )
    }

    private fun populateRecycler(result: Listings?) {
        if (result?.coins != null) {
            mAdapter.PricesAdapter(result.coins, this)
            mAdapter.notifyDataSetChanged()
        } else {
            Toast.makeText(this, "There isn't any data", Toast.LENGTH_LONG).show()
        }

    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}
