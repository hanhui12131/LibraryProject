drop table bookType

create table bookType(
TypeName Varchar(20),
Id	Int	not null primary key identity(1,1)
)

drop table bookinfo

create table bookInfo(
ISBN Varchar(13) not null primary key,
typeId int not null references bookType(Id),
Bookname Varchar(40) not null,
Writer Varchar(21) not null,
Translater Varchar(30),
Publisher Varchar(50) not null,
Date date not null,
Price float not null
)

drop table userInfo

create table userInfo(
Id Int not null primary key identity(1,1),
Name Varchar(20) not null,
Sex Varchar(6) not null,
Age	int not null,
Identitycard Varchar(30) not null,
Workdate date default GetDate() not null,
Tel	Varchar(20) not null,
Yajin Int not null,
Password Nvarchar(10) not null,
admin Nchar(10) not null
)

drop table readerInfo

create table readerInfo(
rownum int not null primary key identity(1,1),
Name Varchar(10) not null,
Sex Varchar(6) not null,
Age	int not null,
Identitycard Varchar(30) not null,
readDate date default GetDate() not null,
manNum	Int not null,
Tel	Varchar(15) not null,
keepMoney float not null,
Zj Int not null,
Zy Varchar(50) not null,
ISBN Varchar(13) not null,
bztime date not null
)
