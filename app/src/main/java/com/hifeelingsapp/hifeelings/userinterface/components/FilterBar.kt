package com.hifeelingsapp.hifeelings.userinterface.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.hifeelingsapp.hifeelings.models.FilterChipItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBar(
    filters: List<FilterChipItem>,
    selectedLabel: String,
    onFilterSelected: (String) -> Unit
) {
    LazyRow(modifier = Modifier.padding(horizontal = 16.dp)) {
        items(filters.size) { index ->
            val item = filters[index]
            val isSelected = item.label == selectedLabel

            val colors = FilterChipDefaults.filterChipColors(
                containerColor = item.backgroundColor ?: MaterialTheme.colorScheme.surfaceVariant,
                selectedContainerColor = item.selectedBackgroundColor ?: MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                labelColor = item.textColor ?: MaterialTheme.colorScheme.onSurface,
                selectedLabelColor = item.selectedTextColor ?: MaterialTheme.colorScheme.onPrimary
            )

            FilterChip(
                selected = isSelected,
                onClick = { onFilterSelected(item.label) },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                },
                leadingIcon = item.icon?.let {
                    {
                        Icon(imageVector = it, contentDescription = null)
                    }
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .defaultMinSize(minHeight = 32.dp)
                    .then(
                        if (item.borderColor != null)
                            Modifier.border(
                                width = item.borderWidth,
                                brush = SolidColor(item.borderColor),
                                shape = RoundedCornerShape(20.dp)
                            )
                        else Modifier
                    ),
                colors = colors
            )
        }
    }
}




