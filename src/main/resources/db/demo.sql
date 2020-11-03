create database demo;
use demo;
create table Office
(
    id          int auto_increment
        primary key,
    office_name varchar(20) not null
)
    comment 'Office';

create table pais
(
    id   varchar(2)  not null
        primary key,
    name varchar(30) not null
);

create table users
(
    id        int auto_increment
        primary key,
    name      varchar(20) not null,
    email     varchar(30) not null,
    office_id int         null,
    areacode  int         null,
    number    int         null,
    pais_id   varchar(2)  null,
    constraint office
        foreign key (office_id) references Office (id)
);


