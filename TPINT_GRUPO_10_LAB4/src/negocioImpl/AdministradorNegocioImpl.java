package negocioImpl;

import dao.IAdministradorDao;
import daoImpl.AdministradorDaoImpl;
import dominio.Administrador;
import negocio.IAdministradorNegocio;

public class AdministradorNegocioImpl implements IAdministradorNegocio{

	private IAdministradorDao aDao = new AdministradorDaoImpl(); 
	
	public Administrador getAdministrador(String email, String contrasenia) {
		return aDao.getAdministradorByEmailAndContrasenia(email, contrasenia);
	}

}
