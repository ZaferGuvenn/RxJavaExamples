package com.lafimsize.rxjavaexamples.model


data class MoneyCurrency(
    val base_code: String,
    val documentation: String,
    val result: String,
    val terms_of_use: String,
    val time_last_update_unix: Int,
    val time_last_update_utc: String,
    val time_next_update_unix: Int,
    val time_next_update_utc: String,
    val conversion_rates: Map<String,Double>
)