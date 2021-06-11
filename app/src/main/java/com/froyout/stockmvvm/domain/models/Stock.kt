package com.froyout.stockmvvm.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stock(
    var id : String,
    var name: String,
    var imageUrl: String,

    var data: List<Float>,
    var type: String,
    var imbal: String,
    var dana: Int,
    var pembelian: String,
    var jangka: String,
    var resiko: String,
    var peluncuran: String,
): Parcelable