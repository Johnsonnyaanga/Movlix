package com.johnson.movlix

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johnson.domain.utils.NetworkResource
import com.johnson.movlix.adapter.TrendingMoviesAdapter
import com.johnson.movlix.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    val viewModel: MainViewModel by inject()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
        supportActionBar?.hide()
        val isConnected = InternetConnection.checkConnection(this)
        Log.d("isconnected",isConnected.toString())




        viewModel.getTrendingMovies()

        getMovies()






    }

    fun getMovies(){
        viewModel.trendingMovies.observe(this, {
            val trendingMoviesAdapter = TrendingMoviesAdapter()
            when(it){
                is NetworkResource.Success -> {
                    Log.d("new data", it.value.body()?.results.toString())
                    trendingMoviesAdapter.differ.submitList(it.value.body()?.results)
                    val layoutmanager  = GridLayoutManager(this,4)
                    binding.recyclerview.adapter = trendingMoviesAdapter
                    binding.recyclerview.layoutManager = layoutmanager

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