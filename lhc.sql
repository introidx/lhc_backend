-- CREATE DATABASE lhc;
-- GRANT ALL PRIVILEGES ON DATABASE "lhc" TO postgres;

/* CREATE TABLE lhc_users(
user_id integer PRIMARY KEY NOT NULL,
name varchar(20) NOT NULL,
email varchar(30) NOT NULL,
password text NOT NULL,
role varchar(20) NOT NULL
); */

-- CREATE SEQUENCE lhc_users_seq INCREMENT 1 START 1;

/* CREATE TABLE lhc_tests(
test_id integer PRIMARY KEY NOT NULL,
subject_code varchar(30) NOT NULL,
topic_name varchar(30) NOT NULL,
time varchar(30) NOT NULL,
marks varchar(30) NOT NULL
);  */

-- CREATE SEQUENCE lhc_tests_seq INCREMENT 1 START 100;

/* CREATE TABLE lhc_questions(
question_id integer PRIMARY KEY NOT NULL,
test_id integer NOT NULL,
question_title varchar(50) NOT NULL,
question_marks varchar(30) NOT NULL
); */

-- CREATE SEQUENCE lhc_questions_seq INCREMENT 1 START 1000;







