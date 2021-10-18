package negocio;

import java.util.List;

import entidad.Persona;

public interface IPersonaNegocio {
	public boolean insert(Persona persona);
	public boolean update(Persona persona);
	public List<Persona> getAll();
	public boolean delete(Persona persona);
}
