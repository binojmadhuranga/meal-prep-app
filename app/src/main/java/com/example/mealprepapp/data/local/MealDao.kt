package com.example.mealprepapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: MealEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeals(meals: List<MealEntity>)

    @Query("SELECT * FROM meals")
    suspend fun getAllMeals(): List<MealEntity>

    @Query("SELECT * FROM meals WHERE LOWER(meal) LIKE '%' || LOWER(:query) || '%'")
    suspend fun searchMealsByName(query: String): List<MealEntity>

    @Query("""
        SELECT * FROM meals
        WHERE LOWER(meal) LIKE '%' || LOWER(:query) || '%'
        OR LOWER(ingredient1) LIKE '%' || LOWER(:query) || '%'
        OR LOWER(ingredient2) LIKE '%' || LOWER(:query) || '%'
    """)
    suspend fun searchMeals(query: String): List<MealEntity>
}