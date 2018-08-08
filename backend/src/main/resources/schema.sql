CREATE TABLE user(
   login          VARCHAR(255) PRIMARY KEY,
   firstname VARCHAR(255) NOT NULL,
   lastname VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   description VARCHAR(255));