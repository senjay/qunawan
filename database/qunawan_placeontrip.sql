CREATE DATABASE  IF NOT EXISTS `qunawan` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `qunawan`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: qunawan
-- ------------------------------------------------------
-- Server version	5.5.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `placeontrip`
--

DROP TABLE IF EXISTS `placeontrip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `placeontrip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `place` int(11) NOT NULL,
  `trip` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `place` (`place`),
  KEY `trip` (`trip`),
  CONSTRAINT `placeontrip_ibfk_1` FOREIGN KEY (`place`) REFERENCES `place` (`id`),
  CONSTRAINT `placeontrip_ibfk_2` FOREIGN KEY (`trip`) REFERENCES `trip` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `placeontrip`
--

LOCK TABLES `placeontrip` WRITE;
/*!40000 ALTER TABLE `placeontrip` DISABLE KEYS */;
INSERT INTO `placeontrip` VALUES (1,1,2),(2,2,3),(3,4,1),(4,5,5),(5,3,6),(6,6,7),(7,4,4),(8,3,8),(9,7,9),(10,14,10),(11,5,11),(12,8,11),(13,3,12),(14,6,13),(15,9,14),(16,9,15),(17,3,16),(18,10,17),(19,3,18),(20,12,19),(21,13,19),(22,25,20),(23,10,21),(24,26,21),(25,27,21),(26,28,21),(27,7,22),(28,14,23),(29,17,24),(30,29,25),(31,5,25),(32,1,1),(33,2,2),(34,3,3),(35,5,4),(36,5,5),(37,6,6),(38,7,7),(39,8,8),(40,9,9),(41,10,10),(42,11,11),(43,12,12),(44,13,13),(45,14,14),(46,15,15),(47,16,16),(48,17,17),(49,18,18),(50,19,19),(51,20,20),(52,21,21),(53,22,22),(54,23,23),(55,24,24),(56,25,25),(57,30,26),(58,31,26),(59,32,26),(60,5,27),(61,33,27),(62,34,27),(63,35,28),(64,36,28),(65,37,28),(66,38,29),(67,39,29),(68,40,29),(69,41,30),(70,42,30),(71,43,30),(72,44,31),(73,45,31),(74,46,32),(75,47,32),(76,48,32),(77,49,33),(78,50,33),(79,51,34),(80,52,34),(81,53,35),(82,54,36),(83,55,36),(84,56,37),(85,57,38),(86,58,39),(87,59,40);
/*!40000 ALTER TABLE `placeontrip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-31 23:21:39
