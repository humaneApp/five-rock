package com.hifeelingsapp.hifeelings.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "letters")
data class LetterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val author: String,
    val title: String,
    val content: String
)
