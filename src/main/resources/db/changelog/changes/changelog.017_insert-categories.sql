--liquibase formatted sql

--changeset victor.hugo:changelog.017_insert-categories
INSERT INTO public.tb_category (id, name, active) VALUES (1, 'Programação', true);
INSERT INTO public.tb_category (id, name, active) VALUES (2, 'Mobile', true);
INSERT INTO public.tb_category (id, name, active) VALUES (3, 'Front-end', true);
INSERT INTO public.tb_category (id, name, active) VALUES (4, 'DevOps', true);
INSERT INTO public.tb_category (id, name, active) VALUES (5, 'Business', true);
--rollback DELETE FROM public.tb_category WHERE id = 1;
--rollback DELETE FROM public.tb_category WHERE id = 2;
--rollback DELETE FROM public.tb_category WHERE id = 3;
--rollback DELETE FROM public.tb_category WHERE id = 4;
--rollback DELETE FROM public.tb_category WHERE id = 5;
