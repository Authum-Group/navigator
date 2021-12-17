use country;

insert into Countries(name) values ("belarus");

insert into Regions(country_id, name) values
(1, "mogilev"),
(1, "brest"),
(1, "minsk"),
(1, "gomel"),
(1, "grodno"),
(1, "vitebsk");

insert into Cities(region_id, name) values
(3, "minsk"),
(2, "pinsk"),
(2, "luninets"),
(5, "grodno"),
(6, "vitebsk");

insert into Districts(city_id, name) values
(1, "zavodskoy"),
(1, "central'niy"),
(1, "moscovskiy"),
(2, "pervomayskiy"),
(3, "leninskiy"),
(4, "central'niy"),
(5, "partizanskiy");

insert into Streets(district_id, name) values
(3, "yakyba kolasa"),
(1, "yanki kupali"),
(2, "maksima bagdanovicha"),
(1, "simona muziki"),
(4, "franciska skoriny");

insert into Point_types(name) values
("bus stop"),
("residential building"),
("public place"),
("road"),
("unknown location");

insert into Points(name, latitude, longitude, street_id, type_id, description) values
("gorky park", 53.902738, 27.573555, 1, 5, null),
("chelyuskintsev park", 53.924148, 27.613308, 2, 4, null),
("nemiga", 53.924148, 27.613308, 3, 3, null),
("brest fortress", 52.083315, 23.659570, 4, 2, null),
("a temple in honor of the establishment of the cross of the lord", 52.913461, 30.916097, 5, 1, null),
("road number 9", 52.919561, 35.916097, 1, 2, null),
("church saint piotr", 52.919461, 34.916097, 2, 3, null),
("sight", 50.919461, 33.916097, 3, 4, null),
("house", 49.919461, 32.916097, 4, 5, null),
("town hall", 48.919461, 31.916097, 5, 6, null);

insert into Transitions(point_from_id, point_to_id) values
(1, 2),
(1, 3),
(1, 10),
(2, 1),
(2, 3),
(3, 1),
(3, 2),
(4, 5),
(4, 10),
(4, 7),
(5, 4),
(5, 6),
(5, 9),
(6, 8),
(6, 9),
(7, 2),
(7, 10),
(8, 7),
(8, 1),
(9,10),
(9, 6),
(10, 9),
(10, 4),
(10, 1);
