package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.IAdministradorDao;
import dominio.Administrador;

public class AdministradorDaoImpl implements IAdministradorDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tpfinal?useSSL=false";
	
	public Administrador getAdministradorByEmailAndContrasenia(String email, String contrasenia) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Administrador administrador = new Administrador();
		try {
			Connection connection = DriverManager.getConnection(host+dbName,user,pass);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT DISTINCT id, dni, nombre, apellido, email FROM administradores WHERE email = '"+email+"'AND contrasenia ='"+contrasenia+"'");
			while (resultSet.next()) {
				administrador.setId(resultSet.getInt("id"));
				administrador.setDni(resultSet.getString("dni"));
				administrador.setNombre(resultSet.getString("nombre"));
				administrador.setApellido(resultSet.getString("apellido"));
				administrador.setEmail(resultSet.getString("email"));
			}
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return administrador;
	}
}
