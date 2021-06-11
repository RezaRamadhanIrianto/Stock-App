package com.froyout.stockmvvm.modules.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.froyout.stockmvvm.domain.models.Stock
import com.froyout.stockmvvm.domain.usecase.StockInteractor
import com.froyout.stockmvvm.domain.usecase.StockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: StockUseCase): ViewModel() {
    fun getStocks(): LiveData<List<Stock>>{
        return useCase.getStock()
    }
}