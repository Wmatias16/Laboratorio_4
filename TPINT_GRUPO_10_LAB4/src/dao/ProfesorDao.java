package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dominio.Alumno;
import dominio.Profesor;

public class ProfesorDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tpfinal?useSSL=false";
	
	public int AgregarDocente(Profesor profesor) {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		int filas = 0 ;
	
		Connection cn = null;
		try
		{
			String Query ="INSERT INTO Profesores(dni,nombre,apellido,email,contrasenia,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado)VALUES(?,?,?,?,?,?,?,?,?,?,true)";
			cn = DriverManager.getConnection(host+dbName, user,pass);
			PreparedStatement miSentencia = cn.prepareStatement(Query);
			
			miSentencia.setString(1, profesor.getDni());
			miSentencia.setString(2, profesor.getNombre());
			miSentencia.setString(3, profesor.getApellido());
			miSentencia.setString(4, profesor.getEmail());
			miSentencia.setString(5, profesor.getContrasenia());
			miSentencia.setString(6, profesor.getFechaNacimiento());
			miSentencia.setString(7, profesor.getDireccion());
			miSentencia.setString(8, profesor.getLocalidad());
			miSentencia.setString(9, profesor.getNacionalidad());
			miSentencia.setString(10, profesor.getTelefono());

			filas = miSentencia.executeUpdate();	
			System.out.println("Devolvio la base de datos =  " +  filas );
			
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
			ResultSet rs = st.executeQuery("Select legajo,dni,nombre,apellido,fechaNacimiento,direccion,nacionalidad,localidad,email,telefono FROM profesores where estado = 1");			
			
			while (rs.next()) {
				
				Profesor profesorRs = new Profesor();
				
				profesorRs.setLegajo(rs.getInt("legajo"));
				profesorRs.setDni(rs.getString("dni"));
				profesorRs.setNombre(rs.getString("nombre"));
				profesorRs.setApellido(rs.getString("apellido"));
				profesorRs.setEmail(rs.getString("email"));
				profesorRs.setFechaNacimiento("fechaNacimiento");
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
	
	public Profesor getProfesorLegajo(String legajo) {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Profesor profesor = new Profesor();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = (Statement) conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select legajo,dni,contrasenia,nombre,apellido,fechaNacimiento,direccion,nacionalidad,localidad,email,telefono FROM profesores where legajo="+legajo);
			while(rs.next()){
				profesor.setLegajo(rs.getInt("legajo"));
				profesor.setDni(rs.getString("dni"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setApellido(rs.getString("apellido"));
				profesor.setContrasenia(rs.getString("contrasenia"));
				profesor.setFechaNacimiento(rs.getString("fechaNacimiento")); 
				profesor.setDireccion(rs.getString("direccion"));
				profesor.setNacionalidad(rs.getString("nacionalidad"));
				profesor.setLocalidad(rs.getString("localidad"));
				profesor.setEmail(rs.getString("email"));
				profesor.setTelefono(rs.getString("telefono"));				
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return profesor;
	}
	
	public Profesor getProfesorByEmailAndContrasenia(String email, String contrasenia) {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Profesor profesor = new Profesor();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = (Statement) conn.createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT legajo, dni, nombre, apellido, fechaNacimiento, direccion, nacionalidad, localidad, email, telefono FROM profesores WHERE email='"+email+"'AND contrasenia='"+contrasenia+"'"+" AND estado = true");
			while(rs.next()){					
				profesor.setLegajo(rs.getInt("legajo"));
				profesor.setDni(rs.getString("dni"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setApellido(rs.getString("apellido"));
				//profesor.setFechaNacimiento(Date.parse(rs.getString("fechaNacimiento")));
				profesor.setDireccion(rs.getString("direccion"));
				profesor.setNacionalidad(rs.getString("nacionalidad"));
				profesor.setLocalidad(rs.getString("localidad"));
				profesor.setEmail(rs.getString("email"));
				profesor.setTelefono(rs.getString("telefono"));				
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return profesor;
	}
	
	public int ModificarProfesor(Profesor profesor)
	{		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int validar = 0;
		
		Connection cn = null;
		try{
			String query = "update profesores set  dni = ?, nombre = ?, apellido = ?, email = ?, contrasenia = ?, direccion = ?, localidad = ?, nacionalidad = ?, telefono = ? , contrasenia = ? where legajo = ?";
			cn = DriverManager.getConnection(host+dbName, user,pass);
			PreparedStatement miSentencia = cn.prepareStatement(query);
			
			miSentencia.setString(1, profesor.getDni());
			miSentencia.setString(2, profesor.getNombre());
			miSentencia.setString(3, profesor.getApellido());
			miSentencia.setString(4, profesor.getEmail());
			miSentencia.setString(5, profesor.getContrasenia());
			
			//System.out.println("Contraseņa --> " + profesor.getContrasenia() ); 
			//pasa null 
			
			miSentencia.setString(6, profesor.getDireccion());
			miSentencia.setString(7, profesor.getLocalidad());
			miSentencia.setString(8, profesor.getNacionalidad());
			miSentencia.setString(9, profesor.getTelefono());
			miSentencia.setString(10, profesor.getContrasenia());
			miSentencia.setInt(11, profesor.getLegajo());
			
			
			validar = miSentencia.executeUpdate();
						
		    cn.close();
		       
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
		}
		
		return validar;
		
	}	
	
	public void cambiarEstadoAlumno(int legajo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		try{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			PreparedStatement miSentencia = cn.prepareStatement("update alumnos set  estado = false where legajo = ?");
			
			miSentencia.setInt(1, legajo);
			
			miSentencia.executeUpdate();
			
		    cn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
		}
	}
	
	public int CambiarEstadoProfesor(int legajo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int Validar = 0;
		
		Connection cn = null;
		try{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			PreparedStatement miSentencia = cn.prepareStatement("update profesores set  estado = false where legajo = ?");
			
			miSentencia.setInt(1, legajo);
			
			Validar = miSentencia.executeUpdate();
			
		    cn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
		}
		
		return Validar;
	}
	
	
}
