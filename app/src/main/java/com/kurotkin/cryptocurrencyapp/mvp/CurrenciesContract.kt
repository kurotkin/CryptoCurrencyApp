package com.kurotkin.cryptocurrencyapp.mvp

import com.kurotkin.cryptocurrencyapp.Currency

class CurrenciesContract {

    interface View : BaseContract.View {
        fun addCurrency(currency: Currency)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter: BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}