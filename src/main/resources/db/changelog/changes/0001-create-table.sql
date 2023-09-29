--liquibase formatted sql

-- Changeset verners:1

CREATE TABLE IF NOT EXISTS client (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  address VARCHAR(255) NOT NULL,
  identity_number VARCHAR(255) NOT NULL
);