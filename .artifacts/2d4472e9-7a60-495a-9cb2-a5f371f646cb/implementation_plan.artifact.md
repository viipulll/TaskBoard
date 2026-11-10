# Implementation Plan - TaskBoard Foundation & UI

Set up the project foundation and implement the main application UI structure for **TaskBoard — Real-Time Collaborative Task Board** using Kotlin, XML layouts ONLY, Material Design 3, MVVM architecture, and Gradle Kotlin DSL.

## Proposed Changes

### Project Structure & Configuration (`com.krish.realtimetaskboard`)
- Configured Gradle Kotlin DSL with ViewBinding enabled and Material 3 dependencies.
- Created package hierarchy: `data.model`, `data.repository`, `ui.auth`, `ui.dashboard`, `ui.board`, `ui.task`, `ui.activity`, `ui.profile`, `viewmodel`, `utils`.

### Data Layer & Sample Data
- **[NEW]** [Task.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/data/model/Task.kt): Data model for tasks.
- **[NEW]** [User.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/data/model/User.kt): User model.
- **[NEW]** [ActivityItem.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/data/model/ActivityItem.kt): Activity feed model.
- **[NEW]** [SampleData.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/utils/SampleData.kt): Realistic sample tasks and users for UI preview.
- **[NEW]** [TaskRepository.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/data/repository/TaskRepository.kt): Repository exposing StateFlow of tasks and activities.

### ViewModels
- **[NEW]** [TaskBoardViewModel.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/viewmodel/TaskBoardViewModel.kt): ViewModel managing task state, filtering, and mutations.

### UI & XML Layouts
- **[NEW]** [activity_splash.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/activity_splash.xml) & [SplashActivity.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/auth/SplashActivity.kt): Branded splash screen.
- **[NEW]** [activity_login.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/activity_login.xml) & [LoginActivity.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/auth/LoginActivity.kt): Login screen.
- **[NEW]** [activity_register.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/activity_register.xml) & [RegisterActivity.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/auth/RegisterActivity.kt): Registration screen.
- **[NEW]** [activity_main.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/activity_main.xml) & [MainActivity.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/MainActivity.kt): Main container with BottomNavigationView.
- **[NEW]** [fragment_dashboard.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/fragment_dashboard.xml) & [DashboardFragment.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/dashboard/DashboardFragment.kt): Dashboard with KPI metrics, sprint progress, and recent tasks.
- **[NEW]** [fragment_board.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/fragment_board.xml) & [BoardFragment.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/board/BoardFragment.kt): Collaborative Kanban board with To Do, In Progress, Completed columns.
- **[NEW]** [fragment_activity.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/fragment_activity.xml) & [ActivityFragment.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/activity/ActivityFragment.kt): Activity history feed.
- **[NEW]** [fragment_profile.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/fragment_profile.xml) & [ProfileFragment.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/profile/ProfileFragment.kt): User profile and settings.
- **[NEW]** [dialog_create_task.xml](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/res/layout/dialog_create_task.xml) & [CreateTaskBottomSheet.kt](file:///C:/Users/m/Desktop/TaskBoard/app/src/main/java/com/krish/realtimetaskboard/ui/task/CreateTaskBottomSheet.kt): Create task form bottom sheet.

## Verification Plan
- Verify project structure, package names, and resource bindings.
- Validate that all screens use ViewBinding and XML layouts exclusively (no Jetpack Compose).
