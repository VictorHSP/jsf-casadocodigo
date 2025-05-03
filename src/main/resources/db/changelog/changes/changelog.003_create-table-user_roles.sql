--liquibase formatted sql

--changeset victor.hugo:changelog.003_create-table-user_roles
CREATE TABLE IF NOT EXISTS public."tb_user_roles" (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    FOREIGN KEY (role_id) REFERENCES tb_role(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE INDEX "user_id_fk_idx" ON public."tb_user_roles" (user_id);
--rollback DROP TABLE public."tb_user_roles";
