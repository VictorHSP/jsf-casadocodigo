--liquibase formatted sql

--changeset victor.hugo:changelog.012_create-table-credit-card-order
CREATE TABLE IF NOT EXISTS public."credit_card_order" (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL UNIQUE,
    status VARCHAR(45) NOT NULL,
    bin_code VARCHAR(8) NULL,
    gateway_credit_card_token VARCHAR(80) NULL,
    merchant_credit_card_token VARCHAR(80) NULL,
    expire_date VARCHAR(8) NULL,
    card_holder_name VARCHAR(100) NULL,
    variant VARCHAR(25) NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES tb_order(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE INDEX order_id_fk_credit_card_order_idx ON credit_card_order (order_id);
CREATE INDEX user_id_fk_credit_card_order_idx  ON credit_card_order (user_id);

--rollback DROP TABLE public."credit_card_order";
