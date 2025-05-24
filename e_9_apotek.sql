-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2024 at 06:04 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_9_apotek`
--

-- --------------------------------------------------------

--
-- Table structure for table `apoteker`
--

CREATE TABLE `apoteker` (
  `id_apoteker` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telepon` varchar(255) NOT NULL,
  `pengalaman` varchar(255) NOT NULL,
  `gaji` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `apoteker`
--

INSERT INTO `apoteker` (`id_apoteker`, `nama`, `alamat`, `no_telepon`, `pengalaman`, `gaji`) VALUES
(2, 'Apoteker1', 'Condong Catur', '081272296378', '3', 2000000),
(3, 'Apoteker2', 'Babarsari', '081234567890', '5', 4500000),
(4, 'Apoteker3', 'Nologlaten', '123456789012', '2', 5000000),
(5, 'Apoteker4', 'Catur Tunggal', '081256782345', '1', 1500000),
(7, 'Apoteker5', 'Gowo', '081272294568', '1.4', 2850000);

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL,
  `nama_obat` varchar(255) NOT NULL,
  `kategori` varchar(255) NOT NULL,
  `harga_obat` double NOT NULL,
  `jumlah_stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `kategori`, `harga_obat`, `jumlah_stok`) VALUES
(1, 'Komix', 'Obat Bebas', 20000, 12),
(4, 'aspirin', 'Obat Keras', 25000, 12),
(5, 'Promag', 'Obat Bebas', 15000, 12),
(6, 'Xanax', 'Obat Psikotropika', 85000, 10),
(7, 'Alprazolam', 'Obat Narkotika', 24000, 6);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telepon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `alamat`, `no_telepon`) VALUES
(2, 'Pelanggan1', '082222222222', 'babarsari'),
(3, 'Pelanggan2', '081111111111', 'demangan'),
(4, 'Pelanggan3', '083333333333', 'Seturan'),
(5, 'Pelanggan4', '084444444444', 'Janti'),
(6, 'Pelanggan5', '085555555555', 'Nologaten');

-- --------------------------------------------------------

--
-- Table structure for table `pengadaanobat`
--

CREATE TABLE `pengadaanobat` (
  `id_pengadaan` int(11) NOT NULL,
  `id_apoteker` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `id_obat` int(11) NOT NULL,
  `tanggal_pengadaan` varchar(255) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `harga_total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengadaanobat`
--

INSERT INTO `pengadaanobat` (`id_pengadaan`, `id_apoteker`, `id_supplier`, `id_obat`, `tanggal_pengadaan`, `kuantitas`, `harga_total`) VALUES
(5, 3, 3, 4, '21-06-2024', 3, 75000),
(6, 2, 2, 1, '12-02-2024', 2, 40000),
(7, 4, 4, 5, '27-05-2024', 10, 150000),
(8, 5, 5, 6, '15-07-2024', 1, 85000),
(9, 7, 6, 7, '10-10-2023', 2, 48000);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telepon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama`, `alamat`, `no_telepon`) VALUES
(2, 'Supplier1', 'concat', '081211111111'),
(3, 'Supplier2', 'Babarsari', '081222222222'),
(4, 'Supplier3', 'Gejayan', '081233333333'),
(5, 'Supplier4', 'Gowok', '081244444444'),
(6, 'Supplier5', 'Kaliurang', '081255555555');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_apoteker` int(11) NOT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `id_obat` int(11) NOT NULL,
  `tanggal_transaksi` varchar(255) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `metode_pembayaran` varchar(255) NOT NULL,
  `total_harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_apoteker`, `id_pelanggan`, `id_obat`, `tanggal_transaksi`, `kuantitas`, `metode_pembayaran`, `total_harga`) VALUES
(3, 2, 2, 1, '23-08-2024', 2, 'Debit', 40000),
(4, 3, 3, 4, '26-08-2024', 3, 'E-Money', 75000),
(5, 4, 4, 5, '01-09-2024', 5, 'Tunai', 75000),
(6, 5, 5, 6, '06-09-2024', 4, 'Debit', 340000),
(7, 7, 6, 7, '11-09-2024', 1, 'E-Money', 24000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apoteker`
--
ALTER TABLE `apoteker`
  ADD PRIMARY KEY (`id_apoteker`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pengadaanobat`
--
ALTER TABLE `pengadaanobat`
  ADD PRIMARY KEY (`id_pengadaan`),
  ADD KEY `fk_apoteker` (`id_apoteker`),
  ADD KEY `fk_supplier` (`id_supplier`),
  ADD KEY `fk_obat` (`id_obat`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_id_apoteker` (`id_apoteker`),
  ADD KEY `fk_id_obat` (`id_obat`),
  ADD KEY `fk_id_pelanggan` (`id_pelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apoteker`
--
ALTER TABLE `apoteker`
  MODIFY `id_apoteker` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `pengadaanobat`
--
ALTER TABLE `pengadaanobat`
  MODIFY `id_pengadaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pengadaanobat`
--
ALTER TABLE `pengadaanobat`
  ADD CONSTRAINT `fk_apoteker` FOREIGN KEY (`id_apoteker`) REFERENCES `apoteker` (`id_apoteker`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_obat` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_supplier` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_id_apoteker` FOREIGN KEY (`id_apoteker`) REFERENCES `apoteker` (`id_apoteker`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_obat` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`),
  ADD CONSTRAINT `fk_id_pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
