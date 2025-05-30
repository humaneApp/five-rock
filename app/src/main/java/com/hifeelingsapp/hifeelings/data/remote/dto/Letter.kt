package com.hifeelingsapp.hifeelings.data.remote.dto

data class Letter(
    val card_id: Long,
    val card_text:String,
    val header: String,
    val mood_tags: List<String>?,
    val person_tags: List<String>?, // nullable and could be a list, assuming same format
    val created_at: String,
    val updated_at: String,
    val note: String?,
    val from_person: String,
    val to_person: String,
    val scheduled_date: String?,
    val type: String,
    val letter_id: Int,
    val link: String?,
    val letter_created_at: String,
    val local_id: String,
    val locked: Boolean,
    val memory: Boolean,
    val archived: Boolean
)