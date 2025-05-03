--liquibase formatted sql

--changeset victor.hugo:changelog.009_create-table-book-sub-categories
CREATE TABLE IF NOT EXISTS public."tb_book_sub_categories" (
    sub_category_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    PRIMARY KEY (sub_category_id, book_id),
    FOREIGN KEY (sub_category_id) REFERENCES tb_sub_category(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    FOREIGN KEY (book_id) REFERENCES tb_book(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE INDEX "book_id_fk_sub_category_idx" ON public."tb_book_sub_categories" (book_id);

--rollback DROP TABLE public."tb_book_sub_categories";
