SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS users(
id int PRIMARY KEY auto_increment,
name VARCHAR,
rank VARCHAR,
staffRole VARCHAR,
dept_id INTEGER
);

CREATE TABLE IF NOT EXISTS departments(
id int PRIMARY KEY auto_increment,
name VARCHAR,
description VARCHAR
);

CREATE TABLE IF NOT EXISTS news(
id int PRIMARY KEY auto_increment,
title VARCHAR,
content VARCHAR,
userid INTEGER,
departmentid INTEGER
);