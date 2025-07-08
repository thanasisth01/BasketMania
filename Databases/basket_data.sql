-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2022 at 03:25 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS basket_data DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE basket_data;

-- --------------------------------------------------------

--
-- Table structure for table `basket_game`
--

CREATE TABLE `basket_game` (
  `game_id` int(11) NOT NULL,
  `team_name1` varchar(50) NOT NULL,
  `team_name2` varchar(50) NOT NULL,
  `game_week_number` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `winning_team_name` varchar(50) NOT NULL DEFAULT ' ',
  `points1` int(11) NOT NULL DEFAULT 0,
  `points2` int(11) NOT NULL DEFAULT 0,
  `made2p_1` int(11) NOT NULL DEFAULT 0,
  `attempted2p_1` int(11) NOT NULL DEFAULT 0,
  `made3p_1` int(11) NOT NULL DEFAULT 0,
  `attempted3p_1` int(11) NOT NULL DEFAULT 0,
  `madeft_1` int(11) NOT NULL DEFAULT 0,
  `attemptedft_1` int(11) NOT NULL DEFAULT 0,
  `made2p_2` int(11) NOT NULL DEFAULT 0,
  `attempted2p_2` int(11) NOT NULL DEFAULT 0,
  `made3p_2` int(11) NOT NULL DEFAULT 0,
  `attempted3p_2` int(11) NOT NULL DEFAULT 0,
  `madeft_2` int(11) NOT NULL DEFAULT 0,
  `attemptedft_2` int(11) NOT NULL DEFAULT 0,
  `off_rebs1` int(11) NOT NULL DEFAULT 0,
  `def_rebs1` int(11) NOT NULL DEFAULT 0,
  `off_rebs2` int(11) NOT NULL DEFAULT 0,
  `def_rebs2` int(11) NOT NULL DEFAULT 0,
  `assist1` int(11) NOT NULL DEFAULT 0,
  `assist2` int(11) NOT NULL DEFAULT 0,
  `blocks1` int(11) NOT NULL DEFAULT 0,
  `blocks_on1` int(11) NOT NULL DEFAULT 0,
  `blocks2` int(11) NOT NULL DEFAULT 0,
  `blocks_on2` int(11) NOT NULL DEFAULT 0,
  `steals1` int(11) NOT NULL DEFAULT 0,
  `steals2` int(11) NOT NULL DEFAULT 0,
  `turnovers1` int(11) NOT NULL DEFAULT 0,
  `turnovers2` int(11) NOT NULL DEFAULT 0,
  `fouls1` int(11) NOT NULL DEFAULT 0,
  `fouls2` int(11) NOT NULL DEFAULT 0,
  `finished_game` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `basket_game`
--

INSERT INTO `basket_game` (`game_id`, `team_name1`, `team_name2`, `game_week_number`, `date`, `winning_team_name`, `points1`, `points2`, `made2p_1`, `attempted2p_1`, `made3p_1`, `attempted3p_1`, `madeft_1`, `attemptedft_1`, `made2p_2`, `attempted2p_2`, `made3p_2`, `attempted3p_2`, `madeft_2`, `attemptedft_2`, `off_rebs1`, `def_rebs1`, `off_rebs2`, `def_rebs2`, `assist1`, `assist2`, `blocks1`, `blocks_on1`, `blocks2`, `blocks_on2`, `steals1`, `steals2`, `turnovers1`, `turnovers2`, `fouls1`, `fouls2`, `finished_game`) VALUES
(1, 'ARIS', 'PANATHINAIKOS OPAP', 1, '2021-10-03 17:00:00', 'APOLLON P. OSCAR', 89, 73, 27, 43, 6, 22, 17, 27, 16, 23, 9, 36, 14, 22, 10, 26, 12, 20, 18, 14, 2, 1, 5, 2, 13, 4, 15, 15, 30, 23, 1),
(2, 'APOLLON P. OSCAR', 'IONIKOS BASKET', 1, '2021-10-03 17:00:00', ' APOLLON P. OSCAR', 80, 72, 16, 34, 10, 29, 18, 19, 21, 49, 7, 32, 9, 14, 8, 33, 21, 28, 12, 12, 6, 4, 4, 3, 2, 6, 3, 5, 16, 23, 1),
(3, 'OLYMPIAKOS', 'AEK', 1, '2021-10-02 16:30:00', 'OLYMPIAKOS', 103, 78, 36, 24, 14, 37, 13, 15, 19, 33, 9, 25, 13, 17, 10, 24, 5, 25, 27, 19, 3, 1, 1, 0, 8, 4, 2, 5, 15, 20, 1),
(4, 'IRAKLIS', 'PROMITHEAS', 1, '2021-10-02 20:00:00', 'PROMITHEAS', 81, 88, 27, 40, 5, 23, 12, 19, 20, 34, 10, 27, 18, 25, 10, 22, 12, 22, 16, 21, 3, 3, 0, 1, 7, 5, 12, 14, 20, 18, 1),
(5, 'LARISA', 'KOLOSSOS H HOTELS', 1, '2021-10-02 17:00:00', 'LARISA', 82, 77, 20, 42, 7, 23, 21, 23, 20, 42, 10, 28, 7, 17, 14, 35, 9, 25, 17, 21, 2, 6, 2, 1, 7, 11, 13, 23, 21, 25, 1),
(6, 'PAOK mateco', 'LAVRIO MEGABOLT', 1, '2021-10-02 17:00:00', 'LAVRIO MEGABOLT', 73, 89, 16, 34, 6, 22, 23, 31, 23, 31, 12, 35, 7, 10, 15, 26, 7, 21, 12, 22, 0, 0, 3, 1, 4, 14, 11, 18, 16, 27, 1),
(7, 'LAVRIO MEGABOLT', 'OLYMPIAKOS', 2, '2021-10-10 20:00:00', ' ', 72, 108, 23, 39, 3, 22, 17, 24, 29, 45, 12, 24, 14, 22, 12, 19, 14, 22, 7, 22, 4, 1, 2, 0, 5, 7, 11, 15, 22, 23, 0),
(8, 'IRAKLIS', 'PANATHINAIKOS OPAP', 2, '2021-10-10 17:00:00', ' ', 76, 79, 19, 34, 9, 33, 11, 16, 19, 38, 9, 16, 14, 19, 10, 20, 8, 30, 13, 15, 1, 1, 0, 0, 14, 8, 20, 10, 17, 17, 0),
(9, 'KOLOSSOS H HOTELS', 'APOLLON P. OSCAR', 2, '2021-10-10 17:00:00', ' ', 73, 56, 18, 31, 9, 22, 10, 12, 11, 29, 8, 25, 10, 13, 3, 32, 5, 23, 22, 9, 2, 1, 1, 0, 5, 7, 14, 13, 20, 20, 0),
(10, 'AEK', 'LARISA', 2, '2021-10-09 20:00:00', ' ', 81, 69, 17, 24, 11, 26, 14, 26, 15, 37, 8, 24, 15, 21, 5, 28, 13, 25, 18, 12, 1, 1, 1, 0, 5, 4, 12, 10, 22, 24, 0),
(11, 'IONIKOS BASKET', 'ARIS', 2, '2021-10-09 17:00:00', ' ', 93, 83, 26, 50, 8, 22, 17, 22, 21, 48, 10, 33, 11, 13, 10, 35, 13, 28, 16, 12, 5, 3, 0, 0, 4, 8, 12, 15, 17, 23, 0),
(12, 'PROMITHEAS', 'PAOK mateco', 2, '2021-10-09 17:00:00', ' ', 84, 77, 17, 30, 12, 26, 14, 19, 20, 37, 8, 22, 13, 19, 6, 26, 7, 24, 23, 16, 1, 0, 1, 0, 4, 7, 9, 11, 19, 21, 0),
(13, 'AEK', 'PAOK mateco', 3, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(14, 'PROMITHEAS', 'APOLLON P. OSCAR', 3, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(15, 'ARIS', 'IONIKOS BASKET', 3, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(16, 'IRAKLIS', 'KOLOSSOS H HOTELS', 3, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(17, 'LARISA', 'LAVRIO MEGABOLT', 3, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(18, 'OLYMPIAKOS', 'PANATHINAIKOS OPAP', 3, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(19, 'AEK', 'PANATHINAIKOS OPAP', 4, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(20, 'PAOK mateco', 'PROMITHEAS', 4, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(21, 'APOLLON P. OSCAR', 'ARIS', 4, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(22, 'IONIKOS BASKET', 'IRAKLIS', 4, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(23, 'KOLOSSOS H HOTELS', 'LARISA', 4, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(24, 'LAVRIO MEGABOLT', 'OLYMPIAKOS', 4, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(25, 'AEK', 'OLYMPIAKOS', 5, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(26, 'PANATHINAIKOS OPAP', 'PAOK mateco', 5, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(27, 'PROMITHEAS', 'APOLLON P. OSCAR', 5, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(28, 'ARIS', 'IONIKOS BASKET', 5, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(29, 'IRAKLIS', 'KOLOSSOS H HOTELS', 5, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(30, 'LARISA', 'LAVRIO MEGABOLT', 5, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(31, 'AEK', 'LAVRIO MEGABOLT', 6, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(32, 'OLYMPIAKOS', 'PANATHINAIKOS OPAP', 6, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(33, 'PAOK mateco', 'PROMITHEAS', 6, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(34, 'APOLLON P. OSCAR', 'ARIS', 6, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(35, 'IONIKOS BASKET', 'IRAKLIS', 6, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(36, 'KOLOSSOS H HOTELS', 'LARISA', 6, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(37, 'AEK', 'LARISA', 7, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(38, 'LAVRIO MEGABOLT', 'OLYMPIAKOS', 7, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(39, 'PANATHINAIKOS OPAP', 'PAOK mateco', 7, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(40, 'PROMITHEAS', 'APOLLON P. OSCAR', 7, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(41, 'ARIS', 'IONIKOS BASKET', 7, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(42, 'IRAKLIS', 'KOLOSSOS H HOTELS', 7, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(43, 'AEK', 'KOLOSSOS H HOTELS', 8, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(44, 'LARISA', 'LAVRIO MEGABOLT', 8, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(45, 'OLYMPIAKOS', 'PANATHINAIKOS OPAP', 8, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(46, 'PAOK mateco', 'PROMITHEAS', 8, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(47, 'APOLLON P. OSCAR', 'ARIS', 8, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(48, 'IONIKOS BASKET', 'IRAKLIS', 8, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(49, 'AEK', 'IRAKLIS', 9, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(50, 'KOLOSSOS H HOTELS', 'LARISA', 9, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(51, 'LAVRIO MEGABOLT', 'OLYMPIAKOS', 9, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(52, 'PANATHINAIKOS OPAP', 'PAOK mateco', 9, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(53, 'PROMITHEAS', 'APOLLON P. OSCAR', 9, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(54, 'ARIS', 'IONIKOS BASKET', 9, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(55, 'AEK', 'IONIKOS BASKET', 10, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(56, 'IRAKLIS', 'KOLOSSOS H HOTELS', 10, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(57, 'LARISA', 'LAVRIO MEGABOLT', 10, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(58, 'OLYMPIAKOS', 'PANATHINAIKOS OPAP', 10, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(59, 'PAOK mateco', 'PROMITHEAS', 10, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(60, 'APOLLON P. OSCAR', 'ARIS', 10, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(61, 'AEK', 'ARIS', 11, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(62, 'IONIKOS BASKET', 'IRAKLIS', 11, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(63, 'KOLOSSOS H HOTELS', 'LARISA', 11, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(64, 'LAVRIO MEGABOLT', 'OLYMPIAKOS', 11, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(65, 'PANATHINAIKOS OPAP', 'PAOK mateco', 11, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(66, 'PROMITHEAS', 'APOLLON P. OSCAR', 11, '0000-00-00 00:00:00', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `team_name` varchar(32) NOT NULL,
  `player_name` varchar(32) NOT NULL,
  `event_type` varchar(32) NOT NULL,
  `game_id` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `opponent_name` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`team_name`, `player_name`, `event_type`, `game_id`, `timestamp`, `opponent_name`) VALUES
('PANATHINAIKOS OPAP', 'Avdalas Ioannis', 'made 2points', 1, '2022-06-11 21:14:06', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted 3points', 1, '2022-06-11 21:53:27', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted freethrow', 1, '2022-06-11 21:53:34', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'made freethrow', 1, '2022-06-11 21:53:36', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'made 2points', 1, '2022-06-11 21:53:38', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted 2points', 1, '2022-06-11 21:53:40', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted 3points', 1, '2022-06-11 21:53:41', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'made 3points', 1, '2022-06-11 21:53:43', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'offensive rebound', 1, '2022-06-11 21:53:45', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'defensive rebound', 1, '2022-06-11 21:53:46', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'block', 1, '2022-06-11 21:53:48', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'block_on', 1, '2022-06-11 21:53:49', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'steal', 1, '2022-06-11 21:53:51', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'turnover', 1, '2022-06-11 21:56:15', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'assist', 1, '2022-06-11 21:56:47', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'steal', 1, '2022-06-11 21:56:51', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'assist', 1, '2022-06-11 21:56:59', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'foul', 1, '2022-06-11 21:57:03', 'Athinaiou Ioannis'),
('APOLLON P. OSCAR', 'Griffin Dayon', 'foul', 1, '2022-06-11 21:58:00', 'Athinaiou Ioannis'),
('IRAKLIS', 'Argyroulis Panagiotis', 'attempted freethrow', 1, '2022-06-11 22:00:02', NULL),
('IRAKLIS', 'Argyroulis Panagiotis', 'steal', 1, '2022-06-11 22:00:04', NULL),
('IRAKLIS', 'Argyroulis Panagiotis', 'turnover', 1, '2022-06-11 22:00:09', NULL),
('IRAKLIS', 'Argyroulis Panagiotis', 'assist', 1, '2022-06-11 22:00:11', NULL),
('IRAKLIS', 'Argyroulis Panagiotis', 'foul', 1, '2022-06-11 22:00:13', 'Agravanis Ioannis'),
('ARIS', 'Gerokostas Nikolaos', 'foul', 1, '2022-06-11 22:36:08', 'Avdalas Ioannis'),
('ARIS', 'Gerokostas Nikolaos', 'assist', 1, '2022-06-11 22:36:10', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted freethrow', 1, '2022-06-16 12:43:29', NULL),
('LARISA', 'Asteriadis Asterios', 'made freethrow', 5, '2022-06-16 12:49:26', NULL),
('LARISA', 'Asteriadis Asterios', 'defensive rebound', 5, '2022-06-16 12:50:01', NULL),
('ARIS', 'Gerokostas Nikolaos', 'steal', 1, '2022-06-17 00:55:06', NULL),
('ARIS', 'Gerokostas Nikolaos', 'steal', 1, '2022-06-17 00:55:24', NULL),
('ARIS', 'Gerokostas Nikolaos', 'steal', 1, '2022-06-17 00:55:27', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted freethrow', 1, '2022-06-17 00:56:41', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted freethrow', 1, '2022-06-17 00:56:42', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'made freethrow', 1, '2022-06-17 00:56:46', NULL),
('APOLLON P. OSCAR', 'Griffin Dayon', 'attempted 2points', 1, '2022-06-17 00:56:50', NULL),
('ARIS', 'Gerokostas Nikolaos', 'made freethrow', 1, '2022-06-17 10:38:31', NULL),
('ARIS', 'Gerokostas Nikolaos', 'offensive rebound', 1, '2022-06-17 10:38:33', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `game_week`
--

CREATE TABLE `game_week` (
  `game_week_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game_week`
--

INSERT INTO `game_week` (`game_week_number`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `name` varchar(27) DEFAULT NULL,
  `position` varchar(14) DEFAULT NULL,
  `team_name` varchar(18) DEFAULT NULL,
  `id` int(3) NOT NULL,
  `photo_path` varchar(109) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`name`, `position`, `team_name`, `id`, `photo_path`) VALUES
('Avdalas Ioannis', 'Small Forward', 'PANATHINAIKOS OPAP', 1, 'https://media-cdn.incrowdsports.com/4698fea5-2aca-4bf2-88e5-5d24e72f3d93.png'),
('Avdalas Neoklis', 'Point Guard', 'PANATHINAIKOS OPAP', 2, 'https://media-cdn.incrowdsports.com/4698fea5-2aca-4bf2-88e5-5d24e72f3d93.png'),
('Agravanis Ioannis', 'Small Forward', 'PROMITHEAS', 3, 'http://www.esake.gr/dat/resize/esakeplayer/2BBFE416/photo_124CB0DD.jpg'),
('Agravanis Dimitris', 'Power Forward', 'PROMITHEAS', 4, 'https://www.proballers.com/media/cache/torso_player/ul/player/32877-3-5da9e972781c9.jpg'),
('Athinaiou Ioannis', 'Shooting Guard', 'IONIKOS BASKET', 5, 'https://www.proballers.com/media/cache/resize_300/ul/player/backup/32244-1-5bdb771b32427Giannis-Athinaiou.jpg'),
('Aminou Al Ouazint', 'Center', 'LAVRIO MEGABOLT', 6, 'http://www.esake.gr/dat/resize/esakeplayer/31D28464/photo_031DA069.jpg'),
('Braian Angola', 'Shooting Guard', 'AEK', 7, 'https://www.proballers.com/media/cache/torso_player/ul/player/58102-3-5d7f381cc2232.jpg'),
('Mihajlo Andrić', 'Small Forward', 'PROMITHEAS', 8, 'https://kolossosbc.gr/Images/FoT0s/1976.jpg'),
('Argyroulis Panagiotis', 'Shooting Guard', 'IRAKLIS', 9, 'https://bit.ly/39hJFV6'),
('Arsenopoulos Nikos ', 'Point Guard', 'IONIKOS BASKET', 10, 'https://bit.ly/39hJFV6'),
('Asteriadis Asterios', 'Shooting Guard', 'LARISA', 11, 'https://www.proballers.com/media/cache/torso_player/ul/player/138565-3-61d4b72675ad3.jpg'),
('Vasileiou Nikos', 'Shooting Guard', 'PROMITHEAS', 12, 'https://www.proballers.com/media/cache/torso_player/ul/player/71947-3-61d44f7a6797Sans-titre-1.jpg'),
('Vezenkof Alexander ', 'Power Forward', 'OLYMPIAKOS', 13, 'https://www.proballers.com/media/cache/torso_player/ul/player/23338-3-61d44849bddaSans-titre-1.jpg'),
('Vissariou Tilemakhos', 'Point Guard', 'LARISA', 14, 'https://api.sofascore.app/api/v1/player/1199447/image'),
('Von Rasant', 'Small Forward', 'LAVRIO MEGABOLT', 15, 'https://bit.ly/3O6YKru'),
('Voulgaropoulos Stratos', 'Center', 'LAVRIO MEGABOLT', 16, 'https://lavriobc.gr/images/VOULGAROPOULOS21.jpg'),
('Gerokostas Nikolaos', 'Power Forward', 'ARIS', 17, 'https://arisac.gr/wp-content/uploads/gerokostas-basket-official.jpg'),
('Geromikhalos Petros', 'Small Forward', 'LAVRIO MEGABOLT', 18, 'https://bit.ly/3QcId71'),
('Yankovits Vladimiros ', 'Small Forward', 'PAOK mateco', 19, 'https://basketball.realgm.com/images/nba/4.2/profiles/photos/2006/Giankovits_Vlantimir_euro.jpg'),
('Garet Branton', 'Center', 'IRAKLIS', 20, 'https://www.iraklis-bc.gr/images/2021/12/02/garrett.jpeg'),
('Gkikas Nikos', 'Point Guard', 'PROMITHEAS', 21, 'https://bit.ly/396DTFG'),
('Giouzelis Yiorgos', 'Small Forward', 'IONIKOS BASKET', 22, 'https://www.proballers.com/media/cache/torso_player/ul/player/68652-3-61085ce8c18c1.jpg'),
('Grant Tzerai', 'Power Forward', 'PROMITHEAS', 23, 'https://www.sdna.gr/sites/default/files/styles/square_cr/public/people/i_21.png?itok=pw0oakaS'),
('Green Devonte', 'Shooting Guard', 'LARISA', 24, 'https://bit.ly/3aIV5kW'),
('Greene Phil ', 'Shooting Guard', 'PAOK mateco', 25, 'http://www.paokbc.gr/images/players/2021-22/4_Greene.png'),
('Griffin Eric ', 'Center', 'AEK', 26, 'https://bit.ly/3xBs0Be'),
('Griffin Malcolm ', 'Point Guard', 'PAOK mateco', 27, 'https://www.proballers.com/media/cache/torso_player/ul/player/58726-3-61d4b25211ef3.jpg'),
('Griffin Dayon', 'Point Guard', 'APOLLON P. OSCAR', 28, 'https://sportando.basketball/wp-content/uploads/2022/01/Dayon-Griffin.jpg'),
('Gogolos Sotiris', 'Point Guard', 'AEK', 29, 'https://bit.ly/3HaSXi1'),
('Gontikas Costis', 'Point Guard', 'IONIKOS BASKET', 30, 'https://gonyuathletics.com/images/2013/9/21/Costis%20Gontikas.jpg'),
('Yints Keison', 'Point Guard', 'IRAKLIS', 31, 'https://www.superbasket.gr/images/editors/resized-image-Promo_-_2022-02-17T181616320.webp'),
('Walkup Thomas ', 'Shooting Guard', 'OLYMPIAKOS', 32, 'https://www.olympiacosbc.gr/templates/yootheme/cache/walkup-allos-bc7fac03.jpeg'),
('Deimezis Dimitrios', 'Power Forward', 'PANATHINAIKOS OPAP', 33, 'https://media-cdn.incrowdsports.com/a0e5230d-1684-49dc-9b27-36bb49143d4e.png'),
('Dimou Emmanouil', 'Shooting Guard', 'PANATHINAIKOS OPAP', 34, 'https://media-cdn.incrowdsports.com/1ea302d1-1f97-4d5d-93f6-6b00453c0d83.png'),
('Diamantakos Yiorgos', 'Center', 'APOLLON P. OSCAR', 35, 'https://bit.ly/3xABNaF'),
('Diplaros Nikos', 'Shooting Guard', 'APOLLON P. OSCAR', 36, 'https://bit.ly/3tm0yF1'),
('Evans Jeremy', 'Power Forward', 'PANATHINAIKOS OPAP', 37, 'https://media-cdn.incrowdsports.com/365dc51d-8c49-4172-becb-e0f2e08a3ad7.png'),
('Evstathiou Simeon', 'Small Forward', 'PANATHINAIKOS OPAP', 38, 'https://bit.ly/3H5sWAV'),
('Abrams Jamar', 'Small Forward', 'IRAKLIS', 39, 'https://bit.ly/3xwWd4d'),
('Quincy Jyrome Acy', 'Power Forward', 'OLYMPIAKOS', 40, 'https://a.espncdn.com/i/headshots/nba/players/full/6576.png'),
('Livio Jean-Charles', 'Power Forward', 'OLYMPIAKOS', 41, 'https://bit.ly/3mzeIyM'),
('Zaras Theodoros', 'Shooting Guard', 'LARISA', 42, 'https://bit.ly/3MDDbO3'),
('Zoumpos Fotis', 'Point Guard', 'APOLLON P. OSCAR', 43, 'https://bit.ly/3NDQUFT'),
('Kavvadas Vasilis', 'Center', 'PANATHINAIKOS OPAP', 44, 'https://bit.ly/3MvI7Ew'),
('Kaklamanakis Dimitris', 'Center', 'LAVRIO MEGABOLT', 45, 'https://bit.ly/3Q5GOzf'),
('Kalliontzis Stratos', 'Power Forward', 'PAOK mateco', 46, 'http://www.paokbc.gr/images/players/2021-22/19_kalliontzis_stratos.png'),
('Kamaras Nikos', 'Small Forward', 'ARIS', 47, 'https://bit.ly/3aJBilJ'),
('Kamarianos Nikolaos', 'Small Forward', 'PAOK mateco', 48, 'https://bit.ly/3tmV50A'),
('Kamperidis Yiorgos', 'Power Forward', 'PAOK mateco', 49, 'https://bit.ly/3xm8c3e'),
('Kamperidis Michalis', 'Small Forward', 'PAOK mateco', 50, 'https://bit.ly/3O2MLLp'),
('Kampouris Nikos', 'Center', 'KOLOSSOS H HOTELS', 51, 'https://bit.ly/3xDkoyc'),
('Cowan Anthony Jr.', 'Shooting Guard', 'ARIS', 52, 'https://bit.ly/3Hclnsi'),
('Karayiannis Konstantinos', 'Center', 'ARIS', 53, 'https://bit.ly/3O3cumN'),
('Karampelas Zois', 'Shooting Guard', 'LARISA', 54, 'https://bit.ly/3xCiopV'),
('Karlis Manolis', 'Point Guard', 'AEK', 55, 'https://bit.ly/3QbYMjG'),
('Karlis Michalis', 'Shooting Guard', 'AEK', 56, 'https://bit.ly/3xDaJGH'),
('Kaselakis Leonidas', 'Power Forward', 'PANATHINAIKOS OPAP', 57, 'https://bit.ly/3zsPidD'),
('Kelly James', 'Center', 'ARIS', 58, 'https://bit.ly/3zJPoxZ'),
('Koyonis Yiorgos', 'Small Forward', 'APOLLON P. OSCAR', 59, 'https://bit.ly/3aIo9sW'),
('Koloveros Iosif', 'Point Guard', 'IONIKOS BASKET', 60, 'https://bit.ly/3mvVWs7'),
('Colom Quino', 'Shooting Guard', 'AEK', 61, 'https://bit.ly/3zpOZAx'),
('Komniadis Ioannis', 'Center', 'IRAKLIS', 62, 'https://bit.ly/3NEYIaa'),
('Koniaris Antonis', 'Point Guard', 'AEK', 63, 'https://bit.ly/3QbMFD7'),
('Coleman Orlando', 'Small Forward', 'APOLLON P. OSCAR', 64, 'https://bit.ly/3xAQlHj'),
('Kouzeloglou Yiannis', 'Small Forward', 'AEK', 65, 'https://bit.ly/3NyS714'),
('Krubally Ousman', 'Power Forward', 'LARISA', 66, 'https://bit.ly/3xfWB60'),
('Konstandinidis Theodoros', 'Point Guard', 'PAOK mateco', 67, 'https://bit.ly/3zAUJHs'),
('Kottas Thomas', 'Center', 'ARIS', 68, 'https://bit.ly/3aGtMb6'),
('Layios Angelos', 'Shooting Guard', 'PROMITHEAS', 69, 'https://bit.ly/3Mx5Eot'),
('Lampropoulos Konstantinos', 'Shooting Guard', 'ARIS', 70, 'https://bit.ly/3Q5Nhu1'),
('Langford Kevin', 'Power Forward', 'IONIKOS BASKET', 71, 'https://bit.ly/3tsh1HA'),
('Langford Keith', 'Shooting Guard', 'AEK', 72, 'https://bit.ly/3Q7v1Ax'),
('Larentzakis Yiannoulis', 'Point Guard', 'OLYMPIAKOS', 73, 'https://www.proballers.com/media/cache/torso_player/ul/player/11181-3-61d446218b4bSans-titre-1.jpg'),
('Latos Ilias', 'Small Forward', 'IRAKLIS', 74, 'https://bit.ly/39hJFV6'),
('Lee Anthony ', 'Small Forward', 'PAOK mateco', 75, 'https://www.proballers.com/ul/player/41784-1-5da9dec926729.jpg'),
('Love Jermaine ', 'Point Guard', 'PAOK mateco', 76, 'https://sportsfive.gr/assets/images/players/Jermaine_Love.jpg'),
('Lockett Eric', 'Power Forward', 'ARIS', 77, 'https://www.proballers.com/media/cache/resize_300/ul/player/backup/71713-1-61d46e1fe6a22.jpg'),
('Lountzis Michalis', 'Shooting Guard', 'OLYMPIAKOS', 78, 'https://bit.ly/3QgiNW3'),
('McKissic Shaquielle ', 'Power Forward', 'OLYMPIAKOS', 79, 'https://www.proballers.com/media/cache/torso_player/ul/player/47896-3-61d44928575eSans-titre-1.jpg'),
('McLaffin Jeremy', 'Center', 'APOLLON P. OSCAR', 80, 'https://www.proballers.com/media/cache/torso_player/ul/player/94896-3-61d46b0f3d853.jpg'),
('McLean Tre', 'Small Forward', 'APOLLON P. OSCAR', 81, 'https://www.proballers.com/media/cache/torso_player/ul/player/54592-3-5e4db1b154814.jpg'),
('Mantzaris Vangelis', 'Point Guard', 'PAOK mateco', 82, 'https://www.euroleague.net/rs/9yofy55dt54nto7s/c4974b14-d249-46d4-9092-0e470e8d733d/12c/filename/c49.jpg'),
('Mantzoukas Lefteris', 'Power Forward', 'PANATHINAIKOS OPAP', 83, 'https://allstarbasket.gr/wp-content/uploads/2021/01/72_Mantzoukas_450x600.png'),
('Margaritis Vangelis', 'Small Forward', 'KOLOSSOS H HOTELS', 84, 'https://www.proballers.com/media/cache/torso_player/ul/player/4125-3-61d44c868342Sans-titre-1.jpg'),
('Marić Marin', 'Center', 'LARISA', 85, 'https://www.proballers.com/media/cache/torso_player/ul/player/41973-3-5d7eaff8d6b22.jpg'),
('Martin Hassan', 'Center', 'OLYMPIAKOS', 86, 'https://www.proballers.com/media/cache/torso_player/ul/player/58256-3-61d447d23052Sans-titre-1.jpg'),
('Mavridis Dimitris', 'Center', 'AEK', 87, 'https://bit.ly/39hJFV6'),
('Mavrokefalidis Loukas', 'Center', 'IONIKOS BASKET', 88, 'https://www.proballers.com/media/cache/torso_player/ul/player/29918-3-5da9925680909.jpg'),
('Miles Isaiah', 'Small Forward', 'PROMITHEAS', 89, 'https://www.proballers.com/media/cache/torso_player/ul/player/54784-3-61d44fa79526Sans-titre-1.jpg'),
('Macon Daryl', 'Shooting Guard', 'PANATHINAIKOS OPAP', 90, 'https://media-cdn.incrowdsports.com/5541c3ed-56f3-47ea-ad3a-af32ed7d03ce.png'),
('Mitrou-Long Elijah', 'Point Guard', 'APOLLON P. OSCAR', 91, 'https://bit.ly/3ztaoZq'),
('Miller Shonn', 'Small Forward', 'KOLOSSOS H HOTELS', 92, 'https://www.kolossosbc.gr/Images/FoT0s/2107.jpg'),
('Mirosavich Angelos', 'Shooting Guard', 'KOLOSSOS H HOTELS', 93, 'https://www.kolossosbc.gr/Images/FoT0s/2104.jpg'),
('Molfetas Yiannis', 'Point Guard', 'APOLLON P. OSCAR', 94, 'https://www.westbasket.gr/wp-content/uploads/2016/08/MOLFETAS.jpg'),
('Momirov Stefan ', 'Point Guard', 'KOLOSSOS H HOTELS', 95, 'https://www.kolossosbc.gr/Images/FoT0s/2109.jpg'),
('Moses Kingsley', 'Center', 'IONIKOS BASKET', 96, 'https://www.proballers.com/media/cache/torso_player/ul/player/7594-3-5e34b3c4ec576.jpg'),
('Mouzourakis Odysseas', 'Center', 'AEK', 97, 'http://www.aekbc.gr/uploads/schemes/images/8/8d945a5225634fc8f976254b0cc3f29a_18.jpg'),
('Moody Stefan ', 'Shooting Guard', 'LARISA', 98, 'https://www.proballers.com/media/cache/torso_player/ul/player/50442-3-5e6518ec38734.jpg'),
('Mouratos Vasilis', 'Point Guard', 'LAVRIO MEGABOLT', 99, 'https://lavriobc.gr/images/MOURATOS21.jpg'),
('Mustafa Muhaymin ', 'Shooting Guard', 'IONIKOS BASKET', 100, 'https://6thman.eu/5007-home_default/muhaymin-mustafa.jpg'),
('Bazinas Thanasis', 'Point Guard', 'PROMITHEAS', 101, 'https://www.proballers.com/media/cache/torso_player/ul/player/68400-3-61070d6dab352.jpg'),
('Bazinas Yianis', 'Power Forward', 'LARISA', 102, 'shorturl.at/ayHLT'),
('Billis Sotiris', 'Small Forward', 'KOLOSSOS H HOTELS', 103, 'https://www.proballers.com/media/cache/torso_player/ul/player/50589-3-61d44c5079a6Sans-titre-1.jpg'),
('Borgis Yiorgos', 'Center', 'APOLLON P. OSCAR', 104, 'https://www.olympiacosbc.gr/images/archive/players/GIORGOS_BOGRIS.jpg'),
('Bokhoridis Eleftherios', 'Point Guard', 'PANATHINAIKOS OPAP', 105, 'https://www.proballers.com/media/cache/torso_player/ul/player/19479-3-5d6d82c902e53.jpg'),
('Nedović Nemanja ', 'Shooting Guard', 'PANATHINAIKOS OPAP', 106, 'https://bit.ly/3Hg8EVl'),
('Neofitos Yiorgos', 'Shooting Guard', 'PROMITHEAS', 107, 'https://bit.ly/39hJFV6'),
('Netzipoglou Omiros', 'Point Guard', 'ARIS', 108, 'https://bit.ly/3Nxc7Bf'),
('Nikolaidis Alexandros', 'Point Guard', 'LAVRIO MEGABOLT', 109, 'https://www.olympiacosbc.gr/images/team/players/2021/side/1nikolaidisbody.jpg'),
('Davis Mike', 'Shooting Guard', 'IONIKOS BASKET', 110, 'https://www.proballers.com/media/cache/resize_300/ul/player/backup/69839-1-61edc20d4b321.jpg'),
('Davis Dejon', 'Power Forward', 'APOLLON P. OSCAR', 111, 'https://triponta.com.cy/wp-content/uploads/2000/11/davis.png'),
('DiLeo David', 'Small Forward', 'PAOK mateco', 112, 'https://bit.ly/3aSo2LA'),
('Dolezaj Marek ', 'Small Forward', 'IRAKLIS', 113, 'https://cuse.com/images/2020/7/18/DolezajMarekRoster20.jpg?width=300'),
('Dorsey Tyler', 'Point Guard', 'OLYMPIAKOS', 114, 'https://bit.ly/3aLnt5Z'),
('Xanthopoulos Vasilis', 'Point Guard', 'KOLOSSOS H HOTELS', 115, 'https://www.kolossosbc.gr/Images/FoT0s/2113.jpg'),
('Ogbeide Derek', 'Center', 'PAOK mateco', 116, 'https://www.proballers.com/media/cache/resize_300/ul/player/backup/83258-1-61d4b04abf442.jpg'),
('Oikonomopoulos Konstantinos', 'Shooting Guard', 'KOLOSSOS H HOTELS', 117, 'https://www.proballers.com/media/cache/torso_player/ul/player/42442-3-5cfd7bcda3222.jpg'),
('Oikonomopoulos Sotiris', 'Shooting Guard', 'OLYMPIAKOS', 118, 'https://bit.ly/3xlH3gS'),
('Owens Josh', 'Center', 'IONIKOS BASKET', 119, 'https://on.nba.com/39htrv2'),
('White Okaro', 'Power Forward', 'PANATHINAIKOS OPAP', 120, 'https://on.nba.com/39htrv2'),
('Williams Xeyrius ', 'Power Forward', 'ARIS', 121, 'https://bit.ly/3O00QZY'),
('Williams Kenny ', 'Shooting Guard', 'KOLOSSOS H HOTELS', 122, 'https://bit.ly/3xxJTAO'),
('Williams Matt Junior', 'Shooting Guard', 'LAVRIO MEGABOLT', 123, 'https://bit.ly/3H6QzZG'),
('Papayiannis Yiorgos', 'Center', 'PANATHINAIKOS OPAP', 124, 'https://bit.ly/3ztdDQv'),
('Papadakis Kostas', 'Point Guard', 'IRAKLIS', 125, 'https://bit.ly/3aSmyB0'),
('Papanikolaou Kostas', 'Small Forward', 'OLYMPIAKOS', 126, 'https://bit.ly/3QeRgnQ'),
('Papantoniou Nontas', 'Shooting Guard', 'LARISA', 127, 'https://bit.ly/3xz4hSa'),
('Papapetrou Ioannis', 'Small Forward', 'PANATHINAIKOS OPAP', 128, 'https://www.proballers.com/media/cache/torso_player/ul/player/8549-3-5d97d74b56002.jpg'),
('Papafotiou Fotis', 'Power Forward', 'APOLLON P. OSCAR', 129, 'https://bit.ly/3H6wWBf'),
('Pappas Nikos', 'Point Guard', 'AEK', 130, 'https://bit.ly/3O1YTfJ'),
('Perry Kendrick', 'Point Guard', 'PANATHINAIKOS OPAP', 131, 'https://bit.ly/39hxSGk'),
('Persidis Nikolaos', 'Small Forward', 'LAVRIO MEGABOLT', 132, 'https://bit.ly/3aDJYKd'),
('Petanidis Yiorgos', 'Point Guard', 'IRAKLIS', 133, 'https://bit.ly/3aT8UNZ'),
('Petanidis Kiriakos', 'Power Forward', 'ARIS', 134, 'https://bit.ly/3mwHq34'),
('Petropoulos Andreas', 'Point Guard', 'AEK', 135, 'https://bit.ly/3zxe3FE'),
('Pilavios Alfis', 'Power Forward', 'LAVRIO MEGABOLT', 136, 'https://bit.ly/3NELryA'),
('Pippen Danny', 'Small Forward', 'LAVRIO MEGABOLT', 137, 'https://bit.ly/398RSuF'),
('Plotas Nikos', 'Shooting Guard', 'PROMITHEAS', 138, 'https://bit.ly/3QbW4up'),
('Pot Stefan', 'Shooting Guard', 'KOLOSSOS H HOTELS', 139, 'https://bit.ly/3aJQ2Ri'),
('Poulianitis Stelios', 'Point Guard', 'ARIS', 140, 'https://bit.ly/3xi4Dv8'),
('Prapas Stergios', 'Shooting Guard', 'KOLOSSOS H HOTELS', 141, 'https://bit.ly/3xg4yYU'),
('Printezis Yiorgos', 'Power Forward', 'OLYMPIAKOS', 142, 'https://bit.ly/3zrIUmW'),
('Rautins Andy', 'Point Guard', 'AEK', 143, 'https://bit.ly/39os3Xw'),
('Rice Rayvonte ', 'Power Forward', 'IONIKOS BASKET', 144, 'https://bit.ly/39kjzkj'),
('Renfro Nate ', 'Power Forward', 'PAOK mateco', 145, 'https://bit.ly/3QfcIco'),
('Ray Kendrick ', 'Point Guard', 'PROMITHEAS', 146, 'https://bit.ly/397j7pp'),
('Rivers Dimitri', 'Small Forward', 'PAOK mateco', 147, 'https://bit.ly/39k2g2S'),
('Rongavopoulos Nikos', 'Point Guard', 'PROMITHEAS', 148, 'https://bit.ly/3Q5XVAZ'),
('Wroten Tony', 'Point Guard', 'IRAKLIS', 149, 'https://bit.ly/3H6Vvhp'),
('Roumoglou Apostolos', 'Shooting Guard', 'PAOK mateco', 150, 'https://bit.ly/3tq31hA'),
('Savage Jared', 'Power Forward', 'LAVRIO MEGABOLT', 151, 'https://bit.ly/3Ho8HyF'),
('Sant-Roos Howard ', 'small Forward', 'PANATHINAIKOS OPAP', 152, 'https://bit.ly/3zt15Zu'),
('Sanders Corey', 'Point Guard', 'LAVRIO MEGABOLT', 153, 'https://bit.ly/3mwgRLw'),
('Saxionis Konstantinos', 'Point Guard', 'AEK', 154, 'https://bit.ly/3MwE377'),
('Sachpatzidis Yiannis', 'Center', 'LARISA', 155, 'https://bit.ly/3xbtC36'),
('Siva Peyton', 'Shooting Guard', 'PANATHINAIKOS OPAP', 156, 'https://bit.ly/3ttSH8u'),
('Sidiroilias Yiannis', 'Power Forward', 'ARIS', 157, 'https://bit.ly/3aROfKd'),
('Simons Gerel', 'Shooting Guard', 'APOLLON P. OSCAR', 158, 'https://bit.ly/39bCA8A'),
('Simpson Trevis', 'Power Forward', 'PROMITHEAS', 159, 'https://bit.ly/3my8wqJ'),
('Skordilis Gaios', 'Center', 'IRAKLIS', 160, 'https://bit.ly/3NFopHE'),
('Slaftsakis Diamantis', 'Small Forward', 'KOLOSSOS H HOTELS', 161, 'https://bit.ly/3mwlcOX'),
('Sloukas Kostas', 'Shooting Guard', 'OLYMPIAKOS', 162, 'https://bit.ly/3aSKkgc'),
('Sprintzios Michalis', 'Small Forward', 'LAVRIO MEGABOLT', 163, 'https://bit.ly/39hJFV6'),
('Spiropoulos Anastasios', 'Small Forward', 'LARISA', 164, 'https://bit.ly/3Qc2Dgv'),
('Stamatis Dimitris', 'Point Guard', 'IRAKLIS', 165, 'https://bit.ly/3xCSZMP'),
('Schizas Stavros', 'Point Guard', 'ARIS', 166, 'https://bit.ly/3mzr1eh'),
('Tanoulis Yiorgos', 'Small Forward', 'PROMITHEAS', 167, 'https://bit.ly/3xDCfVI'),
('Tachiridis Prodromos', 'Power Forward', 'PAOK mateco', 168, 'https://bit.ly/39hJFV6'),
('Taylor Ryan ', 'Small Forward', 'IRAKLIS', 169, 'https://bit.ly/3Qc7C0J'),
('Tzolos Vangelis', 'Point Guard', 'IONIKOS BASKET', 170, 'https://bit.ly/39hJFV6'),
('Juiston Shakur', 'Small Forward', 'ARIS', 171, 'https://bit.ly/39hNFVC'),
('Tillie Kim', 'Power Forward', 'KOLOSSOS H HOTELS', 172, 'https://bit.ly/3tsb6T4'),
('Toliopoulos Vasilis', 'Shooting Guard', 'PAOK mateco', 173, 'https://bit.ly/39ny9aF'),
('Tumba Kevin', 'Center', 'IONIKOS BASKET', 174, 'https://bit.ly/3mxcdgf'),
('Tsalmpouris Yiorgos', 'Center', 'APOLLON P. OSCAR', 175, 'https://bit.ly/3NFGR2W'),
('Tsachtsiras Philippos', 'Small Forward', 'ARIS', 176, 'https://bit.ly/39hJFV6'),
('Tsairelis Mikhalis', 'Small Forward', 'LARISA', 177, 'https://bit.ly/3O5BYA9'),
('Tsiakmas Nikos', 'Shooting Guard', 'APOLLON P. OSCAR', 178, 'https://bit.ly/3MBKaXJ'),
('Fall Moustapha', 'Center', 'OLYMPIAKOS', 179, 'https://bit.ly/39cDd1P'),
('Filippakos Panayiotis', 'Power Forward', 'AEK', 180, 'https://bit.ly/3Q981Rw'),
('Fillios Yiorgos', 'Shooting Guard', 'IRAKLIS', 181, 'https://bit.ly/3mF10Kx'),
('Filoxhenidis Kostas', 'Point Guard', 'LAVRIO MEGABOLT', 182, 'https://bit.ly/3mwQ55B'),
('Flionis Dimitris', 'Point Guard', 'AEK', 183, 'https://bit.ly/3aKezWH'),
('Floyd Jordan', 'Shooting Guard', 'KOLOSSOS H HOTELS', 184, 'https://bit.ly/3myXOAj'),
('Fridas Lampros', 'Point Guard', 'ARIS', 185, 'https://bit.ly/3xiyymS'),
('Chavales Stelios', 'small Forward', 'ARIS', 186, 'https://bit.ly/3HaMOCH'),
('Hummer Ian', 'Power Forward', 'AEK', 187, 'https://bit.ly/3HaMXGf'),
('Hamilton Daniel', 'small Forward', 'IONIKOS BASKET', 188, 'https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3147351.png'),
('Hanlan Olivier', 'Point Guard', 'ARIS', 189, 'https://www.proballers.com/media/cache/torso_player/ul/player/42290-3-61d46f8573243.jpg'),
('Hunt Dario', 'Center', 'PROMITHEAS', 190, 'https://www.proballers.com/media/cache/torso_player/ul/player/45324-3-5d17607d9bec3.jpg'),
('Hudson Jalen ', 'Shooting Guard', 'LARISA', 191, 'https://floridagators.com/images/2018/10/4/FLORIDA_HUDSON_JALEN_3.jpg'),
('Charitopoulos Dimitris', 'Center', 'IRAKLIS', 192, 'https://bit.ly/3xxGSAp'),
('Chtatzidakis Manolis', 'Center', 'KOLOSSOS H HOTELS', 193, 'https://www.kolossosbc.gr/Images/FoT0s/2105.jpg'),
('Chatzikyriakos Yiorgos', 'Shooting Guard', 'IONIKOS BASKET', 194, 'http://www.esake.gr/dat/resize/esakeplayer/19474713/photo_7C7F42E2.jpg'),
('Henry Myke', 'Point Guard', 'IRAKLIS', 195, 'https://on.nba.com/3QcY0CP'),
('Chougkaz Nikos', 'Power Forward', 'PANATHINAIKOS OPAP', 196, 'https://bit.ly/3tsn7aX'),
('Christodoulou Andreas', 'Point Guard', 'PAOK mateco', 197, 'https://bit.ly/3NEwfS5');

-- --------------------------------------------------------

--
-- Table structure for table `player_game_stat_card`
--

CREATE TABLE `player_game_stat_card` (
  `game_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  `game_week_number` int(11) NOT NULL,
  `player_stat_card_id` int(11) NOT NULL,
  `player_name` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  `time_played` int(11) NOT NULL DEFAULT 0,
  `points` int(11) NOT NULL DEFAULT 0,
  `made2p` int(11) NOT NULL DEFAULT 0,
  `attempted2p` int(11) NOT NULL DEFAULT 0,
  `made3p` int(11) NOT NULL DEFAULT 0,
  `attempted3p` int(11) NOT NULL DEFAULT 0,
  `madeft` int(11) NOT NULL DEFAULT 0,
  `attemptedft` int(11) NOT NULL DEFAULT 0,
  `off_rebs` int(11) NOT NULL DEFAULT 0,
  `def_rebs` int(11) NOT NULL DEFAULT 0,
  `assist` int(11) NOT NULL DEFAULT 0,
  `blocks` int(11) NOT NULL DEFAULT 0,
  `blocks_on` int(11) NOT NULL DEFAULT 0,
  `steals` int(11) NOT NULL DEFAULT 0,
  `turnovers` int(11) NOT NULL DEFAULT 0,
  `fouls_commited` int(11) NOT NULL DEFAULT 0,
  `fouls_drawn` int(11) NOT NULL DEFAULT 0,
  `shots_rejected` int(11) NOT NULL DEFAULT 0,
  `tendex` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `player_game_stat_card`
--

INSERT INTO `player_game_stat_card` (`game_id`, `player_id`, `game_week_number`, `player_stat_card_id`, `player_name`, `position`, `time_played`, `points`, `made2p`, `attempted2p`, `made3p`, `attempted3p`, `madeft`, `attemptedft`, `off_rebs`, `def_rebs`, `assist`, `blocks`, `blocks_on`, `steals`, `turnovers`, `fouls_commited`, `fouls_drawn`, `shots_rejected`, `tendex`) VALUES
(1, 1, 1, 1, 'Avdalas Ioannis', 'Small Forward', 0, 125, 4, 27, 0, 1, 1, 2, 3, 5, 1, 0, 0, 1, 1, 4, 1, 2, 223),
(1, 2, 1, 2, 'Avdalas Neoklis', 'Point Guard', 0, 0, 5, 44, 0, 0, 3, 3, 3, 3, 1, 0, 1, 1, 2, 8, 2, 2, -2),
(1, 17, 1, 17, 'Gerokostas Nikolaos', 'Power Forward', 0, 175, 5, 48, 0, 0, 3, 3, 3, 4, 2, 1, 1, 5, 7, 4, 3, 3, 302),
(1, 33, 1, 33, 'Deimezis Dimitrios', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(1, 34, 1, 34, 'Dimou Emmanouil', 'Shooting Guard', 0, 0, 0, 6, 2, 7, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 4, -2),
(1, 37, 1, 37, 'Evans Jeremy', 'Power Forward', 0, 0, 3, 25, 3, 17, 1, 2, 1, 2, 1, 0, 0, 1, 1, 3, 2, 3, -2),
(1, 38, 1, 38, 'Evstathiou Simeon', 'Small Forward', 0, 0, 2, 22, 18, 55, 3, 5, 3, 7, 9, 0, 1, 3, 6, 7, 6, 3, -2),
(1, 44, 1, 44, 'Kavvadas Vasilis', 'Center', 0, 0, 15, 131, 0, 2, 10, 16, 8, 16, 2, 1, 1, 3, 5, 8, 13, 4, -2),
(1, 47, 1, 47, 'Kamaras Nikos', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(1, 52, 1, 52, 'Cowan Anthony Jr.', 'Shooting Guard', 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(1, 53, 1, 53, 'Karayiannis Konstantinos', 'Center', 0, 0, 5, 48, 10, 42, 1, 2, 2, 9, 3, 0, 1, 1, 3, 4, 2, 3, -2),
(1, 57, 1, 57, 'Kaselakis Leonidas', 'Power Forward', 0, 0, 1, 4, 8, 13, 0, 1, 1, 2, 0, 0, 0, 0, 1, 2, 1, 1, -2),
(1, 58, 1, 58, 'Kelly James', 'Center', 0, 0, 6, 69, 16, 46, 7, 8, 6, 10, 4, 1, 2, 2, 4, 8, 8, 4, -2),
(1, 68, 1, 68, 'Kottas Thomas', 'Center', 0, 0, 10, 77, 0, 0, 4, 7, 6, 10, 6, 3, 0, 1, 3, 5, 9, 3, -2),
(1, 70, 1, 70, 'Lampropoulos Konstantinos', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(1, 77, 1, 77, 'Lockett Eric', 'Power Forward', 0, 0, 1, 16, 1, 6, 1, 1, 1, 1, 3, 0, 1, 1, 1, 1, 2, 3, -2),
(1, 83, 1, 83, 'Mantzoukas Lefteris', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(1, 90, 1, 90, 'Macon Daryl', 'Shooting Guard', 0, 0, 4, 45, 29, 67, 6, 6, 1, 5, 7, 0, 1, 1, 5, 10, 7, 4, -2),
(1, 105, 1, 105, 'Bokhoridis Eleftherios', 'Point Guard', 0, 0, 10, 108, 23, 93, 11, 14, 1, 11, 25, 0, 2, 4, 14, 11, 17, 5, -2),
(1, 106, 1, 106, 'Nedović Nemanja ', 'Shooting Guard', 0, 0, 7, 58, 0, 0, 5, 7, 5, 9, 2, 2, 0, 2, 3, 6, 7, 2, -2),
(1, 108, 1, 108, 'Netzipoglou Omiros', 'Point Guard', 0, 0, 7, 65, 8, 28, 2, 3, 2, 7, 4, 1, 1, 5, 4, 9, 3, 4, -2),
(1, 120, 1, 120, 'White Okaro', 'Power Forward', 0, 0, 9, 88, 9, 33, 7, 8, 3, 10, 4, 1, 1, 3, 9, 7, 7, 5, -2),
(1, 121, 1, 121, 'Williams Xeyrius ', 'Power Forward', 0, 0, 3, 26, 0, 0, 1, 2, 3, 3, 1, 1, 1, 1, 1, 4, 2, 2, -2),
(1, 124, 1, 124, 'Papayiannis Yiorgos', 'Center', 0, 0, 5, 57, 15, 48, 5, 6, 3, 10, 6, 1, 0, 4, 3, 12, 9, 4, -2),
(1, 128, 1, 128, 'Papapetrou Ioannis', 'Small Forward', 0, 0, 3, 25, 0, 0, 1, 1, 2, 2, 0, 1, 0, 1, 2, 3, 1, 1, -2),
(1, 131, 1, 131, 'Perry Kendrick', 'Point Guard', 0, 0, 1, 6, 0, 4, 1, 1, 1, 2, 1, 0, 0, 0, 1, 2, 1, 2, -2),
(1, 134, 1, 134, 'Petanidis Kiriakos', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(1, 140, 1, 140, 'Poulianitis Stelios', 'Point Guard', 0, 0, 8, 98, 14, 48, 6, 9, 3, 12, 19, 0, 2, 3, 8, 10, 16, 4, -2),
(1, 152, 1, 152, 'Sant-Roos Howard ', 'small Forward', 0, 0, 1, 13, 0, 4, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 2, -2),
(1, 156, 1, 156, 'Siva Peyton', 'Shooting Guard', 0, 0, 2, 22, 5, 28, 3, 4, 1, 2, 3, 0, 0, 1, 1, 5, 4, 3, -2),
(1, 157, 1, 157, 'Sidiroilias Yiannis', 'Power Forward', 0, 0, 5, 49, 19, 52, 3, 4, 1, 6, 8, 0, 1, 5, 7, 9, 7, 3, -2),
(1, 166, 1, 166, 'Schizas Stavros', 'Point Guard', 0, 0, 5, 46, 7, 24, 2, 3, 1, 4, 3, 0, 1, 1, 1, 6, 3, 2, -2),
(1, 171, 1, 171, 'Juiston Shakur', 'Small Forward', 0, 0, 3, 32, 17, 48, 3, 5, 2, 5, 9, 0, 1, 2, 6, 5, 7, 4, -2),
(1, 176, 1, 176, 'Tsachtsiras Philippos', 'Small Forward', 0, 0, 9, 83, 28, 77, 9, 11, 1, 7, 15, 0, 1, 3, 7, 8, 11, 4, -2),
(1, 185, 1, 185, 'Fridas Lampros', 'Point Guard', 0, 0, 10, 68, 0, 0, 4, 5, 6, 6, 1, 3, 1, 3, 2, 8, 5, 2, -2),
(1, 186, 1, 186, 'Chavales Stelios', 'small Forward', 0, 0, 0, 3, 3, 8, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, -2),
(1, 189, 1, 189, 'Hanlan Olivier', 'Point Guard', 0, 0, 12, 94, 3, 8, 9, 12, 4, 12, 2, 2, 1, 2, 4, 6, 11, 5, -2),
(1, 196, 1, 196, 'Chougkaz Nikos', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(2, 5, 1, 5, 'Athinaiou Ioannis', 'Shooting Guard', 0, 0, 1, 14, 3, 16, 1, 1, 2, 4, 1, 0, 0, 1, 1, 3, 1, 3, -2),
(2, 10, 1, 10, 'Arsenopoulos Nikos ', 'Point Guard', 0, 0, 17, 122, 0, 1, 3, 4, 8, 20, 5, 6, 1, 2, 4, 6, 6, 5, -2),
(2, 22, 1, 22, 'Giouzelis Yiorgos', 'Small Forward', 0, 0, 8, 77, 14, 46, 7, 9, 4, 15, 11, 1, 1, 3, 5, 9, 10, 4, -2),
(2, 28, 1, 28, 'Griffin Dayon', 'Point Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(2, 30, 1, 30, 'Gontikas Costis', 'Point Guard', 0, 0, 0, 5, 0, 6, 1, 1, 1, 2, 0, 0, 0, 0, 0, 1, 1, 2, -2),
(2, 35, 1, 35, 'Diamantakos Yiorgos', 'Center', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(2, 36, 1, 36, 'Diplaros Nikos', 'Shooting Guard', 0, 0, 4, 26, 1, 3, 1, 1, 2, 3, 1, 1, 1, 1, 2, 3, 2, 3, -2),
(2, 43, 1, 43, 'Zoumpos Fotis', 'Point Guard', 0, 0, 1, 10, 9, 23, 2, 2, 0, 1, 3, 0, 0, 1, 2, 2, 2, 3, -2),
(2, 59, 1, 59, 'Koyonis Yiorgos', 'Small Forward', 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -2),
(2, 60, 1, 60, 'Koloveros Iosif', 'Point Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(2, 64, 1, 64, 'Coleman Orlando', 'Small Forward', 0, 0, 1, 17, 13, 29, 1, 2, 1, 5, 1, 1, 0, 1, 2, 3, 1, 3, -2),
(2, 71, 1, 71, 'Langford Kevin', 'Power Forward', 0, 0, 15, 113, 5, 17, 5, 8, 11, 19, 4, 2, 0, 6, 5, 11, 6, 4, -2),
(2, 80, 1, 80, 'McLaffin Jeremy', 'Center', 0, 0, 2, 29, 5, 16, 1, 3, 3, 4, 1, 1, 1, 0, 1, 3, 3, 3, -2),
(2, 81, 1, 81, 'McLean Tre', 'Small Forward', 0, 0, 1, 8, 14, 35, 1, 1, 1, 2, 1, 0, 1, 1, 1, 5, 1, 3, -2),
(2, 88, 1, 88, 'Mavrokefalidis Loukas', 'Center', 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(2, 91, 1, 91, 'Mitrou-Long Elijah', 'Point Guard', 0, 0, 4, 40, 20, 73, 4, 5, 1, 6, 8, 0, 1, 1, 6, 7, 8, 3, -2),
(2, 94, 1, 94, 'Molfetas Yiannis', 'Point Guard', 0, 0, 15, 111, 26, 68, 7, 9, 7, 17, 6, 2, 1, 3, 2, 4, 9, 4, -2),
(2, 96, 1, 96, 'Moses Kingsley', 'Center', 0, 0, 1, 8, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 2, -2),
(2, 100, 1, 100, 'Mustafa Muhaymin ', 'Shooting Guard', 0, 0, 2, 21, 28, 88, 7, 8, 2, 7, 13, 0, 0, 3, 7, 10, 11, 4, -2),
(2, 104, 1, 104, 'Borgis Yiorgos', 'Center', 0, 0, 6, 57, 28, 79, 4, 5, 2, 8, 9, 0, 0, 4, 5, 6, 6, 6, -2),
(2, 110, 1, 110, 'Davis Mike', 'Shooting Guard', 0, 0, 7, 63, 13, 60, 4, 7, 3, 11, 5, 1, 1, 4, 5, 9, 7, 5, -2),
(2, 111, 1, 111, 'Davis Dejon', 'Power Forward', 0, 0, 0, 6, 4, 7, 0, 0, 0, 1, 2, 0, 0, 0, 1, 2, 1, 3, -2),
(2, 119, 1, 119, 'Owens Josh', 'Center', 0, 0, 1, 8, 2, 6, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, -2),
(2, 129, 1, 129, 'Papafotiou Fotis', 'Power Forward', 0, 0, 3, 32, 3, 15, 3, 4, 4, 5, 2, 1, 1, 1, 1, 5, 4, 1, -2),
(2, 144, 1, 144, 'Rice Rayvonte ', 'Power Forward', 0, 0, 0, 2, 0, 3, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, -2),
(2, 158, 1, 158, 'Simons Gerel', 'Shooting Guard', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(2, 170, 1, 170, 'Tzolos Vangelis', 'Point Guard', 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, -2),
(2, 174, 1, 174, 'Tumba Kevin', 'Center', 0, 0, 6, 57, 23, 68, 3, 4, 3, 13, 8, 1, 1, 2, 5, 3, 6, 6, -2),
(2, 175, 1, 175, 'Tsalmpouris Yiorgos', 'Center', 0, 0, 6, 50, 41, 109, 6, 7, 1, 5, 8, 0, 0, 2, 4, 6, 8, 4, -2),
(2, 178, 1, 178, 'Tsiakmas Nikos', 'Shooting Guard', 0, 0, 13, 129, 0, 1, 9, 13, 7, 14, 4, 3, 1, 1, 5, 8, 11, 4, -2),
(2, 188, 1, 188, 'Hamilton Daniel', 'small Forward', 0, 0, 1, 16, 8, 24, 4, 4, 1, 3, 2, 0, 0, 0, 1, 2, 2, 3, -2),
(2, 194, 1, 194, 'Chatzikyriakos Yiorgos', 'Shooting Guard', 0, 0, 7, 61, 15, 34, 3, 5, 2, 6, 2, 0, 1, 2, 3, 2, 5, 5, -2),
(3, 7, 1, 7, 'Braian Angola', 'Shooting Guard', 4, 0, 4, 38, 38, 98, 7, 7, 3, 13, 3, 0, 0, 3, 3, 10, 8, 4, -2),
(3, 13, 1, 13, 'Vezenkof Alexander ', 'Power Forward', 1, 0, 1, 17, 7, 20, 1, 1, 0, 1, 4, 0, 0, 0, 2, 2, 1, 4, -2),
(3, 26, 1, 26, 'Griffin Eric ', 'Center', 2, 0, 12, 108, 4, 21, 5, 9, 5, 14, 4, 1, 1, 3, 6, 7, 8, 5, -2),
(3, 29, 1, 29, 'Gogolos Sotiris', 'Point Guard', 1, 0, 0, 4, 2, 10, 1, 2, 0, 1, 1, 0, 0, 1, 1, 1, 2, 2, -2),
(3, 32, 1, 32, 'Walkup Thomas ', 'Shooting Guard', 4, 0, 4, 33, 3, 6, 2, 3, 3, 5, 2, 1, 0, 2, 2, 6, 2, 2, -2),
(3, 40, 1, 40, 'Quincy Jyrome Acy', 'Power Forward', 1, 0, 2, 13, 0, 0, 0, 1, 1, 3, 0, 1, 0, 1, 1, 1, 1, 4, -2),
(3, 41, 1, 41, 'Livio Jean-Charles', 'Power Forward', 2, 0, 5, 41, 23, 58, 3, 4, 1, 7, 3, 1, 1, 2, 2, 5, 4, 5, -2),
(3, 55, 1, 55, 'Karlis Manolis', 'Point Guard', 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, -2),
(3, 56, 1, 56, 'Karlis Michalis', 'Shooting Guard', 1, 0, 1, 10, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 3, 1, 1, -2),
(3, 61, 1, 61, 'Colom Quino', 'Shooting Guard', 3, 0, 1, 7, 2, 13, 0, 1, 0, 3, 4, 0, 0, 0, 3, 3, 2, 1, -2),
(3, 63, 1, 63, 'Koniaris Antonis', 'Point Guard', 1, 0, 2, 13, 0, 0, 0, 1, 2, 2, 0, 0, 1, 0, 1, 1, 1, 3, -2),
(3, 65, 1, 65, 'Kouzeloglou Yiannis', 'Small Forward', 2, 0, 1, 13, 10, 21, 0, 0, 0, 3, 2, 0, 0, 1, 1, 4, 1, 2, -2),
(3, 72, 1, 72, 'Langford Keith', 'Shooting Guard', 3, 0, 7, 68, 16, 52, 5, 7, 4, 15, 3, 1, 1, 3, 4, 8, 7, 4, -2),
(3, 73, 1, 73, 'Larentzakis Yiannoulis', 'Point Guard', 4, 0, 16, 158, 18, 60, 12, 16, 4, 18, 4, 2, 3, 3, 10, 8, 13, 5, -2),
(3, 78, 1, 78, 'Lountzis Michalis', 'Shooting Guard', 3, 0, 3, 34, 15, 52, 5, 7, 1, 4, 8, 0, 0, 2, 5, 7, 7, 4, -2),
(3, 79, 1, 79, 'McKissic Shaquielle ', 'Power Forward', 4, 0, 9, 101, 0, 3, 10, 16, 6, 6, 4, 1, 2, 2, 6, 11, 17, 3, -2),
(3, 86, 1, 86, 'Martin Hassan', 'Center', 4, 0, 4, 31, 13, 32, 4, 6, 2, 6, 7, 1, 0, 3, 3, 4, 7, 2, -2),
(3, 87, 1, 87, 'Mavridis Dimitris', 'Center', 3, 0, 2, 13, 11, 22, 1, 1, 0, 1, 3, 0, 0, 1, 2, 4, 2, 2, -2),
(3, 97, 1, 97, 'Mouzourakis Odysseas', 'Center', 4, 0, 10, 88, 11, 48, 10, 14, 6, 19, 4, 1, 1, 1, 6, 8, 11, 4, -2),
(3, 114, 1, 114, 'Dorsey Tyler', 'Point Guard', 4, 0, 9, 77, 0, 0, 3, 10, 10, 18, 1, 3, 1, 2, 4, 8, 8, 3, -2),
(3, 118, 1, 118, 'Oikonomopoulos Sotiris', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(3, 126, 1, 126, 'Papanikolaou Kostas', 'Small Forward', 2, 0, 2, 13, 2, 5, 1, 1, 1, 3, 0, 0, 0, 1, 1, 1, 1, 2, -2),
(3, 130, 1, 130, 'Pappas Nikos', 'Point Guard', 2, 0, 9, 68, 18, 43, 3, 4, 1, 5, 5, 0, 1, 2, 3, 3, 6, 5, -2),
(3, 135, 1, 135, 'Petropoulos Andreas', 'Point Guard', 1, 0, 0, 8, 1, 8, 0, 1, 0, 1, 1, 0, 0, 1, 1, 2, 1, 2, -2),
(3, 142, 1, 142, 'Printezis Yiorgos', 'Power Forward', 4, 0, 4, 42, 13, 41, 2, 3, 3, 9, 7, 1, 0, 2, 2, 8, 5, 3, -2),
(3, 143, 1, 143, 'Rautins Andy', 'Point Guard', 3, 0, 7, 68, 23, 54, 5, 6, 3, 7, 6, 1, 1, 1, 5, 5, 7, 4, -2),
(3, 154, 1, 154, 'Saxionis Konstantinos', 'Point Guard', 1, 0, 1, 9, 1, 5, 0, 0, 0, 1, 2, 0, 0, 1, 1, 1, 0, 2, -2),
(3, 162, 1, 162, 'Sloukas Kostas', 'Shooting Guard', 0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, -2),
(3, 179, 1, 179, 'Fall Moustapha', 'Center', 2, 0, 3, 48, 31, 67, 3, 3, 3, 5, 3, 0, 1, 2, 3, 5, 5, 5, -2),
(3, 180, 1, 180, 'Filippakos Panayiotis', 'Power Forward', 2, 0, 5, 48, 15, 49, 4, 5, 2, 3, 4, 0, 1, 1, 2, 4, 6, 5, -2),
(3, 183, 1, 183, 'Flionis Dimitris', 'Point Guard', 4, 0, 11, 106, 30, 90, 6, 8, 1, 11, 6, 2, 0, 3, 7, 10, 6, 4, -2),
(3, 187, 1, 187, 'Hummer Ian', 'Power Forward', 1, 0, 1, 8, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(4, 3, 1, 3, 'Agravanis Ioannis', 'Small Forward', 4, 0, 5, 43, 13, 53, 4, 5, 1, 10, 15, 0, 1, 5, 5, 9, 7, 3, -2),
(4, 4, 1, 4, 'Agravanis Dimitris', 'Power Forward', 1, 0, 0, 3, 2, 4, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 2, -2),
(4, 8, 1, 8, 'Mihajlo Andrić', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(4, 9, 1, 9, 'Argyroulis Panagiotis', 'Shooting Guard', 4, 0, 4, 32, 40, 85, 5, 6, 1, 7, 10, 0, 0, 4, 4, 8, 7, 3, -2),
(4, 12, 1, 12, 'Vasileiou Nikos', 'Shooting Guard', 3, 0, 7, 53, 24, 57, 4, 6, 1, 6, 6, 0, 0, 4, 5, 4, 6, 3, -2),
(4, 20, 1, 20, 'Garet Branton', 'Center', 4, 0, 6, 70, 4, 38, 6, 9, 5, 10, 3, 1, 1, 4, 4, 9, 12, 3, -2),
(4, 21, 1, 21, 'Gkikas Nikos', 'Point Guard', 3, 0, 9, 100, 37, 96, 12, 15, 1, 8, 7, 0, 1, 2, 5, 7, 16, 6, -2),
(4, 23, 1, 23, 'Grant Tzerai', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -2),
(4, 31, 1, 31, 'Yints Keison', 'Point Guard', 3, 0, 8, 78, 1, 1, 3, 5, 7, 7, 3, 2, 1, 2, 4, 7, 5, 3, -2),
(4, 39, 1, 39, 'Abrams Jamar', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(4, 62, 1, 62, 'Komniadis Ioannis', 'Center', 3, 0, 6, 63, 28, 74, 5, 8, 1, 9, 12, 0, 1, 3, 6, 6, 9, 5, -2),
(4, 69, 1, 69, 'Layios Angelos', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(4, 74, 1, 74, 'Latos Ilias', 'Small Forward', 2, 0, 2, 28, 9, 33, 1, 2, 1, 3, 9, 1, 0, 3, 4, 5, 3, 4, -2),
(4, 89, 1, 89, 'Miles Isaiah', 'Small Forward', 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -2),
(4, 101, 1, 101, 'Bazinas Thanasis', 'Point Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(4, 107, 1, 107, 'Neofitos Yiorgos', 'Shooting Guard', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(4, 113, 1, 113, 'Dolezaj Marek ', 'Small Forward', 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(4, 125, 1, 125, 'Papadakis Kostas', 'Point Guard', 1, 0, 2, 15, 3, 10, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 4, -2),
(4, 133, 1, 133, 'Petanidis Yiorgos', 'Point Guard', 1, 0, 0, 9, 4, 6, 1, 1, 0, 1, 1, 0, 1, 1, 1, 3, 1, 1, -2),
(4, 138, 1, 138, 'Plotas Nikos', 'Shooting Guard', 3, 0, 2, 24, 22, 68, 5, 6, 1, 3, 7, 0, 1, 1, 3, 4, 6, 4, -2),
(4, 146, 1, 146, 'Ray Kendrick ', 'Point Guard', 1, 0, 3, 21, 0, 0, 1, 2, 3, 4, 2, 2, 0, 1, 2, 3, 2, 3, -2),
(4, 148, 1, 148, 'Rongavopoulos Nikos', 'Point Guard', 3, 0, 5, 51, 23, 72, 5, 7, 2, 9, 14, 0, 1, 4, 5, 8, 8, 4, -2),
(4, 149, 1, 149, 'Wroten Tony', 'Point Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(4, 159, 1, 159, 'Simpson Trevis', 'Power Forward', 0, 0, 0, 3, 0, 5, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 3, -2),
(4, 160, 1, 160, 'Skordilis Gaios', 'Center', 4, 0, 6, 80, 17, 39, 4, 6, 4, 12, 5, 1, 1, 4, 4, 8, 8, 3, -2),
(4, 165, 1, 165, 'Stamatis Dimitris', 'Point Guard', 1, 0, 1, 8, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, -2),
(4, 167, 1, 167, 'Tanoulis Yiorgos', 'Small Forward', 1, 0, 1, 9, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 2, 1, 3, -2),
(4, 169, 1, 169, 'Taylor Ryan ', 'Small Forward', 3, 0, 0, 8, 13, 47, 2, 4, 1, 3, 0, 0, 0, 2, 1, 5, 3, 2, -2),
(4, 181, 1, 181, 'Fillios Yiorgos', 'Shooting Guard', 2, 0, 5, 48, 10, 34, 3, 4, 1, 7, 4, 0, 1, 1, 2, 5, 4, 4, -2),
(4, 190, 1, 190, 'Hunt Dario', 'Center', 3, 0, 6, 58, 10, 33, 2, 3, 1, 5, 3, 1, 1, 1, 4, 6, 3, 3, -2),
(4, 192, 1, 192, 'Charitopoulos Dimitris', 'Center', 1, 0, 0, 2, 0, 2, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, -2),
(4, 195, 1, 195, 'Henry Myke', 'Point Guard', 1, 0, 0, 1, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(5, 11, 1, 11, 'Asteriadis Asterios', 'Shooting Guard', 0, 0, 2, 13, 6, 13, 1, 1, 0, 3, 3, 0, 0, 0, 1, 2, 1, 3, -2),
(5, 14, 1, 14, 'Vissariou Tilemakhos', 'Point Guard', 0, 0, 9, 105, 1, 4, 4, 6, 7, 8, 1, 3, 2, 2, 4, 7, 6, 4, -2),
(5, 24, 1, 24, 'Green Devonte', 'Shooting Guard', 0, 0, 1, 8, 11, 24, 1, 1, 0, 1, 1, 0, 0, 1, 1, 3, 2, 3, -2),
(5, 42, 1, 42, 'Zaras Theodoros', 'Shooting Guard', 0, 0, 2, 13, 2, 12, 2, 2, 0, 2, 2, 0, 0, 1, 3, 1, 2, 4, -2),
(5, 51, 1, 51, 'Kampouris Nikos', 'Center', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(5, 54, 1, 54, 'Karampelas Zois', 'Shooting Guard', 0, 0, 0, 6, 2, 4, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, -2),
(5, 66, 1, 66, 'Krubally Ousman', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(5, 84, 1, 84, 'Margaritis Vangelis', 'Small Forward', 0, 0, 1, 8, 0, 2, 0, 0, 1, 2, 0, 0, 0, 1, 0, 3, 1, 1, -2),
(5, 85, 1, 85, 'Marić Marin', 'Center', 0, 0, 11, 139, 23, 62, 15, 17, 1, 7, 8, 1, 3, 3, 10, 6, 14, 4, -2),
(5, 92, 1, 92, 'Miller Shonn', 'Small Forward', 0, 0, 0, 8, 6, 20, 0, 0, 1, 2, 2, 0, 0, 1, 2, 3, 2, 3, -2),
(5, 93, 1, 93, 'Mirosavich Angelos', 'Shooting Guard', 0, 0, 2, 23, 13, 28, 2, 3, 3, 3, 2, 0, 1, 1, 1, 5, 4, 3, -2),
(5, 95, 1, 95, 'Momirov Stefan ', 'Point Guard', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(5, 98, 1, 98, 'Moody Stefan ', 'Shooting Guard', 0, 0, 1, 12, 5, 19, 1, 1, 1, 4, 3, 0, 0, 1, 1, 5, 2, 2, -2),
(5, 102, 1, 102, 'Bazinas Yianis', 'Power Forward', 0, 0, 0, 4, 3, 13, 1, 1, 1, 2, 0, 0, 0, 0, 1, 2, 1, 1, -2),
(5, 103, 1, 103, 'Billis Sotiris', 'Small Forward', 0, 0, 1, 3, 1, 4, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, -2),
(5, 115, 1, 115, 'Xanthopoulos Vasilis', 'Point Guard', 0, 0, 0, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, -2),
(5, 117, 1, 117, 'Oikonomopoulos Konstantinos', 'Shooting Guard', 0, 0, 8, 55, 9, 23, 3, 4, 5, 10, 4, 2, 0, 2, 3, 4, 4, 3, -2),
(5, 122, 1, 122, 'Williams Kenny ', 'Shooting Guard', 0, 0, 1, 17, 20, 42, 1, 2, 1, 5, 5, 0, 0, 2, 3, 7, 3, 3, -2),
(5, 127, 1, 127, 'Papantoniou Nontas', 'Shooting Guard', 0, 0, 4, 42, 28, 88, 3, 4, 5, 9, 5, 0, 0, 4, 3, 8, 5, 4, -2),
(5, 139, 1, 139, 'Pot Stefan', 'Shooting Guard', 0, 0, 0, 3, 1, 5, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 3, -2),
(5, 141, 1, 141, 'Prapas Stergios', 'Shooting Guard', 0, 0, 4, 49, 16, 41, 2, 3, 0, 3, 4, 0, 1, 2, 3, 3, 4, 4, -2),
(5, 155, 1, 155, 'Sachpatzidis Yiannis', 'Center', 0, 0, 1, 5, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 2, 1, 1, -2),
(5, 161, 1, 161, 'Slaftsakis Diamantis', 'Small Forward', 0, 0, 10, 83, 19, 65, 6, 9, 9, 14, 3, 2, 1, 1, 3, 9, 7, 4, -2),
(5, 164, 1, 164, 'Spiropoulos Anastasios', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(5, 172, 1, 172, 'Tillie Kim', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(5, 177, 1, 177, 'Tsairelis Mikhalis', 'Small Forward', 0, 0, 6, 58, 6, 26, 4, 5, 1, 2, 3, 1, 1, 1, 4, 4, 6, 3, -2),
(5, 184, 1, 184, 'Floyd Jordan', 'Shooting Guard', 0, 0, 1, 13, 0, 7, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 3, -2),
(5, 191, 1, 191, 'Hudson Jalen ', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(5, 193, 1, 193, 'Chtatzidakis Manolis', 'Center', 0, 0, 8, 72, 3, 14, 3, 5, 5, 7, 2, 3, 1, 3, 2, 7, 5, 2, -2),
(6, 6, 1, 6, 'Aminou Al Ouazint', 'Center', 1, 0, 1, 5, 3, 6, 1, 2, 0, 1, 1, 0, 0, 1, 1, 1, 1, 3, -2),
(6, 15, 1, 15, 'Von Rasant', 'Small Forward', 2, 0, 1, 9, 32, 79, 0, 1, 1, 4, 2, 0, 1, 1, 3, 6, 3, 5, -2),
(6, 16, 1, 16, 'Voulgaropoulos Stratos', 'Center', 4, 0, 14, 133, 37, 123, 10, 13, 5, 18, 4, 3, 2, 2, 7, 8, 13, 5, -2),
(6, 18, 1, 18, 'Geromikhalos Petros', 'Small Forward', 3, 0, 14, 112, 13, 45, 8, 13, 6, 16, 7, 1, 1, 4, 5, 6, 12, 4, -2),
(6, 19, 1, 19, 'Yankovits Vladimiros ', 'Small Forward', 3, 0, 12, 88, 0, 0, 4, 8, 5, 9, 4, 3, 1, 1, 5, 8, 7, 3, -2),
(6, 25, 1, 25, 'Greene Phil ', 'Shooting Guard', 4, 0, 6, 53, 14, 39, 2, 3, 3, 10, 5, 0, 0, 1, 3, 5, 4, 3, -2),
(6, 27, 1, 27, 'Griffin Malcolm ', 'Point Guard', 3, 0, 2, 19, 6, 16, 1, 1, 2, 3, 1, 0, 0, 1, 2, 3, 1, 1, -2),
(6, 45, 1, 45, 'Kaklamanakis Dimitris', 'Center', 4, 0, 3, 31, 18, 58, 2, 3, 5, 8, 2, 0, 1, 3, 3, 8, 3, 3, -2),
(6, 46, 1, 46, 'Kalliontzis Stratos', 'Power Forward', 4, 0, 7, 73, 37, 110, 2, 4, 5, 13, 3, 2, 1, 3, 5, 11, 4, 5, -2),
(6, 48, 1, 48, 'Kamarianos Nikolaos', 'Small Forward', 3, 0, 5, 48, 14, 44, 4, 5, 1, 5, 4, 0, 0, 2, 2, 6, 5, 4, -2),
(6, 49, 1, 49, 'Kamperidis Yiorgos', 'Power Forward', 2, 0, 12, 103, 1, 8, 8, 11, 7, 8, 4, 1, 1, 1, 4, 7, 9, 4, -2),
(6, 50, 1, 50, 'Kamperidis Michalis', 'Small Forward', 4, 0, 5, 58, 15, 38, 2, 3, 1, 6, 10, 0, 1, 2, 6, 9, 6, 4, -2),
(6, 67, 1, 67, 'Konstandinidis Theodoros', 'Point Guard', 2, 0, 3, 30, 18, 41, 3, 3, 1, 6, 3, 0, 1, 2, 2, 5, 3, 4, -2),
(6, 75, 1, 75, 'Lee Anthony ', 'Small Forward', 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(6, 76, 1, 76, 'Love Jermaine ', 'Point Guard', 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(6, 82, 1, 82, 'Mantzaris Vangelis', 'Point Guard', 1, 0, 3, 43, 7, 21, 1, 2, 1, 2, 5, 0, 1, 1, 4, 4, 2, 4, -2),
(6, 99, 1, 99, 'Mouratos Vasilis', 'Point Guard', 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(6, 109, 1, 109, 'Nikolaidis Alexandros', 'Point Guard', 2, 0, 1, 8, 1, 3, 0, 0, 1, 2, 1, 0, 0, 0, 2, 3, 0, 1, -2),
(6, 112, 1, 112, 'DiLeo David', 'Small Forward', 1, 0, 6, 50, 4, 14, 5, 6, 2, 6, 3, 0, 1, 1, 3, 3, 5, 5, -2),
(6, 116, 1, 116, 'Ogbeide Derek', 'Center', 3, 0, 1, 8, 3, 9, 0, 0, 1, 2, 0, 0, 0, 0, 0, 2, 0, 1, -2),
(6, 123, 1, 123, 'Williams Matt Junior', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(6, 132, 1, 132, 'Persidis Nikolaos', 'Small Forward', 3, 0, 4, 28, 13, 38, 3, 4, 2, 6, 6, 1, 0, 2, 4, 7, 6, 3, -2),
(6, 136, 1, 136, 'Pilavios Alfis', 'Power Forward', 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(6, 137, 1, 137, 'Pippen Danny', 'Small Forward', 1, 0, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(6, 145, 1, 145, 'Renfro Nate ', 'Power Forward', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(6, 147, 1, 147, 'Rivers Dimitri', 'Small Forward', 4, 0, 5, 64, 24, 63, 10, 11, 1, 5, 18, 0, 0, 4, 7, 4, 12, 4, -2),
(6, 150, 1, 150, 'Roumoglou Apostolos', 'Shooting Guard', 3, 0, 4, 37, 22, 58, 2, 3, 1, 3, 2, 1, 1, 2, 2, 6, 2, 3, -2),
(6, 151, 1, 151, 'Savage Jared', 'Power Forward', 1, 0, 1, 4, 1, 6, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 2, -2),
(6, 153, 1, 153, 'Sanders Corey', 'Point Guard', 3, 0, 3, 28, 17, 37, 1, 2, 3, 9, 2, 0, 0, 2, 2, 6, 4, 3, -2),
(6, 163, 1, 163, 'Sprintzios Michalis', 'Small Forward', 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, -2),
(6, 168, 1, 168, 'Tachiridis Prodromos', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(6, 173, 1, 173, 'Toliopoulos Vasilis', 'Shooting Guard', 1, 0, 2, 25, 9, 20, 2, 2, 1, 2, 2, 0, 0, 1, 2, 2, 2, 5, -2),
(6, 182, 1, 182, 'Filoxhenidis Kostas', 'Point Guard', 3, 0, 9, 89, 13, 38, 7, 10, 2, 7, 8, 0, 1, 5, 6, 7, 9, 4, -2),
(6, 197, 1, 197, 'Christodoulou Andreas', 'Point Guard', 1, 0, 5, 45, 1, 2, 2, 2, 3, 3, 1, 4, 0, 1, 3, 3, 3, 4, -2),
(7, 6, 2, 6, 'Aminou Al Ouazint', 'Center', 2, 0, 2, 3, 2, 4, 3, 5, 0, 3, 2, 0, 0, 2, 3, 3, 3, 10, -2),
(7, 13, 2, 13, 'Vezenkof Alexander ', 'Power Forward', 4, 0, 3, 10, 4, 12, 2, 2, 1, 4, 11, 1, 1, 1, 5, 7, 2, 12, -2),
(7, 15, 2, 15, 'Von Rasant', 'Small Forward', 7, 0, 3, 6, 19, 48, 1, 2, 2, 13, 7, 1, 2, 4, 9, 17, 8, 14, -2),
(7, 16, 2, 16, 'Voulgaropoulos Stratos', 'Center', 11, 0, 42, 80, 22, 74, 29, 39, 14, 53, 13, 9, 5, 7, 21, 25, 40, 16, -2),
(7, 18, 2, 18, 'Geromikhalos Petros', 'Small Forward', 10, 0, 43, 67, 8, 27, 23, 38, 19, 47, 22, 4, 4, 11, 14, 19, 36, 12, -2),
(7, 32, 2, 32, 'Walkup Thomas ', 'Shooting Guard', 11, 0, 12, 20, 2, 4, 5, 8, 9, 16, 7, 3, 1, 7, 7, 18, 7, 5, -2),
(7, 40, 2, 40, 'Quincy Jyrome Acy', 'Power Forward', 2, 0, 6, 8, 0, 0, 1, 4, 3, 8, 1, 3, 0, 3, 2, 4, 3, 11, -2),
(7, 41, 2, 41, 'Livio Jean-Charles', 'Power Forward', 7, 0, 14, 25, 14, 35, 10, 13, 4, 20, 10, 2, 3, 7, 5, 15, 13, 15, -2),
(7, 45, 2, 45, 'Kaklamanakis Dimitris', 'Center', 11, 0, 10, 19, 11, 35, 7, 10, 16, 23, 5, 1, 2, 9, 8, 25, 10, 9, -2),
(7, 73, 2, 73, 'Larentzakis Yiannoulis', 'Point Guard', 11, 0, 48, 95, 11, 36, 35, 49, 13, 55, 12, 7, 10, 10, 29, 25, 38, 15, -2),
(7, 78, 2, 78, 'Lountzis Michalis', 'Shooting Guard', 9, 0, 10, 21, 9, 31, 16, 20, 2, 13, 23, 1, 1, 6, 15, 21, 22, 12, -2),
(7, 79, 2, 79, 'McKissic Shaquielle ', 'Power Forward', 11, 0, 26, 61, 0, 2, 31, 49, 17, 19, 11, 4, 6, 6, 17, 34, 50, 10, -2),
(7, 86, 2, 86, 'Martin Hassan', 'Center', 11, 0, 11, 19, 8, 19, 13, 17, 5, 17, 20, 2, 1, 8, 10, 12, 22, 7, -2),
(7, 99, 2, 99, 'Mouratos Vasilis', 'Point Guard', 2, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 2, -2),
(7, 109, 2, 109, 'Nikolaidis Alexandros', 'Point Guard', 6, 0, 3, 5, 1, 2, 1, 1, 3, 5, 2, 0, 0, 1, 5, 9, 1, 4, -2),
(7, 114, 2, 114, 'Dorsey Tyler', 'Point Guard', 11, 0, 26, 46, 0, 0, 10, 31, 30, 53, 4, 10, 4, 7, 11, 24, 25, 9, -2),
(7, 118, 2, 118, 'Oikonomopoulos Sotiris', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(7, 123, 2, 123, 'Williams Matt Junior', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(7, 126, 2, 126, 'Papanikolaou Kostas', 'Small Forward', 5, 0, 5, 8, 1, 3, 3, 3, 3, 8, 1, 1, 1, 3, 3, 4, 3, 6, -2),
(7, 132, 2, 132, 'Persidis Nikolaos', 'Small Forward', 10, 0, 11, 17, 8, 23, 10, 12, 5, 19, 19, 2, 0, 6, 11, 22, 18, 8, -2),
(7, 136, 2, 136, 'Pilavios Alfis', 'Power Forward', 2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, -2),
(7, 137, 2, 137, 'Pippen Danny', 'Small Forward', 2, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 2, -2),
(7, 142, 2, 142, 'Printezis Yiorgos', 'Power Forward', 11, 0, 13, 25, 8, 25, 6, 9, 9, 26, 20, 3, 1, 7, 7, 23, 15, 9, -2),
(7, 151, 2, 151, 'Savage Jared', 'Power Forward', 3, 0, 2, 3, 1, 4, 1, 1, 3, 3, 1, 0, 0, 0, 3, 4, 2, 6, -2),
(7, 153, 2, 153, 'Sanders Corey', 'Point Guard', 10, 0, 9, 17, 10, 22, 4, 7, 9, 26, 7, 0, 1, 7, 7, 19, 12, 8, -2),
(7, 162, 2, 162, 'Sloukas Kostas', 'Shooting Guard', 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 5, -2),
(7, 163, 2, 163, 'Sprintzios Michalis', 'Small Forward', 2, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 2, 0, 4, -2),
(7, 179, 2, 179, 'Fall Moustapha', 'Center', 7, 0, 10, 29, 19, 40, 9, 10, 8, 16, 8, 0, 2, 6, 8, 15, 14, 14, -2),
(7, 182, 2, 182, 'Filoxhenidis Kostas', 'Point Guard', 10, 0, 26, 54, 8, 23, 22, 30, 5, 21, 24, 1, 2, 14, 18, 22, 27, 13, -2),
(8, 1, 2, 1, 'Avdalas Ioannis', 'Small Forward', 0, 0, 11, 16, 0, 1, 2, 5, 8, 14, 3, 1, 1, 2, 4, 12, 4, 5, -2),
(8, 2, 2, 2, 'Avdalas Neoklis', 'Point Guard', 0, 0, 15, 27, 0, 0, 9, 10, 8, 8, 3, 0, 3, 4, 6, 25, 7, 5, -2),
(8, 9, 2, 9, 'Argyroulis Panagiotis', 'Shooting Guard', 11, 0, 13, 19, 24, 51, 15, 17, 2, 22, 30, 1, 0, 11, 13, 23, 20, 8, -2),
(8, 20, 2, 20, 'Garet Branton', 'Center', 11, 0, 17, 42, 3, 23, 19, 28, 14, 31, 9, 2, 2, 11, 11, 28, 35, 10, -2),
(8, 31, 2, 31, 'Yints Keison', 'Point Guard', 8, 0, 25, 47, 1, 1, 8, 14, 22, 22, 8, 6, 3, 6, 11, 20, 16, 9, -2),
(8, 33, 2, 33, 'Deimezis Dimitrios', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(8, 34, 2, 34, 'Dimou Emmanouil', 'Shooting Guard', 0, 0, 1, 4, 1, 4, 3, 3, 0, 1, 3, 0, 0, 1, 3, 2, 4, 12, -2),
(8, 37, 2, 37, 'Evans Jeremy', 'Power Forward', 0, 0, 10, 15, 2, 10, 2, 5, 4, 7, 2, 1, 0, 4, 4, 10, 6, 10, -2),
(8, 38, 2, 38, 'Evstathiou Simeon', 'Small Forward', 0, 0, 6, 13, 11, 33, 9, 16, 8, 22, 28, 0, 2, 8, 17, 21, 19, 8, -2),
(8, 39, 2, 39, 'Abrams Jamar', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(8, 44, 2, 44, 'Kavvadas Vasilis', 'Center', 0, 0, 44, 79, 0, 1, 29, 47, 23, 49, 7, 3, 4, 10, 16, 23, 40, 13, -2),
(8, 57, 2, 57, 'Kaselakis Leonidas', 'Power Forward', 0, 0, 2, 3, 5, 8, 1, 2, 4, 6, 1, 1, 0, 1, 2, 5, 2, 3, -2),
(8, 62, 2, 62, 'Komniadis Ioannis', 'Center', 8, 0, 19, 38, 17, 45, 16, 24, 3, 26, 35, 1, 2, 8, 19, 19, 27, 14, -2),
(8, 74, 2, 74, 'Latos Ilias', 'Small Forward', 6, 0, 7, 17, 6, 20, 4, 5, 2, 10, 27, 2, 1, 9, 12, 16, 8, 11, -2),
(8, 83, 2, 83, 'Mantzoukas Lefteris', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, -2),
(8, 90, 2, 90, 'Macon Daryl', 'Shooting Guard', 0, 0, 11, 27, 18, 40, 17, 19, 2, 14, 20, 1, 2, 4, 16, 29, 20, 12, -2),
(8, 105, 2, 105, 'Bokhoridis Eleftherios', 'Point Guard', 0, 0, 31, 65, 14, 56, 32, 43, 4, 34, 76, 1, 6, 13, 43, 34, 52, 14, -2),
(8, 106, 2, 106, 'Nedović Nemanja ', 'Shooting Guard', 0, 0, 21, 35, 0, 0, 15, 20, 16, 26, 7, 6, 1, 6, 8, 18, 20, 7, -2),
(8, 113, 2, 113, 'Dolezaj Marek ', 'Small Forward', 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(8, 120, 2, 120, 'White Okaro', 'Power Forward', 0, 0, 28, 53, 6, 20, 21, 24, 9, 30, 13, 3, 3, 9, 27, 21, 21, 14, -2),
(8, 124, 2, 124, 'Papayiannis Yiorgos', 'Center', 0, 0, 14, 34, 9, 29, 14, 17, 9, 31, 17, 2, 1, 12, 10, 36, 26, 12, -2),
(8, 125, 2, 125, 'Papadakis Kostas', 'Point Guard', 2, 0, 5, 9, 2, 6, 1, 1, 1, 4, 3, 0, 0, 1, 4, 4, 2, 12, -2),
(8, 128, 2, 128, 'Papapetrou Ioannis', 'Small Forward', 0, 0, 8, 15, 0, 0, 2, 3, 5, 7, 0, 3, 1, 2, 6, 8, 3, 3, -2),
(8, 131, 2, 131, 'Perry Kendrick', 'Point Guard', 0, 0, 2, 4, 0, 3, 3, 4, 3, 5, 3, 1, 1, 1, 2, 7, 3, 5, -2),
(8, 133, 2, 133, 'Petanidis Yiorgos', 'Point Guard', 4, 0, 1, 6, 3, 4, 3, 4, 1, 4, 2, 1, 2, 2, 2, 9, 2, 4, -2),
(8, 149, 2, 149, 'Wroten Tony', 'Point Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(8, 152, 2, 152, 'Sant-Roos Howard ', 'small Forward', 0, 0, 4, 8, 0, 3, 1, 1, 0, 3, 2, 0, 1, 1, 2, 3, 3, 6, -2),
(8, 156, 2, 156, 'Siva Peyton', 'Shooting Guard', 0, 0, 6, 13, 3, 17, 9, 12, 3, 7, 9, 0, 1, 4, 3, 16, 13, 9, -2),
(8, 160, 2, 160, 'Skordilis Gaios', 'Center', 11, 0, 19, 48, 10, 24, 12, 19, 12, 37, 14, 4, 3, 12, 13, 25, 24, 9, -2),
(8, 165, 2, 165, 'Stamatis Dimitris', 'Point Guard', 4, 0, 3, 5, 0, 0, 1, 2, 2, 4, 1, 0, 1, 1, 2, 4, 2, 3, -2),
(8, 169, 2, 169, 'Taylor Ryan ', 'Small Forward', 10, 0, 1, 5, 8, 28, 7, 11, 3, 9, 1, 1, 1, 5, 3, 14, 10, 5, -2),
(8, 181, 2, 181, 'Fillios Yiorgos', 'Shooting Guard', 7, 0, 15, 29, 6, 21, 10, 12, 4, 20, 13, 0, 3, 4, 5, 16, 11, 12, -2),
(8, 192, 2, 192, 'Charitopoulos Dimitris', 'Center', 4, 0, 1, 1, 0, 1, 0, 0, 0, 2, 2, 0, 0, 1, 2, 2, 1, 2, -2),
(8, 195, 2, 195, 'Henry Myke', 'Point Guard', 3, 0, 1, 1, 1, 4, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 2, -2),
(8, 196, 2, 196, 'Chougkaz Nikos', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(9, 28, 2, 28, 'Griffin Dayon', 'Point Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(9, 35, 2, 35, 'Diamantakos Yiorgos', 'Center', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(9, 36, 2, 36, 'Diplaros Nikos', 'Shooting Guard', 0, 0, 11, 16, 1, 2, 2, 4, 5, 10, 2, 2, 2, 3, 5, 8, 6, 8, -2),
(9, 43, 2, 43, 'Zoumpos Fotis', 'Point Guard', 0, 0, 2, 6, 6, 14, 6, 6, 1, 4, 9, 0, 1, 2, 6, 7, 6, 10, -2),
(9, 51, 2, 51, 'Kampouris Nikos', 'Center', 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 2, -2),
(9, 59, 2, 59, 'Koyonis Yiorgos', 'Small Forward', 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, -2),
(9, 64, 2, 64, 'Coleman Orlando', 'Small Forward', 0, 0, 3, 10, 8, 18, 4, 5, 4, 14, 3, 2, 0, 2, 6, 10, 4, 10, -2),
(9, 80, 2, 80, 'McLaffin Jeremy', 'Center', 0, 0, 7, 18, 3, 10, 4, 9, 10, 12, 4, 3, 2, 1, 4, 10, 8, 8, -2),
(9, 81, 2, 81, 'McLean Tre', 'Small Forward', 0, 0, 2, 5, 9, 21, 4, 4, 3, 5, 4, 1, 2, 2, 4, 16, 4, 9, -2),
(9, 84, 2, 84, 'Margaritis Vangelis', 'Small Forward', 0, 0, 2, 5, 0, 1, 0, 1, 2, 6, 1, 1, 0, 2, 1, 9, 2, 4, -2),
(9, 91, 2, 91, 'Mitrou-Long Elijah', 'Point Guard', 0, 0, 13, 24, 12, 44, 12, 14, 4, 17, 23, 0, 2, 3, 18, 21, 23, 8, -2),
(9, 92, 2, 92, 'Miller Shonn', 'Small Forward', 0, 0, 1, 5, 4, 12, 1, 1, 3, 5, 6, 0, 1, 4, 5, 8, 6, 8, -2),
(9, 93, 2, 93, 'Mirosavich Angelos', 'Shooting Guard', 0, 0, 7, 14, 8, 17, 6, 9, 8, 9, 5, 0, 2, 4, 2, 14, 11, 8, -2),
(9, 94, 2, 94, 'Molfetas Yiannis', 'Point Guard', 0, 0, 44, 67, 16, 41, 22, 27, 20, 50, 19, 5, 2, 10, 5, 12, 26, 11, -2),
(9, 95, 2, 95, 'Momirov Stefan ', 'Point Guard', 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, -2),
(9, 103, 2, 103, 'Billis Sotiris', 'Small Forward', 0, 0, 2, 2, 1, 3, 1, 1, 1, 4, 1, 0, 0, 2, 1, 1, 1, 8, -2),
(9, 104, 2, 104, 'Borgis Yiorgos', 'Center', 0, 0, 17, 34, 17, 48, 13, 16, 7, 25, 26, 1, 1, 13, 16, 17, 18, 17, -2),
(9, 111, 2, 111, 'Davis Dejon', 'Power Forward', 0, 0, 1, 4, 3, 4, 1, 1, 1, 2, 5, 0, 0, 1, 3, 5, 3, 10, -2),
(9, 115, 2, 115, 'Xanthopoulos Vasilis', 'Point Guard', 0, 0, 1, 1, 1, 2, 1, 1, 0, 1, 1, 0, 0, 1, 2, 2, 1, 2, -2),
(9, 117, 2, 117, 'Oikonomopoulos Konstantinos', 'Shooting Guard', 0, 0, 25, 33, 6, 14, 8, 12, 15, 31, 11, 5, 1, 7, 8, 13, 13, 9, -2),
(9, 122, 2, 122, 'Williams Kenny ', 'Shooting Guard', 0, 0, 4, 10, 12, 25, 4, 5, 2, 14, 16, 0, 0, 6, 9, 20, 9, 9, -2),
(9, 129, 2, 129, 'Papafotiou Fotis', 'Power Forward', 0, 0, 10, 19, 2, 9, 9, 13, 12, 14, 6, 2, 2, 2, 3, 15, 11, 4, -2),
(9, 139, 2, 139, 'Pot Stefan', 'Shooting Guard', 0, 0, 1, 2, 1, 3, 1, 2, 0, 2, 1, 1, 0, 1, 0, 3, 2, 8, -2),
(9, 141, 2, 141, 'Prapas Stergios', 'Shooting Guard', 0, 0, 12, 30, 10, 25, 5, 9, 1, 9, 13, 1, 2, 5, 10, 9, 13, 11, -2),
(9, 158, 2, 158, 'Simons Gerel', 'Shooting Guard', 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, -2),
(9, 161, 2, 161, 'Slaftsakis Diamantis', 'Small Forward', 0, 0, 29, 50, 12, 39, 17, 26, 28, 42, 8, 6, 4, 4, 9, 27, 22, 13, -2),
(9, 172, 2, 172, 'Tillie Kim', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(9, 175, 2, 175, 'Tsalmpouris Yiorgos', 'Center', 0, 0, 19, 30, 25, 66, 18, 21, 3, 15, 24, 0, 1, 5, 11, 19, 25, 12, -2),
(9, 178, 2, 178, 'Tsiakmas Nikos', 'Shooting Guard', 0, 0, 40, 78, 0, 1, 27, 38, 20, 41, 12, 9, 3, 3, 15, 25, 34, 11, -2),
(9, 184, 2, 184, 'Floyd Jordan', 'Shooting Guard', 0, 0, 3, 8, 0, 4, 1, 1, 0, 3, 2, 0, 0, 1, 0, 1, 1, 10, -2),
(9, 193, 2, 193, 'Chtatzidakis Manolis', 'Center', 0, 0, 25, 43, 2, 9, 9, 14, 16, 22, 7, 9, 3, 9, 7, 20, 15, 7, -2),
(10, 7, 2, 7, 'Braian Angola', 'Shooting Guard', 11, 0, 13, 23, 23, 59, 20, 22, 9, 39, 8, 1, 1, 9, 8, 29, 23, 11, -2),
(10, 11, 2, 11, 'Asteriadis Asterios', 'Shooting Guard', 0, 0, 5, 8, 4, 8, 1, 1, 1, 6, 10, 0, 0, 1, 3, 5, 4, 10, -2),
(10, 14, 2, 14, 'Vissariou Tilemakhos', 'Point Guard', 0, 0, 27, 63, 1, 3, 13, 17, 22, 23, 4, 9, 5, 5, 11, 21, 18, 13, -2),
(10, 24, 2, 24, 'Green Devonte', 'Shooting Guard', 0, 0, 2, 5, 7, 15, 4, 4, 1, 4, 3, 0, 0, 3, 2, 9, 5, 8, -2),
(10, 26, 2, 26, 'Griffin Eric ', 'Center', 6, 0, 35, 65, 3, 13, 15, 28, 15, 41, 11, 4, 2, 10, 18, 20, 24, 14, -2),
(10, 29, 2, 29, 'Gogolos Sotiris', 'Point Guard', 3, 0, 1, 3, 1, 6, 3, 5, 1, 2, 3, 0, 1, 2, 2, 3, 5, 5, -2),
(10, 42, 2, 42, 'Zaras Theodoros', 'Shooting Guard', 0, 0, 5, 8, 1, 7, 6, 7, 0, 6, 7, 0, 1, 2, 9, 4, 5, 12, -2),
(10, 54, 2, 54, 'Karampelas Zois', 'Shooting Guard', 0, 0, 1, 4, 1, 3, 0, 1, 0, 4, 1, 0, 0, 1, 2, 3, 1, 2, -2),
(10, 55, 2, 55, 'Karlis Manolis', 'Point Guard', 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 9, -2),
(10, 56, 2, 56, 'Karlis Michalis', 'Shooting Guard', 4, 0, 3, 6, 0, 0, 1, 2, 3, 4, 1, 2, 2, 0, 2, 8, 2, 3, -2),
(10, 61, 2, 61, 'Colom Quino', 'Shooting Guard', 9, 0, 2, 4, 1, 8, 1, 4, 0, 8, 12, 0, 1, 1, 9, 8, 6, 4, -2),
(10, 63, 2, 63, 'Koniaris Antonis', 'Point Guard', 2, 0, 5, 8, 0, 0, 1, 2, 6, 5, 0, 1, 2, 0, 4, 4, 3, 8, -2),
(10, 65, 2, 65, 'Kouzeloglou Yiannis', 'Small Forward', 7, 0, 4, 8, 6, 13, 1, 1, 1, 8, 5, 1, 1, 2, 4, 13, 4, 7, -2),
(10, 66, 2, 66, 'Krubally Ousman', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(10, 72, 2, 72, 'Langford Keith', 'Shooting Guard', 10, 0, 21, 41, 10, 31, 15, 20, 11, 44, 8, 2, 2, 9, 12, 25, 21, 12, -2),
(10, 85, 2, 85, 'Marić Marin', 'Center', 0, 0, 33, 84, 14, 37, 44, 50, 3, 21, 24, 2, 10, 8, 29, 18, 41, 11, -2),
(10, 87, 2, 87, 'Mavridis Dimitris', 'Center', 10, 0, 5, 8, 7, 13, 2, 2, 1, 3, 8, 0, 0, 3, 6, 12, 6, 5, -2),
(10, 97, 2, 97, 'Mouzourakis Odysseas', 'Center', 11, 0, 31, 53, 7, 29, 31, 41, 17, 56, 12, 2, 3, 4, 17, 23, 34, 12, -2),
(10, 98, 2, 98, 'Moody Stefan ', 'Shooting Guard', 0, 0, 4, 7, 3, 12, 3, 4, 2, 12, 8, 1, 0, 3, 4, 14, 5, 6, -2),
(10, 102, 2, 102, 'Bazinas Yianis', 'Power Forward', 0, 0, 1, 3, 2, 8, 2, 3, 4, 6, 1, 0, 0, 0, 2, 5, 3, 3, -2),
(10, 127, 2, 127, 'Papantoniou Nontas', 'Shooting Guard', 0, 0, 12, 25, 17, 53, 8, 11, 16, 27, 14, 1, 1, 13, 9, 25, 16, 13, -2),
(10, 130, 2, 130, 'Pappas Nikos', 'Point Guard', 6, 0, 26, 41, 11, 26, 9, 11, 2, 14, 16, 1, 3, 7, 10, 10, 18, 14, -2),
(10, 135, 2, 135, 'Petropoulos Andreas', 'Point Guard', 3, 0, 1, 5, 1, 5, 1, 2, 0, 2, 2, 0, 1, 2, 2, 7, 3, 7, -2),
(10, 143, 2, 143, 'Rautins Andy', 'Point Guard', 8, 0, 20, 41, 14, 33, 14, 19, 8, 20, 17, 2, 4, 4, 14, 15, 21, 12, -2),
(10, 154, 2, 154, 'Saxionis Konstantinos', 'Point Guard', 3, 0, 4, 6, 1, 3, 0, 0, 1, 3, 5, 0, 1, 3, 3, 3, 1, 7, -2),
(10, 155, 2, 155, 'Sachpatzidis Yiannis', 'Center', 0, 0, 2, 3, 0, 0, 0, 1, 1, 1, 2, 0, 0, 0, 2, 5, 2, 4, -2),
(10, 164, 2, 164, 'Spiropoulos Anastasios', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(10, 177, 2, 177, 'Tsairelis Mikhalis', 'Small Forward', 0, 0, 17, 35, 4, 16, 11, 15, 4, 7, 8, 2, 3, 3, 11, 12, 17, 9, -2),
(10, 180, 2, 180, 'Filippakos Panayiotis', 'Power Forward', 5, 0, 16, 29, 9, 30, 11, 14, 7, 9, 13, 1, 3, 2, 6, 13, 18, 15, -2),
(10, 183, 2, 183, 'Flionis Dimitris', 'Point Guard', 11, 0, 33, 64, 18, 54, 19, 23, 3, 32, 19, 5, 1, 10, 21, 29, 19, 13, -2),
(10, 187, 2, 187, 'Hummer Ian', 'Power Forward', 4, 0, 3, 5, 0, 1, 2, 2, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, -2),
(10, 191, 2, 191, 'Hudson Jalen ', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(11, 5, 2, 5, 'Athinaiou Ioannis', 'Shooting Guard', 0, 0, 4, 9, 2, 10, 2, 3, 5, 13, 3, 0, 1, 3, 4, 8, 3, 10, -2),
(11, 10, 2, 10, 'Arsenopoulos Nikos ', 'Point Guard', 0, 0, 50, 73, 0, 1, 8, 11, 24, 59, 14, 18, 2, 5, 12, 17, 17, 14, -2),
(11, 17, 2, 17, 'Gerokostas Nikolaos', 'Power Forward', 0, 0, 14, 29, 0, 0, 6, 6, 6, 13, 5, 2, 2, 2, 8, 13, 8, 8, -2),
(11, 22, 2, 22, 'Giouzelis Yiorgos', 'Small Forward', 0, 0, 24, 46, 9, 28, 21, 27, 13, 44, 32, 4, 2, 9, 16, 28, 30, 12, -2),
(11, 30, 2, 30, 'Gontikas Costis', 'Point Guard', 0, 0, 1, 3, 0, 4, 2, 3, 2, 5, 1, 0, 1, 0, 1, 3, 3, 5, -2),
(11, 47, 2, 47, 'Kamaras Nikos', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(11, 52, 2, 52, 'Cowan Anthony Jr.', 'Shooting Guard', 0, 0, 1, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 2, -2),
(11, 53, 2, 53, 'Karayiannis Konstantinos', 'Center', 0, 0, 15, 29, 6, 25, 4, 6, 7, 28, 9, 1, 2, 3, 8, 13, 7, 10, -2),
(11, 58, 2, 58, 'Kelly James', 'Center', 0, 0, 18, 42, 10, 28, 20, 25, 17, 30, 13, 4, 7, 7, 13, 25, 23, 12, -2),
(11, 60, 2, 60, 'Koloveros Iosif', 'Point Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(11, 68, 2, 68, 'Kottas Thomas', 'Center', 0, 0, 31, 46, 0, 0, 12, 20, 18, 30, 18, 10, 1, 3, 10, 16, 28, 10, -2),
(11, 70, 2, 70, 'Lampropoulos Konstantinos', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(11, 71, 2, 71, 'Langford Kevin', 'Power Forward', 0, 0, 46, 68, 3, 10, 14, 24, 32, 56, 11, 7, 1, 17, 16, 33, 18, 12, -2),
(11, 77, 2, 77, 'Lockett Eric', 'Power Forward', 0, 0, 4, 10, 1, 4, 2, 2, 4, 2, 9, 0, 2, 2, 4, 4, 5, 9, -2),
(11, 88, 2, 88, 'Mavrokefalidis Loukas', 'Center', 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, -2),
(11, 96, 2, 96, 'Moses Kingsley', 'Center', 0, 0, 2, 5, 1, 4, 0, 0, 1, 0, 0, 0, 0, 1, 2, 3, 1, 6, -2),
(11, 100, 2, 100, 'Mustafa Muhaymin ', 'Shooting Guard', 0, 0, 5, 13, 17, 53, 20, 25, 5, 22, 39, 1, 1, 9, 20, 30, 32, 11, -2),
(11, 108, 2, 108, 'Netzipoglou Omiros', 'Point Guard', 0, 0, 22, 39, 5, 17, 6, 10, 7, 22, 11, 3, 2, 14, 12, 28, 10, 11, -2),
(11, 110, 2, 110, 'Davis Mike', 'Shooting Guard', 0, 0, 21, 38, 8, 36, 13, 21, 10, 33, 15, 2, 4, 11, 15, 27, 21, 14, -2),
(11, 119, 2, 119, 'Owens Josh', 'Center', 0, 0, 2, 5, 1, 4, 1, 1, 0, 1, 3, 1, 1, 2, 2, 2, 1, 4, -2),
(11, 121, 2, 121, 'Williams Xeyrius ', 'Power Forward', 0, 0, 10, 16, 0, 0, 3, 6, 9, 8, 4, 4, 2, 2, 4, 12, 5, 7, -2),
(11, 134, 2, 134, 'Petanidis Kiriakos', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(11, 140, 2, 140, 'Poulianitis Stelios', 'Point Guard', 0, 0, 24, 59, 9, 29, 19, 28, 9, 35, 57, 1, 5, 8, 25, 31, 49, 12, -2),
(11, 144, 2, 144, 'Rice Rayvonte ', 'Power Forward', 0, 0, 0, 1, 0, 2, 0, 0, 1, 2, 1, 1, 0, 0, 2, 1, 1, 2, -2),
(11, 157, 2, 157, 'Sidiroilias Yiannis', 'Power Forward', 0, 0, 15, 30, 12, 31, 9, 11, 4, 19, 24, 1, 3, 15, 22, 27, 21, 10, -2),
(11, 166, 2, 166, 'Schizas Stavros', 'Point Guard', 0, 0, 14, 28, 4, 15, 7, 9, 3, 13, 9, 1, 4, 3, 3, 17, 10, 7, -2),
(11, 170, 2, 170, 'Tzolos Vangelis', 'Point Guard', 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 0, 5, -2),
(11, 171, 2, 171, 'Juiston Shakur', 'Small Forward', 0, 0, 9, 19, 10, 29, 10, 15, 5, 14, 26, 1, 3, 7, 19, 16, 22, 11, -2),
(11, 174, 2, 174, 'Tumba Kevin', 'Center', 0, 0, 17, 34, 14, 41, 9, 13, 8, 39, 25, 2, 4, 6, 14, 8, 19, 19, -2),
(11, 176, 2, 176, 'Tsachtsiras Philippos', 'Small Forward', 0, 0, 28, 50, 17, 46, 28, 34, 3, 21, 44, 0, 2, 8, 20, 24, 33, 12, -2),
(11, 185, 2, 185, 'Fridas Lampros', 'Point Guard', 0, 0, 30, 41, 0, 0, 12, 16, 19, 18, 4, 10, 3, 8, 5, 23, 15, 7, -2),
(11, 186, 2, 186, 'Chavales Stelios', 'small Forward', 0, 0, 1, 2, 2, 5, 0, 0, 1, 2, 0, 0, 1, 0, 1, 5, 0, 4, -2),
(11, 188, 2, 188, 'Hamilton Daniel', 'small Forward', 0, 0, 4, 10, 5, 15, 11, 13, 2, 8, 6, 0, 1, 1, 4, 6, 6, 8, -2),
(11, 189, 2, 189, 'Hanlan Olivier', 'Point Guard', 0, 0, 35, 57, 2, 5, 26, 35, 13, 37, 7, 5, 2, 5, 11, 19, 33, 15, -2),
(11, 194, 2, 194, 'Chatzikyriakos Yiorgos', 'Shooting Guard', 0, 0, 21, 37, 9, 21, 10, 14, 6, 17, 6, 1, 2, 5, 10, 6, 15, 15, -2),
(12, 3, 2, 3, 'Agravanis Ioannis', 'Small Forward', 11, 0, 16, 26, 8, 32, 13, 16, 3, 31, 44, 1, 2, 15, 15, 28, 22, 9, -2),
(12, 4, 2, 4, 'Agravanis Dimitris', 'Power Forward', 3, 0, 1, 2, 1, 3, 3, 3, 1, 1, 1, 0, 1, 3, 1, 4, 2, 5, -2),
(12, 8, 2, 8, 'Mihajlo Andrić', 'Small Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(12, 12, 2, 12, 'Vasileiou Nikos', 'Shooting Guard', 10, 0, 22, 32, 15, 34, 12, 17, 3, 17, 19, 0, 1, 11, 14, 12, 19, 10, -2),
(12, 19, 2, 19, 'Yankovits Vladimiros ', 'Small Forward', 10, 0, 37, 53, 0, 0, 13, 25, 15, 26, 12, 9, 4, 4, 14, 25, 22, 9, -2),
(12, 21, 2, 21, 'Gkikas Nikos', 'Point Guard', 8, 0, 27, 60, 22, 58, 37, 44, 3, 23, 22, 0, 4, 7, 15, 20, 49, 17, -2),
(12, 23, 2, 23, 'Grant Tzerai', 'Power Forward', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2),
(12, 25, 2, 25, 'Greene Phil ', 'Shooting Guard', 11, 0, 19, 32, 9, 24, 6, 9, 9, 30, 16, 1, 1, 4, 10, 15, 13, 10, -2),
(12, 27, 2, 27, 'Griffin Malcolm ', 'Point Guard', 8, 0, 7, 12, 4, 10, 2, 4, 5, 10, 3, 1, 1, 2, 5, 10, 3, 4, -2),
(12, 46, 2, 46, 'Kalliontzis Stratos', 'Power Forward', 11, 0, 21, 44, 22, 66, 7, 12, 15, 40, 10, 6, 3, 9, 14, 34, 12, 15, -2),
(12, 48, 2, 48, 'Kamarianos Nikolaos', 'Small Forward', 8, 0, 14, 29, 9, 27, 11, 14, 3, 14, 12, 1, 1, 7, 7, 17, 14, 12, -2),
(12, 49, 2, 49, 'Kamperidis Yiorgos', 'Power Forward', 7, 0, 37, 62, 1, 5, 24, 34, 21, 25, 12, 3, 3, 4, 13, 21, 27, 12, -2),
(12, 50, 2, 50, 'Kamperidis Michalis', 'Small Forward', 11, 0, 16, 35, 9, 23, 5, 10, 3, 17, 31, 1, 3, 5, 18, 27, 18, 11, -2),
(12, 67, 2, 67, 'Konstandinidis Theodoros', 'Point Guard', 7, 0, 9, 18, 11, 25, 9, 10, 4, 18, 10, 0, 2, 5, 7, 14, 9, 12, -2),
(12, 69, 2, 69, 'Layios Angelos', 'Shooting Guard', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(12, 75, 2, 75, 'Lee Anthony ', 'Small Forward', 2, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, -2),
(12, 76, 2, 76, 'Love Jermaine ', 'Point Guard', 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 4, -2),
(12, 82, 2, 82, 'Mantzaris Vangelis', 'Point Guard', 4, 0, 10, 26, 4, 13, 3, 5, 2, 5, 15, 0, 2, 4, 11, 11, 5, 11, -2),
(12, 89, 2, 89, 'Miles Isaiah', 'Small Forward', 5, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 3, 1, 1, -2),
(12, 101, 2, 101, 'Bazinas Thanasis', 'Point Guard', 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 2, -2),
(12, 107, 2, 107, 'Neofitos Yiorgos', 'Shooting Guard', 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(12, 112, 2, 112, 'DiLeo David', 'Small Forward', 3, 0, 18, 30, 3, 9, 16, 19, 6, 18, 8, 1, 2, 2, 8, 10, 15, 15, -2),
(12, 116, 2, 116, 'Ogbeide Derek', 'Center', 8, 0, 2, 5, 2, 6, 1, 1, 2, 6, 1, 1, 0, 0, 1, 5, 1, 4, -2),
(12, 138, 2, 138, 'Plotas Nikos', 'Shooting Guard', 8, 0, 6, 15, 13, 41, 14, 17, 3, 9, 21, 0, 2, 3, 8, 11, 17, 11, -2),
(12, 145, 2, 145, 'Renfro Nate ', 'Power Forward', 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 3, -2),
(12, 146, 2, 146, 'Ray Kendrick ', 'Point Guard', 4, 0, 10, 13, 0, 0, 2, 7, 8, 12, 5, 7, 0, 4, 5, 8, 7, 10, -2),
(12, 147, 2, 147, 'Rivers Dimitri', 'Small Forward', 11, 0, 14, 39, 15, 38, 30, 34, 2, 15, 54, 0, 1, 12, 20, 11, 35, 11, -2),
(12, 148, 2, 148, 'Rongavopoulos Nikos', 'Point Guard', 10, 0, 15, 31, 14, 43, 14, 20, 5, 26, 41, 0, 3, 11, 14, 23, 24, 11, -2),
(12, 150, 2, 150, 'Roumoglou Apostolos', 'Shooting Guard', 10, 0, 12, 22, 13, 35, 6, 8, 4, 10, 5, 2, 2, 6, 5, 18, 7, 9, -2),
(12, 159, 2, 159, 'Simpson Trevis', 'Power Forward', 1, 0, 0, 2, 0, 3, 0, 0, 0, 4, 3, 0, 0, 1, 0, 3, 2, 8, -2),
(12, 167, 2, 167, 'Tanoulis Yiorgos', 'Small Forward', 3, 0, 3, 6, 1, 1, 1, 1, 1, 4, 3, 1, 0, 2, 3, 7, 4, 8, -2),
(12, 168, 2, 168, 'Tachiridis Prodromos', 'Power Forward', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2),
(12, 173, 2, 173, 'Toliopoulos Vasilis', 'Shooting Guard', 3, 0, 6, 15, 6, 12, 5, 6, 2, 5, 6, 1, 1, 3, 6, 7, 6, 15, -2),
(12, 190, 2, 190, 'Hunt Dario', 'Center', 8, 0, 17, 35, 6, 20, 6, 9, 4, 15, 10, 2, 2, 2, 12, 19, 8, 9, -2),
(12, 197, 2, 197, 'Christodoulou Andreas', 'Point Guard', 3, 0, 15, 27, 1, 1, 6, 7, 8, 8, 2, 11, 1, 2, 8, 9, 9, 13, -2);

-- --------------------------------------------------------

--
-- Table structure for table `player_stat_card`
--

CREATE TABLE `player_stat_card` (
  `player_stat_card_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  `player_name` varchar(32) NOT NULL,
  `games_played` int(11) NOT NULL DEFAULT 0,
  `total_time` int(11) NOT NULL DEFAULT 0,
  `points` int(11) NOT NULL DEFAULT 0,
  `made2p` int(11) NOT NULL DEFAULT 0,
  `attempted2p` int(11) NOT NULL DEFAULT 0,
  `made3p` int(11) NOT NULL DEFAULT 0,
  `attempted3p` int(11) NOT NULL DEFAULT 0,
  `madeft` int(11) NOT NULL DEFAULT 0,
  `attemptedft` int(11) NOT NULL DEFAULT 0,
  `off_rebs` int(11) NOT NULL DEFAULT 0,
  `def_rebs` int(11) NOT NULL DEFAULT 0,
  `assist` int(11) NOT NULL DEFAULT 0,
  `blocks` int(11) NOT NULL DEFAULT 0,
  `blocks_on` int(11) NOT NULL DEFAULT 0,
  `steals` int(11) NOT NULL DEFAULT 0,
  `turnovers` int(11) NOT NULL DEFAULT 0,
  `fouls_drawn` int(11) NOT NULL DEFAULT 0,
  `fouls_commited` int(11) NOT NULL DEFAULT 0,
  `shots_rejected` int(11) NOT NULL DEFAULT 0,
  `tendex` int(11) NOT NULL DEFAULT 0,
  `MPG` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `player_stat_card`
--

INSERT INTO `player_stat_card` (`player_stat_card_id`, `player_id`, `player_name`, `games_played`, `total_time`, `points`, `made2p`, `attempted2p`, `made3p`, `attempted3p`, `madeft`, `attemptedft`, `off_rebs`, `def_rebs`, `assist`, `blocks`, `blocks_on`, `steals`, `turnovers`, `fouls_drawn`, `fouls_commited`, `shots_rejected`, `tendex`, `MPG`) VALUES
(1, 1, 'Avdalas Ioannis', 31, 256, 0, 13, 23, 23, 59, 20, 22, 9, 39, 8, 1, 1, 9, 8, 23, 29, 0, 41, 11),
(2, 2, 'Avdalas Neoklis', 6, 170, 0, 35, 65, 3, 13, 15, 28, 15, 41, 11, 4, 2, 10, 18, 24, 20, 0, 124, 14),
(3, 3, 'Agravanis Ioannis', 3, 31, 0, 1, 3, 1, 6, 3, 5, 1, 2, 3, 0, 1, 2, 2, 5, 3, 0, 124, 5),
(4, 4, 'Agravanis Dimitris', 1, 9, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 124, 9),
(5, 5, 'Athinaiou Ioannis', 14, 28, 0, 3, 6, 0, 0, 1, 2, 3, 4, 1, 2, 2, 0, 2, 2, 8, 0, 3, 3),
(6, 6, 'Aminou Al Ouazint', 9, 70, 0, 2, 4, 1, 8, 1, 4, 0, 8, 12, 0, 1, 1, 9, 6, 8, 0, 124, 4),
(7, 7, 'Braian Angola', 2, 31, 0, 5, 8, 0, 0, 1, 2, 6, 5, 0, 1, 2, 0, 4, 3, 4, 0, 124, 8),
(8, 8, 'Mihajlo Andrić', 7, 95, 0, 4, 8, 6, 13, 1, 1, 1, 8, 5, 1, 1, 2, 4, 4, 13, 0, 124, 7),
(9, 9, 'Argyroulis Panagiotis', 10, 240, 0, 21, 41, 10, 31, 15, 20, 11, 44, 8, 2, 2, 9, 12, 21, 25, 0, 124, 12),
(10, 10, 'Arsenopoulos Nikos ', 10, 88, 0, 5, 8, 7, 13, 2, 2, 1, 3, 8, 0, 0, 3, 6, 6, 12, 0, 124, 5),
(11, 11, 'Asteriadis Asterios', 16, 285, 0, 31, 53, 7, 29, 32, 42, 17, 57, 12, 2, 3, 4, 17, 34, 23, 0, 124, 12),
(12, 12, 'Vasileiou Nikos', 6, 158, 0, 26, 41, 11, 26, 9, 11, 2, 14, 16, 1, 3, 7, 10, 18, 10, 0, 124, 14),
(13, 13, 'Vezenkof Alexander ', 3, 42, 0, 1, 5, 1, 5, 1, 2, 0, 2, 2, 0, 1, 2, 2, 3, 7, 0, 124, 7),
(14, 14, 'Vissariou Tilemakhos', 8, 186, 0, 20, 41, 14, 33, 14, 19, 8, 20, 17, 2, 4, 4, 14, 21, 15, 0, 124, 12),
(15, 15, 'Von Rasant', 3, 34, 0, 4, 6, 1, 3, 0, 0, 1, 3, 5, 0, 1, 3, 3, 1, 3, 0, 124, 7),
(16, 16, 'Voulgaropoulos Stratos', 5, 147, 0, 16, 29, 9, 30, 11, 14, 7, 9, 13, 1, 3, 2, 6, 18, 13, 0, 124, 15),
(17, 17, 'Gerokostas Nikolaos', 31, 318, 0, 33, 64, 18, 54, 20, 24, 4, 32, 19, 5, 1, 14, 25, 19, 29, 0, 19, 13),
(18, 18, 'Geromikhalos Petros', 4, 8, 0, 3, 5, 0, 1, 2, 2, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 124, 1),
(19, 19, 'Yankovits Vladimiros ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(20, 20, 'Garet Branton', 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 1),
(21, 21, 'Gkikas Nikos', 5, 82, 0, 11, 16, 1, 2, 2, 4, 5, 10, 2, 2, 2, 3, 5, 6, 8, 0, 124, 8),
(22, 22, 'Giouzelis Yiorgos', 3, 58, 0, 2, 6, 6, 14, 6, 6, 1, 4, 9, 0, 1, 2, 6, 6, 7, 0, 124, 10),
(23, 23, 'Grant Tzerai', 3, 4, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 124, 1),
(24, 24, 'Green Devonte', 5, 95, 0, 3, 10, 8, 18, 4, 5, 4, 14, 3, 2, 0, 2, 6, 4, 10, 0, 124, 10),
(25, 25, 'Greene Phil ', 5, 80, 0, 7, 18, 3, 10, 4, 9, 10, 12, 4, 3, 2, 1, 4, 8, 10, 0, 124, 8),
(26, 26, 'Griffin Eric ', 7, 130, 0, 2, 5, 9, 21, 4, 4, 3, 5, 4, 1, 2, 2, 4, 4, 16, 0, 124, 9),
(27, 27, 'Griffin Malcolm ', 11, 178, 0, 13, 24, 12, 44, 12, 14, 4, 17, 23, 0, 2, 3, 18, 23, 21, 0, 124, 8),
(28, 28, 'Griffin Dayon', 21, 241, 0, 44, 68, 16, 41, 23, 31, 20, 50, 19, 5, 2, 10, 5, 26, 12, 0, 118, 11),
(29, 29, 'Gogolos Sotiris', 6, 187, 0, 17, 34, 17, 48, 13, 16, 7, 25, 26, 1, 1, 13, 16, 18, 17, 0, 124, 17),
(30, 30, 'Gontikas Costis', 2, 31, 0, 1, 4, 3, 4, 1, 1, 1, 2, 5, 0, 0, 1, 3, 3, 5, 0, 124, 10),
(31, 31, 'Yints Keison', 11, 97, 0, 10, 19, 2, 9, 9, 13, 12, 14, 6, 2, 2, 2, 3, 11, 15, 0, 124, 4),
(32, 32, 'Walkup Thomas ', 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 124, 1),
(33, 33, 'Deimezis Dimitrios', 8, 187, 0, 19, 30, 25, 66, 18, 21, 3, 15, 24, 0, 1, 5, 11, 25, 19, 0, 124, 12),
(34, 34, 'Dimou Emmanouil', 11, 260, 0, 40, 78, 0, 1, 27, 38, 20, 41, 12, 9, 3, 3, 15, 34, 25, 0, 124, 11),
(35, 35, 'Diamantakos Yiorgos', 5, 69, 0, 14, 29, 0, 0, 6, 6, 6, 13, 5, 2, 2, 2, 8, 8, 13, 0, 124, 8),
(36, 36, 'Diplaros Nikos', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(37, 37, 'Evans Jeremy', 2, 5, 0, 1, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 124, 2),
(38, 38, 'Evstathiou Simeon', 8, 160, 0, 15, 29, 6, 25, 4, 6, 7, 28, 9, 1, 2, 3, 8, 7, 13, 0, 124, 10),
(39, 39, 'Abrams Jamar', 10, 242, 0, 18, 42, 10, 28, 20, 25, 17, 30, 13, 4, 7, 7, 13, 23, 25, 0, 124, 12),
(40, 40, 'Quincy Jyrome Acy', 10, 181, 0, 31, 46, 0, 0, 12, 20, 18, 30, 18, 10, 1, 3, 10, 28, 16, 0, 124, 10),
(41, 41, 'Livio Jean-Charles', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(42, 42, 'Zaras Theodoros', 3, 54, 0, 4, 10, 1, 4, 2, 2, 4, 2, 9, 0, 2, 2, 4, 5, 4, 0, 124, 9),
(43, 43, 'Zoumpos Fotis', 11, 254, 0, 22, 39, 5, 17, 6, 10, 7, 22, 11, 3, 2, 14, 12, 10, 28, 0, 124, 11),
(44, 44, 'Kavvadas Vasilis', 5, 65, 0, 10, 16, 0, 0, 3, 6, 9, 8, 4, 4, 2, 2, 4, 5, 12, 0, 124, 7),
(45, 45, 'Kaklamanakis Dimitris', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(46, 46, 'Kalliontzis Stratos', 11, 286, 0, 24, 59, 9, 29, 19, 28, 9, 35, 57, 1, 5, 8, 25, 49, 31, 0, 124, 12),
(47, 47, 'Kamaras Nikos', 11, 205, 0, 15, 30, 12, 31, 9, 11, 4, 19, 24, 1, 3, 15, 22, 21, 27, 0, 124, 10),
(48, 48, 'Kamarianos Nikolaos', 11, 153, 0, 14, 28, 4, 15, 7, 9, 3, 13, 9, 1, 4, 3, 3, 10, 17, 0, 124, 7),
(49, 49, 'Kamperidis Yiorgos', 9, 181, 0, 9, 19, 10, 29, 10, 15, 5, 14, 26, 1, 3, 7, 19, 22, 16, 0, 124, 11),
(50, 50, 'Kamperidis Michalis', 11, 259, 0, 28, 50, 17, 46, 28, 34, 3, 21, 44, 0, 2, 8, 20, 33, 24, 0, 124, 12),
(51, 51, 'Kampouris Nikos', 16, 161, 0, 30, 41, 0, 0, 12, 16, 19, 18, 4, 10, 3, 8, 5, 15, 23, 0, 124, 7),
(52, 52, 'Cowan Anthony Jr.', 2, 16, 0, 1, 2, 2, 5, 0, 0, 1, 2, 0, 0, 1, 0, 1, 0, 5, 0, 124, 4),
(53, 53, 'Karayiannis Konstantinos', 7, 194, 0, 35, 57, 2, 5, 26, 35, 13, 37, 7, 5, 2, 5, 11, 33, 19, 0, 124, 15),
(54, 54, 'Karampelas Zois', 4, 68, 0, 4, 9, 2, 10, 2, 3, 5, 13, 3, 0, 1, 3, 4, 3, 8, 0, 124, 10),
(55, 55, 'Karlis Manolis', 11, 286, 0, 50, 73, 0, 1, 8, 11, 24, 59, 14, 18, 2, 5, 12, 17, 17, 0, 124, 14),
(56, 56, 'Karlis Michalis', 11, 287, 0, 24, 46, 9, 28, 21, 27, 13, 44, 32, 4, 2, 9, 16, 30, 28, 0, 124, 12),
(57, 57, 'Kaselakis Leonidas', 2, 16, 0, 1, 3, 0, 4, 2, 3, 2, 5, 1, 0, 1, 0, 1, 3, 3, 0, 124, 5),
(58, 58, 'Kelly James', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(59, 59, 'Koyonis Yiorgos', 11, 278, 0, 46, 68, 3, 10, 14, 24, 32, 56, 11, 7, 1, 17, 16, 18, 33, 0, 124, 12),
(60, 60, 'Koloveros Iosif', 5, 7, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 124, 1),
(61, 61, 'Colom Quino', 2, 19, 0, 2, 5, 1, 4, 0, 0, 1, 0, 0, 0, 0, 1, 2, 1, 3, 0, 124, 6),
(62, 62, 'Komniadis Ioannis', 11, 262, 0, 5, 13, 17, 53, 20, 25, 5, 22, 39, 1, 1, 9, 20, 32, 30, 0, 124, 11),
(63, 63, 'Koniaris Antonis', 10, 257, 0, 21, 38, 8, 36, 13, 21, 10, 33, 15, 2, 4, 11, 15, 21, 27, 0, 124, 14),
(64, 64, 'Coleman Orlando', 4, 29, 0, 2, 5, 1, 4, 1, 1, 0, 1, 3, 1, 1, 2, 2, 1, 2, 0, 124, 4),
(65, 65, 'Kouzeloglou Yiannis', 4, 16, 0, 0, 1, 0, 2, 0, 0, 1, 2, 1, 1, 0, 0, 2, 1, 1, 0, 124, 2),
(66, 66, 'Krubally Ousman', 1, 5, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 2, 0, 124, 5),
(67, 67, 'Konstandinidis Theodoros', 5, 167, 0, 17, 34, 14, 41, 9, 13, 8, 39, 25, 2, 4, 6, 14, 19, 8, 0, 124, 19),
(68, 68, 'Kottas Thomas', 6, 91, 0, 4, 10, 5, 15, 11, 13, 2, 8, 6, 0, 1, 1, 4, 6, 6, 0, 124, 8),
(69, 69, 'Layios Angelos', 5, 139, 0, 21, 37, 9, 21, 10, 14, 6, 17, 6, 1, 2, 5, 10, 15, 6, 0, 124, 15),
(70, 70, 'Lampropoulos Konstantinos', 11, 197, 0, 13, 19, 24, 51, 15, 17, 2, 22, 30, 1, 0, 11, 13, 20, 23, 0, 124, 8),
(71, 71, 'Langford Kevin', 11, 216, 0, 17, 42, 3, 23, 19, 28, 14, 31, 9, 2, 2, 11, 11, 35, 28, 0, 124, 10),
(72, 72, 'Langford Keith', 8, 143, 0, 25, 47, 1, 1, 8, 14, 22, 22, 8, 6, 3, 6, 11, 16, 20, 0, 124, 9),
(73, 73, 'Larentzakis Yiannoulis', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(74, 74, 'Latos Ilias', 8, 215, 0, 19, 38, 17, 45, 16, 24, 3, 26, 35, 1, 2, 8, 19, 27, 19, 0, 124, 14),
(75, 75, 'Lee Anthony ', 6, 126, 0, 7, 17, 6, 20, 4, 5, 2, 10, 27, 2, 1, 9, 12, 8, 16, 0, 124, 11),
(76, 76, 'Love Jermaine ', 1, 2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 1),
(77, 77, 'Lockett Eric', 2, 46, 0, 5, 9, 2, 6, 1, 1, 1, 4, 3, 0, 0, 1, 4, 2, 4, 0, 124, 12),
(78, 78, 'Lountzis Michalis', 4, 34, 0, 1, 6, 3, 4, 3, 4, 1, 4, 2, 1, 2, 2, 2, 2, 9, 0, 124, 4),
(79, 79, 'McKissic Shaquielle ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(80, 80, 'McLaffin Jeremy', 11, 226, 0, 19, 48, 10, 24, 12, 19, 12, 37, 14, 4, 3, 12, 13, 24, 25, 0, 124, 9),
(81, 81, 'McLean Tre', 4, 21, 0, 3, 5, 0, 0, 1, 2, 2, 4, 1, 0, 1, 1, 2, 2, 4, 0, 124, 3),
(82, 82, 'Mantzaris Vangelis', 10, 97, 0, 1, 5, 8, 28, 7, 11, 3, 9, 1, 1, 1, 5, 3, 10, 14, 0, 124, 5),
(83, 83, 'Mantzoukas Lefteris', 7, 162, 0, 15, 29, 6, 21, 10, 12, 4, 20, 13, 0, 3, 4, 5, 11, 16, 0, 124, 12),
(84, 84, 'Margaritis Vangelis', 4, 12, 0, 1, 1, 0, 1, 0, 0, 0, 2, 2, 0, 0, 1, 2, 1, 2, 0, 124, 2),
(85, 85, 'Marić Marin', 3, 10, 0, 1, 1, 1, 4, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 124, 2),
(86, 86, 'Martin Hassan', 2, 6, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 124, 2),
(87, 87, 'Mavridis Dimitris', 7, 47, 0, 2, 5, 0, 1, 0, 1, 2, 6, 1, 1, 0, 2, 1, 2, 9, 0, 124, 4),
(88, 88, 'Mavrokefalidis Loukas', 5, 80, 0, 1, 5, 4, 12, 1, 1, 3, 5, 6, 0, 1, 4, 5, 6, 8, 0, 124, 8),
(89, 89, 'Miles Isaiah', 7, 105, 0, 7, 14, 8, 17, 6, 9, 8, 9, 5, 0, 2, 4, 2, 11, 14, 0, 124, 8),
(90, 90, 'Macon Daryl', 3, 7, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 124, 1),
(91, 91, 'Mitrou-Long Elijah', 1, 16, 0, 2, 2, 1, 3, 1, 1, 1, 4, 1, 0, 0, 2, 1, 1, 1, 0, 124, 8),
(92, 92, 'Miller Shonn', 4, 14, 0, 1, 1, 1, 2, 1, 1, 0, 1, 1, 0, 0, 1, 2, 1, 2, 0, 124, 2),
(93, 93, 'Mirosavich Angelos', 10, 178, 0, 25, 33, 6, 14, 8, 12, 15, 31, 11, 5, 1, 7, 8, 13, 13, 0, 124, 9),
(94, 94, 'Molfetas Yiannis', 11, 194, 0, 4, 10, 12, 25, 4, 5, 2, 14, 16, 0, 0, 6, 9, 9, 20, 0, 124, 9),
(95, 95, 'Momirov Stefan ', 1, 16, 0, 1, 2, 1, 3, 1, 2, 0, 2, 1, 1, 0, 1, 0, 2, 3, 0, 124, 8),
(96, 96, 'Moses Kingsley', 6, 127, 0, 12, 30, 10, 25, 5, 9, 1, 9, 13, 1, 2, 5, 10, 13, 9, 0, 124, 11),
(97, 97, 'Mouzourakis Odysseas', 11, 294, 0, 29, 50, 12, 39, 17, 26, 28, 42, 8, 6, 4, 4, 9, 22, 27, 0, 124, 13),
(98, 98, 'Moody Stefan ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(99, 99, 'Mouratos Vasilis', 2, 29, 0, 3, 8, 0, 4, 1, 1, 0, 3, 2, 0, 0, 1, 0, 1, 1, 0, 124, 10),
(100, 100, 'Mustafa Muhaymin ', 11, 176, 0, 25, 43, 2, 9, 9, 14, 16, 22, 7, 9, 3, 9, 7, 15, 20, 0, 124, 7),
(101, 101, 'Bazinas Thanasis', 3, 61, 0, 5, 8, 4, 8, 1, 1, 1, 6, 10, 0, 0, 1, 3, 4, 5, 0, 124, 10),
(102, 102, 'Bazinas Yianis', 8, 201, 0, 27, 63, 1, 3, 13, 17, 22, 23, 4, 9, 5, 5, 11, 18, 21, 0, 124, 13),
(103, 103, 'Billis Sotiris', 5, 70, 0, 2, 5, 7, 15, 4, 4, 1, 4, 3, 0, 0, 3, 2, 5, 9, 0, 124, 8),
(104, 104, 'Borgis Yiorgos', 2, 46, 0, 5, 8, 1, 7, 6, 7, 0, 6, 7, 0, 1, 2, 9, 5, 4, 0, 124, 12),
(105, 105, 'Bokhoridis Eleftherios', 5, 24, 0, 1, 4, 1, 3, 0, 1, 0, 4, 1, 0, 0, 1, 2, 1, 3, 0, 124, 2),
(106, 106, 'Nedović Nemanja ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(107, 107, 'Neofitos Yiorgos', 11, 230, 0, 33, 84, 14, 37, 44, 50, 3, 21, 24, 2, 10, 8, 29, 41, 18, 0, 124, 11),
(108, 108, 'Netzipoglou Omiros', 9, 100, 0, 4, 7, 3, 12, 3, 4, 2, 12, 8, 1, 0, 3, 4, 5, 14, 0, 124, 6),
(109, 109, 'Nikolaidis Alexandros', 9, 56, 0, 1, 3, 2, 8, 2, 3, 4, 6, 1, 0, 0, 0, 2, 3, 5, 0, 124, 3),
(110, 110, 'Davis Mike', 11, 318, 0, 12, 25, 17, 53, 8, 11, 16, 27, 14, 1, 1, 13, 9, 16, 25, 0, 124, 13),
(111, 111, 'Davis Dejon', 3, 20, 0, 2, 3, 0, 0, 0, 1, 1, 1, 2, 0, 0, 0, 2, 2, 5, 0, 124, 4),
(112, 112, 'DiLeo David', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(113, 113, 'Dolezaj Marek ', 7, 113, 0, 17, 35, 4, 16, 11, 15, 4, 7, 8, 2, 3, 3, 11, 17, 12, 0, 124, 9),
(114, 114, 'Dorsey Tyler', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(115, 115, 'Xanthopoulos Vasilis', 2, 30, 0, 2, 3, 2, 4, 3, 5, 0, 3, 2, 0, 0, 2, 3, 3, 3, 0, 124, 10),
(116, 116, 'Ogbeide Derek', 7, 180, 0, 3, 6, 19, 48, 1, 2, 2, 13, 7, 1, 2, 4, 9, 8, 17, 0, 124, 14),
(117, 117, 'Oikonomopoulos Konstantinos', 11, 392, 0, 42, 80, 22, 74, 29, 39, 14, 53, 13, 9, 5, 7, 21, 40, 25, 0, 124, 16),
(118, 118, 'Oikonomopoulos Sotiris', 10, 228, 0, 43, 67, 8, 27, 23, 38, 19, 47, 22, 4, 4, 11, 14, 36, 19, 0, 124, 12),
(119, 119, 'Owens Josh', 11, 213, 0, 10, 19, 11, 35, 7, 10, 16, 23, 5, 1, 2, 9, 8, 10, 25, 0, 124, 9),
(120, 120, 'White Okaro', 2, 8, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 124, 2),
(121, 121, 'Williams Xeyrius ', 6, 43, 0, 3, 5, 1, 2, 1, 1, 3, 5, 2, 0, 0, 1, 5, 1, 9, 0, 124, 4),
(122, 122, 'Williams Kenny ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(123, 123, 'Williams Matt Junior', 10, 154, 0, 11, 17, 8, 23, 10, 12, 5, 19, 19, 2, 0, 6, 11, 18, 22, 0, 124, 8),
(124, 124, 'Papayiannis Yiorgos', 2, 5, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 124, 1),
(125, 125, 'Papadakis Kostas', 2, 7, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 124, 2),
(126, 126, 'Papanikolaou Kostas', 3, 30, 0, 2, 3, 1, 4, 1, 1, 3, 3, 1, 0, 0, 0, 3, 2, 4, 0, 124, 6),
(127, 127, 'Papantoniou Nontas', 10, 163, 0, 9, 17, 10, 22, 4, 7, 9, 26, 7, 0, 1, 7, 7, 12, 19, 0, 124, 8),
(128, 128, 'Papapetrou Ioannis', 2, 11, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 2, 0, 124, 4),
(129, 129, 'Papafotiou Fotis', 10, 256, 0, 26, 54, 8, 23, 22, 30, 5, 21, 24, 1, 2, 14, 18, 27, 22, 0, 124, 13),
(130, 130, 'Pappas Nikos', 4, 82, 0, 3, 10, 4, 12, 2, 2, 1, 4, 11, 1, 1, 1, 5, 2, 7, 0, 124, 12),
(131, 131, 'Perry Kendrick', 11, 126, 0, 12, 20, 2, 4, 5, 8, 9, 16, 7, 3, 1, 7, 7, 7, 18, 0, 124, 5),
(132, 132, 'Persidis Nikolaos', 2, 43, 0, 6, 8, 0, 0, 1, 4, 3, 8, 1, 3, 0, 3, 2, 3, 4, 0, 124, 11),
(133, 133, 'Petanidis Yiorgos', 7, 189, 0, 14, 25, 14, 35, 10, 13, 4, 20, 10, 2, 3, 7, 5, 13, 15, 0, 124, 15),
(134, 134, 'Petanidis Kiriakos', 11, 342, 0, 48, 95, 11, 36, 35, 49, 13, 55, 12, 7, 10, 10, 29, 38, 25, 0, 124, 15),
(135, 135, 'Petropoulos Andreas', 9, 218, 0, 10, 21, 9, 31, 16, 20, 2, 13, 23, 1, 1, 6, 15, 22, 21, 0, 124, 12),
(136, 136, 'Pilavios Alfis', 11, 232, 0, 26, 61, 0, 2, 31, 49, 17, 19, 11, 4, 6, 6, 17, 50, 34, 0, 124, 10),
(137, 137, 'Pippen Danny', 11, 142, 0, 11, 19, 8, 19, 13, 17, 5, 17, 20, 2, 1, 8, 10, 22, 12, 0, 124, 7),
(138, 138, 'Plotas Nikos', 11, 208, 0, 26, 46, 0, 0, 10, 31, 30, 53, 4, 10, 4, 7, 11, 25, 24, 0, 124, 9),
(139, 139, 'Pot Stefan', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(140, 140, 'Poulianitis Stelios', 5, 56, 0, 5, 8, 1, 3, 3, 3, 3, 8, 1, 1, 1, 3, 3, 3, 4, 0, 124, 6),
(141, 141, 'Prapas Stergios', 11, 206, 0, 13, 25, 8, 25, 6, 9, 9, 26, 20, 3, 1, 7, 7, 15, 23, 0, 124, 9),
(142, 142, 'Printezis Yiorgos', 1, 5, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 124, 5),
(143, 143, 'Rautins Andy', 7, 194, 0, 10, 29, 19, 40, 9, 10, 8, 16, 8, 0, 2, 6, 8, 14, 15, 0, 124, 14),
(144, 144, 'Rice Rayvonte ', 7, 73, 0, 11, 16, 0, 1, 2, 5, 8, 14, 3, 1, 1, 2, 4, 4, 12, 0, 124, 5),
(145, 145, 'Renfro Nate ', 11, 106, 0, 15, 27, 0, 0, 9, 10, 8, 8, 3, 0, 3, 4, 6, 7, 25, 0, 124, 5),
(146, 146, 'Ray Kendrick ', 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 1),
(147, 147, 'Rivers Dimitri', 1, 24, 0, 1, 4, 1, 4, 3, 3, 0, 1, 3, 0, 0, 1, 3, 4, 2, 0, 124, 12),
(148, 148, 'Rongavopoulos Nikos', 4, 82, 0, 10, 15, 2, 10, 2, 5, 4, 7, 2, 1, 0, 4, 4, 6, 10, 0, 124, 10),
(149, 149, 'Wroten Tony', 11, 189, 0, 6, 13, 11, 33, 9, 16, 8, 22, 28, 0, 2, 8, 17, 19, 21, 0, 124, 8),
(150, 150, 'Roumoglou Apostolos', 9, 242, 0, 44, 79, 0, 1, 29, 47, 23, 49, 7, 3, 4, 10, 16, 40, 23, 0, 124, 13),
(151, 151, 'Savage Jared', 8, 52, 0, 2, 3, 5, 8, 1, 2, 4, 6, 1, 1, 0, 1, 2, 2, 5, 0, 124, 3),
(152, 152, 'Sant-Roos Howard ', 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 124, 1),
(153, 153, 'Sanders Corey', 11, 243, 0, 11, 27, 18, 40, 17, 19, 2, 14, 20, 1, 2, 4, 16, 20, 29, 0, 124, 12),
(154, 154, 'Saxionis Konstantinos', 11, 328, 0, 31, 65, 14, 56, 32, 43, 4, 34, 76, 1, 6, 13, 43, 52, 34, 0, 124, 14),
(155, 155, 'Sachpatzidis Yiannis', 10, 142, 0, 21, 35, 0, 0, 15, 20, 16, 26, 7, 6, 1, 6, 8, 20, 18, 0, 124, 7),
(156, 156, 'Siva Peyton', 6, 163, 0, 28, 53, 6, 20, 21, 24, 9, 30, 13, 3, 3, 9, 27, 21, 21, 0, 124, 14),
(157, 157, 'Sidiroilias Yiannis', 11, 259, 0, 14, 34, 9, 29, 14, 17, 9, 31, 17, 2, 1, 12, 10, 26, 36, 0, 124, 12),
(158, 158, 'Simons Gerel', 9, 57, 0, 8, 15, 0, 0, 2, 3, 5, 7, 0, 3, 1, 2, 6, 3, 8, 0, 124, 3),
(159, 159, 'Simpson Trevis', 5, 46, 0, 2, 4, 0, 3, 3, 4, 3, 5, 3, 1, 1, 1, 2, 3, 7, 0, 124, 5),
(160, 160, 'Skordilis Gaios', 2, 25, 0, 4, 8, 0, 3, 1, 1, 0, 3, 2, 0, 1, 1, 2, 3, 3, 0, 124, 6),
(161, 161, 'Slaftsakis Diamantis', 5, 88, 0, 6, 13, 3, 17, 9, 12, 3, 7, 9, 0, 1, 4, 3, 13, 16, 0, 124, 9),
(162, 162, 'Sloukas Kostas', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(163, 163, 'Sprintzios Michalis', 10, 180, 0, 37, 53, 0, 0, 13, 25, 15, 26, 12, 9, 4, 4, 14, 22, 25, 0, 124, 9),
(164, 164, 'Spiropoulos Anastasios', 11, 224, 0, 19, 32, 9, 24, 6, 9, 9, 30, 16, 1, 1, 4, 10, 13, 15, 0, 124, 10),
(165, 165, 'Stamatis Dimitris', 8, 67, 0, 7, 12, 4, 10, 2, 4, 5, 10, 3, 1, 1, 2, 5, 3, 10, 0, 124, 4),
(166, 166, 'Schizas Stavros', 11, 330, 0, 21, 44, 22, 66, 7, 12, 15, 40, 10, 6, 3, 9, 14, 12, 34, 0, 124, 15),
(167, 167, 'Tanoulis Yiorgos', 8, 176, 0, 14, 29, 9, 27, 11, 14, 3, 14, 12, 1, 1, 7, 7, 14, 17, 0, 124, 12),
(168, 168, 'Tachiridis Prodromos', 7, 153, 0, 37, 62, 1, 5, 24, 34, 21, 25, 12, 3, 3, 4, 13, 27, 21, 0, 124, 12),
(169, 169, 'Taylor Ryan ', 11, 229, 0, 16, 35, 9, 23, 5, 10, 3, 17, 31, 1, 3, 5, 18, 18, 27, 0, 124, 11),
(170, 170, 'Tzolos Vangelis', 7, 156, 0, 9, 18, 11, 25, 9, 10, 4, 18, 10, 0, 2, 5, 7, 9, 14, 0, 124, 12),
(171, 171, 'Juiston Shakur', 2, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 124, 0),
(172, 172, 'Tillie Kim', 1, 4, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 124, 4),
(173, 173, 'Toliopoulos Vasilis', 4, 92, 0, 10, 26, 4, 13, 3, 5, 2, 5, 15, 0, 2, 4, 11, 5, 11, 0, 124, 11),
(174, 174, 'Tumba Kevin', 3, 91, 0, 18, 30, 3, 9, 16, 19, 6, 18, 8, 1, 2, 2, 8, 15, 10, 0, 124, 15),
(175, 175, 'Tsalmpouris Yiorgos', 8, 61, 0, 2, 5, 2, 6, 1, 1, 2, 6, 1, 1, 0, 0, 1, 1, 5, 0, 124, 4),
(176, 176, 'Tsachtsiras Philippos', 1, 3, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 124, 3),
(177, 177, 'Tsairelis Mikhalis', 11, 231, 0, 14, 39, 15, 38, 30, 34, 2, 15, 54, 0, 1, 12, 20, 35, 11, 0, 124, 11),
(178, 178, 'Tsiakmas Nikos', 10, 174, 0, 12, 22, 13, 35, 6, 8, 4, 10, 5, 2, 2, 6, 5, 7, 18, 0, 124, 9),
(179, 179, 'Fall Moustapha', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(180, 180, 'Filippakos Panayiotis', 3, 77, 0, 6, 15, 6, 12, 5, 6, 2, 5, 6, 1, 1, 3, 6, 6, 7, 0, 124, 15),
(181, 181, 'Fillios Yiorgos', 3, 80, 0, 15, 27, 1, 1, 6, 7, 8, 8, 2, 11, 1, 2, 8, 9, 9, 0, 124, 13),
(182, 182, 'Filoxhenidis Kostas', 11, 217, 0, 16, 26, 8, 32, 13, 16, 3, 31, 44, 1, 2, 15, 15, 22, 28, 0, 124, 9),
(183, 183, 'Flionis Dimitris', 3, 25, 0, 1, 2, 1, 3, 3, 3, 1, 1, 1, 0, 1, 3, 1, 2, 4, 0, 124, 5),
(184, 184, 'Floyd Jordan', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(185, 185, 'Fridas Lampros', 10, 184, 0, 22, 32, 15, 34, 12, 17, 3, 17, 19, 0, 1, 11, 14, 19, 12, 0, 124, 10),
(186, 186, 'Chavales Stelios', 8, 252, 0, 27, 60, 22, 58, 37, 44, 3, 23, 22, 0, 4, 7, 15, 49, 20, 0, 124, 17),
(187, 187, 'Hummer Ian', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 124, 0),
(188, 188, 'Hamilton Daniel', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(189, 189, 'Hanlan Olivier', 5, 8, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 3, 0, 124, 1),
(190, 190, 'Hunt Dario', 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 124, 2),
(191, 191, 'Hudson Jalen ', 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 124, 0),
(192, 192, 'Charitopoulos Dimitris', 8, 171, 0, 6, 15, 13, 41, 14, 17, 3, 9, 21, 0, 2, 3, 8, 17, 11, 0, 124, 11),
(193, 193, 'Chtatzidakis Manolis', 4, 72, 0, 10, 13, 0, 0, 2, 7, 8, 12, 5, 7, 0, 4, 5, 7, 8, 0, 124, 10),
(194, 194, 'Chatzikyriakos Yiorgos', 10, 217, 0, 15, 31, 14, 43, 14, 20, 5, 26, 41, 0, 3, 11, 14, 24, 23, 0, 124, 11),
(195, 195, 'Henry Myke', 1, 16, 0, 0, 2, 0, 3, 0, 0, 0, 4, 3, 0, 0, 1, 0, 2, 3, 0, 124, 8),
(196, 196, 'Chougkaz Nikos', 3, 50, 0, 3, 6, 1, 1, 1, 1, 1, 4, 3, 1, 0, 2, 3, 4, 7, 0, 124, 8),
(197, 197, 'Christodoulou Andreas', 8, 147, 0, 17, 35, 6, 20, 6, 9, 4, 15, 10, 2, 2, 2, 12, 8, 19, 0, 124, 9);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `name` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `icon_path` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`name`, `city`, `icon_path`) VALUES
('AEK', 'Athens', 'https://upload.wikimedia.org/wikipedia/el/2/22/AEK_NEW_LOGO_3_STARS.png'),
('APOLLON P. OSCAR', 'Patra', 'https://upload.wikimedia.org/wikipedia/en/thumb/5/5b/Apollon_Patras_BC.png/220px-Apollon_Patras_BC.png'),
('ARIS', 'Thessaloniki', 'https://upload.wikimedia.org/wikipedia/en/4/4f/Arisbc_crest.png'),
('IONIKOS BASKET', 'Piraeus', 'https://upload.wikimedia.org/wikipedia/el/thumb/c/c2/IonikoshncWHITE.png/350px-IonikoshncWHITE.png'),
('IRAKLIS', 'Thessaloniki', 'https://upload.wikimedia.org/wikipedia/el/5/59/GS_Iraklis_BC_logo.png'),
('KOLOSSOS H HOTELS', 'Rhodes City', 'https://upload.wikimedia.org/wikipedia/en/5/55/Kolossos_Rodou_H_Hotels_logo.png'),
('LARISA', 'Larissa', 'https://upload.wikimedia.org/wikipedia/en/7/79/Larissa_Basketball_Club_Logo.jpg'),
('LAVRIO MEGABOLT', 'Lavrio', 'https://upload.wikimedia.org/wikipedia/en/d/d2/GS_Lavrio_Megabolt_logo.png'),
('OLYMPIAKOS', 'Piraeus', 'https://bit.ly/3Q5HBQy'),
('PANATHINAIKOS OPAP', 'Athens', 'https://bit.ly/3aKiH99'),
('PAOK mateco', 'Thessaloniki', 'https://upload.wikimedia.org/wikipedia/el/e/e7/PAOK_BC_logo.png'),
('PROMITHEAS', 'Patra', 'https://bit.ly/3MGwYAK');

-- --------------------------------------------------------

--
-- Table structure for table `team_stat_card`
--

CREATE TABLE `team_stat_card` (
  `team_stat_card_id` int(11) NOT NULL,
  `team_name` varchar(50) NOT NULL,
  `games_played` int(11) NOT NULL DEFAULT 0,
  `wins` int(11) NOT NULL DEFAULT 0,
  `losses` int(11) NOT NULL DEFAULT 0,
  `rank_points` int(11) NOT NULL DEFAULT 0,
  `points` int(11) NOT NULL DEFAULT 0,
  `made2p` int(11) NOT NULL DEFAULT 0,
  `attempted2p` int(11) NOT NULL DEFAULT 0,
  `made3p` int(11) NOT NULL DEFAULT 0,
  `attempted3p` int(11) NOT NULL DEFAULT 0,
  `madeft` int(11) NOT NULL DEFAULT 0,
  `attemptedft` int(11) NOT NULL DEFAULT 0,
  `off_rebs` int(11) NOT NULL DEFAULT 0,
  `def_rebs` int(11) NOT NULL DEFAULT 0,
  `assist` int(11) NOT NULL DEFAULT 0,
  `blocks` int(11) NOT NULL DEFAULT 0,
  `blocks_on` int(11) NOT NULL DEFAULT 0,
  `steals` int(11) NOT NULL DEFAULT 0,
  `turnovers` int(11) NOT NULL DEFAULT 0,
  `fouls_drawn` int(11) NOT NULL DEFAULT 0,
  `fouls_commited` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `team_stat_card`
--

INSERT INTO `team_stat_card` (`team_stat_card_id`, `team_name`, `games_played`, `wins`, `losses`, `rank_points`, `points`, `made2p`, `attempted2p`, `made3p`, `attempted3p`, `madeft`, `attemptedft`, `off_rebs`, `def_rebs`, `assist`, `blocks`, `blocks_on`, `steals`, `turnovers`, `fouls_drawn`, `fouls_commited`) VALUES
(1, 'OLYMPIAKOS', 11, 10, 1, 21, 1112, 261, 419, 139, 349, 174, 226, 109, 304, 277, 40, 14, 104, 145, 252, 208),
(2, 'PANATHINAIKOS OPAP', 11, 10, 1, 21, 1002, 254, 442, 112, 324, 160, 206, 114, 315, 225, 39, 19, 74, 245, 239, 235),
(3, 'PROMITHEAS', 11, 7, 4, 18, 929, 244, 441, 98, 295, 148, 216, 103, 295, 218, 29, 28, 73, 299, 227, 239),
(4, 'AEK', 11, 5, 6, 16, 914, 205, 392, 110, 342, 176, 247, 107, 290, 201, 30, 26, 81, 296, 247, 227),
(5, 'PAOK mateco', 11, 5, 6, 16, 915, 226, 421, 98, 295, 170, 228, 93, 299, 193, 32, 27, 69, 282, 247, 252),
(6, 'LARISA', 11, 2, 6, 14, 928, 218, 442, 94, 275, 211, 287, 126, 287, 185, 29, 45, 82, 383, 274, 264),
(7, 'IRAKLIS', 11, 3, 8, 11, 898, 223, 442, 94, 308, 170, 240, 114, 305, 173, 38, 21, 96, 351, 249, 243),
(8, 'KOLOSSOS H HOTELS', 11, 4, 7, 18, 901, 214, 449, 110, 308, 145, 199, 94, 294, 208, 21, 33, 96, 311, 228, 249),
(9, 'ARIS', 11, 4, 7, 15, 916, 225, 450, 100, 304, 167, 233, 113, 287, 171, 30, 27, 98, 312, 239, 274),
(10, 'IONIKOS BASKET', 11, 3, 8, 14, 918, 213, 445, 112, 342, 158, 218, 115, 278, 172, 30, 36, 80, 292, 233, 234),
(11, 'APOLLON P. OSCAR', 11, 4, 7, 15, 874, 203, 399, 109, 343, 150, 207, 95, 290, 171, 27, 30, 62, 273, 238, 223),
(12, 'LAVRIO MEGABOLT', 11, 5, 6, 16, 2, 224, 435, 102, 302, 135, 184, 96, 268, 195, 34, 33, 83, 306, 218, 252);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `basket_game`
--
ALTER TABLE `basket_game`
  ADD PRIMARY KEY (`game_id`),
  ADD KEY `team_name1` (`team_name1`),
  ADD KEY `team_name2` (`team_name2`),
  ADD KEY `season_number` (`game_week_number`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`timestamp`),
  ADD KEY `game_id` (`game_id`);

--
-- Indexes for table `game_week`
--
ALTER TABLE `game_week`
  ADD PRIMARY KEY (`game_week_number`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `player_game_stat_card`
--
ALTER TABLE `player_game_stat_card`
  ADD PRIMARY KEY (`game_id`,`player_id`),
  ADD KEY `season_number` (`game_week_number`),
  ADD KEY `player_id` (`player_id`),
  ADD KEY `player_stat_card_id` (`player_stat_card_id`),
  ADD KEY `position` (`position`);

--
-- Indexes for table `player_stat_card`
--
ALTER TABLE `player_stat_card`
  ADD PRIMARY KEY (`player_stat_card_id`),
  ADD KEY `player_id` (`player_id`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `team_stat_card`
--
ALTER TABLE `team_stat_card`
  ADD PRIMARY KEY (`team_stat_card_id`),
  ADD KEY `team_name1` (`team_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `basket_game`
--
ALTER TABLE `basket_game`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `game_week`
--
ALTER TABLE `game_week`
  MODIFY `game_week_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `player_stat_card`
--
ALTER TABLE `player_stat_card`
  MODIFY `player_stat_card_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=198;

--
-- AUTO_INCREMENT for table `team_stat_card`
--
ALTER TABLE `team_stat_card`
  MODIFY `team_stat_card_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `basket_game`
--
ALTER TABLE `basket_game`
  ADD CONSTRAINT `match_constraint2` FOREIGN KEY (`team_name1`) REFERENCES `team` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `match_constraint3` FOREIGN KEY (`team_name2`) REFERENCES `team` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `match_constraint4` FOREIGN KEY (`game_week_number`) REFERENCES `game_week` (`game_week_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_constraint` FOREIGN KEY (`game_id`) REFERENCES `basket_game` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `player_game_stat_card`
--
ALTER TABLE `player_game_stat_card`
  ADD CONSTRAINT `player_game_stat_card_constraint1` FOREIGN KEY (`game_id`) REFERENCES `basket_game` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `player_game_stat_card_constraint2` FOREIGN KEY (`game_week_number`) REFERENCES `game_week` (`game_week_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `player_game_stat_card_constraint3` FOREIGN KEY (`player_stat_card_id`) REFERENCES `player_stat_card` (`player_stat_card_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `player_game_stat_card_constraint4` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `player_stat_card`
--
ALTER TABLE `player_stat_card`
  ADD CONSTRAINT `player_stat_card_constraint1` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `team_stat_card`
--
ALTER TABLE `team_stat_card`
  ADD CONSTRAINT `team_stat_card_constraint1` FOREIGN KEY (`team_name`) REFERENCES `team` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
