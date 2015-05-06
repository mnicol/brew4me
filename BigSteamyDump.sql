-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: brew4me
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `beer`
--

DROP TABLE IF EXISTS `beer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beer` (
  `abv` float DEFAULT NULL,
  `beer_name` varchar(45) NOT NULL,
  `brewery_name` varchar(45) NOT NULL,
  `style` varchar(45) DEFAULT NULL,
  `color` int(11) DEFAULT NULL,
  `mouthfeel` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`beer_name`,`brewery_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table containing every different beer';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beer`
--

LOCK TABLES `beer` WRITE;
/*!40000 ALTER TABLE `beer` DISABLE KEYS */;
INSERT INTO `beer` VALUES (6.7,'Ambergeddon','Ale Asylum','ale',14,'medium',9),(7.4,'Bedlam! IPA','Ale Asylum','ale',10,'medium',10),(7,'Big Slick','Ale Asylum','ale',40,'heavy',12),(5.75,'Bitter Woman IPA','Tyranena','ale',13,'medium',10),(6.5,'Dark Voyage','Capital Brewery','ale',40,'heavy',11),(4.7,'Demento','Ale Asylum','ale',6,'light',10),(5.2,'Fat Tire','New Belgium','Ale',3,'Light',4),(5.6,'Ghost Ship','Capital Brewery','ale',5,'medium',9),(5.25,'Headless Man Amber Alt','Tyranena','ale',17,'medium',9),(5.7,'Hopalicious','Ale Asylum','ale',20,'heavy',9),(4.2,'Island Wheat','Capital Brewery','ale',2,'light',8),(5.5,'Madtown Nutbrown','Ale Asylum','ale',35,'heavy',11),(5,'Moon Man','New Glarus Brewing Company','ale',9,'heavy',10),(6.2,'Mutiny IPA','Capital Brewery','ale',18,'heavy',10),(60,'Nacho Average Beer','Mouthfeel INC','Other',20,'Light',40),(5.75,'Rocky\'s Revenge','Tyranena','ale',33,'heavy',10),(4.8,'Spotted Cow','New Glarus Brewing Company','ale',12,'light',8),(5.2,'Supper Club','Capital Brewery','ale',6,'medium',8),(5,'Three Beachers Blonde Honey','Tyranena','ale',9,'light',8),(9.8,'Tripel Nova','Ale Asylum','ale',12,'medium',12),(5,'Two Women','New Glarus Brewing Company','lager',22,'medium',9),(6,'Unshadowed','Ale Asylum','ale',4,'light',10),(5.2,'Wisconsin Amber','Capital Brewery','lager',15,'medium',8);
/*!40000 ALTER TABLE `beer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beerflavors`
--

DROP TABLE IF EXISTS `beerflavors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beerflavors` (
  `beer_flavor` varchar(45) NOT NULL,
  `beer_flavor_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`beer_flavor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table containing flavors that different beers have';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beerflavors`
--

LOCK TABLES `beerflavors` WRITE;
/*!40000 ALTER TABLE `beerflavors` DISABLE KEYS */;
INSERT INTO `beerflavors` VALUES ('balanced','several equal flavors'),('bitter','lots of bitterness'),('bright','lights up your mouth!'),('bulbous','of or relating to bulbs'),('caramel','sweet and silky'),('creamy','silky and smooth'),('crisp','lots of carbonation'),('dilapidated','kind of slantwise'),('fresh','fresh 2 death'),('fruity','it\'s got fruit!'),('full','contains max flavor'),('hoppy','buncha hops'),('malty','thick, containing malt flavor'),('toasty','tastes like toast'),('wheat','contains wheat flavor'),('zesty nacho','the cheesiest');
/*!40000 ALTER TABLE `beerflavors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beerhas`
--

DROP TABLE IF EXISTS `beerhas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beerhas` (
  `flavor` varchar(45) NOT NULL,
  `beername` varchar(45) NOT NULL,
  `breweryname` varchar(45) NOT NULL,
  PRIMARY KEY (`flavor`,`beername`,`breweryname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beerhas`
--

LOCK TABLES `beerhas` WRITE;
/*!40000 ALTER TABLE `beerhas` DISABLE KEYS */;
INSERT INTO `beerhas` VALUES ('balanced','Supper Club','Capital Brewery'),('balanced','Two Women','New Glarus Brewing Company'),('bitter','Bedlam! IPA','Ale Asylum'),('bitter','Mutiny IPA','Capital Brewery'),('bright','Three Beachers Blonde Honey','Tyranena'),('bulbous','Nacho Average Beer','Mouthfeel INC'),('caramel','Mercy','Ale Asylum'),('creamy','Big Slick','Ale Asylum'),('creamy','Dark Voyage','Capital Brewery'),('creamy','Madtown Nutbrown','Ale Asylum'),('creamy','Rocky\'s Revenge','Tyranena'),('crisp','Ambergeddon','Ale Asylum'),('crisp','Three Beachers Blonde Honey','Tyranena'),('dilapidated','Nacho Average Beer','Mouthfeel INC'),('fresh','Fat Tire','New Belgium'),('fruity','Island Wheat','Capital Brewery'),('fruity','Spotted Cow','New Glarus Brewing Company'),('fruity','Unshadowed','Ale Asylum'),('full','Ambergeddon','Ale Asylum'),('full','Dark Voyage','Capital Brewery'),('full','Headless Man Amber Alt','Tyranena'),('full','Hopalicious','Ale Asylum'),('full','Madtown Nutbrown','Ale Asylum'),('full','Moon Man','New Glarus Brewing Company'),('full','Wisconsin Amber','Capital Brewery'),('hoppy','Bedlam! IPA','Ale Asylum'),('hoppy','Bitter Woman IPA','Tyranena'),('hoppy','Demento','Ale Asylum'),('hoppy','Fat Tire','New Belgium'),('hoppy','Ghost Ship','Capital Brewery'),('hoppy','Hopalicious','Ale Asylum'),('hoppy','Moon Man','New Glarus Brewing Company'),('hoppy','Mutiny IPA','Capital Brewery'),('malty','Ambergeddon','Ale Asylum'),('malty','Tripel Nova','Ale Asylum'),('malty','Wisconsin Amber','Capital Brewery'),('toasty','Fat Tire','New Belgium'),('wheat','Island Wheat','Capital Brewery'),('wheat','Spotted Cow','New Glarus Brewing Company'),('zesty nacho','Nacho Average Beer','Mouthfeel INC');
/*!40000 ALTER TABLE `beerhas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beerrates`
--

DROP TABLE IF EXISTS `beerrates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beerrates` (
  `person_email` varchar(45) NOT NULL,
  `beer_rating` int(11) DEFAULT NULL,
  `beer_name` varchar(45) NOT NULL,
  `brewery_name` varchar(45) NOT NULL,
  PRIMARY KEY (`person_email`,`beer_name`,`brewery_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table containing the beers that a person has rated';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beerrates`
--

LOCK TABLES `beerrates` WRITE;
/*!40000 ALTER TABLE `beerrates` DISABLE KEYS */;
INSERT INTO `beerrates` VALUES ('mnicol@wisc.edu',5,'Spotted Cow','New Glarus Brewing Company');
/*!40000 ALTER TABLE `beerrates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brewery`
--

DROP TABLE IF EXISTS `brewery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brewery` (
  `brewery_name` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state_providence` varchar(45) DEFAULT NULL,
  `brewery_size` int(11) DEFAULT NULL,
  `established` int(11) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`brewery_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table containing breweries that brew beers';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brewery`
--

LOCK TABLES `brewery` WRITE;
/*!40000 ALTER TABLE `brewery` DISABLE KEYS */;
INSERT INTO `brewery` VALUES ('Ale Asylum','Madison','Wisconsin',0,2006,'United States'),('Capital Brewery','Middleton','Wisconsin',0,1984,'United States'),('Mouthfeel INC','Hopsylvania','Nebraska',0,2015,NULL),('New Belgium','Fort Collins','Colorado',0,1989,NULL),('New Glarus Brewing Company','New Glarus','Wisconsin',0,1993,'United States'),('Tyranena','Lake Mills','Wisconsin',0,1998,'United States');
/*!40000 ALTER TABLE `brewery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `email` varchar(254) NOT NULL DEFAULT '',
  `name` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `state_providence` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table containing people that make up the users of the database';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('11111','11111','11111','11111','null','11111'),('1111111111aaaa','1213123','123123','123123','1231231','1231234'),('1111111111adfdasf','asdfasdf','asdfadf','adsfasdfa','asdfasdf','adfasdfa'),('12345','12345','12345','12345','null','12345'),('1a1a1a','1a1a1a','1a1a1a','1a1a1a','1a1a1a','1a1a1a'),('222222','222222','222222222','222222222','2222222222','222222222'),('33333','333333333','33333333','33333333','3333333','333333'),('@@@@@@@@@@@@@@','asdfadsf','hh','hh','hh','hh'),('a@wisc.edu','Phil Mitummy','Paytug','9582141582513','Andijan','Uzbekistan'),('aabaker4@wisc.edu','Amy Baker','Seattle','mattisawebsitemakergenius','Washington','United States'),('adfa','asdfa','asdf','asdf','null','qer'),('adfasdfa','adfafd','asdfasdf','asdfasdf','asdfadf','asdfafd'),('ajax','ajax','ajax','ajax','null','ajax'),('ajaxa','ajax','ajax','ajax','null','ajax'),('asdfadf','asdfasdfa','asfdasdf','asdfasdf','asdfasdf','adfasdfa'),('asdfsdf@d','asdfa','ajax','a','ajax','adfasdfa'),('asdgadsfa','asdfadf','asdfaf','asdf','asdfasfd','asdfaf'),('asdgasdf@hotmail.com','Some Guy','1234567','Madison','Wisconsin','United States'),('c@wisc.edu','Richard Smith','Birmingham','l33thaxor','Alabama','United States'),('d@wisc.edu','Conway Jelly','Glassboro','fannypackfan','New Jersey','United States'),('e@wisc.edu','Frank Hulu','New York','flyingsquirrel','New York','United States'),('eaton@cs.wisc.edu','Benjamin Eaton','Madison','1234','Wisconsin','United States'),('email','name','city','password','null','country'),('email1','name1','city1','password1','state1','country1'),('f@wisc.edu','Yao Wang','Atlanta','idontknow','Georgia','United States'),('fgdss','dfd','s','ss','as','d'),('g@wisc.edu','Datamine Wama','Boulder','lolpassword','Colorado','United States'),('guest','Guest','None','Guest','None','United States'),('h@wisc.edu','Ifrit Anon','Sheridan','gogogadgetpencil1','Wyoming','United States'),('i@wisc.edu','Jenny Jameson','Los Angeles','thecakeisalie0923','California','United States'),('j@wisc.edu','Helen Hamly','Dallas','allyourbase1234','Texas','United States'),('jcollingwood@wisc.edu','Joel Collingwood','Madison','poop','Wisconsin','United States'),('k@wisc.edu','Tammy Two','Portland','dreamofthe90s','Oregon','United States'),('l@wisc.edu','Litheal Minrathen','Seattle','whyisitrainingQQ','Washington','United States'),('m@wisc.edu','Horris Fawn','Great Falls','MyKneesHurt11','Montana','United States'),('mnicol@wisc.edu','Matthew Nicol','Anchorage','tomcat','Alaska','United States'),('n@wisc.edu','Ian Toply','Oklahoma City','WhereAmI356','Oklahoma','United States'),('newEmail@email.com','email man','mailtime','Madison','Wisconsin','United States'),('newUser','name','city','pass','s','c'),('null','null','null','null','null','null'),('o@wisc.edu','Kathryn Cooper','Lincoln','BeardsRock69','Nebraska','United States'),('p@wisc.edu','BO Jackson','Starkville','WintersComingD00m','Mississippi','United States'),('q@wisc.edu','Andrew Ryan','Louisville','BaseballBat123','Kentucky','United States'),('r@wisc.edu','Kim Kerry','Nashville','CountryStarInTraining1993','Tennesee','United States'),('rcmoy@wisc.edu','Ryan Moy','Madison','roflcopter','Wisconsin','United States'),('s@wisc.edu','Cindy Johnson','Portland','FEMALEPOWER9000','Maine','United States'),('semin@wisc.edu','Arseny Semin','Madison','m0u1hf331','Wisconsin','United States'),('t@wisc.edu','Micky Mouse','Providence','TheOriginalMM3456','Rhode Island','United States'),('tatatatata','atatatat','atat','atata','atat','atatat'),('temp@1.com','temp','tempPass','tempville','null','tempia'),('test','test','test','test','null','test'),('test123','asdf','y','test','y','d'),('test@wisc.edu','test1','test2','test3','test4','test5'),('test@wisc.eduE','test1','test','T','test','test'),('tester','1','1','1','1','1'),('testert','test','testt','t','test','test'),('testertt','test1t','testt','t','test','test'),('testing','john','Madison','','Wisconsin','United States'),('testsetsetset','tttt','tttt','tttt','tttt','tttt'),('testtest@wisc.edu1','Matthew Nicol','Madison','','Wisconsin','United States'),('testtestsete','asdfa','f','f','f','f'),('testUser','tester','testville','tester','testia','testopia'),('testuser@gmail.com','test user','password','Madison','Wisconsin','United States'),('trololol@aol.com','Troll','trollin','Madison','Wisconsin','United States'),('u@wisc.edu','Ronald McDonald','Chicago','DeepDish4Lyfe83','Illinois','United States'),('v@wisc.edu','Hans Allova','St. Paul','lLoveLakes235','Minnesota','United States'),('w@wisc.edu','Timothy Wert','Ann Arbor','SpArTaInSF@n31','Michigan','United States'),('x@wisc.edu','Ping Pong','De Mois','ItsCalledTableTennis42','Iowa','United States');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `email` varchar(254) NOT NULL DEFAULT '',
  `role_name` varchar(15) NOT NULL,
  PRIMARY KEY (`email`,`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('11111','user'),('1111111111aaaa','user'),('1111111111adfdasf','user'),('12345','user'),('1a1a1a','user'),('222222','user'),('33333','user'),('@@@@@@@@@@@@@@','user'),('a@wisc.edu','user'),('aabaker4@wisc.edu','user'),('adfa','user'),('adfasdfa','user'),('ajax','user'),('ajaxa','user'),('asdfadf','user'),('asdfsdf@d','user'),('asdgadsfa','user'),('asdgasdf@hotmail.com','user'),('c@wisc.edu','user'),('d@wisc.edu','user'),('e@wisc.edu','user'),('eaton@cs.wisc.edu','user'),('email','user'),('email1','user'),('f@wisc.edu','user'),('fgdss','user'),('g@wisc.edu','user'),('guest','user'),('h@wisc.edu','user'),('i@wisc.edu','user'),('j@wisc.edu','user'),('jcollingwood@wisc.edu','user'),('k@wisc.edu','user'),('l@wisc.edu','user'),('m@wisc.edu','user'),('mnicol@wisc.edu','admin'),('mnicol@wisc.edu','user'),('n@wisc.edu','user'),('newEmail@email.com','user'),('newUser','user'),('null','user'),('o@wisc.edu','user'),('p@wisc.edu','user'),('q@wisc.edu','user'),('r@wisc.edu','user'),('rcmoy@wisc.edu','user'),('s@wisc.edu','user'),('semin@wisc.edu','user'),('t@wisc.edu','user'),('tatatatata','user'),('temp@1.com','user'),('test','user'),('test123','user'),('test@wisc.edu','user'),('test@wisc.eduE','user'),('tester','user'),('testert','user'),('testertt','user'),('testing','user'),('testsetsetset','user'),('testtest@wisc.edu1','user'),('testtestsete','user'),('testUser','user'),('testuser@gmail.com','user'),('trololol@aol.com','user'),('u@wisc.edu','user'),('v@wisc.edu','user'),('w@wisc.edu','user'),('x@wisc.edu','user');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vineyard`
--

DROP TABLE IF EXISTS `vineyard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vineyard` (
  `name` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state_providence` varchar(45) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `established` int(11) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table containing vineyards that make beers';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vineyard`
--

LOCK TABLES `vineyard` WRITE;
/*!40000 ALTER TABLE `vineyard` DISABLE KEYS */;
/*!40000 ALTER TABLE `vineyard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wine`
--

DROP TABLE IF EXISTS `wine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wine` (
  `price` float DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `style` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `vineyard` varchar(45) NOT NULL,
  `abv` float DEFAULT NULL,
  PRIMARY KEY (`name`,`vineyard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table containing different wines';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wine`
--

LOCK TABLES `wine` WRITE;
/*!40000 ALTER TABLE `wine` DISABLE KEYS */;
/*!40000 ALTER TABLE `wine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wineflavors`
--

DROP TABLE IF EXISTS `wineflavors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wineflavors` (
  `wineflavor` varchar(45) NOT NULL,
  `wineflavor_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`wineflavor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='flavors that different wines have';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wineflavors`
--

LOCK TABLES `wineflavors` WRITE;
/*!40000 ALTER TABLE `wineflavors` DISABLE KEYS */;
/*!40000 ALTER TABLE `wineflavors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `winehas`
--

DROP TABLE IF EXISTS `winehas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `winehas` (
  `flavor` varchar(45) NOT NULL,
  `wine_name` varchar(45) NOT NULL,
  `vineyard_name` varchar(45) NOT NULL,
  PRIMARY KEY (`flavor`,`wine_name`,`vineyard_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `winehas`
--

LOCK TABLES `winehas` WRITE;
/*!40000 ALTER TABLE `winehas` DISABLE KEYS */;
/*!40000 ALTER TABLE `winehas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `winerates`
--

DROP TABLE IF EXISTS `winerates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `winerates` (
  `person_email` varchar(45) NOT NULL,
  `wine_rating` int(11) DEFAULT NULL,
  `wine_name` varchar(45) NOT NULL,
  `wine_vineyard` varchar(45) NOT NULL,
  PRIMARY KEY (`person_email`,`wine_name`,`wine_vineyard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table containing the beers that a person has rated';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `winerates`
--

LOCK TABLES `winerates` WRITE;
/*!40000 ALTER TABLE `winerates` DISABLE KEYS */;
/*!40000 ALTER TABLE `winerates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-05 22:51:16
