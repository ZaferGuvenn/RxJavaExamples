package com.lafimsize.rxjavaexamples.api

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyAPIService {

    private val BASE_URL="https://v6.exchangerate-api.com/v6/"
    private val api=Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build().create(CurrencyAPI::class.java)

    fun getResult(apiKey:String,currencyCode:String)=api.getAllCurrencies(apiKey, currencyCode)

}