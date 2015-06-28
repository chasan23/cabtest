CREATE TABLE IF NOT EXISTS ASSIGNMENT (
  ASSIGNMENT_ID INT(11) NOT NULL AUTO_INCREMENT,
  B00KING_ID    INT(11) NOT NULL,
  VEHICLE_ID    INT(5)  NOT NULL,
  DRIVER_ID     INT(11) NOT NULL,
  TIMESTAMP    TIME        NOT NULL,
  PRIMARY KEY (ASSIGNMENT_ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS BILLING (
  BILLING_ID    INT(11) NOT NULL AUTO_INCREMENT,
  ASSIGNMENT_ID INT(11) NOT NULL,
  AMOUNT        INT(10) NOT NULL,
  PRIMARY KEY (BILLING_ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS BOOKING (
  BOOKING_ID   INT(11)     NOT NULL AUTO_INCREMENT,
  VEHICLE_TYPE VARCHAR(25) NOT NULL,
  TIMESTAMP    TIME        NOT NULL,
  LOCATION     VARCHAR(25) NOT NULL,
  CUSTOMER_ID  VARCHAR(25),
  PRIMARY KEY (BOOKING_ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS CUSTOMER (
  ID INT(10)      NOT NULL AUTO_INCREMENT,
  FIRST_NAME  VARCHAR(200) NOT NULL,
  LAST_NAME   VARCHAR(200) NOT NULL,
  CONTACT_ID  INT(10)      NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS LOGIN (
  USER_ID  VARCHAR(10) NOT NULL,
  PASSWORD VARCHAR(10) NOT NULL,
  PRIMARY KEY (USER_ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS VEHICLE (
  VEHICLE_ID   INT(5)      NOT NULL AUTO_INCREMENT,
  REG_NUMBER   VARCHAR(25) NOT NULL,
  VEHICLE_TYPE VARCHAR(25) NOT NULL,
  MODEL        VARCHAR(25) NOT NULL,
  AVAILABILITY CHAR(1)     NOT NULL,
  PRIMARY KEY (VEHICLE_ID)
)
  ENGINE = INNODB;


CREATE TABLE IF NOT EXISTS CONTACT (
  CONTACT_ID INT(10)      NOT NULL AUTO_INCREMENT,
  HOME_PH    VARCHAR(20)  NOT NULL,
  MOBILE_PH  VARCHAR(20)  NOT NULL,
  E_MAIL     VARCHAR(100) NOT NULL,
  ADDRESS    VARCHAR(100) NOT NULL,
  PRIMARY KEY (CONTACT_ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS DRIVER (
  ID    INT(11)     NOT NULL AUTO_INCREMENT,
  FIRST_NAME   VARCHAR(20) NOT NULL,
  LAST_NAME    VARCHAR(20) NOT NULL,
  AGE          INT(3)      NOT NULL,
  CONTACT_ID   INT(10)     NOT NULL,
  AVAILABILITY CHAR(1)     NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY (CONTACT_ID),
  CONSTRAINT fk_contact FOREIGN KEY (CONTACT_ID) REFERENCES CONTACT (CONTACT_ID)
)
  ENGINE = INNODB;