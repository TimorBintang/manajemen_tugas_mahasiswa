package com.example.manajemen_tugas_mhs.uiTask

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.manajemen_tugas_mhs.data.TaskEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailScreen(
    task: TaskEntity?,
    onUpdateStatus: (TaskEntity, String) -> Unit,
    onDeleteTask: (TaskEntity) -> Unit,
    onNavigateBack: () -> Unit
) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Tugas") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                    }
                },
                actions = {
                    if (task != null) {
                        IconButton(onClick = { showDeleteDialog = true }) {
                            Icon(Icons.Default.Delete, contentDescription = "Hapus Tugas", tint = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            )
        }
    ) { padding ->
        if (task == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("Tugas tidak ditemukan!")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = task.judul, style = MaterialTheme.typography.headlineMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Mata Kuliah: ${task.mataKuliah}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Deadline: ${task.deadline}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
                        Text(text = "Prioritas: ${task.prioritas}", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Deskripsi:", style = MaterialTheme.typography.titleMedium)
                        Text(text = if (task.deskripsi.isBlank()) "-" else task.deskripsi, style = MaterialTheme.typography.bodyMedium)
                    }
                }

                Text(text = "Ubah Status Tugas:", style = MaterialTheme.typography.titleMedium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FilterChip(
                        selected = task.status == "Belum",
                        onClick = { onUpdateStatus(task, "Belum") },
                        label = { Text("Belum") }
                    )
                    FilterChip(
                        selected = task.status == "Proses",
                        onClick = { onUpdateStatus(task, "Proses") },
                        label = { Text("Proses") }
                    )
                    FilterChip(
                        selected = task.status == "Selesai",
                        onClick = { onUpdateStatus(task, "Selesai") },
                        label = { Text("Selesai") }
                    )
                }
            }

            if (showDeleteDialog) {
                AlertDialog(
                    onDismissRequest = { showDeleteDialog = false },
                    title = { Text("Konfirmasi Hapus") },
                    text = { Text("Apakah kamu yakin ingin menghapus tugas ini?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                onDeleteTask(task)
                                showDeleteDialog = false
                                onNavigateBack()
                            }
                        ) {
                            Text("Hapus", color = MaterialTheme.colorScheme.error)
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDeleteDialog = false }) {
                            Text("Batal")
                        }
                    }
                )
            }
        }
    }
}