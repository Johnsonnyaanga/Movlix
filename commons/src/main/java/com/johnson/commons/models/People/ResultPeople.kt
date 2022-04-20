package com.johnson.commons.models.People

import com.johnson.commons.models.People.KnownFor

data class ResultPeople(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownFor>,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
)