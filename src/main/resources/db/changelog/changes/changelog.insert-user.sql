--liquibase formatted sql

--changeset victor.hugo:changelog.insert-user
INSERT INTO public."tb_user" (NAME, EMAIL, USERNAME, PASSWORD, LOCALE, LAST_UPDATE_AT, ACTIVE)
VALUES ('Victor Hugo', 'victor@gmail.com', 'victorhsp', '$2a$12$hb9CszkLpNp6Jw3wdNJiP.QUokSozQlPNf09kD8q26IMRpdV8Tplm', 'pt_BR', now(), true);
--rollback DELETE FROM public.user WHERE email = 'victor@gmail.com';
