--liquibase formatted sql

--changeset victor.hugo:changelog.changelog.005_create-table-category
CREATE TABLE IF NOT EXISTS public."tb_category" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    active BOOLEAN NOT NULL DEFAULT false
);
--rollback DROP TABLE public."tb_category";
