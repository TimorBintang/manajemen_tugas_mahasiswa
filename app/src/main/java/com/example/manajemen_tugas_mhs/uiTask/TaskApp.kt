package com.example.manajemen_tugas_mhs.uiTask

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            // Nanti diisi di Commit 4
        }

        // Layar 3: Detail Tugas
        composable("detail_tugas/{taskId}") {
            // Nanti diisi di Commit 5
        }
    }
}