create table delivery (
	id bigint not null auto_increment,
	client_id bigint not null,
	tax decimal(10,2) not null,
	status varchar(20) not null,
	requestDate datetime not null,
	completionDate datetime,
	receiver_name vachar(60) not null,
	receiver_street vachar(255) not null,
	receiver_number varchar(30) not null,
	receiver_complement varchar(60),
	receiver_neighborhood varchar(30) notnull,
	primary key (id)
);

alter table delivery add constraint fk_delivery_client
foreign key (client_id) references client (id);