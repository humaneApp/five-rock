package com.hifeelingsapp.hifeelings.userinterface.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hifeelingsapp.hifeelings.MainScreen
import com.hifeelingsapp.hifeelings.data.repository.LetterRepository
import com.hifeelingsapp.hifeelings.data.local.AppDatabase
import com.hifeelingsapp.hifeelings.ui.theme.HiFeelingsTheme
import com.hifeelingsapp.hifeelings.userinterface.components.*
import com.hifeelingsapp.hifeelings.userinterface.viewmodels.LetterViewModel
import com.hifeelingsapp.hifeelings.userinterface.viewmodels.LetterViewModelFactory

@Composable
fun LetterScreen() {
    val context = LocalContext.current

    val letterDao = remember { AppDatabase.getDatabase(context).letterDao() }
    val letterRepository = remember { LetterRepository(letterDao) }

    val viewModel: LetterViewModel = viewModel(
        factory = LetterViewModelFactory(letterRepository)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp)) {

        FilterBar(
            filters = viewModel.filters,
            selectedLabel = viewModel.selectedFilter,
            onFilterSelected = viewModel::onFilterSelected
        )

        Spacer(modifier = Modifier.height(12.dp))

        when (viewModel.selectedFilter) {
            "Received" -> {
                LazyRow(modifier = Modifier.fillMaxSize())  {
                    items(viewModel.letters.size) { index ->
                        LetterCard(letter = viewModel.letters[index])
                    }
                }
            }

            "Write a Letter" -> {
                Text(
                    "Will be launched soon",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )

                // You can uncomment the below when the editor is ready
                /*
                LetterEditor(
                    author = viewModel.author,
                    title = viewModel.title,
                    content = viewModel.content,
                    onAuthorChange = viewModel::onAuthorChange,
                    onTitleChange = viewModel::onTitleChange,
                    onContentChange = viewModel::onContentChange,
                    onSend = viewModel::sendLetter
                )
                */
            }

            else -> {
                Text(
                    "Search Option Soon.....",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(
    name = "Default Device Preview",
    showBackground = true
)
@Composable
fun PreviewDefault() {
    HiFeelingsTheme {
        MainScreen()
    }
}

@Preview(
    name = "Compact 412x917 Preview",
    showBackground = true,
    widthDp = 412,
    heightDp = 917
)
@Composable
fun PreviewCompact() {
    HiFeelingsTheme {
        MainScreen()
    }
}

