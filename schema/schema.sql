DROP TABLE mop cascade constraints;
DROP TABLE extended_mop_data cascade constraints;
DROP TABLE truck_driver_ways cascade constraints;
DROP TABLE truck cascade constraints;
DROP TABLE driver cascade constraints;
DROP TABLE company cascade constraints;
DROP TABLE users cascade constraints;

CREATE TABLE mop (
    id NUMBER(10) PRIMARY KEY,
    serial_number NUMBER(10) NOT NULL,
    place VARCHAR(250) NOT NULL,
    extended_id VARCHAR(250) NOT NULL,
    x NUMBER NOT NULL,
    y NUMBER NOT NULL,
    road_number VARCHAR(250) NOT NULL,
	truck_places NUMBER(10) DEFAULT ON NULL 0,
	occupied_truck_places NUMBER(10) DEFAULT ON NULL 0,
	extended_mop_data_id NUMBER(10) NOT NULL
);

CREATE TABLE extended_mop_data (
    id NUMBER(10) PRIMARY KEY,
	organization VARCHAR(250) NOT NULL,
	road_class VARCHAR(250) NOT NULL,
	direction VARCHAR(50) NOT NULL,
	exit_road VARCHAR(50) NOT NULL,
	passenger_places NUMBER(10) DEFAULT ON NULL 0,
	coach_paces NUMBER(10) DEFAULT ON NULL 0,
	is_guarded NUMBER(1,0) NOT NULL,
	is_fenced NUMBER(1,0) NOT NULL,
	is_security_camera NUMBER(1,0) NOT NULL,
	is_petroleum NUMBER(1,0) NOT NULL,
	is_dangerous_cargo NUMBER(1,0) NOT NULL,
	is_restaurant NUMBER(1,0) NOT NULL,
	is_place_to_stay NUMBER(1,0) NOT NULL,
	is_toilet NUMBER(1,0) NOT NULL,
	is_carwash NUMBER(1,0) NOT NULL,
	is_workshop NUMBER(1,0) NOT NULL,
	person_in_charge VARCHAR(100) NOT NULL,
	person_in_charge_phone VARCHAR(50) NOT NULL,
	person_in_charge_email VARCHAR(50) NOT NULL,
	id_mop NUMBER(10) NOT NULL
);

CREATE TABLE truck_driver_ways (
	id NUMBER(10) PRIMARY KEY,
	fuel NUMBER,
	distance NUMBER NOT NULL,
	result_time TIMESTAMP WITH TIME ZONE NOT NULL,
	result_date DATE NOT NULL,
	id_truck NUMBER(10) NOT NULL,
	id_driver NUMBER(10) NOT NULL
);

CREATE TABLE truck (
	id NUMBER(10) PRIMARY KEY,
	registration VARCHAR(250) NOT NULL, 
	brand VARCHAR(250) NOT NULL, 
	model VARCHAR(250) NOT NULL,
	car_year NUMBER(4) NOT NULL,
	id_truck_driver_ways NUMBER(10) NOT NULL,
	id_company NUMBER(10) NOT NULL 
);

CREATE TABLE driver (
	id NUMBER(10) PRIMARY KEY,
	full_name VARCHAR(250) NOT NULL, 
	id_company NUMBER(10) NOT NULL,
	id_truck_driver_ways NUMBER(10) NOT NULL
);

CREATE TABLE company (
	id NUMBER(10) PRIMARY KEY,
	full_name VARCHAR(250) NOT NULL
);

CREATE TABLE users(
	id NUMBER(10) PRIMARY KEY,
	login VARCHAR(250) NOT NULL,
	system_role VARCHAR(10) NOT NULL
);

ALTER TABLE mop
ADD CONSTRAINT FK_MopExtendedMopData 
FOREIGN KEY (extended_mop_data_id)
REFERENCES extended_mop_data(id);

ALTER TABLE extended_mop_data
ADD CONSTRAINT FK_ExtendedMopMop 
FOREIGN KEY (id_mop)
REFERENCES mop(id);

ALTER TABLE truck_driver_ways
ADD CONSTRAINT FK_TruckDriverWaysDriver 
FOREIGN KEY (id_driver)
REFERENCES driver(id);

ALTER TABLE truck_driver_ways
ADD CONSTRAINT FK_TruckDriverWaysTruck 
FOREIGN KEY (id_truck)
REFERENCES truck(id);

ALTER TABLE truck
ADD CONSTRAINT FK_TruckTruckDriverWays 
FOREIGN KEY (id_truck_driver_ways)
REFERENCES truck_driver_ways(id);

ALTER TABLE truck
ADD CONSTRAINT FK_TruckCompany 
FOREIGN KEY (id_company)
REFERENCES company(id);

ALTER TABLE driver
ADD CONSTRAINT FK_DriverTruckDriverWays 
FOREIGN KEY (id_truck_driver_ways)
REFERENCES truck_driver_ways(id);

ALTER TABLE driver
ADD CONSTRAINT FK_DriverCompany 
FOREIGN KEY (id_company)
REFERENCES company(id);