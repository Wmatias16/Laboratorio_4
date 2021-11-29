DROP DATABASE TPFINAL;

CREATE DATABASE TPFinal;

USE TPFinal;

CREATE TABLE Alumnos(
	legajo INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(8) UNIQUE,
    nombre VARCHAR(45),
    apellido VARCHAR(50),
    email VARCHAR(40),
	fechaNacimiento DATE,
    direccion VARCHAR(50),
    localidad VARCHAR(50),
    nacionalidad VARCHAR(50),
    telefono varchar(15),
    estado bool
);ALTER TABLE Alumnos AUTO_INCREMENT=1000;

CREATE TABLE Profesores(
	legajo INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(8) UNIQUE,
    nombre VARCHAR(45),
    apellido VARCHAR(50),
    email VARCHAR(40),
    password VARCHAR(50),
	fechaNacimiento DATE,
    direccion VARCHAR(50),
    localidad VARCHAR(50),
    nacionalidad VARCHAR(50),
    telefono varchar(15),
    estado bool
);ALTER TABLE Profesores AUTO_INCREMENT=1000;

/*INSERTS DE LAS TABLAS*/

INSERT INTO Alumnos(dni,nombre,apellido,email,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado)
VALUES("12345678","Juan","Perez","alumno@alumno.com","2017-06-15","Juramento 2480","Escobar","Argentina","1190894760",true);

INSERT INTO Profesores(dni,nombre,apellido,email,contraseña,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado)
VALUES("12345678","Juan","Perez","profesor@profesor.com","profesor","2017-06-15","Juramento 2480","Escobar","Argentina","1190894760",true);
