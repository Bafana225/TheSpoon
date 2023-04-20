CREATE TABLE IF NOT EXISTS horaire (
id INT PRIMARY KEY AUTO_INCREMENT,
horaire VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS restaurant (
id INT PRIMARY KEY AUTO_INCREMENT,
adresse VARCHAR(255),
nbretoile INT,
nbrplace INT,
nom VARCHAR(255),
pmr BOOLEAN,
prix INT
);

CREATE TABLE IF NOT EXISTS reservation (
id INT PRIMARY KEY AUTO_INCREMENT,
nbr_adulte INT NOT NULL,
nbr_enfant INT NOT NULL,
horaire INT NOT NULL,
restaurant INT NOT NULL,
FOREIGN KEY (horaire) REFERENCES horaire(id),
FOREIGN KEY (restaurant) REFERENCES restaurant(id)
);


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

INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,2,13,1);
INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,0,14,1);
INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,2,22,2);
INSERT INTO `reservation` (`nbr_adulte`,`nbr_enfant`,`horaire`,`restaurant`) VALUES (2,0,23,2);
