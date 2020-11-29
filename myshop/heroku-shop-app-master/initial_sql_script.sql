create database myshopdb;
\c myshopdb;
create table users
(
	id serial
		constraint users_pk
			primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null
);

create table goods
(
	id serial
		constraint goods_pk
			primary key,
	name varchar(50) not null,
	price float not null
);

create table orders
(
    user_id  integer not null
        constraint orders_users_id_fk
            references users
            on update cascade on delete cascade,
    goods_id integer not null
        constraint orders_goods_id_fk
            references goods
            on update cascade on delete cascade,
    id       serial  not null
        constraint orders_pk
            primary key,
    date     varchar,
    quantity integer not null
);