-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 12 Sie 2014, 23:55
-- Wersja serwera: 5.5.21-log
-- Wersja PHP: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `plugins`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `gildie`
--

CREATE TABLE IF NOT EXISTS `gildie` (
  `lider` char(50) DEFAULT NULL,
  `logo` text,
  `zastepca` text,
  `nazwa` text,
  `center` text,
  `sojusze` text CHARACTER SET utf8 COLLATE utf8_polish_ci,
  `expiretime` text,
  `createtime` text,
  `effecttime` text,
  `size` text,
  `home` text,
  `limit` text,
  `skarbiec` text,
  `zycia` text,
  `zyciatime` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `statystyki`
--


CREATE TABLE IF NOT EXISTS `statystyki` (
  `nick` text COLLATE utf8_polish_ci NOT NULL,
  `punkty` int(10) NOT NULL,
  `zabojstwa` int(10) NOT NULL,
  `smierci` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;


-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sojusze`
--


CREATE TABLE IF NOT EXISTS `sojusze` (
  `g0` char(50) DEFAULT NULL,
  `g1` char(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `czlonkowie`
--


CREATE TABLE IF NOT EXISTS `czlonkowie` (
  `nick` char(50) DEFAULT NULL,
  `gildia` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
