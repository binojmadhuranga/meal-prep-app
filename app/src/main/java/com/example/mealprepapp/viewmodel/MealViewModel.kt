package com.example.mealprepapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mealprepapp.data.local.MealEntity

class MealViewModel : ViewModel() {

    var meals by mutableStateOf(listOf<MealEntity>())
        private set

    fun searchMealsByIngredient(query: String) {
        meals = listOf(
            MealEntity(
                idMeal = "1",
                meal = "Chicken Curry",
                drinkAlternate = null,
                category = "Chicken",
                area = "Indian",
                instructions = "Cook chicken",
                tags = "Spicy",
                youtube = "",
                thumbnail = "",
                ingredient1 = "Chicken",
                ingredient2 = "Salt",
                ingredient3 = "",
                ingredient4 = "",
                ingredient5 = "",
                measure1 = "500g",
                measure2 = "1 tsp",
                measure3 = "",
                measure4 = "",
                measure5 = ""
            )
        )
    }

    fun saveMealsToDatabase() {
        // Room save later
    }
}