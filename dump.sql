-- MySQL dump 10.15  Distrib 10.0.20-MariaDB, for osx10.10 (x86_64)
--
-- Host: localhost    Database: ecomsport
-- ------------------------------------------------------
-- Server version	10.0.20-MariaDB

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
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresse` (
  `idAdresse` int(11) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAdresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `idArticle` int(11) NOT NULL,
  `Marque` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Prix` int(11) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `id_categorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idArticle`),
  KEY `FK_hwx5nbo80qthchtigribkfdcp` (`id_categorie`),
  CONSTRAINT `FK_hwx5nbo80qthchtigribkfdcp` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`idCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `id_theme` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCategorie`),
  KEY `FK_riqe27xf3vortsyj4q9tbl1yf` (`id_theme`),
  CONSTRAINT `FK_riqe27xf3vortsyj4q9tbl1yf` FOREIGN KEY (`id_theme`) REFERENCES `theme` (`idTheme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `idCommande` int(11) NOT NULL,
  `Date` datetime DEFAULT NULL,
  `Prix` int(11) DEFAULT NULL,
  `Statut` varchar(255) DEFAULT NULL,
  `id_adresse` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `FK_d9q9p0ssuiio519kc0bex1q8t` (`id_adresse`),
  CONSTRAINT `FK_d9q9p0ssuiio519kc0bex1q8t` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`idAdresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande_article`
--

DROP TABLE IF EXISTS `commande_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande_article` (
  `id_commande` int(11) NOT NULL,
  `id_article` int(11) NOT NULL,
  KEY `FK_a1ve2pxqrbgc2u1dmg37w943` (`id_article`),
  KEY `FK_ic3il98bf96ldddywob9drqmh` (`id_commande`),
  CONSTRAINT `FK_a1ve2pxqrbgc2u1dmg37w943` FOREIGN KEY (`id_article`) REFERENCES `article` (`idArticle`),
  CONSTRAINT `FK_ic3il98bf96ldddywob9drqmh` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande_article`
--

LOCK TABLES `commande_article` WRITE;
/*!40000 ALTER TABLE `commande_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compte`
--

DROP TABLE IF EXISTS `compte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compte` (
  `idClient` int(11) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Login` varchar(255) DEFAULT NULL,
  `MDP` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Prenom` varchar(255) DEFAULT NULL,
  `id_adresse` int(11) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  KEY `FK_b8j07qtmot4r2xd866cdhp5yb` (`id_adresse`),
  CONSTRAINT `FK_b8j07qtmot4r2xd866cdhp5yb` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`idAdresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `coordonneescb`
--

DROP TABLE IF EXISTS `coordonneescb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordonneescb` (
  `idCoordonneesCB` int(11) NOT NULL,
  `Crypto` varchar(255) DEFAULT NULL,
  `Date` varchar(255) DEFAULT NULL,
  `Numero` varchar(255) DEFAULT NULL,
  `id_compte` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCoordonneesCB`),
  KEY `FK_on4n15h1qx8e4v5jmu6xg4cdd` (`id_compte`),
  CONSTRAINT `FK_on4n15h1qx8e4v5jmu6xg4cdd` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordonneescb`
--

LOCK TABLES `coordonneescb` WRITE;
/*!40000 ALTER TABLE `coordonneescb` DISABLE KEYS */;
/*!40000 ALTER TABLE `coordonneescb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (53),(53);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `idTheme` int(11) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTheme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-12  5:14:02
