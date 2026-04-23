package com.example.mealprepapp.repository

import com.example.mealprepapp.data.local.MealDao
import com.example.mealprepapp.data.local.MealEntity
import com.example.mealprepapp.data.remote.MealApiService

class MealRepository(private val mealDao: MealDao) {

    private val mealApiService = MealApiService.api

    suspend fun insertMeal(meal: MealEntity) {
        mealDao.insertMeal(meal)
    }

    suspend fun insertMeals(meals: List<MealEntity>) {
        mealDao.insertMeals(meals)
    }

    suspend fun getAllMeals(): List<MealEntity> {
        return mealDao.getAllMeals()
    }

    suspend fun searchMealsByName(query: String): List<MealEntity> {
        return mealDao.searchMealsByName(query)
    }

    suspend fun searchMeals(query: String): List<MealEntity> {
        return mealDao.searchMeals(query)
    }

    suspend fun searchMealsFromWeb(mealName: String): List<MealEntity> {
        val response = mealApiService.searchMealsByName(mealName)

        return response.meals.orEmpty().map { meal ->
            MealEntity(
                idMeal = meal.idMeal,
                meal = meal.strMeal,
                drinkAlternate = null,
                category = meal.strCategory.orEmpty(),
                area = meal.strArea.orEmpty(),
                instructions = meal.strInstructions.orEmpty(),
                tags = null,
                youtube = "",
                thumbnail = "",
                ingredient1 = null,
                ingredient2 = null,
                ingredient3 = null,
                ingredient4 = null,
                ingredient5 = null,
                measure1 = null,
                measure2 = null,
                measure3 = null,
                measure4 = null,
                measure5 = null
            )
        }
    }
}
