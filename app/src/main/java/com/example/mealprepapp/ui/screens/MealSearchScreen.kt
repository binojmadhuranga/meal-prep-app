package com.example.mealprepapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mealprepapp.viewmodel.MealViewModel

@Composable
fun MealSearchScreen(
    navController: NavController,
    mealViewModel: MealViewModel
) {
    var mealNameQuery by remember { mutableStateOf("") }
    val meals = mealViewModel.meals

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Search Meals By Name",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = mealNameQuery,
            onValueChange = { mealNameQuery = it },
            label = { Text("Enter Meal Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                mealViewModel.searchMealsByName(mealNameQuery)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(meals) { meal ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Meal: ${meal.meal}")
                        Text("Category: ${meal.category}")
                        Text("Area: ${meal.area}")
                        Text("Instructions: ${meal.instructions}")

                        if (!meal.drinkAlternate.isNullOrBlank()) {
                            Text("Drink Alternate: ${meal.drinkAlternate}")
                        }

                        if (!meal.tags.isNullOrBlank()) {
                            Text("Tags: ${meal.tags}")
                        }

                        if (meal.youtube.isNotBlank()) {
                            Text("YouTube: ${meal.youtube}")
                        }

                        if (meal.thumbnail.isNotBlank()) {
                            Text("Thumbnail: ${meal.thumbnail}")
                        }

                        if (!meal.ingredient1.isNullOrBlank()) Text("Ingredient 1: ${meal.ingredient1}")
                        if (!meal.measure1.isNullOrBlank()) Text("Measure 1: ${meal.measure1}")

                        if (!meal.ingredient2.isNullOrBlank()) Text("Ingredient 2: ${meal.ingredient2}")
                        if (!meal.measure2.isNullOrBlank()) Text("Measure 2: ${meal.measure2}")

                        if (!meal.ingredient3.isNullOrBlank()) Text("Ingredient 3: ${meal.ingredient3}")
                        if (!meal.measure3.isNullOrBlank()) Text("Measure 3: ${meal.measure3}")

                        if (!meal.ingredient4.isNullOrBlank()) Text("Ingredient 4: ${meal.ingredient4}")
                        if (!meal.measure4.isNullOrBlank()) Text("Measure 4: ${meal.measure4}")

                        if (!meal.ingredient5.isNullOrBlank()) Text("Ingredient 5: ${meal.ingredient5}")
                        if (!meal.measure5.isNullOrBlank()) Text("Measure 5: ${meal.measure5}")
                    }
                }
            }
        }
    }
}