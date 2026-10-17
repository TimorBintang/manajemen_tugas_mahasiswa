package com.example.manajemen_tugas_mhs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.manajemen_tugas_mhs.data.TaskDatabase
import com.example.manajemen_tugas_mhs.repository.TaskRepository
import com.example.manajemen_tugas_mhs.uiTask.TaskApp
import com.example.manajemen_tugas_mhs.viewmodel.TaskViewModel
import com.example.manajemen_tugas_mhs.viewmodel.TaskViewModelFactory
import com.example.manajemen_tugas_mhs.ui.theme.Manajemen_tugas_mhsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = TaskDatabase.getDatabase(this)
        val repository = TaskRepository(database.taskDao())

        setContent {
            Manajemen_tugas_mhsTheme {
                val taskViewModel: TaskViewModel = viewModel(
                    factory = TaskViewModelFactory(repository)
                )

                TaskApp(viewModel = taskViewModel)
            }
        }
    }
}