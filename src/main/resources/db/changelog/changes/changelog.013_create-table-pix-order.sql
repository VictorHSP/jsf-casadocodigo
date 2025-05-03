--liquibase formatted sql

--changeset victor.hugo:changelog.013_create-table-pix-order
CREATE TABLE IF NOT EXISTS public."pix_order" (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL UNIQUE,
    status VARCHAR(25) NOT NULL,
    qr_code VARCHAR(150) NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES tb_order(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE INDEX order_id_fk_pix_order_idx ON pix_order (order_id);
CREATE INDEX user_id_fk_pix_order_idx ON pix_order (user_id);

--rollback DROP TABLE public."pix_order";
