package com.johnson.movlix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.johnson.commons.utils.NetworkResource
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import java.util.*

class MainActivity : AppCompatActivity() {
    val viewModel:MainViewModel by inject<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getTrendingMovies()
        viewModel.trendingMovies.observe(this, {
            when(it){
                is NetworkResource.Success -> {
                    Log.d("new data", it.value.body()?.results.toString())
                }
                is NetworkResource.Failure ->{
                    Log.d("new data", it.errorCode.toString())
                }

                is NetworkResource.Loading ->{
                    Log.d("new data", "loading")
                }
            }

        })



    }
}