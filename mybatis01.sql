/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.0.96-community-nt : Database - db_2xuanke
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_2xuanke` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_2xuanke`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL auto_increment,
  `userName` varchar(50) default NULL,
  `userPw` varchar(50) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

LOCK TABLES `t_admin` WRITE;

insert  into `t_admin`(`userId`,`userName`,`userPw`) values (1,'admin','admin'),(6,'aaa','a');

UNLOCK TABLES;

/*Table structure for table `t_kebiao` */

DROP TABLE IF EXISTS `t_kebiao`;

CREATE TABLE `t_kebiao` (
  `id` int(11) NOT NULL auto_increment,
  `kecheng_id` int(11) default NULL,
  `shijian` varchar(50) default NULL,
  `jieci` varchar(50) default NULL,
  `jiaoshi` varchar(50) default NULL,
  `laoshi_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_kebiao` */

LOCK TABLES `t_kebiao` WRITE;

insert  into `t_kebiao`(`id`,`kecheng_id`,`shijian`,`jieci`,`jiaoshi`,`laoshi_id`) values (1,1,'星期一','1-2','多媒体教室',1),(2,2,'星期一','3-4','多媒体教室',2),(3,3,'星期一','5-6','多媒体教室',3),(4,4,'星期一','7-8','多媒体教室',3),(5,4,'星期二','1-2','多媒体教室',1),(6,4,'星期二','3-4','多媒体教室',3);

UNLOCK TABLES;

/*Table structure for table `t_kecheng` */

DROP TABLE IF EXISTS `t_kecheng`;

CREATE TABLE `t_kecheng` (
  `id` int(11) NOT NULL auto_increment,
  `bianhao` varchar(200) default NULL,
  `mingcheng` varchar(255) default NULL,
  `keshi` varchar(50) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_kecheng` */

LOCK TABLES `t_kecheng` WRITE;

insert  into `t_kecheng`(`id`,`bianhao`,`mingcheng`,`keshi`,`del`) values (1,'C001','C++程序设计基础','40','no'),(2,'C002','C语言程序设计','38','no'),(3,'J001','JSP动态网站开发技术','40','no'),(4,'J002','JAVA程序设计','40','no');

UNLOCK TABLES;

/*Table structure for table `t_laoshi` */

DROP TABLE IF EXISTS `t_laoshi`;

CREATE TABLE `t_laoshi` (
  `id` int(11) NOT NULL default '0',
  `bianhao` varchar(50) default NULL,
  `xingming` varchar(50) default NULL,
  `xingbie` varchar(50) default NULL,
  `nianling` varchar(50) default NULL,
  `zhicheng` varchar(50) default NULL,
  `loginname` varchar(50) default NULL,
  `loginpw` varchar(50) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_laoshi` */

LOCK TABLES `t_laoshi` WRITE;

insert  into `t_laoshi`(`id`,`bianhao`,`xingming`,`xingbie`,`nianling`,`zhicheng`,`loginname`,`loginpw`,`del`) values (1,'001','文之秀','男','25','教授','001','000000','no'),(2,'002','马老师','男','52','助教','002','000000','no'),(3,'003','张幸福','女','45','讲师','003','000000','no');

UNLOCK TABLES;

/*Table structure for table `t_xuesheng` */

DROP TABLE IF EXISTS `t_xuesheng`;

CREATE TABLE `t_xuesheng` (
  `id` int(11) NOT NULL auto_increment,
  `xuehao` varchar(50) default NULL,
  `xingming` varchar(50) default NULL,
  `xingbie` varchar(50) default NULL,
  `nianling` varchar(50) default NULL,
  `banji` varchar(50) default NULL,
  `loginname` varchar(50) default NULL,
  `loginpw` varchar(50) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_xuesheng` */

LOCK TABLES `t_xuesheng` WRITE;

insert  into `t_xuesheng`(`id`,`xuehao`,`xingming`,`xingbie`,`nianling`,`banji`,`loginname`,`loginpw`,`del`) values (1,'2015001','刘亮','男','21','计算机专业001班','2015001','000000','no'),(2,'2015002','张昂','男','19','计算机专业001班','2015002','000000','no'),(3,'2015003','李斯','男','18','计算机专业001班','2015003','000000','no');

UNLOCK TABLES;

/*Table structure for table `t_xuesheng_kebiao` */

DROP TABLE IF EXISTS `t_xuesheng_kebiao`;

CREATE TABLE `t_xuesheng_kebiao` (
  `id` int(11) NOT NULL auto_increment,
  `xuesheng_id` int(11) default NULL,
  `kebiao_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_xuesheng_kebiao` */

LOCK TABLES `t_xuesheng_kebiao` WRITE;

insert  into `t_xuesheng_kebiao`(`id`,`xuesheng_id`,`kebiao_id`) values (1,1,1),(2,1,2),(3,1,3),(4,1,6),(5,1,4),(6,1,5);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
