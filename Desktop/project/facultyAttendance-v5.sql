-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: facultyattendance
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

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
-- Table structure for table `faculty_attendance`
--

DROP TABLE IF EXISTS `faculty_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_attendance` (
  `log_id` int(11) NOT NULL,
  `log_in` varchar(45) NOT NULL,
  `log_out` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `code` varchar(9) NOT NULL,
  PRIMARY KEY (`log_id`),
  UNIQUE KEY `log_id_UNIQUE` (`log_id`),
  KEY `code_idx` (`code`),
  CONSTRAINT `code` FOREIGN KEY (`code`) REFERENCES `faculty_sched` (`code`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_attendance`
--

LOCK TABLES `faculty_attendance` WRITE;
/*!40000 ALTER TABLE `faculty_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_dept`
--

DROP TABLE IF EXISTS `faculty_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_dept` (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(45) NOT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `dept_id_UNIQUE` (`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_dept`
--

LOCK TABLES `faculty_dept` WRITE;
/*!40000 ALTER TABLE `faculty_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_info`
--

DROP TABLE IF EXISTS `faculty_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_info` (
  `faculty_id` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `dept_id` int(11) NOT NULL,
  PRIMARY KEY (`faculty_id`),
  UNIQUE KEY `faculty_id_UNIQUE` (`faculty_id`),
  KEY `dept_id_idx` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_info`
--

LOCK TABLES `faculty_info` WRITE;
/*!40000 ALTER TABLE `faculty_info` DISABLE KEYS */;
INSERT INTO `faculty_info` VALUES (120871,'Albert','Ramos','Suello Village Marcos Highway','09889012783',9812),(123411,'Jude','Ramos','Teachers Village Marcos highway','09993782109',9878);
/*!40000 ALTER TABLE `faculty_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_sched`
--

DROP TABLE IF EXISTS `faculty_sched`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_sched` (
  `code` varchar(9) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `time` varchar(11) NOT NULL,
  `day` varchar(7) NOT NULL,
  `room` varchar(45) NOT NULL,
  `faculty_id` varchar(6) NOT NULL,
  PRIMARY KEY (`code`),
  KEY `faculty_id_idx` (`faculty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_sched`
--

LOCK TABLES `faculty_sched` WRITE;
/*!40000 ALTER TABLE `faculty_sched` DISABLE KEYS */;
INSERT INTO `faculty_sched` VALUES ('9348A','DATABASE MANAGEMENT SYSTEMS','4:00-5:00','WS','D515','123411'),('9348B','DATABASE MANAGEMENT SYSTEMS','1:00-2:30','TF','D522','120871'),('9357','HUMAN COMPUTER INTERACTION','8:00-9:30','WF','D514','126339');
/*!40000 ALTER TABLE `faculty_sched` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-11 23:00:34
