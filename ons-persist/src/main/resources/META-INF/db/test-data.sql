insert into T_SURNAME (SURNAME) values ('Etherton');
insert into T_SURNAME (SURNAME) values ('Eatherton');
insert into T_SURNAME (SURNAME) values ('Wilkinson');
insert into T_SURNAME (SURNAME) values ('De Roo');

insert into T_PERSON (SURNAME_ID, FIRST_NAME, DATE_OF_BIRTH) values (1, 'Martin', '1963-03-04');
insert into T_PERSON (SURNAME_ID, FIRST_NAME, DATE_OF_BIRTH) values (1, 'Mark', '1960-06-30');
insert into T_PERSON (SURNAME_ID, FIRST_NAME, DATE_OF_BIRTH) values (1, 'Samuel Original', '1805-01-01');
insert into T_PERSON (SURNAME_ID, FIRST_NAME, DATE_OF_BIRTH) values (3, 'Nora', '1936-04-23');
insert into T_PERSON (SURNAME_ID, FIRST_NAME, DATE_OF_BIRTH) values (4, 'Erna', '1959-03-05');
insert into T_PERSON (SURNAME_ID, FIRST_NAME, DATE_OF_BIRTH) values (1, 'Sydney', '1931-06-12');


insert into T_LOCATION (CITY) values ('Sheffield');
insert into T_LOCATION (CITY) values ('London');

insert into T_MARRIAGE (PERSON_ID, PARTNER_ID) values (0,4);
insert into T_MARRIAGE (PERSON_ID, PARTNER_ID) values (0,3);
insert into T_MARRIAGE (PERSON_ID, PARTNER_ID) values (5,3);
insert into T_DEATH (PERSON_ID, LOCATION_ID, DATE_OF_DEATH) values (0,0, '2090-06-06');

