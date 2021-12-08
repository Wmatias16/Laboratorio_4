DROP DATABASE TPFINAL;

CREATE DATABASE TPFinal;

USE TPFinal;

CREATE TABLE Alumnos(
	legajo INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(10) UNIQUE,
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
    dni VARCHAR(10) UNIQUE,
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

CREATE TABLE Administradores(
	id INT AUTO_INCREMENT PRIMARY KEY,
	dni VARCHAR(10) UNIQUE,
    nombre VARCHAR(45),
    apellido VARCHAR(50),
    email VARCHAR(40),
    contrasenia VARCHAR(50)
);

CREATE TABLE Carreras(
	idCarrera INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100)
);

CREATE TABLE Materias(
	idMateria INT AUTO_INCREMENT PRIMARY KEY,
    idCarrera INT,
    nombre VARCHAR(100),
    FOREIGN KEY (idCarrera) REFERENCES Carreras (idCarrera) ON DELETE CASCADE
);

CREATE TABLE Cursos(
	idCurso INT AUTO_INCREMENT PRIMARY KEY,
    idMateria INT,
	legajoDocente INT,
    semestre VARCHAR(30),
    anio varchar(10),
    FOREIGN KEY (idMateria) REFERENCES Materias (idMateria) ON DELETE CASCADE,
    FOREIGN KEY (legajoDocente) REFERENCES Profesores (legajo) ON DELETE CASCADE
);

CREATE TABLE AlumnosXcurso(
	nroInscripcion INT AUTO_INCREMENT PRIMARY KEY,
    idCurso INT,
    legajoAlumno INT,
    estado BOOL,
    regularidad VARCHAR(15),
    FOREIGN KEY (idCurso) REFERENCES Cursos (idCurso) ON DELETE CASCADE,
    FOREIGN KEY (legajoAlumno) REFERENCES Alumnos (legajo) ON DELETE CASCADE
);

CREATE TABLE Notas(
	idNota INT AUTO_INCREMENT PRIMARY KEY,
    idCurso INT,
    legajoAlumno INT,
    tipo INT,
    calificacion DOUBLE,
    FOREIGN KEY (idCurso) REFERENCES Cursos (idCurso) ON DELETE CASCADE,
    FOREIGN KEY (legajoAlumno) REFERENCES Alumnos (legajo) ON DELETE CASCADE
);

/*INSERTS DE LAS TABLAS*/

/*ALUMNOS*/
INSERT INTO Alumnos (dni, nombre, apellido, email, fechaNacimiento, direccion, localidad, nacionalidad, telefono, estado) VALUES
("39100100", "Juan", "Pérez", "jperez@alumno.com", "1995-06-15", "Juramento 2480", "Escobar", "Argentina", "1190894760", true),
("39100101", "Roberto", "Gómez", "rgomez@alumno.com", "1995-06-16", "Cabildo 250", "Tigre", "Argentina", "1190894587", true),
("39100102", "Carlos", "López", "clopez@alumno.com", "1995-06-17", "Congreso 420", "Martínez", "Argentina", "1165734587", true),
("42100105", "Josefina", "Sánchez", "jsanchez@alumno.com", "2001-11-12", "Asunción 682", "San Fernando", "Argentina", "1133557651", true),
("42300222", "Carla", "Rodríguez", "crodriguez@alumno.com", "2002-02-07", "Lima 1620", "San Isidro", "Argentina", "1159895783", true);

/*PROFESORES*/
INSERT INTO Profesores (dni, nombre, apellido, email, contrasenia, fechaNacimiento, direccion, localidad, nacionalidad, telefono, estado) VALUES
("12345678", "Sara", "Sánchez", "ssanchez@profesor.com", "sara123", "1960-06-15", "Juramento 280", "General Pacheco", "Argentina", "1159622688", true),
("30365678", "Lara", "Pintos", "lpintos@profesor.com", "lara123", "1987-11-25", "Obligado 420", "Tigre", "Argentina", "1199613388", true);

/*ADMINISTRADORES*/
INSERT INTO Administradores(dni, nombre, apellido, email, contrasenia) VALUES
('39100664', 'Eduardo', 'Granado', 'eduardo@gmail.com', '12345');

/*CARRERAS*/
INSERT INTO Carreras (nombre) VALUES
("Tecnicatura Universitaria en Programación");

/*MATERIAS*/
INSERT INTO Materias (idCarrera, nombre) VALUES
(1, "Matemática"),
(1, "Programación I"),
(1, "Laboratorio I"),
(1, "Inglés I"),
(1, "Sistemas de Procesamiento de Datos"),
(1, "Probabilidad y Estadística"),
(1, "Inglés II"),
(1, "Programación II"),
(1, "Laboratorio II"),
(1, "Metodología de Sistemas I"),
(1, "Elementos de Investigación Operativa"),
(1, "Programación III"),
(1, "Laboratorio III"),
(1, "Laboratorio IV"),
(1, "Legislación");

/* CURSOS */
INSERT INTO Cursos (idMateria, legajoDocente, semestre, anio) VALUES
(1, 1000, "Primer semestre", "2021");

/* ALUMNOSXCURSO */
INSERT INTO AlumnosXcurso (idCurso, legajoAlumno, estado, regularidad) VALUES
(1, 1000, true, "Regular"),
(1, 1001, true, "Libre"),
(1, 1002, true, "Libre"),
(1, 1003, true, "Regular"),
(1, 1004, true, "Regular");

/* NOTAS */
INSERT INTO Notas (idCurso, legajoAlumno, tipo, calificacion) VALUES
(1, 1000, 1, 7.50),
(1, 1000, 2, 7),
(1, 1001, 1, 4),
(1, 1001, 2, 5),
(1, 1001, 3, 6),
(1, 1001, 4, 4),
(1, 1002, 1, 2),
(1, 1002, 2, 2.50),
(1, 1003, 1, 6),
(1, 1003, 2, 5),
(1, 1003, 4, 8.50),
(1, 1004, 1, 4),
(1, 1004, 2, 8),
(1, 1004, 3, 6.50);