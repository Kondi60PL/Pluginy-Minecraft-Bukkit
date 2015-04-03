-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost:3066
-- Czas wygenerowania: 29 Sty 2014, 00:09
-- Wersja serwera: 5.5.29
-- Wersja PHP: 5.3.10-1ubuntu3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `Guilds`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla  `Gildie`
--

CREATE TABLE IF NOT EXISTS `Gildie` (
  `gildiaID` int(11) NOT NULL AUTO_INCREMENT,
  `liderID` int(11) NOT NULL,
  `tag` varchar(6) NOT NULL,
  `nazwa` varchar(64) NOT NULL,
  `opis` varchar(256) DEFAULT NULL,
  `bazaworld` varchar(16) DEFAULT NULL,
  `bazaX` int(11) DEFAULT NULL,
  `bazaY` int(11) DEFAULT NULL,
  `bazaZ` int(11) DEFAULT NULL,
  `zalozono` bigint(20) NOT NULL,
  `promienCuboid` bigint(20) DEFAULT NULL,
  `friendlyFire` int(11) DEFAULT NULL,
  `zastepcaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`gildiaID`),
  UNIQUE KEY `liderID` (`liderID`),
  UNIQUE KEY `tag` (`tag`),
  UNIQUE KEY `nazwa` (`nazwa`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla  `Gracze`
--

CREATE TABLE IF NOT EXISTS `Gracze` (
  `graczID` int(11) NOT NULL AUTO_INCREMENT,
  `gildiaID` int(11) DEFAULT NULL,
  `nick` varchar(16) NOT NULL,
  `ranking` int(11) NOT NULL,
  PRIMARY KEY (`graczID`),
  UNIQUE KEY `nick` (`nick`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla  `Sojusze`
--

CREATE TABLE IF NOT EXISTS `Sojusze` (
  `sojuszID` int(11) NOT NULL AUTO_INCREMENT,
  `gildiaID1` int(11) NOT NULL,
  `gildiaID2` int(11) NOT NULL,
  `propozycjaSojuszu` tinyint(4) NOT NULL,
  PRIMARY KEY (`sojuszID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla  `Zaproszenia`
--

CREATE TABLE IF NOT EXISTS `Zaproszenia` (
  `zaproszenieID` int(11) NOT NULL AUTO_INCREMENT,
  `graczID` int(11) NOT NULL,
  `gildiaID` int(11) NOT NULL,
  PRIMARY KEY (`zaproszenieID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla  `Zgony`
--

CREATE TABLE IF NOT EXISTS `Zgony` (
  `zgonID` int(11) NOT NULL AUTO_INCREMENT,
  `powod` varchar(16) NOT NULL,
  `zabityID` int(11) NOT NULL,
  `zabijajacyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`zgonID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
