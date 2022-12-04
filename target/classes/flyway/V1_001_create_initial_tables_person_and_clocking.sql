create table person (id bigint not null auto_increment, name varchar(255) not null, register_date datetime(6), removed bit, primary key (id)) engine=InnoDB

create table clocking (id bigint not null auto_increment, minutes_duration integer, grade double precision, clocking_description varchar(500),  subject varchar(500), clocking_start_date datetime(6), clocking_finish_date datetime(6), localization varchar(255), person_id bigint not null, removed bit, primary key (id)) engine=InnoDB

alter table clocking add constraint FK887ckl98ya71ifc4uf2nwhyc foreign key (person_id) references person (id)


