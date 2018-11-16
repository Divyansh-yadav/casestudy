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
  `price` double DEFAULT NULL,
  `cart_id` varchar(36) NOT NULL,
  PRIMARY KEY (`cart_id`),
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
INSERT INTO `cart` VALUES ('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','306dd713-e3f0-43b9-bddc-e82905d7a120',1,350,'2018-11-16 10:33:04','2018-11-16 10:33:04',300,'4bb0c7f0-b016-4f80-9579-2e83e37d37b5'),('518789ec-da85-4515-b5e4-df4fed853855','2df7e53c-9662-43b1-8213-3cf1f144d91f',1,21,'2018-11-16 12:28:42','2018-11-16 12:28:42',15,'5575e011-6879-44c5-9149-d8630bbfa1a8'),('518789ec-da85-4515-b5e4-df4fed853855','5c8890b6-9251-4e0f-83b8-2587af22777d',1,500,'2018-11-16 12:28:32','2018-11-16 12:28:32',30,'6ba42ba0-f21d-4810-bfe6-e62b3e4e4f5b'),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1a279937-253c-4fe5-9c42-48960fcb9e6a',1,150,'2018-11-16 11:29:11','2018-11-16 11:29:11',15,'91c70ee6-e84c-49f7-a75e-02f313a010a7');
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
  `zipcode` varchar(36) DEFAULT NULL,
  `customer_id` varchar(36) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL,
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
INSERT INTO `customer_detail` VALUES ('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','grg','Indore Bypass Road','1234567989','123456','0302eead-b631-4c66-8115-e442dafbe479',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1m','ghjghj','Indore Bypass Road','5232232555','123232','05465880-b826-4073-90d8-46a4a04d0664',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','reger','Indore Bypass Road','1334678904','123456','0a692c48-514a-40dd-9b98-45975017b2fd',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','df`','Indore Bypass Road','1234567890','123456','0bfbdb25-6e4d-40c1-b14d-6ca3f92aac57',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','foi','Indore Bypass Road','1234565789','123456','12d51eae-2a8b-4d75-a6e0-c2cfe3671ed6',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','Root','Indore Bypass Road','1234656789','123456','15417437-4f61-4f05-822c-60324cdf53ae',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','sfsfsdf','Indore Bypass Road','1234567890','123456','174a5705-2ffd-47c7-a49f-147e67487f30',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','gdfh','Indore Bypass Road','1234678912','123456','18ab5904-d0b4-4d73-95e8-5fe48b9ab778',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','fg','Indore Bypass Road','1234567890','123456','24812186-0160-49d8-a039-be6fafd01abc',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','dgk','Indore Bypass Road','1234567890','123456','25bb8191-6c28-42f1-a82a-f99aca2059d3',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','CL751','Near DMart','Indore Bypass Road','8745247347','453441','27b40c6b-9e72-440c-b344-e01bdf6a0515',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','hgh','Indore Bypass Road','1234656780','123456','298f055e-72ce-4ea0-add2-7bbf101e731d',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','fj','Indore Bypass Road','1234656780','123456','2f47f6f8-de27-4282-a05d-c630be5221fc',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','85','kanadia road','Kanadia Road','9425720223','452016','343941fb-dd76-409e-9395-0c437ba6eff0',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','Temple','Indore Bypass Road','1234567890','123456','348a708b-bdc4-4e88-a620-5085ea03d2ed',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1d','gtrj','Indore Bypass Road','1234567890','123456','368feb47-4e87-442d-9bd0-847ead712045',NULL,NULL),('5ba184c8-f14f-41a5-bf6f-12d18bd9f473','9a','near dmart','Indore Bypass Road','7828229625','123456','38b2974c-9281-43a4-b91c-03f674e73b9c',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1f','gfj','Khandwa - Indore Road','1234567890','123465','39110df4-f5fb-496f-937e-4e441791996c',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','gh','Indore Bypass Road','1323456789','123456','391969a9-3104-4d9d-99f4-6dfc6f3c0f56',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','126','D Mart','Indore Bypass Road','9875619874','213498','3925bd5a-1909-4930-acaf-c9e24bf2abe4',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','fji','Indore Bypass Road','1223456789','123456','3c5aa316-61cf-4999-9b0c-557b571f22ab',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1f','dfuh','Khandwa - Indore Road','1234567890','123456','3d4f076a-1879-4b18-9e70-a7061850a622',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','sdf','Indore Bypass Road','1234567890','123456','3f4f2cb3-4c96-4b6e-b5b1-ac45659748c2',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','hgdu','Indore Bypass Road','1234567890','123456','41b164dd-a943-4305-bed1-ac1efdcd614f',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','fufh','Indore Bypass Road','1234567989','123456','46ea8b50-f5ac-4ce8-a7d8-a1f8e78edb07',NULL,NULL),('09296e3d-66e8-4685-bdd4-bc6ce80f546e','123','Temple','Indore Bypass Road','1234567890','123456','4e27346d-a999-4aaf-9d8e-7cdcb3c68c7a',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1a','sdg','Indore Bypass Road','1234567804','123456','5136a1a4-2670-46fc-b3ac-c83307cee0d5',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','fdhg','Indore Bypass Road','8889727221','123456','57ce620c-1979-4644-a8bd-84724106d731',NULL,NULL),('09296e3d-66e8-4685-bdd4-bc6ce80f546e','123','Temple','Indore Bypass Road','1234567890','123456','5cbf55da-83be-4282-a7b7-044505232c32',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','mdfg','Indore Bypass Road','1232456705','123456','5e6dab09-6b3a-4f95-90c2-836986f13a9b',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','fhuih','Indore Bypass Road','1234567890','123456','65114ab0-66a3-4bf8-b6a8-6ccd7cfb87a0',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','gj','Indore Bypass Road','1234567890','123456','6b4770c4-3d8b-4313-ab11-08efc0cbf0d7',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','reger','Indore Bypass Road','1334678904','123456','6bb89c5a-36d2-459b-bd0e-e21af3e14473',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','847','44rst','Indore Bypass Road','9846519847','654684','6c9b9ceb-0986-4215-b8ae-f8abd0ae04a4',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','2315','Station Road','Rau - Pithampur Road','9617462021','453441','6ff2cd66-6e86-4e73-9f90-881d49d3d09f',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','hm','Indore Bypass Road','1234567890','123456','7577adac-9e25-4c7b-bc3a-42a3bab21944',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','temple','Indore Bypass Road','1234567890','123456','792d0a6b-6c3d-45c1-8ee5-42b977e1701d',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','FDK','Indore Bypass Road','1234567890','123456','811e86a9-82cb-4c03-b2be-6035b3fc661b',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','fsid','Indore Bypass Road','1234567891','123456','8256323e-f6e5-403a-a7d2-9a1c5174011f',NULL,NULL),('c84d7147-ecbc-4b8a-8f10-4c450c744a03','2315','satsyugw','Rau - Pithampur Road','9635252156','453441','849bbeb0-97b8-4383-9af3-16914e834095',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','hjj','Indore Bypass Road','1234567890','123456','8a403d0a-4b48-4499-92a6-cc643dab0dcc',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','jgf','Indore Bypass Road','1234567890','123456','8acff887-6b7e-486e-b2e7-ffd3178b3244',NULL,NULL),('707502ac-7a76-4946-817f-d63f0c9cbb17','12','svsf','Khandwa - Indore Road','1234567890','123456','8e583994-54e7-4f8a-98e0-218320dde888',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','sakshi.shukla@impetus.co.in','Indore Bypass Road','1234567890','123456','98d665b0-2e6f-42da-b8ad-277c91ad9c17',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','gjofij','Indore Bypass Road','1234560789','123456','9d885302-cc63-4ea1-8709-012d11383b1f',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','ghh','Indore Bypass Road','1234567891','123456','a181aa5e-d793-43f3-a15b-3464d522f685',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','16165','65165561','Rau - Pithampur Road','6546565465','465526','aa2a53fe-554b-468f-80e9-a297dcab76b3',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','112','sgfs','Indore Bypass Road','1234567890','123456','b473ea26-a058-4324-94fc-d5ab2f77698a',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','sakshi.shukla@impetus.co.in','Indore Bypass Road','1234567890','123456','b99c89dc-d72e-47fb-9cae-0e231c59424a',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','45','fdg fdgfdg','Palasiya Road','1234567789','452016','ba3262da-42e2-4e7d-b178-9a203c732018',NULL,NULL),('707502ac-7a76-4946-817f-d63f0c9cbb17','12','jdfsj','Indore Bypass Road','1234546789','123456','c951d381-8895-43e6-aeb1-7bbf63a04759',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','sakshi.shukla@impetus.co.in','Indore Bypass Road','1234567890','123456','d0465d89-8f99-4bd3-b8fc-6e4148a8ec90',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','temple','Indore Bypass Road','1234567890','123465','d496b52c-47d0-451e-bf7b-f230fc56dada',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1254','Dmart','Indore Bypass Road','7954236548','575412','e37dd66d-9daa-4c34-bdff-644ff52037f8',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','54','jsfdh','Indore Bypass Road','1234567899','546478','e45e1183-6ebb-45f3-befa-d13e9048292a',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','tree','Indore Bypass Road','1234567890','123456','e9e8808b-c5fc-409c-b11d-274e353f4869',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1d','fjij','Indore Bypass Road','1234567890','123456','eb7eac50-e404-4369-9164-d1f6f259d888',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','gjij','Indore Bypass Road','1234567890','123456','f0a6e198-b7e6-49be-a21f-4f566dc1fec5',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','Temple','Indore Bypass Road','1234567890','123456','f23b53bb-1a3d-4101-b337-571a5957b2b8',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','jgdg','Indore Bypass Road','1234567890','132456','f542ce93-529c-4a9b-83c4-576b580e3117',NULL,NULL),('09296e3d-66e8-4685-bdd4-bc6ce80f546e','123','Temple','Indore Bypass Road','1234567890','123456','f75896b3-3e1d-4863-a6f4-53befb852ae4',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','123','root','Indore Bypass Road','1234567890','123456','f9c146be-5f07-4577-bb4f-8f4c78f96ce7',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','dhg','Indore Bypass Road','1234567890','123456','fcf09613-5e5f-43fd-b07b-7db2c089feab',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','1f','sbs','Indore Bypass Road','1234656789','123456','fe136a54-445f-4720-8cec-f28cc7338a64',NULL,NULL),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','12','jhd','Indore Bypass Road','1234567890','123456','fee7f90e-0022-4488-9eb4-4c162f7a9f8d',NULL,NULL);
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
  `feedback_id` varchar(255) NOT NULL,
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
INSERT INTO `customer_feedback` VALUES ('16142854-60a0-4826-baf0-cf0dbef147f9','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','Good',NULL,'2018-11-15 16:15:03','2018-11-15 16:15:03','0d0c091c-9914-42c9-9706-225c54234e7d'),('f356bafa-d324-40d8-8f00-96649260b6f5','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','Bad',NULL,'2018-11-15 16:20:28','2018-11-15 16:20:28','ccea204a-d736-48f4-8652-dd237994c932'),('eba7aca9-07c1-4f2f-b6d3-5ee39e78bb84','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','Good',NULL,'2018-11-15 16:46:03','2018-11-15 16:46:03','d025b259-90bd-475d-a5c1-53604a85ef6e'),('cf4d93cd-f25d-4f6b-b4b5-2ee14afeae71','5ba184c8-f14f-41a5-bf6f-12d18bd9f473',NULL,NULL,'2018-11-15 17:59:08','2018-11-15 17:59:08','d025b259-90bd-475d-a5c1-53604a85ef6e'),('a3e6cd46-e7f6-4b29-906f-981c7d658058','c84d7147-ecbc-4b8a-8f10-4c450c744a03',NULL,NULL,NULL,'2018-11-16 11:27:51','73db9ccc-8369-4db6-a871-d7621f0e1c15');
/*!40000 ALTER TABLE `customer_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  KEY `FKr45epddmrka0nkg3fkqcj28r4` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
INSERT INTO `order_details` VALUES ('07b5811b-aac3-49cb-8dc2-ed86a322d46b','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":3,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"},{\"quantity\":2,\"productId\":\"1003\",\"price\":20,\"weight\":100,\"productName\":\"yogurt\"}]','2018-11-14 13:58:39','2018-11-14 13:58:39',0),('1397b1f5-d921-4f84-b230-e9ad7fa6cf00','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":2,\"productId\":\"1006\",\"price\":170,\"weight\":430,\"productName\":\"pizzas\"},{\"quantity\":2,\"productId\":\"1001\",\"price\":60,\"weight\":1003,\"productName\":\"Milk-pouch\"},{\"quantity\":2,\"productId\":\"1005\",\"price\":200,\"weight\":500,\"productName\":\"icecream\"},{\"quantity\":2,\"productId\":\"1007\",\"price\":75,\"weight\":250,\"productName\":\"microwaveable-entrees \"},{\"quantity\":2,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-14 19:23:29','2018-11-14 19:23:29',0),('16142854-60a0-4826-baf0-cf0dbef147f9','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"1001\",\"price\":60,\"weight\":1003,\"productName\":\"Milk-pouch\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-15 16:14:25','2018-11-15 16:14:25',0),('1dfc6d0c-cd23-4042-8aff-97df87f1e5c5','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"},{\"quantity\":1,\"productId\":\"1001\",\"price\":60,\"weight\":1003,\"productName\":\"Milk-pouch\"}]','2018-11-15 16:52:24','2018-11-15 16:52:24',0),('75b20a67-a498-47cb-837b-525dad91105a','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"2cf108da-599e-46d6-80c6-9b04ff4a74e3\",\"price\":25,\"weight\":500,\"productName\":\"Milk\"},{\"quantity\":1,\"productId\":\"5c8890b6-9251-4e0f-83b8-2587af22777d\",\"price\":30,\"weight\":500,\"productName\":\"Bread\"}]','2018-11-15 21:23:31','2018-11-15 21:23:31',0),('7976454a-d44e-425b-a502-69a19f988dfa','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":3,\"productId\":\"1003\",\"price\":20,\"weight\":100,\"productName\":\"yogurt\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-15 14:04:14','2018-11-15 14:04:14',0),('a3e6cd46-e7f6-4b29-906f-981c7d658058','c84d7147-ecbc-4b8a-8f10-4c450c744a03',0,0,'[{\"quantity\":1,\"productId\":\"1908e46b-b035-4acc-908f-79b78aafd89a\",\"price\":250,\"weight\":300,\"productName\":\"Chicken\"}]','2018-11-16 11:21:51','2018-11-16 11:21:51',0),('b5cf2cd9-6d32-4708-94f0-f527dab82dde','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"1003\",\"price\":20,\"weight\":100,\"productName\":\"yogurt\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-15 14:18:04','2018-11-15 14:18:04',0),('cb2dec6c-d999-497d-b02a-104c01a6ffbc','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"7668a523-c0ae-4a9f-aef4-e2bf844799fe\",\"price\":40,\"weight\":200,\"productName\":\"Cold Drink\"},{\"quantity\":1,\"productId\":\"1a279937-253c-4fe5-9c42-48960fcb9e6a\",\"price\":15,\"weight\":150,\"productName\":\"Chips\"}]','2018-11-16 09:55:18','2018-11-16 09:55:18',0),('cf4d93cd-f25d-4f6b-b4b5-2ee14afeae71','5ba184c8-f14f-41a5-bf6f-12d18bd9f473',0,0,'[{\"quantity\":1,\"productId\":\"1001\",\"price\":60,\"weight\":1003,\"productName\":\"Milk-pouch\"},{\"quantity\":1,\"productId\":\"1003\",\"price\":20,\"weight\":100,\"productName\":\"yogurt\"},{\"quantity\":1,\"productId\":\"1003\",\"price\":20,\"weight\":100,\"productName\":\"yogurt\"},{\"quantity\":1,\"productId\":\"1004\",\"price\":450,\"weight\":1000,\"productName\":\"sour-cream\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-15 17:55:18','2018-11-15 17:55:18',0),('e11077a3-cea7-48bf-80ae-805bb3295403','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"1003\",\"price\":20,\"weight\":100,\"productName\":\"yogurt\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-14 19:29:51','2018-11-14 19:29:51',0),('eba7aca9-07c1-4f2f-b6d3-5ee39e78bb84','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"1001\",\"price\":60,\"weight\":1003,\"productName\":\"Milk-pouch\"}]','2018-11-15 16:44:11','2018-11-15 16:44:11',0),('f356bafa-d324-40d8-8f00-96649260b6f5','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"1001\",\"price\":60,\"weight\":1003,\"productName\":\"Milk-pouch\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-15 16:18:49','2018-11-15 16:18:49',0),('f70a2113-7b0a-419e-9355-88c717e223d3','1fde4cb0-0f34-4150-88dd-4f9117d3f4a1',0,0,'[{\"quantity\":1,\"productId\":\"1001\",\"price\":60,\"weight\":1003,\"productName\":\"Milk-pouch\"},{\"quantity\":1,\"productId\":\"1002\",\"price\":10,\"weight\":10,\"productName\":\"cream packates\"}]','2018-11-15 14:35:25','2018-11-15 14:35:25',0);
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
  `image_url` text,
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
INSERT INTO `product_category` VALUES ('125d43bd-939e-430f-91c7-688cb86369f4','Beauty','Beauty.jpg','2018-11-15 20:18:30','2018-11-15 20:18:30'),('23ebd42e-e547-4df1-ac30-1621539c3a8c','Snacks','Snacks_Beverages.jpg','2018-11-15 20:14:57','2018-11-15 20:14:57'),('54ae5f2f-d06d-4568-875d-ba191805de90','Food Grains','food_grains.jpg','2018-11-15 20:19:38','2018-11-15 20:19:38'),('7bfe19be-c811-448c-9a5a-451bca65cc07','Meat','Meats_Seafood_Eggs.jpg','2018-11-15 20:00:03','2018-11-15 20:00:03'),('844d9c94-5b08-4066-b7cc-cbe9ddc6eaae','Household','Household.jpg','2018-11-15 20:17:08','2018-11-15 20:17:08'),('b1accc05-877a-43cf-a6f7-5675fc497ede','Others','No_Image_Available.png','2018-11-16 12:18:56','2018-11-16 12:18:56'),('de1bef9b-1a33-42d8-9a0e-2a4d374b89dc','Vegetables','Vegetables.jpg','2018-11-15 20:06:36','2018-11-15 20:06:36'),('df10ecb8-5b98-4726-adde-526b77104c96','Dairy & Bakery','Dairy_Bakery.jpg','2018-11-15 20:05:07','2018-11-15 20:05:07'),('e3c4b591-2560-45d9-bd5f-15322c7b312c','Fruits','Fruits.jpg','2018-11-15 19:59:13','2018-11-15 19:59:13');
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
  `image_url` text,
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
INSERT INTO `products` VALUES ('1908e46b-b035-4acc-908f-79b78aafd89a','7bfe19be-c811-448c-9a5a-451bca65cc07','Chicken',232,300,250,1,'chicken.jpg','2018-11-15 21:01:01','2018-11-15 21:01:01'),('1a279937-253c-4fe5-9c42-48960fcb9e6a','23ebd42e-e547-4df1-ac30-1621539c3a8c','Chips',2323,150,15,1,'chips.jpg','2018-11-15 21:04:57','2018-11-15 21:04:57'),('1dbde59f-5f8b-4c72-8bef-958c1a706b72','54ae5f2f-d06d-4568-875d-ba191805de90','Poha',565,250,49,1,'poha.jpg','2018-11-16 12:03:39','2018-11-16 12:03:39'),('2cf108da-599e-46d6-80c6-9b04ff4a74e3','df10ecb8-5b98-4726-adde-526b77104c96','Milk',2323,500,25,1,'Milk.jpg','2018-11-15 20:45:20','2018-11-15 20:45:20'),('2df7e53c-9662-43b1-8213-3cf1f144d91f','e3c4b591-2560-45d9-bd5f-15322c7b312c','Orange',100,21,15,1,'orange.jpg','2018-11-15 20:28:57','2018-11-15 20:28:57'),('302f4d16-016c-42b9-ad27-4db9d31e2d50','de1bef9b-1a33-42d8-9a0e-2a4d374b89dc','Potato',1549,10,10,1,'Potato.jpg','2018-11-15 20:40:09','2018-11-15 20:40:09'),('306dd713-e3f0-43b9-bddc-e82905d7a120','125d43bd-939e-430f-91c7-688cb86369f4','Lipstick',222,350,300,1,'lipstick.jpg','2018-11-15 20:36:57','2018-11-15 20:36:57'),('30799b2f-b318-4af6-ba60-55b92db7690e','df10ecb8-5b98-4726-adde-526b77104c96','Pizza Base',4343,250,99,1,'pizza_base.jpg','2018-11-16 12:15:52','2018-11-16 12:15:52'),('429c991f-7509-4f88-ab1a-2b4b08d86984','7bfe19be-c811-448c-9a5a-451bca65cc07','Egg',343,10,6,1,'eggs.jpg','2018-11-15 21:00:14','2018-11-15 21:00:14'),('46ab611d-6ede-4fb7-93e6-c4cc4be44f04','54ae5f2f-d06d-4568-875d-ba191805de90','Sugar',2323,500,29,1,'sugar.jpg','2018-11-16 11:51:54','2018-11-16 11:51:54'),('47664a3f-904e-43a4-8d2a-99f8999fab56','e3c4b591-2560-45d9-bd5f-15322c7b312c','Banana',1323,25,4,1,'bananas.jpg','2018-11-16 11:56:43','2018-11-16 11:56:43'),('4a322acc-a8c6-4c88-b818-ef939c52c098','e3c4b591-2560-45d9-bd5f-15322c7b312c','PineApple',100,500,50,1,'pineapple.jpg','2018-11-15 20:30:47','2018-11-15 20:30:47'),('4b0ed207-a9ea-4c2b-ba72-d4a3dcf5922d','54ae5f2f-d06d-4568-875d-ba191805de90','Wheat Flour',2323,1000,250,1,'Wheat_Flour.jpg','2018-11-15 20:51:25','2018-11-15 20:51:25'),('4e3f1705-36f2-49d6-ba61-636160c39c55','23ebd42e-e547-4df1-ac30-1621539c3a8c','Choclate',1323,200,100,1,'dairy_milk.jpg','2018-11-16 12:01:50','2018-11-16 12:01:50'),('5c8890b6-9251-4e0f-83b8-2587af22777d','df10ecb8-5b98-4726-adde-526b77104c96','Bread',100,500,30,1,'Bread.png','2018-11-15 20:45:55','2018-11-15 20:45:55'),('6ef7d633-5260-4597-bdf0-68c591453922','de1bef9b-1a33-42d8-9a0e-2a4d374b89dc','Sprout',2112,250,100,1,'sprout.jpg','2018-11-16 12:06:22','2018-11-16 12:06:22'),('7668a523-c0ae-4a9f-aef4-e2bf844799fe','23ebd42e-e547-4df1-ac30-1621539c3a8c','Cold Drink',1212,200,40,1,'ColdDrink.jpg','2018-11-15 21:05:36','2018-11-15 21:05:36'),('88c4c20a-c159-4567-83ea-a92ca8f99f75','de1bef9b-1a33-42d8-9a0e-2a4d374b89dc','LadyFInger',4455,4.5,5,1,'LadyFinger.jpg','2018-11-15 20:41:04','2018-11-15 20:41:04'),('8b71407f-fa50-44fb-8ce1-a32006e3b526','7bfe19be-c811-448c-9a5a-451bca65cc07','Mutton',3232,500,259,1,'mutton.jpg','2018-11-16 11:58:57','2018-11-16 11:58:57'),('8eea7387-0f7b-4e36-b8fc-76d06ea34e11','df10ecb8-5b98-4726-adde-526b77104c96','Curd',145,250,25,1,'curd.jpg','2018-11-15 20:46:25','2018-11-15 20:46:25'),('920fe349-4af5-44c6-8527-3087aead4bb8','de1bef9b-1a33-42d8-9a0e-2a4d374b89dc','Bell Pepper',4555,15.5,20,1,'Bell_Peppers.jpeg','2018-11-15 20:41:50','2018-11-15 20:41:50'),('99f99e65-be65-4645-9e29-04532e210f2e','844d9c94-5b08-4066-b7cc-cbe9ddc6eaae','Odonil',5456,575,150,1,'ODONIL-MIX-CP-AIR-FRESHENER-1432112120-10013103.jpg','2018-11-15 20:56:52','2018-11-15 20:56:52'),('bcdee51c-02e8-436b-9499-768df0560971','54ae5f2f-d06d-4568-875d-ba191805de90','Rice',1000,1000,500,1,'Rice.jpg','2018-11-15 20:50:35','2018-11-15 20:50:35'),('cf858941-393b-4a8c-aaa9-9c1d3b2ca99e','844d9c94-5b08-4066-b7cc-cbe9ddc6eaae','Cloth clip',2323,50,50,1,'Cloth_clip.jpg','2018-11-15 20:57:52','2018-11-15 20:57:52'),('d0fc95aa-92bf-42b6-954c-218cb5ac6aa5','e3c4b591-2560-45d9-bd5f-15322c7b312c','Apple',100,25,20,1,'apple.jpg','2018-11-15 20:27:37','2018-11-15 20:27:37'),('d84484a2-9a8f-4d8c-9d73-3500fda8a2aa','125d43bd-939e-430f-91c7-688cb86369f4','FaceWash',121,454,115,1,'faceWash.jpg','2018-11-15 20:37:30','2018-11-15 20:37:30'),('f3d587e2-faf6-4720-8513-cba0eb074718','125d43bd-939e-430f-91c7-688cb86369f4','Shampoo',1000,750,299,1,'shampoo.jpeg','2018-11-16 11:51:07','2018-11-16 11:51:07'),('f77531cb-50b3-40b9-a820-6b5ae0bc3133','125d43bd-939e-430f-91c7-688cb86369f4','EyeLiner',100,122,250,1,'eyeliner.jpg','2018-11-15 20:36:26','2018-11-15 20:36:26'),('f823c1bb-b730-4592-8a2d-09448d245674','844d9c94-5b08-4066-b7cc-cbe9ddc6eaae','Harpic',1212,1000,149,1,'harpic.png','2018-11-16 11:53:15','2018-11-16 11:53:15');
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
  `customer_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`provider_pk`),
  KEY `service_provider_id` (`service_provider_id`),
  KEY `order_id` (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `FK7ibcwhhyhch6m1ufr6kuujpwj` (`customer_id`),
  CONSTRAINT `FK7ibcwhhyhch6m1ufr6kuujpwj` FOREIGN KEY (`customer_id`) REFERENCES `customer_detail` (`customer_id`),
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
INSERT INTO `service_provider` VALUES (NULL,'a3e6cd46-e7f6-4b29-906f-981c7d658058','c84d7147-ecbc-4b8a-8f10-4c450c744a03','2018-11-16 11:21:51','2018-11-16 11:21:51','Delievered','cb861788-209b-4a5a-9995-837bf7e715cd','849bbeb0-97b8-4383-9af3-16914e834095');
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
  `role` varchar(20) DEFAULT NULL,
  `customer_rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('09296e3d-66e8-4685-bdd4-bc6ce80f546e','rohanyadav84@gmail.com','Divyansh Yadav','$2a$10$wLDdLFrT9nmn2Mg6sKjQR.vxhGZwCkzsJeTAr5lqJCuv/eC9eI0HO',1,'2018-11-05 15:44:36','2018-11-05 15:44:36','ROLE_CUSTOMER',0),('1fde4cb0-0f34-4150-88dd-4f9117d3f4a1','sakshi.shukla@impetus.co.in','Sakshi Shukla ','$2a$10$yfUCmt6mNbMlXsCmBVT6LO1lEUozr/jFNV98QkkX2I48jUzcUMkq.',1,'2018-11-05 17:16:22','2018-11-05 17:16:22','ROLE_CUSTOMER',0),('3241580d-a508-4510-9118-2034fbf7f310','pawan.nerkar.pn@gmail.com','Pawan Nerkar','$2a$10$.b9WI4JnBTssJwnTVIAoqearl77kDhoCJMEPU4wwKsv4sq2Smf3jy',1,'2018-11-05 15:40:21','2018-11-05 15:40:21','ROLE_ADMIN',0),('518789ec-da85-4515-b5e4-df4fed853855','tushar.chhabra@impetus.co.in','Tushar Chabra','$2a$10$rTJT7fOkYAoa5VfycJRbAu84Dn44e4dD3ugZsQe5yEVWLEud64sDK',1,'2018-11-16 12:26:33','2018-11-16 12:26:33','ROLE_CUSTOMER',0),('5ba184c8-f14f-41a5-bf6f-12d18bd9f473','vipulkjain@impetus.co.in','Vipul Kumar','$2a$10$xIFDbtvxChmOPJwbupjoPeMKb1qfezwwJT7DNsNA7vz6P0C8plzue',1,'2018-11-15 17:49:41','2018-11-15 17:49:41','ROLE_CUSTOMER',0),('707502ac-7a76-4946-817f-d63f0c9cbb17','ayush.maheshwari@impetus.co.in','ayush','$2a$10$iDNLqE039U.ZjW.qHlied.nhzYDW9iL02Z92XH6BuYKQBeleT.Vpm',1,'2018-11-13 16:59:19','2018-11-13 16:59:19','ROLE_CUSTOMER',0),('8d1f8c43-96e1-4dd0-8119-ef2870e407d4','anand.tiwari@impetus.co.in','Anand Tiwari','$2a$10$sLGf4/mx5FGOp8phr8JHuuSMlZCs2u0PKd5bh/0cU1EGLg9cdd4be',1,'2018-11-16 12:25:41','2018-11-16 12:25:41','ROLE_CUSTOMER',0),('c84d7147-ecbc-4b8a-8f10-4c450c744a03','samarthshrivastav@gmail.com','Samarth Shrivastav','$2a$10$3o0lg0tcuZsISw6qHKVFZuj.UZ1wTWT2gCNaCoDI8ldpgu5I93PVK',1,'2018-11-16 10:24:14','2018-11-16 10:24:14','ROLE_CUSTOMER',0),('f1c3ee00-0779-46cf-a315-15e7155267ec','keertimodi26@gmail.com','Keerti Modi','$2a$10$1k9jb5UmcWn8CTIgNM56y.xPZIc6HLo9PvF8k2UHUwpBAltAHnsuS',1,'2018-11-05 15:41:30','2018-11-05 15:41:30','ROLE_SERVICEPROVIDER',0);
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

-- Dump completed on 2018-11-16 12:31:58
