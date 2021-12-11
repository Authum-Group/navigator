USE Country;

INSERT INTO Countries(name) VALUES
("Belarus"),
("Spain"),
("Great Britain"),
("Japan");

INSERT INTO Regions(country_id, name) VALUES
(1, "Mogilev region"),
(1, "Brest region"),
(1, "Minsk region"),
(1, "Gomel region"),
(1, "Grodno region"),
(1, "Vitebsk region");

INSERT INTO Cities(region_id, name) VALUES
(3, "Minsk"),
(2, "Pinsk"),
(2, "Luninets"),
(5, "Grodno"),
(6, "Vitebsk");

INSERT INTO Districts(city_id, name) VALUES
(1, "Zavodskoy district"),
(1, "Central'niy district"),
(1, "Moscovskiy district"),
(2, "Pervomayskiy district"),
(3, "Leninskiy district"),
(4, "Central'niy district"),
(5, "Partizanskiy district");

INSERT INTO Streets(name) VALUES
("Yakyba Kolasa"),
("Yanki Kupali"),
("Maksima Bagdanovicha"),
("Simona Muziki"),
("Franciska Skoriny");

INSERT INTO Street_districts(street_id, district_id) VALUES
(2, 1),
(3, 2),
(4, 1),
(1, 3),
(5, 4),
(4, 5);

INSERT INTO Point_types(type) VALUES
("Bus stop"),
("Residential building"),
("Public place"),
("Road"),
("Unknown location");

INSERT INTO Coordinates(latitude, longitude) VALUES
(53.902738, 27.573555),
(53.924148, 27.613308),
(53.902236, 27.549848),
(52.083315, 23.659570),
(52.244799, 26.795678),
(52.746566, 24.115057),
(53.694239, 26.869446),
(52.427148, 31.013167),
(52.965395, 29.784252),
(52.919461, 30.916097);

INSERT INTO Points(district_id, coordinate_id, point_type_id, name) VALUES
(2, 1, 3, "Gorky park"),
(3, 2, 1, "Chelyuskintsev Park"),
(2, 3, 3, "Nemiga"),
(4, 4, 3, "Brest Fortress"),
(5, 5, 5, "A temple in honor of the establishment of the cross of the lord"),
(7, 6, 4, "Road number 9"),
(1, 7, 3, "Church saint Piotr"),
(6, 8, 2, "Sight"),
(5, 9, 2, "House"),
(2, 2, 3, "Town hall");

INSERT INTO Houses(street_id, number, block, number_of_entrances) VALUES
(2, 5, 2, 10),
(1, 2, 1, 8),
(5, 35, 1, 15),
(3, 12, 5, 3),
(4, 10, 1, 1);

INSERT INTO Point_points(point_id, available_point_id) VALUES
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










