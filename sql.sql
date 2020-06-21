Query For User table

CREATE TABLE user(
  userId INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  loginName VARCHAR(255) NOT NULL
);

Query for Todo table

CREATE TABLE user(
  todoId INT AUTO_INCREMENT PRIMARY KEY,
  userId INT,
  month VARCHAR(255) NOT NULL,
  day VARCHAR(255) NOT NULL,
  year VARCHAR(255) NOT NULL,
title VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL,
priority VARCHAR(255) NOT NULL,

FOREIGN KEY (userId) REFERENCES user(userId)
);
