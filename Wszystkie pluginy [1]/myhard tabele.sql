CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `nick` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `lastIp` varchar(255) NOT NULL,
  `firstIP` varchar(255) NOT NULL,
  `premium` int(1) NOT NULL,
  `lastPlayed` bigint(255) NOT NULL,
  `firstPlayed` bigint(255) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `deaths` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `player` varchar(32) NOT NULL,
  `killer` varchar(32) NOT NULL,
  `time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `mh_alliances` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `guild_1` varchar(4) NOT NULL,
  `guild_2` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `mh_guilds` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tag` varchar(4) COLLATE utf8_polish_ci NOT NULL,
  `name` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `owner` varchar(36) COLLATE utf8_polish_ci NOT NULL,
  `leader` varchar(36) COLLATE utf8_polish_ci NOT NULL,
  `cuboidWorld` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `cuboidX` int(10) NOT NULL,
  `cuboidZ` int(10) NOT NULL,
  `cuboidSize` int(10) NOT NULL,
  `homeWorld` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `homeX` int(10) NOT NULL,
  `homeY` int(10) NOT NULL,
  `homeZ` int(10) NOT NULL,
  `createTime` bigint(13) NOT NULL DEFAULT '0',
  `expireTime` bigint(13) NOT NULL DEFAULT '0',
  `pvp` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `mh_admin_logs` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `time` bigint(13) NOT NULL,
  `command` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `mh_backups` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `time` bigint(13) NOT NULL,
  `armor` text NOT NULL,
  `inventory` text NOT NULL,
  `enderchest` text NOT NULL,
  `location` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`,`uuid`)
);

CREATE TABLE IF NOT EXISTS `mh_backups` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `time` bigint(13) NOT NULL,
  `armor` text NOT NULL,
  `inventory` text NOT NULL,
  `enderchest` text NOT NULL,
  `location` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`,`uuid`)
);

CREATE TABLE IF NOT EXISTS `mh_bans` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `admin` varchar(255) NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `createTime` bigint(13) NOT NULL,
  `expireTime` bigint(13) NOT NULL DEFAULT '0',
  `unban` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`uuid`)
);

CREATE TABLE IF NOT EXISTS `mh_blacklisted` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `mh_codes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(8) NOT NULL,
  `time` bigint(13) NOT NULL DEFAULT '0',
  `nick` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
);

CREATE TABLE IF NOT EXISTS `mh_hardcore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL,
  `ban_start_time` bigint(255) NOT NULL,
  `ban_end_time` bigint(255) NOT NULL,
  `desc` varchar(255) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `unban` int(1) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `mh_ipbans` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ip` varchar(32) NOT NULL,
  `admin` varchar(255) NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `createTime` bigint(13) NOT NULL,
  `expireTime` bigint(13) NOT NULL DEFAULT '0',
  `unban` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`ip`)
);

CREATE TABLE IF NOT EXISTS `mh_members` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) COLLATE utf8_polish_ci NOT NULL,
  `tag` varchar(4) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
);

CREATE TABLE IF NOT EXISTS `mh_ubcodes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `time` bigint(13) NOT NULL DEFAULT '-1',
  `used` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
);

CREATE TABLE IF NOT EXISTS `mh_unbanlogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(32) NOT NULL,
  `time` bigint(20) NOT NULL,
  `code` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `mh_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `lastName` varchar(16) NOT NULL,
  `gamemode` int(1) NOT NULL,
  `fly` int(1) NOT NULL,
  `god` int(1) NOT NULL,
  `lastWorld` varchar(32) NOT NULL,
  `lastX` int(10) NOT NULL,
  `lastY` int(10) NOT NULL,
  `lastZ` int(10) NOT NULL,
  `homeWorld` varchar(32) NOT NULL,
  `homeX` int(10) NOT NULL,
  `homeY` int(10) NOT NULL,
  `homeZ` int(10) NOT NULL,
  `kills` int(10) NOT NULL,
  `deaths` int(10) NOT NULL,
  `logouts` int(10) NOT NULL,
  `points` int(10) NOT NULL,
  `timePlay` int(10) NOT NULL,
  `firstIp` varchar(32) NOT NULL,
  `lastIp` varchar(32) NOT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `id` (`id`)
);

CREATE TABLE IF NOT EXISTS `mh_whitelisted` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
);