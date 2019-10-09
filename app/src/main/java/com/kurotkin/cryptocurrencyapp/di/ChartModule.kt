package com.kurotkin.cryptocurrencyapp.di
import com.kurotkin.cryptocurrencyapp.YearValueFormatter
import com.kurotkin.cryptocurrencyapp.chart.LatestChart
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ChartModule {
    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()

    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()
}