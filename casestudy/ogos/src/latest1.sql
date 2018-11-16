-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: ogos
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `user_id` varchar(36) DEFAULT NULL,
  `product_id` varchar(36) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL,
  `modificationtime` datetime DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_detail`
--

DROP TABLE IF EXISTS `customer_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_detail` (
  `user_id` varchar(100) DEFAULT NULL,
  `house_no` varchar(36) DEFAULT NULL,
  `landmark` varchar(36) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `contact_no` varchar(16) DEFAULT NULL,
  `customer_rating` int(8) DEFAULT NULL,
  `zipcode` varchar(36) DEFAULT NULL,
  `customer_id` varchar(36) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `customer_detail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_detail`
--

LOCK TABLES `customer_detail` WRITE;
/*!40000 ALTER TABLE `customer_detail` DISABLE KEYS */;
INSERT INTO `customer_detail` VALUES ('7cee1416-182b-4343-9070-d47eac31b64a',NULL,NULL,NULL,NULL,NULL,NULL,'17ab61fb-8b94-4b3b-bc7f-76b05059da14'),('c51046ea-6d10-4590-9d03-4a8b4c26fe9b',NULL,NULL,NULL,NULL,NULL,NULL,'2954ff60-504e-4a75-a3a7-e153e47f0add'),('226ba0a5-2e59-4059-a91f-ae356126f93a',NULL,NULL,NULL,NULL,NULL,NULL,'330737b7-b553-45e3-9765-b707aa6cc382'),('226ba0a5-2e59-4059-a91f-ae356126f93a',NULL,NULL,NULL,NULL,NULL,NULL,'4611de66-df84-4e9d-b791-f61ac5e45dc3'),('c51046ea-6d10-4590-9d03-4a8b4c26fe9b',NULL,NULL,NULL,NULL,NULL,NULL,'51760730-9c9c-4743-80d9-9d72c46099df'),('226ba0a5-2e59-4059-a91f-ae356126f93a',NULL,NULL,NULL,NULL,NULL,NULL,'76d16096-80bc-4a1d-a688-8e613e37b228'),('226ba0a5-2e59-4059-a91f-ae356126f93a',NULL,NULL,NULL,NULL,NULL,NULL,'9712143d-4155-489b-bcaf-ca2832a7a2a3'),('226ba0a5-2e59-4059-a91f-ae356126f93a',NULL,NULL,NULL,NULL,NULL,NULL,'b5cd6c29-f248-451c-8b35-0fff3b6bb880'),(NULL,NULL,NULL,NULL,NULL,NULL,NULL,'c13f5b3f-a48d-4746-8a31-aa35e1c76581'),(NULL,'1','abc','def',NULL,NULL,NULL,'cb78cea8-fbd7-49ed-bbb2-ae9dd85555d1'),(NULL,NULL,NULL,NULL,NULL,NULL,NULL,'d40860d0-fa63-4f56-83ef-e9b1a18dd753'),(NULL,'1','abc','def',NULL,NULL,NULL,'dc26a2b3-5e68-445e-91d8-500ff091ddd4'),(NULL,NULL,NULL,NULL,NULL,NULL,NULL,'e103f3d3-1dd3-41d8-a8cb-7b8b6ee237b3'),('c51046ea-6d10-4590-9d03-4a8b4c26fe9b',NULL,NULL,NULL,NULL,NULL,NULL,'e6359508-36ed-45d4-ab05-816db332bd47');
/*!40000 ALTER TABLE `customer_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_feedback`
--

DROP TABLE IF EXISTS `customer_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_feedback` (
  `order_id` varchar(36) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  `feedback` varchar(16) DEFAULT NULL,
  `comments` varchar(128) DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL,
  `modificationtime` datetime DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `customer_feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `customer_feedback_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_feedback`
--

