--liquibase formatted sql

--changeset Svigelf:4
CREATE TABLE `economic_agent`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `owner_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `addr` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `fax` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `ea_oi` FOREIGN KEY (`owner_id`) REFERENCES `economic_sector` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = MyISAM AUTO_INCREMENT = 1;
--rollback drop table economic_agent;
