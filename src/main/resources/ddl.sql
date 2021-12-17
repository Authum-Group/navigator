create database if not exists Country;
use Country;

create table if not exists Countries(
id serial,
name varchar(45) not null unique,
primary key(id)
);

create table if not exists Regions(
id serial,
country_id bigint unsigned not null,
name varchar(45) not null unique,
primary key(id),
constraint fk_regions_country_id foreign key(country_id) references Countries(id)
on update no action
on delete cascade
);

create table if not exists Cities(
id serial,
region_id bigint unsigned not null,
name varchar(45) not null,
primary key(id),
constraint fk_cities_region_id foreign key(region_id) references Regions(id)
on update no action
on delete cascade
);

create table if not exists Districts(
id serial,
city_id bigint unsigned not null,
name varchar(45) not null,
primary key(id),
constraint fk_districts_city_id foreign key(city_id) references Cities(id)
on update no action
on delete cascade
);

create table if not exists Streets(
id serial,
district_id bigint unsigned not null,
name varchar(150) not null,
primary key(id),
constraint fk_streets_district_id foreign key(district_id) references Districts(id)
on update no action
on delete cascade
);

create table if not exists Point_types(
id serial,
name varchar(50) not null unique,
primary key(id)
);

create table if not exists Points(
id serial,
name varchar(150) not null,
latitude double not null,
longitude double not null,
description text,
street_id bigint unsigned not null,
type_id bigint unsigned not null,
primary key(id),
constraint fk_points_street_id foreign key(street_id) references Streets(id)
on update no action
on delete cascade,
constraint fk_points_type_id foreign key(type_id) references Point_types(id)
on update no action
on delete cascade
);

create table if not exists Transitions(
id serial,
point_from_id bigint unsigned not null,
point_to_id bigint unsigned not null,
primary key(id),
constraint fk_transitions_point_from_id foreign key(point_from_id) references Points(id)
on update no action
on delete cascade,
constraint fk_transitions_point_to_id foreign key(point_to_id) references Points(id)
on update no action
on delete cascade
);
