-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 04, 2018 at 06:03 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id7693974_lokasi`
--

-- --------------------------------------------------------

--
-- Table structure for table `fasilitas`
--

CREATE TABLE `fasilitas` (
  `fasilitas_umum` varchar(40) NOT NULL,
  `x` float NOT NULL,
  `y` float NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fasilitas`
--

INSERT INTO `fasilitas` (`fasilitas_umum`, `x`, `y`, `alamat`, `id`) VALUES
('SPBU Taman Ria', -8.4608, 118.742, 'Jl. Soekarno Hatta, Monggonao, Mpunda, Bima, Nusa Tenggara Barat. 84116', 1),
('SPBU Penatoi', -8.45868, 118.748, 'Penatoi, Mpunda, Bima, Nusa Tenggara Barat 84116', 2),
('SPBU Amahami', -8.46798, 118.723, 'Dara, West Rasanae, Bima, Nusa Tenggara Barat84111', 3),
('RSUD Bima', -8.47361, 118.762, 'Jalan Langsat No.1, Rabangodu Selatan, Raba, Rabangodu Sel., Bima, Nusa Tenggara Baratr. 84115', 4),
('RS Dr. Agung', -8.47362, 118.763, 'Jl. Ir Sutami No.1, Rabadompu Bar., Raba, Bima, Nusa Tenggara Bar. 84115', 5),
('Rumah Sakit PKU Muhammadiyah Bima', -8.4545, 118.736, 'Jl. Gajah Mada No.6, Monggonao, Mpunda, Bima, Nusa Tenggara Bar. 84100', 6),
('Puskesmas Penana\'e', -8.46648, 118.765, 'Jl. Gajah Mada, Rabadompu Bar., Raba, Bima, Nusa Tenggara Bar. 84115', 7),
('Puskesmas Jatibaru', -8.43886, 118.755, 'Jl. Datuk Dibanta, Jatibaru, Asakota, Bima, Nusa Tenggara Bar. 84111', 8),
('Puskesmas Paruga', -8.45938, 118.725, 'Jln.Pahlawan No.7, Dara, West Rasanae, Bima, Nusa Tenggara Barat 84118', 9),
('Puskesmas Kumbe', -8.48549, 118.77, 'Kumbe, Rasanae Tim., Bima, Nusa Tenggara Bar. 84115', 10),
('Puskemas Mpunda', -8.46345, 118.745, 'Jl. Gatot Subroto, Sadia, Mpunda, Bima, Nusa Tenggara Bar. 84116', 11),
('Puskemas Monggonao', -8.45981, 118.743, 'Monggonao, Mpunda, Bima, Nusa Tenggara Barat 84116', 12),
('Puskemas Asakota', -8.4501, 118.733, 'Jl. Datuk Dibanta, Jatiwangi, Asakota, Bima, Nusa Tenggara Bar. 84117', 13),
('BANK BNI Raba', -8.4694, 118.76, 'Jl. Soekarno Hatta , Rabangodu Utara, Raba, Bima, Nusa Tenggara Bar. 84111', 14),
('BANK BNI Bima', -8.45221, 118.727, 'Sarae, Rasanae Barat, Kota Bima, Nusa Tenggara Bar. 84118', 15),
('BANK BRI Bima', -8.45299, 118.727, 'Sarae, Rasanae Barat, Kota Bima, Nusa Tenggara Bar. 84118', 16),
('BANK BRI Unit Raba ', -8.46369, 118.752, 'Lewirato, Mpunda, Bima. 84116', 17),
('BANK Mandiri Cabang Bima', -8.454, 118.729, 'Jalan Sumbawa-Bima No. 02, Paruga, Bima, Nusa Tenggara Barat,  84111', 18),
('BANK Mandiri Syariah ', -8.45811, 118.724, 'Kompleks Sultan Square A4-A5, JL. Sultan Kaharudin, Dara, Rasanae Bar., Bima, Nusa Tenggara Barat. 84118', 19),
('BANK  Pesisir Akbar KC Kota Bima', -8.46717, 118.723, 'Dara,  Rasanae Barat, Bima.  84111', 20),
('BANK Sinarmas ', -8.45705, 118.743, 'Monggonao, Mpunda, Bima, Nusa Tenggara Barat 84116\r\n', 21),
('ATM BRI Bima', -8.45321, 118.727, 'Sarae, Rasanae Barat, Kota Bima, Nusa Tenggara Bar. 84118\r\n', 22),
('ATM Bank NTB Syariah', -8.45921, 118.724, 'Dara, Rasanae Barat, Bima, Nusa Tenggara Bar. 84118', 23),
('ATM BNI Dara', -8.46011, 118.723, 'Dara, Rasanae Barat, Bima, Nusa Tenggara Bar. 84118\r\n', 24),
('ATM BRI Raba', -8.47037, 118.761, 'Jl. Soekarno Hatta No.113, Rabangodu Utara, Raba, Bima.  84111\r\n', 25),
('ATM BNI Amahami', -8.46807, 118.723, 'Dara, Rasanae Barat, Bima.  84118\r\n', 26),
('ATM BNI Camelia', -8.45718, 118.744, 'Monggonao, Mpunda, Bima. 84116\r\n', 27),
('ATM Telkom Bima', -8.46225, 118.747, 'Lewirato, Mpunda, Bima, Nusa Tenggara Barat 84116\r\n', 28),
('Kantor Pos Rabangodu Utara', -8.46865, 118.76, 'Rabangodu Utara, Raba, Bima, Nusa Tenggara Barat 84115\r\n', 29),
('Kantor Pos Bima', -8.45524, 118.738, 'Jl. Gajah Mada, Monggonao, Bima, Nusa Tenggara Baratr. 82113\r\n', 30),
('Kantor Pos Bima Tolomundu', -8.45291, 118.731, 'Jl. Datuk Dibanta, Pane, Rasanae Barat, Bima, Nusa Tenggara Bar. 84118\r\n', 31),
('Kantor Walikota Bima', -8.46228, 118.748, 'Jl. Soekarno Hatta, Rabadompu Barat, Raba, Bima, Nusa Tenggara Bar. 84115\r\n', 32),
('Kantor Imigrasi Bima', -8.45389, 118.728, 'Jl. Kartini, Paruga, Rasanae Barat, Bima, Nusa Tenggara Barat. 84118\r\n', 33),
('Masjid Terapung Amahami Kota Bima', -8.46536, 118.722, 'Jl. Sultan Muhamad Salahuddin,Kota Bima, Nusa Tenggara Bar. 84111\r\n', 34),
('Masjid Uswatun Hasanah', -8.4776, 118.723, 'Melayu, Asakota, Bima, Nusa Tenggara Barat. 84118\r\n', 35),
('Masjid Raya Bima', -8.45315, 118.73, 'Pane, Rasanae Barat, Bima, Nusa Tenggara Barat. 84118\r\n', 36),
('Masjid Baitul Hamid ', -8.46662, 118.758, ' Jl. Soekarno Hatta, Rabangodu Utara, Raba, Bima, Nusa Tenggara Barat. 84115\r\n', 37),
('Masjid An-Nur Rbadompu Barat', -8.47727, 118.766, 'Rabadompu Barat,  Kota Bima, Nusa Tenggara Barat. 84115\r\n', 38),
('Masjid AL-Kautsar Oi Mbo', -8.48618, 118.775, 'Kumbe, Rasanae Timur, Kota Bima, Nusa Tenggara Barat. 84115\r\n', 39),
('Masjid Nurul Huda Lampe', -8.51195, 118.8, 'Jl.Lintas Bima-Sape , Lampe, Kota Bima. \r\n', 40),
('Gereja Katolik Bima', -8.47378, 118.76, 'Rabangodu Selatan, Raba, Bima. \r\n', 41),
('Gereja PGI Jemaat Bethel', -8.47233, 118.76, 'Rabangodu Selatan, Raba, Bima. \r\n', 42),
('Gereja Santo Yohanes', -8.45742, 118.727, 'Jl. Danatraha No.99, Dara, Kota Bima. \r\n', 43),
('Gpdi Jemaat Narwastu ', -8.4508, 118.724, 'Kelurahan Tanjung, Kota Bima.\r\n', 44),
('Gereja Kemah Injil Ekklesia Bima', -8.45075, 118.721, 'Kelurahan Tanjung, Kota Bima.\r\n', 45);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `nama` varchar(40) NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL,
  `keterangan` varchar(150) NOT NULL,
  `id` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`nama`, `longitude`, `latitude`, `keterangan`, `id`) VALUES
