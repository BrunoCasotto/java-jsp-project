drop database if exists tasks;
create database if not exists tasks;

use tasks;

drop table if exists users;
create table if not exists users (
  id int(11) unsigned not null auto_increment,
  email char(100) not null,
  pass char(100) not null,
  primary key (id),
  unique key ex_email (email)
);

drop table if exists tasks;
create table if not exists tasks (
  id int(11) unsigned not null auto_increment,
  userId int(11) unsigned not null,
  title char(200) not null,
  done tinyint(1) default 0,
  primary key (id),
  foreign key (userId) references users(id)
);