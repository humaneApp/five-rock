package com.hifeelingsapp.hifeelings.data.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.Color
import com.hifeelingsapp.hifeelings.data.local.LetterDao
import com.hifeelingsapp.hifeelings.data.local.entities.LetterEntity
import com.hifeelingsapp.hifeelings.models.FilterChipItem
import com.hifeelingsapp.hifeelings.data.remote.dto.Letter
import com.hifeelingsapp.hifeelings.data.remote.RetrofitInstance

class LetterRepository(private val letterDao: LetterDao) {

    suspend fun getReceivedLettersRemote(): List<Letter> {
        val response = RetrofitInstance.api.getReceivedLetters()
        if (response.success) {
            return response.letters
        } else {
            // handle error if needed (e.g., throw exception or return emptyList)
            return emptyList()
        }

    }


    fun getFilters(): List<FilterChipItem> = listOf(
        FilterChipItem("Received"),
        FilterChipItem(
            "Write a Letter",
            backgroundColor = Color.Companion.Black,
            selectedBackgroundColor = Color.Companion.Black,
            textColor = Color.Companion.White,
            selectedTextColor = Color.Companion.White
        ),
        FilterChipItem("Search", icon = Icons.Default.Search)
    )

    suspend fun archiveLetter(letter: LetterEntity) {
        letterDao.insertLetter(letter)
    }

//    fun getSampleLetters(): List<Letter> = listOf(
//        Letter("Alex", "First Letter", "Lorem ipsum..."),
//        Letter("Sam", "Another Letter", "Dolor sit amet...")
//    )
}