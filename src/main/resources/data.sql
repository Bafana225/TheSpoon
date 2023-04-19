CREATE TABLE usertype (
  id INT PRIMARY KEY AUTO_INCREMENT,
  usertype VARCHAR(50) NOT NULL
);

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE horaire (
    id INT PRIMARY KEY AUTO_INCREMENT,
    horaire VARCHAR(255) NOT NULL
);

CREATE TABLE `restaurant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `nbretoile` int(11) DEFAULT NULL,
  `nbrplace` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pmr` bit(1) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `plagehoraire` (
  `id_plagehoraire` int(11) NOT NULL AUTO_INCREMENT,
  `id_restaurant` int(11) NOT NULL,
  `id_horaire` int(11) NOT NULL,
  PRIMARY KEY (`id_plagehoraire`),
  FOREIGN KEY (`id_restaurant`) REFERENCES `restaurant` (`id`),
  FOREIGN KEY (`id_horaire`) REFERENCES `horaire` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nbr_adulte` int(11) NOT NULL,
  `nbr_enfant` int(11) NOT NULL,
  `horaire` int(11) NOT NULL,
  `restaurant` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`horaire`) REFERENCES `plagehoraire`(`id`),
  FOREIGN KEY (`restaurant`) REFERENCES `restaurant`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `usertype`(`usertype`) VALUES ('restaurateur');
INSERT INTO `usertype`(`usertype`) VALUES ('client');

INSERT INTO `utilisateur`(`nom`, `prenom`, `type`) VALUES ('DUPONT','Pierre',1);
INSERT INTO `utilisateur`(`nom`, `prenom`, `type`) VALUES ('ROBERT','Jean',2);
INSERT INTO `utilisateur`(`nom`, `prenom`, `type`) VALUES ('AUDAS','Evan',2);

INSERT INTO `horaire`(`horaire`) VALUES ('00h - 01h');
INSERT INTO `horaire`(`horaire`) VALUES ('01h - 02h');
INSERT INTO `horaire`(`horaire`) VALUES ('03h - 03h');
INSERT INTO `horaire`(`horaire`) VALUES ('03h - 04h');
INSERT INTO `horaire`(`horaire`) VALUES ('04h - 05h');
INSERT INTO `horaire`(`horaire`) VALUES ('05h - 06h');
INSERT INTO `horaire`(`horaire`) VALUES ('06h - 07h');
INSERT INTO `horaire`(`horaire`) VALUES ('07h - 08h');
INSERT INTO `horaire`(`horaire`) VALUES ('08h - 09h');
INSERT INTO `horaire`(`horaire`) VALUES ('09h - 10h');
INSERT INTO `horaire`(`horaire`) VALUES ('10h - 11h');
INSERT INTO `horaire`(`horaire`) VALUES ('11h - 12h');
INSERT INTO `horaire`(`horaire`) VALUES ('12h - 13h');
INSERT INTO `horaire`(`horaire`) VALUES ('13h - 14h');
INSERT INTO `horaire`(`horaire`) VALUES ('14h - 15h');
INSERT INTO `horaire`(`horaire`) VALUES ('15h - 16h');
INSERT INTO `horaire`(`horaire`) VALUES ('15h - 17h');
INSERT INTO `horaire`(`horaire`) VALUES ('16h - 18h');
INSERT INTO `horaire`(`horaire`) VALUES ('17h - 19h');
INSERT INTO `horaire`(`horaire`) VALUES ('18h - 20h');
INSERT INTO `horaire`(`horaire`) VALUES ('19h - 20h');
INSERT INTO `horaire`(`horaire`) VALUES ('20h - 21h');
INSERT INTO `horaire`(`horaire`) VALUES ('21h - 22h');
INSERT INTO `horaire`(`horaire`) VALUES ('22h - 23h');
INSERT INTO `horaire`(`horaire`) VALUES ('23h - 00h');

INSERT INTO `restaurant`(`adresse`, `nbretoile`, `nbrplace`, `nom`, `pmr`, `prix`) VALUES ('rue des chats',0,30,'BoulevardDuRêve',true,30);
INSERT INTO `restaurant`(`adresse`, `nbretoile`, `nbrplace`, `nom`, `pmr`, `prix`) VALUES ('rue des chiens',0,30,'QuaiGourmand',true,40);
INSERT INTO `restaurant`(`adresse`, `nbretoile`, `nbrplace`, `nom`, `pmr`, `prix`) VALUES ('rue des canards',0,30,'LaPasserelle',true,25);
INSERT INTO `restaurant`(`adresse`, `nbretoile`, `nbrplace`, `nom`, `pmr`, `prix`) VALUES ('rue des poulets',0,30,'LaVolaille',true,25);

INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (1,12);
INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (1,13);
INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (1,14);
INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (1,15);

INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (2,21);
INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (2,22);
INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (2,23);
INSERT INTO `plagehoraire` (`id_restaurant`,`id_horaire`) VALUES (2,24);

INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,2,13,1);
INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,0,14,1);
INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,2,22,2);
INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,0,23,2);
