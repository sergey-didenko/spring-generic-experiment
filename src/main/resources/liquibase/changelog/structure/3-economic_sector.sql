--liquibase formatted sql

--changeset Svigelf:3
CREATE TABLE `economic_sector`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = MyISAM AUTO_INCREMENT = 1;
--rollback drop table economic_sector;
