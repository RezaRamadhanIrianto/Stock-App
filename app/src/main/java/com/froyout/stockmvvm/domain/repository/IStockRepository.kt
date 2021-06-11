package com.froyout.stockmvvm.domain.repository

import androidx.lifecycle.LiveData
import com.froyout.stockmvvm.domain.models.Stock

interface IStockRepository {
    fun getStock(): LiveData<List<Stock>>
}