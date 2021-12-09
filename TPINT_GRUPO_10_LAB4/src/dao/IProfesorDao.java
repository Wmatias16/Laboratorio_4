package dao;

import java.util.ArrayList;

import dominio.Profesor;

public interface IProfesorDao {
	public int AgregarDocente(Profesor profesor);
	public ArrayList<Profesor> ListarProfesores();
	public Profesor getProfesorLegajo(String legajo);
	public Profesor getProfesorByLegajo(int legajo);
	public Profesor getProfesorByEmailAndContrasenia(String email, String contrasenia);
	public int ModificarProfesor(Profesor profesor);
	public void cambiarEstadoAlumno(int legajo);
	public int CambiarEstadoProfesor(int legajo);
}
