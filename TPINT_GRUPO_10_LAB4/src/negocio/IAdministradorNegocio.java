package negocio;

import dominio.Administrador;

public interface IAdministradorNegocio {
	public Administrador getAdministrador(String email, String contrasenia);
}
