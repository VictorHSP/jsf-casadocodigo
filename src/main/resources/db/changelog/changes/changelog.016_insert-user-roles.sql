--liquibase formatted sql

--changeset victor.hugo:changelog.changelog.016_insert-user-roles
INSERT INTO public.tb_user_roles (user_id, role_id) VALUES (1, 1);
--rollback DELETE FROM public.tb_user_roles WHERE role_id = 1 and user_id = 1;
