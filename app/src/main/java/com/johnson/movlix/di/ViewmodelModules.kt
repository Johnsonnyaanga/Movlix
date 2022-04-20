package com.johnson.movlix.di

import com.johnson.movlix.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val mainViewModel = module {
    viewModel { MainViewModel(get()) }
}