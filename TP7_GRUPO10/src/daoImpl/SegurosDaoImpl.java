package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.IsegurosDao;
import dominio.Seguros;

public class SegurosDaoImpl implements IsegurosDao{
	
	
	private static final String insert = "INSERT INTO seguros(descripcion, idTipo, costoContratacion,costoAsegurado) VALUES(?, ?, ?,?)";
	
	
	public boolean insert(Seguros seguros) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean estado = false;
		
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, seguros.getDescripcion());
			statement.setInt(2, seguros.getIdTipo().getId());
			statement.setDouble(3, seguros.getCostoContratacion());
			statement.setDouble(4, seguros.getCostoAsegurado());
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
		
}	

