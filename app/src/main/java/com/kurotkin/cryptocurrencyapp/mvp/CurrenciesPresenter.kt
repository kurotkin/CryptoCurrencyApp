package com.kurotkin.cryptocurrencyapp.mvp

import com.kurotkin.cryptocurrencyapp.Currency
import com.kurotkin.cryptocurrencyapp.di.App
import com.kurotkin.cryptocurrencyapp.formatThousands
import com.kurotkin.cryptocurrencyapp.rest.CoinGeckoApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrenciesPresenter  : CurrenciesContract.Presenter() {

    //внедряем источник данных
    @Inject
    lateinit var geckoApi: CoinGeckoApi

    //инициализируем компоненты Даггера
    init {
        App.appComponent.inject(this)
    }

    //создаем список, загружая данные с помощью RxJava
    override fun makeList() {
        view.showProgress()

        subscribe(geckoApi.getCoinMarket()              //подписываемся на поток данных
            .subscribeOn(Schedulers.io())               //определяем отдельный поток для отправки данных
            .observeOn(AndroidSchedulers.mainThread())  //получаем данные в основном потоке
            .flatMap { Observable.fromIterable(it) }    //преобразуем List<GeckoCoin> в Observable<GeckoCoin>
            .doOnNext {                                 //наполняем поля элемента списка для адаптера
                view.addCurrency(
                    Currency(
                        it.id,
                        it.symbol,
                        it.name,
                        it.image,
                        it.current_price,
                        it.market_cap.formatThousands(),
                        it.market_cap_rank,
                        it.total_volume,
                        it.price_change_percentage_24h,
                        it.market_cap_change_percentage_24h,
                        it.circulating_supply,
                        it.total_supply,
                        it.ath,
                        it.ath_change_percentage
                    )
                )
            }
             .doOnComplete {                //вызывается при вызове onComplete
                view.hideProgress()
            }
            .subscribe({                    //подписывает Observer на Observable
                view.hideProgress()
                view.notifyAdapter()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }

    //обновляем список
    override fun refreshList() {
        view.refresh()
        makeList()
    }
}