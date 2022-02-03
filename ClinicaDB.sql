-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica-db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita` (
  `cita_id` bigint NOT NULL AUTO_INCREMENT,
  `disponible` bit(1) NOT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`cita_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` VALUES (1,_binary '','Otorrinolaringologia','2022-01-29','18:00:00'),(2,_binary '\0','General','2022-01-29','18:00:00'),(3,_binary '','General','2022-01-29','17:00:00'),(4,_binary '','General','2022-01-29','16:00:00'),(5,_binary '','General','2022-01-29','15:00:00'),(6,_binary '','General','2022-01-29','14:00:00'),(7,_binary '','General','2022-01-29','10:00:00'),(8,_binary '','General','2022-01-29','11:00:00'),(9,_binary '','General','2022-01-29','10:00:00'),(10,_binary '','General','2022-01-29','10:00:00');
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita_usuario`
--

DROP TABLE IF EXISTS `cita_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita_usuario` (
  `historial_id` bigint NOT NULL,
  `cita_id` bigint NOT NULL,
  PRIMARY KEY (`historial_id`,`cita_id`),
  UNIQUE KEY `UK_tismajqo6xyq7nc24bmbg4mx5` (`cita_id`),
  UNIQUE KEY `UK_etwo8ur1pjhkbc1qdb25ue0i6` (`historial_id`),
  CONSTRAINT `FKotby94e3jjiw1qfxgbbfmjmvy` FOREIGN KEY (`historial_id`) REFERENCES `historial` (`historial_id`),
  CONSTRAINT `FKpi7veboxno6hnp1f5agcfb0bp` FOREIGN KEY (`cita_id`) REFERENCES `cita` (`cita_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita_usuario`
--

LOCK TABLES `cita_usuario` WRITE;
/*!40000 ALTER TABLE `cita_usuario` DISABLE KEYS */;
INSERT INTO `cita_usuario` VALUES (1,2);
/*!40000 ALTER TABLE `cita_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial` (
  `historial_id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`historial_id`),
  KEY `FKlokcpcj85w8sm6ye61wq2w2vn` (`usuario_id`),
  CONSTRAINT `FKlokcpcj85w8sm6ye61wq2w2vn` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (1,'2020-01-01 00:00:00',1);
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento` (
  `medicamento_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`medicamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta` (
  `receta_id` bigint NOT NULL AUTO_INCREMENT,
  `diagnostico` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `vigencia` bit(1) NOT NULL,
  `cita_id` bigint DEFAULT NULL,
  PRIMARY KEY (`receta_id`),
  KEY `FKji1nlrda8ol80i1dnjebse20n` (`cita_id`),
  CONSTRAINT `FKji1nlrda8ol80i1dnjebse20n` FOREIGN KEY (`cita_id`) REFERENCES `cita` (`cita_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_medicamento`
--

DROP TABLE IF EXISTS `receta_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta_medicamento` (
  `medicamento_id` bigint NOT NULL,
  `receta_id` bigint NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`medicamento_id`,`receta_id`),
  UNIQUE KEY `UK_gf06htsec279jp8wf7gm4p8o5` (`medicamento_id`),
  UNIQUE KEY `UK_9ttu81ca3hanx2fltf290abk4` (`receta_id`),
  CONSTRAINT `FK33ljwpx976qfn68k50ebx05sc` FOREIGN KEY (`receta_id`) REFERENCES `receta` (`receta_id`),
  CONSTRAINT `FKk8yybi10rlynwhvjckrjn4hsi` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`medicamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_medicamento`
--

LOCK TABLES `receta_medicamento` WRITE;
/*!40000 ALTER TABLE `receta_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `receta_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `usuario_id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `correo_electronico` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `edad` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_usuario` varchar(255) DEFAULT NULL,
  `historial_id` bigint DEFAULT NULL,
  PRIMARY KEY (`usuario_id`),
  KEY `FKdfhhfk1jojkjk7kvvtbu2m54r` (`historial_id`),
  CONSTRAINT `FKdfhhfk1jojkjk7kvvtbu2m54r` FOREIGN KEY (`historial_id`) REFERENCES `historial` (`historial_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Yagui','18200222','panza',NULL,'77883212',22,'Carlos','999765433','Estudiante',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-01 17:34:54
