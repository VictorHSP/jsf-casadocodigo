--liquibase formatted sql

--changeset victor.hugo:changelog.changelog.006_create-table-sub_category
CREATE TABLE IF NOT EXISTS public."tb_sub_category" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT false,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES tb_category(id)
            ON DELETE CASCADE
            ON UPDATE SET NULL
);

CREATE INDEX "category_id_fk_idx" ON public."tb_sub_category" (category_id);
--rollback DROP TABLE public."tb_sub_category";
