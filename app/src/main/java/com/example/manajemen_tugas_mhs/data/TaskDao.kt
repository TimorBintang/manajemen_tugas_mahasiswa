package com.example.manajemen_tugas_mhs.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tugas_mahasiswa ORDER BY deadline ASC")
    fun getAllTasks(): Flow<List<TaskEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity): Long
    @Update
    suspend fun updateTask(task: TaskEntity): Int
    @Delete
    suspend fun deleteTask(task: TaskEntity): Int
}