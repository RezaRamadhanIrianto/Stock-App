package com.froyout.stockmvvm.di

import com.froyout.stockmvvm.data.repositories.StockRepository
import com.froyout.stockmvvm.domain.repository.IStockRepository
import com.froyout.stockmvvm.domain.usecase.StockInteractor
import com.froyout.stockmvvm.domain.usecase.StockUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    fun provideStockRepo(): IStockRepository{
        return StockRepository()
    }
    @Provides
    fun provideStockUseCase(repo: IStockRepository): StockUseCase{
        return StockInteractor(repo)
    }
}