--liquibase formatted sql

--changeset victor.hugo:changelog.003_create-table-user_roles
CREATE TABLE public."tb_user_roles" (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (role_id) REFERENCES tb_role(id)
);
--rollback DROP TABLE public."tb_user_roles";
