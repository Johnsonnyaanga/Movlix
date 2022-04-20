package com.johnson.remote.di

import com.johnson.domain.usecases.MoviesUseCase
import org.koin.dsl.module


val UseCaseModule = module {
    single { MoviesUseCase(get())  }
}