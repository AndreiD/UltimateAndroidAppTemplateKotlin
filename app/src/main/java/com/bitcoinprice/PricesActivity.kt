package com.bitcoinprice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.bitcoinprice.adapters.PricesAdapter
import com.bitcoinprice.data.TheApiService
import com.bitcoinprice.model.Listings
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PricesActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private val mAdapter: PricesAdapter = PricesAdapter()
    private var disposable: Disposable? = null
    private val theApiService by lazy {
        TheApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prices)

        mRecyclerView = findViewById(R.id.recycler_prices)

        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mAdapter

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