('Hotel Camelia', -8.45734, 118.744, 'Jl. Gajah Mada, Monggonao, Mpunda, Bima, Nusa Tenggara Bar. 84116', 2),
('Losmen Dara', -8.4591, 118.724, 'Dara, Rasanae Bar., Bima, Nusa Tenggara Bar. 84118', 3),
('Losmen Dewi Sari ', -8.45806, 118.727, 'Jl. Danatraha, Dara, Rasanae Bar., Bima, Nusa Tenggara Bar. 84118', 4),
('Hotel favorit', -8.45906, 118.725, 'Jl. Sultan Muhamad Salahuddin, Dara, Rasanae Bar., Bima, Nusa Tenggara Bar. 84118', 6),
('Losmen Komodo', -8.45264, 118.727, 'Jalan Sultan Ibrahim No.2, Sarae, Rasanae Bar., Bima, Nusa Tenggara Bar. 84118', 7),
('Hotel Lambitu', -8.45333, 118.726, 'Jalan Sumbawa No.4, Paruga, Rasanae Bar., Bima, Nusa Tenggara Bar. 84118', 8),
('Hotel La Illa', -8.45805, 118.736, 'Jl. Soekarno Hatta No.123, Pane, Rasanae Bar., Bima, Nusa Tenggara Bar. 84119', 9),
('Hotel Lila Graha', -8.45354, 118.725, 'Jl. Lombok No. 20, Paruga, Rasanae Bar., Bima, Nusa Tenggara Bar. 84118', 10),
('Hotel La Ode', -8.47493, 118.765, 'Rabadompu Bar., Raba, Bima, Nusa Tenggara Bar. 84115', 11),
('Hotel Marina', -8.46511, 118.764, 'Jl. Gajah Mada No. 8, Kec. Rasana,e Timur, Penaraga, Raba, Bima, Nusa Tenggara Bar. 83116', 12),
('Hotel Mutmainah', -8.46512, 118.764, 'Jl. Gajah Mada No. 8, Kec. Rasana,e Timur, Penaraga, Raba, Bima, Nusa Tenggara Bar. 83116', 13),
('Hotel Parewa', -8.45672, 118.734, 'Jl. Soekarno Hatta No.28, Pane, Rasanae Bar., Bima, Nusa Tenggara Bar. 84116', 14),
('Hotel Permata', -8.45434, 118.725, 'Jl. Soekarno Hatta, Monggonao, Mpunda, Bima, Nusa Tenggara Bar. 84116', 15),
('Hotel Graha Raja', -8.45099, 118.728, 'no 32 saleko kelurahan, Jl. Anggrek, Sarae, Rasanae Bar., Bima, Nusa Tenggara Bar. 84118', 16),
('Homestay Tambora ', -8.46142, 118.76, 'Penaraga, Raba, Bima, West Nusa Tenggara 84115', 17);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `nama_lokasi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `nama_lokasi`, `latitude`, `longitude`) VALUES
(1, 'Amahami', -8.46564, 118.723),
(2, 'Terminal kumbe', -8.48508, 118.771),
(3, 'Lawata', -8.47111, 118.711),
(4, 'Taman Ni\'u', -8.49393, 118.714),
(5, 'lapangan pahlawan', -8.4745, 118.762),
(6, 'paruga na\'e', -8.45827, 118.735),
(7, 'serasuba barat', -8.45428, 118.726),
(8, 'serasuba timur', -8.45455, 118.727),
(9, 'taman ria', -8.4601, 118.742);

-- --------------------------------------------------------

--
-- Table structure for table `rentalcar`
--

CREATE TABLE `rentalcar` (
  `rent_car` varchar(40) NOT NULL,
  `x` float NOT NULL,
  `y` float NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `id` int(11) NOT NULL,
  `no_hp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rentalcar`
--

INSERT INTO `rentalcar` (`rent_car`, `x`, `y`, `alamat`, `id`, `no_hp`) VALUES
('Bima RentCar', -8.45944, 118.741, 'JL Soekarno Hatta, RT. 01 RW. 01, Monggonao, Monggonao, Mpunda, Bima, Nusa Tenggara Bar. 84111\r\n', 1, '081337374357'),
('Mulya Rentcar ', -8.45853, 118.749, 'Jl. Gajah Mada No.46, Penatoi, Mpunda, Bima, Nusa Tenggara Barat. 84116\r\n', 2, '085253960151'),
('Jhon rentcar ', -8.44987, 118.723, 'Jl. Yos Sudarso, Asakota,Kota Bima, Nusa Tenggara Barat\r\n', 3, '085205292882'),
('PT. Pelita Armada Sewa Mobil Bima', 0, 0, '', 4, ''),
('Jhon rentcar ', -8.4646, 118.754, 'Jl.Soekarno-Hatta, Kelurahan Penaraga, Kota Bima, Nusa Tenggara Barat\r\n', 5, ''),
('Brow rentcar', -8.47836, 118.767, 'Jl.Ir Soetami, Rabadompu Timur, Kota Bima, Nusa Tenggara Barat\r\n', 6, '');

-- --------------------------------------------------------

--
-- Table structure for table `transportasi`
--

CREATE TABLE `transportasi` (
  `layanan_transportasi` varchar(40) NOT NULL,
  `x` float NOT NULL,
  `y` float NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transportasi`
