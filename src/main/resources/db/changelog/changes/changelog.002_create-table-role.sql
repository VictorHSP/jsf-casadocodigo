--liquibase formatted sql

--changeset victor.hugo:changelog.002_create-table-role
CREATE TABLE IF NOT EXISTS public."tb_role" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--rollback DROP TABLE public."tb_role";
