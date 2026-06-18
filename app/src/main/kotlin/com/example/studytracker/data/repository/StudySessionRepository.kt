package com.example.studytracker.data.repository

import com.example.studytracker.data.dao.StudySessionDao
import com.example.studytracker.data.entity.StudySession
import kotlinx.coroutines.flow.Flow

class StudySessionRepository(private val studySessionDao: StudySessionDao) {
    fun getAllStudySessions(): Flow<List<StudySession>> = studySessionDao.getAllStudySessions()

    suspend fun insertStudySession(studySession: StudySession) {
        studySessionDao.insertStudySession(studySession)
    }

    suspend fun deleteStudySession(studySession: StudySession) {
        studySessionDao.deleteStudySession(studySession)
    }

    suspend fun getStudySessionById(id: Int): StudySession? {
        return studySessionDao.getStudySessionById(id)
    }

    fun getTotalStudyMinutes(): Flow<Int?> = studySessionDao.getTotalStudyMinutes()
}
