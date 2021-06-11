package com.froyout.stockmvvm.domain.usecase

import androidx.lifecycle.LiveData
import com.froyout.stockmvvm.domain.models.Stock

interface StockUseCase {
    fun getStock(): LiveData<List<Stock>>
}