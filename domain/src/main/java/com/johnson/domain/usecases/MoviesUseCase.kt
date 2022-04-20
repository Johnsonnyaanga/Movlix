package com.johnson.domain.usecases

import com.johnson.domain.models.TrendingResponse
import com.johnson.domain.repository.MoviesRepository
import com.johnson.domain.utils.NetworkResource
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