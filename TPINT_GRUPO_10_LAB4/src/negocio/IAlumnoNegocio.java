package negocio;

import java.util.ArrayList;

import dominio.Alumno;

public interface IAlumnoNegocio {
	public ArrayList<Alumno> listarAlumnos();
	public int altaAlumnos(Alumno alum);
	public int modificarAlumno(Alumno alum);
	public Alumno obtenerAlumno(String legajo);
	public int bajaAlumnos(int legajo);
}
