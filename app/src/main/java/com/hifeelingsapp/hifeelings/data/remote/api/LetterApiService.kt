package com.hifeelingsapp.hifeelings.data.remote.api

import com.hifeelingsapp.hifeelings.data.remote.dto.LetterResponse
import retrofit2.http.GET

interface LetterApiService {
    @GET("letters") // This hits http://{{IPAddress}}:11001/letters
    suspend fun getReceivedLetters(): LetterResponse

}