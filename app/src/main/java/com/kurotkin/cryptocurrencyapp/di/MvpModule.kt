package com.kurotkin.cryptocurrencyapp.di

import com.kurotkin.cryptocurrencyapp.mvp.CurrenciesPresenter
import com.kurotkin.cryptocurrencyapp.mvp.LatestChartPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): CurrenciesPresenter = CurrenciesPresenter()

    @Provides
    @Singleton
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()
}