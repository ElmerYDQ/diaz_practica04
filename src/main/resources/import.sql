/* Insertar clientes
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Jose', 'David', 'jose@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Manuel', 'David', 'manuel@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Juan', 'David', 'juan@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Erick', 'David', 'erick@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Joel', 'David', 'joel@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Gerson', 'David', 'gerson@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Alonso', 'David', 'alonso@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Andres', 'David', 'andres@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Jhunior', 'David', 'jhunior@gmail.com', '789456123');
INSERT INTO clientes (nombre, apellido, correo, telefono) values ('Raul', 'David', 'raul@gmail.com', '789456123');

/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('ediaz','$2a$10$Ik7/y1BTKQbOLwIBCxU7c.rh1.DLwtSKoYDeUWApNO6J.QMQAiSNm',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$RV828HIt/NAyote9.7pZcOEDNwyvOSEboGZzPj2uwAyZfcWv8O4Wi',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');