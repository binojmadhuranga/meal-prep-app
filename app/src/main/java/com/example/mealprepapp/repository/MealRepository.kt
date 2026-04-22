package com.example.mealprepapp.repository

import com.example.mealprepapp.data.local.MealDao
import com.example.mealprepapp.data.local.MealEntity

class MealRepository(private val mealDao: MealDao) {

    suspend fun insertMeal(meal: MealEntity) {
        mealDao.insertMeal(meal)
    }

    suspend fun insertMeals(meals: List<MealEntity>) {
        mealDao.insertMeals(meals)
    }

    suspend fun getAllMeals(): List<MealEntity> {
        return mealDao.getAllMeals()
    }

    suspend fun searchMeals(query: String): List<MealEntity> {
        return mealDao.searchMeals(query)
    }
}
