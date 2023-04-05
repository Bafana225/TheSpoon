
--Horaires :
INSERT INTO horaires (horaires) VALUES ('08h00-10h00');
INSERT INTO horaires (horaires) VALUES ('10h00-12h00');
INSERT INTO horaires (horaires) VALUES ('12h00-14h00');
INSERT INTO horaires (horaires) VALUES ('14h00-16h00');
INSERT INTO horaires (horaires) VALUES ('16h00-18h00');

--Restaurant :
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Le Petit Bistrot', '10 rue du Moulin', 30, true, 25.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('Chez Paul', '5 avenue des Champs', 50, false, 35.0);
INSERT INTO restaurant (nom, adresse, nb_couverts, accessibilite_pmr, prix_moyen) VALUES ('La Belle Epoque', '15 rue des Roses', 40, true, 45.0);

--Reservation :
INSERT INTO reservation (nb_adultes, nb_enfants, accessible_pmr, restaurant_id, horaires_id) VALUES (2, 1, true, 1, 1);
INSERT INTO reservation (nb_adultes, nb_enfants, accessible_pmr, restaurant_id, horaires_id) VALUES (4, 0, false, 2, 3);
INSERT INTO reservation (nb_adultes, nb_enfants, accessible_pmr, restaurant_id, horaires_id) VALUES (3, 2, true, 3, 5);

