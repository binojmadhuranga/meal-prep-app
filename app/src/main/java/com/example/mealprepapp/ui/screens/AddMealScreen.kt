package com.example.mealprepapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mealprepapp.data.local.MealEntity
import com.example.mealprepapp.viewmodel.MealViewModel

@Composable
fun AddMealScreen(
    navController: NavController,
    mealViewModel: MealViewModel
) {
    var mealName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }
    var ingredient1 by remember { mutableStateOf("") }
    var ingredient2 by remember { mutableStateOf("") }
    var ingredient3 by remember { mutableStateOf("") }
    var ingredient4 by remember { mutableStateOf("") }
    var ingredient5 by remember { mutableStateOf("") }
    var measure1 by remember { mutableStateOf("") }
    var measure2 by remember { mutableStateOf("") }
    var measure3 by remember { mutableStateOf("") }
    var measure4 by remember { mutableStateOf("") }
    var measure5 by remember { mutableStateOf("") }

    val isFormValid = mealName.isNotBlank() && category.isNotBlank() && area.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Add Meal",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = mealName,
            onValueChange = { mealName = it },
            label = { Text("Meal Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = area,
            onValueChange = { area = it },
            label = { Text("Area") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = instructions,
            onValueChange = { instructions = it },
            label = { Text("Instructions") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = ingredient1,
            onValueChange = { ingredient1 = it },
            label = { Text("Ingredient 1") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = ingredient2,
            onValueChange = { ingredient2 = it },
            label = { Text("Ingredient 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = ingredient3,
            onValueChange = { ingredient3 = it },
            label = { Text("Ingredient 3") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = ingredient4,
            onValueChange = { ingredient4 = it },
            label = { Text("Ingredient 4") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = ingredient5,
            onValueChange = { ingredient5 = it },
            label = { Text("Ingredient 5") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = measure1,
            onValueChange = { measure1 = it },
            label = { Text("Measure 1") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = measure2,
            onValueChange = { measure2 = it },
            label = { Text("Measure 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = measure3,
            onValueChange = { measure3 = it },
            label = { Text("Measure 3") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = measure4,
            onValueChange = { measure4 = it },
            label = { Text("Measure 4") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = measure5,
            onValueChange = { measure5 = it },
            label = { Text("Measure 5") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newMeal = MealEntity(
                    idMeal = System.currentTimeMillis().toString(),
                    meal = mealName,
                    drinkAlternate = null,
                    category = category,
                    area = area,
                    instructions = if (instructions.isBlank()) "No instructions provided" else instructions,
                    tags = null,
                    youtube = "",
                    thumbnail = "",
                    ingredient1 = ingredient1.ifBlank { null },
                    ingredient2 = ingredient2.ifBlank { null },
                    ingredient3 = ingredient3.ifBlank { null },
                    ingredient4 = ingredient4.ifBlank { null },
                    ingredient5 = ingredient5.ifBlank { null },
                    measure1 = measure1.ifBlank { null },
                    measure2 = measure2.ifBlank { null },
                    measure3 = measure3.ifBlank { null },
                    measure4 = measure4.ifBlank { null },
                    measure5 = measure5.ifBlank { null }
                )

                mealViewModel.saveCustomMeal(newMeal) {
                    navController.popBackStack()
                }
            },
            enabled = isFormValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save to DB")
        }
    }
}

