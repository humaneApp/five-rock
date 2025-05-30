package com.hifeelingsapp.hifeelings.userinterface.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hifeelingsapp.hifeelings.models.FilterChipItem
import com.hifeelingsapp.hifeelings.data.repository.LetterRepository
import com.hifeelingsapp.hifeelings.data.local.entities.LetterEntity
import com.hifeelingsapp.hifeelings.data.remote.dto.Letter
import com.hifeelingsapp.hifeelings.data.remote.dto.LetterResponse
import kotlinx.coroutines.launch

class LetterViewModel(private val repository: LetterRepository) : ViewModel() {

    var selectedFilter by mutableStateOf("Received")
        private set

    var author by mutableStateOf("")
    var title by mutableStateOf("")
    var content by mutableStateOf("")

    val filters: List<FilterChipItem> = repository.getFilters()

    var letters by mutableStateOf<List<Letter>>(emptyList())
        private set

    init {
        fetchLettersForFilter(selectedFilter)
    }

    fun onFilterSelected(label: String) {
        selectedFilter = label
        fetchLettersForFilter(label)
    }

    private fun fetchLettersForFilter(filter: String) {
        viewModelScope.launch {

            try {
                val receivedLetters = repository.getReceivedLettersRemote()
                letters = receivedLetters
            } catch (e: Exception) {
                println("Error fetching letters: ${e.message}")
                letters = emptyList()
            }
        }
    }

    fun onAuthorChange(newAuthor: String) {
        author = newAuthor
    }

    fun onTitleChange(newTitle: String) {
        title = newTitle
    }

    fun onContentChange(newContent: String) {
        content = newContent
    }

    fun sendLetter() {
        // TODO: Implement sending logic
    }

    fun archiveLetter() {
        if (author.isBlank() || title.isBlank() || content.isBlank()) {
            println("Validation Error: Author, Title, and Content cannot be blank for archiving.")
            return
        }

        val letterToArchive = LetterEntity(
            author = author,
            title = title,
            content = content
        )

        viewModelScope.launch {
            repository.archiveLetter(letterToArchive)}}}