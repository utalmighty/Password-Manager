Create database if not exists `password_manager`;

use `password_manager`;

Drop table if exists `password`;

Create table `password`(
	`id` int NOT NULL AUTO_INCREMENT,
    `identified_by` varchar(100) default null,
    `username` varchar(100) default null,
	`url_pattern` varchar(200) default null,
    `password` varchar(1000) default NULL,
	PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;