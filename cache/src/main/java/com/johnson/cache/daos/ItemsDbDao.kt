package com.johnson.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.johnson.cache.models.ResultEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDbDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertMovie(itemEntity: List<ResultEntity>)
//
//
//    @Query("SELECT * FROM trending_movies_table")
//    fun getAllMovies(): Flow<List<ResultEntity>>


}
