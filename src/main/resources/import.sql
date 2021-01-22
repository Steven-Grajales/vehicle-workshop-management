insert into users(USER_ID,AFM,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,ROLE,ADDRESS) values ('1','112567892','John','Doe','john@mail.com','pass1234','ADMIN','Baker Street');
insert into users(USER_ID,AFM,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,ROLE,ADDRESS) values ('2','345678923','Jane','Doe','jane@mail.com','pass1234','SIMPLE','Beef Street');
insert into users(USER_ID,AFM,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,ROLE,ADDRESS) values ('3','987456123','Teo','Dora','teo@mail.com','pass1234','SIMPLE','Teo Street');
insert into users(USER_ID,AFM,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,ROLE,ADDRESS) values ('4','123456789','George','Luke','George@mail.com','pass1234','SIMPLE','Bar Street');

insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8357','AUDI','2007','GREY','2');
insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8356','AUDI','2007','GREY','2');
insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8355','AUDI','2007','GREY','1');
insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8354','AUDI','2007','GREY','1');
insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8353','AUDI','2007','GREY','3');
insert into vehicles(PLATENO,CAR_MODEL,YEAR,COLOR,USER_ID) values ('IMA-8352','AUDI','2007','GREY','4');

insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values ('11/10/2017','11:15','Completed','Small','500','1');
insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values ('11/10/2017','09:30','Completed','Big','1000','2');
insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values ('11/10/2017','11:15','Completed','Small','500','1');
insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values ('11/10/2017','09:30','Completed','Big','1000','2');
insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values (DATE_FORMAT(CURDATE(),"%d/%m/%Y"),'11:15','In_Progress','Small','500','1');
insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values (DATE_FORMAT(CURDATE(),"%d/%m/%Y"),'12:30','In_Progress','Big','1000','2');
insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values (DATE_FORMAT(CURDATE(),"%d/%m/%Y"),'13:15','On_Hold','Small','500','3');
insert into repairs(REPAIR_DATE,REPAIR_TIME,REPAIR_STATUS,REPAIR_TYPE,REPAIR_COST,VEHICLE_ID) values (DATE_FORMAT(CURDATE(),"%d/%m/%Y"),'23:30','On_Hold','Big','1000','4');