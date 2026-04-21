package com.example.mealprepapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mealprepapp.viewmodel.MealViewModel

@Composable
fun MealSearchScreen(
    navController: NavController,
    mealViewModel: MealViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Meal Search Screen")
    }
}