
CREATE TABLE IF NOT EXISTS restaurant (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(50),
  adresse VARCHAR(50),
  nb_couverts INT,
  accessibilite_pmr BOOLEAN,
  prix_moyen DOUBLE
);


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


