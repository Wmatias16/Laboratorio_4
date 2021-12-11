package negocio;

import java.util.List;

import dominio.AlumnoXCurso;

public interface IAlumnoXcursoNegocio {
	public List<AlumnoXCurso> actualizarNotas(String[] notas);
	public List<AlumnoXCurso> getAlumnosXcursoDelCurso(int idCurso);
}
