package com.lafimsize.rxjavaexamples.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lafimsize.rxjavaexamples.BuildConfig
import com.lafimsize.rxjavaexamples.R
import com.lafimsize.rxjavaexamples.databinding.ActivityMainBinding
import com.lafimsize.rxjavaexamples.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.activity_main,null,false)
        setContentView(binding.root)

        val apiKey=BuildConfig.API_KEY
        val currencyCode="TRY"

        viewModel=ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.cevirBTN.setOnClickListener {
            viewModel.getMoneyInfo(apiKey,currencyCode)
        }

        observeLiveData()
    }

    private fun observeLiveData(){

        viewModel._moneyCurrency.observe(this){

            println("Çıktı tamam!")
            println(it.conversion_rates)
            binding.textView.text=it.toString()
        }

    }
}