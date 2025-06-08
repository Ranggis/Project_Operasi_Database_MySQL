-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2025 at 02:44 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` int(11) NOT NULL,
  `judul` varchar(100) DEFAULT NULL,
  `pengarang` varchar(100) DEFAULT NULL,
  `tahun_terbit` year(4) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `judul`, `pengarang`, `tahun_terbit`, `jumlah`) VALUES
(1, 'Bumi', 'Tere Liye', '2014', 100),
(2, 'Bulan', 'Tere Liye', '2015', 120),
(3, 'Matahari', 'Tere Liye', '2016', 150),
(4, 'Bintang', 'Tere Liye', '2017', 50),
(5, 'Ceros dan Batozar', 'Tere Liye', '2018', 87),
(6, 'Komet', 'Tere Liye', '2018', 230),
(7, 'Komet Minor', 'Tere Liye', '2019', 120),
(8, 'Selena', 'Tere Liye', '2020', 124),
(9, 'Nebula', 'Tere Liye', '2020', 189),
(10, 'Lumpu', 'Tere Liye', '2021', 24),
(11, 'Si Putih', 'Tere Liye', '2021', 126),
(12, 'Bibi Gill', 'Tere Liye', '2022', 200),
(13, 'Sagaras', 'Tere Liye', '2022', 284),
(14, 'Matahari Minor', 'Tere Liye', '2022', 53),
(15, 'ILT: Bagian 1', 'Tere Liye', '2023', 98),
(16, 'Aldebaran: Bagian 1', 'Tere Liye', '2024', 102),
(18, 'Hana Tara Hata', 'Tere Liye', '2025', 78);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
