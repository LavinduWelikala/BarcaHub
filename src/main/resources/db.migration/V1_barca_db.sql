CREATE TABLE `culer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `clubs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `founded_year` int NOT NULL,
  `manager` varchar(255) DEFAULT NULL,
  `motto` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `president` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `news` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `published_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `player` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `jersey_number` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `club_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9qstgybpoo3jootiiccqusc13` (`club_id`),
  CONSTRAINT `FK9qstgybpoo3jootiiccqusc13` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `stadium` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci