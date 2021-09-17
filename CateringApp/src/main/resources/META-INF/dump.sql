*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `diet`
--

DROP TABLE IF EXISTS `diet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diet` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `amount_of_acquirer` bigint DEFAULT NULL,
                        `description` text COLLATE utf8mb4_unicode_ci,
                        `diet_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `price` double DEFAULT NULL,
                        `total_amount_of_acquirer` bigint DEFAULT NULL,
                        `length_whole_plan_id` bigint DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FKtqou4xu6yxd0p7qdn1f1b4pst` (`length_whole_plan_id`),
                        CONSTRAINT `FKtqou4xu6yxd0p7qdn1f1b4pst` FOREIGN KEY (`length_whole_plan_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diet`
--

LOCK TABLES `diet` WRITE;
/*!40000 ALTER TABLE `diet` DISABLE KEYS */;
INSERT INTO `diet` VALUES (1,NULL,'Made rationally for those who rates healthy lifestyle','Vegan Diet',38.6,NULL,NULL),(2,NULL,'Reductive diet, the best choice for mens wanted to lose weight','Slimming Diet',35.6,NULL,NULL),(3,NULL,'Diet created for people who do sports','Athletic Diet',41.6,NULL,NULL),(4,NULL,'Restrictive diet relied on cut down on carbohydrate','Ketogenic Diet',36.8,NULL,NULL),(5,NULL,'Classic tastes, diverse ingredients - no limits','Classic Diet',42.8,NULL,NULL);
/*!40000 ALTER TABLE `diet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `created_on` date DEFAULT NULL,
                         `email` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `password` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `username` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2021-09-06','tense@gmmm.com','$2a$10$1J/yZqTo1tp/tGlG4SP1UuapsJEUnwFMYdXGb2eiQzKfpEeFqU06i','ROLE_ADMIN','Tense'),(2,'2021-09-06','spike13@gmmm.com','$2a$10$ttjiWv36P/eJAxu4GHQYBOO.9iRWkhLoVUMiM0FpCK23UkzCSPuqe','ROLE_USER','Spike');
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

