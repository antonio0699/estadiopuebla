-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: estadiopuebla
-- ------------------------------------------------------
-- Server version	5.5.34

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
-- Table structure for table `ta_estadio_menu`
--

DROP TABLE IF EXISTS `ta_estadio_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_estadio_menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `menu` varchar(45) DEFAULT NULL,
  `id_rol` varchar(45) DEFAULT NULL,
  `activo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_estadio_menu`
--

LOCK TABLES `ta_estadio_menu` WRITE;
/*!40000 ALTER TABLE `ta_estadio_menu` DISABLE KEYS */;
INSERT INTO `ta_estadio_menu` VALUES (1,'modulo de acceso','1',1),(2,'modulo articulos','1',1),(3,'modulo inventarios','1',1),(4,'modulo de usuarios','1',1),(5,'modulo de jugador','1',1),(6,'modulo de reporte','1',1);
/*!40000 ALTER TABLE `ta_estadio_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_estadio_submenu`
--

DROP TABLE IF EXISTS `ta_estadio_submenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_estadio_submenu` (
  `id_submenu` int(11) NOT NULL AUTO_INCREMENT,
  `submenu` varchar(45) DEFAULT NULL,
  `id_menu` int(11) DEFAULT NULL,
  `url_pantall` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_submenu`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_estadio_submenu`
--

LOCK TABLES `ta_estadio_submenu` WRITE;
/*!40000 ALTER TABLE `ta_estadio_submenu` DISABLE KEYS */;
INSERT INTO `ta_estadio_submenu` VALUES (1,'Acceder',1,NULL),(2,'Cerrar sesion',1,NULL),(3,'Recuperar',1,NULL),(4,'Alta',2,NULL),(5,'Modificar',2,NULL),(6,'Eliminar',2,NULL),(7,'Listar',2,NULL),(8,'Recepciones',3,NULL),(9,'Entregas',3,NULL),(10,'Listado',3,NULL),(11,'Alta',4,NULL),(12,'Modificar',4,NULL),(13,'Eliminar',4,NULL),(14,'Listar',4,NULL),(15,'Alta',5,NULL),(16,'Modificar',5,NULL),(17,'Eliminar',5,NULL),(18,'Listar',5,NULL),(19,'Buscador de existencias',6,NULL),(20,'Inventario total',6,NULL),(21,'Reporte de entrega de uniformes',6,NULL);
/*!40000 ALTER TABLE `ta_estadio_submenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_estadio_usuarios`
--

DROP TABLE IF EXISTS `ta_estadio_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_estadio_usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_estadio_usuarios`
--

LOCK TABLES `ta_estadio_usuarios` WRITE;
/*!40000 ALTER TABLE `ta_estadio_usuarios` DISABLE KEYS */;
INSERT INTO `ta_estadio_usuarios` VALUES (1,'laura','123',1);
/*!40000 ALTER TABLE `ta_estadio_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_estadios_roles`
--

DROP TABLE IF EXISTS `ta_estadios_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_estadios_roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `menu` varchar(45) DEFAULT NULL,
  `activo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_estadios_roles`
--

LOCK TABLES `ta_estadios_roles` WRITE;
/*!40000 ALTER TABLE `ta_estadios_roles` DISABLE KEYS */;
INSERT INTO `ta_estadios_roles` VALUES (1,'administrador',1);
/*!40000 ALTER TABLE `ta_estadios_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'estadiopuebla'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-19 19:23:31
