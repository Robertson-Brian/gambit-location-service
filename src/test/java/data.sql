INSERT INTO LOCATIONS (street, city, state, zip, company, active)
VALUES ('11730 Plaza America Dr #207', 'Reston', 'Virginia', '20190', 'HQ_Revature', true);

INSERT INTO LOCATIONS (street, city, state,  zip, company, active)  
VALUES ('3220 Banyan Circle', 'Tampa', 'Florida', '33613', 'USF_Revature', true);


INSERT INTO buildings(street_address, building_number, location_id)
VALUES('3220 Banyan Circle', null, 2);

INSERT INTO buildings(street_address, building_number, location_id)
VALUES('11730 Plaza America Dr', '205', 1);


INSERT INTO rooms(room_number, building_id, capacity)
VALUES('101', 1, 25);

INSERT INTO rooms(room_number, building_id, capacity)
VALUES('102', 1, 30);

INSERT INTO rooms(room_number, building_id, capacity)
VALUES('103', 1, 25);

INSERT INTO rooms(room_number, building_id, capacity)
VALUES('200A', 2, 30);

INSERT INTO rooms(room_number, building_id, capacity)
VALUES('200B', 2, 30);


INSERT INTO unavailabilities(start_date, end_date, room_id, comments, batch_id)
VALUES(CURRENT_DATE  ,(CURRENT_DATE + 15), 1, 'Painting and Maintanence', null);

INSERT INTO unavailabilities(start_date, end_date, room_id, comments, batch_id)
VALUES((CURRENT_DATE + 30) ,(CURRENT_DATE + 90), 5, 'Class in session', null);

INSERT INTO unavailabilities(start_date, end_date, room_id, comments, batch_id)
VALUES((CURRENT_DATE - 30) ,(CURRENT_DATE + 60) , 4, 'Class in session', null);