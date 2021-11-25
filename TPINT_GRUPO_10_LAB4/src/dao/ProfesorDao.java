package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dominio.Profesor;

public class ProfesorDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "Root";
	private String dbName = "tpfinal?useSSL=false";
	
	public int AgregarDocente(Profesor profesor) {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = (Statement) cn.createStatement();
			String Query ="Insert into alumnos(dni,nombre,apellido,email,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado) values ('"+profesor.getDni()+"','"+profesor.getNombre()+"','"+profesor.getApellido()+"','"+profesor.getEmail()+"','"+profesor.getFechaNacimiento()+"','"+profesor.getDireccion()+"','"+profesor.getLocalidad()+"','"+profesor.getNacionalidad()+"','"+profesor.getTelefono()+"','"+1+"')";
			filas = st.executeUpdate(Query);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return filas;
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
			ResultSet rs = st.executeQuery("Select legajo,dni,nombre,apellido,fechaNacimiento,direccion,nacionalidad,localidad,email,telefono FROM profesor");			
			
			while (rs.next()) {
				
				Profesor profesorRs = new Profesor();
				
				profesorRs.setLegajo(rs.getInt("legajo"));
				profesorRs.setDni(rs.getString("dni"));
				profesorRs.setNombre(rs.getNString("nombre"));
				profesorRs.setApellido(rs.getString("apellido"));
				profesorRs.setEmail(rs.getString("email"));
				//profesorRs.setFechaNacimiento(dbName); corregir ------------------
				profesorRs.setDireccion(rs.getString("direcciom"));
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