LOCK TABLES `customer_feedback` WRITE;
/*!40000 ALTER TABLE `customer_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_details` (
  `order_id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_weight` double DEFAULT NULL,
  `product_detail` text,
  `creationtime` datetime DEFAULT NULL,
  `modificationtime` datetime DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `delivery_status` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES ('031663f8-e34a-4ff2-b2cd-55ff91ea0741','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'[]','2018-10-23 10:58:41','2018-10-23 10:58:41',0,NULL),('49f1d109-e73c-484a-96c2-c260dbf5a6c7','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'{}','2018-10-23 12:44:28','2018-10-23 12:44:28',0,NULL),('5450ad68-1bca-402f-916b-7e4d45311d7c','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,NULL,'2018-10-23 10:46:23','2018-10-23 10:46:23',0,NULL),('62c669f8-8ae0-4caa-b7e4-0677b73a4734','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'{\"df\":\"df\"}','2018-10-23 12:48:09','2018-10-23 12:48:09',0,NULL),('78b089d7-8ed7-4a05-8885-b68d105c1245','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'[]','2018-10-23 10:59:49','2018-10-23 10:59:49',0,NULL),('a1d08d70-f522-4d9b-8b1c-327ab52f95a2','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,NULL,'2018-10-23 10:49:15','2018-10-23 10:49:15',0,NULL),('a2ded8b2-5c36-425c-944a-0ad079086071','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'{}','2018-10-23 10:51:45','2018-10-23 10:51:45',0,NULL),('a3a68dbc-dd31-4efa-9d57-0719be994389','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'gfg','2018-10-23 11:18:54','2018-10-23 11:18:54',0,NULL),('b8764144-7a95-48ec-a3cd-457bb1cf4c91','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'{}','2018-10-23 10:50:36','2018-10-23 10:50:36',0,NULL),('ee20e722-708c-4676-85b0-9c599f410868','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,NULL,'2018-10-23 10:46:52','2018-10-23 10:46:52',0,NULL),('fae06db0-04bc-4cc4-941b-6ae047b7893b','0273bbae-d2e9-4522-af72-5bc68b749107',0,0,'{}','2018-10-23 14:06:59','2018-10-23 14:06:59',0,NULL);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_category` (
  `category_id` varchar(36) NOT NULL,
  `category_name` varchar(36) DEFAULT NULL,
  `image_url` varchar(64) DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL,
  `modificationtime` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES ('95ea4f9f-561e-4e7f-b202-f6021f6b904f','vegetables','assets/icon.png','2018-10-25 16:10:32','2018-10-25 16:10:32'),('a4699e68-7d74-41c6-9dcf-d455aa00b589','Fruits','assets/icon.png','2018-10-25 16:10:38','2018-10-25 16:10:38');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` varchar(36) NOT NULL,
  `category_id` varchar(36) DEFAULT NULL,
  `product_name` varchar(36) DEFAULT NULL,
  `quantity` int(16) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT '1',
  `image_url` varchar(64) DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL,
  `modificationtime` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('4851b709-a1ca-4e42-8157-951e2f9c553f','a4699e68-7d74-41c6-9dcf-d455aa00b589','Apple',50,5,500,1,'assets/icon.png','2018-10-25 16:18:21','2018-10-25 16:18:21'),('7ce6f10c-3437-4bef-94bc-bd4b87f76fc7','95ea4f9f-561e-4e7f-b202-f6021f6b904f','Tomato',50,5,500,1,'assets/icon.png','2018-10-25 16:17:54','2018-10-25 16:17:54'),('900f9013-4899-4857-b580-da7c36c19ed3','a4699e68-7d74-41c6-9dcf-d455aa00b589','Orange',50,5,500,1,'assets/icon.png','2018-10-25 16:18:26','2018-10-25 16:18:26'),('fc416b59-b07a-4b09-ac9d-cf2be50a98d6','95ea4f9f-561e-4e7f-b202-f6021f6b904f','Potato',50,5,500,0,'assets/icon.png','2018-10-25 16:17:06','2018-10-25 16:17:06');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_provider`
--

DROP TABLE IF EXISTS `service_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_provider` (
  `service_provider_id` varchar(36) DEFAULT NULL,
  `order_id` varchar(36) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL,
  `modificationtime` datetime DEFAULT NULL,
  `delivery_status` varchar(36) DEFAULT 'placed',
  `provider_pk` varchar(36) NOT NULL,
  PRIMARY KEY (`provider_pk`),
  KEY `service_provider_id` (`service_provider_id`),
  KEY `order_id` (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `service_provider_ibfk_1` FOREIGN KEY (`service_provider_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `service_provider_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`order_id`),
  CONSTRAINT `service_provider_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_provider`
--

LOCK TABLES `service_provider` WRITE;
/*!40000 ALTER TABLE `service_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(36) NOT NULL,
  `email` varchar(36) DEFAULT NULL,
  `user_name` varchar(36) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT '1',
  `creationtime` datetime DEFAULT NULL,
  `modificationtime` datetime DEFAULT NULL,
  `role` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0273bbae-d2e9-4522-af72-5bc68b749107','adf','xyz',NULL,1,'2018-10-18 19:01:01','2018-10-18 19:01:01',NULL),('1eb8b0e2-2e08-4b04-a391-241894afad27','def','xyz','password',1,'2018-10-18 10:01:11','2018-10-18 10:01:11',NULL),('226ba0a5-2e59-4059-a91f-ae356126f93a','divyansh.yadav@impetus.co.in',NULL,'$2a$10$tsMPD48cdeWLEz5vDs.aYeZyktRMAlTm5DiSfq/.8WCvAESDRIWjq',1,'2018-10-22 11:41:19','2018-10-22 11:41:19','customer'),('27f77cdd-5ee6-4f5d-a34f-458a5414d753','rajat.jain@impetus.co.in','Rajat Jain','$2a$10$sZVHT05RZrc3lQGVBIH2/OOx6OXHkkNja3LebZW30KwuaCQnUwPwS',1,'2018-10-24 15:26:14','2018-10-24 15:26:14','customer'),('2e6e2e4f-c835-494a-8fcc-a3bccc57b2f1','keerti@gmail.com','Keerti Modi','123456',1,'2018-10-25 10:02:13','2018-10-25 10:02:13','customer'),('2f03a247-e571-4942-84ba-8597edc71adc','abc@abc.com','abc','123456',1,'2018-10-24 17:13:15','2018-10-24 17:13:15','admin'),('3ad0c2b7-5cae-4d71-8566-5d6d420766d2',NULL,'sd',NULL,1,'2018-10-25 10:53:14','2018-10-25 10:53:14','customer'),('4dc0199c-3345-4bb0-ad5d-5c7648c6d2b7','cde','xyz',NULL,1,'2018-10-18 10:00:11','2018-10-18 10:00:11',NULL),('7cee1416-182b-4343-9070-d47eac31b64a','pawan.nerker@impetus.co.in',NULL,'$2a$10$lFbrmoQ56kK8.txu1pR.zOJQnj20F6WrKy8B6he9ViYk/NPdtkU3m',1,'2018-10-22 11:36:52','2018-10-22 11:36:52',NULL),('85a0bc75-1504-49ff-a2d9-bee9e12e8c36',NULL,NULL,NULL,1,'2018-10-25 10:53:09','2018-10-25 10:53:09','customer'),('9239ea02-33fe-4ee6-904f-2c81904bb2ca','abc','xyz',NULL,1,NULL,NULL,NULL),('bc6ada38-5079-4587-b02f-d36c19082d9c','pawan',NULL,NULL,1,'2018-10-18 16:32:50','2018-10-18 16:32:50',NULL),('c51046ea-6d10-4590-9d03-4a8b4c26fe9b',NULL,NULL,NULL,1,'2018-10-22 16:53:24','2018-10-22 16:53:24','customer'),('c981eea8-048c-43fa-972a-cc55e3adc8f1',NULL,NULL,NULL,1,'2018-10-25 10:54:20','2018-10-25 10:54:20','customer'),('d7393d72-cb6d-4ebf-b2b6-63ce63599031','anand@gmail.com','anand tiwari','123456',1,'2018-10-25 13:13:11','2018-10-25 13:13:11','customer'),('e0f45683-78fd-4372-b7ac-1f2b261d0881',NULL,NULL,'123',1,'2018-10-25 09:31:19','2018-10-25 09:31:19','customer');
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

-- Dump completed on 2018-10-26 12:23:57
