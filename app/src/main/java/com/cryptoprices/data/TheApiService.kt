package com.cryptoprices.data

import com.cryptoprices.model.Listings
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TheApiService {


    @GET("latest")
    @Headers(
        "Accept: application/json",
        "Content-type:application/json",
        "X-CMC_PRO_API_KEY:f9e8664f-2a69-4a97-b6af-a1aa6258c3cf"
    )
    fun getListings(@Query("start") start: String,
                    @Query("limit") limit: String):
            Observable<Listings>


    companion object {
        fun create(): TheApiService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/")
                .build()

            return retrofit.create(TheApiService::class.java)
        }
    }

}