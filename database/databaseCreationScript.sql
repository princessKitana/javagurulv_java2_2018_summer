SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8 ;
USE `java2` ;

DROP TABLE IF EXISTS `products` ;

CREATE TABLE IF NOT EXISTS `products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(32) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


---- POSTGRE ----

CREATE TABLE products(
id    serial PRIMARY KEY,
title varchar(32) NOT NULL,
description varchar(100) NOT NULL,
date_added date NOT NULL
);

INSERT INTO products(id, title, description, date_added)
VALUES
 ( default, 'coffee', 'black', '2018-09-01');


select * from products
where title='coffee';


---Let's Ride ---
CREATE TYPE status AS ENUM ('PENDING', 'CANCELLED', 'CLOSED');

CREATE TABLE trip(
id    bigserial PRIMARY KEY,
driverId bigint NOT NULL,
origin varchar(60) NOT NULL,
destination varchar(60) NOT NULL,
date date NOT NULL,
time time NOT NULL,
comment varchar(100),
price decimal,
status status
);

DROP table registeredUser;

CREATE TABLE registeredUser(
id    bigserial PRIMARY KEY,
firstName varchar(50) NOT NULL,
lastName varchar(50) NOT NULL,
email varchar(200),
phone varchar(50),
login varchar(50),
password varchar(50),
isDriver BOOLEAN NOT NULL
);