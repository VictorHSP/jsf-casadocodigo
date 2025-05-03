--liquibase formatted sql

--changeset victor.hugo:changelog.changelog.015_insert-user
INSERT INTO public."tb_user" (ID, NAME, EMAIL, USERNAME, PASSWORD, LOCALE, CREATED_AT, LAST_UPDATE_AT, ADDRESS, NUMBER, ZIPCODE, COMPLEMENT, NEIGHBORHOOD, CITY, STATE, COUNTRY, CELLPHONE, ACTIVE)
VALUES
(1, 'Victor Hugo', 'victor@gmail.com', 'victorhsp',
 '$2a$12$hb9CszkLpNp6Jw3wdNJiP.QUokSozQlPNf09kD8q26IMRpdV8Tplm', 'pt_BR',
 now(), now(), 'Rua do Contorno 223', 123, '31150000', 'Apt 102',
 'Almeiras', 'Alamor', 'Minas Gerais', 'Brazil', '31989899989', true);
--rollback DELETE FROM public."tb_user" WHERE email = 'victor@gmail.com';
