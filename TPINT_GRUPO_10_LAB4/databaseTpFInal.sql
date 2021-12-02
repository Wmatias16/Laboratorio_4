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
    contrasenia VARCHAR(50),
	fechaNacimiento DATE,
    direccion VARCHAR(50),
    localidad VARCHAR(50),
    nacionalidad VARCHAR(50),
    telefono varchar(15),
    estado bool
);ALTER TABLE Profesores AUTO_INCREMENT=1000;

CREATE TABLE Materias(
	idMateria INT AUTO_INCREMENT PRIMARY KEY,
    idCarrera INT,
    nombre VARCHAR(45)
);ALTER TABLE Materias AUTO_INCREMENT=1000;

CREATE TABLE Cursos(
	idCurso INT AUTO_INCREMENT PRIMARY KEY,
    idMateria INT,
	legajoDocente INT,
    anio varchar(10)
);ALTER TABLE Materias AUTO_INCREMENT=1;

/*INSERTS DE LAS TABLAS*/

/*ALUMNOS*/
INSERT INTO Alumnos(dni,nombre,apellido,email,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado)
VALUES("12345678","Juan","Perez","alumno@alumno.com","2017-06-15","Juramento 2480","Escobar","Argentina","1190894760",true);


/*PROFESORES*/
INSERT INTO Profesores(dni,nombre,apellido,email,contrasenia,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado)
VALUES("12345678","Juan","Perez","profesor@profesor.com","profesor","2017-06-15","Juramento 2480","Escobar","Argentina","1190894760",true);

/*MATERIAS*/
INSERT INTO Materias(idCarrera,nombre) VALUES(1,"Matematicas");
INSERT INTO Materias(idCarrera,nombre) VALUES(1,"Programacion");
INSERT INTO Materias(idCarrera,nombre) VALUES(1,"Laboratorio");
INSERT INTO Materias(idCarrera,nombre) VALUES(1,"Base de datos");


