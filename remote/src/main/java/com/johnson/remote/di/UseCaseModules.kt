package com.johnson.remote.di

import com.johnson.remote.usecases.MoviesUseCase
import org.koin.dsl.module

val UseCaseModule = module {
    factory { MoviesUseCase(get())   }
}