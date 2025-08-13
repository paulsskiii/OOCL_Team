CREATE DATABASE  IF NOT EXISTS `cargo_shipping_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cargo_shipping_system`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: cargo_shipping_system
-- ------------------------------------------------------
-- Server version	9.2.0

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(50) DEFAULT NULL,
  `address_line2` varchar(50) DEFAULT NULL,
  `barangay` varchar(50) DEFAULT NULL,
  `city_id` int NOT NULL,
  `postal_code` varchar(20) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'90 Ludington Circle','8392','Dayton',52,NULL,NULL,'Indonesia'),(2,'32716 Artisan Point','2739','Village',14,NULL,NULL,'Indonesia'),(3,'25258 Waywood Circle','65841','Mcbride',41,'628532',NULL,'Russia'),(4,'8 Lillian Court','85','International',80,NULL,NULL,'Sudan'),(5,'2 Petterle Park','1076','Bluestem',24,NULL,NULL,'Vietnam'),(6,'7161 Lunder Crossing','01','Roth',8,NULL,NULL,'Ireland'),(7,'34 Clemons Lane','4','Stone Corner',15,'44505','Ohio','United States'),(8,'47 Anniversary Circle','18062','Tony',65,'5202541',NULL,'Japan'),(9,'85 Mayer Terrace','03657','Shelley',3,NULL,NULL,'Uruguay'),(10,'102 Sutteridge Hill','05','Prairieview',23,NULL,NULL,'Jamaica'),(11,'705 Carpenter Pass','35','Chive',15,NULL,NULL,'Honduras'),(12,'4456 Daystar Park','061','Dorton',35,NULL,NULL,'Syria'),(13,'142 Donald Alley','8172','Bunting',61,NULL,NULL,'China'),(14,'446 Ruskin Junction','237','Sunnyside',60,'152014',NULL,'Russia'),(15,'93 Hoffman Park','4','Portage',22,'694752',NULL,'Russia'),(16,'229 Waywood Plaza','4069','Di Loreto',19,NULL,NULL,'Sudan'),(17,'49946 Blue Bill Park Plaza','7','Center',33,NULL,NULL,'China'),(18,'61 Pankratz Pass','1','Old Shore',1,NULL,NULL,'Vietnam'),(19,'1 Scott Lane','10','Delaware',23,NULL,NULL,'Peru'),(20,'181 Summit Street','82323','Corry',41,NULL,NULL,'Indonesia'),(21,'088 Sunnyside Hill','3408','North',66,NULL,NULL,'Vietnam'),(22,'1 Atwood Crossing','25158','Hansons',4,NULL,NULL,'Greece'),(23,'32 4th Court','223','Messerschmidt',68,NULL,NULL,'Indonesia'),(24,'4 Mosinee Road','62005','Nevada',23,NULL,NULL,'Indonesia'),(25,'1 Leroy Court','2','6th',7,'40401',NULL,'Poland'),(26,'8501 Lien Alley','186','Superior',53,NULL,NULL,'South Korea'),(27,'19144 Welch Trail','6','Ohio',50,NULL,NULL,'Indonesia'),(28,'925 Bowman Place','93','Dryden',50,NULL,NULL,'Djibouti'),(29,'329 Crest Line Hill','04','Pearson',73,'9634603',NULL,'Japan'),(30,'74935 Russell Park','9','Oriole',40,'242622',NULL,'Russia'),(31,'073 Cherokee Avenue','853','Fair Oaks',56,'630008',NULL,'Colombia'),(32,'42317 Maple Drive','1','Delaware',44,'29980000',NULL,'Brazil'),(33,'05959 Anhalt Court','468','Ridgeway',46,'3586',NULL,'Argentina'),(34,'7 Kennedy Court','0','Moose',15,NULL,NULL,'Turkmenistan'),(35,'79 Sunfield Parkway','5','Erie',79,'36520000',NULL,'Brazil'),(36,'098 Forest Road','5','Crowley',32,NULL,NULL,'Botswana'),(37,'2942 Hermina Center','6166','Walton',60,'627603',NULL,'Russia'),(38,'92 Longview Pass','51','Talmadge',19,'50730',NULL,'Pakistan'),(39,'58926 Lakewood Way','6','Village',43,'26540','Skåne','Sweden'),(40,'4961 Maple Wood Place','76776','Fuller',45,'2433',NULL,'Philippines'),(41,'771 Arapahoe Parkway','4987','Village',5,'20','Alberta','Canada'),(42,'1754 Village Park','3','Sommers',53,NULL,NULL,'Vietnam'),(43,'04 Warbler Road','46','Forest',67,NULL,NULL,'Uzbekistan'),(44,'71566 Londonderry Trail','957','Del Mar',57,NULL,NULL,'China'),(45,'12 Nova Center','6','Eastwood',35,NULL,NULL,'China'),(46,'2 Holmberg Plaza','23','Thackeray',47,NULL,NULL,'Indonesia'),(47,'83658 Oak Valley Road','0','Basil',49,NULL,NULL,'China'),(48,'2106 Kennedy Parkway','147','Melrose',54,NULL,NULL,'Indonesia'),(49,'4998 Waubesa Road','601','Boyd',67,NULL,NULL,'Indonesia'),(50,'5 Farragut Lane','0025','Village',72,NULL,NULL,'Peru'),(51,'919 Gale Trail','991','Ridgeway',17,NULL,NULL,'China'),(52,'34354 Longview Circle','8','Weeping Birch',66,NULL,NULL,'Indonesia'),(53,'4 Buhler Avenue','686','Schiller',15,NULL,NULL,'Peru'),(54,'60230 Old Gate Way','15927','Mallory',39,'94604','Île-de-France','France'),(55,'11 Village Terrace','850','Esker',44,NULL,NULL,'China'),(56,'62803 Old Gate Alley','625','Portage',69,'73210',NULL,'Pakistan'),(57,'26 Fallview Center','82','Heffernan',22,NULL,NULL,'China'),(58,'557 Westport Alley','4604','Wayridge',80,NULL,NULL,'Azerbaijan'),(59,'94829 Tony Avenue','89187','Thompson',40,NULL,NULL,'China'),(60,'24980 Butterfield Terrace','412','Melrose',16,NULL,NULL,'China'),(61,'6 Bobwhite Center','9','Waubesa',62,NULL,NULL,'China'),(62,'7730 Alpine Hill','1657','8th',45,NULL,NULL,'Jamaica'),(63,'17 Gale Point','82','Tomscot',12,NULL,NULL,'Burundi'),(64,'1 Macpherson Circle','98','Monument',12,NULL,NULL,'Serbia'),(65,'9975 Anthes Crossing','246','Grover',36,'357329',NULL,'Russia'),(66,'103 Jenifer Way','36037','Oriole',54,NULL,NULL,'Indonesia'),(67,'5302 Haas Way','35','Shopko',5,'49544','Michigan','United States'),(68,'01 Brown Junction','52589','Stone Corner',34,'5016',NULL,'Philippines'),(69,'3201 Jana Way','31','Pleasure',34,'1100',NULL,'Philippines'),(70,'2 Sycamore Circle','0855','Brickson Park',33,'20706',NULL,'Costa Rica'),(71,'9939 Dovetail Park','11','Ridge Oak',41,NULL,NULL,'China'),(72,'4816 Dahle Point','12274','Melrose',19,NULL,NULL,'Peru'),(73,'187 Orin Place','88','Linden',1,'1225',NULL,'Macedonia'),(74,'14909 Graedel Junction','749','Independence',64,'1400',NULL,'Macedonia'),(75,'09 Sachs Drive','646','Dennis',51,'1400','British Columbia','Canada'),(76,'01 Boyd Parkway','3733','Kenwood',59,NULL,NULL,'Bosnia and Herzegovina'),(77,'6340 Fallview Terrace','99','Northview',58,'19360000',NULL,'Brazil'),(78,'1 Upham Drive','5697','Veith',54,NULL,NULL,'Yemen'),(79,'83643 Crowley Park','8237','Arrowood',18,NULL,NULL,'China'),(80,'173 Florence Junction','1','David',49,NULL,NULL,'Jordan');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Thị Trấn Nước Hai'),(2,'Altan-Ovoo'),(3,'Clamart'),(4,'Guacarí'),(5,'Babica'),(6,'Xigangzi'),(7,'El Tejocote'),(8,'Urug'),(9,'Dobryanka'),(10,'Lainqu'),(11,'Tlogocilik'),(12,'Gongrong'),(13,'Rizal'),(14,'Hanamaki'),(15,'Sihe'),(16,'Yuhuangding'),(17,'Olszówka'),(18,'Talashkino'),(19,'Ballymun'),(20,'Jauja'),(21,'Chengbei'),(22,'Marmárion'),(23,'Nora'),(24,'Cagliari'),(25,'Petushki'),(26,'Gucun'),(27,'Brusy'),(28,'Maguwon'),(29,'Ang Thong'),(30,'Schaumburg'),(31,'Todorovo'),(32,'Mangero'),(33,'Yunji'),(34,'Banjar Tengah'),(35,'Prelog'),(36,'Kiangan'),(37,'Souziqiu'),(38,'Trakan Phut Phon'),(39,'Santa Paz'),(40,'Qiling'),(41,'El Nido'),(42,'Tielong'),(43,'Oued Laou'),(44,'Saint-Jouan-des-Guérets'),(45,'Buzuluk'),(46,'Ljig'),(47,'Strawczyn'),(48,'Rivne'),(49,'Runting'),(50,'Staffanstorp'),(51,'Ivry-sur-Seine'),(52,'Fatumuti'),(53,'New Orleans'),(54,'Santa Venera'),(55,'Spirovo'),(56,'Rivas'),(57,'Velyki Sorochyntsi'),(58,'Ḩarf al Musaytirah'),(59,'Wailiang'),(60,'Kaédi'),(61,'Nogliki'),(62,'Varkaus'),(63,'Holýšov'),(64,'Huangdi'),(65,'Temuji'),(66,'Berlin'),(67,'Altanbulag'),(68,'São Lourenço da Mata'),(69,'Bislig'),(70,'Qijia'),(71,'Camacupa'),(72,'Brazzaville'),(73,'Ledenice'),(74,'Deje'),(75,'Bato'),(76,'Zmiyëvka'),(77,'Ostroróg'),(78,'Nangalimang'),(79,'Kavadarci'),(80,'Archis');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courier`
