--liquibase formatted sql

--changeset victor.hugo:changelog.create-table-user
CREATE TABLE public."tb_user" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    locale VARCHAR(5) NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_at TIMESTAMP,
    active bool DEFAULT false
);
--rollback DROP TABLE public.user;
