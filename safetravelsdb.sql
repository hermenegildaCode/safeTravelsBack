-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: safetravelsdb
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

use heroku_9b1e7c968780182;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `bookingId` bigint NOT NULL AUTO_INCREMENT,
  `b_username` varchar(20) DEFAULT NULL,
  `hotelId` bigint DEFAULT NULL,
  `roomId` bigint DEFAULT NULL,
  `checkinDate` date DEFAULT NULL,
  `checkoutDate` date DEFAULT NULL,
  `cancelled` tinyint(1) DEFAULT NULL,
  `breakfastIncluded` tinyint(1) DEFAULT NULL,
  `freecancellation` tinyint(1) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `review` varchar(2000) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `booking_id` int NOT NULL,
  `breakfast_included` bit(1) NOT NULL,
  `checkin_date` date DEFAULT NULL,
  `checkout_date` date DEFAULT NULL,
  `hotel_id` int NOT NULL,
  `room_id` int DEFAULT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `username` (`b_username`),
  KEY `hotelId` (`hotelId`),
  KEY `roomId` (`roomId`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`b_username`) REFERENCES `usr` (`username`) ON DELETE CASCADE,
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`hotelId`) REFERENCES `hotel` (`id`) ON DELETE CASCADE,
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`roomId`) REFERENCES `room` (`roomId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'maurinho',NULL,NULL,NULL,NULL,0,NULL,NULL,0,NULL,0,0,_binary '','2021-09-21','2021-09-18',39,0),(29,'eloncinho',NULL,NULL,NULL,NULL,0,NULL,NULL,65,NULL,0,135,_binary '','2021-09-02','2021-09-03',34,95),(30,'eloncinho',NULL,NULL,NULL,NULL,0,NULL,NULL,250,NULL,0,136,_binary '','2021-09-21','2021-09-23',28,87),(31,'eloncinho',NULL,NULL,NULL,NULL,0,NULL,NULL,60,NULL,0,137,_binary '','2021-09-01','2021-09-02',38,105),(32,'test',NULL,NULL,NULL,NULL,0,NULL,NULL,60,NULL,0,138,_binary '','2021-09-20','2021-09-22',38,105);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (139);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `numberOfRooms` int DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stars` int DEFAULT NULL,
  `pool` tinyint(1) DEFAULT NULL,
  `hdescription` varchar(500) DEFAULT NULL,
  `spa` tinyint(1) DEFAULT NULL,
  `wifi` tinyint(1) DEFAULT NULL,
  `parking` tinyint(1) DEFAULT NULL,
  `airportShuttle` tinyint(1) DEFAULT NULL,
  `pets` tinyint(1) DEFAULT NULL,
  `recommended` tinyint(1) DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `hotelname` varchar(255) DEFAULT NULL,
  `number_of_rooms` int NOT NULL,
  `breakfastPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (28,NULL,'Praza do Obradoiro 1,15705','Santiago','A Coruña','att@hostalreiscatolicos.com','981585858',NULL,4.5,231,5,0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,1,1,NULL,0,1,0,'Parador Hostal Dos Reis Catolicos',50,10),(29,NULL,'Illa da Toxa, S/N, 36991','O Grove','Pontevedra','granhotellatoja@eurostars.com','983786578',NULL,4,115,5,1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',1,1,1,NULL,0,1,0,'Eurostars Gran Hotel La Toja',300,10),(30,NULL,'Rua Portelo 20, 32660','Allariz','Ourense','att@oportelorural.com','982946578',NULL,4.5,55,2,0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,1,0,NULL,0,0,0,'O Portelo Rural',15,10),(31,NULL,'Avda Concepción Arenal 51, 15179','Santa Cruz de Oleiros','A Coruña','hello@noaboutique.com','981845685',NULL,4.6,270,4,1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,1,1,NULL,0,0,0,'Noa Boutique Hotel',20,10),(32,NULL,'Ronda de Outeiro, 99A, 15007','A Coruña','A Coruña','hello@noaboutique.com','981845685',NULL,4,270,4,1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',1,1,1,NULL,0,1,0,'Hotel Avenida',20,10),(33,NULL,'Lugar a Hermida s/n, 27560','Monterroso','Lugo','hello@astorres.com','981845685',NULL,5,120,5,0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,1,1,NULL,0,0,5,'Hotel As Torres da Hermida',20,10),(34,NULL,'Cristosende, 31, 32765','Cristosende','Ourense','hello@casagrandecr.com','98646685',NULL,4.2,76,3,0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,1,1,NULL,0,0,10,'Casa Grande de Cristosende',50,10),(35,NULL,'Camiño do Pazo s/n, 27460','Sober','Lugo','hello@torreshermida.gal','986655685',NULL,4.3,179,4,1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',1,1,1,NULL,0,0,2,'Eurostars Pazo de Sober',60,10),(36,NULL,'Rúa San Francisco 5, 27700','Ribadeo','Lugo','hello@rosmary.com','981845685',NULL,4.2,65,1,0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,0,0,NULL,0,0,5,'Hotel Ros Mary',8,10),(37,NULL,'Rúa Os Olmos 62, 36630','Cambados','Pontevedra','hello@villaprado.com','988845685',NULL,4,129,2,0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,1,0,NULL,0,0,0,'Villaprado',10,10),(38,NULL,'Paseo del Parrote 2-4, 15001','A Coruña','A Coruña','att@nhcorunafinisterre.com','981665858',NULL,4.5,105,5,1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',0,1,1,NULL,0,1,0,'NH Collection A Coruña Finisterre',100,10);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `hotelId` bigint DEFAULT NULL,
  `roomId` bigint NOT NULL AUTO_INCREMENT,
  `maxHosts` int DEFAULT NULL,
  `privateBathroom` tinyint(1) DEFAULT NULL,
  `privateToilet` tinyint(1) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `mountainView` tinyint(1) DEFAULT NULL,
  `seaView` tinyint(1) DEFAULT NULL,
  `balcony` tinyint(1) DEFAULT NULL,
  `ac` tinyint(1) DEFAULT NULL,
  `minibar` tinyint(1) DEFAULT NULL,
  `flatScreenTv` tinyint(1) DEFAULT NULL,
  `jacuzzi` tinyint(1) DEFAULT NULL,
  `numberOfRoomsLikeThis` int DEFAULT NULL,
  `room_id` int NOT NULL,
  `flat_screen_tv` bit(1) NOT NULL,
  `hotel_id` int NOT NULL,
  `max_hosts` int NOT NULL,
  `mountain_view` bit(1) NOT NULL,
  `private_bathroom` bit(1) NOT NULL,
  `private_toilet` bit(1) NOT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `sea_view` bit(1) NOT NULL,
  `number_of_rooms_like_this` int NOT NULL,
  PRIMARY KEY (`roomId`),
  KEY `hotelId` (`hotelId`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotelId`) REFERENCES `hotel` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (NULL,13,NULL,NULL,NULL,60,NULL,NULL,1,1,1,NULL,0,NULL,82,_binary '',30,1,_binary '\0',_binary '',_binary '','single',_binary '\0',3),(NULL,14,NULL,NULL,NULL,60,NULL,NULL,1,1,1,NULL,0,NULL,83,_binary '',30,2,_binary '\0',_binary '',_binary '','double',_binary '\0',8),(NULL,15,NULL,NULL,NULL,220,NULL,NULL,1,1,1,NULL,0,NULL,84,_binary '',29,2,_binary '',_binary '',_binary '','double',_binary '',100),(NULL,16,NULL,NULL,NULL,220,NULL,NULL,1,1,1,NULL,0,NULL,85,_binary '',29,2,_binary '',_binary '',_binary '','double',_binary '\0',100),(NULL,17,NULL,NULL,NULL,200,NULL,NULL,1,1,1,NULL,0,NULL,86,_binary '',29,2,_binary '',_binary '',_binary '','single',_binary '',50),(NULL,18,NULL,NULL,NULL,250,NULL,NULL,1,1,1,NULL,0,NULL,87,_binary '',28,1,_binary '',_binary '',_binary '','single',_binary '\0',20),(NULL,19,NULL,NULL,NULL,290,NULL,NULL,1,1,1,NULL,0,NULL,88,_binary '',28,2,_binary '',_binary '',_binary '','double',_binary '\0',80),(NULL,20,NULL,NULL,NULL,80,NULL,NULL,1,1,1,NULL,0,NULL,89,_binary '',31,1,_binary '',_binary '',_binary '','single',_binary '\0',10),(NULL,21,NULL,NULL,NULL,90,NULL,NULL,1,1,1,NULL,0,NULL,90,_binary '',31,2,_binary '',_binary '',_binary '','double',_binary '\0',20),(NULL,22,NULL,NULL,NULL,90,NULL,NULL,1,1,1,NULL,1,NULL,91,_binary '',32,2,_binary '',_binary '',_binary '','double',_binary '\0',80),(NULL,23,NULL,NULL,NULL,70,NULL,NULL,1,1,1,NULL,1,NULL,92,_binary '',32,1,_binary '',_binary '',_binary '','single',_binary '\0',80),(NULL,24,NULL,NULL,NULL,60,NULL,NULL,1,1,1,NULL,1,NULL,93,_binary '',33,1,_binary '',_binary '',_binary '','single',_binary '\0',30),(NULL,25,NULL,NULL,NULL,70,NULL,NULL,1,1,1,NULL,0,NULL,94,_binary '',33,2,_binary '',_binary '',_binary '','double',_binary '\0',60),(NULL,26,NULL,NULL,NULL,65,NULL,NULL,1,1,1,NULL,0,NULL,95,_binary '',34,2,_binary '',_binary '',_binary '','double',_binary '\0',50),(NULL,27,NULL,NULL,NULL,50,NULL,NULL,1,1,1,NULL,0,NULL,96,_binary '',34,1,_binary '',_binary '',_binary '','single',_binary '\0',10),(NULL,28,NULL,NULL,NULL,60,NULL,NULL,1,1,1,NULL,0,NULL,97,_binary '',35,1,_binary '',_binary '',_binary '','single',_binary '\0',20),(NULL,29,NULL,NULL,NULL,65,NULL,NULL,1,1,1,NULL,0,NULL,98,_binary '',35,2,_binary '',_binary '',_binary '','double',_binary '\0',60),(NULL,30,NULL,NULL,NULL,35,NULL,NULL,0,0,0,NULL,0,NULL,99,_binary '\0',36,2,_binary '\0',_binary '',_binary '','double',_binary '\0',60),(NULL,31,NULL,NULL,NULL,30,NULL,NULL,0,0,0,NULL,0,NULL,100,_binary '\0',36,1,_binary '\0',_binary '',_binary '','single',_binary '\0',60),(NULL,32,NULL,NULL,NULL,30,NULL,NULL,0,0,0,NULL,0,NULL,101,_binary '\0',37,1,_binary '\0',_binary '',_binary '','single',_binary '\0',10),(NULL,33,NULL,NULL,NULL,40,NULL,NULL,0,0,0,NULL,0,NULL,102,_binary '\0',37,2,_binary '\0',_binary '',_binary '','double',_binary '\0',30),(NULL,34,NULL,NULL,NULL,76,NULL,NULL,0,0,0,NULL,0,NULL,103,_binary '\0',38,2,_binary '\0',_binary '',_binary '','double',_binary '',30),(NULL,35,NULL,NULL,NULL,65,NULL,NULL,0,0,0,NULL,0,NULL,104,_binary '\0',38,2,_binary '\0',_binary '',_binary '','double',_binary '\0',30),(NULL,36,NULL,NULL,NULL,60,NULL,NULL,0,0,0,NULL,0,NULL,105,_binary '\0',38,1,_binary '\0',_binary '',_binary '','single',_binary '\0',20),(NULL,37,NULL,NULL,NULL,20,NULL,NULL,1,1,1,NULL,1,NULL,106,_binary '\0',39,2,_binary '',_binary '',_binary '','double',_binary '\0',1),(NULL,38,NULL,NULL,NULL,200,NULL,NULL,0,1,1,NULL,0,NULL,120,_binary '\0',31,2,_binary '',_binary '',_binary '','double',_binary '',3);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr`
--

DROP TABLE IF EXISTS `usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `usr` (
  `email` varchar(30) NOT NULL,
  `passwd` varchar(700) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `usrrole` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `UKdfui7gxngrgwn9ewee3ogtgym` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr`
--

LOCK TABLES `usr` WRITE;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` VALUES ('elonmusk@tesla.com','$2a$10$Ipr3groe1UqSNW6ryY5jzu2NVwPxsex6NrxX3p4ARsfyKxbNEd5mS','eloncinho',NULL),('fulgencio@gmail.com','$2a$10$/poyxWRV8.JKdNE2Dh1Ki.e1LiY7KfYnVjzM.Z/xPDfFhR9WJIUtu','fulgencio',NULL),('jeffbezos@gmail.com','abc123..','jeff',NULL),('jotaeminha@gmail.com','$2a$10$5FCHZ88bG4AmxVgarRGpxeAmfdmW./b4.8oKzM9aOtynUjYHmo..y','jotaeminha',NULL),('maurosilva@mauro.com','$2a$10$EhTVd4kgjH.0L13tkdLWPeLQ9rmjHjXfcimTc/QCtuWJ3z9oEtzxa','maurinho',NULL),('merda@merda.com','$2a$10$07IPxNw2ZIaDFIJKqjyJqOhAdkDsPTrb5EPR4jRcWseplMaJcnWgi','merda',NULL),('test@test.com','$2a$10$5h.Nopnv1EVPtcw.klrlH.qqOM2OQR0yg28k2PayIzOsXLY/k6D3C','test',NULL);
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_role`
--

DROP TABLE IF EXISTS `usr_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `usr_role` (
  `usr_email` varchar(255) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`usr_email`,`role_id`),
  KEY `FKxmva6wt104q4i8fovnthnlgf` (`role_id`),
  CONSTRAINT `FKxmva6wt104q4i8fovnthnlgf` FOREIGN KEY (`role_id`) REFERENCES `usrrole` (`role_id`),
  CONSTRAINT `FKy0mbnpycv0aq6ffbavlg0av4` FOREIGN KEY (`usr_email`) REFERENCES `usr` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_role`
--

LOCK TABLES `usr_role` WRITE;
/*!40000 ALTER TABLE `usr_role` DISABLE KEYS */;
INSERT INTO `usr_role` VALUES ('elonmusk@tesla.com',3),('fulgencio@gmail.com',3),('jotaeminha@gmail.com',3),('maurosilva@mauro.com',3),('merda@merda.com',3),('test@test.com',3);
/*!40000 ALTER TABLE `usr_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usrrole`
--

DROP TABLE IF EXISTS `usrrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `usrrole` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usrrole`
--

LOCK TABLES `usrrole` WRITE;
/*!40000 ALTER TABLE `usrrole` DISABLE KEYS */;
INSERT INTO `usrrole` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MODERATOR'),(3,'ROLE_USER');
/*!40000 ALTER TABLE `usrrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-04 13:50:24
