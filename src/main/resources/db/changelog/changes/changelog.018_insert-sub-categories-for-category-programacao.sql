--liquibase formatted sql

--changeset victor.hugo:changelog.018_insert-sub-categories-for-category-programacao
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Lógica', true, 1);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Java', true, 1);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('.NET', true, 1);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('PHP', true, 1);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('OO', true, 1);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Funcional', true, 1);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Python', true, 1);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Todos', true, 1);
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 1;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 1;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 1;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 1;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 1;
