# Study Tracker - Android Jetpack Compose App

A clean architecture Android application for tracking study sessions using Kotlin and Jetpack Compose with Material 3 design.

## Architecture Overview

This project follows clean architecture principles with clear separation of concerns:

### Data Layer
- **Entity**: `StudySession` - Room database entity representing a study session
- **DAO**: `StudySessionDao` - Data access object for database operations
- **Database**: `StudyTrackerDatabase` - Room database singleton
- **Repository**: `StudySessionRepository` - Abstraction layer for data operations

### Presentation Layer
- **ViewModel**: `StudyTrackerViewModel` - Manages UI state and business logic
- **UI State**: `StudyTrackerUiState` - Data class representing UI state
- **Screens**: Jetpack Compose screens with Material 3 components
- **Theme**: Custom Material 3 theme with support for dynamic colors

## Project Structure

```
app/src/main/kotlin/com/example/studytracker/
├── data/
│   ├── dao/
│   │   └── StudySessionDao.kt
│   ├── database/
│   │   └── StudyTrackerDatabase.kt
│   ├── entity/
│   │   └── StudySession.kt
│   └── repository/
│       └── StudySessionRepository.kt
├── presentation/
│   ├── ui/
│   │   ├── screen/
│   │   │   └── StudyTrackerScreen.kt
│   │   └── theme/
│   │       └── Theme.kt
│   └── viewmodel/
│       ├── StudyTrackerViewModel.kt
│       └── StudyTrackerViewModelFactory.kt
└── MainActivity.kt
```

## Features

- ✅ Add study sessions with subject name and duration
- ✅ View all sessions in chronological order
- ✅ Delete individual sessions
- ✅ Track total study time across all sessions
- ✅ Material 3 modern design system
- ✅ Dark mode support
- ✅ Responsive and intuitive UI
- ✅ Input validation
- ✅ Error handling with SnackBar notifications

## Dependencies

- **Jetpack Compose**: Modern UI toolkit
- **Room**: Local persistence library
- **Kotlin Coroutines**: Asynchronous programming
- **Material 3**: Design system and components
- **Android Architecture Components**: ViewModel, LiveData

## Building and Running

### Prerequisites
- Android Studio Flamingo or later
- JDK 17 or later
- Android SDK with API level 34

### Build Steps

1. Clone the repository
2. Open in Android Studio
3. Build the project: `./gradlew assembleDebug`
4. Run on emulator or device: `./gradlew installDebug`

## GitHub Actions Workflow

The project includes an automated CI/CD workflow (`.github/workflows/android.yml`) that:
- Triggers on push and pull requests to the main branch
- Sets up JDK 17
- Caches Gradle dependencies
- Builds the APK
- Uploads the APK as an artifact

## Best Practices Implemented

1. **Single Responsibility Principle**: Each class has a single, well-defined responsibility
2. **Dependency Injection**: Dependencies are passed through constructors
3. **State Management**: StateFlow for reactive UI updates
4. **Error Handling**: Proper error handling and user feedback
5. **Resource Efficiency**: Gradle dependency caching for faster builds
6. **Code Organization**: Clear separation of concerns across layers
7. **Type Safety**: Leveraging Kotlin's type system
8. **Coroutine Best Practices**: Using viewModelScope for lifecycle-aware coroutines

## Future Enhancements

- Add statistics and analytics
- Implement data persistence with encryption
- Add notifications for study sessions
- Implement cloud sync
- Add unit and integration tests
- Add data export functionality

## License

MIT License
