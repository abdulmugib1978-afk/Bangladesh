package com.example.studytracker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studytracker.data.repository.StudySessionRepository

class StudyTrackerViewModelFactory(
    private val repository: StudySessionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(StudyTrackerViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                StudyTrackerViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
