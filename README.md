# Aplikasi Manajemen Tugas Mahasiswa (Offline)

Aplikasi mobile berbasis Android untuk membantu mahasiswa mencatat, memantau, dan memperbarui status tugas mata kuliah secara offline. Dibuat untuk memenuhi Tugas Studi Kasus Praktikum 1 Pemrograman Aplikasi Bergerak Universitas Mulia.

## 📱 Fitur Utama
1. **Daftar Tugas (Read):** Menampilkan seluruh tugas yang tersimpan di database lokal Room.
2. **Tambah Tugas (Create):** Formulir untuk menambahkan tugas baru (Mata Kuliah, Judul, Deskripsi, Deadline, Prioritas).
3. **Detail Tugas:** Menampilkan informasi rinci dari tugas yang dipilih.
4. **Ubah Status (Update):** Memperbarui status pengerjaan tugas (*Belum*, *Proses*, *Selesai*).
5. **Hapus Tugas (Delete):** Menghapus tugas dari database lokal dengan dialog konfirmasi.

## 🛠️ Arsitektur & Teknologi
- **Bahasa:** Kotlin
- **UI:** Jetpack Compose (Declarative UI)
- **Arsitektur:** MVVM (Model-View-ViewModel) + Repository Pattern
- **Database Lokal:** Room Database (Offline First)
- **Asynchronous:** Kotlin Coroutines & StateFlow
- **Navigation:** Navigation Compose

## 🚀 Cara Menjalankan
1. *Clone* repository ini:
   ```bash
   git clone [https://github.com/TimorBintang/manajemen_tugas_mahasiswa.git](https://github.com/TimorBintang/manajemen_tugas_mahasiswa.git)