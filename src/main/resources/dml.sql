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