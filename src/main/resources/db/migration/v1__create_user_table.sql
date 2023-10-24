CREATE SCHEMA IF NOT EXISTS dev;

CREATE TABLE dev.user (
    id bigint primary key,
    name varchar(100) not null,
    cpf varchar(100) not null,
    address varchar(100) not null,
    email varchar(100) not null,
    phone varchar(100) not null,
    create_date varchar(100) not null,
);