--

DROP TABLE IF EXISTS `courier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courier` (
  `courier_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `contact_number` varchar(16) DEFAULT NULL,
  `vehicle_type` varchar(32) DEFAULT NULL,
  `license_number` varchar(20) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`courier_id`),
  UNIQUE KEY `contact_number` (`contact_number`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courier`
--

LOCK TABLES `courier` WRITE;
/*!40000 ALTER TABLE `courier` DISABLE KEYS */;
INSERT INTO `courier` VALUES (1,'Fidelity','Rorke','214130136','Volkswagen','WBASN2C54AC101147','2025-01-16 13:44:41'),(2,'Sayers','Udy','831802022','Mazda','JM1NC2MF4E0731223','2025-02-12 09:18:55'),(3,'Beret','Tidbury','456202602','BMW','5J8TB2H59CA122794','2024-11-21 01:06:49'),(4,'Gavrielle','Hadgkiss','126270454','Buick','WA1CGAFE7DD511151','2025-05-22 10:00:09'),(5,'Mellisa','Mitrovic','876103527','Mazda','1FMNE1BW4AD881433','2025-01-21 19:51:13'),(6,'Collin','Bautiste','286978281','GMC','WBXPA93496W204660','2024-11-07 15:20:06'),(7,'Kaile','Pluck','709353942','Mercury','3GYFK66N64G048494','2025-03-23 11:05:26'),(8,'Fitzgerald','Sesser','808903194','Audi','WBAEP33465P384878','2025-05-30 00:57:45'),(9,'Vivyan','Blas','783574448','Volkswagen','KMHEC4A47FA975759','2025-05-08 04:18:20'),(10,'Honoria','Cosgreave','177210107','Chevrolet','WAUCFAFR9EA151957','2025-01-11 01:11:25'),(11,'Danyette','Powling','624303388','Mitsubishi','3D7JV1EP7BG982101','2025-05-09 14:45:05'),(12,'Onfroi','Daily','236420351','GMC','3VW467AT4DM289742','2025-07-15 05:06:15'),(13,'Marris','Jedraszek','971167246','Volvo','2T1BURHE4FC243648','2024-09-28 23:45:39'),(14,'Tam','Pidduck','788091257','Volkswagen','WBALW7C56CC786575','2025-07-17 16:06:27'),(15,'Ephraim','Beevers','878713449','Lamborghini','WAUKFAFL6DN038871','2025-02-25 03:05:36'),(16,'Bethany','Betz','683436847','Infiniti','WAUCH74F79N769072','2025-05-19 04:55:01'),(17,'Belinda','Ebbett','190343389','Mercedes-Benz','WBAVB73527V336212','2024-10-08 19:35:55'),(18,'Cassius','Pawlett','124388906','Ford','1FTMF1E8XAK014561','2025-01-19 03:55:12'),(19,'Tiffi','Muckle','904284086','Mitsubishi','1D7RE2GKXBS600095','2025-03-20 05:49:49'),(20,'Tobe','Patillo','791662846','Mazda','1N6AF0LX0FN800978','2025-03-31 19:24:14'),(21,'Melodie','Raselles','849403968','Volvo','3N1CN7AP4EL103650','2024-09-13 10:08:29'),(22,'Valerye','Crutcher','323509489','Saab','2G61R5S34D9945000','2024-08-30 08:10:42'),(23,'Chris','Deverell','280074685','Ferrari','WA1EV74L17D863259','2024-12-26 00:12:00'),(24,'Darnell','O\'Doogan','713208517','Cadillac','1GT01XEG2FZ689135','2025-04-25 20:16:41'),(25,'Ailyn','Rawlinson','158742168','Hyundai','1FTSW2A54AE866931','2025-06-26 05:14:19'),(26,'Oriana','Di Filippo','550273870','Honda','1GD22ZCGXDZ437310','2024-12-17 04:57:28'),(27,'Sigismondo','Waterhowse','172751466','Bentley','5GAKRBED4CJ195588','2025-01-01 21:12:45'),(28,'Lolly','Blankett','148128800','Chevrolet','1GD422CG5EF572908','2025-04-27 05:36:47'),(29,'Gerrie','Fetherstonhaugh','868115660','Chevrolet','3D73Y4CL9BG753274','2024-11-23 16:56:09'),(30,'Nick','Mannakee','982745460','Mercedes-Benz','5NPDH4AE5DH559337','2024-09-16 11:25:03'),(31,'Jillene','Churms','602607105','Chevrolet','1C4RDJAGXCC325755','2025-02-16 23:31:09'),(32,'Christy','Glasscock','655435848','Cadillac','WAUVC68E55A823568','2025-01-01 14:34:49'),(33,'Amelina','Conduit','845792726','Chrysler','WA1DGAFEXBD749786','2024-12-25 04:22:39'),(34,'Katharina','Colmore','964729282','Pontiac','1G6YV36A675663997','2025-06-03 07:19:37'),(35,'Gale','Gerler','209872287','Volkswagen','4T1BB3EK4AU779519','2025-04-23 14:22:39'),(36,'Rozanne','Stonall','556111291','Cadillac','WBAUN9C57AV574658','2024-11-25 06:20:24'),(37,'Marty','Eatherton','329962426','Mazda','WBALW3C50DC089770','2024-12-27 15:46:07'),(38,'Mallorie','Dyche','685555517','Lincoln','5NMSG3AB7AH331326','2025-06-01 09:53:52'),(39,'Guenevere','Beves','624413082','Acura','3D4PH1FG1BT848978','2025-04-29 10:40:42'),(40,'Margarethe','Ruzic','368131023','Mercedes-Benz','1G6KD5EYXAU725112','2024-11-02 11:08:52'),(41,'Avrit','Teodorski','815559725','Subaru','WAUEFAFL2BA175047','2024-12-04 11:50:51'),(42,'Amandi','Hamner','926387022','Mercedes-Benz','1FTEW1E87AK539310','2025-02-09 13:40:37'),(43,'Arther','Blague','308110514','Dodge','KMHHT6KD1DU382871','2025-08-06 19:01:05'),(44,'Saunders','Brimacombe','344949885','Ford','JTEBU4BF6DK125600','2025-06-19 22:47:03'),(45,'Aubrie','Meus','567086920','Toyota','WBA3B9C50FP137245','2024-09-18 06:34:26'),(46,'Blanch','Pavie','338075881','Dodge','3VW217AU3FM395407','2025-07-29 20:17:14'),(47,'Lanita','Felgate','670291059','Lincoln','JN1BY1AR5FM607858','2024-12-23 02:46:35'),(48,'Alfy','Kenafaque','239697319','Honda','WVGAV7AXXAW038601','2025-04-02 09:03:07'),(49,'Windy','McWhorter','117705509','Chrysler','1G6DF8E59C0540327','2024-11-11 10:18:20'),(50,'Ingemar','Sullivan','615057609','Saturn','JH4KB16698C256618','2025-04-18 16:12:48'),(51,'Jany','Badrock','240746566','Oldsmobile','WAUDF78E08A576067','2024-12-09 22:00:27'),(52,'Earl','Garman','838517039','Mercury','ZHWGU6BZ3CL508927','2024-11-14 10:35:32'),(53,'Sioux','Legon','276736609','Oldsmobile','19UUA65515A835632','2024-12-05 22:59:18'),(54,'Thor','Rasor','723764523','Toyota','WAUVT64B84N307661','2024-08-31 12:13:25'),(55,'Kacey','George','849588199','Mitsubishi','WAUBF78K19N109490','2024-09-07 10:39:38'),(56,'Stafani','Glidden','375371634','Kia','4T1BD1FK2EU381826','2025-04-27 15:41:50'),(57,'Tommie','Hedditch','681013941','Nissan','1C3CCBCGXDN657619','2024-12-27 18:44:24'),(58,'Matilda','Gow','612314028','Nissan','2G4GR5EK4C9838209','2025-01-23 05:51:41'),(59,'Carola','Grotty','732775360','Chrysler','1D4PT6GX3BW082854','2025-05-01 11:36:17'),(60,'Marje','Moyser','231988228','GMC','WA1CGBFE4ED847606','2025-07-06 09:13:19'),(61,'Phyllys','Triggol','993911607','Chevrolet','SAJWA4EC5EM714175','2024-08-20 00:09:01'),(62,'Didi','Croxford','601148276','Saturn','1G6DS1E3XC0340185','2025-02-24 00:05:10'),(63,'Verina','Leavens','175513689','Dodge','1C4RDJEG2EC051013','2024-11-28 03:28:19'),(64,'Lind','Rubie','883659316','Volvo','SCBLE47K48C171523','2025-03-21 13:53:32'),(65,'Jody','Redfearn','270420986','Chevrolet','SCBLC37F05C427977','2025-03-24 11:11:36'),(66,'Jerome','Collocott','592238014','Buick','WAU4GBFBXBN615904','2025-06-05 16:39:26'),(67,'Ulberto','Mighele','717162046','Jeep','WAU3GBFC2DN164023','2025-03-27 16:50:55'),(68,'Hilda','Kopec','677481630','Ford','WDDHF5GB8AA295209','2025-07-02 21:58:28'),(69,'Aigneis','Lorkin','616252011','Toyota','1N6AF0KX4FN729396','2024-11-23 21:13:16'),(70,'Mariska','Mogie','249411199','Audi','1G4HJ5EMXAU071172','2024-11-06 15:09:10'),(71,'Drugi','Burlay','192313003','Lexus','1G6DS8ED9B0620888','2025-02-07 09:27:28'),(72,'Geri','Crocumbe','913477285','Ford','1G4HK5ESXBU834580','2024-08-15 06:24:32'),(73,'Antonius','Passingham','958081114','Land Rover','WA1LGBFEXFD653406','2025-01-26 00:38:55'),(74,'Cornelius','Thridgould','896919398','Honda','1G6DC8E59C0821021','2024-09-30 18:41:44'),(75,'Noel','Ownsworth','661856140','Chrysler','WBAKF3C53BE178861','2025-08-10 17:49:29'),(76,'Brad','Marsden','326429907','Volkswagen','WA1CGBFE1BD663252','2024-10-06 11:39:15'),(77,'Waldon','Wonfor','767702583','Chevrolet','WBA3A5G54CN140338','2024-12-10 18:07:57'),(78,'Roderigo','Parncutt','429094056','Lexus','5FRYD4H82EB180257','2024-08-29 23:47:48'),(79,'Nerte','Nappin','146998464','BMW','1N6AA0CA3AN013820','2024-09-22 10:55:59'),(80,'Cristabel','Dood','185304683','Mitsubishi','SAJWA4FB4EL981402','2025-02-06 11:55:18');
/*!40000 ALTER TABLE `courier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `contact_number` varchar(16) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `address_id` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `contact_number` (`contact_number`),
  UNIQUE KEY `email_address` (`email_address`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Lynda','Epinoy','94681310337','lepinoy0@gmail.com',11,'2025-07-31 00:59:10','2025-07-20 03:03:01'),(2,'Glyn','Danelut','60117971747','gdanelut1@biblegateway.com',19,'2025-04-08 02:34:59','2025-03-11 07:24:53'),(3,'Clemmie','Setterthwait','39988478284','csetterthwait2@gmail.com',79,'2025-03-30 23:00:33','2025-05-31 15:44:04'),(4,'Grange','Brimicombe','26373575406','gbrimicombe3@gmail.com',28,'2025-02-20 22:39:32','2025-03-21 11:05:49'),(5,'Kary','Elby','77807607642','kelby4@gmail.com',36,'2025-07-31 15:49:04','2025-07-25 01:17:33'),(6,'Goldarina','Primett','39137804942','gprimett5@gmail.com',60,'2024-09-15 14:12:18','2025-05-05 23:17:46'),(7,'Lyn','Dymoke','39085339278','ldymoke6@gmail.com',3,'2025-02-18 23:41:40','2025-04-25 08:28:25'),(8,'Mari','Fright','91798786678','mfright7@gmail.com',66,'2024-11-09 22:11:26','2025-02-06 05:39:03'),(9,'Ivy','Ralestone','63599551858','iralestone8@gmail.com',57,'2024-11-14 12:15:40','2025-07-31 03:44:36'),(10,'Lizzy','Geane','22041672137','lgeane9@accuweather.com',11,'2025-02-09 11:51:17','2025-03-24 23:33:58'),(11,'Shirley','Waylett','65284660953','swayletta@flavors.me',6,'2025-06-03 11:07:08','2025-05-17 03:51:13'),(12,'Zsa zsa','Bester','18890725679','zbesterb@gmail.com',10,'2024-08-15 22:27:49','2025-03-06 04:02:30'),(13,'Moishe','Beeckx','91784304804','mbeeckxc@gmail.com',21,'2024-12-24 04:32:18','2025-04-13 19:54:06'),(14,'Dmitri','Stuchbury','49341264381','dstuchburyd@engadget.com',46,'2025-08-09 11:42:51','2025-01-13 16:26:39'),(15,'Miller','Monks','66632219011','mmonkse@toplist.cz',38,'2025-04-18 08:35:40','2025-07-25 20:05:37'),(16,'Juditha','Simoncelli','24156268116','jsimoncellif@gmail.com',10,'2025-07-11 05:27:25','2025-07-27 04:12:49'),(17,'Odie','Bernaldo','34896465577','obernaldog@gmail.com',59,'2025-04-06 20:59:19','2025-05-05 18:56:42'),(18,'Tabbie','Eldrett','18903584152','teldretth@gmail.com',31,'2025-06-23 04:51:50','2025-06-21 05:55:40'),(19,'Dominique','Richardson','28118436090','drichardsoni@gmail.com',61,'2024-10-02 14:14:23','2025-02-12 21:08:42'),(20,'Mill','Duerden','78436983149','mduerdenj@gmail.com',58,'2025-07-01 03:53:46','2025-07-30 05:16:04'),(21,'Pyotr','Cordoba','91774947463','pcordobak@gmail.com',42,'2025-06-26 23:55:13','2025-07-29 17:15:09'),(22,'Trent','Wildash','31337265544','twildashl@gmail.com',4,'2025-01-02 18:05:57','2025-05-06 01:17:38'),(23,'Erina','Yellowlees','32778370918','eyellowleesm@gmail.com',34,'2025-05-03 16:09:47','2025-02-10 16:18:51'),(24,'Ethelda','Peirce','83560603207','epeircen@gmail.com',7,'2025-02-14 03:17:32','2025-07-31 23:21:49'),(25,'Jo','Janousek','87332211631','jjanouseko@gmail.com',53,'2025-05-26 16:41:24','2025-03-21 18:31:49'),(26,'Orin','Bridel','95993008849','obridelp@gmail.com',22,'2024-12-18 20:33:52','2025-06-27 08:40:48'),(27,'Caz','Marvin','32926974254','cmarvinq@telegraph.co.uk',9,'2025-07-09 21:41:26','2025-05-08 08:34:35'),(28,'Atlanta','Sizland','31277306768','asizlandr@prnewswire.com',2,'2025-04-06 19:51:38','2025-02-24 06:28:17'),(29,'Marigold','Crowcombe','67264949087','mcrowcombes@ibm.com',15,'2025-01-09 03:57:51','2025-02-25 16:36:17'),(30,'Jedediah','Afonso','38355472192','jafonsot@nytimes.com',59,'2024-11-17 18:22:09','2025-07-21 09:04:40'),(31,'Bertie','Spraberry','83553726316','bspraberryu@senate.gov',13,'2025-04-14 00:48:23','2025-03-10 22:00:37'),(32,'Mireille','Tett','73295069866','mtettv@unc.edu',29,'2024-12-24 15:34:01','2025-06-24 07:09:43'),(33,'Madel','Marcone','76610096652','mmarconew@house.gov',76,'2025-06-22 14:57:11','2025-01-26 19:36:10'),(34,'Martainn','Pavy','68269746692','mpavyx@taobao.com',78,'2025-04-17 13:02:07','2025-05-11 00:13:26'),(35,'Carolyn','Martignon','26266059061','cmartignony@stumbleupon.com',50,'2025-01-20 07:34:35','2025-05-09 10:10:17'),(36,'Jermain','Dono','72521531759','jdonoz@businessinsider.com',42,'2024-08-26 13:44:54','2025-07-15 01:08:26'),(37,'James','Fears','27372555071','jfears10@ocn.ne.jp',25,'2024-10-03 05:33:23','2025-03-20 06:41:35'),(38,'Humphrey','Duquesnay','27302308478','hduquesnay11@clickbank.net',39,'2024-10-19 00:31:15','2025-05-08 23:24:01'),(39,'Rafaelita','Schachter','75463257633','rschachter12@t-online.de',30,'2025-08-06 04:07:48','2025-04-24 04:37:46'),(40,'Nollie','Whitecross','81157188700','nwhitecross13@dyndns.org',41,'2025-05-27 08:56:45','2025-05-23 21:03:31'),(41,'Shelton','Strute','39438908286','sstrute14@bbc.co.uk',48,'2024-08-17 19:19:25','2025-04-11 18:07:41'),(42,'Orsola','Ferrario','31098105947','oferrario15@webeden.co.uk',31,'2025-06-08 21:43:49','2025-05-20 20:11:06'),(43,'Carlie','Geraud','38505151214','cgeraud16@nasa.gov',8,'2025-02-07 03:16:06','2025-03-18 16:57:56'),(44,'Artemas','Ruggen','13824141833','aruggen17@gmail.com',40,'2025-05-11 08:34:00','2025-06-08 16:04:15'),(45,'Westbrook','Arber','38435613542','warber18@xing.com',66,'2025-06-28 22:47:25','2025-04-04 11:34:03'),(46,'Heath','Treversh','56167201127','htreversh19@gmail.com',70,'2025-01-26 00:14:55','2025-02-28 07:37:18'),(47,'Klarika','Standage','94864070889','kstandage1a@gmail.com',66,'2024-09-19 08:22:42','2025-06-29 13:53:26'),(48,'Rhianna','Gouldthorp','82888325304','rgouldthorp1b@gmail.com',4,'2025-02-07 03:39:11','2025-03-07 21:13:44'),(49,'Rufus','Robichon','37895330694','rrobichon1c@umn.edu',4,'2024-08-28 06:16:48','2025-06-03 06:31:23'),(50,'Tamarra','Dziwisz','69723663570','tdziwisz1d@gmail.com',27,'2024-08-24 04:07:50','2025-03-30 06:56:26'),(51,'William','Killiam','62187565829','wkilliam1e@gmail.com',34,'2025-07-17 14:47:50','2025-05-07 00:50:52'),(52,'Anstice','Krugmann','80220930112','akrugmann1f@gmail.com',64,'2025-04-24 18:34:01','2025-04-28 12:41:55'),(53,'Ave','Rundle','57730280902','arundle1g@nifty.com',73,'2025-05-07 06:00:38','2025-03-29 21:24:44'),(54,'Wait','Chugg','41773344043','wchugg1h@gmail.com',45,'2025-08-11 05:25:16','2025-07-03 13:32:23'),(55,'Lenka','Loveitt','81476807911','lloveitt1i@gmail.com',45,'2025-07-10 07:11:36','2025-02-13 09:32:36'),(56,'Octavia','Carmo','66459031076','ocarmo1j@psu.edu',27,'2025-07-28 14:42:52','2025-05-02 18:51:48'),(57,'Kittie','Acklands','33850510650','kacklands1k@gmail.com',44,'2025-01-08 21:48:08','2025-01-25 23:29:09'),(58,'Anneliese','Jankovic','24568405083','ajankovic1l@gmail.com',68,'2025-02-06 22:49:25','2025-05-22 21:56:34'),(59,'Moe','Alliker','16986588087','malliker1m@gmail.com',75,'2025-07-05 03:04:38','2025-04-16 17:51:58'),(60,'Lovell','Josowitz','13159195261','ljosowitz1n@gmail.com',10,'2025-03-13 00:19:57','2025-07-14 05:53:20'),(61,'Witty','Labat','11939815446','wlabat1o@gmail.com',75,'2025-03-21 02:35:11','2025-03-22 21:50:24'),(62,'Maxi','Voules','51006887765','mvoules1p@gmail.com',75,'2024-10-07 06:29:18','2025-04-13 08:20:52'),(63,'Nicol','Dowrey','35464515028','ndowrey1q@bloomberg.com',58,'2025-07-17 17:58:33','2025-06-22 13:11:02'),(64,'Sherye','Accombe','42828649192','saccombe1r@gmail.com',79,'2024-10-24 05:29:37','2025-06-17 16:09:48'),(65,'Erhard','Lymbourne','37883195675','elymbourne1s@gmail.com',69,'2025-08-08 09:42:56','2025-07-20 01:50:55'),(66,'Claudius','Mariault','62199623492','cmariault1t@gmail.com',75,'2024-08-25 22:06:24','2025-03-16 17:50:42'),(67,'Malvin','Cockshoot','88220686692','mcockshoot1u@gmail.com',73,'2025-02-11 04:01:32','2025-08-02 10:57:35'),(68,'Warden','De la Harpe','16727801253','wdelaharpe1v@gmail.com',22,'2025-04-30 12:29:25','2025-05-26 04:02:27'),(69,'Laurens','Belone','36801062824','lbelone1w@gmail.com',49,'2024-12-04 16:49:30','2025-03-04 16:53:01'),(70,'Marcel','Wilbore','39794376695','mwilbore1x@gmail.com',30,'2025-01-04 06:59:55','2025-06-19 10:00:27'),(71,'Skipp','Tanswill','61464368652','stanswill1y@gmail.com',66,'2024-09-12 17:22:39','2025-04-12 02:04:49'),(72,'Magdalene','Mangion','85726821175','mmangion1z@gmail.com',57,'2025-02-22 03:24:30','2025-05-27 10:20:11'),(73,'Frankie','Veel','17857496619','fveel20@gmail.com',58,'2024-11-30 16:15:39','2025-07-08 18:27:45'),(74,'Jannel','Dobie','32094497114','jdobie21@gmail.com',36,'2024-11-05 14:40:56','2025-04-27 03:39:11'),(75,'Marvin','Pogue','56062742620','mpogue22@gmail.com',39,'2025-04-22 03:50:55','2025-02-15 15:59:54'),(76,'Lanna','Powrie','78242375856','lpowrie23@gmail.com',32,'2025-06-30 13:53:33','2025-02-07 22:27:58'),(77,'Chickie','Muggeridge','83130581445','cmuggeridge24@gmail.com',52,'2025-07-28 11:54:32','2025-04-09 08:06:39'),(78,'Irvin','Mackilpatrick','26589685188','imackilpatrick25@gmail.com',26,'2025-01-07 12:52:51','2025-04-01 16:01:26'),(79,'Kerrill','Wheatman','52665985111','kwheatman26@gmail.com',45,'2025-06-03 19:55:55','2025-07-07 22:13:34'),(80,'Stanly','Wiffler','39873653701','gmail.com',33,'2024-08-31 15:57:41','2025-04-20 14:23:25');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int NOT NULL AUTO_INCREMENT,
  `city_id` int NOT NULL,
  `contact_number` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`location_id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `location_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,1,'+639181234001'),(2,2,'+639181234002'),(3,3,'+639181234003'),(4,4,'+639181234004'),(5,5,'+639181234005'),(6,6,'+639181234006'),(7,7,'+639181234007'),(8,8,'+639181234008'),(9,9,'+639181234009'),(10,10,'+639181234010'),(11,11,'+639181234011'),(12,12,'+639181234012'),(13,13,'+639181234013'),(14,14,'+639181234014'),(15,15,'+639181234015'),(16,16,'+639181234016'),(17,17,'+639181234017'),(18,18,'+639181234018'),(19,19,'+639181234019'),(20,20,'+639181234020'),(21,21,'+639181234021'),(22,22,'+639181234022'),(23,23,'+639181234023'),(24,24,'+639181234024'),(25,25,'+639181234025'),(26,26,'+639181234026'),(27,27,'+639181234027'),(28,28,'+639181234028'),(29,29,'+639181234029'),(30,30,'+639181234030'),(31,31,'+639181234031'),(32,32,'+639181234032'),(33,33,'+639181234033'),(34,34,'+639181234034'),(35,35,'+639181234035'),(36,36,'+639181234036'),(37,37,'+639181234037'),(38,38,'+639181234038'),(39,39,'+639181234039'),(40,40,'+639181234040'),(41,41,'+639181234041'),(42,42,'+639181234042'),(43,43,'+639181234043'),(44,44,'+639181234044'),(45,45,'+639181234045'),(46,46,'+639181234046'),(47,47,'+639181234047'),(48,48,'+639181234048'),(49,49,'+639181234049'),(50,50,'+639181234050'),(51,51,'+639181234051'),(52,52,'+639181234052'),(53,53,'+639181234053'),(54,54,'+639181234054'),(55,55,'+639181234055'),(56,56,'+639181234056'),(57,57,'+639181234057'),(58,58,'+639181234058'),(59,59,'+639181234059'),(60,60,'+639181234060'),(61,61,'+639181234061'),(62,62,'+639181234062'),(63,63,'+639181234063'),(64,64,'+639181234064'),(65,65,'+639181234065'),(66,66,'+639181234066'),(67,67,'+639181234067'),(68,68,'+639181234068'),(69,69,'+639181234069'),(70,70,'+639181234070'),(71,71,'+639181234071'),(72,72,'+639181234072'),(73,73,'+639181234073'),(74,74,'+639181234074'),(75,75,'+639181234075'),(76,76,'+639181234076'),(77,77,'+639181234077'),(78,78,'+639181234078'),(79,79,'+639181234079'),(80,80,'+639181234080');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package` (
  `package_id` int NOT NULL AUTO_INCREMENT,
  `pickup_date` datetime DEFAULT NULL,
  `delivery_date` datetime DEFAULT NULL,
  `package_type_id` int NOT NULL,
  `weight` float DEFAULT NULL,
  `contents_description` varchar(255) DEFAULT NULL,
  `sender_id` int NOT NULL,
  `recipient_id` int NOT NULL,
  `courier_id` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`package_id`),
  KEY `package_type_id` (`package_type_id`),
  KEY `sender_id` (`sender_id`),
  KEY `recipient_id` (`recipient_id`),
  KEY `courier_id` (`courier_id`),
  CONSTRAINT `package_ibfk_1` FOREIGN KEY (`package_type_id`) REFERENCES `packagetype` (`package_type_id`),
  CONSTRAINT `package_ibfk_2` FOREIGN KEY (`sender_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `package_ibfk_3` FOREIGN KEY (`recipient_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `package_ibfk_4` FOREIGN KEY (`courier_id`) REFERENCES `courier` (`courier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (1,'2025-03-04 18:23:35','2025-07-22 21:18:18',3,4.27,'Duis mattis egestas metus.',67,69,35,'2024-09-05 16:13:43'),(2,'2025-08-04 04:19:46','2025-03-05 05:24:49',3,1.4,'Aliquam erat volutpat. In congue.',67,64,56,'2024-08-15 20:55:03'),(3,'2025-02-11 08:32:10','2025-02-23 09:17:02',6,2.43,'Phasellus sit amet erat.',17,79,72,'2024-09-10 08:17:01'),(4,'2025-01-12 21:26:56','2025-03-24 21:24:15',1,4.04,'Praesent blandit. Nam nulla.',35,52,16,'2024-09-07 19:14:33'),(5,'2024-08-27 10:49:03','2025-03-22 12:41:55',3,3.03,'Vivamus tortor.',4,23,74,'2024-08-21 22:26:35'),(6,'2025-02-08 17:31:31','2025-05-13 10:07:01',5,4.8,'Nulla ut erat id mauris vulputate elementum. Nullam varius.',45,55,55,'2024-08-12 16:56:59'),(7,'2024-10-22 17:08:08','2025-04-25 07:51:06',6,4.32,'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.',5,76,56,'2024-08-29 21:55:52'),(8,'2025-01-05 08:10:36','2025-06-09 13:43:13',3,2.76,'Vivamus tortor. Duis mattis egestas metus.',52,31,58,'2024-09-01 01:28:17'),(9,'2024-12-20 04:50:58','2025-07-07 09:46:04',2,4.55,'Proin interdum mauris non ligula pellentesque ultrices.',23,58,59,'2024-08-15 01:39:15'),(10,'2025-01-08 03:52:11','2025-03-22 06:32:09',4,4.03,'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.',63,76,65,'2024-08-27 23:36:39'),(11,'2025-02-07 05:19:06','2025-05-16 18:44:27',6,4.75,'Maecenas tincidunt lacus at velit.',70,77,76,'2024-08-27 12:18:54'),(12,'2025-06-02 01:34:35','2025-07-12 12:39:57',6,2.8,'Cras non velit nec nisi vulputate nonummy.',14,62,56,'2024-09-09 18:34:19'),(13,'2025-07-02 07:34:45','2025-07-21 19:18:41',2,4.64,'Morbi non quam nec dui luctus rutrum. Nulla tellus.',25,67,20,'2024-08-22 19:23:19'),(14,'2024-09-23 19:10:18','2025-03-02 20:35:01',3,1.68,'In eleifend quam a odio.',22,74,2,'2024-09-02 08:47:14'),(15,'2025-07-11 09:28:41','2025-04-30 21:47:05',6,4.23,'Nunc rhoncus dui vel sem. Sed sagittis.',8,27,58,'2024-08-30 04:51:08'),(16,'2024-10-13 07:02:46','2025-04-30 15:18:45',4,4.03,'In congue. Etiam justo.',10,68,24,'2024-08-28 01:59:06'),(17,'2025-03-03 03:35:18','2025-03-07 23:03:31',5,2.63,'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.',8,47,54,'2024-09-07 05:11:11'),(18,'2025-04-06 09:48:19','2025-03-19 09:29:34',5,3.82,'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.',80,67,71,'2024-08-18 08:53:41'),(19,'2024-10-11 20:34:26','2025-02-26 21:49:19',6,4.19,'In hac habitasse platea dictumst. Etiam faucibus cursus urna.',75,17,57,'2024-08-25 15:35:50'),(20,'2024-11-30 17:25:33','2025-02-23 04:54:22',5,3.04,'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.',33,79,6,'2024-09-11 12:43:58'),(21,'2025-07-14 08:30:30','2025-03-01 22:14:21',5,1.05,'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.',80,8,43,'2024-08-22 17:58:12'),(22,'2024-08-18 09:42:06','2025-03-30 14:48:19',1,1.53,'Morbi a ipsum. Integer a nibh.',6,43,27,'2024-08-20 06:29:52'),(23,'2024-08-12 00:20:14','2025-06-22 23:15:44',1,3.51,'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.',79,38,45,'2024-09-01 10:46:47'),(24,'2024-10-21 07:23:28','2025-03-15 19:33:28',4,1.91,'Proin risus.',44,27,20,'2024-08-27 03:15:56'),(25,'2024-12-03 08:53:55','2025-03-17 22:44:47',2,2.41,'Etiam justo. Etiam pretium iaculis justo.',78,16,18,'2024-08-15 16:00:41'),(26,'2025-07-13 07:57:23','2025-05-14 13:26:18',4,4.1,'Sed vel enim sit amet nunc viverra dapibus.',54,68,72,'2024-08-24 07:50:43'),(27,'2024-11-10 05:43:16','2025-02-13 12:02:19',5,4.56,'Maecenas ut massa quis augue luctus tincidunt.',8,38,12,'2024-09-07 21:25:30'),(28,'2025-03-10 00:49:34','2025-05-11 13:32:47',4,3.6,'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.',80,16,17,'2024-09-02 12:29:55'),(29,'2025-02-04 18:56:19','2025-01-27 12:18:34',3,3.32,'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.',4,56,42,'2024-09-02 19:37:28'),(30,'2025-05-09 07:49:47','2025-07-14 04:02:26',6,1.46,'Nulla ut erat id mauris vulputate elementum. Nullam varius.',1,37,41,'2024-09-06 01:42:05'),(31,'2025-03-08 10:16:34','2025-08-03 14:38:00',4,3.88,'Donec vitae nisi.',41,13,40,'2024-08-13 08:27:57'),(32,'2024-11-03 00:22:19','2025-07-12 12:51:22',2,2.25,'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.',57,44,77,'2024-08-24 05:32:41'),(33,'2024-11-02 07:40:47','2025-01-29 21:20:57',5,4.33,'In quis justo. Maecenas rhoncus aliquam lacus.',15,45,3,'2024-08-19 21:16:57'),(34,'2024-11-14 13:15:22','2025-06-25 08:31:44',2,3.5,'Duis bibendum. Morbi non quam nec dui luctus rutrum.',46,62,26,'2024-08-25 06:42:07'),(35,'2025-01-26 15:41:48','2025-03-06 17:11:54',3,1.55,'Morbi quis tortor id nulla ultrices aliquet.',32,21,30,'2024-09-08 12:53:55'),(36,'2024-10-23 21:19:28','2025-07-23 16:18:42',6,4.72,'Etiam pretium iaculis justo.',16,64,33,'2024-08-15 13:18:39'),(37,'2024-12-29 13:17:24','2025-04-12 02:18:53',4,3.34,'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.',61,29,77,'2024-08-29 22:07:08'),(38,'2024-10-18 19:15:33','2025-02-19 04:13:37',2,1.82,'In hac habitasse platea dictumst.',69,13,60,'2024-08-20 17:16:51'),(39,'2025-01-30 05:45:28','2025-02-19 10:35:35',6,1.62,'Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.',69,73,63,'2024-08-24 22:22:41'),(40,'2025-08-01 07:09:32','2025-06-29 22:56:01',4,3.17,'Duis mattis egestas metus. Aenean fermentum.',12,33,6,'2024-08-28 15:14:15'),(41,'2024-08-23 21:49:49','2025-05-25 10:52:23',5,4.57,'Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.',8,77,47,'2024-08-17 00:32:45'),(42,'2025-04-21 16:31:43','2025-02-17 04:06:21',3,1.58,'Proin at turpis a pede posuere nonummy. Integer non velit.',58,27,60,'2024-08-18 04:31:13'),(43,'2025-04-22 09:06:56','2025-03-21 16:03:43',4,3.4,'Vivamus tortor. Duis mattis egestas metus.',23,30,19,'2024-08-30 12:27:48'),(44,'2024-12-23 04:24:25','2025-03-06 23:42:22',3,4.32,'Ut at dolor quis odio consequat varius.',37,57,24,'2024-08-16 07:11:23'),(45,'2025-05-10 13:57:16','2025-04-07 08:50:24',1,3.23,'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.',18,51,1,'2024-09-07 19:29:42'),(46,'2025-02-08 10:12:24','2025-03-01 13:22:48',4,4.45,'Quisque ut erat. Curabitur gravida nisi at nibh.',51,47,48,'2024-09-09 00:29:07'),(47,'2024-10-04 22:58:36','2025-05-18 12:26:23',1,3.21,'Donec dapibus.',5,22,75,'2024-09-07 14:09:28'),(48,'2025-06-11 10:51:24','2025-02-15 14:53:48',1,3.6,'Curabitur at ipsum ac tellus semper interdum.',65,1,48,'2024-08-13 23:45:41'),(49,'2024-11-02 16:52:28','2025-03-21 11:30:46',6,3.03,'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.',73,54,61,'2024-08-31 13:18:44'),(50,'2024-11-02 16:01:32','2025-01-24 20:06:21',2,2.46,'Nulla tempus.',62,10,25,'2024-08-25 11:58:04'),(51,'2025-01-16 10:34:50','2025-06-22 14:34:39',6,4.34,'Integer ac neque. Duis bibendum.',17,61,3,'2024-08-18 05:05:08'),(52,'2025-04-30 15:38:33','2025-02-25 19:39:45',1,3.39,'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.',26,57,35,'2024-08-20 20:16:23'),(53,'2025-06-13 10:31:00','2025-03-28 13:23:41',5,3.94,'Nulla ut erat id mauris vulputate elementum.',23,29,17,'2024-09-05 14:00:28'),(54,'2025-07-15 19:17:15','2025-02-25 19:53:13',5,4.17,'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.',39,9,28,'2024-08-16 21:21:22'),(55,'2024-11-07 07:31:34','2025-04-12 11:29:22',6,2.44,'Nunc purus.',47,26,70,'2024-08-12 13:14:57'),(56,'2025-06-04 07:26:04','2025-07-03 13:26:09',1,3.44,'Integer ac leo.',16,26,24,'2024-09-10 05:52:04'),(57,'2024-11-17 07:12:31','2025-07-16 00:00:39',2,4.91,'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.',52,13,43,'2024-09-11 19:17:03'),(58,'2025-02-04 17:46:20','2025-06-16 12:03:36',1,1.19,'Quisque ut erat. Curabitur gravida nisi at nibh.',13,30,37,'2024-08-17 07:02:23'),(59,'2024-12-11 05:14:34','2025-07-14 02:41:02',4,2.28,'Fusce consequat.',5,47,64,'2024-09-09 00:01:10'),(60,'2025-07-25 09:12:17','2025-02-11 07:48:13',3,2.86,'Ut tellus. Nulla ut erat id mauris vulputate elementum.',30,76,14,'2024-08-20 00:24:33'),(61,'2024-10-14 02:53:32','2025-04-05 17:11:49',6,4.75,'Aenean lectus.',45,25,3,'2024-08-14 22:50:09'),(62,'2025-07-10 22:04:58','2025-05-29 11:02:48',6,1.72,'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.',8,48,38,'2024-08-28 00:34:11'),(63,'2024-09-18 16:31:19','2025-03-02 22:48:54',2,1.9,'Nunc purus. Phasellus in felis.',10,10,69,'2024-08-25 14:34:37'),(64,'2025-04-14 12:51:19','2025-01-30 14:42:21',4,4.38,'Praesent blandit.',57,14,22,'2024-08-30 21:58:02'),(65,'2025-07-28 18:31:22','2025-02-22 06:02:54',5,4.8,'Cras in purus eu magna vulputate luctus.',58,56,50,'2024-09-11 02:38:30'),(66,'2024-08-16 11:16:40','2025-02-04 11:43:28',5,3.46,'Cras in purus eu magna vulputate luctus.',46,43,63,'2024-09-10 11:20:47'),(67,'2024-10-15 17:00:53','2025-07-22 10:37:19',3,4.62,'Etiam pretium iaculis justo.',55,52,68,'2024-09-08 03:15:39'),(68,'2025-03-01 13:43:45','2025-03-06 17:57:17',2,1.57,'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.',1,5,11,'2024-08-13 21:07:54'),(69,'2024-10-12 05:02:41','2025-01-25 15:06:03',3,4.71,'Etiam pretium iaculis justo. In hac habitasse platea dictumst.',24,54,65,'2024-08-26 23:36:11'),(70,'2025-07-02 19:48:24','2025-07-02 15:47:03',6,4.26,'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.',48,52,65,'2024-08-17 04:57:33'),(71,'2025-06-12 20:01:10','2025-03-28 07:01:02',6,3.54,'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.',4,31,53,'2024-08-14 05:05:09'),(72,'2024-12-06 11:49:59','2025-07-16 01:21:12',1,2.81,'Duis bibendum. Morbi non quam nec dui luctus rutrum.',77,49,55,'2024-09-05 17:28:15'),(73,'2025-03-30 13:25:43','2025-03-24 22:33:27',4,2.22,'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.',48,1,42,'2024-09-08 00:34:22'),(74,'2024-11-29 06:14:20','2025-04-29 19:58:49',6,4.44,'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula.',40,60,67,'2024-09-10 21:36:26'),(75,'2025-03-04 14:49:21','2025-02-27 07:21:36',6,3.27,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.',20,75,47,'2024-08-16 02:44:53'),(76,'2025-04-29 18:24:34','2025-06-15 22:41:57',6,4.82,'Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',31,14,36,'2024-08-21 03:51:40'),(77,'2025-01-20 03:01:11','2025-02-21 03:57:33',1,2.22,'Quisque ut erat. Curabitur gravida nisi at nibh.',43,72,67,'2024-09-03 02:42:32'),(78,'2024-11-26 23:01:38','2025-02-03 05:28:07',3,4.76,'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.',62,65,44,'2024-08-25 01:06:17'),(79,'2025-03-06 17:26:31','2025-07-09 22:21:28',1,4.11,'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.',8,30,66,'2024-08-28 13:19:48'),(80,'2025-02-07 16:16:27','2025-03-04 12:31:19',2,4.39,'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.',62,20,47,'2024-09-11 12:06:11'),(81,'2025-02-07 16:16:27','2025-03-04 12:31:19',1,4.2,'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.',23,68,11,'2025-08-12 21:35:16');
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packagestatus`
--

DROP TABLE IF EXISTS `packagestatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packagestatus` (
  `package_status_id` int NOT NULL AUTO_INCREMENT,
  `status_name` varchar(50) NOT NULL,
  PRIMARY KEY (`package_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packagestatus`
--

LOCK TABLES `packagestatus` WRITE;
/*!40000 ALTER TABLE `packagestatus` DISABLE KEYS */;
INSERT INTO `packagestatus` VALUES (1,'PENDING'),(2,'ACCEPTED'),(3,'REJECTED'),(4,'LOADED TO CONTAINER'),(5,'IN TRANSIT'),(6,'IN CUSTOMS PROCESSING'),(7,'HANDED TO TRUCKING SERVICES'),(8,'OUT FOR DELIVERY'),(9,'DELIVERED'),(10,'PACKAGE LOST'),(11,'FAILED DELIVERY');
/*!40000 ALTER TABLE `packagestatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packagetype`
--

DROP TABLE IF EXISTS `packagetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packagetype` (
  `package_type_id` int NOT NULL AUTO_INCREMENT,
  `classification_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`package_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packagetype`
--

LOCK TABLES `packagetype` WRITE;
/*!40000 ALTER TABLE `packagetype` DISABLE KEYS */;
INSERT INTO `packagetype` VALUES (1,'GENERAL'),(2,'DANGEROUS'),(3,'AWKWARD'),(4,'REEFER'),(5,'REEFER DANGEROUS'),(6,'AWKWARD DANGEROUS');
/*!40000 ALTER TABLE `packagetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trackingevent`
--

DROP TABLE IF EXISTS `trackingevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trackingevent` (
  `tracking_event_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `package_status_id` int NOT NULL,
  `package_id` int NOT NULL,
  `location_id` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`tracking_event_id`),
  KEY `package_status_id` (`package_status_id`),
  KEY `package_id` (`package_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `trackingevent_ibfk_1` FOREIGN KEY (`package_status_id`) REFERENCES `packagestatus` (`package_status_id`),
  CONSTRAINT `trackingevent_ibfk_2` FOREIGN KEY (`package_id`) REFERENCES `package` (`package_id`),
  CONSTRAINT `trackingevent_ibfk_3` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackingevent`
--

LOCK TABLES `trackingevent` WRITE;
/*!40000 ALTER TABLE `trackingevent` DISABLE KEYS */;
INSERT INTO `trackingevent` VALUES (1,'Package order has been created and is awaiting processing',1,23,77,'2025-08-12 16:30:32',NULL),(2,'Package has been accepted at the origin facility',2,45,18,'2025-08-12 16:30:32',NULL),(3,'Package was rejected due to incomplete documentation',3,7,59,'2025-08-12 16:30:32',NULL),(4,'Package loaded into shipping container at port',4,32,44,'2025-08-12 16:30:32',NULL),(5,'Package is currently in transit to the destination',5,68,36,'2025-08-12 16:30:32',NULL),(6,'Package is undergoing customs inspection',6,56,12,'2025-08-12 16:30:32',NULL),(7,'Package handed over to trucking company for local delivery',7,11,73,'2025-08-12 16:30:32',NULL),(8,'Package is out for delivery to the recipient',8,78,5,'2025-08-12 16:30:32',NULL),(9,'Package has been successfully delivered to the recipient',9,42,64,'2025-08-12 16:30:32',NULL),(10,'Package reported lost during transit',10,14,40,'2025-08-12 16:30:32',NULL),(11,'Package order has been created and is awaiting processing',1,66,19,'2025-08-12 16:30:32',NULL),(12,'Package has been accepted at the origin facility',2,58,8,'2025-08-12 16:30:32',NULL),(13,'Package was rejected due to incomplete documentation',3,25,55,'2025-08-12 16:30:32',NULL),(14,'Package loaded into shipping container at port',4,12,39,'2025-08-12 16:30:32',NULL),(15,'Package is currently in transit to the destination',5,37,4,'2025-08-12 16:30:32',NULL),(16,'Package is undergoing customs inspection',6,20,67,'2025-08-12 16:30:32',NULL),(17,'Package handed over to trucking company for local delivery',7,73,9,'2025-08-12 16:30:32',NULL),(18,'Package is out for delivery to the recipient',8,18,28,'2025-08-12 16:30:32',NULL),(19,'Package has been successfully delivered to the recipient',9,5,45,'2025-08-12 16:30:32',NULL),(20,'Package reported lost during transit',10,27,61,'2025-08-12 16:30:32',NULL),(21,'Package order has been created and is awaiting processing',1,80,16,'2025-08-12 16:30:32',NULL),(22,'Package has been accepted at the origin facility',2,31,78,'2025-08-12 16:30:32',NULL),(23,'Package was rejected due to incomplete documentation',3,41,2,'2025-08-12 16:30:32',NULL),(24,'Package loaded into shipping container at port',4,15,33,'2025-08-12 16:30:32',NULL),(25,'Package is currently in transit to the destination',5,77,70,'2025-08-12 16:30:32',NULL),(26,'Package is undergoing customs inspection',6,35,6,'2025-08-12 16:30:32',NULL),(27,'Package handed over to trucking company for local delivery',7,3,50,'2025-08-12 16:30:32',NULL),(28,'Package is out for delivery to the recipient',8,48,29,'2025-08-12 16:30:32',NULL),(29,'Package has been successfully delivered to the recipient',9,50,25,'2025-08-12 16:30:32',NULL),(30,'Package reported lost during transit',10,64,11,'2025-08-12 16:30:32',NULL),(31,'Package order has been created and is awaiting processing',1,17,46,'2025-08-12 16:30:32',NULL),(32,'Package has been accepted at the origin facility',2,4,23,'2025-08-12 16:30:32',NULL),(33,'Package was rejected due to incomplete documentation',3,9,1,'2025-08-12 16:30:32',NULL),(34,'Package loaded into shipping container at port',4,29,71,'2025-08-12 16:30:32',NULL),(35,'Package is currently in transit to the destination',5,54,63,'2025-08-12 16:30:32',NULL),(36,'Package is undergoing customs inspection',6,63,31,'2025-08-12 16:30:32',NULL),(37,'Package handed over to trucking company for local delivery',7,13,60,'2025-08-12 16:30:32',NULL),(38,'Package is out for delivery to the recipient',8,36,32,'2025-08-12 16:30:32',NULL),(39,'Package has been successfully delivered to the recipient',9,22,75,'2025-08-12 16:30:32',NULL),(40,'Package reported lost during transit',10,47,15,'2025-08-12 16:30:32',NULL),(41,'Package order has been created and is awaiting processing',1,38,26,'2025-08-12 16:30:32',NULL),(42,'Package has been accepted at the origin facility',2,39,54,'2025-08-12 16:30:32',NULL),(43,'Package was rejected due to incomplete documentation',3,71,3,'2025-08-12 16:30:32',NULL),(44,'Package loaded into shipping container at port',4,75,27,'2025-08-12 16:30:32',NULL),(45,'Package is currently in transit to the destination',5,55,41,'2025-08-12 16:30:32',NULL),(46,'Package is undergoing customs inspection',6,19,68,'2025-08-12 16:30:32',NULL),(47,'Package handed over to trucking company for local delivery',7,49,42,'2025-08-12 16:30:32',NULL),(48,'Package is out for delivery to the recipient',8,40,17,'2025-08-12 16:30:32',NULL),(49,'Package has been successfully delivered to the recipient',9,26,79,'2025-08-12 16:30:32',NULL),(50,'Package reported lost during transit',10,28,58,'2025-08-12 16:30:32',NULL),(51,'Package order has been created and is awaiting processing',1,60,52,'2025-08-12 16:30:32',NULL),(52,'Package has been accepted at the origin facility',2,46,35,'2025-08-12 16:30:32',NULL),(53,'Package was rejected due to incomplete documentation',3,24,14,'2025-08-12 16:30:32',NULL),(54,'Package loaded into shipping container at port',4,79,22,'2025-08-12 16:30:32',NULL),(55,'Package is currently in transit to the destination',5,43,13,'2025-08-12 16:30:32',NULL),(56,'Package is undergoing customs inspection',6,52,66,'2025-08-12 16:30:32',NULL),(57,'Package handed over to trucking company for local delivery',7,53,49,'2025-08-12 16:30:32',NULL),(58,'Package is out for delivery to the recipient',8,1,38,'2025-08-12 16:30:32',NULL),(59,'Package has been successfully delivered to the recipient',9,10,24,'2025-08-12 16:30:32',NULL),(60,'Package reported lost during transit',10,34,72,'2025-08-12 16:30:32',NULL),(61,'Package order has been created and is awaiting processing',1,8,51,'2025-08-12 16:30:32',NULL),(62,'Package has been accepted at the origin facility',2,2,62,'2025-08-12 16:30:32',NULL),(63,'Package was rejected due to incomplete documentation',3,70,30,'2025-08-12 16:30:32',NULL),(64,'Package loaded into shipping container at port',4,6,65,'2025-08-12 16:30:32',NULL),(65,'Package is currently in transit to the destination',5,59,76,'2025-08-12 16:30:32',NULL),(66,'Package is undergoing customs inspection',6,30,48,'2025-08-12 16:30:32',NULL),(67,'Package handed over to trucking company for local delivery',7,16,43,'2025-08-12 16:30:32',NULL),(68,'Package is out for delivery to the recipient',8,61,47,'2025-08-12 16:30:32',NULL),(69,'Package has been successfully delivered to the recipient',9,33,20,'2025-08-12 16:30:32',NULL),(70,'Package reported lost during transit',10,21,21,'2025-08-12 16:30:32',NULL),(71,'Package order has been created and is awaiting processing',1,74,37,'2025-08-12 16:30:32',NULL),(72,'Package has been accepted at the origin facility',2,65,74,'2025-08-12 16:30:32',NULL),(73,'Package was rejected due to incomplete documentation',3,44,57,'2025-08-12 16:30:32',NULL),(74,'Package loaded into shipping container at port',4,57,56,'2025-08-12 16:30:32',NULL),(75,'Package is currently in transit to the destination',5,72,7,'2025-08-12 16:30:32',NULL),(76,'Package is undergoing customs inspection',6,67,80,'2025-08-12 16:30:32',NULL),(77,'Package handed over to trucking company for local delivery',7,62,53,'2025-08-12 16:30:32',NULL),(78,'Package is out for delivery to the recipient',8,51,34,'2025-08-12 16:30:32',NULL),(79,'Package has been successfully delivered to the recipient',9,69,10,'2025-08-12 16:30:32',NULL),(80,'Package reported lost during transit',10,76,69,'2025-08-12 16:30:32',NULL),(81,'Recipient did not show during delivery',11,23,77,'2025-08-13 16:30:32',NULL),(82,'Package has been successfully delivered to the recipient',9,45,18,'2025-08-14 16:30:32',NULL),(83,'Package has been successfully delivered to the recipient',9,68,36,'2025-08-14 16:30:32',NULL),(84,'Package has been successfully delivered to the recipient',9,81,17,'2025-08-14 16:30:32',NULL);
/*!40000 ALTER TABLE `trackingevent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-13 11:33:05
