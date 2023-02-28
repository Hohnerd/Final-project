/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 8.0.25-0ubuntu0.20.04.1 : Database - animals
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`animals` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

/*Table structure for table `animal` */

DROP TABLE IF EXISTS `animal`;

CREATE TABLE `animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `typ` varchar(50) CHARACTER SET cp1251 COLLATE cp1251_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `work` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `animal` */

insert  into `animal`(`id`,`typ`,`name`,`work`,`birthday`) values (1,'собаки','шарик','охраняет','2023-02-01'),(2,'кошки','мурзик','ловит мышей','2022-01-01'),(3,'хомяки','рыжий','жрет','2019-06-01'),(4,'лошади','сивка','возит','2015-05-05'),(6,'ослы',NULL,'возит','2016-06-06'),(7,'овца','люська','дает шерсть',NULL);

/*Table structure for table `home` */

DROP TABLE IF EXISTS `home`;

CREATE TABLE `home` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `home` */

insert  into `home`(`id`) values (1),(2),(3);

/*Table structure for table `pack` */

DROP TABLE IF EXISTS `pack`;

CREATE TABLE `pack` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `pack` */

insert  into `pack`(`id`) values (4),(6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
