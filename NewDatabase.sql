-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: 401_Platform
-- ------------------------------------------------------
-- Server version	5.6.27

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
-- Table structure for table `Organizations`
--

DROP TABLE IF EXISTS `Organizations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Organizations` (
  `org_id` int(11) NOT NULL,
  `organization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Organizations`
--

LOCK TABLES `Organizations` WRITE;
/*!40000 ALTER TABLE `Organizations` DISABLE KEYS */;
/*!40000 ALTER TABLE `Organizations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectRankings`
--

DROP TABLE IF EXISTS `ProjectRankings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectRankings` (
  `student_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectRankings`
--

LOCK TABLES `ProjectRankings` WRITE;
/*!40000 ALTER TABLE `ProjectRankings` DISABLE KEYS */;
INSERT INTO `ProjectRankings` VALUES (1,2,3),(1,21,4),(1,3,1),(1,17,2),(1,16,5),(2,2,2),(2,3,1),(2,17,5),(2,11,3),(2,4,4),(3,8,1),(3,1,5),(3,28,2),(3,26,4),(3,15,3),(4,8,2),(4,1,5),(4,21,4),(4,26,1),(4,25,3),(5,8,1),(5,1,4),(5,26,2),(5,25,5),(5,6,3),(6,13,3),(6,7,4),(6,17,2),(6,5,1),(6,4,5),(7,13,3),(7,18,5),(7,23,2),(7,24,1),(7,11,4),(8,28,2),(8,20,5),(8,23,3),(8,26,1),(8,11,4),(9,8,2),(9,27,4),(9,17,5),(9,22,3),(9,9,1),(10,1,1),(10,2,3),(10,3,4),(10,22,5),(10,4,2),(11,23,2),(11,24,1),(11,6,4),(11,14,5),(11,4,3),(12,8,1),(12,23,3),(12,24,5),(12,26,2),(12,19,4),(13,13,4),(13,18,1),(13,23,3),(13,22,5),(13,29,2),(14,27,4),(14,28,3),(14,3,1),(14,17,2),(14,25,5),(15,27,2),(15,1,4),(15,28,3),(15,12,1),(15,4,5),(16,13,2),(16,27,1),(16,26,5),(16,19,3),(16,4,4),(17,13,4),(17,18,2),(17,22,5),(17,29,1),(17,19,3),(18,13,3),(18,18,1),(18,23,5),(18,11,2),(18,5,4),(19,13,1),(19,8,4),(19,2,5),(19,22,3),(19,5,2),(20,8,1),(20,26,2),(20,6,4),(20,9,5),(20,4,3),(21,8,4),(21,18,1),(21,17,5),(21,24,2),(21,6,3),(22,18,3),(22,24,2),(22,29,1),(22,11,4),(22,15,5),(23,1,5),(23,25,2),(23,26,4),(23,14,1),(23,6,3),(24,13,1),(24,20,5),(24,24,3),(24,5,2),(24,11,4),(25,28,5),(25,26,3),(25,14,1),(25,6,2),(25,12,4),(26,13,3),(26,20,1),(26,17,2),(26,29,5),(26,11,4),(27,28,2),(27,10,1),(27,22,5),(27,24,3),(27,6,4),(28,28,2),(28,10,1),(28,22,5),(28,24,3),(28,6,4),(29,28,2),(29,10,1),(29,22,5),(29,24,3),(29,11,4),(30,13,1),(30,20,3),(30,23,5),(30,29,4),(30,11,2),(31,13,4),(31,18,3),(31,20,5),(31,19,2),(31,11,1),(32,13,3),(32,10,2),(32,24,5),(32,12,1),(32,14,4),(33,18,2),(33,7,4),(33,10,3),(33,22,5),(33,29,1),(34,1,1),(34,27,3),(34,17,5),(34,25,2),(34,26,4),(35,21,1),(35,2,4),(35,3,2),(35,17,3),(35,15,5),(36,8,1),(36,27,3),(36,28,2),(36,24,5),(36,9,4),(37,13,3),(37,3,4),(37,16,5),(37,25,1),(37,5,2),(38,13,1),(38,7,2),(38,28,4),(38,19,3),(38,15,5),(39,13,1),(39,20,5),(39,24,3),(39,11,2),(39,5,4),(40,13,2),(40,21,1),(40,3,3),(40,17,4),(40,14,5),(41,8,3),(41,7,2),(41,10,1),(41,9,4),(41,15,5),(42,1,5),(42,28,4),(42,2,2),(42,3,1),(42,17,3),(43,27,1),(43,28,2),(43,21,4),(43,3,3),(43,15,5),(44,13,5),(44,18,1),(44,23,4),(44,29,2),(44,11,3),(45,10,3),(45,17,2),(45,23,5),(45,26,1),(45,29,4),(46,10,3),(46,17,2),(46,26,1),(46,15,4),(46,5,5),(47,27,2),(47,3,1),(47,17,3),(47,5,5),(47,4,4),(48,13,4),(48,20,2),(48,23,3),(48,24,5),(48,11,1),(49,13,4),(49,20,2),(49,23,3),(49,24,5),(49,11,1),(50,13,4),(50,20,2),(50,23,3),(50,24,5),(50,11,1),(51,10,4),(51,17,2),(51,22,3),(51,29,1),(51,5,5),(52,27,1),(52,1,4),(52,20,5),(52,23,3),(52,19,2),(53,27,2),(53,28,3),(53,10,5),(53,17,1),(53,3,4),(54,13,2),(54,28,5),(54,24,1),(54,9,4),(54,5,3),(55,8,1),(55,28,4),(55,26,5),(55,14,2),(55,9,3),(56,13,1),(56,20,2),(56,24,4),(56,12,5),(56,19,3),(57,1,5),(57,20,2),(57,3,4),(57,22,1),(57,24,3),(58,7,3),(58,24,1),(58,29,2),(58,9,4),(58,5,5),(59,8,1),(59,28,4),(59,26,5),(59,14,2),(59,9,3),(60,1,3),(60,28,2),(60,22,5),(60,29,1),(60,6,4),(61,13,4),(61,28,1),(61,20,5),(61,24,2),(61,11,3),(62,1,5),(62,10,2),(62,29,1),(62,26,3),(62,14,4),(63,27,1),(63,28,2),(63,10,3),(63,17,4),(63,26,5),(64,25,2),(64,26,4),(64,14,1),(64,6,3),(64,4,5),(65,2,3),(65,21,5),(65,17,2),(65,3,4),(65,22,1),(66,8,1),(66,28,4),(66,26,5),(66,14,2),(66,9,3),(67,13,5),(67,1,1),(67,2,3),(67,25,4),(67,4,2),(68,8,4),(68,18,2),(68,10,5),(68,29,1),(68,6,3),(69,13,3),(69,27,1),(69,21,2),(69,20,5),(69,19,4);
/*!40000 ALTER TABLE `ProjectRankings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectStatusTypes`
--

DROP TABLE IF EXISTS `ProjectStatusTypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectStatusTypes` (
  `status_id` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectStatusTypes`
--

LOCK TABLES `ProjectStatusTypes` WRITE;
/*!40000 ALTER TABLE `ProjectStatusTypes` DISABLE KEYS */;
INSERT INTO `ProjectStatusTypes` VALUES (1,'Pending'),(2,'Approved'),(3,'Rejected'),(4,'Changes Requested');
/*!40000 ALTER TABLE `ProjectStatusTypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Projects`
--

DROP TABLE IF EXISTS `Projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Projects` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(45) DEFAULT NULL,
  `stakeholder_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `max_size` int(11) DEFAULT NULL,
  `min_size` int(11) DEFAULT NULL,
  `description` longtext,
  `background` longtext,
  `technologies` longtext,
  `admin_comments` longtext,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Projects`
--

LOCK TABLES `Projects` WRITE;
/*!40000 ALTER TABLE `Projects` DISABLE KEYS */;
INSERT INTO `Projects` VALUES (1,'Quizzly',NULL,1,NULL,8,6,NULL,NULL,NULL,NULL),(2,'SummerCampReg',NULL,1,NULL,8,4,NULL,NULL,NULL,NULL),(3,'Sigma',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(4,'P2P4Health',NULL,1,NULL,12,9,NULL,NULL,NULL,NULL),(5,'SociallyConsciousMachineLearningBots',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(6,'ChangingTheTutoringSphere',NULL,1,NULL,5,3,NULL,NULL,NULL,NULL),(7,'TrojanMotors',NULL,1,NULL,6,4,NULL,NULL,NULL,NULL),(8,'AutismSocietyApp',NULL,1,NULL,3,2,NULL,NULL,NULL,NULL),(9,'AutismSocietyDB',NULL,1,NULL,3,2,NULL,NULL,NULL,NULL),(10,'SchoolOfFishApp',NULL,1,NULL,3,2,NULL,NULL,NULL,NULL),(11,'PredictingElections',NULL,1,NULL,5,4,NULL,NULL,NULL,NULL),(12,'Perfit',NULL,1,NULL,6,4,NULL,NULL,NULL,NULL),(13,'MarketingTechnologyPlatform',NULL,1,NULL,6,4,NULL,NULL,NULL,NULL),(14,'PureFocusiOSApp',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(15,'Cosmic-System',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(16,'eFormsProject',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(17,'Prop47Website',NULL,1,NULL,3,2,NULL,NULL,NULL,NULL),(18,'ProstheticSpinalCord',NULL,1,NULL,6,3,NULL,NULL,NULL,NULL),(19,'QuantitativeTrading_DataScience',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(20,'QuantitativeTrading_DataExtractionPipeline',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(21,'PositionControl',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(22,'SpoilerAlert',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(23,'LogoDetection',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(24,'AIMedicalImaging',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(25,'Diabetes',NULL,1,NULL,5,3,NULL,NULL,NULL,NULL),(26,'iLegal',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(27,'401ProjectPlatform',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(28,'LetterOfRecGenerator',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL),(29,'AutonomousDroneControl',NULL,1,NULL,4,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StakeholderInfo`
--

DROP TABLE IF EXISTS `StakeholderInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StakeholderInfo` (
  `stakeholder_id` int(11) NOT NULL,
  `organization_id` int(11) DEFAULT NULL,
  `avg_rating` float DEFAULT NULL,
  PRIMARY KEY (`stakeholder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StakeholderInfo`
--

LOCK TABLES `StakeholderInfo` WRITE;
/*!40000 ALTER TABLE `StakeholderInfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `StakeholderInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StakeholderReviews`
--

DROP TABLE IF EXISTS `StakeholderReviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StakeholderReviews` (
  `stakeholder_id` int(11) NOT NULL,
  `review` longtext,
  `rating` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StakeholderReviews`
--

LOCK TABLES `StakeholderReviews` WRITE;
/*!40000 ALTER TABLE `StakeholderReviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `StakeholderReviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudentInfo`
--

DROP TABLE IF EXISTS `StudentInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StudentInfo` (
  `student_id` int(11) NOT NULL,
  `semester` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `uscid` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudentInfo`
--

LOCK TABLES `StudentInfo` WRITE;
/*!40000 ALTER TABLE `StudentInfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `StudentInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserTypes`
--

DROP TABLE IF EXISTS `UserTypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserTypes` (
  `type_id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserTypes`
--

LOCK TABLES `UserTypes` WRITE;
/*!40000 ALTER TABLE `UserTypes` DISABLE KEYS */;
INSERT INTO `UserTypes` VALUES (1,'Admin'),(2,'Stakeholder'),(3,'Student');
/*!40000 ALTER TABLE `UserTypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone_num` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,3,'Randy','Henderson',NULL,NULL,NULL,NULL),(2,3,'Jack','Nicholson',NULL,NULL,NULL,NULL),(3,3,'Adam','Sandler',NULL,NULL,NULL,NULL),(4,3,'Tony','Montana',NULL,NULL,NULL,NULL),(5,3,'Jeffrey','Goldbloom',NULL,NULL,NULL,NULL),(6,3,'Daniel','Chang',NULL,NULL,NULL,NULL),(7,3,'Gideon','Gorilla',NULL,NULL,NULL,NULL),(8,3,'Gerald','Broflovsky',NULL,NULL,NULL,NULL),(9,3,'Stan','Marsh',NULL,NULL,NULL,NULL),(10,3,'Peter','Griffin',NULL,NULL,NULL,NULL),(11,3,'John','Jefferson',NULL,NULL,NULL,NULL),(12,3,'Jerry','Garcia',NULL,NULL,NULL,NULL),(13,3,'Jimmy','Page',NULL,NULL,NULL,NULL),(14,3,'Paul','Gilbert',NULL,NULL,NULL,NULL),(15,3,'Matt','Damon',NULL,NULL,NULL,NULL),(16,3,'Eric','Clapton',NULL,NULL,NULL,NULL),(17,3,'John','Lennon',NULL,NULL,NULL,NULL),(18,3,'Paul','McCartney',NULL,NULL,NULL,NULL),(19,3,'Ringo','Starr',NULL,NULL,NULL,NULL),(20,3,'Nicholas','Cage',NULL,NULL,NULL,NULL),(21,3,'Jim','Carrey',NULL,NULL,NULL,NULL),(22,3,'Steven','McStevenson',NULL,NULL,NULL,NULL),(23,3,'Gary','Goldbloom',NULL,NULL,NULL,NULL),(24,3,'Bruce','Wayne',NULL,NULL,NULL,NULL),(25,3,'Alan','Rickman',NULL,NULL,NULL,NULL),(26,3,'Rick','Sanchez',NULL,NULL,NULL,NULL),(27,3,'Elizabeth','Banks',NULL,NULL,NULL,NULL),(28,3,'Scott','Toddleman',NULL,NULL,NULL,NULL),(29,3,'Steve','Austin',NULL,NULL,NULL,NULL),(30,3,'Billy','Idol',NULL,NULL,NULL,NULL),(31,3,'Jimi','Hendrix',NULL,NULL,NULL,NULL),(32,3,'Michael','Jack',NULL,NULL,NULL,NULL),(33,3,'Jack','Black',NULL,NULL,NULL,NULL),(34,3,'Jake','Sparrow',NULL,NULL,NULL,NULL),(35,3,'Danny','Bolton',NULL,NULL,NULL,NULL),(36,3,'Eddard','Stark',NULL,NULL,NULL,NULL),(37,3,'Chad','Butler',NULL,NULL,NULL,NULL),(38,3,'Davis','Jim',NULL,NULL,NULL,NULL),(39,3,'Charlie','Sheen',NULL,NULL,NULL,NULL),(40,3,'Jim','Morisson',NULL,NULL,NULL,NULL),(41,3,'Seth','McFarlane',NULL,NULL,NULL,NULL),(42,3,'David','Bowie',NULL,NULL,NULL,NULL),(43,3,'Kurt','Cobain',NULL,NULL,NULL,NULL),(44,3,'Freddie','Mercury',NULL,NULL,NULL,NULL),(45,3,'Mick','Jagger',NULL,NULL,NULL,NULL),(46,3,'Ozzy','Osbourne',NULL,NULL,NULL,NULL),(47,3,'Robert','Plant',NULL,NULL,NULL,NULL),(48,3,'George','Harrison',NULL,NULL,NULL,NULL),(49,3,'Dave','Mustaine',NULL,NULL,NULL,NULL),(50,3,'Eddie','Veder',NULL,NULL,NULL,NULL),(51,3,'Gene','Simmons',NULL,NULL,NULL,NULL),(52,3,'Chester','Bennington',NULL,NULL,NULL,NULL),(53,3,'Mike','Shinoda',NULL,NULL,NULL,NULL),(54,3,'James','Bond',NULL,NULL,NULL,NULL),(55,3,'Axl','Rose',NULL,NULL,NULL,NULL),(56,3,'Van','Halen',NULL,NULL,NULL,NULL),(57,3,'Synyster','Gates',NULL,NULL,NULL,NULL),(58,3,'Chuck','Berry',NULL,NULL,NULL,NULL),(59,3,'Roger','Waters',NULL,NULL,NULL,NULL),(60,3,'Syd','Barrett',NULL,NULL,NULL,NULL),(61,3,'Jon','Snow',NULL,NULL,NULL,NULL),(62,3,'Darth','Vader',NULL,NULL,NULL,NULL),(63,3,'Tyrion','Lannister',NULL,NULL,NULL,NULL),(64,3,'Jake','Fender',NULL,NULL,NULL,NULL),(65,3,'Bryan','Davis',NULL,NULL,NULL,NULL),(66,3,'George','Michael',NULL,NULL,NULL,NULL),(67,3,'Henry','Cage',NULL,NULL,NULL,NULL),(68,3,'Bill','Smith',NULL,NULL,NULL,NULL),(69,3,'Frank','Sinatra',NULL,NULL,NULL,NULL),(70,1,'admin','holderson','admin@usc.edu','admin','admin',NULL);
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-23 17:06:13
