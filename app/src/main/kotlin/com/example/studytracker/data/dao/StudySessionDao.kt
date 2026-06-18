package com.example.studytracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.studytracker.data.entity.StudySession
import kotlinx.coroutines.flow.Flow

@Dao
interface StudySessionDao {
    @Insert
    suspend fun insertStudySession(studySession: StudySession)

    @Delete
    suspend fun deleteStudySession(studySession: StudySession)

    @Query("SELECT * FROM study_sessions ORDER BY timestamp DESC")
    fun getAllStudySessions(): Flow<List<StudySession>>

    @Query("SELECT * FROM study_sessions WHERE id = :id")
    suspend fun getStudySessionById(id: Int): StudySession?

    @Query("SELECT SUM(durationInMinutes) FROM study_sessions")
    fun getTotalStudyMinutes(): Flow<Int?>
}
