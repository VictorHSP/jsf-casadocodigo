--liquibase formatted sql

--changeset victor.hugo:changelog.005_insert-roles
INSERT INTO public.tb_role (id, role) VALUES (1, 'ADMIN');
INSERT INTO public.tb_role (id, role) VALUES (2, 'CUSTOMER');
--rollback DELETE FROM public."tb_role" WHERE role = 'ADMIN';
--rollback DELETE FROM public."tb_role" WHERE role = 'CUSTOMER';
