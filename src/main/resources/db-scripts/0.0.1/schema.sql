-- first drop tables
drop table if exists Item;
drop table if exists UserRole;
drop table if exists RoleAccess;
drop table if exists Menu;
drop table if exists Role;
drop table if exists `User`;
drop table if exists BranchOffice;
drop table if exists Enterprise;
drop table if exists BoardingGate;
drop table if exists BussStation;
drop table if exists Locality;
drop table if exists Region;
drop table if exists Country;

-- second create tables
CREATE TABLE Item (
	id         INT PRIMARY KEY auto_increment,
	name VARCHAR(55),
	createdby  INT NOT NULL,
	lastmodifiedby INT NOT NULL,
	createddate datetime not null,
	lastModifiedDate datetime not null
)engine=InnoDB DEFAULT charset=utf8;

create table BoardingGate
(
   boardinggateid       smallint not null,
   bussstationid        int,
   number               smallint not null,
   description          varchar(55),
   deleted              bool,
   primary key (boardinggateid)
)engine=InnoDB DEFAULT charset=utf8;

create table BranchOffice
(
   enterpriseid         int not null,
   branchofficeid       int not null,
   regionid             int,
   localityid           int,
   name                 varchar(55) not null,
   address              varchar(100) not null,
   phone                varchar(50),
   cargooffice          bool not null,
   ticketoffice         bool not null,
   deleted              bool not null,
   primary key (enterpriseid, branchofficeid)
)engine=InnoDB DEFAULT charset=utf8;

create table BussStation
(
   bussstationid        int not null,
   regionid             int,
   localityid           int,
   name                 varchar(55) not null,
   initials             char(10),
   deleted              bool not null,
   primary key (bussstationid)
)engine=InnoDB DEFAULT charset=utf8;

create table Country
(
   countryid            int not null auto_increment,
   name                 varchar(55) not null,
   initials             char(10) not null,
   deleted              bool not null,
   enterpriseid        smallint not null,
   primary key (countryid)
)engine=InnoDB DEFAULT charset=utf8;

create table Enterprise
(
   enterpriseid         int not null,
   name                 varchar(55) not null,
   businessname         varchar(55) not null,
   primary key (enterpriseid)
)engine=InnoDB DEFAULT charset=utf8;

create table Locality
(
   regionid             int not null,
   localityid           int not null,
   name                 varchar(55) not null,
   initials             char(10) not null,
   deleted              bool not null,
   primary key (regionid, localityid)
)engine=InnoDB DEFAULT charset=utf8;

create table Menu
(
   menuid               int not null,
   men_menuid           int,
   name                 varchar(55),
   icon                 varchar(50),
   url                  varchar(100),
   `order`               smallint,
   level                smallint,
   initial              char(10),
   primary key (menuid)
)engine=InnoDB DEFAULT charset=utf8;

create table Region
(
   regionid             int not null auto_increment,
   countryid            int,
   name                 varchar(55) not null,
   initials             char(10) not null,
   deleted              bool not null,
   primary key (regionid)
)engine=InnoDB DEFAULT charset=utf8;

create table Role
(
   roleid               int not null,
   name                 varchar(55) not null,
   primary key (roleid)
)engine=InnoDB DEFAULT charset=utf8;

create table RoleAccess
(
   roleid               int not null,
   menuid               int not null,
   deleted              bool,
   createby             int,
   lastmodifiedby       int,
   createdate           datetime,
   lastmodifieddate     datetime,
   primary key (roleid, menuid)
)engine=InnoDB DEFAULT charset=utf8;

create table User
(
   userid               int not null,
   enterpriseid         int,
   branchofficeid       int,
   name                 varchar(55) not null,
   lastname             varchar(55) not null,
   identitynumber       varchar(20) not null,
   birthdate            date,
   phone                varchar(50) not null,
   address              varchar(100),
   email                varchar(80) not null,
   password             varchar(128) not null,
   deleted              bool not null,
   createdby            int not null,
   lastmodifiedby       int not null,
   createddate          datetime not null,
   lastmodifieddate     datetime not null,
   primary key (userid)
)engine=InnoDB DEFAULT charset=utf8;

create table UserRole
(
   userid               int not null,
   roleid               int not null,
   deleted              bool not null,
   createdby            int not null,
   lastmodifiedby       int not null,
   createddate          datetime not null,
   lastmodifieddate     datetime not null,
   primary key (userid, roleid)
)engine=InnoDB DEFAULT charset=utf8;

-- third create constraints and foreign keys for relations tables
alter table BoardingGate add constraint fk_rel_11 foreign key (bussstationid)
      references BussStation (bussstationid) on delete restrict on update restrict;

alter table BranchOffice add constraint fk_rel_1 foreign key (enterpriseid)
      references Enterprise (enterpriseid) on delete restrict on update restrict;

alter table BranchOffice add constraint fk_rel_10 foreign key (regionid, localityid)
      references Locality (regionid, localityid) on delete restrict on update restrict;

alter table BussStation add constraint fk_rel_12 foreign key (regionid, localityid)
      references Locality (regionid, localityid) on delete restrict on update restrict;

alter table Locality add constraint fk_rel_9 foreign key (regionid)
      references Region (regionid) on delete restrict on update restrict;

alter table Menu add constraint fk_relati_12 foreign key (men_menuid)
      references Menu (menuid) on delete restrict on update restrict;

alter table Region add constraint fk_rel_8 foreign key (countryid)
      references Country (countryid) on delete restrict on update restrict;

alter table RoleAccess add constraint fk_rela_11 foreign key (roleid)
      references Role (roleid) on delete restrict on update restrict;

alter table RoleAccess add constraint fk_rela_12 foreign key (menuid)
      references Menu (menuid) on delete restrict on update restrict;

alter table User add constraint fk_relationship_2 foreign key (enterpriseid, branchofficeid)
      references BranchOffice (enterpriseid, branchofficeid) on delete restrict on update restrict;

alter table UserRole add constraint fk_rel_3 foreign key (userid)
      references User (userid) on delete restrict on update restrict;

alter table UserRole add constraint fk_rel_4 foreign key (roleid)
      references Role (roleid) on delete restrict on update restrict;

-- fourth create triggers


-- fifth create store procedures


-- sixth create events
