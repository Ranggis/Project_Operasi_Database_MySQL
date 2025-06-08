# 📚 Aplikasi Manajemen Buku Perpustakaan

Selamat datang di **Aplikasi Manajemen Buku Perpustakaan** berbasis Java dan MySQL!
Aplikasi ini dirancang untuk membantu pengguna dalam melakukan operasi CRUD (*Create, Read, Update, Delete*) terhadap data buku dalam sistem perpustakaan secara mudah dan efisien melalui antarmuka terminal.

---

## 📅 Fitur Utama

* ✏️ **Menambahkan Buku Baru**
  Input judul, pengarang, tahun terbit, dan jumlah buku.

* 🔍 **Mencari Buku Berdasarkan ID**
  Temukan buku dan tampilkan informasi lengkapnya secara langsung.

* 🔢 **Melihat Semua Data Buku**
  Tampilkan seluruh daftar buku yang tersimpan dalam database.

* ✏️ **Mengedit Informasi Buku**
  Ubah detail buku tertentu berdasarkan ID.

* ❌ **Menghapus Buku**
  Hapus data buku dari sistem secara permanen.

---

## ⚙️ Teknologi yang Digunakan

* **Java SE** untuk pengembangan aplikasi
* **MySQL** sebagai database manajemen data
* **JDBC (Java Database Connectivity)** untuk koneksi dan komunikasi antara Java & MySQL

---

## ⚡ Struktur Kode

* `Buku.java`
  Berisi logika utama untuk koneksi database dan fungsi-fungsi CRUD.

* `Main.java` (contoh: `BukuApp.java`)
  Menyediakan antarmuka menu berbasis teks untuk pengguna.

---

## 🔗 Koneksi Database

Pastikan kamu memiliki database dengan nama `perpustakaan` dan tabel `buku` dengan struktur sebagai berikut:

```sql
CREATE TABLE buku (
    id_buku INT AUTO_INCREMENT PRIMARY KEY,
    judul VARCHAR(100),
    pengarang VARCHAR(100),
    tahun_terbit INT,
    jumlah INT
);
```

---

## ⚡ Cara Menjalankan Aplikasi

1. Jalankan server MySQL (XAMPP/WAMP/Docker/Native)
2. Pastikan koneksi diatur dengan benar di `Buku.java`
3. Compile dan jalankan program:

```bash
javac Buku.java BukuApp.java
java BukuApp
```

---

## 🌟 Kenapa Harus Pakai Aplikasi Ini?

* Praktis digunakan di lingkungan kampus, sekolah, atau proyek pribadi
* Langsung jalan tanpa library tambahan
* Bisa dikembangkan lebih lanjut menjadi aplikasi GUI atau web!

---

## ✨ Rencana Pengembangan Selanjutnya

* Integrasi dengan GUI (JavaFX atau Swing)
* Fitur pencarian lanjutan (berdasarkan judul atau pengarang)
* Sistem login untuk admin dan pengguna
* Export data ke CSV atau PDF

---

## ❤️ Kontribusi

Silakan fork, clone, dan bantu kembangkan aplikasi ini! Pull request sangat terbuka\~

---

## 🌐 Lisensi

Proyek ini open-source dan dapat digunakan bebas untuk keperluan non-komersial.

---

> Dibuat dengan semangat belajar dan secangkir kopi ☕ oleh Ranggis ✨
