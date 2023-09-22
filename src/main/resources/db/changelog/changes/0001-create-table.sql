--liquibase formatted sql

--changeset verners:1

CREATE TABLE IF NOT EXISTS vehicle (

    vin_number VARCHAR(17) PRIMARY KEY NOT NULL,
    registration_number VARCHAR(15) NOT NULL,
    manufacturer VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    fuel VARCHAR(50) NOT NULL,
    engine_capacity VARCHAR(50) NOT NULL,
    year_of_production SMALLINT(4) NOT NULL,
    vehicle_registration_date DATE

);

--liquibase formatted sql

--changeset verners:2

CREATE TABLE IF NOT EXISTS owner (

    owner_identity_number VARCHAR(50) PRIMARY KEY NOT NULL,
    owner_firstname VARCHAR(25) NOT NULL,
    owner_lastname VARCHAR(25) NOT NULL,
    owner_address VARCHAR(100) NOT NULL,
    owner_email VARCHAR(100) NOT NULL

);
