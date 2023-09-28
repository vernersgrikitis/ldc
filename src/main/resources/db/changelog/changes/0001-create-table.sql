--liquibase formatted sql

-- Changeset verners:1

CREATE TABLE IF NOT EXISTS client (
  client_id BIGSERIAL PRIMARY KEY NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  address VARCHAR(255) NOT NULL,
  identity_number VARCHAR(255) NOT NULL,
  date_of_birth DATE NOT NULL
);

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
   vehicle_registration_date DATE NOT NULL
);

-- Changeset verners:3

CREATE TABLE IF NOT EXISTS vehicle_history (
   history_id BIGSERIAL PRIMARY KEY NOT NULL,
   start_of_ownership TIMESTAMP NOT NULL,
   end_of_ownership TIMESTAMP,
   vehicle_id BIGINT REFERENCES vehicle(vehicle_id),
   previous_owner_id BIGINT REFERENCES client(client_id),
   current_owner_id BIGINT REFERENCES client(client_id)
);
