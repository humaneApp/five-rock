package com.hifeelingsapp.hifeelings.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.hifeelingsapp.hifeelings.data.remote.dto.Letter

data class LetterResponse(
    @SerializedName("payload") val letters: List<Letter>,
    val success: Boolean,
    val error: String
)