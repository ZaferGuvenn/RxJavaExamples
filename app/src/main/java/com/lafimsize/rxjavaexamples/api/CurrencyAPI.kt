package com.lafimsize.rxjavaexamples.api

import com.lafimsize.rxjavaexamples.model.MoneyCurrency
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyAPI {

    @GET("{API_KEY}/latest/{CURRENCY_CODE}")
    fun getAllCurrencies(
        @Path("API_KEY") apiKey:String,
        @Path("CURRENCY_CODE") currencyCode:String
    ): Flowable<MoneyCurrency>

}