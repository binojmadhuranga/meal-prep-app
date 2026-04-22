package com.example.mealprepapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.mealprepapp.data.local.MealDatabase
import com.example.mealprepapp.repository.MealRepository
import com.example.mealprepapp.ui.screens.AddMealScreen
import com.example.mealprepapp.ui.screens.HomeScreen
import com.example.mealprepapp.ui.screens.IngredientSearchScreen
import com.example.mealprepapp.ui.screens.MealSearchScreen
import com.example.mealprepapp.ui.screens.WebSearchScreen
import com.example.mealprepapp.ui.theme.MealPrepAppTheme
import com.example.mealprepapp.viewmodel.MealViewModel
import com.example.mealprepapp.viewmodel.MealViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MealPrepAppTheme {
                val database = remember { MealDatabase.getDatabase(applicationContext) }
                val repository = remember { MealRepository(database.mealDao()) }
                val mealViewModelFactory = remember { MealViewModelFactory(repository) }

                val navController = rememberNavController()
                val mealViewModel: MealViewModel = viewModel(factory = mealViewModelFactory)

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {

                        composable("home") {
                            HomeScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }

                        composable("addMeal") {
                            AddMealScreen(
                                navController = navController,
                                mealViewModel = mealViewModel
                            )
                        }

                        composable("ingredientSearch") {
                            IngredientSearchScreen(
                                navController = navController,
                                mealViewModel = mealViewModel
                            )
                        }

                        composable("mealSearch") {
                            MealSearchScreen(
                                navController = navController,
                                mealViewModel = mealViewModel
                            )
                        }

                        composable("webSearch") {
                            WebSearchScreen(
                                navController = navController,
                                mealViewModel = mealViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}