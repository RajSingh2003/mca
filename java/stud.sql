CREATE DATABASE student_db;

USE student_db;

CREATE TABLE student (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    grade CHAR(2)
);
