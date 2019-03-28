package com.cryptoprices.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coin {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("symbol")
    @Expose
    var mSymbol: String? = null
}