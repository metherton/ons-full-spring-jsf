drop table T_PERSON if exists;
drop table T_LOCATION if exists;
drop table T_SURNAME if exists;

create table T_PERSON (ID integer identity primary key, FIRST_NAME varchar(50) not null, HANDICAPPED boolean, DATE_OF_BIRTH date);
create table T_LOCATION (ID integer identity primary key, CITY varchar(50) not null, POST_CODE varchar(25) null);
create table T_SURNAME (ID integer identity primary key, SURNAME varchar(50) not null);
