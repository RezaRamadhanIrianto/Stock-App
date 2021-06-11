package com.froyout.stockmvvm.utils.dummy

import com.froyout.stockmvvm.domain.models.Stock

object DataDummy {
    fun getDummyStock() : List<Stock>{
        val stocks = ArrayList<Stock>()

        stocks.add(
            Stock(
                id = "1",
                name = "BBRI",
                imageUrl = "https://cdn-kbm-01.sgp1.digitaloceanspaces.com/master/payment_method/bri_bank.png",
                data = addList(floatArrayOf(10F, 20F, 30F, 35F, 30F)),
                type = "Saham",
                imbal = "10.1%/Tahun",
                dana = 1000000,
                pembelian = "1 Juta",
                jangka = "1 Tahun",
                resiko = "Tinggi",
                peluncuran = "17 Apr 2020"
            )
        )
        stocks.add(
            Stock(
                id = "1",
                name = "BBCA",
                imageUrl = "https://cdn-kbm-01.sgp1.digitaloceanspaces.com/master/payment_method/bca_bank.png",
                data = addList(floatArrayOf(20F, 50F, 45F, 60F, 30F)),
                type = "Saham",
                imbal = "12.1%/Tahun",
                dana = 10000000,
                pembelian = "2 Juta",
                jangka = "1 Tahun",
                resiko = "Tinggi",
                peluncuran = "18 Apr 2020"
            )
        )
        stocks.add(
            Stock(
                id = "1",
                name = "BBNI",
                imageUrl = "https://cdn-kbm-01.sgp1.digitaloceanspaces.com/master/payment_method/bni_bank.png",
                data = addList(floatArrayOf(15F, 20F, 20F, 25F, 40F)),
                type = "Saham",
                imbal = "10.5%/Tahun",
                dana = 1000000,
                pembelian = "1 Juta",
                jangka = "1 Tahun",
                resiko = "Tinggi",
                peluncuran = "19 Apr 2020"
            )
        )

        return stocks
    }

    fun addList(a: FloatArray): List<Float>{
        val lists = ArrayList<Float>()
        for(i in a){
            lists.add(i)
        }
        return lists
    }
}