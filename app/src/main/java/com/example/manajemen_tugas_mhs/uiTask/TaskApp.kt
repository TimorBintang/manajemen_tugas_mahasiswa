package com.example.manajemen_tugas_mhs.uiTask

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.manajemen_tugas_mhs.viewmodel.TaskViewModel

@Composable
fun TaskApp(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "daftar_tugas") {

        // Layar 1: Daftar Tugas
        composable("daftar_tugas") {
            val tasks by viewModel.taskList.collectAsState()
            TaskListScreen(
                tasks = tasks,
                onAddTaskClick = { navController.navigate("tambah_tugas") },
                onTaskClick = { taskId -> navController.navigate("detail_tugas/$taskId") }
            )
        }

        // Layar 2: Form Tambah Tugas
        composable("tambah_tugas") {
            TaskFormScreen(
                onSaveTask = { newTask ->
                    viewModel.addTask(newTask)
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Layar 3 & 4: Detail & Edit Status / Hapus Tugas
        composable(
            route = "detail_tugas/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: -1
            val tasks by viewModel.taskList.collectAsState()
            val selectedTask = tasks.find { it.id == taskId }

            TaskDetailScreen(
                task = selectedTask,
                onUpdateStatus = { task, newStatus ->
                    viewModel.updateTask(task.copy(status = newStatus))
                },
                onDeleteTask = { task ->
                    viewModel.deleteTask(task)
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}