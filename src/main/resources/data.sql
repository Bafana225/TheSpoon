
CREATE TABLE IF NOT EXISTS restaurant (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(50),
  adresse VARCHAR(50),
  nb_couverts INT,
  accessibilite_pmr BOOLEAN,
  prix_moyen DOUBLE
);

INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen)
VALUES ('Le Petit Bistrot', '10 rue du Moulin', 30, true, 25.0);

INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen)
VALUES ('Chez Paul', '5 avenue des Champs', 50, false, 35.0);

INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen)
VALUES ('La Belle Epoque', '15 rue des Roses', 40, true, 45.0);


