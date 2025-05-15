--liquibase formatted sql

--changeset victor.hugo:changelog.019_insert-sub-categories-for-category-mobile
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('IOS', true, 2);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Android', true, 2);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Multiplataforma', true, 2);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Todos', true, 2);
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 2;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 2;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 2;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 2;
