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
---Let's Ride ---
DROP table users;

CREATE TABLE users(
id    bigserial PRIMARY KEY,
firstName varchar(200),
lastName varchar(200),
email varchar(200),
phone varchar(200) NOT NULL,
login varchar(200) NOT NULL,
password varchar(200) NOT NULL,
isDriver BOOLEAN NOT NULL
);


--CREATE TYPE TripStatus AS ENUM ('PENDING', 'CANCELLED', 'CLOSED');

CREATE TABLE trips(
id    bigserial PRIMARY KEY,
driverId bigint NOT NULL, --product_no integer REFERENCES products (product_no), ; @OneToMany(mappedBy = "student"
origin varchar(200) NOT NULL,
destination varchar(200) NOT NULL,
date date NOT NULL,
time time NOT NULL,
comment varchar(200),
price double precision,
status varchar(200) --TripStatus
);

