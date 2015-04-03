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
-- Struktura tabeli dla tabeli `bans`
--
 
CREATE TABLE IF NOT EXISTS `bans` (
  `banID` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(16) NOT NULL,
  `powod` varchar(64) NOT NULL,
  `time` bigint(20) NOT NULL,
  `admin` varchar(16) NOT NULL,
  PRIMARY KEY (`banID`),
  UNIQUE KEY `Nick` (`Nick`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
 
-- --------------------------------------------------------
--
-- Struktura tabeli dla tabeli `users`
--
 
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `z` int(11) DEFAULT NULL,
  `home` varchar(64) DEFAULT NULL,
  `nick` varchar(64) NOT NULL,
  `world` varchar(16) NOT NULL,
  `mute` varchar(16) DEFAULT NULL,
  `fly` int(1) DEFAULT NULL,  
  `gamemode` int(1) DEFAULT NULL,
  `god` int(1) DEFAULT NULL,
  `muteTime` bigint(20) DEFAULT NULL,
  `pkt` int(1) DEFAULT NULL,
  `lvl` int(1) DEFAULT NULL,
  `itemshop` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `nick` (`nick`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
 
-- --------------------------------------------------------
 
--
 
 
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;