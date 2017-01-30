create table ITEM (
  ID int not null AUTO_INCREMENT,
  NAME varchar(100) not null,
  barcode varchar(100),
  purchase_date DATE,
  expiration_date DATE,
  url varchar(1000),
  primary key (id)
);