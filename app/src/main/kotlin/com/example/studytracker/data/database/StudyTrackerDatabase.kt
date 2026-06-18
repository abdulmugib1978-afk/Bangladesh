package com.example.studytracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studytracker.data.dao.StudySessionDao
import com.example.studytracker.data.entity.StudySession

@Database(entities = [StudySession::class], version = 1, exportSchema = false)
abstract class StudyTrackerDatabase : RoomDatabase() {
    abstract fun studySessionDao(): StudySessionDao

    companion object {
        @Volatile
        private var INSTANCE: StudyTrackerDatabase? = null

        fun getDatabase(context: Context): StudyTrackerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudyTrackerDatabase::class.java,
                    "study_tracker_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
