--liquibase formatted sql

--changeset victor.hugo:changelog.011_create-table-order-item
CREATE TABLE IF NOT EXISTS public."tb_item_order" (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    FOREIGN KEY (order_id) REFERENCES tb_order(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (book_id) REFERENCES tb_book(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE INDEX order_id_fk_item_order_idx ON tb_item_order (order_id);
CREATE INDEX book_id_fk_item_order_idx ON tb_item_order (book_id);


--rollback DROP TABLE public."tb_item_order";
