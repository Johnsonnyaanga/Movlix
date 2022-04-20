package com.johnson.remote.repository

import com.johnson.domain.models.TrendingResponse
import com.johnson.domain.repository.MoviesRepository
import com.johnson.domain.utils.NetworkResource
import com.johnson.remote.api.RestService
import retrofit2.Response


class MoviesRepositoryImpl(private val restService: RestService):BaseRepository(),
    MoviesRepository {

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