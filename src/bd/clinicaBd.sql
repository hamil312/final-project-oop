-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: clinica
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `citas_medicas`
--

DROP TABLE IF EXISTS `citas_medicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas_medicas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_hora` datetime DEFAULT NULL,
  `medico_id` int DEFAULT NULL,
  `paciente_id` int DEFAULT NULL,
  `nombre_paciente` varchar(45) DEFAULT NULL,
  `nombre_medico` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas_medicas`
--

LOCK TABLES `citas_medicas` WRITE;
/*!40000 ALTER TABLE `citas_medicas` DISABLE KEYS */;
INSERT INTO `citas_medicas` VALUES (2,'2004-12-12 00:00:00',3,1,NULL,NULL),(4,'2005-12-12 00:00:00',3,2,NULL,NULL),(5,'2005-12-12 00:00:00',4,3,NULL,NULL),(6,'2006-12-12 00:00:00',5,8,NULL,NULL),(7,'2007-12-12 00:00:00',6,8,NULL,NULL),(10,'2025-05-12 10:30:00',6,8,'hola','Mas'),(11,'2025-12-12 08:00:00',2,7,'Michael','James');
/*!40000 ALTER TABLE `citas_medicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultas_medicas`
--

DROP TABLE IF EXISTS `consultas_medicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultas_medicas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `diagnostico` varchar(45) DEFAULT NULL,
  `prescripcion` varchar(45) DEFAULT NULL,
  `observaciones` varchar(45) DEFAULT NULL,
  `medico_id` int DEFAULT NULL,
  `cita_id` int DEFAULT NULL,
  `paciente_id` int DEFAULT NULL,
  `medico_nombre` varchar(45) DEFAULT NULL,
  `paciente_nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultas_medicas`
--

LOCK TABLES `consultas_medicas` WRITE;
/*!40000 ALTER TABLE `consultas_medicas` DISABLE KEYS */;
INSERT INTO `consultas_medicas` VALUES (2,'2004-12-12 00:00:00','Hi','Hi Again','none',3,2,1,NULL,NULL),(3,'2005-12-12 00:00:00','Hi','Hi Again Again','none again',3,4,2,NULL,NULL),(4,'2005-12-12 00:00:00','Another diagnosis','Hi Again Again Again','none again',4,5,3,NULL,NULL),(5,'2006-12-12 00:00:00','Covid','Paracetamol','Ninguna',5,6,8,NULL,NULL),(6,'2007-12-12 00:00:00','Covid','Paracetamol 1','Ninguna',6,7,8,NULL,NULL),(9,'2025-05-12 10:30:00','Covid2','Paracetamol 1','Ninguna',6,10,8,'Mas','hola'),(10,'2025-12-12 08:00:00','Covid2','Paracetamol 1','Ninguna',2,11,7,'James','Michael');
/*!40000 ALTER TABLE `consultas_medicas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-26 11:38:21
