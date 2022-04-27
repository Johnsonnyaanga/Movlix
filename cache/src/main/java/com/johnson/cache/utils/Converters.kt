package com.johnson.cache.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.johnson.cache.models.ResultEntity

object Converters {

    @TypeConverter
    fun fromMovieList(movie: List<ResultEntity>): String {
        val type = object : TypeToken<List<ResultEntity>>() {}.type
        return Gson().toJson(movie, type)
    }

    @TypeConverter
    fun toMovieList(jString: String): List<ResultEntity> {
        val type = object : TypeToken<List<ResultEntity>>() {}.type
        return Gson().fromJson(jString, type)
    }

    @TypeConverter
    fun fromListInt(genre_ids:List<Int>):String{
        val type = object: TypeToken<List<Int>>() {}.type
        return Gson().toJson(genre_ids,type)
    }

    @TypeConverter
    fun toListInt(jString:String):List<Int>{
        val type = object: TypeToken<List<Int>>() {}.type
        return Gson().fromJson(jString,type)
    }



}
