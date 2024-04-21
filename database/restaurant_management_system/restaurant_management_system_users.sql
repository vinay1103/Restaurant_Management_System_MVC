-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurant_management_system
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `createdDate` date DEFAULT NULL,
  `currentStatus` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,'Enabled','shubham123@gmail.com','SHUBHAM CHOUDHARY','$2a$10$HilAeIBmvXduk7OukLP/G.R8z57iA5KAfZt4XT3z1FnWSTjrPGOYa','97702318880','manager'),(3,'2022-09-24','Enabled','BHUSHAN@gmail.com','Bhushan choudhary','$2a$10$DjhbjT5Lu5swIPtCOkmjZ.AbzPKjsEDkgdgAlrXiN2spABwy11leG','9644068044','chef'),(4,'2022-09-24','Enabled','AMOL@gmail.com','AMOL Choudhary','$2a$10$FPsEsapRudhM7VzsNUKd2.tU2.tWFPwhvAQOdMRJNEJBsRca8G7w6','8785546562','chef'),(5,'2022-09-24','Enabled','LOKESH@gmail.com','LOKESH Choudhary','$2a$10$fC0gYr/2BkboY5f2VLq5/.XA2j.G73I5dc8ZH005r4yOy79fQD0zC','7885546562','cashier'),(6,'2022-09-24','Enabled','VAIBHAV@gmail.com','VAIBHAV PATIL','$2a$10$KnTe7JLik2Q.jo8oMShV/OH0//V.QFnrbMBzysFgbB2ifhuukN3SO','8545546562','waiter'),(7,'2022-09-24','Enabled','MAHENDRA@gmail.com','MAHENDRA SONANIYA','$2a$10$wJ6j3q2Tey45rJcmwV8r6uYN2ufUvomPRIUf4tufi/11UF/.NylVC','9945546562','waiter'),(8,'2022-09-24','Enabled','SHIVAM@gmail.com','SHIVAM PATIL','$2a$10$YW4ko5TtpSS8dekRPICZLeRKiHfNz.PFAMmj778/93oivefsATW2e','9542546562','chef'),(9,'2022-09-24','Enabled','SANCHIT@gmail.com','SABCHIT PATIL','$2a$10$QrtBCWm53bvTHXSTWa.WN.IZcFcCkQcdBIZfkM4tSm4FgKNq8nMqG','7442546562','waiter'),(10,'2022-09-24','Enabled','VINOD@gmail.com','VINOD SAPKALE','$2a$10$1WifzQ1OWVC94L24GpaZrekKOfTiu4eOa0D7Z7NjtS0mCDR4CapVq','6642546562','waiter'),(12,'2022-09-27','Enabled','vishal@gmail.com','vishal','$2a$10$jAaQ8LVMFvVUYrpUZxHTGuovJXilQ98SGVSY/nVLrGk1LEGOzKvMe','1234567890','chef');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 11:22:36
