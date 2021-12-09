package dao;

import dominio.Administrador;

public interface IAdministradorDao {
	public Administrador getAdministradorByEmailAndContrasenia(String email, String contrasenia);
	
}
