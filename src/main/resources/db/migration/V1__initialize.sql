CREATE TABLE Reader (
  username VARCHAR(25) UNIQUE NOT NULL,
  password VARCHAR(25)        NOT NULL,
  fullname VARCHAR(50)        NOT NULL
);

CREATE TABLE Book (
  id          INT(11) PRIMARY KEY AUTO_INCREMENT,
  author      VARCHAR(50)   NOT NULL,
  description VARCHAR(1000) NOT NULL,
  isbn        VARCHAR(10)   NOT NULL,
  title       VARCHAR(250)  NOT NULL,
  reader      VARCHAR(25)   NOT NULL,
  FOREIGN KEY (reader) REFERENCES Reader (username)
);

INSERT INTO Reader (username, password, fullname) VALUES ('Switch', 'password', 'Switch');
INSERT INTO Book (author, description, isbn, title, reader)
VALUES ("Bruce Eckel", "Think in Java", "1234567890", "Java编程思想", "Switch");
