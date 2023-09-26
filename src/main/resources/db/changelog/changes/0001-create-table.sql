--liquibase formatted sql

-- Changeset verners:1

CREATE TABLE IF NOT EXISTS owner (
    identity_number VARCHAR(50) PRIMARY KEY NOT NULL,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    address VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Changeset verners:2

CREATE TABLE IF NOT EXISTS vehicle (
    vin_number VARCHAR(17) PRIMARY KEY NOT NULL,
    registration_number VARCHAR(15) NOT NULL,
    manufacturer VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    fuel VARCHAR(50) NOT NULL,
    engine_capacity VARCHAR(50) NOT NULL,
    year_of_production SMALLINT(4) NOT NULL,
    vehicle_registration_date DATE,
    identity_number VARCHAR(50),
    FOREIGN KEY (identity_number) REFERENCES owner(identity_number)
);
