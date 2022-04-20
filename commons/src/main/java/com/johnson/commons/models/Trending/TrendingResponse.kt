package com.johnson.commons.models.Trending

import com.johnson.commons.models.Result

data class TrendingResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)