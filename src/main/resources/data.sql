-- Création de la table restaurant
CREATE TABLE IF NOT EXISTS restaurant (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(50),
  adresse VARCHAR(50),
  nb_couverts INT,
  accessibilite_pmr BOOLEAN,
  prix_moyen DOUBLE
);

-- Création de la table horaires
CREATE TABLE IF NOT EXISTS horaires (
  id INT PRIMARY KEY AUTO_INCREMENT,
  horaire VARCHAR(50)
);

-- Création de la table reservation
CREATE TABLE IF NOT EXISTS reservation (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nbAdultes INT,
  nbEnfants INT,
  accessiblePmr BOOLEAN,
  restaurant_id INT,
  horaires_id INT,
  FOREIGN KEY (restaurant_id) REFERENCES restaurant(id),
  FOREIGN KEY (horaires_id) REFERENCES horaires(id)
);

-- Insertion des restaurants
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Le Petit Bistrot', '10 rue du Moulin', 30, true, 25.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Chez Paul', '5 avenue des Champs', 50, false, 35.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('La Belle Epoque', '15 rue des Roses', 40, true, 45.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Le Comptoir', '7 rue de la Paix', 20, true, 20.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Le Grand Café', '2 place de la République', 60, false, 40.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('La Table darthur', '14 avenue Victor Hugo', 30, true, 35.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Le Jardin des Saveurs', '18 rue de la Liberté', 50, true, 50.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Le Café de la Gare', '12 avenue de la Gare', 40, false, 30.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Le Coin Gourmand', '6 rue des Moulins', 25, true, 22.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('La Terrasse ensoleillée', '22 boulevard des Alliés', 35, true, 42.0);


-- Insertion des horaires
INSERT INTO horaires (horaire) VALUES ('13h00-14h00');
INSERT INTO horaires (horaire) VALUES ('19h00-20h00');
INSERT INTO horaires (horaire) VALUES ('20h00-21h00');
INSERT INTO horaires (horaire) VALUES ('21h00-22h00');
INSERT INTO horaires (horaire) VALUES ('22h00-23h00');

-- Insertion des réservations
INSERT INTO reservation (nbAdultes, nbEnfants, accessiblePmr, restaurant_id, horaires_id) VALUES (2, 1, true, 1, 1);
INSERT INTO reservation (nbAdultes, nbEnfants, accessiblePmr, restaurant_id, horaires_id) VALUES (4, 2, false, 2, 3);
INSERT INTO reservation (nbAdultes, nbEnfants, accessiblePmr, restaurant_id, horaires_id) VALUES (3, 0, true, 1, 2);
INSERT INTO reservation (nbAdultes, nbEnfants, accessiblePmr, restaurant_id, horaires_id) VALUES (2, 1, false, 3, 4);
INSERT INTO reservation (nbAdultes, nbEnfants, accessiblePmr, restaurant_id, horaires_id) VALUES (5, 3, true, 2, 5);



