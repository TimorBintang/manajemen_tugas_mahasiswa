package com.example.manajemen_tugas_mhs.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tugas_mahasiswa")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val mataKuliah: String,
    val judul: String,
    val deskripsi: String,
    val deadline: String,
    val prioritas: String,
    val status: String = "Belum"
)