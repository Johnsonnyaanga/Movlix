package com.johnson.movlix

import android.app.Application
import com.johnson.movlix.di.mainViewModel
import com.johnson.remote.di.UseCaseModule
import com.johnson.remote.di.networkModule
import com.johnson.remote.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovlixApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovlixApp)
            modules(networkModule, repositoryModule, mainViewModel, UseCaseModule)
        }
    }
}