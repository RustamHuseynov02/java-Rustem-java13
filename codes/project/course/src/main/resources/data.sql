insert into users
(username,password,enabled)
values
('m1','{noop}1',1),
('m2','{noop}1',1),
('m3','{noop}1',1);

insert into authorities
(username,authority)
values
('m1','teacher'),
('m2','teacher'),
('m3','teacher');

insert into student
(name,surname)
values
('Saleh','Cəfərov'),
('Əli','Hüseynov'),
('Rasim','Ağakişiyev');