package com.hifeelingsapp.hifeelings.data.local

import androidx.room.*
import com.hifeelingsapp.hifeelings.data.local.entities.LetterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LetterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLetter(letter: LetterEntity)

    @Query("SELECT * FROM letters")
    fun getAllLetters(): Flow<List<LetterEntity>>

    @Delete
    suspend fun deleteLetter(letter: LetterEntity)

    @Query("DELETE FROM letters")
    suspend fun clearAll()
}
