-- MariaDB dump 10.19  Distrib 10.6.4-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: alley_v2
-- ------------------------------------------------------
-- Server version	10.6.4-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arch`
--

DROP TABLE IF EXISTS `arch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arch` (
  `arch_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `latitude` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `longitude` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `des` varchar(2048) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`arch_id`),
  UNIQUE KEY `arch_arch_id_uindex` (`arch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arch`
--

LOCK TABLES `arch` WRITE;
/*!40000 ALTER TABLE `arch` DISABLE KEYS */;
INSERT INTO `arch` (`arch_id`, `name`, `latitude`, `longitude`, `des`) VALUES (2,'逸夫楼','32.110551','118.960141','主要教学楼之一'),(3,'左涤江楼','32.110771','118.959322','逸夫楼B区，主要教学楼之一'),(4,'国际学院','32.110407','118.959048','逸夫楼C区，主要教学楼之一'),(5,'纪忠楼','32.110432','118.958098','基础实验楼'),(6,'基础实验楼','32.11008','118.957148','纪忠楼'),(7,'四五六食堂','32.111255','118.955174','一组团食堂'),(8,'一栋','32.11233','118.954643','一组团学生宿舍楼'),(9,'三栋','32.11355','118.953939','一组团学生宿舍楼'),(10,'二栋','32.113959','118.955271','一组团学生宿舍楼'),(11,'五栋','32.114785','118.953491','一组团学生宿舍楼'),(12,'四栋','32.115164','118.954736','一组团学生宿舍楼'),(13,'篮球场','32.111411','118.95657','学生活动场所'),(14,'方肇周','32.112657','118.956186','综合体育馆'),(15,'炜华体育场','32.111883','118.957863','仙林校区第一运动场'),(16,'择善楼','32.111531','118.959614','仙二，公共教学楼北楼'),(17,'思源楼','32.112203','118.959113','仙一，公共教学楼南楼'),(18,'杜厦图书馆','32.114154','118.960221','中国唯一一座双枢纽管理体系的智能化信息图书馆。'),(19,'潘忠来楼','32.110853','118.961697','电子科学与工程学院'),(20,'朱共山楼','32.111814','118.961433','地球科学与工程学院'),(21,'昆山楼','32.112599','118.961573','地理与海洋科学学院'),(22,'常州楼','32.110999','118.962899','计算机科学与技术系'),(23,'行政南楼','32.112017','118.963109','扬州楼，为仙林校区的行政办公楼'),(24,'行政北楼','32.112913','118.962835','扬州楼，为仙林校区的行政办公楼，'),(25,'国际会议中心','32.114333','118.963455','按四星级标准建造集多种功能为一体的综合建筑体。'),(26,'星云楼','32.113876','118.962331','主要用途为对佛教文化进行研究'),(27,'12栋','32.114815','118.962039','三组团学生宿舍楼'),(28,'十食堂','32.115063','118.963193','食堂之一'),(29,'15栋','32.115604','118.963369','三组团学生宿舍楼'),(30,'14栋','32.115619','118.962584','三组团学生宿舍楼'),(31,'13栋','32.115555','118.961563','三组团学生宿舍楼'),(32,'网络信息中心','32.115145','118.960411','网络信息中心'),(33,'淮安楼','32.115042','118.959613','档案馆'),(34,'校史馆','32.11438','118.958299','陈列校园历史文件'),(35,'大活','32.113764','118.957874','敬文大学生活动中心'),(36,'外院','32.116168','118.960785','见侨裕楼'),(37,'杨宗义楼','32.116046','118.959916','文学院院楼'),(38,'薛光林楼','32.116445','118.959091','哲学系'),(39,'匡亚明学院','32.116582','118.960184','见潘琦楼'),(40,'信息管理学院','32.116975','118.960359','见潘琦楼'),(41,'政府管理学院','32.117087','118.959702','见河仁楼'),(42,'社会学院','32.118129','118.959551','见河仁楼'),(43,'历史学院','32.118864','118.959044','历史学院楼'),(44,'新传院','32.119889','118.959432','见紫金楼'),(45,'游泳馆','32.116203','118.958282','暂不开放'),(46,'6栋','32.115163','118.957732','二组团学生宿舍'),(47,'快递站','32.1147','118.956468','取快递的地方'),(48,'7栋','32.115355','118.956149','二组团学生宿舍'),(49,'8栋','32.115823','118.957088','二组团学生宿舍'),(50,'9栋','32.115827','118.955736','二组团学生宿舍'),(51,'10栋','32.116097','118.956452','二组团学生宿舍'),(52,'11栋','32.116934','118.955964','二组团学生宿舍'),(53,'九食','32.116597','118.955514','食堂之一'),(54,'网球馆','32.115982','118.954199','学生活动场所'),(55,'校医院','32.115702','118.953191','负责校园医疗工作'),(56,'保卫处','32.116258','118.953155','负责校园安保工作'),(57,'第三领域','32.117154','118.953272','咖啡馆'),(58,'环院','32.117278','118.953527','环境科学学院的科研，教学用房。'),(59,'大气科学院','32.117702','118.955159','大气科学院院楼'),(60,'苏州楼','32.118193','118.953009','化学化工学院'),(61,'无锡楼','32.119066','118.954723','生命科学学院'),(62,'第二运动场','32.120461','118.953065','第二个运动场'),(63,'第二体育馆','32.121125','118.951571','第二个体育馆'),(64,'医学院','32.119858','118.954383','医学院院楼'),(65,'镇江楼','32.121046','118.955172','现代工学院'),(66,'人工智能学院','32.12148','118.954815','火爆专业'),(67,'24栋','32.122731','118.953633','四组团学生宿舍'),(68,'16栋','32.122639','118.951336','四组团学生宿舍'),(69,'十一食','32.122742','118.952256','食堂之一'),(70,'23栋','32.123482','118.953635','四组团学生宿舍'),(71,'22栋','32.123621','118.952313','四组团学生宿舍'),(72,'17栋','32.123491','118.951415','四组团学生宿舍'),(73,'21栋','32.124532','118.953919','四组团学生宿舍'),(74,'20栋','32.124452','118.953164','四组团学生宿舍'),(75,'19栋','32.124426','118.952386','四组团学生宿舍'),(76,'18栋','32.124436','118.95147','四组团学生宿舍'),(77,'左涤江天文台','32.121886','118.960584','天文与空间科学学院的天文教学场所'),(78,'梅岭','32.118208','118.957275','梅岭气象观测场'),(79,'天文楼','32.125307','118.960379','整个场地呈不规则形。'),(80,'圣达楼','32.117087','118.959702','政府管理学院和马克思主义学院所在地。'),(81,'河仁楼','32.118129','118.959551','社会学院，河仁社会慈善学院。'),(82,'潘琦楼','32.116582','118.960184','匡亚明学院，信息管理学院，大学外语部。'),(83,'紫金楼','32.119889','118.959432','新闻传播学院院楼。'),(84,'侨裕楼','32.116168','118.960785','外国语学院院楼');
/*!40000 ALTER TABLE `arch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arch_picture`
--

DROP TABLE IF EXISTS `arch_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arch_picture` (
  `arch_id` int(11) NOT NULL,
  `picture` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arch_picture`
--

LOCK TABLES `arch_picture` WRITE;
/*!40000 ALTER TABLE `arch_picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `arch_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `arch_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `father_id` int(11) NOT NULL,
  `content` varchar(2048) COLLATE utf8mb4_unicode_ci NOT NULL,
  `like_num` int(11) NOT NULL,
  `create_t` datetime NOT NULL,
  `picture` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE KEY `comment_comment_id_uindex` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like`
--

DROP TABLE IF EXISTS `like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `like` (
  `user_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like`
--

LOCK TABLES `like` WRITE;
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
/*!40000 ALTER TABLE `like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mark` (
  `user_id` int(11) NOT NULL,
  `arch_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`arch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark`
--

LOCK TABLES `mark` WRITE;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_unread` tinyint(1) NOT NULL,
  `comment_id` int(11) NOT NULL,
  PRIMARY KEY (`notice_id`),
  UNIQUE KEY `notice_notice_id_uindex` (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` int(11) NOT NULL,
  `avatar` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `locate_auth` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_info_open_id_uindex` (`open_id`),
  UNIQUE KEY `user_info_user_id_uindex` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`user_id`, `open_id`, `name`, `gender`, `avatar`, `locate_auth`) VALUES (1,'null','系统',1,'-2',1);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-18  4:37:10
