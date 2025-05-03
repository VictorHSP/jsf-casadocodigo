--liquibase formatted sql

--changeset victor.hugo:changelog.014_create-table-book-details
CREATE TABLE IF NOT EXISTS public."tb_book_details" (
    id BIGSERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    summary JSON NOT NULL,
    number_of_pages SMALLINT NOT NULL,
    url_ebook VARCHAR(150) NOT NULL,
    book_id BIGINT NOT NULL,
    url_photo VARCHAR(150) NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_at TIMESTAMP NULL,
    version SMALLINT NOT NULL DEFAULT 0,
    published BOOLEAN NOT NULL DEFAULT false,
    FOREIGN KEY (book_id) REFERENCES tb_book(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE INDEX book_id_fk_book_details_idx ON tb_book_details (book_id);

--rollback DROP TABLE public."tb_book_details";
