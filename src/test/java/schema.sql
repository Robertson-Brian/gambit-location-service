CREATE TABLE locations (
 location_id SERIAL PRIMARY KEY,
 street varchar(50) NOT NULL,
 city varchar(25) NOT NULL,
 state varchar(20) NOT NULL,
 zip varchar(10) NOT NULL,
 company varchar(25) NOT NULL,
 active boolean NOT NULL
);

CREATE TABLE buildings (
 building_id SERIAL PRIMARY KEY,
 street_address varchar(50) NOT NULL,
 building_number varchar(10),
 LOCATION_ID integer not null,
 foreign key (LOCATION_ID) references LOCATIONS (LOCATION_ID)
);

CREATE TABLE rooms (
 room_id serial PRIMARY KEY,
 room_number varchar(20) NOT NULL,
 building_id integer NOT NULL,
 capacity integer NOT NULL,
 FOREIGN KEY (building_id) REFERENCES BUILDINGS(BUILDING_ID)
);

CREATE TABLE unavailabilities (
 unavailability_id SERIAL PRIMARY KEY,
 start_date date NOT NULL,
 end_date date NOT NULL,
 room_id integer NOT NULL,
 comments varchar(255),
 batch_id integer,
 FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);
