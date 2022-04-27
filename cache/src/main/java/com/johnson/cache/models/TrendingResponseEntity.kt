package com.johnson.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "trending_movies_table")
data class TrendingResponseEntity(
    val page: Int,
    val results: List<ResultEntity>,
    val total_pages: Int,
    val total_results: Int,
    @PrimaryKey
    val cacheID:Int
)