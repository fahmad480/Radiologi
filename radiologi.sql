-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2020 at 05:37 PM
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
  `harga` int(11) NOT NULL,
  `id_supplier` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `nama`, `jenis`, `kuantitas`, `harga`, `id_supplier`) VALUES
('film01', 'Film 30x50', 'barang', 50, 0, 'supplier01'),
('film02', 'Film 40x70', 'barang', 25, 0, 'supplier01'),
('tools01', 'Alat Scan Radiologi Utama', 'alat', 1, 0, 'supplier02');

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
  `nama_inv` varchar(11) NOT NULL,
  `id_supplier` varchar(11) NOT NULL,
  `keterangan` mediumtext NOT NULL,
  `status` enum('pending','ditolak','diterima') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory_log`
--

INSERT INTO `inventory_log` (`id`, `id_staff`, `nama_inv`, `id_supplier`, `keterangan`, `status`) VALUES
(1, 'st', 'film 30x50', 'su', 'ini film ya bro', 'pending'),
(2, 'st', 'film 40x50', 'su', 'ini film ya bro', 'pending'),
(4, 'st', 'asdasd', 'supplier01', 'ini film ya bro', 'diterima'),
(5, 'st', 'film 50x50', 'su', 'film 50x50\nharga 50000/pcs\nkuantitas 100\nkualitas brand udin', 'pending'),
(7, 'st', 'film 60x50', 'supplier02', 'film 50x50\nharga 50000/pcs\nkuantitas 100\nkualitas brand udin', 'diterima');

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

--
-- Dumping data for table `maintenance_log`
--

INSERT INTO `maintenance_log` (`id`, `keterangan`, `id_staff`, `date`) VALUES
(1, 'maintenance makan', 'st', '2020-07-01');

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
  `tmp_lahir` varchar(25) NOT NULL,
  `tgl_lahir` varchar(10) NOT NULL DEFAULT '0000-00-00',
  `id_suster` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`ktp`, `nama`, `alamat`, `hp`, `kelamin`, `tmp_lahir`, `tgl_lahir`, `id_suster`) VALUES
('4444444444444441', 'deniz', 'cikutra', '444444444441', 'l', 'Surabaya', '1999-10-26', 'sus'),
('4444444444444442', 'agnez', 'sukasenang', '444444444442', 'w', 'jakarta', '1998-11-01', 'sus'),
('4444444444444443', 'triz', 'sukasenang', '444444444443', 'l', 'bandung', '2000-06-01', 'sus');

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
  ADD KEY `id_staff` (`id_staff`),
  ADD KEY `id_supplier` (`id_supplier`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `maintenance_log`
--
ALTER TABLE `maintenance_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  ADD CONSTRAINT `inventory_log_ibfk_2` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`ktp`),
  ADD CONSTRAINT `inventory_log_ibfk_3` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`ktp`);

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
