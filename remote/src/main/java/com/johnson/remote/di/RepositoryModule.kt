package com.johnson.remote.di

import com.johnson.domain.repository.MoviesRepository
import com.johnson.remote.repository.MoviesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MoviesRepository>{ MoviesRepositoryImpl(get()) }
}
