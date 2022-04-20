package com.johnson.commons.models.PopularMovies

import com.johnson.commons.models.Result

data class PopularMovieResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)