CREATE DATABASE Hotdeal DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
use Hotdeal;

CREATE TABLE User (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id VARCHAR(20) UNIQUE,
  password VARCHAR(20),
  nickname VARCHAR(15) UNIQUE,
  email VARCHAR(100) UNIQUE,
  join_datetime DATETIME
);

CREATE TABLE Item (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  url VARCHAR(100),
  title VARCHAR(20),
  content text,
  price INT,
  item_created_at DATETIME,
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE Favorite (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  item_id INT,
  url VARCHAR(100),
  favorite_count INT,
  favorite_created_at DATETIME,
  FOREIGN KEY (user_id) REFERENCES User(id),
  FOREIGN KEY (item_id) REFERENCES Item(id)
);

CREATE TABLE Report (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  item_id INT,
  url VARCHAR(100),
  report_count INT,
  report_created_at DATETIME,
  FOREIGN KEY (user_id) REFERENCES User(id),
  FOREIGN KEY (item_id) REFERENCES Item(id)
);

CREATE TABLE Alarm (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  message varchar(50),
  type VARCHAR(10),
  read_flag TINYINT,
  alarm_created_at DATETIME,
  FOREIGN KEY (user_id) REFERENCES User(id)
);


insert into user values(null, '1', '2', '3', '4', null);
insert into user values(null, '2', '3', '4', '5', null);
insert into user values(null, '3', '4', '5', '6', null);
select * from user;



drop table user;