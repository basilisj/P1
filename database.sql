--creating lookup tables

create type roles as enum('employee', 'finance_manager');

create table if not exists user_roles(
id int primary key generated always as identity,
roles roles

);
select * from user_roles;
select * from r_type;
select * from r_status;
select * from users;
select * from reimb;
create type reimbursement_type as enum('LODGING', 'TRAVEL', 'FOOD', 'OTHER');

insert into user_roles(role_id, user_role) values (1, 'EMPLOYEE');
insert into user_roles (role_id, user_role) values (2, 'FINANCE_MANAGER');

truncate table user_roles cascade;
truncate table r_type cascade;
truncate table r_status cascade;
truncate table reimb cascade;
truncate table users cascade;

insert into r_type(type_id, reim_type) values (1, 'TRAVEL');
insert into r_type(type_id, reim_type) values (2, 'FOOD');
insert into r_type(type_id, reim_type) values (3, 'LODGING');
insert into r_type(type_id, reim_type) values (4, 'OTHER');

insert into r_status(status_id, status) values (1, 'PENDING');
insert into r_status(status_id, status) values (2, 'DENIED');
insert into r_status(status_id, status) values (3, 'APPROVED');


create table if not exists r_type(
id int primary key generated always as identity,
reimbursement_type reimbursement_type
);

create type reimbursement_status as enum ('Approves', 'Pending', 'Denied');

create table if not exists r_status(
id int primary key generated always as identity,
reimbursement_status reimbursement_status
);

drop table user_roles;
drop table r_type;
drop table r_status;