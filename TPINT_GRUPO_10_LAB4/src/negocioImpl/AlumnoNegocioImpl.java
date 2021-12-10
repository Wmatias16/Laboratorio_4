package negocioImpl;

import java.util.ArrayList;

import dominio.Alumno;
import dao.IAlumnoDao;
import daoImpl.AlumnoDaoImpl;
import negocio.IAlumnoNegocio;

public class AlumnoNegocioImpl implements IAlumnoNegocio{

	private IAlumnoDao alumDao = new AlumnoDaoImpl();
	
	
	public AlumnoNegocioImpl(){
		
	}
	
	
	@Override
	public ArrayList<Alumno> listarAlumnos() {
		return alumDao.getAlumnos();
	}
	
	@Override
	public int altaAlumnos(Alumno alum) {
		return alumDao.agregarAlumno(alum);
	}
	
	@Override
	public Alumno obtenerAlumno(String legajo) {
		return alumDao.getAlumnoLegajo(legajo);
	}
	
	@Override
	public int modificarAlumno(Alumno alum) {
		return alumDao.modificarAlumno(alum);
	}
	
	@Override
	public int bajaAlumnos(int legajo) {
		return alumDao.cambiarEstadoAlumno(legajo);
	}
	
	
}
