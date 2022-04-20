package com.johnson.remote.repository

import com.johnson.commons.models.Trending.TrendingResponse
import com.johnson.commons.utils.NetworkResource
import com.johnson.remote.api.RestService
import retrofit2.Response

class MoviesRepositoryImpl(private val restService: RestService):BaseRepository(),MoviesRepository {

    override suspend fun getTrendingMovies(
        mediaType: String,
        timeWindow: String,
        apiKey: String,
        language: String?
    ): NetworkResource<Response<TrendingResponse>> {
        return safeApiCall {
            restService.fetchTrendingMovies(mediaType,timeWindow,apiKey,language )
        }
    }
}