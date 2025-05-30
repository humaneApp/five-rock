package com.hifeelingsapp.hifeelings.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class FilterChipItem(
    val label: String,
    val backgroundColor: Color? = null,
    val selectedBackgroundColor: Color? = null,
    val textColor: Color? = null,
    val selectedTextColor: Color? = null,
    val icon: ImageVector? = null,
    val borderColor: Color? = null,      // add this
    val borderWidth: Dp = 1.dp
)
