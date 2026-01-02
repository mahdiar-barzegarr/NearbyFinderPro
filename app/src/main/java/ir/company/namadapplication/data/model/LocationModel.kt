package ir.company.namadapplication.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class LocationModel(
    val id: Int,
    val name: String,
    @DrawableRes val iconRes: Int,
    val color: Color
)
