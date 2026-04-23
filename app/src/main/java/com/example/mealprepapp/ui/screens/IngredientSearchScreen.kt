package com.example.mealprepapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mealprepapp.viewmodel.MealViewModel

@Composable
fun IngredientSearchScreen(
    navController: NavController,
    mealViewModel: MealViewModel
) {
    var ingredient by remember { mutableStateOf("") }

    val meals = mealViewModel.meals

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Search Meals By Ingredient",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = ingredient,
            onValueChange = { ingredient = it },
            label = { Text("Enter Ingredient") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                mealViewModel.searchMealsByIngredient(ingredient)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Retrieve Meals")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                mealViewModel.saveMealsToDatabase()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Meals to Database")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(meals) { meal ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text("Meal: ${meal.meal}")
                        Text("Category: ${meal.category}")
                        Text("Area: ${meal.area}")
                        Text("Ingredient1: ${meal.ingredient1}")
                        Text("Ingredient2: ${meal.ingredient2}")
                        Text("Measure1: ${meal.measure1}")
                        Text("Measure2: ${meal.measure2}")
                    }
                }
            }
        }
    }
}