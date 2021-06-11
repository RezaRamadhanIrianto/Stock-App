package com.froyout.stockmvvm.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.froyout.stockmvvm.domain.models.Stock
import com.froyout.stockmvvm.domain.repository.IStockRepository
import com.froyout.stockmvvm.utils.dummy.DataDummy
import javax.inject.Inject

class StockRepository @Inject constructor (): IStockRepository {
    override fun getStock(): LiveData<List<Stock>> {
        val stocks = MutableLiveData<List<Stock>>()
        stocks.postValue(DataDummy.getDummyStock())
        return stocks
    }
}