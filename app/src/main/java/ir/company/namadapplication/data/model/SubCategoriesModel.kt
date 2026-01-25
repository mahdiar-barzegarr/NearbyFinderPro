package ir.company.namadapplication.data.model

import androidx.compose.ui.graphics.Color

data class SubCategoriesModel(
    val title: String,
    val apiCategory: String, // 👈 این
    val icon: Int,
    val color: Color
)