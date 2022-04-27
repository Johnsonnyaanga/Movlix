package com.johnson.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.johnson.cache.daos.ItemsDbDao
import com.johnson.cache.models.ResultEntity
import com.johnson.cache.models.TrendingResponseEntity
import com.johnson.cache.utils.Converters

@Database(entities = [ResultEntity::class, TrendingResponseEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun itemDao(): ItemsDbDao
}
