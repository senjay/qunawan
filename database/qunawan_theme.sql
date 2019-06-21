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
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1,'漂流'),(2,'美食'),(3,'山水景观'),(4,'自驾游'),(5,'森林公园'),(6,'摄影'),(7,'亲子'),(8,'温泉'),(9,'田园度假'),(10,'古镇村落'),(11,'都市观光'),(12,'民俗文化'),(13,'动植物园'),(14,'海滨岛屿'),(15,'潜水'),(16,'休闲娱乐'),(17,'海岛'),(18,'游学'),(19,'古迹遗址'),(20,'游船'),(21,'主题乐园'),(22,'主题体验'),(23,'演艺'),(24,'场馆'),(25,'特色街区'),(26,'宗教'),(27,'夜景'),(28,'滑雪'),(29,'湿地'),(30,'溶洞'),(31,'园林'),(32,'艺术'),(33,'公园陵园'),(34,'瀑布'),(35,'江南水乡'),(36,'博物馆'),(37,'自然奇观'),(38,'文化艺术'),(39,'垂钓'),(40,'采摘'),(41,'骑马'),(42,'美酒'),(43,'草原沙漠'),(44,'购物'),(45,'游学'),(46,'湖景'),(47,'农家乐'),(48,'热带雨林');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-31 23:21:51
