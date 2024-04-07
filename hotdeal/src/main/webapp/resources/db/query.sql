CREATE DATABASE Hotdeal DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
use Hotdeal;

CREATE TABLE `hotdeal`.`user` (
  `id` INT AUTO_INCREMENT,
  `user_id` VARCHAR(45),
  `password` VARCHAR(45),
  `nickname` VARCHAR(45),
  `email` VARCHAR(45),
  `join_datetime` DATETIME,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

insert into user values(null, '1', '2', '3', '4', null);
insert into user values(null, '2', '3', '4', '5', null);
insert into user values(null, '3', '4', '5', '6', null);
select * from user;

drop table user;