--

INSERT INTO `transportasi` (`layanan_transportasi`, `x`, `y`, `alamat`, `id`) VALUES
('Terminal Bus Dara', -8.45874, 118.724, 'Dara, Rasanae Barat,  Bima, Nusa Tenggara Barat. 84118', 1),
('Terminal Bus Kumbe', -8.4851, 118.771, 'Jl. Lintas Bima-Sape, Kumbe, Rasanae Tim., Bima, Nusa Tenggara Bar. 84115', 2),
('Bandara Sultan Muhammad Salahuddin', -8.5418, 118.692, 'Jalan Sumbawa, Belo, Palibelo, Belo, Palibelo, Bima, Nusa Tenggara Bar. 84173', 3),
('Pelabuhan Bima', -8.44821, 118.714, 'Kel. Tanjung, Rasanae Barat, Kota  Bima.', 4),
('Terminal Bus Jatibaru', -8.43291, 118.764, '', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fasilitas`
--
ALTER TABLE `fasilitas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rentalcar`
--
ALTER TABLE `rentalcar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transportasi`
--
ALTER TABLE `transportasi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fasilitas`
--
ALTER TABLE `fasilitas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `rentalcar`
--
ALTER TABLE `rentalcar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `transportasi`
--
ALTER TABLE `transportasi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
