package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Curso;
import dominio.Materia;

public interface ICursoDao {
	public int altaCurso(Curso curso);
	public int altaCursoXalumno(int idCurso,String legajoAlumno);
	public int buscarMaxId();
	public ArrayList<Materia> getCursos();
	public Curso getCursoById(int idCurso);
	public List<Curso> getCursosDelDocente(int legajo);
}
