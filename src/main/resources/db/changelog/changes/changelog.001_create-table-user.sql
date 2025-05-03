--liquibase formatted sql

--changeset victor.hugo:changelog.001_create-table-user
CREATE TABLE IF NOT EXISTS public."tb_user" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    locale VARCHAR(5) NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_at TIMESTAMP,
    address VARCHAR(100) NULL,
    number SMALLINT NULL,
    zipcode VARCHAR(8) NULL,
    complement VARCHAR(100) NULL,
    neighborhood VARCHAR(45) NULL,
    city VARCHAR(25) NULL,
    state VARCHAR(25) NULL,
    country VARCHAR(30) NULL,
    cellphone VARCHAR(20) NULL,
    active bool DEFAULT false
);
--rollback DROP TABLE public."tb_user";
