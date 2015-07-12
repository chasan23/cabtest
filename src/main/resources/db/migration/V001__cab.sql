CREATE TABLE IF NOT EXISTS ASSIGNMENT (
  ASSIGNMENT_ID INT(11) NOT NULL AUTO_INCREMENT,
  B00KING_ID    INT(11) NOT NULL,
  VEHICLE_ID    INT(5)  NOT NULL,
  DRIVER_ID     INT(11) NOT NULL,
  TIMESTAMP    TIMESTAMP NOT NULL,
  PRIMARY KEY (ASSIGNMENT_ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS BILLING (
  BILLING_ID    INT(11) NOT NULL AUTO_INCREMENT,
  ASSIGNMENT_ID INT(11) NOT NULL,
  AMOUNT        INT(10) NOT NULL,
  PRIMARY KEY (BILLING_ID),
  CONSTRAINT fk_assignment FOREIGN KEY (ASSIGNMENT_ID) REFERENCES ASSIGNMENT (ASSIGNMENT_ID)

)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS BOOKING (
  BOOKING_ID   INT(11)     NOT NULL AUTO_INCREMENT,
  VEHICLE_TYPE VARCHAR(25) NOT NULL,
  TIMESTAMP    TIMESTAMP   NOT NULL,
  ORIGIN_ID    INT(11)     NOT NULL,
  ORIGIN_ADDRESS VARCHAR(255) NOT NULL,
  DESTINATION_ID    INT(11) NOT NULL,
  CUSTOMER_ID  VARCHAR(25) NOT NULL,
  DURATION    INT(11)      NOT NULL,
  PRIMARY KEY (BOOKING_ID),
  CONSTRAINT fk_customer FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID)

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

CREATE TABLE IF NOT EXISTS SETTLEMENT (
  ID           INT(11)     NOT NULL AUTO_INCREMENT,
  DRIVER_ID    INT(11)     NOT NULL,
  VEHICLE_ID   INT(5)      NOT NULL,
  FROM_DATE    TIMESTAMP   NOT NULL,
  TO_DATE      TIMESTAMP   NOT NULL,
  DRIVER_CHARGE FLOAT(11)    NOT NULL,
  SERVICE_CHARGE FLOAT(11)   NOT NULL,
  VEHICLE_CHARGE FLOAT(11)   NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT fk_driver3 FOREIGN KEY (DRIVER_ID) REFERENCES DRIVER (ID),
  CONSTRAINT fk_vehicle3 FOREIGN KEY (VEHICLE_ID) REFERENCES VEHICLE (VEHICLE_ID)

)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS HIBERNATE_SEQUENCES (
  SEQUENCE_NEXT_HI_VALUE INT(11) NOT NULL,
  SEQUENCE_NAME VARCHAR(255)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS DRIVER_AVAILABILITY(
  ID           INT(11)     NOT NULL AUTO_INCREMENT,
  DRIVER_ID    INT(11)     NOT NULL,
  DATE         DATE        NOT NULL,
  TIME_SLOT    INT(3)      NOT NULL,
  LOCATION_ID  INT(11)     NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT fk_driver2 FOREIGN KEY (DRIVER_ID) REFERENCES DRIVER (ID),
  CONSTRAINT fk_location2 FOREIGN KEY (LOCATION_ID) REFERENCES LOCATION (ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS DISTANCE_MATRIX(
  ID           INT(11)     NOT NULL AUTO_INCREMENT,
  LOCATION_A       INT(11)      NOT NULL,
  LOCATION_B       INT(11)      NOT NULL,
  TIME             INT(3)       NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS VEHICLE_AVAILABILITY(
  ID           INT(11)     NOT NULL AUTO_INCREMENT,
  VEHICLE_ID    INT(11)    NOT NULL,
  DATE         DATE        NOT NULL,
  TIME_SLOT    INT(3)      NOT NULL,
  LOCATION_ID  INT(11)     NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT fk_vehicle2 FOREIGN KEY (VEHICLE_ID) REFERENCES VEHICLE (VEHICLE_ID),
  CONSTRAINT fk_location FOREIGN KEY (LOCATION_ID) REFERENCES LOCATION (ID)
)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS DRIVER_VEHICLE(
  ID           INT(11)     NOT NULL AUTO_INCREMENT,
  DRIVER_ID    INT(11)     NOT NULL,
  VEHICLE_ID    INT(11)    NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT fk_vehicle FOREIGN KEY (VEHICLE_ID) REFERENCES VEHICLE (VEHICLE_ID),
  CONSTRAINT fk_driver FOREIGN KEY (DRIVER_ID) REFERENCES DRIVER (ID)

)
  ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS LOCATION(
  ID           INT(11)     NOT NULL AUTO_INCREMENT,
  LOCATION     VARCHAR(255)     NOT NULL,
  DISTRICT     VARCHAR(255)     NOT NULL,
  PROVINCE     VARCHAR(255)     NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE = INNODB;