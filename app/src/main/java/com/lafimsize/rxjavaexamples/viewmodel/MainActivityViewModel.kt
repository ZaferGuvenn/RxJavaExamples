package com.lafimsize.rxjavaexamples.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lafimsize.rxjavaexamples.api.CurrencyAPIService
import com.lafimsize.rxjavaexamples.model.MoneyCurrency
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityViewModel:ViewModel() {

    private val disposable=CompositeDisposable()
    private val moneyCurrencyLiveData=MutableLiveData<MoneyCurrency>()
    private val currencyAPIService=CurrencyAPIService()
    val _moneyCurrency:LiveData<MoneyCurrency>
        get() = moneyCurrencyLiveData

    fun getMoneyInfo(apiKey:String,currencyCode:String){

        disposable.add(currencyAPIService.getResult(apiKey, currencyCode)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this :: handleResponse))

    }

    private fun handleResponse(moneyCurrency: MoneyCurrency){
        println(moneyCurrency)
        moneyCurrencyLiveData.value=moneyCurrency
    }

    override fun onCleared() {
        super.onCleared()

        disposable.dispose()
    }

}