--liquibase formatted sql

--changeset victor.hugo:changelog.007_create-table-author
CREATE TABLE IF NOT EXISTS public."tb_author" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    url_photo VARCHAR(150) NULL,
    bio TEXT NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_at TIMESTAMP NULL,
    deleted BOOLEAN DEFAULT false
);
--rollback DROP TABLE public."tb_author";
