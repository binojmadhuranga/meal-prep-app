package com.example.mealprepapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.mealprepapp.ui.screens.HomeScreen
import com.example.mealprepapp.ui.screens.IngredientSearchScreen
import com.example.mealprepapp.ui.screens.MealSearchScreen
import com.example.mealprepapp.ui.screens.WebSearchScreen
import com.example.mealprepapp.ui.theme.MealPrepAppTheme
import com.example.mealprepapp.viewmodel.MealViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MealPrepAppTheme {

                val navController = rememberNavController()
                val mealViewModel: MealViewModel = viewModel()

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