CREATE DATABASE  IF NOT EXISTS `micro_message` 
USE `micro_message`;

DROP TABLE IF EXISTS `command`;

CREATE TABLE `command` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `command` WRITE;
INSERT INTO `command` VALUES (1,'查看','精彩内容'),(2,'段子','精彩段子'),(3,'新闻','今日头条'),(4,'娱乐','娱乐新闻'),(5,'电影','近日上映大片'),(6,'彩票','中奖号码'),(23,'天气','天气预报'),(24,'美食','美食搜罗'),(25,'奇闻','奇闻异事'),(26,'游戏','游戏天地');