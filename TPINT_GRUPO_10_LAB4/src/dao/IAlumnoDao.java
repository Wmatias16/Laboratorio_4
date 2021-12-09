package dao;

import java.util.ArrayList;

import dominio.Alumno;

public interface IAlumnoDao {
	public int agregarAlumno(Alumno alumno);
	public int modificarAlumno(Alumno alum);
	public ArrayList<Alumno> getAlumnos();
	public Alumno getAlumnoLegajo(String legajo);
	public int cambiarEstadoAlumno(int legajo);
}
