CREATE DATABASE todo_list;
USE todo_list;

CREATE TABLE users (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), username VARCHAR(100), password VARCHAR(100), email VARCHAR(100), roles VARCHAR(100));
CREATE TABLE tasks (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, task_name VARCHAR(100), task_type VARCHAR(100), description VARCHAR(100), duration_hours INTEGER, start_date VARCHAR(100), end_date VARCHAR(100), mark boolean, process boolean, id_user INTEGER, FOREIGN KEY (id_user) REFERENCES users (id));
CREATE TABLE user_role(user_id Integer, role varchar(100));

