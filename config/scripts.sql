-- db2.booking definition

CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` bigint DEFAULT NULL,
  `pickup_address` varchar(255) DEFAULT NULL,
  `drop_address` varchar(255) DEFAULT NULL,
  `booking_amount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);




INSERT INTO db2.booking
(id, created_by, pickup_address, drop_address, booking_amount)
VALUES(1, 222, '8cvfwvWRBV88 Birch St', '999eqceqceq Walnut St', '130993830.001');
INSERT INTO db2.booking
(id, created_by, pickup_address, drop_address, booking_amount)
VALUES(2, 100, '123 Main St eijcfvecve ', '45eqceqcveq6 Elm St', '83648.13');

INSERT INTO db1.booking
(id, created_by, pickup_address, drop_address, booking_amount)
VALUES(1, 2, '789 Pine St', '321 Oak St', '75.50');
INSERT INTO db1.booking
(id, created_by, pickup_address, drop_address, booking_amount)
VALUES(2, 3, '555 Maple St', '777 Cedar St', '120.25');