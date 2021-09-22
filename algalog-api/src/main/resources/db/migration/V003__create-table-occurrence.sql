create table occurrence (
	id bigserial not null,
	delivery_id bigint not null,
	description text not null,
	record_date timestamp not null,
	primary key (id)
);

alter table occurrence add constraint fk_occurrence_delivery
foreign key (delivery_id) references delivery (id);