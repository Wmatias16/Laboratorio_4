package negocio;

import java.util.List;

import dominio.Curso;

public interface ICursoNegocio {
	public List<Curso> getCursosDocente(int legajo);
	public int crearCurso(Curso curso);
	public int buscarMax();
	public int altaAlumnoXcurso(int idCurso, String legajo);
}
