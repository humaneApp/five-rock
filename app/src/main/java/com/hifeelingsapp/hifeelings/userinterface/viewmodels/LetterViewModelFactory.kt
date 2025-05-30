package com.hifeelingsapp.hifeelings.userinterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hifeelingsapp.hifeelings.data.repository.LetterRepository

class LetterViewModelFactory(
    private val repository: LetterRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LetterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LetterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
