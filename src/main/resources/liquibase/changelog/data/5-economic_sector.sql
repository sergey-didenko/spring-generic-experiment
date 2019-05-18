--liquibase formatted sql

--changeset Svigelf:5
--preconditions onFail:CONTINUE onError:CONTINUE
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM economic_sector
INSERT INTO `economic_sector` VALUES (1, 'Calificări meșteșugărești');
INSERT INTO `economic_sector` VALUES (2, 'Vînzări angro (cu ridicata) și cu amănuntul');
INSERT INTO `economic_sector` VALUES (3, 'Electronică și automatică');
INSERT INTO `economic_sector` VALUES (4, 'Mecanică și prelucrarea metalelor');
INSERT INTO `economic_sector` VALUES (5, 'Vehicule cu motor, nave și aeronave');
INSERT INTO `economic_sector` VALUES (6, 'Prelucrarea alimentelor');
INSERT INTO `economic_sector` VALUES (7, 'Textile (îmbrăcăminte, încălțăminte și articole din piele)');
INSERT INTO `economic_sector` VALUES (8, 'Minerit și extracție');
INSERT INTO `economic_sector` VALUES (9, 'Construcții și inginerie civilă');
INSERT INTO `economic_sector` VALUES (10, 'Producția culturilor agricole și creșterea animalelor');
INSERT INTO `economic_sector` VALUES (11, 'Servicii hoteliere, restaurante și alimentație publică');
INSERT INTO `economic_sector` VALUES (12, 'Servicii transport');
INSERT INTO `economic_sector` VALUES (13, 'Silvicultură');
INSERT INTO `economic_sector` VALUES (14, 'Asistență socială și consiliere');
INSERT INTO `economic_sector` VALUES (15, 'Inginerie și activități inginerești');
--rollback delete from economic_sector where id in (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
