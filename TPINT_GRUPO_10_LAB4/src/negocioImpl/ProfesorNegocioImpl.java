package negocioImpl;

import dominio.Profesor;

import java.util.ArrayList;

import dao.IProfesorDao;
import daoImpl.ProfesorDaoImpl;
import negocio.IprofesorNegocio;;

public class ProfesorNegocioImpl implements IprofesorNegocio {
	
	IProfesorDao ProfeDao = new ProfesorDaoImpl();

	@Override
	public int AltaProfesor(Profesor profe) {		
		return ProfeDao.AgregarDocente(profe);
	}

	@Override
	public int BajaProfesor(int legajo) {
		return ProfeDao.CambiarEstadoProfesor(legajo);
	}

	@Override
	public int ModificarProfesor(Profesor profe) {
		return ProfeDao.ModificarProfesor(profe);
	}

	@Override
	public ArrayList<Profesor> ListarProfesor() {
		return ProfeDao.ListarProfesores();
	}

	@Override
	public Profesor getProfesorLegajo(String legajo) {
		return ProfeDao.getProfesorLegajo(legajo);
	}

	@Override
	public Profesor getProfesorByEmailAndContrasenia(String email, String contrasennia) {
		return ProfeDao.getProfesorByEmailAndContrasenia(email,contrasennia);
	}
	
	
	
}
