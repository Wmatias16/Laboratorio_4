package dao;

import java.util.ArrayList;

import dominio.Materia;

public interface IMateriaDao {
	public ArrayList<Materia> getMaterias();
	public Materia getMateria(int idMateria);
}
