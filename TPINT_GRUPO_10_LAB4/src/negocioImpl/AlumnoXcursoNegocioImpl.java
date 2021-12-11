package negocioImpl;

import java.util.List;

import dao.IAlumnoXCursoDao;
import daoImpl.AlumnoXCursoDaoImpl;
import dominio.AlumnoXCurso;
import negocio.IAlumnoXcursoNegocio;

public class AlumnoXcursoNegocioImpl implements IAlumnoXcursoNegocio{

	private IAlumnoXCursoDao alumXcurDao = new AlumnoXCursoDaoImpl();
	
	@Override
	public List<AlumnoXCurso> actualizarNotas(String[] notas) {
		return alumXcurDao.actualizarNotas(notas);
	}

	@Override
	public List<AlumnoXCurso> getAlumnosXcursoDelCurso(int idCurso) {
		return alumXcurDao.getAlumnosXCursoDelCurso(idCurso);
	}
	
}
