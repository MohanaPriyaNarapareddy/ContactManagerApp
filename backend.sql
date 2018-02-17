
DROP DATABASE IF EXISTS contactmngr;
CREATE DATABASE contactmngr;


-- Creating Company Schema
USE contactmngr;

DROP TABLE IF EXISTS PERSON;
CREATE TABLE PERSON (
  fname        varchar(25) not null,
  mname        varchar(25) not null,
  lname        varchar(25) not null,
  bdate    date,
  contact_id int(5),
  CONSTRAINT pk_person primary key (contact_id),
  CONSTRAINT CHECK_CM CHECK (bdate <= sysdate)
);


DROP TABLE IF EXISTS E_MAILS;
CREATE TABLE E_MAILS (  MAIL_id  VARCHAR(200),contact_id int(5),
  type varchar(20) ,
  name varchar(15), 
  CONSTRAINT pk_email primary key (mail_id,contact_id),
  CONSTRAINT fk_email foreign key (contact_id) references PERSON (contact_id)
);
DROP TABLE IF EXISTS PHONE;
CREATE TABLE PHONE (  number  varchar(20),contact_id int(20),
  type varchar(20) ,
  code int(5), 
  CONSTRAINT pk_phone primary key (number,contact_id),
  CONSTRAINT fk_phone foreign key (contact_id) references PERSON (contact_id)
);
DROP TABLE IF EXISTS ADDRESS;
CREATE TABLE ADDRESS (  add_id  int(20),contact_id int(20),
  country varchar(20) , state varchar(20), city varchar(20),street varchar(20),type varchar(20),
  CONSTRAINT pk_add primary key (add_id,contact_id),
  CONSTRAINT fk_add foreign key (contact_id) references PERSON (contact_id)
);


select * from person where contact_id='89';
INSERT INTO PERSON VALUES ('Raman','mohan','grill','c','10');
INSERT INTO PERSON VALUES ('williams','waren','louis','1986-08-29','29');
INSERT INTO PERSON VALUES ('Klan','rohan','lend','1977-06-26','12');
INSERT INTO PERSON VALUES ('john','blan','kalan','1980-08-29','15');
INSERT INTO PERSON VALUES ('williams','waren','louis','1986-08-29','21');
INSERT INTO PERSON VALUES ('samul','mourian','bing','1980-08-29','26');

INSERT INTO E_MAILS VALUES ('mhgvv@gmail.com','10','primary','Raman');
INSERT INTO E_MAILS VALUES ('klan@gmail.com','12','primary','Klan');
INSERT INTO E_MAILS VALUES('samul@gmail.com','26','secondary','samul');

INSERT INTO PHONE VALUES ('4256870010','10','primary','01');
INSERT INTO PHONE VALUES ('4256870017','21','primary','01');
INSERT INTO PHONE VALUES ('4256870567','15','secondary','01');
INSERT INTO contactmngr.address VALUES ('4','10','united states','texas','dallas','Maccalum','office');
INSERT INTO contactmngr.address VALUES ('6','26','united states','carolena','charllette','chattam','primary');
INSERT INTO contactmngr.address VALUES ('8','26','united states','ohio','Boston','ashparks','primary');

SELECT * FROM PERSON;
SELECT * FROM GROUPS;
SELECT * FROM BELONGS_TO;

SELECT * FROM ADDRESS;
SELECT * FROM PHONE;
SELECT * FROM E_MAILS;

