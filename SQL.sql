DROP schema IF EXISTS oopproject;

create schema oopproject;

CREATE TABLE user(
    id int auto_increment,
    personalId varchar (128) UNIQUE,
    firstName varchar(128),
    lastName varchar(128),
	birthDate varchar(128),
    mail varchar(128),
    mobile varchar(128),
    password varchar(128),
    primary key (id)
 );
 
 create Table object(
	id int auto_increment,
    userId int,
    objectType int(2),
    objectName varchar(128),
    primary key (id),
    foreign key (userId) references user(id)
 );
 
  create Table card(
	id int auto_increment,
    userId int,
    cardNumber varchar(128) unique,
    cardDate varchar(128),
	firstName varchar(128),
    lastName varchar(128),
    primary key (id),
    foreign key (userId) references user(id)
 );
 
  create Table company(
	id int auto_increment,
	companyName varchar(128),
    primary key (id)
 );
 
  create Table transaction(
	id int auto_increment,
    cardId int,
    amount double,
	companyId int,
    transactionDate varchar(128),
    objectId int,
    primary key (id),
    foreign key (companyId) references company(id),
    foreign key (cardId) references card(id),
    foreign key (objectId) references object(id)
 );
 
  create Table ticket(
	objectId int,
    companyId int,
    ticket varchar(128),
    foreign key (objectId) references object(id),
    foreign key (companyId) references company(id)
 );
 
 
 
 