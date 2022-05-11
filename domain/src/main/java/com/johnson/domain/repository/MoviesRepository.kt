package com.johnson.domain.repository

import com.johnson.domain.models.Actors.Actors
import com.johnson.domain.models.TrendingResponse
import com.johnson.domain.utils.NetworkResource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface  MoviesRepository {
    suspend fun getTrendingMovies(
        mediaType: String,
        timeWindow: String,
        apiKey: String,
        language: String?
    ): NetworkResource<Response<TrendingResponse>>

    suspend fun fetchMovieActors(
         movieId: Int,
         apiKey: String,
         language: String?
    ): NetworkResource<Response<Actors>>



}