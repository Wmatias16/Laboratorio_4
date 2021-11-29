package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dominio.Profesor;

public class ProfesorDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tpfinal?useSSL=false";
	
	public void AgregarDocente(Profesor profesor) {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		Connection cn = null;
		try
		{
			String Query ="INSERT INTO Profesores(dni,nombre,apellido,email,password,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado)VALUES(?,?,?,?,?,?,?,?,?,?,true)";
			cn = DriverManager.getConnection(host+dbName, user,pass);
			PreparedStatement miSentencia = cn.prepareStatement(Query);
			
			miSentencia.setString(1, profesor.getDni());
			miSentencia.setString(2, profesor.getNombre());
			miSentencia.setString(3, profesor.getApellido());
			miSentencia.setString(4, profesor.getEmail());
			miSentencia.setString(5, profesor.getContraseña());
			miSentencia.setString(6, "2017-06-15");
			miSentencia.setString(7, profesor.getDireccion());
			miSentencia.setString(8, profesor.getLocalidad());
			miSentencia.setString(9, profesor.getNacionalidad());
			miSentencia.setString(10, profesor.getTelefono());

			miSentencia.executeUpdate();			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Profesor> ListarProfesores(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Profesor> lista = new ArrayList<Profesor>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = (Statement) cn.createStatement();
			ResultSet rs = st.executeQuery("Select legajo,dni,nombre,apellido,fechaNacimiento,direccion,nacionalidad,localidad,email,telefono FROM profesores");			
			
			while (rs.next()) {
				
				Profesor profesorRs = new Profesor();
				
				profesorRs.setLegajo(rs.getInt("legajo"));
				profesorRs.setDni(rs.getString("dni"));
				profesorRs.setNombre(rs.getString("nombre"));
				profesorRs.setApellido(rs.getString("apellido"));
				profesorRs.setEmail(rs.getString("email"));
				//profesorRs.setFechaNacimiento(dbName); corregir ------------------
				profesorRs.setDireccion(rs.getString("direccion"));
				profesorRs.setNacionalidad(rs.getString("nacionalidad"));
				profesorRs.setLocalidad(rs.getString("localidad"));
				profesorRs.setTelefono(rs.getString("telefono"));
				
				lista.add(profesorRs);
							}
			
			cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
}
