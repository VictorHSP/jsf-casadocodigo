--liquibase formatted sql

--changeset victor.hugo:changelog.008_create-table-book
CREATE TABLE IF NOT EXISTS public."tb_book" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    isbn VARCHAR(32) NOT NULL,
    published_date DATE NULL,
    author_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_at TIMESTAMP NULL,
    FOREIGN KEY (author_id) REFERENCES tb_author(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE INDEX "author_id_fk_idx" ON public."tb_book" (author_id);

--rollback DROP TABLE public."tb_book";
