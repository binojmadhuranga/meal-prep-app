package com.example.mealprepapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealprepapp.data.local.MealEntity
import com.example.mealprepapp.data.local.SeedMeals
import com.example.mealprepapp.repository.MealRepository
import kotlinx.coroutines.launch

class MealViewModel(private val repository: MealRepository) : ViewModel() {

    var meals by mutableStateOf(listOf<MealEntity>())
        private set

    fun searchMealsByIngredient(query: String) {
        viewModelScope.launch {
            meals = if (query.isBlank()) {
                repository.getAllMeals()
            } else {
                repository.searchMeals(query)
            }
        }
    }

    fun saveMealsToDatabase() {
        viewModelScope.launch {
            repository.insertMeals(SeedMeals.items)
            meals = repository.getAllMeals()
        }
    }

    fun saveCustomMeal(meal: MealEntity, onSaved: () -> Unit = {}) {
        viewModelScope.launch {
            repository.insertMeal(meal)
            meals = repository.getAllMeals()
            onSaved()
        }
    }
}