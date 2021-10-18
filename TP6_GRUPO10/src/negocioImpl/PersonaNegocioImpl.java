package negocioImpl;

import java.util.List;

import dao.IPersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.IPersonaNegocio;

public class PersonaNegocioImpl implements IPersonaNegocio{

	IPersonaDao pdao = new PersonaDaoImpl();
	
	public boolean insert(Persona persona) {
		
		Boolean estado = false;
		
		if(persona.getNombre().trim().length() != 0 && persona.getApellido().trim().length() != 0 && persona.getDni().trim().length() != 0)
		{
			estado = pdao.insert(persona);
		}
		
		return estado;
	}


	public boolean delete(Persona persona) {
		return false;
	}


	public boolean update(Persona persona) {
		return false;
	}

	public List<Persona> getAll() {
		return null;
	}

}
