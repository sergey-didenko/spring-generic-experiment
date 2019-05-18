--liquibase formatted sql

--changeset Svigelf:6
--preconditions onFail:CONTINUE onError:CONTINUE
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM economic_agent
INSERT INTO `economic_agent` VALUES (1, 3, 'Draexlmaier', 'bd. Stefan cel Mare, 4', 'email@email.md', '+37379556875215', '--');
INSERT INTO `economic_agent` VALUES (2, 3, 'Gebauer and Griller', 'bd. Stefan cel Mare, 4', 'email@email.md', '+37379556875215', '--');
INSERT INTO `economic_agent` VALUES (3, 3, 'Sumitomo', 'bd. Stefan cel Mare, 4', 'email@email.md', '+37379556875215', '--');
INSERT INTO `economic_agent` VALUES (4, 3, 'La Trivineta Cavi', 'bd. Stefan cel Mare, 4', 'email@email.md', '+37379556875215', '--');
INSERT INTO `economic_agent` VALUES (5, 3, 'Coroplast', 'bd. Stefan cel Mare, 4', 'email@email.md', '+37379556875215', '--');
--rollback delete from economic_agent where id in (1, 2, 3, 4, 5);
