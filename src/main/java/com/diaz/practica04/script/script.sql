create database clientes2;

create table clientes(
	id int auto_increment primary key,
	apellido varchar(50) not null,
	nombre varchar(50) not null,
	correo varchar(50) not null unique,
	telefono varchar(9) not null
);