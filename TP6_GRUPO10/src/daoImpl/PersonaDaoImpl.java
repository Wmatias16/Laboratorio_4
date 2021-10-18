package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.IPersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements IPersonaDao{

	private static final String insert = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	
	public boolean insert(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean estado = false;
		
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				estado = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
		return estado;
	}

	
	public boolean update(Persona persona) {
		return false;
	}

	
	public List<Persona> getAll() {
		return null;
	}

	
	public boolean delete(Persona persona) {
		return false;
	}

}
