/*
    Create database ams
 */
    create database ams;

/*
    Create table account
 */

create table account
(
    id             int not null primary key auto_increment,
    full_name      varchar(255),
    account_number varchar(255) unique,
    amount         int,
    email          varchar(255),
    phone          varchar(255),
    location       varchar(255)
);

/*
    Create table transactions
 */

create table transactions
(
    id               int not null primary key auto_increment,
    account_number   varchar(255),
    type             varchar(255),
    amount           int,
    transaction_date timestamp,
    foreign key (account_number) references account (account_number)
);

