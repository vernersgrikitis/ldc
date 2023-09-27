--liquibase formatted sql

-- Changeset verners:2

CREATE TABLE IF NOT EXISTS vehicle (
  vehicle_id BIGSERIAL PRIMARY KEY NOT NULL,
  vin_number VARCHAR(50) NOT NULL,
  registration_number VARCHAR(50) NOT NULL,
  manufacturer VARCHAR(100) NOT NULL,
  model VARCHAR(255) NOT NULL,
  fuel VARCHAR(255) NOT NULL,
  engine_capacity VARCHAR(255) NOT NULL,
  year_of_production VARCHAR(255) NOT NULL,
  vehicle_registrationDate DATE NOT NULL
);