create table if not exists departures (
    id serial primary key,
    type varchar (100),
    departuredate varchar (100),
    postoffice_id int
);
create sequence departures_sequence start 1 increment 1;
create table if not exists postoffices (
    id serial primary key,
    name varchar (100),
    cityname varchar (100)
);
create sequence postoffice_sequence start 1 increment 1;