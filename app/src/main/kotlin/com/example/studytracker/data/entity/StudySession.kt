package com.example.studytracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study_sessions")
data class StudySession(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val subjectName: String,
    val durationInMinutes: Int,
    val timestamp: Long = System.currentTimeMillis()
)
