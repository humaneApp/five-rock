package com.hifeelingsapp.hifeelings.data.remote

import com.hifeelingsapp.hifeelings.data.remote.api.LetterApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "http://34.68.80.127:11001/"

    private const val TOKEN = "Bearer " // Use the exact token Postman used

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", TOKEN)
                .header("Content-Type", "application/json")
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        }
        .build()

    val api: LetterApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LetterApiService::class.java)
    }
}