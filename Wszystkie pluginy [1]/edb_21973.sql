-- phpMyAdmin SQL Dump
-- version 4.2.10.1
-- http://www.phpmyadmin.net
--
-- Host: gs5.enderchest.pl
-- Czas generowania: 27 Lut 2015, 19:28
-- Wersja serwera: 5.5.41-0+wheezy1
-- Wersja PHP: 5.4.36-0+deb7u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `edb_21973`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_admin_logs`
--

CREATE TABLE IF NOT EXISTS `mh_admin_logs` (
  `id` int(11) DEFAULT NULL,
  `uuid` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `command` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_alliances`
--

CREATE TABLE IF NOT EXISTS `mh_alliances` (
  `id` int(11) DEFAULT NULL,
  `guild_1` int(11) DEFAULT NULL,
  `guild_2` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_backups`
--

CREATE TABLE IF NOT EXISTS `mh_backups` (
  `id` int(11) DEFAULT NULL,
  `uuid` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `armor` int(11) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `enderchest` int(11) DEFAULT NULL,
  `location` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_bans`
--

CREATE TABLE IF NOT EXISTS `mh_bans` (
  `id` int(11) DEFAULT NULL,
  `uuid` int(11) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  `reason` int(11) DEFAULT NULL,
  `createTime` int(11) DEFAULT NULL,
  `expireTime` int(11) DEFAULT NULL,
  `unban` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_blacklisted`
--

CREATE TABLE IF NOT EXISTS `mh_blacklisted` (
  `id` int(11) DEFAULT NULL,
  `uuid` int(11) DEFAULT NULL,
  `reason` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_guilds`
--

CREATE TABLE IF NOT EXISTS `mh_guilds` (
  `id` int(11) DEFAULT NULL,
  `tag` int(11) DEFAULT NULL,
  `name` int(11) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `leader` int(11) DEFAULT NULL,
  `cuboidWorld` int(11) DEFAULT NULL,
  `cuboidX` int(11) DEFAULT NULL,
  `cuboidZ` int(11) DEFAULT NULL,
  `cuboidSize` int(11) DEFAULT NULL,
  `homeWorld` int(11) DEFAULT NULL,
  `homeX` int(11) DEFAULT NULL,
  `homeY` int(11) DEFAULT NULL,
  `homeZ` int(11) DEFAULT NULL,
  `createTime` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_hardcore`
--

CREATE TABLE IF NOT EXISTS `mh_hardcore` (
  `uuid` int(11) DEFAULT NULL,
  `ban_start_time` int(11) DEFAULT NULL,
  `ban_end_time` int(11) DEFAULT NULL,
  `ip` int(11) DEFAULT NULL,
  `desc` int(11) DEFAULT NULL,
  `unban` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_ipbans`
--

CREATE TABLE IF NOT EXISTS `mh_ipbans` (
  `id` int(11) DEFAULT NULL,
  `ip` int(11) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  `reason` int(11) DEFAULT NULL,
  `createTime` int(11) DEFAULT NULL,
  `expireTime` int(11) DEFAULT NULL,
  `unban` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_members`
--

CREATE TABLE IF NOT EXISTS `mh_members` (
  `id` int(11) DEFAULT NULL,
  `uuid` int(11) DEFAULT NULL,
  `tag` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_users`
--

CREATE TABLE IF NOT EXISTS `mh_users` (
  `id` int(11) DEFAULT NULL,
  `uuid` int(11) DEFAULT NULL,
  `lastName` int(11) DEFAULT NULL,
  `gamemode` int(11) DEFAULT NULL,
  `fly` int(11) DEFAULT NULL,
  `god` int(11) DEFAULT NULL,
  `lastWorld` int(11) DEFAULT NULL,
  `lastX` int(11) DEFAULT NULL,
  `lastY` int(11) DEFAULT NULL,
  `lastZ` int(11) DEFAULT NULL,
  `homeWorld` int(11) DEFAULT NULL,
  `homeX` int(11) DEFAULT NULL,
  `homeY` int(11) DEFAULT NULL,
  `homeZ` int(11) DEFAULT NULL,
  `kills` int(11) DEFAULT NULL,
  `deaths` int(11) DEFAULT NULL,
  `logouts` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `timePlay` int(11) DEFAULT NULL,
  `firstIp` int(11) DEFAULT NULL,
  `lastIp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `mh_whitelisted`
--

CREATE TABLE IF NOT EXISTS `mh_whitelisted` (
  `id` int(11) DEFAULT NULL,
  `uuid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
