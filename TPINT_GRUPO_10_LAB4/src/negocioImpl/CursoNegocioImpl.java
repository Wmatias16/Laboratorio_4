package negocioImpl;

import java.util.List;

import dao.ICursoDao;
import daoImpl.CursoDaoImpl;
import dominio.Curso;
import negocio.ICursoNegocio;

public class CursoNegocioImpl implements ICursoNegocio{
	private ICursoDao cursoDao = new CursoDaoImpl();

	@Override
	public List<Curso> getCursosDocente(int legajo) {
		return cursoDao.getCursosDelDocente(legajo);
	}

	@Override
	public int crearCurso(Curso curso) {
		return cursoDao.altaCurso(curso);
	}

	@Override
	public int buscarMax() {
		return cursoDao.buscarMaxId();
	}

	@Override
	public int altaAlumnoXcurso(int idCurso, String legajo) {
		return cursoDao.altaCursoXalumno(idCurso, legajo);
	} 
	
	
	
}
