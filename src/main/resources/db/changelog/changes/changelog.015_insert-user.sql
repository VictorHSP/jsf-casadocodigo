--liquibase formatted sql

--changeset victor.hugo:changelog.changelog.015_insert-user
INSERT INTO public."tb_user" (ID, NAME, EMAIL, USERNAME, PASSWORD, LOCALE, CREATED_AT, LAST_UPDATE_AT, ADDRESS, ZIPCODE, COMPLEMENT, NEIGHBORHOOD, CITY, STATE, COUNTRY, CELLPHONE, ACTIVE)
VALUES
(1, 'Victor Hugo', 'victor@gmail.com', 'victorhsp',
 '$2a$12$hb9CszkLpNp6Jw3wdNJiP.QUokSozQlPNf09kD8q26IMRpdV8Tplm', 'pt_BR',
 now(), now(), null, null, null, null,
 null, null, null, null, true);
--rollback DELETE FROM public."tb_user" WHERE email = 'victor@gmail.com';
