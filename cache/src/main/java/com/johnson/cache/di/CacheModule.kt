package com.johnson.cache.di

import androidx.room.Room
import com.johnson.cache.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val CacheModule = module {
    single { Room.databaseBuilder(
        androidApplication(),
        AppDataBase::class.java,
        "movies_database"
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build() }

    single { get<AppDataBase>().itemDao() }
}