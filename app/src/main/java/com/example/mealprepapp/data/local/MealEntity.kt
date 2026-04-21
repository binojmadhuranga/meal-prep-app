package com.example.mealprepapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey
    val idMeal: String,

    val meal: String,
    val drinkAlternate: String?,
    val category: String,
    val area: String,
    val instructions: String,
    val tags: String?,
    val youtube: String,
    val thumbnail: String,

    val ingredient1: String?,
    val ingredient2: String?,
    val ingredient3: String?,
    val ingredient4: String?,
    val ingredient5: String?,

    val measure1: String?,
    val measure2: String?,
    val measure3: String?,
    val measure4: String?,
    val measure5: String?
)