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
fun WebSearchScreen(
    navController: NavController,
    mealViewModel: MealViewModel
) {
    var mealNameQuery by remember { mutableStateOf("") }
    val webMeals = mealViewModel.webMeals

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Search Meals From Web",
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
                mealViewModel.searchMealsFromWeb(mealNameQuery)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !mealViewModel.isWebSearchLoading
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (mealViewModel.isWebSearchLoading) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(16.dp))
        }

        mealViewModel.webSearchError?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        LazyColumn {
            items(webMeals) { meal ->
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
                    }
                }
            }
        }
    }
}