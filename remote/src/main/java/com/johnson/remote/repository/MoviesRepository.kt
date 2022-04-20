package com.johnson.remote.repository

import com.johnson.commons.models.Trending.TrendingResponse
import com.johnson.commons.utils.NetworkResource
import retrofit2.Response

interface  MoviesRepository {
    suspend fun getTrendingMovies(
        mediaType: String,
        timeWindow: String,
        apiKey: String,
        language: String?
    ):NetworkResource<Response<TrendingResponse>>

}