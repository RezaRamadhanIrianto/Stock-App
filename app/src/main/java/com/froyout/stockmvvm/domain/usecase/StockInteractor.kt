package com.froyout.stockmvvm.domain.usecase

import androidx.lifecycle.LiveData
import com.froyout.stockmvvm.data.repositories.StockRepository
import com.froyout.stockmvvm.domain.models.Stock
import com.froyout.stockmvvm.domain.repository.IStockRepository
import javax.inject.Inject

class StockInteractor @Inject constructor(private val repo: IStockRepository): StockUseCase {
    override fun getStock(): LiveData<List<Stock>> {
        return repo.getStock()
    }
}