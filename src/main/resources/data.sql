CREATE TABLE IF NOT EXISTS restaurant (
  id_restaurant INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(50),
  adresse VARCHAR(300),
  nb_couverts INT,
  accessibilite_pmr BOOLEAN,
  prix_moyen INT
);

CREATE TABLE IF NOT EXISTS horaires (
  id_horaires INT PRIMARY KEY,
  horaires VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS reservation (
  id_reservation INT PRIMARY KEY AUTO_INCREMENT,
  nbAdultes INT,
  nbEnfants INT,
  accessiblePmr BOOLEAN,
  id_restaurant INT,
  id_horaires INT,
  FOREIGN KEY (id_restaurant) REFERENCES restaurant(id_restaurant),
  FOREIGN KEY (id_horaires) REFERENCES horaires(id_horaires)
);

CREATE TABLE IF NOT EXISTS restaurant_horaires (
  restaurant_id_restaurant INT,
  horaires_id_horaires INT,
  FOREIGN KEY (restaurant_id_restaurant) REFERENCES restaurant(id_restaurant),
  FOREIGN KEY (horaires_id_horaires) REFERENCES horaires(id_horaires)
);

INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES
  ('Le Petit Bistrot', '10 rue du Moulin', 30, true, 25.0),
  ('Chez Paul', '5 avenue des Champs', 50, false, 35.0),
  ('La Belle Epoque', '15 rue des Roses', 40, true, 45.0),
  ('Le Comptoir', '7 rue de la Paix', 20, true, 20.0),
  ('Le Grand Café', '2 place de la République', 60, false, 40.0),
  ('La Table darthur', '14 avenue Victor Hugo', 30, true, 35.0),
  ('Le Jardin des Saveurs', '18 rue de la Liberté', 50, true, 50.0),
  ('Le Café de la Gare', '12 avenue de la Gare', 40, false, 30.0),
  ('Le Coin Gourmand', '6 rue des Moulins', 25, true, 22.0),
  ('La Terrasse ensoleillée', '22 boulevard des Alliés', 35, true, 42.0);

INSERT INTO horaires (id_horaires, horaires) VALUES
  (1, '13h00-14h00'),
  (2, '19h00-20h00'),
  (3, '20h00-21h00'),
  (4, '21h00-22h00'),
  (5, '22h00-23h00');

INSERT INTO reservation (nbAdultes, nbEnfants, accessiblePmr, id_restaurant, id_horaires) VALUES
  (2, 1, true, 1, 1),
  (4, 2, false, 2, 2),
  (3, 0, true, 3, 3),
  (2, 1, false, 4, 4),
  (5, 3, true, 5, 5);

INSERT INTO restaurant_horaires (restaurant_id_restaurant, horaires_id_horaires) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (1, 4),
  (1, 5),
  (2, 1);

