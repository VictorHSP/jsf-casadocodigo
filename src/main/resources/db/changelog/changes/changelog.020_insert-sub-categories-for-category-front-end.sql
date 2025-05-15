--liquibase formatted sql

--changeset victor.hugo:changelog.020_insert-sub-categories-for-category-front-end
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('HTML e CSS', true, 3);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('JavaScript', true, 3);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Frameworks', true, 3);
INSERT INTO public.tb_sub_category (name, active, category_id) VALUES ('Todos', true, 3);
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 3;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 3;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 3;
--rollback DELETE FROM public.tb_sub_category WHERE category_id = 3;
