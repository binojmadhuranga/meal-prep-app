package com.example.mealprepapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

	@GET("search.php")
	suspend fun searchMealsByName(@Query("s") mealName: String): MealApiResponse

	companion object {
		val api: MealApiService by lazy {
			retrofit2.Retrofit.Builder()
				.baseUrl("https://www.themealdb.com/api/json/v1/1/")
				.addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
				.build()
				.create(MealApiService::class.java)
		}
	}
}