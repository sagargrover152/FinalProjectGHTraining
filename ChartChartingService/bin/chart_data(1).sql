-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2019 at 12:35 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chart_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee_stats`
--

CREATE TABLE `employee_stats` (
  `tracker_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `project_part_progress` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_stats`
--

INSERT INTO `employee_stats` (`tracker_id`, `emp_id`, `month`, `project_part_progress`, `year`, `emp_name`, `project_name`) VALUES
(0, 3, 10, 77, 2019, 'Ankush', 'AT&T'),
(1, 1, 10, 89, 2019, 'Sagar', 'Airbus'),
(2, 1, 9, 78, 2019, 'Sagar', 'Airbus'),
(3, 2, 9, 62, 2019, 'Indrijeet', 'AT&T'),
(4, 2, 10, 39, 2019, 'Indrijeet', 'AT&T'),
(6, 4, 10, 77, 2019, 'Akhil', 'Airbus'),
(7, 5, 8, 45, 2019, 'Rushil', 'AT&T'),
(8, 5, 10, 78, 2019, 'Rushil', 'AT&T'),
(9, 5, 9, 93, 2019, 'Rushil', 'AT&T'),
(10, 3, 9, 35, 2019, 'Ankush', 'AT&T'),
(11, 3, 8, 35, 2019, 'Ankush', 'AT&T'),
(12, 3, 7, 67, 2019, 'Ankush', 'AT&T'),
(13, 3, 6, 0, 2019, 'Ankush', 'AT&T');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `project_stats`
--

CREATE TABLE `project_stats` (
  `tracker_id` int(11) NOT NULL,
  `completed_tasks` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `total_assigned_tasks` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project_stats`
--

INSERT INTO `project_stats` (`tracker_id`, `completed_tasks`, `month`, `project_name`, `total_assigned_tasks`, `year`) VALUES
(1, 8, 10, 'AT&T', 10, 2019),
(2, 15, 9, 'AT&T', 15, 2019),
(3, 10, 8, 'AT&T', 15, 2019),
(4, 6, 7, 'AT&T', 10, 2019);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee_stats`
--
ALTER TABLE `employee_stats`
  ADD PRIMARY KEY (`tracker_id`);

--
-- Indexes for table `project_stats`
--
ALTER TABLE `project_stats`
  ADD PRIMARY KEY (`tracker_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
