create table delivery (
	id bigint not null auto_increment,
	client_id bigint not null,
	tax decimal(10,2) not null,
	status varchar(20) not null,
	request_date datetime not null,
	completion_date datetime,
	receiver_name varchar(60) not null,
	receiver_street varchar(255) not null,
	receiver_number varchar(30) not null,
	receiver_complement varchar(60),
	receiver_neighborhood varchar(30) not null,
	primary key (id)
);

alter table delivery add constraint fk_delivery_client
foreign key (client_id) references client (id);