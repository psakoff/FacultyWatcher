CREATE TABLE `Student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupId` varchar(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1