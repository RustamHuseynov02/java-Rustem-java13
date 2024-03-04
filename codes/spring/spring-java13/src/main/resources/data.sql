insert into users
(username,password,enabled)
values('Yusif','{noop}1',1);

insert into teachers
(username,name,surname)
values('Yusif','yusif','alizade');

insert into authorities
(username,authority)
values 
('Yusif','ROLE_ADD_STUDENT'),
('Yusif','ROLE_GET_STUDENT');

insert into students
(name,surname)
values
('Rustem','Huseynov');