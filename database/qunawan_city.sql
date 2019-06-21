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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(10) NOT NULL,
  `type` int(1) NOT NULL COMMENT '0：国家，1：省份，2：城市',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `FK200D8B6BCE9EEC` (`parent_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK200D8B6BCE9EEC` FOREIGN KEY (`parent_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=611 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,NULL,'中国',0),(2,NULL,'阿尔及利亚',0),(3,NULL,'阿根廷',0),(4,NULL,'阿联酋',0),(5,NULL,'埃及',0),(6,NULL,'爱尔兰',0),(7,NULL,'奥地利',0),(8,NULL,'澳大利亚',0),(9,NULL,'巴基斯坦',0),(10,NULL,'巴拿马',0),(11,NULL,'巴西',0),(12,NULL,'白俄罗斯',0),(13,NULL,'保加利亚',0),(14,NULL,'比利时',0),(15,NULL,'波多黎各',0),(16,NULL,'波兰',0),(17,NULL,'玻利维亚',0),(18,NULL,'丹麦',0),(19,NULL,'德国',0),(20,NULL,'俄罗斯',0),(21,NULL,'法国',0),(22,NULL,'菲律宾',0),(23,NULL,'芬兰',0),(24,NULL,'古巴',0),(25,NULL,'关岛',0),(26,NULL,'韩国',0),(27,NULL,'荷兰',0),(28,NULL,'加拿大',0),(29,NULL,'柬埔寨',0),(30,NULL,'捷克',0),(31,NULL,'喀麦隆',0),(32,NULL,'科威特',0),(33,NULL,'老挝',0),(34,NULL,'黎嫩',0),(35,NULL,'列支敦士登',0),(36,NULL,'卢森堡',0),(37,NULL,'卢旺达',0),(38,NULL,'罗马尼亚',0),(39,NULL,'马尔代夫',0),(40,NULL,'马来西亚',0),(41,NULL,'美国',0),(42,NULL,'蒙古',0),(43,NULL,'孟加拉',0),(44,NULL,'秘鲁',0),(45,NULL,'墨西哥',0),(46,NULL,'南非',0),(47,NULL,'南斯拉夫',0),(48,NULL,'尼日利亚',0),(49,NULL,'挪威',0),(50,NULL,'葡萄牙',0),(51,NULL,'日本',0),(52,NULL,'瑞典',0),(53,NULL,'瑞士',0),(54,NULL,'塞浦路斯',0),(55,NULL,'沙特阿拉伯',0),(56,NULL,'斯里兰卡',0),(57,NULL,'泰国',0),(58,NULL,'坦桑尼亚',0),(59,NULL,'土耳其',0),(60,NULL,'委内瑞拉',0),(61,NULL,'文莱',0),(62,NULL,'乌克兰',0),(63,NULL,'乌拉圭',0),(64,NULL,'西班牙',0),(65,NULL,'希腊',0),(66,NULL,'新加坡',0),(67,NULL,'新西兰',0),(68,NULL,'匈牙利',0),(69,NULL,'牙买加',0),(70,NULL,'意大利',0),(71,NULL,'印度',0),(72,NULL,'印度尼西亚',0),(73,NULL,'英国',0),(74,NULL,'越南',0),(75,NULL,'智利',0),(76,NULL,'其他国家或地区',0),(77,1,'安徽',1),(78,1,'北京',1),(79,1,'重庆',1),(80,1,'福建',1),(81,1,'甘肃',1),(82,1,'广东',1),(83,1,'广西',1),(84,1,'贵州',1),(85,1,'海南',1),(86,1,'河北',1),(87,1,'河南',1),(88,1,'黑龙江',1),(89,1,'湖北',1),(90,1,'湖南',1),(91,1,'吉林',1),(92,1,'江苏',1),(93,1,'江西',1),(94,1,'辽宁',1),(95,1,'内蒙古',1),(96,1,'宁夏',1),(97,1,'青海',1),(98,1,'山东',1),(99,1,'山西',1),(100,1,'陕西',1),(101,1,'上海',1),(102,1,'四川',1),(103,1,'天津',1),(104,1,'西藏',1),(105,1,'新疆',1),(106,1,'云南',1),(107,1,'浙江',1),(109,1,'香港',1),(110,1,'澳门',1),(111,1,'台湾',1),(112,77,'安庆',2),(113,77,'蚌埠',2),(114,77,'巢湖',2),(115,77,'池州',2),(116,77,'滁州',2),(117,77,'阜阳',2),(118,77,'合肥',2),(119,77,'淮北',2),(120,77,'淮南',2),(121,77,'黄山',2),(122,77,'六安',2),(123,77,'马鞍山',2),(124,77,'宿州',2),(125,77,'铜陵',2),(126,77,'芜湖',2),(127,77,'宣城',2),(128,77,'亳州',2),(129,78,'北京',2),(130,79,'重庆',2),(131,80,'福州',2),(132,80,'龙岩',2),(133,80,'南平',2),(134,80,'宁德',2),(135,80,'莆田',2),(136,80,'泉州',2),(137,80,'三明',2),(138,80,'厦门',2),(139,80,'漳州',2),(140,81,'白银',2),(141,81,'定西',2),(142,81,'甘南藏族自治州',2),(143,81,'嘉峪关',2),(144,81,'金昌',2),(145,81,'酒泉',2),(146,81,'兰州',2),(147,81,'临夏回族自治区',2),(148,81,'陇南',2),(149,81,'平凉',2),(150,81,'庆阳',2),(151,81,'天水',2),(152,81,'武威',2),(153,81,'张掖',2),(154,82,'潮州',2),(155,82,'东莞',2),(156,82,'佛山',2),(157,82,'广州',2),(158,82,'河源',2),(159,82,'惠州',2),(160,82,'江门',2),(161,82,'揭阳',2),(162,82,'茂名',2),(163,82,'梅州',2),(164,82,'清远',2),(165,82,'汕头',2),(166,82,'汕尾',2),(167,82,'韶关',2),(168,82,'深圳',2),(169,82,'阳江',2),(170,82,'云浮',2),(171,82,'湛江',2),(172,82,'肇庆',2),(173,82,'中山',2),(174,82,'珠海',2),(175,83,'百色',2),(176,83,'北海',2),(177,83,'崇左',2),(178,83,'防城港',2),(179,83,'桂林',2),(180,83,'贵港',2),(181,83,'河池',2),(182,83,'贺州',2),(183,83,'来宾',2),(184,83,'柳州',2),(185,83,'南宁',2),(186,83,'钦州',2),(187,83,'梧州',2),(188,83,'玉林',2),(189,84,'安顺',2),(190,84,'毕节',2),(191,84,'贵阳',2),(192,84,'六盘水',2),(193,84,'黔东南苗族侗族自治州',2),(194,84,'黔南布依族苗族自治州',2),(195,84,'黔西南布依族苗族自治',2),(196,84,'铜仁',2),(197,84,'遵义',2),(198,85,'白沙黎族自治县',2),(199,85,'保亭黎族苗族自治县',2),(200,85,'昌江黎族自治县',2),(201,85,'澄迈县',2),(202,85,'定安县',2),(203,85,'东方',2),(204,85,'海口',2),(205,85,'乐东黎族自治县',2),(206,85,'临高县',2),(207,85,'陵水黎族自治县',2),(208,85,'琼海',2),(209,85,'琼中黎族苗族自治县',2),(210,85,'三亚',2),(211,85,'屯昌县',2),(212,85,'万宁',2),(213,85,'文昌',2),(214,85,'五指山',2),(215,85,'儋州',2),(216,86,'保定',2),(217,86,'沧州',2),(218,86,'承德',2),(219,86,'邯郸',2),(220,86,'衡水',2),(221,86,'廊坊',2),(222,86,'秦皇岛',2),(223,86,'石家庄',2),(224,86,'唐山',2),(225,86,'邢台',2),(226,86,'张家口',2),(227,87,'安阳',2),(228,87,'鹤壁',2),(229,87,'济源',2),(230,87,'焦作',2),(231,87,'开封',2),(232,87,'洛阳',2),(233,87,'南阳',2),(234,87,'平顶山',2),(235,87,'三门峡',2),(236,87,'商丘',2),(237,87,'新乡',2),(238,87,'信阳',2),(239,87,'许昌',2),(240,87,'郑州',2),(241,87,'周口',2),(242,87,'驻马店',2),(243,87,'漯河',2),(244,87,'濮阳',2),(245,88,'大庆',2),(246,88,'大兴安岭',2),(247,88,'哈尔滨',2),(248,88,'鹤岗',2),(249,88,'黑河',2),(250,88,'鸡西',2),(251,88,'佳木斯',2),(252,88,'牡丹江',2),(253,88,'七台河',2),(254,88,'齐齐哈尔',2),(255,88,'双鸭山',2),(256,88,'绥化',2),(257,88,'伊春',2),(258,89,'鄂州',0),(259,89,'恩施土家族苗族自治州',2),(260,89,'黄冈',2),(261,89,'黄石',2),(262,89,'荆门',2),(263,89,'荆州',2),(264,89,'潜江',2),(265,89,'神龙架林区',2),(266,89,'十堰',2),(267,89,'随州',2),(268,89,'天门',2),(269,89,'武汉',2),(270,89,'仙桃',2),(271,89,'咸宁',2),(272,89,'襄樊',2),(273,89,'孝感',2),(274,89,'宜昌',2),(275,90,'常德',2),(276,90,'长沙',2),(277,90,'郴州',2),(278,90,'衡阳',2),(279,90,'怀化',2),(280,90,'娄底',2),(281,90,'邵阳',2),(282,90,'湘潭',2),(283,90,'湘西土家族苗族自治州',2),(284,90,'益阳',2),(285,90,'永州',2),(286,90,'岳阳',2),(287,90,'张家界',2),(288,90,'株洲',2),(289,91,'白城',2),(290,91,'白山',2),(291,91,'长春',2),(292,91,'吉林',2),(293,91,'辽源',2),(294,91,'四平',2),(295,91,'松原',2),(296,91,'通化',2),(297,91,'延边朝鲜族自治州',2),(298,92,'常州',2),(299,92,'淮安',2),(300,92,'连云港',2),(301,92,'南京',2),(302,92,'南通',2),(303,92,'苏州',2),(304,92,'宿迁',2),(305,92,'泰州',2),(306,92,'无锡',2),(307,92,'徐州',2),(308,92,'盐城',2),(309,92,'扬州',2),(310,92,'镇江',2),(311,93,'抚州',2),(312,93,'赣州',2),(313,93,'吉安',2),(314,93,'景德镇',2),(315,93,'九江',2),(316,93,'南昌',2),(317,93,'萍乡',2),(318,93,'上饶',2),(319,93,'新余',2),(320,93,'宜春',2),(321,93,'鹰潭',2),(322,94,'鞍山',2),(323,94,'本溪',2),(324,94,'朝阳',2),(325,94,'大连',2),(326,94,'丹东',2),(327,94,'抚顺',2),(328,94,'阜新',2),(329,94,'葫芦岛',2),(330,94,'锦州',2),(331,94,'辽阳',2),(332,94,'盘锦',2),(333,94,'沈阳',2),(334,94,'铁岭',2),(335,94,'营口',2),(336,95,'阿拉善盟',2),(337,95,'巴彦淖尔盟',2),(338,95,'包头',2),(339,95,'赤峰',2),(340,95,'鄂尔多斯',2),(341,95,'呼和浩特',2),(342,95,'呼伦贝尔',2),(343,95,'通辽',2),(344,95,'乌海',2),(345,95,'乌兰察布盟',2),(346,95,'锡林郭勒盟',2),(347,95,'兴安盟',2),(348,96,'固原',2),(349,96,'石嘴山',2),(350,96,'吴忠',2),(351,96,'银川',2),(352,97,'果洛藏族自治州',2),(353,97,'海北藏族自治州',2),(354,97,'海东',2),(355,97,'海南藏族自治州',2),(356,97,'海西蒙古族藏族自治州',2),(357,97,'黄南藏族自治州',2),(358,97,'西宁',2),(359,97,'玉树藏族自治州',2),(360,98,'滨州',2),(361,98,'德州',2),(362,98,'东营',2),(363,98,'菏泽',2),(364,98,'济南',2),(365,98,'济宁',2),(366,98,'莱芜',2),(367,98,'聊城',2),(368,98,'临沂',2),(369,98,'青岛',2),(370,98,'日照',2),(371,98,'泰安',2),(372,98,'威海',2),(373,98,'潍坊',2),(374,98,'烟台',2),(375,98,'枣庄',2),(376,98,'淄博',2),(377,99,'长治',2),(378,99,'大同',2),(379,99,'晋城',2),(380,99,'晋中',2),(381,99,'临汾',2),(382,99,'吕梁',2),(383,99,'朔州',2),(384,99,'太原',2),(385,99,'忻州',2),(386,99,'阳泉',2),(387,99,'运城',2),(460,100,'安康',2),(461,100,'宝鸡',2),(462,100,'汉中',2),(463,100,'商洛',2),(464,100,'铜川',2),(465,100,'渭南',2),(466,100,'西安',2),(467,100,'咸阳',2),(468,100,'延安',2),(469,100,'榆林',2),(470,101,'上海',2),(471,102,'阿坝藏族羌族自治州',2),(472,102,'巴中',2),(473,102,'成都',2),(474,102,'达州',2),(475,102,'德阳',2),(476,102,'甘孜藏族自治州',2),(477,102,'广安',2),(478,102,'广元',2),(479,102,'乐山',2),(480,102,'凉山彝族自治州',2),(481,102,'眉山',2),(482,102,'绵阳',2),(483,102,'南充',2),(484,102,'内江',2),(485,102,'攀枝花',2),(486,102,'遂宁',2),(487,102,'雅安',2),(488,102,'宜宾',2),(489,102,'资阳',2),(490,102,'自贡',2),(491,102,'泸州',2),(492,103,'天津',2),(493,104,'阿里',2),(494,104,'昌都',2),(495,104,'拉萨',2),(496,104,'林芝',2),(497,104,'那曲',2),(498,104,'日喀则',2),(499,104,'山南',2),(500,105,'阿克苏',2),(501,105,'阿拉尔',2),(502,105,'巴音郭楞蒙古自治州',2),(503,105,'博尔塔拉蒙古自治州',2),(504,105,'昌吉回族自治州',2),(505,105,'哈密',2),(506,105,'和田',2),(507,105,'喀什',2),(508,105,'克拉玛依',2),(509,105,'克孜勒苏柯尔克孜自治',2),(510,105,'石河子',2),(511,105,'图木舒克',2),(512,105,'吐鲁番',2),(513,105,'乌鲁木齐',2),(514,105,'五家渠',2),(515,105,'伊犁哈萨克自治州',2),(516,106,'保山',2),(517,106,'楚雄彝族自治州',2),(518,106,'大理白族自治州',2),(519,106,'德宏傣族景颇族自治州',2),(520,106,'迪庆藏族自治州',2),(521,106,'红河哈尼族彝族自治州',2),(522,106,'昆明',2),(523,106,'丽江',2),(524,106,'临沧',2),(525,106,'怒江傈傈族自治州',2),(526,106,'曲靖',2),(527,106,'思茅',2),(528,106,'文山壮族苗族自治州',2),(529,NULL,'西双版纳傣族自治州',2),(530,106,'玉溪',2),(531,106,'昭通',2),(532,107,'杭州',2),(533,107,'湖州',2),(534,107,'嘉兴',2),(535,107,'金华',2),(536,107,'丽水',2),(537,107,'宁波',2),(538,107,'绍兴',2),(539,107,'台州',2),(540,107,'温州',2),(541,107,'舟山',2),(542,107,'衢州',2),(543,532,'淳安县',3),(544,532,'富阳县',3),(545,532,'杭州市',3),(546,532,'建德市',3),(547,532,'临安市',3),(548,532,'桐庐县',3),(549,533,'安吉县',3),(550,533,'长兴县',3),(551,533,'德清县',3),(552,533,'湖州市',3),(553,534,'海宁市',3),(554,534,'海盐县',3),(555,534,'嘉善县',3),(556,534,'嘉兴市',3),(557,534,'平湖市',3),(558,534,'桐乡市',3),(559,535,'东阳市',3),(560,535,'金华市',3),(561,535,'兰溪市',3),(562,535,'磐安县',3),(563,535,'浦江县',3),(564,535,'武义县',3),(565,535,'义乌市',3),(566,535,'永康市',3),(567,536,'丽水市',3),(568,536,'龙泉市',3),(569,536,'青田县',3),(570,536,'庆元县',3),(571,536,'松阳县',3),(572,536,'遂昌县',3),(573,536,'云和县',3),(574,536,'缙云县',3),(575,537,'慈溪市',3),(576,537,'奉化市',3),(577,537,'宁波市',3),(578,537,'宁海县',3),(579,537,'象山县',3),(580,537,'余姚市',3),(581,538,'上虞市',3),(582,538,'绍兴市',3),(583,538,'绍兴县',3),(584,538,'新昌县',3),(585,538,'诸暨市',3),(586,538,'嵊州市',3),(587,539,'临海市',3),(588,539,'三门县',3),(589,539,'台州市',3),(590,539,'天台县',3),(591,539,'温岭市',3),(592,539,'仙居县',3),(593,539,'玉环县',3),(594,540,'苍南县',3),(595,540,'洞头县',3),(596,540,'乐清县',3),(597,540,'平阳县',3),(598,540,'瑞安市',3),(599,540,'泰顺县',3),(600,540,'温州市',3),(601,540,'文成县',3),(602,540,'永嘉县',3),(603,541,'舟山市',3),(604,541,'岱山县',3),(605,541,'嵊泗县',3),(606,542,'常山县',3),(607,542,'江山市',3),(608,542,'开化县',3),(609,542,'龙游县',3),(610,542,'衢州市',3);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-31 23:21:50
