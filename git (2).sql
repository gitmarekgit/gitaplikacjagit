-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sty 18, 2024 at 03:23 PM
-- Wersja serwera: 10.4.32-MariaDB
-- Wersja PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `git`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `logowanie`
--

CREATE TABLE `logowanie` (
  `ID` int(11) NOT NULL,
  `Login` text NOT NULL,
  `Haslo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Dumping data for table `logowanie`
--

INSERT INTO `logowanie` (`ID`, `Login`, `Haslo`) VALUES
(1, 'admin', 'admin1');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `muzyka`
--

CREATE TABLE `muzyka` (
  `ID` int(11) NOT NULL,
  `Autor` text NOT NULL,
  `Utwor` text NOT NULL,
  `Album` text NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Dumping data for table `muzyka`
--

INSERT INTO `muzyka` (`ID`, `Autor`, `Utwor`, `Album`, `userID`) VALUES
(13, 'aa', 'bb', 'cc', 1),
(14, 'aa', 'bb', 'cc', 6);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rejestracja`
--

CREATE TABLE `rejestracja` (
  `ID` int(11) NOT NULL,
  `Login` text NOT NULL,
  `Haslo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `logowanie`
--
ALTER TABLE `logowanie`
  ADD PRIMARY KEY (`ID`);

--
-- Indeksy dla tabeli `muzyka`
--
ALTER TABLE `muzyka`
  ADD PRIMARY KEY (`ID`);

--
-- Indeksy dla tabeli `rejestracja`
--
ALTER TABLE `rejestracja`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logowanie`
--
ALTER TABLE `logowanie`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `muzyka`
--
ALTER TABLE `muzyka`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `rejestracja`
--
ALTER TABLE `rejestracja`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
