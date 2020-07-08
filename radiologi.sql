-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 08, 2020 at 04:41 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `radiologi`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `ktp` varchar(16) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `hp` varchar(13) NOT NULL,
  `kelamin` enum('l','w') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`ktp`, `password`, `nama`, `alamat`, `hp`, `kelamin`) VALUES
('1111111111111111', '', 'dokter1', 'bandung', '111111111111', 'l'),
('1111111111111112', '', 'dokter2', 'jakarta', '111111111112', 'w'),
('d', 'd', 'namakudokter', 'bandung', '123123', 'l');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis` enum('alat','barang') NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `id_supplier` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `nama`, `jenis`, `kuantitas`, `id_supplier`) VALUES
('film01', 'Film 30x50', 'barang', 50, 'supplier01'),
('film02', 'Film 40x70', 'barang', 25, 'supplier01'),
('tools01', 'Alat Scan Radiologi Utama', 'alat', 1, 'supplier02');

-- --------------------------------------------------------

--
-- Table structure for table `inventoryradiologi`
--

CREATE TABLE `inventoryradiologi` (
  `id` int(11) NOT NULL,
  `id_inventory` varchar(11) NOT NULL,
  `id_radiologi` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `inventory_log`
--

CREATE TABLE `inventory_log` (
  `id` int(11) NOT NULL,
  `id_staff` varchar(11) NOT NULL,
  `id_inv` varchar(11) NOT NULL,
  `keterangan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_log`
--

CREATE TABLE `maintenance_log` (
  `id` int(11) NOT NULL,
  `keterangan` text NOT NULL,
  `id_staff` varchar(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `ktp` varchar(16) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `hp` varchar(13) NOT NULL,
  `kelamin` enum('l','w') NOT NULL,
  `id_suster` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`ktp`, `nama`, `alamat`, `hp`, `kelamin`, `id_suster`) VALUES
('4444444444444441', 'deniz', 'cikutra', '444444444441', 'l', '2222222222222222'),
('4444444444444442', 'agnez', 'sukasenang', '444444444442', 'w', '2222222222222221');

-- --------------------------------------------------------

--
-- Table structure for table `radiologi`
--

CREATE TABLE `radiologi` (
  `id` int(11) NOT NULL,
  `id_pasien` varchar(16) NOT NULL,
  `id_dokter` varchar(16) NOT NULL,
  `id_scanradiologi` int(11) NOT NULL,
  `id_inventoryradiologi` int(11) NOT NULL,
  `date` date NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `record_log`
--

CREATE TABLE `record_log` (
  `id` int(11) NOT NULL,
  `keterangan` text NOT NULL,
  `id_staff` varchar(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `scan`
--

CREATE TABLE `scan` (
  `id` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scan`
--

INSERT INTO `scan` (`id`, `nama`, `harga`) VALUES
('full', 'Scan Full Body', 150000),
('kepala01', 'Scan Kepala', 75000);

-- --------------------------------------------------------

--
-- Table structure for table `scanradiologi`
--

CREATE TABLE `scanradiologi` (
  `id` int(11) NOT NULL,
  `id_scan` varchar(11) NOT NULL,
  `id_radiologi` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `ktp` varchar(11) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nama` char(50) NOT NULL,
  `alamat` text NOT NULL,
  `hp` varchar(13) NOT NULL,
  `kelamin` enum('l','w') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`ktp`, `password`, `nama`, `alamat`, `hp`, `kelamin`) VALUES
('33333333331', '', 'Martinez', 'lhokseumawe', '3333333333331', 'l'),
('33333333332', '', 'Rodrigez', 'Banten', '3333333333332', 'l'),
('st', 'st', 'namakustaff', 'jakarta', '1234123', 'l');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `ktp` varchar(11) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nama` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`ktp`, `password`, `nama`) VALUES
('su', 'su', 'namakusupplier'),
('supplier01', '', 'PT Mencari Cinta Sejati'),
('supplier02', '', 'Umbrella Corporation');

-- --------------------------------------------------------

--
-- Table structure for table `suster`
--

