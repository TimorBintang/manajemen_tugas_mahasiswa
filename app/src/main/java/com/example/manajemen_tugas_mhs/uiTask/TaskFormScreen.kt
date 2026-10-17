package com.example.manajemen_tugas_mhs.uiTask

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.manajemen_tugas_mhs.data.TaskEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskFormScreen(
    onSaveTask: (TaskEntity) -> Unit,
    onNavigateBack: () -> Unit
) {
    var mataKuliah by remember { mutableStateOf("") }
    var judul by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var deadline by remember { mutableStateOf("") }
    var prioritas by remember { mutableStateOf("Sedang") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Tugas Baru") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = mataKuliah,
                onValueChange = { mataKuliah = it },
                label = { Text("Mata Kuliah") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = judul,
                onValueChange = { judul = it },
                label = { Text("Judul Tugas") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = deskripsi,
                onValueChange = { deskripsi = it },
                label = { Text("Deskripsi Tugas") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            OutlinedTextField(
                value = deadline,
                onValueChange = { deadline = it },
                label = { Text("Deadline (misal: 25 Okt 2026)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = prioritas,
                onValueChange = { prioritas = it },
                label = { Text("Prioritas (Tinggi / Sedang / Rendah)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (mataKuliah.isNotBlank() && judul.isNotBlank()) {
                        onSaveTask(
                            TaskEntity(
                                mataKuliah = mataKuliah,
                                judul = judul,
                                deskripsi = deskripsi,
                                deadline = deadline,
                                prioritas = prioritas,
                                status = "Belum"
                            )
                        )
                        onNavigateBack()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan Tugas")
            }
        }
    }
}