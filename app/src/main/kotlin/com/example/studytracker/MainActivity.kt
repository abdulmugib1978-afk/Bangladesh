package com.example.studytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.studytracker.data.database.StudyTrackerDatabase
import com.example.studytracker.data.repository.StudySessionRepository
import com.example.studytracker.presentation.ui.screen.StudyTrackerScreen
import com.example.studytracker.presentation.ui.theme.StudyTrackerTheme
import com.example.studytracker.presentation.viewmodel.StudyTrackerViewModel
import com.example.studytracker.presentation.viewmodel.StudyTrackerViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize database and repository
        val database = StudyTrackerDatabase.getDatabase(this)
        val repository = StudySessionRepository(database.studySessionDao())
        val viewModelFactory = StudyTrackerViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(StudyTrackerViewModel::class.java)

        setContent {
            StudyTrackerTheme {
                StudyTrackerScreen(viewModel)
            }
        }
    }
}
