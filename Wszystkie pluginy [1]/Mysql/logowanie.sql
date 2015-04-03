-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 26 Lut 2014, 16:35
-- Wersja serwera: 5.5.21-log
-- Wersja PHP: 5.4.10
 
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
 
 
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
 
--
-- Baza danych: `deq1997_guilds`
--
 
-- --------------------------------------------------------
 
--
-- Struktura tabeli dla tabeli `Cubestars`
--
 
CREATE TABLE IF NOT EXISTS `Cubestars` (
  `nick` text,
  `haslo` text,
  `ip` text,
  `status` text,
  `lastloc` text,
  `zamrozony` text,
  `inv` text,
  `eq` text,
  `teleport` text,
  `czasteleportacji` text,
  `TrybTeleportacji` text,
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

 
-- --------------------------------------------------------
 
--
 
 
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;