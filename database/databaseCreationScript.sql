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
---- POSTGRE ----
---Let's Ride ---
DROP table users,trips,vehicles, tripPassangers;


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

CREATE TABLE vehicles(
id    bigserial PRIMARY KEY,
driverId bigint NOT NULL references users(id),
model varchar(200) NOT NULL,
color varchar(200) NOT NULL,
year int,
regNumber varchar(200)
);


CREATE TABLE trips(
id    bigserial PRIMARY KEY,
driverId bigint NOT NULL references users(id),
origin varchar(200) NOT NULL,
destination varchar(200) NOT NULL,
date date NOT NULL,
time time NOT NULL,
comment varchar(200),
price double precision,
passangerCount int NOT NULL,
status varchar(200),
vehicleId bigint NOT NULL references vehicles(id)
);


CREATE TABLE tripPassangers(
id    bigserial PRIMARY KEY,
tripId bigint NOT NULL references trips(id),
passangerId bigint NOT NULL references users(id)
);

--Insert test data
INSERT INTO users
VALUES
(DEFAULT, 'Vasja', 'Driver', 'vasja@mailinator.com', '12346789879', 'vasja', 'vasja', true),
(DEFAULT, 'Masha', 'Passanger', 'masha@mailinator.com', '12346789879', 'masha', 'masha', false),
(DEFAULT, 'Pasha', 'Passanger', 'pasha@mailinator.com', '12346789879', 'pasha', 'pasha', false);

INSERT INTO vehicles
VALUES (DEFAULT, 2, 'Audi A6', 'Black', 3, '2015', 'MK-1578');

INSERT INTO trips
VALUES (DEFAULT, 2, 'Riga', 'Liepaja', '2018-09-11', '16:00:00', 'Meet at Alfa', '2.50', 'PENDING');

INSERT INTO tripPassangers
VALUES
(DEFAULT, 1, 3),
(DEFAULT, 1, 4);