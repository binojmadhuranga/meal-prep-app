package com.example.mealprepapp.data.remote

data class MealApiResponse(
    val meals: List<MealApiDto>?
)

data class MealApiDto(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String?,
    val strArea: String?,
    val strInstructions: String?
)


