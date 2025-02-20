Enter password: 
-- MySQL dump 10.13  Distrib 8.0.41, for Linux (x86_64)
--
-- Host: localhost    Database: pokemon
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attaques`
--

DROP TABLE IF EXISTS `attaques`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attaques` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nom_attaque` varchar(255) DEFAULT NULL,
  `id_type` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK64pqefic8mnxtp5ik05i593at` (`id_type`),
  CONSTRAINT `FK64pqefic8mnxtp5ik05i593at` FOREIGN KEY (`id_type`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attaques`
--

LOCK TABLES `attaques` WRITE;
/*!40000 ALTER TABLE `attaques` DISABLE KEYS */;
INSERT INTO `attaques` VALUES (1,'Psykoud\'Boul',13),(2,'S├®isme',15),(3,'Poing Glace',8),(4,'Poing M├®t├®ore',1),(5,'Vibrobscur',17),(6,'Surf',4),(7,'D├®tricanon',12),(8,'Laser Glace',8),(9,'Ombre Port├®e',16),(10,'T├¬te de Fer',1),(11,'Danse Lames',10),(12,'Damocl├¿s',10),(13,'Bouclier Royal',16),(14,'Vampi-Poing',2),(15,'Close Combat',2),(16,'Col├¿re',3),(17,'Draco-Griffe',3),(18,'Luminocanon',1),(19,'Fulgurayon',5),(20,'Lance-Soleil',11),(21,'Draco-M├®t├®ore',3),(22,'Boutefeu',7),(23,'Vitesse Extr├¬me',10),(24,'Lame de Roc',14),(25,'M├óchouille',17),(26,'Canon Graine',11),(27,'Mach Punch',2),(28,'Poing Feu',7),(29,'Poing ├ëclair',5),(30,'├ëco-Sph├¿re',11),(31,'Exploforce',2),(32,'Draco-Choc',3),(33,'Temp├¬te Verte',11),(34,'Pied Br├╗leur',7),(35,'Telluriforce',15),(36,'Lance-Flammes',7),(37,'Ball\'Ombre',16),(38,'Psyko',13),(39,'Choc Psy',13),(40,'├ëclat Magique',6),(41,'Danse Draco',3),(42,'Blizzard',8),(43,'M├®gacorne',9),(44,'Tricherie',17),(45,'Abri',10),(46,'Toxik',12),(47,'Cent Rancunes',17),(48,'Plaie-Croix',9),(49,'Lame-Feuille',11),(50,'Voile Miroir',13),(51,'M├®gaphone',10),(52,'Tonnerre',5),(53,'Coup d\'Jus',5),(54,'Change-├ëclair',5),(55,'Queue de Fer',1),(56,'Hydrocanon',4),(57,'Pisto-Poing',1),(58,'D├®flagration',7),(59,'Flying Press',2),(60,'Piqu├®',18),(61,'├ëbullition',4),(62,'Atterrissage',18),(63,'Demi-Tour',9),(64,'Surpuissance',2),(65,'Pouvoir Lunaire',6),(66,'G├®nusection',17),(67,'Direct Toxik',12),(68,'Coup Bas',17),(69,'Coupe Psycho',13),(70,'Bomb Beurk',12),(71,'Danse Fleurs',11),(72,'Giga-Sangsue',11),(73,'Fracass\'T├¬te',14),(74,'Lyophilisation',8),(75,'Pouvoir Antique',14),(76,'Cascade',4),(77,'Ailes Psycho',13),(78,'Lame d\'Air',18),(79,'Vent Arri├¿re',18),(80,'Vent Violent',18),(81,'Boule ├ëlek',5),(82,'N┼ôud Herbe',11),(83,'Cradovague',12),(84,'Pi├¿ge de Roc',14),(85,'C├ólinerie',6),(86,'Dynamo-Poing',2),(87,'Tacle Lourd',1),(88,'Mur Fumig├¿ne',1),(89,'Poison-Croix',12),(90,'Rapace',18),(91,'Anti-Brume',18),(92,'Crocs Givre',8),(93,'Gyroballe',1),(94,'Bluff',10),(95,'Assaut Frontal',15),(96,'Tranche',10),(97,'Cavalerie Lourde',15),(98,'Taurogne',10),(99,'├ëboulement',14),(100,'Canicule',7),(101,'Ultralaser',10),(102,'├ëruption',7),(103,'Hydro-Queue',4),(104,'Psycho-Croc',13),(105,'Bang Sonique',10),(106,'Crocs ├ëclair',5),(107,'├ëclair Fou',5),(108,'Crocs Feu',7),(109,'Aurasph├¿re',2),(110,'Pic├┤ts',15),(111,'Bec Vrille',18),(112,'Pied Voltige',2),(113,'├ëclats Glace',8),(114,'Exuviation',10),(115,'Chute Glace',8),(116,'Aqua-Br├¿che',4),(117,'Explonuit',17),(118,'Vibr├®caille',3),(119,'Griffe Ombre',16),(120,'Tisse Ombre',16),(121,'Dark Lariat',17),(122,'Vampirisme',9),(123,'Aria de l\'├ëcume',4),(124,'Vif Roc',14),(125,'Casse-Brique',2),(126,'Tunnelier',15),(127,'Blockhaus',12),(128,'Soin',10),(129,'Pics Toxik',12),(130,'Bourdon',9),(131,'M├®gafouet',11),(132,'Ancrage',1),(133,'Aqua-Jet',4),(134,'Escarmouche',9),(135,'Carapi├¿ge',7),(136,'Giga Impact',10),(137,'Marto-Poing',2),(138,'Amass\'Sable',15),(139,'Extrasenseur',13),(140,'Bec-Canon',18),(141,'Marteau de Glace',8),(142,'├ëlectrikipik',5),(143,'Pico-D├®fense',11),(144,'Botte Sucrette',11),(145,'Acrobatie',18),(146,'Os\'Ombre',16),(147,'Tr├®pignement',15),(148,'Sabotage',17),(149,'Tambour Battant',11),(150,'Ballon Br├╗lant',7),(151,'Hantise',16),(152,'Draco-Fl├¿ches',3),(153,'Enroulement',12),(154,'Fouet de Feu',7),(155,'Overdrive',5),(156,'Tacle Feu',7),(157,'Ultime Bastion',2),(158,'Big Splash',2),(159,'Choc ├ëmotionnel',6),(160,'Force G',11),(161,'Acide Malique',11),(162,'Feu Encorcel├®',7),(163,'Pl├®nitude',13),(164,'Papillodanse',9),(165,'Roue Libre',5),(166,'Regard M├®dusant',10),(167,'Ex├®cu-Son',17),(168,'Fa├ºade',10),(169,'Blocage',17),(170,'Machination',17),(171,'Clonage',10),(172,'Kokiyarme',12),(173,'Sort Sinistre',13),(174,'Tir de Pr├®cision',4),(175,'Charge Glaive',3),(176,'Ru├®e d\'Or',1),(177,'Canon Blind├®',7),(178,'Lame Solaire',11),(179,'Tranche-Nuit',17),(180,'Lame en Peine',7),(181,'Souplesse',10),(182,'Marteau Mastoc',1),(183,'Laser Hasard',3),(184,'Cri Draconique',3),(185,'Chant Flamboyant',7),(186,'Aquatacle',4),(187,'Queulonage',10),(188,'Draco-Charge',3),(189,'Poing Ombre',16),(190,'Poing de Col├¿re',16),(191,'Plaquage',10),(192,'Plat du Jour',3),(193,'D├®rapage',1),(194,'Eau Revoir',4),(195,'Poing Sonique',4),(196,'Rayon Gemme',14),(197,'Tomberoche',14),(198,'Rebond',18),(199,'Cryo-Pirouette',8),(200,'Tunnel',15),(201,'Surchauffe',7),(202,'Double D├®charge',5),(203,'Salaison',14),(204,'Hommage Posthume',16),(205,'Draco-Ascension',18),(206,'Lame Pang├®enne',15),(207,'Fatal-Foudre',5),(208,'Onde Originelle',4),(209,'Choc M├®t├®ore',1),(210,'Rayon Spectral',16),(211,'Laser Prisme',13),(212,'Photo-Geyser',13),(213,'G├®o-Contr├┤le',6),(214,'Mort-Ailes',18),(215,'Myria-Fl├¿ches',15),(216,'Sanction Supr├¬me',3),(217,'Hurle-Temps',3),(218,'Spatio-Rift',3),(219,'Revenant',16),(220,'Z├®nith',7),(221,'Feu Sacr├®',7),(222,'A├®roblast',18),(223,'Lame Sainte',2),(224,'Garde Large',14),(225,'Mur de Fer',1),(226,'Laser Infinimax',3),(227,'Canon Dynamax',3),(228,'Glaciation',8),(230,'Frappe Psy',13),(231,'Flamme Bleue',7),(232,'Flamme Croix',7),(233,'├ëclair Croix',5),(234,'Charge Foudre',5),(235,'├ëcrous d\'Poing',1),(236,'Ultimapoing',10),(237,'Plasma Punch',5),(238,'Ire de la Nature',6),(239,'Martobois',11),(240,'Encornebois',11),(241,'Brume',8),(242,'Repos',13),(243,'Tour Rapide',10),(244,'Voltage├┤le',5),(245,'Draco-├ënergie',3),(246,'Vortex Magma',7),(247,'Vampigraine',11),(248,'Estocorne',1),(249,'Pi├¿ge de Venin',12),(250,'Caboche-Kaboum',7),(251,'Taillade',9),(252,'Vampibaiser',6),(253,'Typhon Passionn├®',6),(254,'Vive-Attaque',10),(255,'Coup d\'Boule',10),(256,'├ëclate Griffe',10),(257,'Coup Double',10),(258,'Synth├¿se',11),(259,'Temp├¬te Florale',11),(260,'Regard Gla├ºant',13),(261,'Coup Fulgurant',2),(262,'Fureur Ardente',17),(263,'Croque Fort',17),(264,'Branchicrok',4),(265,'Coup Varia-Type',10),(266,'Chant Antique',10),(267,'Danse du Feu',7),(268,'M├®talliroue',1),(269,'Forte-Paume',2),(270,'Furie-Bond',9),(271,'Lame Ointe',2),(272,'Ocroupi',4);
/*!40000 ALTER TABLE `attaques` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boite_dresseur`
--

DROP TABLE IF EXISTS `boite_dresseur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boite_dresseur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` int DEFAULT NULL,
  `boite_id` int NOT NULL,
  `dresseur_id` int NOT NULL,
  PRIMARY KEY (`id`,`boite_id`,`dresseur_id`),
  KEY `FK38cvl54yb6n1ea2p2r1ho7j1y` (`boite_id`),
  KEY `FKjnbc082kek24p87ogougqulol` (`dresseur_id`),
  CONSTRAINT `FK38cvl54yb6n1ea2p2r1ho7j1y` FOREIGN KEY (`boite_id`) REFERENCES `boites` (`id`),
  CONSTRAINT `FKjnbc082kek24p87ogougqulol` FOREIGN KEY (`dresseur_id`) REFERENCES `dresseurs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boite_dresseur`
--

LOCK TABLES `boite_dresseur` WRITE;
/*!40000 ALTER TABLE `boite_dresseur` DISABLE KEYS */;
INSERT INTO `boite_dresseur` VALUES (1,1,1,10),(2,1,1,43),(3,2,1,48),(4,7,1,52),(5,2,1,70),(6,1,1,83),(7,1,1,92),(8,1,1,99),(9,3,1,102),(10,6,1,103),(11,3,1,105),(12,1,1,106),(13,1,1,107),(14,1,2,10),(15,2,2,25),(16,2,2,43),(17,3,2,48),(18,6,2,52),(19,2,2,70),(20,1,2,84),(21,1,2,95),(22,1,2,99),(23,1,2,100),(24,2,2,102),(25,2,2,103),(26,3,2,105),(27,1,2,108),(28,2,2,116),(29,3,4,83),(30,5,4,84),(31,4,4,92),(32,2,4,95),(33,5,4,99),(34,2,4,100),(35,1,4,102),(36,1,4,103),(37,7,4,112),(38,3,5,82),(39,5,5,85),(40,9,5,102),(41,2,5,105),(42,5,5,109),(43,6,5,116),(44,11,6,106),(45,11,6,107),(46,4,6,108),(47,4,6,114),(48,1,7,14),(49,1,7,74),(50,5,7,83),(51,9,7,99),(52,5,7,102),(53,2,7,104),(54,1,7,105),(55,1,7,116),(56,1,7,135),(57,1,7,134),(58,2,7,140),(59,1,7,141),(60,2,8,14),(61,5,8,83),(62,6,8,99),(63,3,8,102),(64,4,8,104),(65,3,8,105),(66,2,8,81),(67,1,8,116),(68,1,9,139),(69,1,8,136),(70,1,8,137),(71,1,8,138),(72,4,3,43),(73,3,3,48),(74,2,3,52),(75,2,3,70),(76,5,3,83),(77,1,3,95),(78,4,3,99),(79,3,3,100),(80,1,3,102),(81,2,3,103),(82,1,3,105),(83,1,3,108),(84,1,3,114),(85,1,8,142),(86,1,9,143),(87,1,9,14),(88,1,9,144),(89,1,9,145),(90,1,9,146),(91,1,9,147),(92,4,9,114),(93,1,9,142),(94,3,9,105),(95,1,9,148),(96,7,9,106),(97,3,9,107),(98,1,9,149);
/*!40000 ALTER TABLE `boite_dresseur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boite_nature`
--

DROP TABLE IF EXISTS `boite_nature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boite_nature` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` int DEFAULT NULL,
  `boite_id` int NOT NULL,
  `nature_id` int NOT NULL,
  PRIMARY KEY (`id`,`boite_id`,`nature_id`),
  KEY `FKqebuiyw1c156udrgukm9csg82` (`boite_id`),
  KEY `FK183cn018m6w0wt3scj542ons6` (`nature_id`),
  CONSTRAINT `FK183cn018m6w0wt3scj542ons6` FOREIGN KEY (`nature_id`) REFERENCES `natures` (`id_nature`),
  CONSTRAINT `FKqebuiyw1c156udrgukm9csg82` FOREIGN KEY (`boite_id`) REFERENCES `boites` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boite_nature`
--

LOCK TABLES `boite_nature` WRITE;
/*!40000 ALTER TABLE `boite_nature` DISABLE KEYS */;
INSERT INTO `boite_nature` VALUES (1,3,1,3),(2,3,1,11),(3,8,1,16),(4,2,1,18),(5,1,1,19),(6,10,1,22),(7,3,1,25),(8,2,2,3),(9,2,2,5),(10,2,2,11),(11,8,2,16),(12,1,2,18),(13,13,2,22),(14,2,2,25),(15,2,3,5),(16,4,3,11),(17,7,3,16),(18,1,3,18),(19,12,3,22),(20,4,3,25),(21,3,4,3),(22,3,4,5),(23,7,4,11),(24,3,4,16),(25,1,4,21),(26,10,4,22),(27,3,4,25),(28,1,5,3),(29,1,5,5),(30,1,5,8),(31,6,5,11),(32,4,5,16),(33,1,5,18),(34,10,5,22),(35,6,5,25),(36,1,6,7),(37,8,6,11),(38,7,6,16),(39,1,6,21),(40,11,6,22),(41,2,6,25);
/*!40000 ALTER TABLE `boite_nature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boite_pokeball`
--

DROP TABLE IF EXISTS `boite_pokeball`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boite_pokeball` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` int DEFAULT NULL,
  `boite_id` int NOT NULL,
  `pokeball_id` int NOT NULL,
  PRIMARY KEY (`id`,`boite_id`,`pokeball_id`),
  KEY `FKspu0ghm5efygdfv2dcqlglvgs` (`boite_id`),
  KEY `FK44omcwjq6au05clq4wel6hnvd` (`pokeball_id`),
  CONSTRAINT `FK44omcwjq6au05clq4wel6hnvd` FOREIGN KEY (`pokeball_id`) REFERENCES `pokeballs` (`id_pokeball`),
  CONSTRAINT `FKspu0ghm5efygdfv2dcqlglvgs` FOREIGN KEY (`boite_id`) REFERENCES `boites` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boite_pokeball`
--

LOCK TABLES `boite_pokeball` WRITE;
/*!40000 ALTER TABLE `boite_pokeball` DISABLE KEYS */;
INSERT INTO `boite_pokeball` VALUES (1,5,1,1),(2,5,1,9),(3,1,1,7),(4,1,1,13),(5,3,1,18),(6,1,1,19),(7,7,1,17),(8,7,1,16),(9,5,2,1),(10,4,2,9),(11,1,2,13),(12,1,2,15),(13,1,2,21),(14,3,2,19),(15,7,2,17),(16,2,2,22),(17,5,2,16),(18,1,2,23),(19,2,3,1),(20,3,3,9),(21,2,3,8),(22,1,3,15),(23,1,3,11),(24,2,3,18),(25,1,3,20),(26,3,3,19),(27,7,3,17),(28,3,3,22),(29,4,3,16),(30,1,3,23),(31,2,4,1),(32,5,4,18),(33,3,4,20),(34,4,4,19),(35,7,4,17),(36,8,4,16),(37,1,4,23),(38,3,5,1),(39,2,5,18),(40,2,5,21),(41,1,5,20),(42,7,5,19),(43,6,5,17),(44,3,5,22),(45,6,5,16),(46,2,6,1),(47,2,6,18),(48,3,6,21),(49,2,6,20),(50,4,6,19),(51,9,6,17),(52,1,6,22),(53,6,6,16),(54,1,6,23),(55,3,7,24),(56,16,7,9),(57,2,7,13),(58,2,7,15),(59,2,7,5),(60,5,7,10),(61,2,8,1),(62,5,8,3),(63,11,8,9),(64,1,8,15),(65,1,8,17),(66,4,8,10),(67,6,8,23),(68,1,9,1),(69,2,9,3),(70,12,9,9),(71,7,9,10),(72,1,9,19),(73,1,9,18),(74,1,9,17),(75,2,9,21);
/*!40000 ALTER TABLE `boite_pokeball` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boite_pokedex`
--

DROP TABLE IF EXISTS `boite_pokedex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boite_pokedex` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nb_assexues` bigint DEFAULT NULL,
  `nb_femelles` bigint DEFAULT NULL,
  `nb_level100` bigint DEFAULT NULL,
  `nb_males` bigint DEFAULT NULL,
  `nom_boite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boite_pokedex`
--

LOCK TABLES `boite_pokedex` WRITE;
/*!40000 ALTER TABLE `boite_pokedex` DISABLE KEYS */;
INSERT INTO `boite_pokedex` VALUES (1,0,16,20,14,'001/030'),(2,0,15,21,15,'031/060'),(3,2,9,19,19,'061/090'),(4,3,11,19,16,'091/120'),(5,7,11,25,12,'121/150'),(6,1,3,19,26,'151/180'),(7,1,10,23,19,'181/210'),(8,1,9,22,20,'211/240'),(9,6,15,24,9,'241/270'),(10,1,14,17,15,'271/300'),(11,0,16,22,14,'301/330'),(12,4,9,22,17,'331/360'),(13,11,9,25,10,'361/390'),(14,0,18,23,12,'391/420'),(15,2,15,26,13,'421/450'),(16,4,8,26,18,'451/480'),(17,12,6,12,12,'481/510'),(18,0,13,3,17,'511/540'),(19,0,15,5,15,'541/570'),(20,2,18,5,10,'571/600'),(21,4,13,6,13,'601/630'),(22,9,5,6,16,'631/660'),(23,0,13,0,17,'661/689'),(24,5,13,0,12,'690/719'),(25,2,9,0,19,'720/745'),(26,3,12,1,15,'745/774'),(27,21,2,0,7,'775/804'),(28,5,8,1,17,'805/834'),(29,2,12,0,16,'835/864'),(30,9,8,2,13,'865/893'),(31,5,5,1,20,'894/923'),(32,2,13,1,15,'924/953'),(33,0,18,0,12,'954/983'),(34,26,0,0,4,'984/1013'),(35,5,1,0,6,'1014/1025');
/*!40000 ALTER TABLE `boite_pokedex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boite_sexe`
--

DROP TABLE IF EXISTS `boite_sexe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boite_sexe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` int DEFAULT NULL,
  `boite_id` int NOT NULL,
  `sexe_id` int NOT NULL,
  PRIMARY KEY (`id`,`boite_id`,`sexe_id`),
  KEY `FKpwrxig4tkikkihg90xv0rmj20` (`boite_id`),
  KEY `FKp55e9uey4vcu049vutueyf1rk` (`sexe_id`),
  CONSTRAINT `FKp55e9uey4vcu049vutueyf1rk` FOREIGN KEY (`sexe_id`) REFERENCES `sexe` (`id`),
  CONSTRAINT `FKpwrxig4tkikkihg90xv0rmj20` FOREIGN KEY (`boite_id`) REFERENCES `boites` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boite_sexe`
--

LOCK TABLES `boite_sexe` WRITE;
/*!40000 ALTER TABLE `boite_sexe` DISABLE KEYS */;
INSERT INTO `boite_sexe` VALUES (1,25,1,1),(2,4,1,2),(3,1,1,3),(4,19,2,1),(5,11,2,2),(6,22,3,1),(7,8,3,2),(8,13,4,1),(9,15,4,2),(10,2,4,3),(11,17,5,1),(12,11,5,2),(13,2,5,3),(14,19,6,1),(15,10,6,2),(16,1,6,3),(17,1,7,1),(18,1,7,2),(19,28,7,3),(20,3,8,1),(21,2,8,2),(22,25,8,3),(23,0,2,3),(24,0,3,3),(25,0,9,1),(26,0,9,2),(27,27,9,3);
/*!40000 ALTER TABLE `boite_sexe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boite_type`
--

DROP TABLE IF EXISTS `boite_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boite_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` int DEFAULT NULL,
  `boite_id` int NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`,`boite_id`,`type_id`),
  KEY `FKjp45t48kdsw68g8m6efnofhid` (`boite_id`),
  KEY `FKffs3cifpxgo8kbxyr49td05el` (`type_id`),
  CONSTRAINT `FKffs3cifpxgo8kbxyr49td05el` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`),
  CONSTRAINT `FKjp45t48kdsw68g8m6efnofhid` FOREIGN KEY (`boite_id`) REFERENCES `boites` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boite_type`
--

LOCK TABLES `boite_type` WRITE;
/*!40000 ALTER TABLE `boite_type` DISABLE KEYS */;
INSERT INTO `boite_type` VALUES (1,4,1,1),(2,6,1,2),(3,5,1,3),(4,4,1,4),(5,1,1,5),(6,1,1,6),(7,4,1,7),(8,1,1,8),(9,1,1,9),(10,3,1,11),(11,1,1,12),(12,4,1,13),(13,5,1,15),(14,1,1,16),(15,5,1,17),(16,2,1,18),(17,6,2,1),(18,4,2,3),(19,3,2,4),(20,3,2,5),(21,1,2,6),(22,2,2,7),(23,2,2,8),(24,2,2,9),(25,3,2,11),(26,4,2,12),(27,3,2,13),(28,6,2,14),(29,3,2,15),(30,1,2,16),(31,4,2,17),(32,5,2,18),(33,3,3,1),(34,1,3,2),(35,3,3,3),(36,4,3,4),(37,2,3,5),(38,2,3,6),(39,7,3,7),(40,1,3,8),(41,1,3,9),(42,9,3,10),(43,1,3,12),(44,1,3,13),(45,1,3,14),(46,3,3,15),(47,1,3,16),(48,3,3,17),(49,6,3,18),(50,1,4,1),(51,4,4,2),(52,3,4,3),(53,5,4,4),(54,3,4,5),(55,3,4,6),(56,4,4,7),(57,2,4,8),(58,3,4,9),(59,4,4,10),(60,3,4,11),(61,2,4,12),(62,3,4,13),(63,4,4,14),(64,2,4,15),(65,5,4,16),(66,1,4,17),(67,2,4,18),(68,3,5,1),(69,2,5,2),(70,4,5,3),(71,3,5,4),(72,3,5,5),(73,3,5,6),(74,3,5,7),(75,1,5,8),(76,3,5,9),(77,1,5,10),(78,3,5,11),(79,3,5,12),(80,5,5,13),(81,3,5,14),(82,1,5,15),(83,2,5,16),(84,4,5,17),(85,1,5,18),(86,4,6,1),(87,4,6,2),(88,3,6,3),(89,3,6,4),(90,3,6,5),(91,1,6,6),(92,4,6,7),(93,2,6,8),(94,1,6,9),(95,3,6,10),(96,3,6,11),(97,4,6,12),(98,2,6,13),(99,3,6,14),(100,1,6,15),(101,5,6,16),(102,2,6,17),(103,3,6,18);
/*!40000 ALTER TABLE `boite_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boites`
--

DROP TABLE IF EXISTS `boites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boites` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_level100` bigint DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boites`
--

LOCK TABLES `boites` WRITE;
/*!40000 ALTER TABLE `boites` DISABLE KEYS */;
INSERT INTO `boites` VALUES (1,21,'SHINY FAVORIS'),(2,11,'SHINY STRATS'),(3,6,'SHINY STRATS 2'),(4,21,'SHINY ALOLA'),(5,13,'SHINY GALAR'),(6,7,'SHINY PALDEA'),(7,16,'SHINY L├ëGENDAIRES'),(8,10,'SHINY L├ëGENDAIRES & Co'),(9,8,'SHINY ARCEUS & Cie');
/*!40000 ALTER TABLE `boites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dresseurs`
--

DROP TABLE IF EXISTS `dresseurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dresseurs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` bigint DEFAULT NULL,
  `nb_shiny` bigint DEFAULT NULL,
  `nom_dresseur` varchar(255) NOT NULL,
  `num_dresseur` varchar(255) NOT NULL,
  `id_region_dresseur` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfsnyosxy3e4qa4k38cya0ffrk` (`id_region_dresseur`),
  CONSTRAINT `FKfsnyosxy3e4qa4k38cya0ffrk` FOREIGN KEY (`id_region_dresseur`) REFERENCES `region_dresseur` (`id_region_dresseur`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dresseurs`
--

LOCK TABLES `dresseurs` WRITE;
/*!40000 ALTER TABLE `dresseurs` DISABLE KEYS */;
INSERT INTO `dresseurs` VALUES (1,11,0,'Kal-El','00019',1),(2,12,0,'Takashi','00031',1),(3,6,0,'Wolverine','00053',1),(4,12,0,'M-Jane','00072',1),(5,8,0,'Kenzy','00089',1),(6,9,0,'L├®golas','00101',1),(7,11,0,'Teyla','00106',1),(8,12,0,'Sirius','00110',1),(9,10,0,'Optimus','00150',1),(10,12,2,'Oliver','00200',1),(11,8,0,'Callen','00330',1),(12,12,0,'Natasha','00371',1),(13,14,0,'Seeley','00400',1),(14,11,5,'Thor├»n','00540',1),(15,10,0,'Zo├®','00551',1),(16,7,0,'Dexter','00662',1),(17,13,0,'Arizona','00900',1),(18,8,0,'Samus','00940',1),(19,7,0,'Looping','00978',1),(20,13,0,'Nucky','01008',1),(21,6,0,'Am├®lia','01046',1),(22,3,0,'Hikari','01218',1),(23,7,0,'Jethro','01515',1),(24,5,0,'Izzie','01991',1),(25,10,2,'F├®licity','02004',1),(26,9,0,'Willow','02030',1),(27,10,0,'Seiyar','02318',1),(28,5,0,'Kyra','02515',1),(29,10,0,'Castle','03010',1),(30,5,0,'Rebecca','03069',1),(31,7,0,'Aragorn','03380',1),(32,7,0,'Warrick','03500',1),(33,6,0,'Bane','03800',1),(34,6,0,'Peter','04844',1),(35,11,0,'Ridley','05005',1),(36,5,0,'Olivia','05225',1),(37,8,0,'Ra\'s Al Ghul','06001',1),(38,6,0,'Elliot','06035',1),(39,9,0,'Obi Wan','08070',1),(40,9,0,'Cadel','08085',1),(41,5,0,'Shiryu','08846',1),(42,12,0,'Ayrton','09001',1),(43,8,7,'Skye','09060',1),(44,5,0,'Ang├®lus','09355',1),(45,7,0,'Ma├»di','09839',1),(46,8,0,'Kimblee','09900',1),(47,4,0,'Amidala','10002',1),(48,10,8,'Kenshiro','10003',1),(49,1,0,'Mt Bataille','10048',1),(50,11,0,'Jack','10078',1),(51,5,0,'Ziva','10083',1),(52,9,15,'Slade','10101',1),(53,5,0,'Sisyphe','10128',1),(54,9,0,'Indiana','10222',1),(55,8,0,'Billie','10247',1),(56,8,0,'Gatsby','10300',1),(57,7,0,'Lincoln','10370',1),(58,7,0,'Connor','10414',1),(59,8,0,'Caspian','10510',1),(60,10,0,'Satoshi','10684',1),(61,9,0,'Spike','10688',1),(62,7,0,'Di├®go','10723',1),(63,7,0,'Elektra','10798',1),(64,11,0,'Sydney','10981',1),(65,9,0,'Illyria','11078',1),(66,7,0,'Kagaho','11302',1),(67,7,0,'Winry','11910',1),(68,7,0,'Sylar','12850',1),(69,6,0,'Ikki','12939',1),(70,8,6,'Sherlock','13000',1),(71,10,0,'Edward','13663',1),(72,8,0,'Buffy','14010',1),(73,6,0,'Bones','14449',1),(74,0,1,'Jethro','15160',1),(75,8,0,'Castiel','15180',1),(76,6,0,'Ahsoka','17600',1),(77,8,0,'River','19090',1),(78,8,0,'Horatio','34121',1),(79,1,0,'Channel (C├®dric)','40122',1),(80,8,0,'Logan','52338',1),(81,10,2,'Goku','016632',1),(82,9,3,'Zelda','000127',2),(83,10,19,'Hermione','000196',2),(84,11,6,'Aloy','000689',2),(85,9,5,'Thanos','000959',2),(86,12,0,'Ry├┤','001488',2),(87,8,0,'Primrose','001528',2),(88,10,0,'Sylens','001614',3),(89,7,0,'Drax','002482',2),(90,10,0,'Veronica','003370',2),(91,8,0,'Genos','003607',2),(92,11,5,'Shaka','004108',2),(93,10,0,'Actarus','004145',3),(94,9,0,'Rey','005645',2),(95,9,5,'Saitama','005908',2),(96,8,0,'M├®gumi','006599',2),(97,10,0,'Mazikeen','006901',2),(98,7,0,'Loki','007551',2),(99,12,26,'Voldemort','007610',2),(100,9,6,'Gamora','008601',2),(101,8,0,'S├┤ma','008850',2),(102,12,24,'Goldorak','010077',2),(103,12,11,'Kylo Ren','010096',2),(104,12,6,'Erina','010119',2),(105,12,14,'Jin','010172',2),(106,14,19,'Maverick','010415',3),(107,12,15,'Krauser','010787',3),(108,12,6,'Rhaenyra','011611',3),(109,10,5,'Boba Fett','013130',2),(110,12,0,'Wanda','013516',3),(111,10,0,'Bumblebee','013869',3),(112,10,7,'Daenerys','013902',2),(113,8,0,'Lucifer','014101',2),(114,12,9,'Hyunckel','015189',3),(115,12,0,'Teal\'c','016713',3),(116,10,10,'Poe','031000',2),(117,12,0,'Rocket','105000',3),(118,15,0,'Event','Event',3),(119,1,0,'GF','02016',NULL),(120,1,0,'GF','03016',NULL),(121,1,0,'GF','06016',NULL),(122,1,0,'GF','05016',NULL),(123,1,0,'GF','08016',NULL),(124,1,0,'ETE2012','08272',NULL),(125,1,0,'PRI2013','03013',NULL),(126,1,0,'GF','11016',NULL),(127,1,0,'Hope','07245',NULL),(128,1,0,'Harry','10235',NULL),(129,1,0,'Helen','10016',NULL),(130,1,0,'Mt Tensei','100917',NULL),(131,1,0,'Fula','100118',NULL),(132,1,0,'Home','808809',NULL),(133,1,0,'Jungle','201113',NULL),(134,0,1,'Jungle','211006',NULL),(135,0,1,'Event','060218',NULL),(136,0,1,'Event','170714',NULL),(137,0,1,'Event','190222',NULL),(138,0,1,'Event','190524',NULL),(139,0,1,'Event','200630',NULL),(140,0,2,'Event','211022',NULL),(141,0,1,'Event','221118',NULL),(142,0,2,'Event','250128',NULL),(143,0,1,'Wanda','060055',NULL),(144,0,1,'Hondo','001050',NULL),(145,0,1,'Event','220218',NULL),(146,0,1,'Event','220311',NULL),(147,0,1,'Event','220415',NULL),(148,0,1,'Event','241016',NULL),(149,0,1,'Event','250212',NULL);
/*!40000 ALTER TABLE `dresseurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `natures`
--

DROP TABLE IF EXISTS `natures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `natures` (
  `id_nature` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` bigint DEFAULT NULL,
  `nb_shiny` bigint DEFAULT NULL,
  `nom_nature` varchar(255) NOT NULL,
  PRIMARY KEY (`id_nature`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `natures`
--

LOCK TABLES `natures` WRITE;
/*!40000 ALTER TABLE `natures` DISABLE KEYS */;
INSERT INTO `natures` VALUES (1,29,0,'Assur├®'),(2,32,0,'Bizarre'),(3,45,9,'Brave'),(4,43,0,'Calme'),(5,51,8,'Discret'),(6,37,0,'Docile'),(7,32,1,'Doux'),(8,40,1,'Foufou'),(9,45,0,'Gentil'),(10,43,0,'Hardi'),(11,56,30,'Jovial'),(12,32,0,'L├óche'),(13,41,0,'Malin'),(14,34,0,'Malpoli'),(15,33,0,'Mauvais'),(16,54,37,'Modeste'),(17,39,0,'Na├»f'),(18,38,5,'Press├®'),(19,34,1,'Prudent'),(20,36,0,'Pudique'),(21,41,2,'Relax'),(22,90,66,'Rigide'),(23,33,0,'S├®rieux'),(24,25,0,'Solo'),(25,49,20,'Timide');
/*!40000 ALTER TABLE `natures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokeballs`
--

DROP TABLE IF EXISTS `pokeballs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokeballs` (
  `id_pokeball` int NOT NULL AUTO_INCREMENT,
  `nb_pokemon` bigint DEFAULT NULL,
  `nb_shiny` bigint DEFAULT NULL,
  `nom_pokeball` varchar(255) NOT NULL,
  PRIMARY KEY (`id_pokeball`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokeballs`
--

LOCK TABLES `pokeballs` WRITE;
/*!40000 ALTER TABLE `pokeballs` DISABLE KEYS */;
INSERT INTO `pokeballs` VALUES (1,169,24,'Pok├®Ball'),(2,16,0,'SuperBall'),(3,43,7,'HyperBall'),(4,44,0,'BisBall'),(5,48,2,'ChronoBall'),(6,45,0,'FaibloBall'),(7,49,1,'FiletBall'),(8,43,2,'HonorBall'),(9,210,49,'LuxeBall'),(10,55,16,'M├®moireBall'),(11,52,1,'RapideBall'),(12,22,0,'SafariBall'),(13,33,4,'ScubaBall'),(14,36,0,'SoinBall'),(15,40,5,'SombreBall'),(16,20,36,'SpeedBall'),(17,35,45,'MasseBall'),(18,15,15,'App├ótBall'),(19,16,23,'LuneBall'),(20,8,7,'LoveBall'),(21,9,8,'CopainBall'),(22,12,9,'R├¬veBall'),(23,12,10,'UltraBall'),(24,0,3,'MasterBall');
/*!40000 ALTER TABLE `pokeballs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokedex`
--

DROP TABLE IF EXISTS `pokedex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokedex` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nom_pokemon` varchar(255) NOT NULL,
  `num_dex` varchar(255) NOT NULL,
  `id_boite` bigint NOT NULL,
  `dresseur_id` int NOT NULL,
  `id_nature` int NOT NULL,
  `id_pokeball` int NOT NULL,
  `id_region` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd7dl23ikpd0yeanhrwd6i3wxe` (`id_boite`),
  KEY `FKtco1eiqtgltfpcwkv4lei8xx0` (`dresseur_id`),
  KEY `FKsqg8u50t6l1wmewd97ecx42pe` (`id_nature`),
  KEY `FK85g2669fd11yrvmuv5qnoa32b` (`id_pokeball`),
  KEY `FKotw7tjse1nysf0q7evb2athgu` (`id_region`),
  CONSTRAINT `FK85g2669fd11yrvmuv5qnoa32b` FOREIGN KEY (`id_pokeball`) REFERENCES `pokeballs` (`id_pokeball`),
  CONSTRAINT `FKd7dl23ikpd0yeanhrwd6i3wxe` FOREIGN KEY (`id_boite`) REFERENCES `boite_pokedex` (`id`),
  CONSTRAINT `FKotw7tjse1nysf0q7evb2athgu` FOREIGN KEY (`id_region`) REFERENCES `regions` (`id`),
  CONSTRAINT `FKsqg8u50t6l1wmewd97ecx42pe` FOREIGN KEY (`id_nature`) REFERENCES `natures` (`id_nature`),
  CONSTRAINT `FKtco1eiqtgltfpcwkv4lei8xx0` FOREIGN KEY (`dresseur_id`) REFERENCES `dresseurs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1033 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokedex`
--

LOCK TABLES `pokedex` WRITE;
/*!40000 ALTER TABLE `pokedex` DISABLE KEYS */;
INSERT INTO `pokedex` VALUES (1,'Bulbizarre','001',1,6,25,3,1),(2,'Herbizarre','002',1,62,12,1,1),(3,'Florizarre','003',1,35,18,1,1),(4,'Salam├¿che','004',1,55,1,1,1),(5,'Reptincel','005',1,4,12,1,1),(6,'Dracaufeu','006',1,42,6,5,1),(7,'Carapuce','007',1,7,20,1,1),(8,'Carabaffe','008',1,64,12,1,1),(9,'Tortank','009',1,6,21,13,1),(10,'Chenipan','010',1,48,1,1,1),(11,'Chrisacier','011',1,81,7,3,1),(12,'Papilusion','012',1,4,25,1,1),(13,'Aspicot','013',1,84,11,21,1),(14,'Coconfort','014',1,81,4,3,1),(15,'Dardargnan','015',1,4,11,1,1),(16,'Roucool','016',1,55,22,2,1),(17,'Roucoups','017',1,50,17,2,1),(18,'Roucarnage','018',1,39,20,8,1),(19,'Rattata','019',1,81,18,3,1),(20,'Rattatac','020',1,4,2,1,1),(21,'Piafabec','021',1,81,11,3,1),(22,'Rapasdepic','022',1,9,24,11,1),(23,'Abo','023',1,55,15,1,1),(24,'Arbok','024',1,25,6,9,1),(25,'Pikachu','025',1,46,20,10,1),(26,'Raichu','026',1,44,15,12,1),(27,'Sabelette','027',1,64,25,6,1),(28,'Sablaireau','028',1,13,7,12,1),(29,'Nidoran ÔÖÇ','029',1,73,12,6,1),(30,'Nidorina','030',1,50,3,12,1),(31,'Nidoqueen','031',2,64,9,6,1),(32,'Nidoran ÔÖé','032',2,7,3,4,1),(33,'Nidorino','033',2,50,16,12,1),(34,'Nidoking','034',2,63,25,12,1),(35,'Melofee','035',2,42,21,10,1),(36,'Melodelfe','036',2,4,25,1,1),(37,'Goupix','037',2,53,15,5,1),(38,'Feunard','038',2,23,6,14,1),(39,'Rondoudou','039',2,42,15,6,1),(40,'Grodoudou','040',2,60,17,6,1),(41,'Nosferapti','041',2,81,24,3,1),(42,'Noferalto','042',2,50,22,3,1),(43,'Mystherbe','043',2,113,1,6,1),(44,'Ortide','044',2,66,21,6,1),(45,'Rafflesia','045',2,26,13,6,1),(46,'Paras','046',2,103,5,15,1),(47,'Parasect','047',2,55,18,12,1),(48,'Mimitoss','048',2,7,19,12,1),(49,'Aeromite','049',2,4,4,12,1),(50,'Taupiqueur','050',2,73,16,6,1),(51,'Triopikeur','051',2,4,2,8,1),(52,'Miaouss','052',2,17,10,1,1),(53,'Persian','053',2,55,14,2,1),(54,'Psykokwak','054',2,51,14,10,1),(55,'Akwakwak','055',2,6,14,7,1),(56,'Ferosinge','056',2,12,7,9,1),(57,'Colossinge','057',2,104,12,9,1),(58,'Caninos','058',2,50,8,2,1),(59,'Arcanin','059',2,2,20,9,1),(60,'Ptitard','060',2,7,1,7,1),(61,'T├¬tarte','061',3,50,2,13,1),(62,'Tartard','062',3,33,5,7,1),(63,'Abra','063',3,97,25,16,1),(64,'Kadabra','064',3,6,18,8,1),(65,'Alakazam','065',3,62,12,4,1),(66,'Machoc','066',3,73,10,11,1),(67,'Machopeur','067',3,42,21,14,1),(68,'Mackogneur','068',3,18,12,2,1),(69,'Chetiflor','069',3,104,23,9,1),(70,'Boustiflor','070',3,64,20,9,1),(71,'Empiflor','071',3,4,2,4,1),(72,'Tentacool','072',3,12,8,7,1),(73,'Tentacruel','073',3,103,22,7,1),(74,'Racaillou','074',3,66,10,6,1),(75,'Gravalanch','075',3,9,10,8,1),(76,'Grolem','076',3,44,10,6,1),(77,'Ponyta','077',3,50,19,2,1),(78,'Galopa','078',3,35,18,4,1),(79,'Ramoloss','079',3,95,4,1,1),(80,'Flagadoss','080',3,4,18,7,1),(81,'Magneti','081',3,112,14,1,1),(82,'Magneton','082',3,80,23,3,1),(83,'Canarticho','083',3,19,21,10,1),(84,'Doduo','084',3,81,6,3,1),(85,'Dodrio','085',3,54,20,10,1),(86,'Otaria','086',3,17,9,3,1),(87,'Lamantine','087',3,63,3,4,1),(88,'Tadmorv','088',3,81,2,3,1),(89,'Grotadmorv','089',3,55,20,1,1),(90,'Kokiyas','090',3,3,16,3,1),(91,'Crustabri','091',4,62,9,7,1),(92,'Fantominus','092',4,75,5,15,1),(93,'Spectrum','093',4,50,12,9,1),(94,'Ectoplasma','094',4,3,11,1,1),(95,'Onix','095',4,64,1,6,1),(96,'Soporifik','096',4,81,5,3,1),(97,'Hypnomade','097',4,62,13,1,1),(98,'Krabby','098',4,42,22,13,1),(99,'Krabboss','099',4,23,8,7,1),(100,'Voltorb','100',4,99,22,4,1),(101,'Electrode','101',4,75,5,4,1),(102,'Noeunoeuf','102',4,7,4,12,1),(103,'Noadkoko','103',4,63,24,12,1),(104,'Osselait','104',4,84,22,19,1),(105,'Ossatueur','105',4,13,5,10,1),(106,'Kicklee','106',4,81,1,1,1),(107,'Tygnon','107',4,63,8,1,1),(108,'Excelangue','108',4,63,10,1,1),(109,'Smogo','109',4,20,2,9,1),(110,'Smogogo','110',4,9,21,6,1),(111,'Rhinocorne','111',4,51,5,11,1),(112,'Rhinof├®ros','112',4,26,22,4,1),(113,'Leveinard','113',4,60,11,10,1),(114,'Saquedeneu','114',4,4,9,5,1),(115,'Kangourex','115',4,64,5,12,1),(116,'Hypotrempe','116',4,53,17,13,1),(117,'Hypoc├®an','117',4,18,3,13,1),(118,'Poissir├¿ne','118',4,17,11,7,1),(119,'Poissoroi','119',4,64,9,12,1),(120,'Stari','120',4,37,8,9,1),(121,'Staross','121',5,75,23,13,1),(122,'M. Mime','122',5,32,10,14,1),(123,'Ins├®cateur','123',5,62,23,12,1),(124,'Lippoutou','124',5,21,9,15,1),(125,'Elektek','125',5,39,16,4,1),(126,'Magmar','126',5,54,5,11,1),(127,'Scarabrute','127',5,18,14,12,1),(128,'Tauros','128',5,35,3,10,1),(129,'Magicarpe','129',5,48,22,13,1),(130,'L├®viator','130',5,66,2,7,1),(131,'Lokhlass','131',5,64,8,1,1),(132,'M├®tamorph','132',5,25,13,14,1),(133,'├ëvoli','133',5,66,23,1,1),(134,'Aquali','134',5,65,19,13,1),(135,'Voltali','135',5,33,2,11,1),(136,'Pyroli','136',5,54,13,5,1),(137,'Porygon','137',5,55,16,1,1),(138,'Amonita','138',5,64,12,1,1),(139,'Amonistar','139',5,33,10,13,1),(140,'Kabuto','140',5,66,16,1,1),(141,'Kabutops','141',5,63,12,1,1),(142,'Pt├®ra','142',5,65,24,14,1),(143,'Ronflex','143',5,23,16,10,1),(144,'Artikodin','144',5,3,17,9,1),(145,'Electhor','145',5,52,18,15,1),(146,'Sulfura','146',5,51,18,14,1),(147,'Minidraco','147',5,64,4,12,1),(148,'Draco','148',5,64,4,12,1),(149,'Dracolosse','149',5,35,13,10,1),(150,'Mewtwo','150',5,73,7,15,1),(151,'Mew','151',6,119,8,10,1),(152,'Germignon','152',6,78,16,1,2),(153,'Macronium','153',6,27,3,9,2),(154,'M├®ganium','154',6,33,19,15,2),(155,'H├®ricendre','155',6,7,14,1,2),(156,'Feurisson','156',6,27,19,2,2),(157,'Typhlosion','157',6,13,17,1,2),(158,'Kaiminus','158',6,7,12,1,2),(159,'Crocrodil','159',6,27,7,13,2),(160,'Aligatueur','160',6,35,6,1,2),(161,'Fouinette','161',6,99,10,4,2),(162,'Fouinar','162',6,21,14,8,2),(163,'Hoothoot','163',6,113,4,1,2),(164,'Noarfang','164',6,18,6,1,2),(165,'Coxy','165',6,83,7,1,2),(166,'Coxyclaque','166',6,31,7,3,2),(167,'Mimigal','167',6,103,19,6,2),(168,'Migalos','168',6,13,13,4,2),(169,'Nostenfer','169',6,47,18,6,2),(170,'Loupio','170',6,73,6,7,2),(171,'Lanturn','171',6,47,4,13,2),(172,'Pichu','172',6,42,21,4,2),(173,'M├®lo','173',6,17,16,3,2),(174,'Toudoudou','174',6,103,5,11,2),(175,'Togepi','175',6,96,24,1,2),(176,'Togetic','176',6,78,5,1,2),(177,'Natu','177',6,78,1,1,2),(178,'Xatu','178',6,98,5,11,2),(179,'Wattouat','179',6,66,15,11,2),(180,'Lainergie','180',6,50,19,1,2),(181,'Pharamp','181',7,46,13,11,2),(182,'Joliflor','182',7,19,22,15,2),(183,'Marill','183',7,73,23,7,2),(184,'Azumarill','184',7,18,23,1,2),(185,'Simularbre','185',7,9,22,5,2),(186,'Tarpaud','186',7,25,15,7,2),(187,'Granivol','187',7,10,4,6,2),(188,'Floravol','188',7,27,9,2,2),(189,'Cotovol','189',7,53,7,6,2),(190,'Capumain','190',7,27,5,2,2),(191,'Tournegrin','191',7,99,16,1,2),(192,'H├®liatronc','192',7,31,14,2,2),(193,'Yanma','193',7,17,14,7,2),(194,'Axoloto','194',7,66,9,7,2),(195,'Maraiste','195',7,62,1,7,2),(196,'Mentali','196',7,57,23,14,2),(197,'Noctali','197',7,3,20,9,2),(198,'Corn├¿bre','198',7,31,2,1,2),(199,'Roigada','199',7,4,7,13,2),(200,'Feufor├¬ve','200',7,57,10,5,2),(201,'Zarbi','201',7,21,2,10,2),(202,'Qulbutok├®','202',7,51,8,15,2),(203,'Girafarig','203',7,44,2,12,2),(204,'Pomdepik','204',7,99,14,5,2),(205,'Foretress','205',7,31,13,5,2),(206,'Insolourdo','206',7,53,25,5,2),(207,'Scorplane','207',7,27,8,3,2),(208,'Steelix','208',7,75,18,8,2),(209,'Snubull','209',7,10,6,11,2),(210,'Granbull','210',7,60,13,14,2),(211,'Qwilfish','211',8,27,7,2,2),(212,'Cizayox','212',8,52,22,9,2),(213,'Caratroc','213',8,60,18,10,2),(214,'Scarhino','214',8,44,12,12,2),(215,'Farfuret','215',8,54,11,15,2),(216,'Teddiursa','216',8,12,15,1,2),(217,'Ursaring','217',8,46,13,11,2),(218,'Limagma','218',8,42,2,5,2),(219,'Volcaropod','219',8,75,22,4,2),(220,'Marcacrin','220',8,91,11,9,2),(221,'Cochignon','221',8,3,7,5,2),(222,'Corayon','222',8,13,21,8,2),(223,'R├®moraid','223',8,91,15,7,2),(224,'Octillery','224',8,31,9,1,2),(225,'Cadoizo','225',8,21,3,14,2),(226,'D├®manta','226',8,13,11,11,2),(227,'Airmure','227',8,33,25,8,2),(228,'Malosse','228',8,50,23,1,2),(229,'D├®molosse','229',8,35,22,9,2),(230,'Hyporoi','230',8,39,18,13,2),(231,'Phanpy','231',8,72,1,12,2),(232,'Donphan','232',8,60,25,5,2),(233,'Porygon2','233',8,7,16,1,2),(234,'Cerfrousse','234',8,46,4,8,2),(235,'Queulorior','235',8,31,14,5,2),(236,'Debugant','236',8,96,21,4,2),(237,'Kapo├®ra','237',8,13,25,4,2),(238,'Lippouti','238',8,65,3,10,2),(239,'El├®kid','239',8,54,22,4,2),(240,'Magby','240',8,65,5,9,2),(241,'Ecr├®meuh','241',9,21,5,14,2),(242,'Leuphorie','242',9,63,10,12,2),(243,'Raikou','243',9,72,14,11,2),(244,'Entei','244',9,13,3,4,2),(245,'Suicune','245',9,13,24,7,2),(246,'Embrylex','246',9,26,23,6,2),(247,'Ymphect','247',9,7,17,5,2),(248,'Tyranocif','248',9,72,12,11,2),(249,'Lugia','249',9,20,3,22,2),(250,'Ho-oH','250',9,49,25,1,2),(251,'Celebi','251',9,120,25,10,2),(252,'Arcko','252',9,19,25,9,3),(253,'Massko','253',9,7,6,1,3),(254,'Jungko','254',9,42,8,15,3),(255,'Poussifeu','255',9,19,22,5,3),(256,'Galifeu','256',9,50,5,1,3),(257,'Bras├®gali','257',9,6,19,10,3),(258,'Gobou','258',9,19,22,7,3),(259,'Flobio','259',9,61,5,1,3),(260,'Laggron','260',9,72,19,13,3),(261,'Medhy├®na','261',9,78,20,6,3),(262,'Grahy├®na','262',9,23,3,8,3),(263,'Zigzaton','263',9,14,20,4,3),(264,'Lin├®on','264',9,60,20,6,3),(265,'Chenipotte','265',9,14,25,9,3),(266,'Armulys','266',9,14,9,9,3),(267,'Charmillon','267',9,80,14,1,3),(268,'Blindalys','268',9,14,20,9,3),(269,'Papinox','269',9,18,2,1,3),(270,'N├®nupiot','270',9,91,20,9,3),(271,'Lombr├®','271',10,61,23,8,3),(272,'Ludicolo','272',10,26,6,14,3),(273,'Grainipiot','273',10,85,21,9,3),(274,'Pifeuil','274',10,78,9,1,3),(275,'Tengalice','275',10,39,7,15,3),(276,'Nirondelle','276',10,14,16,9,3),(277,'H├®l├®delle','277',10,24,9,11,3),(278,'Go├®lise','278',10,96,11,1,3),(279,'B├®kipan','279',10,113,10,1,3),(280,'Tarsal','280',10,78,4,1,3),(281,'Kirlia','281',10,61,23,6,3),(282,'Gardevoir','282',10,72,21,6,3),(283,'Arakdo','283',10,14,2,7,3),(284,'Maskadra','284',10,19,22,7,3),(285,'Balignon','285',10,17,7,1,3),(286,'Chapignon','286',10,72,1,4,3),(287,'Par├®cool','287',10,12,14,8,3),(288,'Vigoroth','288',10,61,8,4,3),(289,'Monafl├¿mit','289',10,75,25,8,3),(290,'Ningale','290',10,96,4,6,3),(291,'Ninjask','291',10,67,14,11,3),(292,'Munja','292',10,60,10,8,3),(293,'Chuchmur','293',10,113,18,4,3),(294,'Ramboum','294',10,61,20,6,3),(295,'Brouhabam','295',10,26,22,4,3),(296,'Makuhita','296',10,12,10,9,3),(297,'Hariyama','297',10,32,10,4,3),(298,'Azurill','298',10,12,6,1,3),(299,'Tarinor','299',10,21,2,9,3),(300,'Skitty','300',10,14,7,9,3),(301,'Delcatty','301',11,14,24,6,3),(302,'T├®n├®fix','302',11,100,22,19,3),(303,'Mysdibule','303',11,18,14,1,3),(304,'Galekid','304',11,67,22,9,3),(305,'Galegon','305',11,61,6,6,3),(306,'Galeking','306',11,26,23,8,3),(307,'M├®ditikka','307',11,43,22,16,3),(308,'Charmina','308',11,80,9,3,3),(309,'Dynavolt','309',11,42,3,11,3),(310,'Elecsprint','310',11,57,13,11,3),(311,'Posipi','311',11,2,9,10,3),(312,'N├®gapi','312',11,60,16,11,3),(313,'Muciole','313',11,68,20,7,3),(314,'Lumivole','314',11,15,16,14,3),(315,'Ros├®lia','315',11,65,5,6,3),(316,'Gloupti','316',11,104,20,9,3),(317,'Avaltout','317',11,47,24,5,3),(318,'Carvanha','318',11,97,22,18,3),(319,'Sharp├®do','319',11,26,18,13,3),(320,'Wailmer','320',11,96,14,9,3),(321,'Wailord','321',11,37,6,9,3),(322,'Chamallot','322',11,12,16,5,3),(323,'Cam├®rupt','323',11,72,8,12,3),(324,'Chartor','324',11,32,13,5,3),(325,'Spoink','325',11,35,19,8,3),(326,'Groret','326',11,57,5,4,3),(327,'Spinda','327',11,60,3,10,3),(328,'Kraknoix','328',11,98,22,9,3),(329,'Vibraninf','329',11,27,24,5,3),(330,'Lib├®gon','330',11,42,13,9,3),(331,'Cacn├®a','331',12,67,4,11,3),(332,'Cacturne','332',12,62,6,1,3),(333,'Tylton','333',12,27,21,2,3),(334,'Altaria','334',12,6,18,9,3),(335,'Mangriff','335',12,78,5,5,3),(336,'S├®viper','336',12,39,20,5,3),(337,'S├®l├®roc','337',12,86,8,5,3),(338,'Solaroc','338',12,37,24,9,3),(339,'Barloche','339',12,10,15,7,3),(340,'Barbicha','340',12,14,13,7,3),(341,'Ecrapince','341',12,9,11,7,3),(342,'Colhomard','342',12,57,5,13,3),(343,'Balbuto','343',12,78,17,1,3),(344,'Kaorine','344',12,18,8,2,3),(345,'Lilia','345',12,46,21,1,3),(346,'Vacilys','346',12,6,5,15,3),(347,'Anorith','347',12,54,9,6,3),(348,'Armaldo','348',12,32,9,6,3),(349,'Barpau','349',12,10,16,1,3),(350,'Milobellus','350',12,26,11,13,3),(351,'Morph├®o','351',12,61,24,1,3),(352,'K├®cl├®on','352',12,2,6,8,3),(353,'Polichombr','353',12,9,22,15,3),(354,'Branette','354',12,67,18,15,3),(355,'Skel├®nox','355',12,53,24,15,3),(356,'T├®raclope','356',12,65,21,15,3),(357,'Tropius','357',12,47,12,9,3),(358,'Eoko','358',12,39,9,14,3),(359,'Absol','359',12,32,22,9,3),(360,'Ok├®ok├®','360',12,17,11,3,3),(361,'Stalgamin','361',13,68,17,10,3),(362,'Oniglali','362',13,35,11,9,3),(363,'Obalie','363',13,2,24,11,3),(364,'Phogleur','364',13,13,12,13,3),(365,'Kaimorse','365',13,23,12,7,3),(366,'Coquiperl','366',13,83,23,1,3),(367,'Serpang','367',13,44,20,2,3),(368,'Rosabyss','368',13,80,25,1,3),(369,'Relicanth','369',13,14,8,5,3),(370,'Lovdisc','370',13,2,25,10,3),(371,'Draby','371',13,7,19,1,3),(372,'Drackhaus','372',13,61,16,4,3),(373,'Drattak','373',13,72,15,10,3),(374,'Terhal','374',13,103,22,17,3),(375,'M├®tang','375',13,61,3,1,3),(376,'M├®talosse','376',13,54,8,9,3),(377,'Regirock','377',13,80,21,5,3),(378,'Regice','378',13,80,18,5,3),(379,'Registeel','379',13,80,19,3,3),(380,'Latias','380',13,13,2,14,3),(381,'Latios','381',13,46,13,10,3),(382,'Kyogre','382',13,13,9,13,3),(383,'Groudon','383',13,46,20,9,3),(384,'Rayquaza','384',13,80,8,3,3),(385,'Jirachi','385',13,79,21,1,3),(386,'Deoxys','386',13,37,13,3,3),(387,'Tortipouss','387',13,104,13,9,4),(388,'Boskara','388',13,24,12,1,4),(389,'Torterra','389',13,13,4,10,4),(390,'Ousticram','390',13,15,16,1,4),(391,'Chimpenfeu','391',14,45,14,1,4),(392,'Simiabraz','392',14,57,11,10,4),(393,'Tiplouf','393',14,9,16,1,4),(394,'Prinplouf','394',14,68,8,1,4),(395,'Pingol├®on','395',14,32,20,13,4),(396,'Etourmi','396',14,2,9,10,4),(397,'Etourvol','397',14,15,4,8,4),(398,'Etouraptor','398',14,16,23,1,4),(399,'Keunotor','399',14,12,22,1,4),(400,'Castorno','400',14,71,10,1,4),(401,'Crikzik','401',14,83,22,4,4),(402,'M├®lokrik','402',14,15,5,4,4),(403,'Lixy','403',14,65,6,5,4),(404,'Luxio','404',14,15,11,11,4),(405,'Luxray','405',14,6,20,11,4),(406,'Rozbouton','406',14,82,15,9,4),(407,'Roserade','407',14,14,21,9,4),(408,'Kranidos','408',14,71,23,1,4),(409,'Charkos','409',14,57,19,8,4),(410,'Dinoclier','410',14,9,15,6,4),(411,'Bastiodon','411',14,45,23,1,4),(412,'Cheniti','412',14,17,17,6,4),(413,'Cheniselle','413',14,45,13,6,4),(414,'Papilord','414',14,24,9,8,4),(415,'Apitrini','415',14,52,22,3,4),(416,'Apireine','416',14,45,1,7,4),(417,'Pachirisu','417',14,54,20,11,4),(418,'Mustebouee','418',14,35,23,9,4),(419,'Musteflott','419',14,15,13,13,4),(420,'Ceribou','420',14,82,13,8,4),(421,'Ceriflor','421',15,15,5,6,4),(422,'Sancoki','422',15,71,7,5,4),(423,'Tritosor','423',15,54,7,7,4),(424,'Capidextre','424',15,2,10,14,4),(425,'Baudrive','425',15,71,13,11,4),(426,'Grodrive','426',15,45,8,14,4),(427,'Laporeille','427',15,42,9,10,4),(428,'Lockpin','428',15,65,22,8,4),(429,'Magir├¬ve','429',15,31,17,5,4),(430,'Corboss','430',15,16,6,15,4),(431,'Chaglam','431',15,2,21,10,4),(432,'Chaffreux','432',15,45,21,14,4),(433,'Korillon','433',15,83,2,14,4),(434,'Moufouette','434',15,71,21,1,4),(435,'Moufflair','435',15,24,17,10,4),(436,'Arch├®omire','436',15,9,4,4,4),(437,'Arch├®odong','437',15,16,1,14,4),(438,'Manza├»','438',15,22,9,10,4),(439,'Mime Jr','439',15,15,6,10,4),(440,'Ptiravi','440',15,12,16,3,4),(441,'Pijako','441',15,68,4,11,4),(442,'Spiritomb','442',15,22,4,14,4),(443,'Griknot','443',15,65,21,11,4),(444,'Carmache','444',15,68,7,14,4),(445,'Carchacrok','445',15,35,9,9,4),(446,'Goinfrex','446',15,71,17,1,4),(447,'Riolu','447',15,71,3,1,4),(448,'Lucario','448',15,39,3,10,4),(449,'Hippopotas','449',15,71,12,15,4),(450,'Hippodocus','450',15,15,6,5,4),(451,'Rapion','451',16,71,9,1,4),(452,'Drascore','452',16,35,7,10,4),(453,'Cradopaud','453',16,68,22,15,4),(454,'Coatox','454',16,45,21,12,4),(455,'Vortente','455',16,68,16,8,4),(456,'Ecayon','456',16,17,2,1,4),(457,'Lumin├®on','457',16,19,17,13,4),(458,'Babimanta','458',16,20,8,13,4),(459,'Blizzi','459',16,71,11,5,4),(460,'Blizzaroi','460',16,16,6,11,4),(461,'Dimoret','461',16,27,24,3,4),(462,'Magn├®zone','462',16,24,19,10,4),(463,'Coudlangue','463',16,60,13,10,4),(464,'Rhinastoc','464',16,13,3,10,4),(465,'Bouldeneu','465',16,55,17,3,4),(466,'Elekable','466',16,67,22,11,4),(467,'Maganon','467',16,39,19,9,4),(468,'Togekiss','468',16,51,5,1,4),(469,'Yanm├®ga','469',16,46,12,7,4),(470,'Phyllali','470',16,9,8,15,4),(471,'Givrali','471',16,42,6,8,4),(472,'Scorvol','472',16,32,9,10,4),(473,'Mammochon','473',16,2,25,8,4),(474,'Porygon-Z','474',16,4,19,1,4),(475,'Gallame','475',16,102,22,9,4),(476,'Tarinorme','476',16,16,11,14,4),(477,'Noctunoir','477',16,113,1,15,4),(478,'Momartik','478',16,67,4,9,4),(479,'Motisma','479',16,16,10,15,4),(480,'Cr├®helf','480',16,67,17,4,4),(481,'Cr├®follet','481',17,2,1,5,4),(482,'Cr├®fadet','482',17,22,21,11,4),(483,'Dialga','483',17,16,16,11,4),(484,'Palkia','484',17,39,11,7,4),(485,'Heatran','485',17,105,10,9,4),(486,'Regigigas','486',17,2,2,10,4),(487,'Giratina','487',17,26,21,10,4),(488,'Cresselia','488',17,2,19,14,4),(489,'Phione','489',17,15,9,13,4),(490,'Manaphy','490',17,121,17,10,4),(491,'Darkrai','491',17,122,7,10,4),(492,'Shaymin','492',17,6,21,8,4),(493,'Arceus','493',17,123,6,10,4),(494,'Victini','494',17,41,2,14,5),(495,'Vip├®lierre','495',17,69,1,1,5),(496,'Lianaja','496',17,58,13,1,5),(497,'Majaspic','497',17,8,15,1,5),(498,'Gruikui','498',17,1,8,1,5),(499,'Grotichon','499',17,5,12,1,5),(500,'Roitiflam','500',17,29,9,1,5),(501,'Moustillon','501',17,77,1,1,5),(502,'Mateloutre','502',17,38,17,1,5),(503,'Clamiral','503',17,11,2,1,5),(504,'Ratentif','504',17,23,8,6,5),(505,'Miradar','505',17,76,10,8,5),(506,'Ponchiot','506',17,23,25,4,5),(507,'Ponchien','507',17,1,16,6,5),(508,'Mastouffe','508',17,29,21,8,5),(509,'Chacripan','509',17,20,12,11,5),(510,'L├®opardus','510',17,30,4,8,5),(511,'Feuillajou','511',18,5,3,1,5),(512,'Feuiloutan','512',18,1,16,1,5),(513,'Flamajou','513',18,38,18,1,5),(514,'Flamoutan','514',18,28,20,1,5),(515,'Flotajou','515',18,58,25,1,5),(516,'Flotoutan','516',18,36,20,1,5),(517,'Munna','517',18,20,3,22,5),(518,'Mushana','518',18,1,8,9,5),(519,'Poichigeon','519',18,37,2,6,5),(520,'Colombeau','520',18,77,5,8,5),(521,'D├®flaisan','521',18,34,1,1,5),(522,'Z├®bibron','522',18,59,15,11,5),(523,'Z├®blitz','523',18,41,12,3,5),(524,'Nodulithe','524',18,29,13,5,5),(525,'G├®olithe','525',18,40,13,15,5),(526,'Gigalithe','526',18,1,5,9,5),(527,'Chovsourir','527',18,113,10,8,5),(528,'Rhinolove','528',18,5,6,15,5),(529,'Rototaupe','529',18,75,8,5,5),(530,'Minotaupe','530',18,8,24,15,5),(531,'Nanm├®ou├»e','531',18,59,16,14,5),(532,'Charpenti','532',18,8,17,8,5),(533,'Ouvrifier','533',18,10,25,3,5),(534,'B├®tochef','534',18,58,4,14,5),(535,'Tritonde','535',18,17,10,13,5),(536,'Batracn├®','536',18,59,21,13,5),(537,'Crapustule','537',18,38,3,13,5),(538,'Judokrak','538',18,41,7,4,5),(539,'Karacl├®e','539',18,38,3,4,5),(540,'Larveyette','540',18,83,5,7,5),(541,'Couverdure','541',19,40,19,7,5),(542,'Manternel','542',19,11,10,14,5),(543,'Venipatte','543',19,3,23,7,5),(544,'Scobolide','544',19,8,2,4,5),(545,'Brutapode','545',19,34,4,7,5),(546,'Doudouvet','546',19,29,21,4,5),(547,'Farfaduvet','547',19,58,14,4,5),(548,'Chlorobule','548',19,10,16,3,5),(549,'Fragilady','549',19,11,3,14,5),(550,'Bargantua','550',19,30,16,7,5),(551,'Masca├»man','551',19,59,15,8,5),(552,'Escroco','552',19,76,4,4,5),(553,'Crocorible','553',19,8,4,5,5),(554,'Darumarond','554',19,20,20,22,5),(555,'Darumacho','555',19,34,3,1,5),(556,'Maracachi','556',19,77,15,4,5),(557,'Crabicoque','557',19,40,24,4,5),(558,'Crabaraque','558',19,76,17,7,5),(559,'Baggiguane','559',19,8,13,4,5),(560,'Bagga├»d','560',19,34,2,9,5),(561,'Crypt├®ro','561',19,34,22,3,5),(562,'Tutafeh','562',19,37,19,2,5),(563,'Tutankafer','563',19,69,17,15,5),(564,'Carapagos','564',19,76,9,1,5),(565,'M├®gapagos','565',19,28,15,1,5),(566,'Ark├®apti','566',19,1,15,1,5),(567,'A├®ropt├®ryx','567',19,11,9,1,5),(568,'Miamiasme','568',19,40,23,5,5),(569,'Miasmax','569',19,59,15,6,5),(570,'Zorua','570',19,8,19,1,5),(571,'Zoroark','571',20,59,8,9,5),(572,'Chinchidou','572',20,40,8,6,5),(573,'Pashmilla','573',20,77,14,8,5),(574,'Scrutella','574',20,8,10,5,5),(575,'Mesm├®rella','575',20,69,17,15,5),(576,'Sid├®rella','576',20,29,9,9,5),(577,'Nucl├®os','577',20,40,24,8,5),(578,'M├®ios','578',20,41,10,3,5),(579,'Symbios','579',20,5,11,11,5),(580,'Couaneton','580',20,20,17,7,5),(581,'Lakm├®cygne','581',20,28,16,7,5),(582,'Sorb├®b├®','582',20,59,20,6,5),(583,'Sorboul','583',20,77,3,9,5),(584,'Sorbouboul','584',20,58,4,11,5),(585,'Vivaldaim','585',20,8,3,6,5),(586,'Haydaim','586',20,11,19,14,5),(587,'Emolga','587',20,36,11,3,5),(588,'Carabing','588',20,20,4,7,5),(589,'Lan├ºargot','589',20,30,8,8,5),(590,'Trompignon','590',20,20,14,9,5),(591,'Gaulet','591',20,36,13,3,5),(592,'Viskuse','592',20,29,22,13,5),(593,'Moyade','593',20,58,7,13,5),(594,'Mamanbo','594',20,1,5,13,5),(595,'Statitik','595',20,40,14,7,5),(596,'Mygavolt','596',20,5,10,7,5),(597,'Grindur','597',20,29,9,6,5),(598,'Noacier','598',20,36,21,3,5),(599,'Tic','599',20,37,25,1,5),(600,'Clic','600',20,69,23,11,5),(601,'Cliticlic','601',21,76,13,8,5),(602,'Anchwatt','602',21,29,4,11,5),(603,'Lamp├®roie','603',21,69,1,9,5),(604,'Ohmassacre','604',21,34,23,14,5),(605,'Lewsor','605',21,40,20,9,5),(606,'Neitram','606',21,28,11,3,5),(607,'Fun├®cire','607',21,77,20,8,5),(608,'M├®lancolux','608',21,58,6,5,5),(609,'Lugulabre','609',21,1,9,15,5),(610,'Coupenotte','610',21,5,22,5,5),(611,'Incisache','611',21,11,7,9,5),(612,'Tranchodon','612',21,1,18,11,5),(613,'Polarhume','613',21,75,18,11,5),(614,'Polagriffe','614',21,69,15,9,5),(615,'Hexagel','615',21,8,2,9,5),(616,'Escargaume','616',21,20,21,10,5),(617,'Limaspeed','617',21,36,15,3,5),(618,'Limonde','618',21,30,3,8,5),(619,'Kungfouine','619',21,41,19,3,5),(620,'Shaofouine','620',21,20,20,22,5),(621,'Drakkarmin','621',21,59,25,3,5),(622,'Gringolem','622',21,8,22,9,5),(623,'Golemastoc','623',21,76,10,8,5),(624,'Scalpion','624',21,52,22,9,5),(625,'Scalproie','625',21,5,11,5,5),(626,'Frison','626',21,1,8,5,5),(627,'Furaiglon','627',21,40,14,9,5),(628,'Gueriaigle','628',21,11,11,11,5),(629,'Vostourno','629',21,29,21,5,5),(630,'Vaututrice','630',21,28,10,11,5),(631,'Aflamanoir','631',22,30,17,4,5),(632,'Fermite','632',22,38,18,11,5),(633,'Solochi','633',22,77,12,3,5),(634,'Diamat','634',22,38,9,5,5),(635,'Trioxhydre','635',22,11,6,9,5),(636,'Pyronille','636',22,77,16,1,5),(637,'Pyrax','637',22,5,14,9,5),(638,'Cobaltium','638',22,33,22,10,5),(639,'Terrakium','639',22,29,18,15,5),(640,'Viridium','640',22,37,5,9,5),(641,'Bor├®as','641',22,20,2,22,5),(642,'Fulguris','642',22,99,17,9,5),(643,'Reshiram','643',22,1,3,14,5),(644,'Zekrom','644',22,99,25,9,5),(645,'D├®m├®t├®ros','645',22,20,17,22,5),(646,'Kyurem','646',22,8,15,15,5),(647,'Keldeo','647',22,124,4,10,5),(648,'Meloetta','648',22,125,10,10,5),(649,'Genesect','649',22,126,7,10,5),(650,'Marisson','650',22,12,23,1,6),(651,'Bogu├®risse','651',22,10,9,9,6),(652,'Blind├®pique','652',22,25,3,9,6),(653,'Feunnec','653',22,104,13,1,6),(654,'Roussil','654',22,52,16,1,6),(655,'Goupelin','655',22,56,10,1,6),(656,'Grenousse','656',22,70,25,1,6),(657,'Cro├óporal','657',22,99,18,7,6),(658,'Amphinobi','658',22,10,15,1,6),(659,'Sapereau','659',22,43,23,4,6),(660,'Excavarenne','660',22,48,14,4,6),(661,'Passerouge','661',23,70,5,9,6),(662,'Braisillon','662',23,48,10,11,6),(663,'Flambusard','663',23,56,13,1,6),(664,'L├®pidonille','664',23,12,6,1,6),(665,'P├®r├®grain','665',23,12,4,1,6),(666,'Prismillon','666',23,48,21,7,6),(667,'H├®lionceau','667',23,48,16,9,6),(668,'N├®m├®lios ÔÖé','668',23,56,7,5,6),(669,'N├®m├®lios ÔÖÇ','668',23,48,16,9,6),(670,'Flab├®b├®','669',23,103,6,9,6),(671,'Floette','670',23,48,25,8,6),(672,'Florges','671',23,56,13,9,6),(673,'Cabriolaine','672',23,70,4,6,6),(674,'Chevroum','673',23,25,18,15,6),(675,'Pandespi├¿gle','674',23,86,11,9,6),(676,'Pandarbare','675',23,43,22,9,6),(677,'Couafarel','676',23,25,11,8,6),(678,'Psystigri','677',23,70,10,4,6),(679,'Mistigrix','678',23,43,19,14,6),(680,'Monorpale','679',23,52,3,9,6),(681,'Dimocl├¿s','680',23,103,3,17,6),(682,'Exagide','681',23,10,22,11,6),(683,'Fluvetin','682',23,86,8,14,6),(684,'Cocotine','683',23,70,22,14,6),(685,'Sucroquin','684',23,96,17,9,6),(686,'Cupcanaille','685',23,25,20,14,6),(687,'S├®piatop','686',23,105,8,9,6),(688,'S├®piatroce','687',23,17,6,11,6),(689,'Opermine','688',23,91,6,9,6),(690,'Golgopathe','689',23,48,5,9,6),(691,'Venalgue','690',24,70,8,7,6),(692,'Kravarech','691',24,52,14,9,6),(693,'Flingouste','692',24,17,25,13,6),(694,'Gamblast','693',24,56,15,7,6),(695,'Galvaran','694',24,43,25,11,6),(696,'Iguolta','695',24,56,22,11,6),(697,'Ptyranidur','696',24,97,22,19,6),(698,'Rexillius','697',24,10,22,1,6),(699,'Amagara','698',24,97,16,1,6),(700,'Dragmara','699',24,25,8,1,6),(701,'Nymphali','700',24,17,16,9,6),(702,'Brutalibr├®','701',24,10,22,11,6),(703,'Dedenne','702',24,25,19,11,6),(704,'Strassie','703',24,105,2,9,6),(705,'Mucuscule','704',24,43,23,11,6),(706,'Colimucus','705',24,48,12,5,6),(707,'Muplodocus','706',24,52,1,9,6),(708,'Trousselin','707',24,97,18,1,6),(709,'Broc├®l├┤me','708',24,70,11,5,6),(710,'Dess├®liande','709',24,25,11,15,6),(711,'Pitrouille','710',24,96,20,4,6),(712,'Banshitrouye','711',24,43,13,15,6),(713,'Grela├ºon','712',24,43,3,8,6),(714,'S├®racrawl','713',24,70,9,9,6),(715,'Sonistrelle','714',24,100,11,15,6),(716,'Bruyverne','715',24,10,9,1,6),(717,'Xerneas','716',24,56,1,11,6),(718,'Yveltal','717',24,52,15,9,6),(719,'Zygarde','718',24,56,11,15,6),(720,'Diancie','719',24,127,21,10,6),(721,'Hoopa','720',25,128,5,10,6),(722,'Volcanion','721',25,129,5,10,6),(723,'Brindibou','722',25,97,11,1,7),(724,'├ëffl├¿che','723',25,84,2,1,7),(725,'Arch├®duc','724',25,112,18,1,7),(726,'Flamiaou','725',25,86,11,1,7),(727,'Matoufeu','726',25,95,3,1,7),(728,'F├®linferno','727',25,99,11,1,7),(729,'Otaquin','728',25,92,16,1,7),(730,'Otarlette','729',25,92,5,1,7),(731,'Oratoria','730',25,104,8,1,7),(732,'Picassaut','731',25,99,17,1,7),(733,'Piclairon','732',25,92,9,9,7),(734,'Bazoucan','733',25,112,12,1,7),(735,'Manglouton','734',25,100,17,6,7),(736,'Argouste','735',25,104,21,9,7),(737,'Larvibule','736',25,95,16,16,7),(738,'Chrysapile','737',25,100,1,6,7),(739,'Lucanon','738',25,112,13,23,7),(740,'Crabagarre','739',25,104,22,17,7),(741,'Crabominable','740',25,100,22,17,7),(742,'Plumeline','741',25,92,16,15,7),(743,'Plumeline','741',25,84,25,15,7),(744,'Plumeline','741',25,104,4,9,7),(745,'Plumeline','741',25,103,13,9,7),(746,'Bombydou','742',25,105,22,14,7),(747,'Rubombelle','743',25,98,25,9,7),(748,'Rocabot','744',25,113,22,17,7),(749,'Lougaroc Ôÿ╝','745',25,97,12,9,7),(750,'Lougaroc Ôÿ¥','745',25,84,11,19,7),(751,'Lougaroc Ôÿ╝/Ôÿ¥','745',26,99,11,16,7),(752,'Froussardine','746',26,84,24,13,7),(753,'Vorast├®rie','747',26,86,15,18,7),(754,'Pr├®dast├®rie','748',26,112,22,7,7),(755,'Tiboudet','749',26,105,3,16,7),(756,'Bourrinos','750',26,103,3,16,7),(757,'Araqua','751',26,92,3,18,7),(758,'Tarenbulle','752',26,95,3,18,7),(759,'Mimantis','753',26,83,1,20,7),(760,'Floramantis','754',26,112,24,6,7),(761,'Spododo','755',26,92,8,11,7),(762,'Lampignon','756',26,103,21,21,7),(763,'Tritox','757',26,100,5,9,7),(764,'Malamandre','758',26,95,19,16,7),(765,'Nounourson','759',26,86,21,20,7),(766,'Chelours','760',26,84,22,20,7),(767,'Croquine','761',26,96,25,20,7),(768,'Candine','762',26,86,22,20,7),(769,'Sucreine','763',26,83,22,20,7),(770,'Guerilande','764',26,100,5,6,7),(771,'Gouroutan','765',26,112,4,9,7),(772,'Quartermac','766',26,112,22,16,7),(773,'Sovkipou','767',26,103,15,18,7),(774,'Sarmoura├»','768',26,85,22,18,7),(775,'Bacabouh','769',26,92,16,17,7),(776,'Tr├®passable','770',26,105,16,17,7),(777,'Concombaffe','771',26,105,7,13,7),(778,'Type:0','772',26,84,21,1,7),(779,'Silvalli├®','773',26,100,22,1,7),(780,'M├®t├®no','774',26,95,11,17,7),(781,'Dodoala','775',27,104,10,9,7),(782,'Boumata','776',27,98,18,23,7),(783,'Togedemaru','777',27,98,11,16,7),(784,'Mimiqui','778',27,112,11,19,7),(785,'Denticrisse','779',27,84,11,18,7),(786,'Dra├»eul','780',27,98,5,16,7),(787,'Sinistrail','781',27,95,22,18,7),(788,'B├®b├®caille','782',27,86,14,17,7),(789,'├ëca├»d','783',27,92,3,17,7),(790,'├ëka├»ser','784',27,85,22,17,7),(791,'Tokorico','785',27,95,16,15,7),(792,'Tokopiyon','786',27,83,16,9,7),(793,'Tokotoro','787',27,100,2,3,7),(794,'Tokopisco','788',27,84,6,15,7),(795,'Cosmog','789',27,83,10,1,7),(796,'Cosmovum','790',27,99,17,1,7),(797,'Solgaleo','791',27,116,23,9,7),(798,'Lunala','792',27,105,22,9,7),(799,'Z├®ro├»d','793',27,84,22,23,7),(800,'Mouscoto','794',27,92,18,23,7),(801,'Cancrelove','795',27,112,22,23,7),(802,'C├óblif├¿re','796',27,92,21,23,7),(803,'Bamboiselle','797',27,95,12,23,7),(804,'Katagami','798',27,92,22,23,7),(805,'Engloutyran','799',27,103,19,23,7),(806,'Necrozma','800',27,104,22,9,7),(807,'Magearna','801',27,104,25,10,7),(808,'Marshadow','802',27,130,17,10,7),(809,'V├®mini','803',27,83,17,1,7),(810,'Mandrillon','804',27,105,5,23,7),(811,'Ama-Ama','805',28,99,22,23,7),(812,'Pierroteknik','806',28,105,4,23,7),(813,'Zeraora','807',28,131,11,10,7),(814,'Meltan','808',28,81,22,3,7),(815,'Melmetal','809',28,132,3,10,7),(816,'Ouistempo','810',28,86,3,1,8),(817,'Badabouin','811',28,98,12,1,8),(818,'Gorythmic','812',28,90,20,1,8),(819,'Flambino','813',28,87,16,1,8),(820,'Lapyro','814',28,113,15,1,8),(821,'Pyrobut','815',28,116,11,1,8),(822,'Larm├®l├®on','816',28,101,15,1,8),(823,'Arrozard','817',28,91,7,1,8),(824,'L├®zargus','818',28,82,25,1,8),(825,'Rongourmand','819',28,86,6,21,8),(826,'Rongrigou','820',28,94,11,1,8),(827,'Minisange','821',28,94,23,1,8),(828,'Bleuseille','822',28,85,25,9,8),(829,'Corvaillus','823',28,102,13,17,8),(830,'Larvadar','824',28,85,16,9,8),(831,'Col├®od├┤me','825',28,90,22,9,8),(832,'Astronelle','826',28,94,14,9,8),(833,'Goupilou','827',28,102,25,19,8),(834,'Roublenard','828',28,86,19,19,8),(835,'Tournicoton','829',28,87,17,9,8),(836,'Blancoton','830',28,101,5,9,8),(837,'Moumouton','831',28,94,11,1,8),(838,'Moumouflon','832',28,101,5,9,8),(839,'Kh├®locrok','833',28,90,22,18,8),(840,'Torgamord','834',28,94,7,18,8),(841,'Voltoutou','835',29,101,18,9,8),(842,'Fulgudog','836',29,90,18,9,8),(843,'Charbi','837',29,85,5,17,8),(844,'Wagomine','838',29,109,5,17,8),(845,'Monthracite','839',29,94,5,17,8),(846,'Verpom','840',29,91,23,21,8),(847,'Pomdrapi','841',29,109,22,21,8),(848,'Dratatin','842',29,94,15,21,8),(849,'Dunaja','843',29,87,6,9,8),(850,'Dunaconda','844',29,102,4,9,8),(851,'Nigosier','845',29,87,5,9,8),(852,'Embrochet','846',29,82,11,18,8),(853,'Hastacuda','847',29,116,11,18,8),(854,'Toxizap','848',29,90,8,16,8),(855,'Salarsen','849',29,97,8,16,8),(856,'Grillepattes','850',29,94,10,16,8),(857,'Scolocendre','851',29,90,22,16,8),(858,'Poulpaf','852',29,85,22,16,8),(859,'Krakos','853',29,116,22,18,8),(860,'Th├®ffroi','854',29,86,17,9,8),(861,'Polth├®geist','855',29,87,12,9,8),(862,'Bibichut','856',29,94,1,22,8),(863,'Chapotus','857',29,91,25,22,8),(864,'Sorcilence','858',29,87,4,22,8),(865,'Grimalin','859',29,101,3,19,8),(866,'Fourbelin','860',29,90,3,19,8),(867,'Angoliath','861',29,82,3,19,8),(868,'Ixon','862',29,109,11,19,8),(869,'Berserkatt','863',29,91,10,9,8),(870,'Coray├┤me','864',29,82,11,9,8),(871,'Palarticho','865',30,116,24,2,8),(872,'M. Glaquette','866',30,87,10,10,8),(873,'Tut├®t├®kri','867',30,102,13,9,8),(874,'Cr├¿my','868',30,87,4,9,8),(875,'Charmilly','869',30,101,14,9,8),(876,'Hexadron','870',30,82,11,16,8),(877,'Wattapik','871',30,102,10,9,8),(878,'Frissonille','872',30,101,25,19,8),(879,'Beldeneige','873',30,90,25,19,8),(880,'Dolman','874',30,116,22,17,8),(881,'Bekagla├ºon','875',30,109,19,9,8),(882,'Wimessir','876',30,101,9,9,8),(883,'Morpeko','877',30,109,22,19,8),(884,'Charibari','878',30,109,22,17,8),(885,'Pachyradjah','879',30,90,22,17,8),(886,'Galvagon','880',30,102,14,1,8),(887,'Galvagla','881',30,85,17,1,8),(888,'Hydragon','882',30,82,3,1,8),(889,'Hydragla','883',30,109,9,1,8),(890,'Duralugon','884',30,116,25,17,8),(891,'Fantyrm','885',30,90,18,17,8),(892,'Dispareptil','886',30,109,12,9,8),(893,'Lanssorien','887',30,116,18,17,8),(894,'Zacian','888',30,102,23,9,8),(895,'Zamazenta','889',30,82,18,3,8),(896,'├ëthernatos','890',30,85,10,9,8),(897,'Wushours','891',30,109,23,1,8),(898,'Shifours','892',30,102,11,1,8),(899,'Shifours','892',30,116,22,1,8),(900,'Zarude','893',30,133,14,10,8),(901,'Regieleki','894',31,116,8,9,8),(902,'Regidrago','895',31,109,22,9,8),(903,'Blizzeval','896',31,102,5,9,8),(904,'Spectreval','897',31,105,24,9,8),(905,'Sylveroy','898',31,105,3,9,8),(906,'Cerbyllin','899',31,89,16,17,9),(907,'Hach├®cateur','900',31,89,11,17,9),(908,'Ursaking','901',31,89,14,17,9),(909,'Paragruel','902',31,89,1,3,9),(910,'Farfurex','903',31,89,23,17,9),(911,'Qwilpik','904',31,89,16,17,9),(912,'Amov├®nus','905',31,89,22,3,9),(913,'Poussacha','906',31,117,18,1,10),(914,'Matourgeon','907',31,93,2,1,10),(915,'Miascarade','908',31,111,9,1,10),(916,'Chochodile','909',31,110,19,1,10),(917,'Crocogril','910',31,106,10,1,10),(918,'Fl├ómigator','911',31,114,21,1,10),(919,'Coiffeton','912',31,107,25,1,10),(920,'Canarbello','913',31,88,25,1,10),(921,'Palmaval','914',31,108,16,1,10),(922,'Gourmelet','915',31,93,23,9,10),(923,'Fragroin','916',31,111,6,9,10),(924,'Tissemboule','917',31,93,16,9,10),(925,'Filentrappe','918',31,111,11,9,10),(926,'Lilliterelle','919',31,110,17,9,10),(927,'Gambex','920',31,108,16,9,10),(928,'Pohm','921',31,117,5,9,10),(929,'Pohmotte','922',31,106,22,9,10),(930,'Pohmarmotte','923',31,88,19,16,10),(931,'Compagnol','924',32,110,7,9,10),(932,'Famignol','925',32,114,21,9,10),(933,'P├ótachiot','926',32,93,5,9,10),(934,'Briochien','927',32,111,22,9,10),(935,'Olivini','928',32,111,19,9,10),(936,'Olivado','929',32,117,11,9,10),(937,'Arboliva','930',32,93,18,9,10),(938,'Tapato├¿s','931',32,115,9,9,10),(939,'Selutin','932',32,115,25,9,10),(940,'Amassel','933',32,117,1,9,10),(941,'Gigansel','934',32,108,17,9,10),(942,'Charbambin','935',32,115,25,16,10),(943,'Carmadura','936',32,108,25,16,10),(944,'Malvalame','937',32,88,9,19,10),(945,'T├¬tampoule','938',32,115,18,9,10),(946,'Ampibidou','939',32,93,9,9,10),(947,'Zap├®trel','940',32,111,4,9,10),(948,'Fulgulairo','941',32,114,20,5,10),(949,'Grondogue','942',32,115,20,9,10),(950,'Dogrino','943',32,93,23,9,10),(951,'Gribougraine','944',32,93,15,9,10),(952,'Tag-Tag','945',32,111,19,9,10),(953,'Virovent','946',32,110,18,9,10),(954,'Virevorreur','947',32,117,20,9,10),(955,'Terracool','948',32,115,22,9,10),(956,'Terracruel','949',32,110,24,9,10),(957,'Craparoi','950',32,88,11,17,10),(958,'Pimito','951',32,115,24,21,10),(959,'Scovilain','952',32,93,4,21,10),(960,'L├®boul├®rou','953',32,110,11,20,10),(961,'B├®rasca','954',33,115,6,20,10),(962,'Flotillon','955',33,117,7,9,10),(963,'Cl├®opsytra','956',33,107,22,9,10),(964,'Forgerette','957',33,110,19,22,10),(965,'Forgella','958',33,117,16,22,10),(966,'Forgelina','959',33,114,1,22,10),(967,'Taupikeau','960',33,110,5,7,10),(968,'Triopikeau','961',33,117,15,7,10),(969,'Lestombaile','962',33,117,20,19,10),(970,'Dofin','963',33,115,14,9,10),(971,'Superdofin','964',33,88,4,18,10),(972,'Vrombi','965',33,110,22,17,10),(973,'Vrombotor','966',33,88,10,17,10),(974,'Motorizard','967',33,115,25,9,10),(975,'Ferdeter','968',33,117,14,16,10),(976,'Germ├®clat','969',33,117,3,9,10),(977,'Flor├®clat','970',33,107,8,9,10),(978,'Toutombe','971',33,107,16,9,10),(979,'Tomberro','972',33,110,16,9,10),(980,'Flamenroule','973',33,110,1,9,10),(981,'Pi├®tac├®','974',33,111,22,17,10),(982,'Balbal├¿ze','975',33,107,16,9,10),(983,'D├®lestin','976',33,115,16,7,10),(984,'Oyacata','977',33,117,4,18,10),(985,'Nigirigon','978',33,115,5,9,10),(986,'Courrousinge','979',33,114,13,9,10),(987,'Terraiste','980',33,111,15,17,10),(988,'Farigiraf','981',33,110,6,9,10),(989,'Deusolourdo','982',33,97,17,5,10),(990,'Scalpereur','983',33,102,22,17,10),(991,'Fort-Ivoire','984',34,108,9,9,10),(992,'Hurle-Queue','985',34,108,24,9,10),(993,'Fongus-Furie','986',34,108,25,9,10),(994,'Flotte-M├¿che','987',34,108,1,9,10),(995,'Rampe-Ailes','988',34,108,11,9,10),(996,'Pelage-Sabl├®','989',34,108,7,9,10),(997,'Roue-de-Fer','990',34,106,6,9,10),(998,'Hotte-de-Fer','991',34,88,21,9,10),(999,'Paume-de-Fer','992',34,106,4,9,10),(1000,'T├¬tes-de-Fer','993',34,88,7,9,10),(1001,'Mite-de-Fer','994',34,106,12,9,10),(1002,'Epine-de-Fer','995',34,106,1,9,10),(1003,'Frigodo','996',34,111,9,17,10),(1004,'Cryodo','997',34,107,4,9,10),(1005,'Glaivodo','998',34,106,11,17,10),(1006,'Mordudor','999',34,93,13,9,10),(1007,'Gromago','1000',34,108,13,9,10),(1008,'Chongjian','1001',34,114,8,9,10),(1009,'Baojian','1002',34,108,6,9,10),(1010,'Dinglu','1003',34,106,12,5,10),(1011,'Yuyu','1004',34,88,18,9,10),(1012,'Rugit-Lune','1005',34,114,10,9,10),(1013,'Garde-de-Fer','1006',34,106,17,9,10),(1014,'Koraidon','1007',34,114,22,9,10),(1015,'Miraidon','1008',34,88,16,15,10),(1016,'Serpente-Eau','1009',34,114,13,9,10),(1017,'Vert-de-Fer','1010',34,114,5,9,10),(1018,'Pomdramour','1011',34,107,7,9,10),(1019,'Poltchageist','1012',34,114,13,9,10),(1020,'Th├®ffroyable','1013',34,106,19,9,10),(1021,'F├®licanis','1014',35,106,2,9,10),(1022,'Fortusimia','1015',35,114,2,9,10),(1023,'Favianos','1016',35,107,22,9,10),(1024,'Ogerpon','1017',35,106,24,9,10),(1025,'Pondralugon','1018',35,102,25,17,10),(1026,'Pomdorochi','1019',35,97,4,21,10),(1027,'Feu-Per├ºant','1020',35,107,22,9,10),(1028,'Ire-Foudre','1021',35,107,25,9,10),(1029,'Roc-de-Fer','1022',35,106,17,9,10),(1030,'Chef-de-Fer','1023',35,106,22,9,10),(1031,'Terapagos','1024',35,107,10,9,10),(1032,'P├¬chaminus','1025',35,107,25,9,10);
/*!40000 ALTER TABLE `pokedex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon_shiny`
--

DROP TABLE IF EXISTS `pokemon_shiny`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_shiny` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iv_manquant` varchar(255) NOT NULL,
  `nom_pokemon` varchar(255) NOT NULL,
  `num_dex` varchar(255) NOT NULL,
  `position` int NOT NULL,
  `attaque1` bigint DEFAULT NULL,
  `attaque2` bigint DEFAULT NULL,
  `attaque3` bigint DEFAULT NULL,
  `attaque4` bigint DEFAULT NULL,
  `id_boite` int DEFAULT NULL,
  `id_dresseur` int NOT NULL,
  `id_nature` int NOT NULL,
  `id_pokeball` int NOT NULL,
  `id_region` bigint DEFAULT NULL,
  `id_sexe` int DEFAULT NULL,
  `type1` int NOT NULL,
  `type2` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK39niijdqlkvvnoj4jyynwwaf7` (`attaque1`),
  KEY `FKhvcskr8a2wydnoa798d5fas69` (`attaque2`),
  KEY `FK9yclo8tq2yxdshxuj7xcqv77` (`attaque3`),
  KEY `FK404yly1hjakeluqftknw8kbpv` (`attaque4`),
  KEY `FKsddi0d8ai33pswsvisu3bh9v5` (`id_boite`),
  KEY `FKo3ogafkn786pbjwv1p63yuked` (`id_dresseur`),
  KEY `FK59r3ceyp8l1lr71os5xyooo3g` (`id_nature`),
  KEY `FKov1i9pqaq1x2kbfbgquuoq506` (`id_pokeball`),
  KEY `FK41ta6ehscm9pir2hbxwto8ij2` (`id_region`),
  KEY `FK7p8pme21weql6waov9ym17qwc` (`id_sexe`),
  KEY `FKrhp16bpxd5c3goxlogha75w08` (`type1`),
  KEY `FK17dlfxwf8ddiabujdqv39g1e0` (`type2`),
  CONSTRAINT `FK17dlfxwf8ddiabujdqv39g1e0` FOREIGN KEY (`type2`) REFERENCES `type` (`id`),
  CONSTRAINT `FK39niijdqlkvvnoj4jyynwwaf7` FOREIGN KEY (`attaque1`) REFERENCES `attaques` (`id`),
  CONSTRAINT `FK404yly1hjakeluqftknw8kbpv` FOREIGN KEY (`attaque4`) REFERENCES `attaques` (`id`),
  CONSTRAINT `FK41ta6ehscm9pir2hbxwto8ij2` FOREIGN KEY (`id_region`) REFERENCES `regions` (`id`),
  CONSTRAINT `FK59r3ceyp8l1lr71os5xyooo3g` FOREIGN KEY (`id_nature`) REFERENCES `natures` (`id_nature`),
  CONSTRAINT `FK7p8pme21weql6waov9ym17qwc` FOREIGN KEY (`id_sexe`) REFERENCES `sexe` (`id`),
  CONSTRAINT `FK9yclo8tq2yxdshxuj7xcqv77` FOREIGN KEY (`attaque3`) REFERENCES `attaques` (`id`),
  CONSTRAINT `FKhvcskr8a2wydnoa798d5fas69` FOREIGN KEY (`attaque2`) REFERENCES `attaques` (`id`),
  CONSTRAINT `FKo3ogafkn786pbjwv1p63yuked` FOREIGN KEY (`id_dresseur`) REFERENCES `dresseurs` (`id`),
  CONSTRAINT `FKov1i9pqaq1x2kbfbgquuoq506` FOREIGN KEY (`id_pokeball`) REFERENCES `pokeballs` (`id_pokeball`),
  CONSTRAINT `FKrhp16bpxd5c3goxlogha75w08` FOREIGN KEY (`type1`) REFERENCES `type` (`id`),
  CONSTRAINT `FKsddi0d8ai33pswsvisu3bh9v5` FOREIGN KEY (`id_boite`) REFERENCES `boites` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_shiny`
--

LOCK TABLES `pokemon_shiny` WRITE;
/*!40000 ALTER TABLE `pokemon_shiny` DISABLE KEYS */;
INSERT INTO `pokemon_shiny` VALUES (1,'5IV/Att','Florizarre','003',6,70,30,71,72,2,102,16,21,1,1,11,12),(2,'5IV/PV','Dracaufeu','006',5,22,16,2,41,2,99,22,17,1,1,7,18),(3,'5IV/Att','Roucarnage','018',10,62,100,101,80,3,70,25,16,1,2,10,18),(4,'5IV/D├®f','Nidoking','034',18,67,2,43,24,2,105,22,17,1,1,12,15),(5,'5IV/ASp','Arcanin','059',7,15,22,10,23,1,52,22,1,1,1,7,NULL),(6,'5IV/ASp','Alakazam','065',13,37,38,31,30,1,103,25,16,1,1,13,NULL),(7,'5IV/DSp','Crustabri','091',29,113,114,115,116,3,83,22,17,1,1,4,8),(8,'5IV/D├®f','Ectoplasma','094',25,70,5,37,40,2,52,16,15,1,2,16,12),(9,'5IV/DSp','Kangourex','115',4,28,94,2,25,3,99,22,17,1,2,10,NULL),(10,'5IV/PV','Scarabrute','127',23,11,2,48,254,3,100,22,17,1,2,9,NULL),(11,'5IV/PV','Tauros','128',9,191,16,2,99,3,105,11,16,1,1,10,NULL),(12,'5IV/DSp','L├®viator','130',19,25,2,76,41,2,48,22,13,1,1,4,18),(13,'5IV/DSp','Aquali','134',19,8,61,37,56,1,103,16,18,1,1,4,NULL),(14,'5IV/PV','Voltali','135',20,37,52,53,54,1,48,25,1,1,1,5,NULL),(15,'5IV/ASp','Pyroli','136',21,64,22,58,55,1,83,3,16,1,1,7,NULL),(16,'5IV/PV','Pt├®ra','142',5,92,60,2,24,3,103,11,22,1,1,14,18),(17,'5IV/DSp','Typhlosion','157',11,58,102,31,36,3,52,16,1,2,1,7,NULL),(18,'5IV/Vit','Aligatueur','160',12,3,2,76,103,3,52,22,1,2,1,4,NULL),(19,'5IV/ASp','Nostenfer','169',27,89,90,91,1,2,48,22,16,2,2,12,18),(20,'5IV/DSp','Pharamp','181',29,32,52,31,54,2,43,5,19,2,1,5,NULL),(21,'5IV/Vit','Mentali','196',22,37,38,39,40,1,70,16,1,2,1,13,NULL),(22,'5IV/Vit','Noctali','197',27,44,45,46,47,1,107,19,19,2,1,17,NULL),(23,'5IV/PV','Steelix','208',30,24,2,93,55,2,70,3,17,2,2,1,15),(24,'5IV/PV','Cizayox','212',23,57,63,48,10,2,102,22,16,2,2,9,1),(25,'5IV/ASp','Scarhino','214',26,24,2,43,15,1,52,22,9,2,1,9,2),(26,'5IV/ASp','Airmure','227',26,10,110,111,62,3,99,22,17,2,1,1,18),(27,'5IV/Att','D├®molosse','229',15,58,5,37,36,1,52,16,9,2,1,17,7),(28,'5IV/Att','Hyporoi','230',17,8,6,61,32,1,43,16,18,2,2,4,3),(29,'5IV/DSp','Tyranocif','248',24,41,2,25,24,2,25,3,9,2,1,14,17),(30,'5IV/Att','Jungko','254',10,30,31,32,33,1,105,18,17,3,1,11,NULL),(31,'5IV/Vit','Bras├®gali','257',11,34,2,22,15,1,105,22,16,3,2,7,2),(32,'5IV/DSp','Laggron','260',9,3,2,76,24,2,52,22,1,3,1,4,15),(33,'5IV/Att','Gardevoir','282',4,37,38,39,40,2,10,16,9,3,2,13,6),(34,'5IV/Vit','Mysdibule','303',21,108,85,68,10,3,70,22,20,3,2,1,6),(35,'5IV/PV','Galeking','306',22,10,2,87,73,2,52,22,1,3,1,1,14),(36,'5IV/Att','Elecsprint','310',11,53,52,81,36,2,103,25,22,3,1,5,NULL),(37,'5IV/PV','Sharpedo','319',14,92,76,25,104,3,100,22,18,3,1,4,17),(38,'5IV/PV','Cam├®rupt','323',15,24,102,35,36,3,48,5,17,3,1,7,15),(39,'5IV/ASp','Lib├®gon','330',23,41,2,28,17,1,105,22,17,3,2,15,3),(40,'5IV/Vit','Altaria','334',16,51,60,32,65,3,43,5,22,3,1,3,18),(41,'5IV/D├®f','Vacilys','346',16,83,30,35,84,2,103,5,22,3,1,14,11),(42,'5IV/ASp','Armaldo','348',17,24,2,48,11,2,105,22,17,3,1,14,9),(43,'5IV/Att','Milobellus','350',24,8,6,61,56,1,70,16,13,3,1,4,NULL),(44,'5IV/D├®f','Absol','359',20,43,85,68,1,2,70,22,19,3,2,17,NULL),(45,'5IV/DSp','Oniglali','362',28,92,25,10,74,2,48,18,9,3,2,8,NULL),(46,'5IV/DSp','M├®talosse','376',1,1,2,3,4,1,103,22,17,3,3,1,13),(47,'5IV/DSp','Drattak','373',1,41,2,12,17,2,95,11,16,3,1,3,18),(48,'5IV/ASp','Torterra','389',8,24,2,25,26,1,52,3,1,4,1,11,15),(49,'5IV/Vit','Simiabraz','392',9,27,28,29,14,1,106,22,16,4,1,7,2),(50,'5IV/Vit','Pingol├®on','395',15,82,61,8,18,2,100,16,17,4,1,4,1),(51,'5IV/D├®f','Luxray','405',19,106,107,92,64,3,83,18,16,4,1,5,NULL),(52,'5IV/PV','Lockpin','428',28,112,28,29,3,3,83,22,16,4,1,10,NULL),(53,'5IV/ASp','Carchacrok','445',5,10,16,2,17,1,103,11,17,4,1,3,15),(54,'6IV Parfait','Lucario','448',14,3,2,57,15,1,10,22,9,4,1,2,1),(55,'5IV/PV','Drascore','452',6,67,2,25,89,3,95,22,9,4,1,12,17),(56,'5IV/DSp','├ëlekable','466',21,3,28,29,86,2,116,11,16,4,1,5,NULL),(57,'5IV/DSp','Phyllali','470',28,26,48,49,55,1,92,22,16,4,1,11,NULL),(58,'5IV/Vit','Givrali','471',29,50,42,37,8,1,103,16,18,4,1,8,NULL),(59,'5IV/PV','Scorvol','472',18,62,2,63,24,1,103,22,17,4,1,15,18),(60,'6IV Parfait','Gallame','475',4,1,3,14,15,1,52,22,9,4,1,13,2),(61,'5IV/Att','Majaspic','497',13,72,30,32,33,2,25,25,1,5,1,11,NULL),(62,'5IV/D├®f','Minotaupe','530',17,99,2,10,11,3,83,22,22,5,1,15,1),(63,'5IV/PV','Crocorible','553',25,25,16,2,24,1,102,11,16,5,1,15,17),(64,'5IV/PV','Zoroark','571',30,5,117,31,36,3,99,25,19,5,1,17,NULL),(65,'5IV/Att','Sid├®rella','576',20,39,38,52,37,3,83,16,17,5,1,13,NULL),(66,'5IV/D├®f','Lugulabre','609',13,30,38,37,36,3,100,16,19,5,1,16,7),(67,'5IV/PV','Tranchodon','612',12,67,16,2,41,2,84,22,16,5,1,3,NULL),(68,'5IV/ASp','Drakkarmin','621',3,7,2,28,17,3,99,22,17,5,1,3,NULL),(69,'5IV/D├®f','Scalproie','625',3,24,68,10,69,2,52,22,9,5,2,17,1),(70,'5IV/Vit','Trioxhydre','635',12,21,5,35,36,1,48,16,9,5,1,17,3),(71,'6IV Parfait','Goupelin','655',14,37,38,39,36,2,43,16,1,6,1,7,13),(72,'6IV Parfait','Amphinobi','658',2,5,6,7,8,1,52,18,7,6,1,4,17),(73,'5IV/DSp','Flambusard','663',22,63,90,22,62,3,48,11,8,6,1,7,18),(74,'5IV/Att','N├®m├®lios ÔÖé','668',1,58,5,51,36,3,103,16,9,6,1,7,10),(75,'6IV Parfait','N├®m├®lios ÔÖÇ','668',2,58,5,51,36,3,48,16,9,6,2,7,10),(76,'5IV/D├®f','Florges','671',24,40,38,30,65,3,43,16,8,6,2,6,NULL),(77,'5IV/ASp','Exagide','681',3,9,10,11,13,1,99,3,17,6,1,1,16),(78,'5IV/Att','Gamblast','693',25,32,6,109,8,3,102,16,18,6,2,4,NULL),(79,'5IV/DSp','Iguolta','695',27,51,6,52,54,3,43,25,11,6,1,5,10),(80,'5IV/PV','Rexillius','697',7,17,16,2,73,2,52,22,19,6,2,14,3),(81,'5IV/PV','Dragmara','699',8,74,35,53,75,2,52,16,1,6,2,14,8),(82,'5IV/DSp','Nymphali','700',30,51,39,37,65,1,52,16,1,6,1,6,NULL),(83,'5IV/D├®f','Brutalibr├®','701',16,59,60,29,14,1,102,11,16,6,1,2,18),(84,'5IV/PV','Bruyverne','715',18,105,32,80,36,3,43,25,15,6,2,18,3),(85,'5IV/D├®f','Gu├®riaigle','628',10,77,78,79,80,2,108,16,23,9,1,13,18),(86,'5IV/Vit','Muplodocus','706',26,88,52,8,21,2,116,16,17,9,2,1,3),(87,'5IV/DSp','Ursaking','901',7,95,96,14,97,3,108,22,19,9,1,15,10),(88,'5IV/DSp','Arch├®duc','724',4,49,68,63,120,4,112,22,23,7,1,11,16),(89,'5IV/PV','F├®linferno','727',5,121,2,22,122,4,102,11,1,7,2,7,17),(90,'5IV/D├®f','Oratoria','730',6,123,37,40,65,4,92,16,1,7,1,4,6),(91,'5IV/Vit','Bazoucan','733',23,140,111,63,125,4,100,22,16,7,2,10,18),(92,'5IV/Att','Lucanon','738',11,18,130,52,54,4,92,16,16,7,1,9,5),(93,'5IV/Vit','Crabominable','740',24,15,2,10,141,4,100,22,17,7,2,2,8),(94,'5IV/PV','Lougaroc Ôÿ╝','745',7,24,124,25,84,4,112,22,17,7,1,14,NULL),(95,'5IV/D├®f','Lougaroc Ôÿ¥','745',8,24,25,99,125,4,84,11,19,7,1,14,NULL),(96,'5IV/ASp','Lougaroc Ôÿ╝/Ôÿ¥','745',9,10,124,126,24,4,99,11,16,7,1,14,NULL),(97,'5IV/DSp','Pr├®dast├®rie','748',10,127,128,129,116,4,112,21,18,7,1,12,4),(98,'5IV/DSp','Bourrinos','750',21,15,2,87,97,4,103,3,16,7,1,15,NULL),(99,'5IV/D├®f','Tarenbulle','752',18,67,25,122,116,4,92,3,18,7,2,4,9),(100,'6IV Max','Malamandre','758',2,83,46,32,36,4,84,25,17,7,2,12,7),(101,'5IV/D├®f','Chelours','760',15,136,2,3,137,4,84,22,20,7,1,10,2),(102,'5IV/PV','Sucreine','763',26,112,85,63,144,4,83,22,20,7,2,11,NULL),(103,'5IV/PV','Gouroutan','765',20,37,38,52,139,4,112,5,20,7,2,10,13),(104,'5IV/D├®f','Quartermac','766',19,10,2,63,15,4,112,22,16,7,1,2,NULL),(105,'5IV/ASp','Sarmura├»','768',13,116,133,122,134,4,95,22,18,7,1,9,4),(106,'5IV/DSp','Tr├®passable','770',16,147,37,35,72,4,99,16,17,7,2,16,15),(107,'6IV Parfait','M├®t├®no','774',27,114,2,145,24,4,112,11,17,7,3,14,18),(108,'5IV/D├®f','Boumata','776',14,21,135,18,36,4,83,5,17,7,1,7,3),(109,'5IV/D├®f','Togedemaru','777',25,10,63,142,143,4,99,11,16,7,2,5,1),(110,'5IV/ASp','Mimiqui','778',3,119,85,11,9,4,112,11,19,7,2,16,6),(111,'5IV/DSp','Denticrisse','779',22,92,76,25,104,4,84,11,18,7,2,4,13),(112,'5IV/Att','Dra├»eul','780',17,21,51,80,36,4,83,5,16,7,2,10,3),(113,'5IV/DSp','Sinistrail','781',12,131,2,132,119,4,95,22,18,7,3,16,11),(114,'5IV/DSp','├ëka├»ser','784',1,14,2,118,41,4,92,3,17,7,1,3,2),(115,'5IV/Att','Raichu Ôÿ╝/Ôÿ¥','026',28,31,38,52,54,4,99,25,16,7,2,5,13),(116,'5IV/D├®f','Feunard Ôÿ╝/Ôÿ¥','038',30,74,8,139,65,4,99,25,19,7,2,8,6),(117,'5IV/PV','Ossatueur Ôÿ╝/Ôÿ¥','105',29,22,45,2,146,4,84,22,19,7,2,7,16),(118,'6IV Max','Z├®ro├»d','793',14,84,52,83,196,8,83,18,23,7,3,14,12),(119,'6IV Max','Mouscoto','794',15,67,122,3,14,8,83,8,23,7,3,9,2),(120,'6IV Max','Cancrelove','795',16,67,63,8,15,8,99,9,23,7,3,9,2),(121,'6IV Max','C├óblif├¿re','796',17,54,52,30,40,8,99,20,23,7,3,5,NULL),(122,'6IV Max','Bamboiselle','797',18,247,45,87,36,8,99,21,9,7,3,1,18),(123,'6IV Max','Katagami','798',19,49,248,223,69,8,83,16,9,7,3,11,1),(124,'6IV Max','Engloutyran','799',20,58,25,87,21,8,99,5,23,7,3,17,3),(125,'6IV Max','V├®mini','803',21,67,46,170,249,8,104,25,1,7,3,12,NULL),(126,'6IV Max','Mandrillon','804',22,58,83,170,21,8,99,25,1,7,3,12,3),(127,'6IV Max','Ama-Ama','805',23,24,2,10,84,8,102,9,9,7,3,14,1),(128,'6IV Max','Pierroteknik','806',24,58,38,37,250,8,83,10,23,7,3,7,16),(129,'5IV/DSp','Gorythmic','812',3,63,2,148,149,5,109,22,1,8,1,11,NULL),(130,'5IV/ASp','Pyrobut','815',4,112,68,63,150,5,102,11,1,8,1,7,NULL),(131,'5IV/ASp','L├®zargus','818',5,8,63,5,174,5,85,25,1,8,1,4,NULL),(132,'5IV/PV','Corvaillus','823',11,158,90,63,10,5,102,22,17,8,1,18,1),(133,'5IV/ASp','Astronelle','826',23,39,38,130,72,5,102,25,22,8,1,9,13),(134,'5IV/PV','Roublenard','828',26,170,171,5,82,5,102,25,19,8,1,17,NULL),(135,'5IV/ASp','Torgamord','834',13,24,2,116,84,5,116,22,18,8,1,4,14),(136,'5IV/Att','Fulgudog','836',27,25,85,108,106,5,102,11,16,8,1,5,NULL),(137,'5IV/Att','Monthracite','839',18,84,61,24,36,5,85,5,17,8,1,14,7),(138,'5IV/D├®f','Pomdrapi','841',14,68,16,160,41,5,109,22,21,8,2,11,3),(139,'5IV/Vit','Dratatin','842',15,32,128,30,161,5,85,16,21,8,2,11,3),(140,'5IV/D├®f','Dunaconda','844',21,84,2,24,166,5,102,22,16,8,2,15,NULL),(141,'5IV/D├®f','Hastacuda','847',22,116,133,104,15,5,116,11,18,8,2,4,NULL),(142,'5IV/Vit','Salarsen','849',8,83,52,155,105,5,116,8,16,8,2,5,12),(143,'5IV/PV','Scolocendre','851',7,153,131,122,154,5,82,22,16,8,2,9,7),(144,'5IV/PV','Krakos','853',2,14,68,3,116,5,85,22,16,8,1,2,NULL),(145,'5IV/D├®f','Polth├®geist','855',17,37,39,114,72,5,105,25,19,8,3,16,NULL),(146,'5IV/D├®f','Sorcilence','858',16,162,38,163,40,5,82,16,22,8,2,13,6),(147,'5IV/D├®f','Angoliath','861',12,14,68,121,159,5,116,3,19,8,1,17,6),(148,'5IV/D├®f','Ixon','862',24,167,168,169,15,5,85,11,19,8,1,17,10),(149,'5IV/D├®f','Hexadron','870',10,15,67,1,157,5,82,11,16,8,3,2,NULL),(150,'5IV/Att','Beldeneige','873',19,8,130,78,164,5,102,25,19,8,1,8,9),(151,'5IV/PV','Dolman','874',9,24,2,156,84,5,102,22,17,8,2,14,NULL),(152,'5IV/ASp','Morpeko','877',20,165,108,25,29,5,109,22,19,8,2,5,17),(153,'5IV/Vit','Pachyradjah','879',25,10,2,85,84,5,109,22,17,8,1,1,NULL),(154,'5IV/DSp','Duralugon','884',1,18,52,20,21,5,116,25,17,8,1,1,3),(155,'6IV Parfait','Lanssorien','887',6,41,151,63,152,5,116,18,17,8,2,3,16),(156,'5IV/DSp','Galopa(Galar)','078',30,1,85,11,97,5,109,11,20,8,1,13,6),(157,'5IV/Vit','Flagadoss(Galar)','080',28,172,38,61,37,5,102,16,22,8,1,12,13),(158,'5IV/Att','Roigada(Galar)','199',29,173,38,37,83,5,105,16,19,8,2,12,13),(159,'5IV/Att','Fl├ómigator','911',7,36,37,51,185,6,108,16,1,10,2,7,16),(160,'5IV/D├®f','Palmaval','914',8,125,186,116,15,6,106,11,1,10,1,4,2),(161,'5IV/DSp','Pohmarmotte','923',28,15,3,29,202,6,106,11,16,10,1,5,2),(162,'5IV/PV','Arboliva','930',17,72,51,35,40,6,107,16,21,10,1,11,10),(163,'5IV/ASp','Gigansel','934',30,158,2,203,84,6,107,22,17,10,2,14,NULL),(164,'5IV/PV','Carmadura','936',3,177,38,37,36,6,108,25,16,10,1,7,13),(165,'5IV/PV','Malvalame','937',4,119,178,179,180,6,106,22,19,10,1,7,16),(166,'5IV/DSp','Ampibidou','939',24,51,52,53,54,6,107,16,16,10,1,5,NULL),(167,'5IV/PV','Fulgulairo','941',10,80,52,53,54,6,107,25,16,10,1,5,18),(168,'5IV/D├®f','Dogrino','943',16,25,168,85,104,6,106,11,19,10,1,17,NULL),(169,'5IV/DSp','Tag-Tag','945',22,63,46,96,7,6,106,11,20,10,1,12,10),(170,'5IV/Vit','Craparoi','950',20,197,48,99,97,6,106,22,17,10,1,14,NULL),(171,'5IV/PV','Scovilain','952',27,20,201,30,36,6,107,16,21,10,2,11,7),(172,'5IV/DSp','B├®rasca','954',14,35,38,130,139,6,107,16,20,10,2,9,13),(173,'5IV/DSp','Forgelina','959',5,125,85,181,182,6,114,11,22,10,2,6,1),(174,'5IV/PV','Lestombaile','962',26,148,90,126,63,6,107,11,19,10,2,18,17),(175,'5IV/D├®f','Superdofin','964',15,103,194,14,195,6,107,22,18,10,1,4,NULL),(176,'5IV/ASp','Vrombotor','966',13,10,193,7,67,6,107,22,17,10,1,1,12),(177,'5IV/DSp','Motorizard','967',9,17,25,187,188,6,108,11,17,10,1,3,10),(178,'5IV/PV','Ferdeter','968',25,10,200,2,55,6,114,22,16,10,2,1,NULL),(179,'5IV/D├®f','Flor├®clat','970',18,196,35,83,40,6,107,16,17,10,2,14,12),(180,'5IV/D├®f','Tomberro','972',19,9,85,158,204,6,107,22,19,10,1,16,NULL),(181,'5IV/ASp','Flamenroule','973',21,79,90,63,15,6,106,22,16,10,1,18,2),(182,'5IV/DSp','Balbal├¿ze','975',23,158,198,191,199,6,114,22,17,10,2,8,NULL),(183,'5IV/Att','Oyacata','977',12,87,191,186,192,6,114,21,18,10,1,4,NULL),(184,'5IV/Vit','Courrousinge','979',11,189,16,125,190,6,106,22,17,10,2,2,16),(185,'5IV/ASp','Terraiste','980',29,43,46,2,67,6,106,22,17,10,1,12,15),(186,'5IV/PV','Scalpereur','983',2,66,10,67,11,2,105,22,17,10,1,17,1),(187,'5IV/ASp','Glaivodo','998',1,17,25,115,175,6,106,11,17,10,1,3,8),(188,'6IV Parfait','Gromago','1000',2,37,176,31,170,6,108,7,23,10,3,1,16),(189,'5IV/Att','Pondralugon','1018',6,18,19,20,21,1,102,25,17,10,2,1,3),(190,'5IV/DSp','Pomdorochi','1019',6,183,30,35,184,6,106,16,21,10,1,11,3),(191,'5IV/Att','Tauros(Paldea)','128',8,1,22,98,15,3,114,11,23,10,1,2,7),(192,'6IV Max','Artikodin','144',22,8,42,228,80,7,74,10,24,1,3,8,18),(193,'6IV Max','├ëlecthor','145',23,91,100,52,54,7,99,16,5,1,3,5,18),(194,'6IV Max','Sulfura','146',24,80,63,62,58,7,99,21,9,1,3,7,18),(195,'6IV Max','Mewtwo','150',25,8,31,230,207,7,104,10,9,1,3,13,NULL),(196,'6IV Max','Raikou','243',16,139,52,37,54,7,83,25,9,2,3,5,NULL),(197,'6IV Max','Entei','244',17,58,102,20,139,7,102,10,9,2,3,7,NULL),(198,'6IV Max','Suicune','245',18,8,61,163,80,7,99,16,13,2,3,4,NULL),(199,'6IV Max','Lugia','249',14,62,38,222,139,7,99,25,24,2,3,13,18),(200,'6IV Max','Ho-Oh','250',13,90,220,2,221,7,102,9,9,2,3,7,18),(201,'6IV Max','Celebi','251',15,170,38,163,33,7,134,2,10,2,3,11,13),(202,'6IV Max','Regirock','377',7,14,2,29,24,8,14,10,15,3,3,14,NULL),(203,'6IV Max','Regice','378',8,31,242,52,8,8,104,3,9,3,3,8,NULL),(204,'6IV Max','Registeel','379',9,3,2,10,137,8,99,22,3,3,3,1,NULL),(205,'6IV Max','Latias','380',26,163,38,52,21,7,99,16,9,3,2,3,13),(206,'6IV Max','Latios','381',27,8,38,163,21,7,14,12,9,3,1,3,13),(207,'6IV Max','Kyogre','382',3,207,163,8,208,7,99,15,13,3,3,4,NULL),(208,'6IV Max','Groudon','383',2,24,2,28,206,7,104,22,15,3,3,15,NULL),(209,'6IV Max','Rayquaza','384',1,23,2,41,205,7,99,15,9,3,3,3,18),(210,'6IV Max','Dialga','483',10,217,58,18,21,7,83,2,15,4,3,1,3),(211,'6IV Max','Palkia','484',11,58,218,109,56,7,99,25,5,4,3,4,3),(212,'6IV Max','Heatran','485',13,84,35,18,246,8,104,25,9,4,2,7,1),(213,'6IV Max','Regigigas','486',12,3,28,29,136,8,102,4,17,4,3,10,NULL),(214,'6IV Max','Giratina','487',12,17,2,219,9,7,83,18,9,4,3,16,3),(215,'6IV Max','Cobaltium','638',10,11,10,223,15,9,105,22,9,5,3,1,2),(216,'6IV Max','Terrakium','639',11,24,2,223,15,9,14,7,3,5,3,14,2),(217,'6IV Max','Viridium','640',12,11,223,49,15,9,105,22,9,5,3,11,2),(218,'6IV Max','Bor├®as','641',25,63,100,148,80,8,83,14,9,5,1,18,NULL),(219,'6IV Max','Fulguris','642',26,5,52,31,54,8,14,23,3,5,1,5,18),(220,'6IV Max','Reshiram','643',28,231,38,232,21,7,83,19,24,5,3,3,7),(221,'6IV Max','Zekrom','644',29,1,16,233,234,7,105,14,9,5,3,3,5),(222,'6IV Max','D├®m├®t├®ros','645',27,63,2,148,24,8,14,3,3,5,1,15,18),(223,'6IV Max','Kyurem','646',30,8,31,35,21,7,116,12,9,5,3,3,8),(224,'6IV Max','Xern├®as','716',7,213,38,207,65,7,83,2,9,6,3,6,NULL),(225,'6IV Max','Yveltal','717',8,214,100,68,5,7,99,5,9,6,3,17,18),(226,'6IV Max','Zygarde','718',9,23,41,215,216,7,135,22,10,6,3,3,15),(227,'6IV Max','Tokorico','785',3,40,52,53,238,8,136,25,10,7,3,5,6),(228,'6IV Max','Tokopiyon','786',4,37,38,52,40,8,116,10,9,7,3,13,6),(229,'6IV Max','Tokotoro','787',5,64,239,240,1,8,137,22,10,7,3,11,6),(230,'6IV Max','Tokopisco','788',6,163,6,241,65,NULL,138,4,10,7,3,4,6),(231,'6IV Max','Solgaleo','791',4,1,25,10,209,7,102,22,9,7,3,13,1),(232,'6IV Max','Lunala','792',5,210,38,37,65,7,102,3,9,7,3,13,16),(233,'6IV Max','Necrozma','800',6,211,5,35,212,7,102,17,9,7,3,13,NULL),(234,'5IV/D├®f','Zeraora','807',7,237,16,34,15,9,139,18,10,7,3,5,NULL),(235,'6IV Max','Melmetal','809',1,235,236,18,86,8,81,8,3,7,3,1,NULL),(236,'6IV Max','Zacian','888',19,223,85,10,11,7,140,22,10,8,3,6,NULL),(237,'6IV Max','Zamazenta','889',20,224,10,225,15,7,140,22,10,8,3,2,NULL),(238,'6IV Max','├ëthernatos','890',21,36,70,226,227,7,141,25,10,8,3,12,3),(239,'6IV Max','Regieleki','894',10,243,52,244,54,8,105,15,9,8,3,5,NULL),(240,'6IV Max','Regidrago','895',11,41,108,106,245,8,102,3,9,8,3,3,NULL),(241,'6IV Max','Amov├®nus','905',28,65,35,79,253,8,142,17,10,9,2,6,18),(242,'6IV Max','Meltan','808',2,18,52,93,257,8,81,1,3,7,3,1,NULL),(243,'6IV Max','Type:0','772',29,256,48,10,257,8,104,25,1,7,3,10,NULL),(244,'6IV Max','Sylvalli├®','773',30,11,25,10,265,8,95,22,1,7,3,10,NULL),(245,'6IV Max','Arceus','493',1,51,128,35,23,9,144,24,3,4,3,10,NULL),(246,'6IV Max','Shaymin','492',2,82,258,20,259,9,143,10,9,4,3,11,NULL),(247,'6IV Max','Manaphy','490',3,37,6,61,8,9,142,4,10,4,3,4,NULL),(248,'6IV Max','Artikodin(Galar)','144',4,80,38,39,260,9,145,9,10,8,3,13,18),(249,'6IV Max','├ëlecthor(Galar)','145',5,15,111,125,261,9,146,22,10,8,3,2,18),(250,'6IV Max','Sulfura(Galar)','146',6,262,78,80,75,9,147,20,10,8,3,17,18),(251,'6IV Max','Rugit-Lune','1005',19,41,263,17,1,9,114,13,9,10,3,3,17),(252,'6IV Max','Hydragon','882',27,264,16,25,104,9,105,13,1,8,3,4,3),(253,'6IV Max','Meloetta','648',8,51,38,37,266,9,148,16,10,5,3,10,13),(254,'6IV Max','T├¬tes-de-Fer','993',14,51,5,78,32,9,106,25,9,10,3,17,18),(255,'6IV Max','Garde-de-Fer','1006',13,15,179,69,159,9,106,21,19,10,3,6,2),(256,'6IV Max','Mite-de-Fer','994',15,80,130,83,267,9,106,7,9,10,3,7,12),(257,'6IV Max','├ëpine-de-Fer','995',18,25,2,107,99,9,106,6,9,10,3,14,5),(258,'6IV Max','Paume-de-Fer','992',16,269,107,29,15,9,106,18,9,10,3,2,5),(259,'6IV Max','Roue-de-Fer','990',17,268,2,43,87,9,106,7,9,10,3,15,1),(260,'6IV Max','Hotte-de-Der','991',24,8,111,194,74,9,106,22,18,10,3,8,4),(261,'6IV Max','Rampe-Ailes','988',20,134,270,64,125,9,107,24,9,10,3,9,2),(262,'6IV Max','Fort-Ivoire','984',21,147,2,10,15,9,107,4,17,10,3,15,2),(263,'6IV Max','Hurle-Queue','985',22,51,38,85,104,9,107,7,9,10,3,6,13),(264,'6IV Max','Flotte-M├¿che','987',23,40,39,37,196,9,114,24,9,10,3,16,6),(265,'6IV Max','Pelage-Sabl├®','989',25,18,35,53,54,9,114,22,21,10,3,5,15),(266,'6IV Max','Fongus-Furie','986',26,25,191,68,26,9,114,13,21,10,3,11,17),(267,'6IV Max','Keldeo','647',9,271,272,109,56,9,149,16,10,5,3,4,2);
/*!40000 ALTER TABLE `pokemon_shiny` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region_dresseur`
--

DROP TABLE IF EXISTS `region_dresseur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `region_dresseur` (
  `id_region_dresseur` bigint NOT NULL AUTO_INCREMENT,
  `nom_region_dresseur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_region_dresseur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region_dresseur`
--

LOCK TABLES `region_dresseur` WRITE;
/*!40000 ALTER TABLE `region_dresseur` DISABLE KEYS */;
INSERT INTO `region_dresseur` VALUES (1,'1G/6G'),(2,'Alola/Galar/Hisui'),(3,'Paldea');
/*!40000 ALTER TABLE `region_dresseur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nom_region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (1,'Kanto'),(2,'Johto'),(3,'Hoenn'),(4,'Sinnoh'),(5,'Unys'),(6,'Kalos'),(7,'Alola'),(8,'Galar'),(9,'Hisui'),(10,'Paldea');
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexe`
--

DROP TABLE IF EXISTS `sexe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sexe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_shiny` int DEFAULT NULL,
  `nb_total` int DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexe`
--

LOCK TABLES `sexe` WRITE;
/*!40000 ALTER TABLE `sexe` DISABLE KEYS */;
INSERT INTO `sexe` VALUES (1,115,505,'M├óle ÔÖé'),(2,59,372,'Femelle ÔÖÇ'),(3,6,155,'Assexu├® ├ÿ');
/*!40000 ALTER TABLE `sexe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nb_shiny` int DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,21,'Acier'),(2,17,'Combat'),(3,22,'Dragon'),(4,22,'Eau'),(5,15,'├ëlectrik'),(6,11,'F├®e'),(7,24,'Feu'),(8,9,'Glace'),(9,11,'Insecte'),(10,17,'Normal'),(11,15,'Plante'),(12,15,'Poison'),(13,18,'Psy'),(14,17,'Roche'),(15,15,'Sol'),(16,15,'Spectre'),(17,19,'T├®n├¿bres'),(18,19,'Vol');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-16 10:49:29
