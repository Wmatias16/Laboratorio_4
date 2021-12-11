package negocio;

import java.util.ArrayList;

import dominio.Profesor;

public interface IprofesorNegocio {
	public int AltaProfesor(Profesor profe);
	public int BajaProfesor(int legajo);
	public int ModificarProfesor(Profesor profe);
	public ArrayList<Profesor>ListarProfesor();
	public Profesor getProfesorLegajo(String legajo);
	public Profesor getProfesorByEmailAndContrasenia(String email,String contrasennia);
}
