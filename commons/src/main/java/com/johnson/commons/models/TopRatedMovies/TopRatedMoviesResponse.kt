package com.johnson.commons.models.TopRatedMovies

import com.johnson.commons.models.Result

data class TopRatedMoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)