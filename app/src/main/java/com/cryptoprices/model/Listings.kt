package com.cryptoprices.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Listings {

    @SerializedName("data")
    @Expose
    var coins: List<Coin?> = ArrayList()

}