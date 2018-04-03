--------------------------------------------------------------------------------;

drop database samajik_lms_db;
create database samajik_lms_db;
use samajik_lms_db;

----------------------------------Database Created------------------------------;
create table tbl_users(
mid int primary key auto_increment,
sid int not null,
name varchar(50) not null,
regDate timestamp default current_timestamp,
status tinyint(1) default 1
);
------------------------------------tbl_users created ---------------------------;
create table tbl_login(
mid int not null,
email varchar(50),
password varchar(50),
FOREIGN KEY(mid) REFERENCES tbl_users(mid)
);

----------------------------------tbl_login created-------------------------------;

create table tbl_store(
bid int primary key auto_increment,
bookName varchar(50) unique ,
subject varchar(50) ,
author varchar(50) ,
publication varchar(50),
quantity int,
addedDate timestamp default CURRENT_TIMESTAMP
);
----------------------------------tbl_store created--------------------------------;

create table tbl_bucket(
mid int not null,
bid int not null,
issueDate timestamp default current_timestamp,
dueDate timestamp,
FOREIGN KEY(mid) REFERENCES tbl_users(mid),
FOREIGN KEY(bid) REFERENCES tbl_store(bid)
);

----------------------------------tbl_bucket created -----------------------------;

