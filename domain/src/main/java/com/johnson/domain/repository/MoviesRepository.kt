package com.johnson.domain.repository

import com.johnson.domain.models.TrendingResponse
import com.johnson.domain.utils.NetworkResource
import retrofit2.Response


interface  MoviesRepository {
    suspend fun getTrendingMovies(
        mediaType: String,
        timeWindow: String,
        apiKey: String,
        language: String?
    ): NetworkResource<Response<TrendingResponse>>

}