CREATE TABLE `suster` (
  `ktp` varchar(16) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `hp` varchar(13) NOT NULL,
  `kelamin` enum('l','w') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suster`
--

INSERT INTO `suster` (`ktp`, `password`, `nama`, `alamat`, `hp`, `kelamin`) VALUES
('2222222222222221', '', 'Maria', 'Surabaya', '222222222221', 'w'),
('2222222222222222', '', 'Ellisa', 'Maroko', '222222222222', 'w'),
('sus', 'sus', 'namakususter', 'jakarta', '2134123', 'w');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`ktp`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `inventoryradiologi`
--
ALTER TABLE `inventoryradiologi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_inventory` (`id_inventory`),
  ADD KEY `id_radiologi` (`id_radiologi`);

--
-- Indexes for table `inventory_log`
--
ALTER TABLE `inventory_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_inv` (`id_inv`),
  ADD KEY `id_staff` (`id_staff`);

--
-- Indexes for table `maintenance_log`
--
ALTER TABLE `maintenance_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_staff` (`id_staff`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`ktp`),
  ADD KEY `id_suster` (`id_suster`);

--
-- Indexes for table `radiologi`
--
ALTER TABLE `radiologi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_dokter` (`id_dokter`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `id_inventoryradiologi` (`id_inventoryradiologi`),
  ADD KEY `id_scanradiologi` (`id_scanradiologi`);

--
-- Indexes for table `record_log`
--
ALTER TABLE `record_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_staff` (`id_staff`);

--
-- Indexes for table `scan`
--
ALTER TABLE `scan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scanradiologi`
--
ALTER TABLE `scanradiologi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_radiologi` (`id_radiologi`),
  ADD KEY `id_scan` (`id_scan`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`ktp`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`ktp`);

--
-- Indexes for table `suster`
--
ALTER TABLE `suster`
  ADD PRIMARY KEY (`ktp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventoryradiologi`
--
ALTER TABLE `inventoryradiologi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inventory_log`
--
ALTER TABLE `inventory_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `maintenance_log`
--
ALTER TABLE `maintenance_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `radiologi`
--
ALTER TABLE `radiologi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `record_log`
--
ALTER TABLE `record_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `scanradiologi`
--
ALTER TABLE `scanradiologi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`ktp`);

--
-- Constraints for table `inventoryradiologi`
--
ALTER TABLE `inventoryradiologi`
  ADD CONSTRAINT `inventoryradiologi_ibfk_1` FOREIGN KEY (`id_inventory`) REFERENCES `inventory` (`id`),
  ADD CONSTRAINT `inventoryradiologi_ibfk_2` FOREIGN KEY (`id_radiologi`) REFERENCES `radiologi` (`id`);

--
-- Constraints for table `inventory_log`
--
ALTER TABLE `inventory_log`
  ADD CONSTRAINT `inventory_log_ibfk_1` FOREIGN KEY (`id_inv`) REFERENCES `inventory` (`id`),
  ADD CONSTRAINT `inventory_log_ibfk_2` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`ktp`);

--
-- Constraints for table `maintenance_log`
--
ALTER TABLE `maintenance_log`
  ADD CONSTRAINT `maintenance_log_ibfk_1` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`ktp`);

--
-- Constraints for table `pasien`
--
ALTER TABLE `pasien`
  ADD CONSTRAINT `pasien_ibfk_1` FOREIGN KEY (`id_suster`) REFERENCES `suster` (`ktp`);

--
-- Constraints for table `radiologi`
--
ALTER TABLE `radiologi`
  ADD CONSTRAINT `radiologi_ibfk_1` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`ktp`),
  ADD CONSTRAINT `radiologi_ibfk_2` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`ktp`),
  ADD CONSTRAINT `radiologi_ibfk_3` FOREIGN KEY (`id_inventoryradiologi`) REFERENCES `inventoryradiologi` (`id`),
  ADD CONSTRAINT `radiologi_ibfk_4` FOREIGN KEY (`id_scanradiologi`) REFERENCES `scanradiologi` (`id`);

--
-- Constraints for table `record_log`
--
ALTER TABLE `record_log`
  ADD CONSTRAINT `record_log_ibfk_1` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`ktp`);

--
-- Constraints for table `scanradiologi`
--
ALTER TABLE `scanradiologi`
  ADD CONSTRAINT `scanradiologi_ibfk_1` FOREIGN KEY (`id_radiologi`) REFERENCES `radiologi` (`id`),
  ADD CONSTRAINT `scanradiologi_ibfk_2` FOREIGN KEY (`id_scan`) REFERENCES `scan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
