DROP TABLE IF EXISTS USERS;
  
CREATE TABLE USERS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  password VARCHAR(250) NOT NULL,
  user_name VARCHAR(250) NOT NULL
);


INSERT INTO USERS(first_name, last_name, email, password ,user_name) VALUES
  ('Lokesh', 'Gupta', 'abc@gmail.com','lokesh123','12345'),
  ('Deja', 'Vu', 'xyz@email.com','deja123','12345'),
  ('Caption', 'America', 'cap@marvel.com','capton123','12345');