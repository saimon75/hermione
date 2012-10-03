insert into contact (first_name, last_name, birth_date) values ('Clarence','Ho','1980-07-30');
insert into contact (first_name, last_name, birth_date) values ('Scott','Tiger','1972-01-30');
insert into contact (first_name, last_name, birth_date) values ('John','Smith','1964-01-30');

insert into contact_tel_detail (contact_id, tel_type, tel_number) values
(1, 'Mobile','1235151');
insert into contact_tel_detail (contact_id, tel_type, tel_number) values
(2, 'Home','3333333');
insert into contact_tel_detail (contact_id, tel_type, tel_number) values
(3, 'Mobile','2626622522');

insert into hobby (hobby_id) values ('Swimming');
insert into hobby (hobby_id) values ('Jogging');
insert into hobby (hobby_id) values ('Reading');

insert into contact_hobby_detail (contact_id, hobby_id) 
values (1,'Swimming');
insert into contact_hobby_detail (contact_id, hobby_id) 
values (1,'Reading');
insert into contact_hobby_detail (contact_id, hobby_id) 
values (2,'Swimming');