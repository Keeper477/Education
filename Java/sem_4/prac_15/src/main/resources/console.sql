create table if not exists departure (
    id serial primary key,
    type varchar (100),
    departuredate varchar (100)
);
create table if not exists postoffice (
    id serial primary key,
    name varchar (100),
    cityname varchar (100)
);