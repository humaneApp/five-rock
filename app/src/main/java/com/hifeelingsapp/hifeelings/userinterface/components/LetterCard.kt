package com.hifeelingsapp.hifeelings.userinterface.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hifeelingsapp.hifeelings.data.remote.dto.Letter

@Composable
fun LetterCard(letter: Letter) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Card(
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .padding(16.dp)
            .width(screenWidth * 0.8f)
            .height(screenHeight * 0.8f),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("by ${letter.from_person}", style = MaterialTheme.typography.labelMedium, maxLines = 1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(letter.header, style = MaterialTheme.typography.titleMedium, maxLines = 2)
            Spacer(modifier = Modifier.height(8.dp))
            Text(letter.created_at, style = MaterialTheme.typography.bodyMedium, maxLines = 5)
        }
    }
    Log.d("ThemeCheck", "Current surface color: ${MaterialTheme.colorScheme.surface}")
}

//@Preview(showBackground = true)
//@Composable
//fun Previewcard() {
//    val letter: Letter = Letter(1,"1","1","1","1","1","1")
//
//    LetterCard(letter)
//
//}
//var author by remember { mutableStateOf("") }
//var title by remember { mutableStateOf("") }
//var content by remember { mutableStateOf("") }
//LetterEditor(
//author = author,
//title = title,
//content = content,
//onAuthorChange = { author = it },
//onTitleChange = { title = it },
//onContentChange = { content = it },
//onSend = { /* handle send */ },
//onArchive = { /* handle archive */ }
//)