DROP TABLE users;
CREATE TABLE USERS
  (
    USER_ID    NUMBER PRIMARY KEY,
    NAME       VARCHAR2(100),
    ADDRESS    VARCHAR2(100),
    EMAIL_ID   VARCHAR2(50)NOT NULL UNIQUE,
    CONTACT_NO VARCHAR2(10)NOT NULL UNIQUE,
    PASSWORD   VARCHAR2(100)NOT NULL
  );
---------------------------------------------------
DROP TABLE region;
CREATE TABLE REGION
  (
    REGION_ID NUMBER PRIMARY KEY,
    CITY      VARCHAR2(240) NOT NULL,
    STATE     VARCHAR2(240)NOT NULL,
    LATTITUDE NUMBER(10,7),
    LONGITUDE NUMBER(10,7)
  );
----------------------------------------------------
DROP TABLE hotel;
CREATE TABLE HOTEL
  (
    REGION_ID       NUMBER REFERENCES REGION (REGION_ID),
    HOTEL_ID        VARCHAR2(240) PRIMARY KEY,
    HOTEL_NAME      VARCHAR2(240)NOT NULL,
    ADDRESS_LINE1   VARCHAR2(240),
    ADDRESS_LINE2   VARCHAR2(240),
    CITY            VARCHAR2(240),
    STATE           VARCHAR2(2),
    ZIP_CODE        NUMBER,
    PHONE_NUMBER    VARCHAR2(50),
    PRICE_PER_NIGHT NUMBER,
    USER_RATINGS    NUMBER
  );
---------------------------------------------------
DROP TABLE mode_of_transport;
CREATE TABLE MODE_OF_TRANSPORT
  (
    MODE_ID   NUMBER PRIMARY KEY,
    MODE_TYPE VARCHAR2(100)
  );
---------------------------------------------------
DROP TABLE mode_air;
CREATE TABLE mode_air
  (
    mode_id        NUMBER REFERENCES MODE_OF_TRANSPORT (mode_id),
    mode_type      VARCHAR2(100),
    service_id     VARCHAR2(240) PRIMARY KEY,
    service_name   VARCHAR2(240),
    price_per_mile VARCHAR2(100)
  );
---------------------------------------------------
DROP TABLE mode_train;
CREATE TABLE mode_train
  (
    mode_id        NUMBER REFERENCES MODE_OF_TRANSPORT (mode_id),
    mode_type      VARCHAR2(100),
    service_id     VARCHAR2(240) PRIMARY KEY,
    service_name   VARCHAR2(240),
    price_per_mile VARCHAR2(100)
  );
---------------------------------------------------
DROP TABLE mode_road;
CREATE TABLE mode_road
  (
    mode_id        NUMBER REFERENCES MODE_OF_TRANSPORT (mode_id),
    mode_type      VARCHAR2(100),
    service_id     VARCHAR2(240) PRIMARY KEY,
    service_name   VARCHAR2(240),
    price_per_mile VARCHAR2(100)
  );
---------------------------------------------------
DROP TABLE offers;
CREATE TABLE OFFERS
  (
    OFFER_ID         NUMBER PRIMARY KEY,
    OFFER_CODE       VARCHAR2(100) UNIQUE,
    DISCOUNT_OFFERED VARCHAR2(100),
    REQUIREMENT      VARCHAR2(100)
  );
---------------------------------------------------
DROP TABLE dependent_details;
CREATE TABLE DEPENDENT_DETAILS
  (
    USER_ID        NUMBER REFERENCES USERS (USER_ID),
    DEPENDENT_NAME VARCHAR2(100),
    relationship   VARCHAR2(50),
    SEX            VARCHAR2(2),
    AGE            NUMBER
  );
---------------------------------------------------
DROP TABLE CUSTOMER_SUPPORT;
CREATE TABLE CUSTOMER_SUPPORT
  (
    EMPLOYEE_ID   NUMBER PRIMARY KEY,
    EMPLOYEE_NAME VARCHAR2(240) ,
    SEX           VARCHAR2(1),
    CONTACT       NUMBER
  );
---------------------------------------------------
DROP TABLE USER_SUPPORT;
CREATE TABLE USER_SUPPORT
  (
    EMPLOYEE_ID       NUMBER PRIMARY KEY,
    EMPLOYEE_NAME     VARCHAR2(240) ,
    SEX               VARCHAR2(1),
    CONTACT           NUMBER,
    AREA_OF_COMPLAINT VARCHAR2(240)
  );
---------------------------------------------------
DROP TABLE TECHNICAL_SUPPORT;
CREATE TABLE TECHNICAL_SUPPORT
  (
    EMPLOYEE_ID   NUMBER PRIMARY KEY,
    EMPLOYEE_NAME VARCHAR2(240) ,
    SEX           VARCHAR2(1),
    CONTACT       NUMBER,
    TECH_LEVEL    VARCHAR2(240)
  );
---------------------------------------------------
DROP TABLE itinerary;
CREATE TABLE ITINERARY
  (
    ITINERARY_ID         NUMBER PRIMARY KEY,
    USER_ID              NUMBER REFERENCES USERS (USER_ID),
    DEPARTURE_CITY       VARCHAR2(100),
    ARRIVAL_CITY         VARCHAR2(100),
    SERVICE_ID           VARCHAR2(240),
    DATE_OF_DEPARTURE    DATE,
    DATE_OF_RETURN       DATE,
    NUMBER_OF_DEPENDENTS NUMBER,
    HOTEL_ID             VARCHAR2(240) REFERENCES hotel(hotel_id),
    TRAVEL_COST          NUMBER,
    HOTEL_COST           NUMBER,
    TOTAL_COST           NUMBER
  );
