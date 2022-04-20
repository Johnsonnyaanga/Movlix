package com.johnson.remote.usecases

import com.johnson.commons.models.Trending.TrendingResponse
import com.johnson.commons.utils.NetworkResource
import com.johnson.remote.repository.MoviesRepository
import retrofit2.Response

class MoviesUseCase(private val repository: MoviesRepository) {
    suspend operator fun invoke(
        mediaType: String,
        timeWindow: String,
        apiKey: String,
        language: String?
    ): NetworkResource<Response<TrendingResponse>> {
        return repository.getTrendingMovies(mediaType, timeWindow, apiKey, language)
    }
}