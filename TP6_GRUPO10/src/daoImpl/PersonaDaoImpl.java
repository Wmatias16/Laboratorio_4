package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean actualizacionExitosa = false;
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE personas SET Nombre = ?, Apellido = ? WHERE Dni = ?");
			preparedStatement.setString(1, persona.getNombre());
			preparedStatement.setString(2, persona.getApellido());
			preparedStatement.setString(3, persona.getDni());
			if (preparedStatement.executeUpdate() > 0) {
				conexion.commit();
				actualizacionExitosa = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizacionExitosa;
	}

	
	public List<Persona> getAll() {
		List<Persona> personas = new ArrayList<>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement("SELECT Dni, Nombre, Apellido FROM personas");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				personas.add(new Persona(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}

	
	public boolean delete(Persona persona) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean borradoExitoso = false;
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM personas WHERE Dni = ?");
			preparedStatement.setString(1, persona.getDni());
			if (preparedStatement.executeUpdate() > 0) {
				conexion.commit();
				borradoExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borradoExitoso;
	}
	
	

}
