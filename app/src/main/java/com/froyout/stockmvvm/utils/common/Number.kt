package com.froyout.stockmvvm.utils.common

import java.text.DecimalFormat
import kotlin.math.ln
import kotlin.math.pow

object NumberUtils {
    fun noPref(num: Int): String{
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(num)
    }

    fun withSuff(num: Long): String {
        if (num < 1000) return "" +  num
        val exp = (ln(num.toDouble()) / ln(1000.0)).toInt()
        val format = DecimalFormat("0.#")
        val value = format.format(num / 1000.0.pow(exp.toDouble()))
        return String.format("%s%c", value, "kMBTPE"[exp - 1])
    }
}