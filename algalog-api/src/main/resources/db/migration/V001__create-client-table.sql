create table client (
	id bigserial not null,
	name varchar(60) not null,
	email varchar(255) not null,
	phone varchar(20) not null,
	primary key (id)
);