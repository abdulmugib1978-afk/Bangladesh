package com.example.studytracker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studytracker.data.entity.StudySession
import com.example.studytracker.data.repository.StudySessionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class StudyTrackerUiState(
    val studySessions: List<StudySession> = emptyList(),
    val totalMinutes: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null
)

class StudyTrackerViewModel(private val repository: StudySessionRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(StudyTrackerUiState())
    val uiState: StateFlow<StudyTrackerUiState> = _uiState.asStateFlow()

    init {
        loadStudySessions()
        loadTotalMinutes()
    }

    private fun loadStudySessions() {
        viewModelScope.launch {
            repository.getAllStudySessions().collect { sessions ->
                _uiState.value = _uiState.value.copy(studySessions = sessions)
            }
        }
    }

    private fun loadTotalMinutes() {
        viewModelScope.launch {
            repository.getTotalStudyMinutes().collect { total ->
                _uiState.value = _uiState.value.copy(totalMinutes = total ?: 0)
            }
        }
    }

    fun addStudySession(subjectName: String, durationInMinutes: Int) {
        if (subjectName.isBlank() || durationInMinutes <= 0) {
            _uiState.value = _uiState.value.copy(error = "Invalid input")
            return
        }
        viewModelScope.launch {
            try {
                val newSession = StudySession(
                    subjectName = subjectName,
                    durationInMinutes = durationInMinutes
                )
                repository.insertStudySession(newSession)
                _uiState.value = _uiState.value.copy(error = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }

    fun deleteStudySession(studySession: StudySession) {
        viewModelScope.launch {
            try {
                repository.deleteStudySession(studySession)
                _uiState.value = _uiState.value.copy(error = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
