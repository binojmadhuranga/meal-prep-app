package com.example.mealprepapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                navController.navigate("addMeal")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Meals to DB")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("ingredientSearch")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search for Meals By Ingredient")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("mealSearch")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search for Meals")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("webSearch")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search Meals From Web")
        }
    }
}