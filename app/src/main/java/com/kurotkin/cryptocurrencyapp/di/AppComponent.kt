package com.kurotkin.cryptocurrencyapp.di

import com.kurotkin.cryptocurrencyapp.activities.MainActivity
import com.kurotkin.cryptocurrencyapp.fragments.CurrenciesListFragment
import com.kurotkin.cryptocurrencyapp.mvp.CurrenciesPresenter
import com.kurotkin.cryptocurrencyapp.mvp.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)
    fun inject(fragment: CurrenciesListFragment)
}