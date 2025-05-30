package com.hifeelingsapp.hifeelings.userinterface.components

import androidx.compose.foundation.background
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun LetterEditor(
    author: String,
    title: String,
    content: String,
    onAuthorChange: (String) -> Unit,
    onTitleChange: (String) -> Unit,
    onContentChange: (String) -> Unit,
    onSend: () -> Unit,
    onArchive: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .height(screenHeight * 0.8f),
            shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LetterEditorTextField(value = author, onValueChange = onAuthorChange, hint = "Author")
            LetterEditorTextField(value = title, onValueChange = onTitleChange, hint = "Title")
            LetterEditorTextField(
                value = content,
                onValueChange = onContentChange,
                hint = "Content",
                modifier = Modifier
                    .height(150.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Button(onClick = onSend) {
                    Text("Send", style = MaterialTheme.typography.labelLarge)
                }
                Button(onClick = onArchive) {
                    Text("Archive", style = MaterialTheme.typography.labelLarge)
                }
            }

        }
    }
}

@Composable
fun LetterEditorTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier
) {
    val textColor = MaterialTheme.colorScheme.onSurface
    val hintColor = MaterialTheme.colorScheme.onSurfaceVariant

    Column(modifier = modifier.padding(vertical = 4.dp)) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurface),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            decorationBox = { innerTextField ->
                Box(Modifier.padding(8.dp)) {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            style = MaterialTheme.typography.bodyLarge.copy(color = hintColor)
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}

