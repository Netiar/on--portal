CREATE DATABASE news_ping;
\c news_ping;

CREATE TABLE users(
id serial PRIMARY KEY,
name VARCHAR,
rank VARCHAR,
staffRole VARCHAR,
dept_id INTEGER
);

CREATE TABLE departments(
id serial PRIMARY KEY,
name VARCHAR,
description VARCHAR
);

CREATE TABLE news(
id serial PRIMARY KEY,
title VARCHAR,
content VARCHAR,
userid INTEGER,
departmentid INTEGER
);