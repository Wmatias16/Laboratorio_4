package dao;

import java.util.List;

import dominio.AlumnoXCurso;

public interface IAlumnoXCursoDao {
	public List<AlumnoXCurso> getAlumnosXCursoDelCurso(int idCurso);
	public List<AlumnoXCurso> actualizarNotas(String[] notas);
}
