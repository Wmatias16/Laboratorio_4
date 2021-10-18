package dao;

import java.util.List;

import entidad.Persona;

public interface IPersonaDao {
	public boolean insert(Persona persona);
	public boolean update(Persona persona);
	public List<Persona> getAll();
	public boolean delete(Persona persona);
}
