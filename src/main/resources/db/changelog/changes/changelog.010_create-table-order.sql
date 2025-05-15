--liquibase formatted sql

--changeset victor.hugo:changelog.changelog.010_create-table-order
CREATE TABLE IF NOT EXISTS public."tb_order" (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update_at TIMESTAMP NULL,
    totalValue DECIMAL(10, 2) NOT NULL,
    status VARCHAR(25) NOT NULL,
    gateway VARCHAR(45) NOT NULL,
    gateway_reference VARCHAR(45) NULL,
    merchant_reference VARCHAR(45) NOT NULL UNIQUE,
    payment_type VARCHAR(25) NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE INDEX "user_id_fk_order_idx" ON public."tb_order" (user_id);

--rollback DROP TABLE public."tb_order";
