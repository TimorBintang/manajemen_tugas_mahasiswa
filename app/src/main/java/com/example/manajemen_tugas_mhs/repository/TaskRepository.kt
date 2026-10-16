package com.example.manajemen_tugas_mhs.repository

import com.example.manajemen_tugas_mhs.data.TaskDao
import com.example.manajemen_tugas_mhs.data.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: Flow<List<TaskEntity>> = taskDao.getAllTasks()

    suspend fun insert(task: TaskEntity) = taskDao.insertTask(task)
    suspend fun update(task: TaskEntity) = taskDao.updateTask(task)
    suspend fun delete(task: TaskEntity) = taskDao.deleteTask(task)
}