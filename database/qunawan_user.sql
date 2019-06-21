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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(100) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `city` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `img_path` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`phone`,`name`,`email`),
  KEY `FK285FEB2B3ABD95` (`city`),
  KEY `FK285FEBF0968787` (`city`),
  CONSTRAINT `FK285FEB2B3ABD95` FOREIGN KEY (`city`) REFERENCES `city` (`id`),
  CONSTRAINT `FK285FEBF0968787` FOREIGN KEY (`city`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'13052478417','e10adc3949ba59abbe56e057f20f883e',269,'张飞',1,'','946452@qq.com','张二蛋','1990-09-29'),(2,'13052478418','e10adc3949ba59abbe56e057f20f883e',269,'赵云',1,NULL,'9467881@qq.com','赵铁柱','1989-08-01'),(3,'15988649480','e10adc3949ba59abbe56e057f20f883e',269,'马超',1,NULL,'wangwu@163.com','马云','1964-09-30'),(4,'15088649801','e10adc3949ba59abbe56e057f20f883e',269,'黄忠',1,NULL,'xiaohong@163.com','黄飞鸿','1991-01-01'),(5,'13065628981','e10adc3949ba59abbe56e057f20f883e',269,'诸葛亮',1,NULL,'zhangwei@163.com','诸葛匹夫','1965-09-10'),(6,'13052478411','e10adc3949ba59abbe56e057f20f883e',269,'马云龙',0,NULL,'77287618@qq.com','马三炮','1987-01-01'),(7,'18501259810','e10adc3949ba59abbe56e057f20f883e',352,'花祭',1,'','cy1798@qq.com','花无缺','1992-10-15'),(8,'18701721202','e10adc3949ba59abbe56e057f20f883e',NULL,'大校楚轩',1,'','505871117@qq.com','楚大校','1989-03-01'),(52,'18701721202','e10adc3949ba59abbe56e057f20f883e',101,'张三',1,NULL,'94645289@qq.com','张三丰','1990-09-29'),(53,'13052445321','e10adc3949ba59abbe56e057f20f883e',101,'李四',1,NULL,'1897281@qq.com','李四','1989-09-01'),(54,'13052478415','e10adc3949ba59abbe56e057f20f883e',101,'老六',1,NULL,'1897231@qq.com','赵六','1976-04-01'),(55,'13054442512','e10adc3949ba59abbe56e057f20f883e',577,'清风',1,NULL,'1897623@qq.com','张全蛋','1989-08-01'),(56,'13054442510','e10adc3949ba59abbe56e057f20f883e',577,'马儒',1,NULL,'8782781@qq.com','唐马儒','1985-06-08'),(57,'12345678901','e10adc3949ba59abbe56e057f20f883e',NULL,'aa',0,NULL,'aa@aa.com','aa',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-31 23:21:40
