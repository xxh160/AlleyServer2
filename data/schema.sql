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
INSERT INTO `arch_picture` (`arch_id`, `picture`) VALUES (2,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/3.%20%E9%80%B8%E5%A4%AB%E6%A5%BC.png'),(3,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/4.%20%E5%B7%A6%E6%B6%A4%E6%B1%9F%E6%A5%BC.png'),(4,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/5.%20%E5%9B%BD%E9%99%85%E5%AD%A6%E9%99%A2.jpg'),(5,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/6.%20%E5%AE%9E%E9%AA%8C%E6%A5%BC.jpg'),(6,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/7.%20%E5%9F%BA%E7%A1%80%E5%AE%9E%E9%AA%8C%E6%A5%BC.png'),(7,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/8.%20456%E9%A3%9F.jpg'),(8,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/9.%20%E4%B8%80%E6%A0%8B.png'),(9,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/10.%20%E4%B8%89%E6%A0%8B.png'),(10,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/11.%20%E4%BA%8C%E6%A0%8B.jpg'),(11,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/12.%20%E4%BA%94%E6%A0%8B.png'),(12,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/13.%20%E5%9B%9B%E6%A0%8B.png'),(13,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/14.%20%E7%AF%AE%E7%90%83%E5%9C%BA.png'),(14,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/15.%20%E6%96%B9%E8%82%87%E5%91%A8.jpg'),(15,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/16.%20%E7%82%9C%E5%8D%8E.jpg'),(17,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/17.%20%E4%BB%99%E4%BA%8C.jpg'),(16,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/18.%20%E4%BB%99%E4%B8%80.jpg'),(18,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/19.%20%E5%9B%BE%E4%B9%A6%E9%A6%86.jpg'),(19,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/20.%20%E7%94%B5%E5%AD%90%E6%A5%BC.jpg'),(20,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/21.%20%E5%9C%B0%E7%A7%91%E6%A5%BC.jpg'),(21,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/22.%20%E5%9C%B0%E6%B5%B7.jpg'),(22,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/23.%20%E8%AE%A1%E7%A7%91%E6%A5%BC.png'),(23,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/24.%20%E8%A1%8C%E6%94%BF%E5%8D%97%E6%A5%BC.jpg'),(24,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/25.%20%E8%A1%8C%E6%94%BF%E5%8C%97%E6%A5%BC.jpg'),(25,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/26.%20%E5%9B%BD%E9%99%85%E4%BC%9A%E8%AE%AE%E4%B8%AD%E5%BF%83.png'),(26,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/27.%20%E6%98%9F%E4%BA%91%E6%A5%BC.jpg'),(27,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/28.%20%E5%8D%81%E4%BA%8C%E6%A0%8B.png'),(28,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/29.%2010%E9%A3%9F.jpg'),(29,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/30.%2012%E6%A0%8B.png'),(30,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/31.%2014%E6%A0%8B.png'),(31,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/32.%2013%E6%A0%8B.jpg'),(32,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/33.%20%E7%BD%91%E7%BB%9C%E4%BF%A1%E6%81%AF%E4%B8%AD%E5%BF%83.png'),(33,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/34.%20%E6%A1%A3%E6%A1%88%E9%A6%86.jpg'),(34,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/35.%20%E6%A0%A1%E5%8F%B2%E9%A6%86.png'),(35,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/36.%20%E5%A4%A7%E6%B4%BB.jpg'),(36,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/37.%20%E5%A4%96%E9%99%A2.jpg'),(37,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/38.%20%E6%96%87%E5%AD%A6%E9%99%A2.jpg'),(38,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/39.%20%E5%93%B2%E5%AD%A6%E7%B3%BB.jpg'),(39,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/40.%20%E5%8C%A1%E4%BA%9A%E6%98%8E%E5%AD%A6%E9%99%A2.png'),(40,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/41.%20%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E5%AD%A6%E9%99%A2.png'),(41,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/42.%20%E6%94%BF%E7%AE%A1%E9%99%A2.jpg'),(42,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/43.%20%E7%A4%BE%E4%BC%9A%E5%AD%A6%E9%99%A2.png'),(43,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/44.%20%E5%8E%86%E5%8F%B2%E5%AD%A6%E9%99%A2.jpg'),(44,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/45.%20%E6%96%B0%E4%BC%A0.jpg'),(45,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/46.%20%E6%B8%B8%E6%B3%B3%E9%A6%86.jpg'),(46,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/47.%20%E5%85%AD%E6%A0%8B.png'),(47,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/48.%20%E5%BF%AB%E9%80%92%E7%AB%99.png'),(48,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/49.7%E6%A0%8B.png'),(49,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/50.8%E6%A0%8B.png'),(50,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/51.9%E6%A0%8B.png'),(51,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/52.10%E6%A0%8B.png'),(52,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/53.11%E6%A0%8B.png'),(53,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/54.%209%E9%A3%9F.jpg'),(54,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/55.%20%E7%BD%91%E7%90%83%E5%9C%BA.png'),(55,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/56.%20%E6%A0%A1%E5%8C%BB%E9%99%A2.png'),(56,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/57.%20%E4%BF%9D%E5%8D%AB%E5%A4%84.jpg'),(57,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/58.%20%E7%AC%AC%E4%B8%89%E9%A2%86%E5%9F%9F.png'),(58,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/59.%20%E7%8E%AF%E9%99%A2.jpg'),(59,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/60.%20%E5%A4%A7%E6%B0%94%E9%99%A2%E6%A5%BC.jpg'),(60,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/61.%20%E5%8C%96%E5%AD%A6%E9%99%A2.jpg'),(61,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/62.%20%E7%94%9F%E7%A7%91%E6%A5%BC.jpg'),(62,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/63.%20%E7%AC%AC%E4%BA%8C%E8%BF%90%E5%8A%A8%E5%9C%BA.png'),(63,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/64.%20%E7%AC%AC%E4%BA%8C%E4%BD%93%E8%82%B2%E9%A6%86.jpg'),(64,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/65.%20%E5%8C%BB%E5%AD%A6%E9%99%A2.jpg'),(65,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/66.%20%E9%95%87%E6%B1%9F%E6%A5%BC.png'),(66,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/67.%20%E4%BA%BA%E5%B7%A5%E6%99%BA%E8%83%BD%E5%AD%A6%E9%99%A2.png'),(67,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/68.24%E6%A0%8B.png'),(68,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/69.16%E6%A0%8B.png'),(69,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/70.%2011shi.jpg'),(70,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/71.23%E6%A0%8B.png'),(71,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/72.%2022%E6%A0%8B.jpg'),(72,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/73.%2017%E6%A0%8B.jpg'),(73,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/74.%2021%E6%A0%8B.jpg'),(74,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/75.%2020%E6%A0%8B.jpg'),(75,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/76.%2019%E6%A0%8B.jpg'),(76,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/77.%2018%E6%A0%8B.jpg'),(77,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/78.%20%E5%A4%A9%E6%96%87%E5%8F%B0.jpg'),(78,'https://s3.bmp.ovh/imgs/2021/08/9fd7dc9618773b70.jpg'),(79,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/80.%20%E5%A4%A9%E6%96%87%E9%99%A2.jpg'),(80,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/81.%20%E6%A2%85%E5%B2%AD.png'),(81,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/82.%20%E7%A4%BE%E4%BC%9A%E5%AD%A6%E9%99%A2.jpg'),(82,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/83.%20%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E5%A4%A7%E6%A5%BC.jpg'),(83,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/84.%20%E6%96%B0%E9%97%BB%E4%BC%A0%E6%92%AD%E5%AD%A6%E9%99%A2%E9%99%A2%E6%A5%BC.jpg'),(84,'https://nju-se.oss-cn-beijing.aliyuncs.com/alley-v2/arch/85.%20%E5%A4%96%E5%9B%BD%E8%AF%AD%E5%AD%A6%E9%99%A2.png');
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

-- Dump completed on 2021-08-23 18:28:49
