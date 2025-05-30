package com.hifeelingsapp.hifeelings.userinterface.components

import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hifeelingsapp.hifeelings.ui.theme.NoIndication
import com.hifeelingsapp.hifeelings.userinterface.components.BottomNavItem

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    currentRoute: String,
    onItemSelected: (String) -> Unit
) {
    NavigationBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 0.dp,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label, style = MaterialTheme.typography.labelMedium) },
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route)},
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary,
                    indicatorColor = MaterialTheme.colorScheme.background // This can remove pill highlight
                )

            )
        }
    }
}
