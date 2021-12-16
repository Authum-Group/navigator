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
(5, "partizanskiy"),
(5, "oktyabrskiy");

insert into Streets(district_id, name) values
(13, "yakyba kolasa"),
(10, "yanki kupali"),
(12, "maksima bagdanovicha"),
(11, "simona muziki"),
(14, "franciska skoriny"),
(15, "nezavisimosti"),
(16, "zamkovaya"),
(9, "lenina"),
(14, "osvoboditeley"),
(13, "pekinskaya");
SELECT * FROM Point_types;
insert into Point_types(type) values
("bus stop"),
("residential building"),
("public place"),
("road"),
("unknown location");

insert into Points(name, latitude, longitude, street_id, type_id, description) values
("gorky park", 53.902738, 27.573555, 11, 5, null),
("chelyuskintsev park", 53.924148, 27.613308, 12, 4, null),
("nemiga", 53.924148, 27.613308, 13, 3, null),
("brest fortress", 52.083315, 23.659570, 14, 2, null),
("a temple in honor of the establishment of the cross of the lord", 52.913461, 30.916097, 15, 1, null),
("road number 9", 52.919561, 35.916097, 16, 2, null),
("church saint piotr", 52.919461, 34.916097, 20, 3, null),
("sight", 50.919461, 33.916097, 13, 4, null),
("house", 49.919461, 32.916097, 14, 5, null),
("town hall", 48.919461, 31.916097, 15, 5, null),
("mir castle",  53.451111, 26.472777, 16, 3, null),
("nesvizh castle", 53.224367, 26.689889, 17, 3, null),
("saint varvara church", 53.467381, 26.024960, 14, 3, null),
("vitebsk tawn hall", 55.195551, 30.205944, 18, 5, null),
("ozarichi", 52.46478, 29.25694, 20, 5, null),
("trostenec", 53.865515, 27.712640, 19, 1, null),
("national republic library", 53.931320, 27.646262, 11, 3, null),
("national park braslav", 55.723055, 27.052777, 17, 5, null),
("gas station gazpromneft", 54.019405, 28.209226, 13, 4, null),
("mound of glory", 54.018611, 27.898311, 14, 3, null),
("grand opera",  53.910618, 27.561706, 11, 3, null),
("pina river", 52.154708, 26.194847, 15, 5, null),
("old castle", 53.677201, 23.823201, 16, 3, null),
("lower castle", 55.488046, 28.764561, 17, 5, null),
("great stone",  53.903317, 27.976425, 11, 2, "industrial park"),
("minsk arena", 53.936066, 27.481646, 19, 2, "stadium");

insert into Transitions(point_from_id, point_to_id) values
(61, 72),
(61, 53),
(71, 60),
(62, 71),
(72, 53),
(53, 71),
(53, 72),
(54, 55),
(54, 60),
(74, 77),
(75, 74),
(65, 66),
(55, 59),
(56, 58),
(66, 69),
(77, 72),
(67, 70),
(78, 77),
(68, 61),
(69,70),
(59, 56),
(60, 69),
(70, 73),
(60, 71),
(71, 67),
(62, 61),
(62, 63),
(62, 66),
(63, 55),
(73, 70),
(53, 59),
(64, 68),
(74, 56),
(65, 68),
(56, 59),
(66, 60),
(76, 71),
(67, 70),
(68, 67),
(69, 61),
(59, 58),
(70, 66),
(60, 53),
(60, 58),
(61, 69),
(71, 68),
(72, 70),
(62, 64),
(63, 62),
(73, 64),
(55, 61),
(65, 61),
(75, 60),
(66, 71);











