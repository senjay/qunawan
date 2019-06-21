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
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `city` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK499E8E72B3ABD95` (`city`),
  KEY `FK499E8E7F0968787` (`city`),
  CONSTRAINT `FK499E8E7F0968787` FOREIGN KEY (`city`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_place` FOREIGN KEY (`city`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,'东方明珠',101),(2,'西湖',107),(3,'千岛湖',543),(4,'嘉兴',534),(5,'杭州',532),(6,'建德',546),(7,'宋城',532),(8,'湘湖',532),(9,'西塘',555),(10,'普陀山',603),(11,'桐庐',548),(12,'通天河',548),(13,'桂花岛',543),(14,'上海欢乐谷',470),(15,'东方明珠',470),(16,'上海博物馆',470),(17,'上海野生动物园',470),(18,'上海世纪公园',470),(19,'上海黄浦江游览',470),(20,'杜夫人蜡像馆',470),(21,'佘山',470),(22,'上海植物园',470),(23,'东平国家森林公园',470),(24,'天目湖',298),(25,'石浦渔村',579),(26,'佛顶山',603),(27,'奉化溪口',576),(28,'雪窦山',576),(29,'大明山',532),(30,'桂林',179),(31,'阳朔',179),(32,'桂林漓江',179),(33,'临安',532),(34,'浙江',107),(35,'江苏',92),(36,'苏州',303),(37,'张家港',303),(38,'云南',106),(39,'昆明',522),(40,'西双版纳',529),(41,'厦门',138),(42,'鼓浪屿',138),(43,'南普陀寺',138),(44,'成都',473),(45,'九寨沟',471),(46,'三亚',210),(47,'蜈支洲岛',210),(48,'天涯海角',210),(49,'东北',247),(50,'哈尔滨',247),(51,'韩国',26),(52,'首尔',26),(53,'塞班岛',41),(54,'西班牙',64),(55,'葡萄牙',50),(56,'意大利',70),(57,'巴厘岛',72),(58,'南非',46),(59,'希腊',65);
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
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
