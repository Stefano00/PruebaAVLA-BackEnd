CREATE DATABASE todo_list;
USE todo_list;

CREATE TABLE users (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), username VARCHAR(100), password VARCHAR(100), email VARCHAR(100), roles VARCHAR(100));
CREATE TABLE tasks (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, task_name VARCHAR(100), task_type VARCHAR(100), description VARCHAR(100), duration_hours INTEGER, start_date VARCHAR(100), end_date VARCHAR(100), mark boolean, process boolean, id_user INTEGER, FOREIGN KEY (id_user) REFERENCES users (id));
CREATE TABLE user_role(user_id Integer, role varchar(100));
CREATE TABLE users_tasks(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, id_user INTEGER, FOREIGN KEY (id_user) REFERENCES users (id), id_task INTEGER UNIQUE, FOREIGN KEY (id_task) REFERENCES tasks (id));

select * from tasks;
select * from users_tasks;

drop table users_tasks;
drop table tasks;

show tables;

insert into users_tasks values(1,1,1);
insert into users_tasks values(2,2,1);
insert into users_tasks values(3,1,2);
insert into users_tasks values(4,1,1);


