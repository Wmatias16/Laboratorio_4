package daoImpl;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dominio.Alumno;
import dominio.Profesor;
import dao.IProfesorDao;;

public class  ProfesorDaoImpl implements IProfesorDao {
	
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
			miSentencia.setDate(6, new Date(profesor.getFechaNacimiento().getTime()));
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
				profesorRs.setFechaNacimiento(new java.util.Date(rs.getDate("fechaNacimiento").getTime()));
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
				profesor.setFechaNacimiento(new java.util.Date(rs.getDate("fechaNacimiento").getTime())); 
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
	
	public Profesor getProfesorByLegajo(int legajo) { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Profesor profesor = new Profesor();
		try{
			Connection connection = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT legajo, dni, nombre, apellido, fechaNacimiento, direccion, nacionalidad, localidad, email, telefono FROM profesores WHERE estado = true AND legajo = " +legajo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){					
				profesor.setLegajo(resultSet.getInt("legajo"));
				profesor.setDni(resultSet.getString("dni"));
				profesor.setNombre(resultSet.getString("nombre"));
				profesor.setApellido(resultSet.getString("apellido"));
				profesor.setFechaNacimiento(new java.util.Date(resultSet.getDate("fechaNacimiento").getTime()));
				profesor.setDireccion(resultSet.getString("direccion"));
				profesor.setNacionalidad(resultSet.getString("nacionalidad"));
				profesor.setLocalidad(resultSet.getString("localidad"));
				profesor.setEmail(resultSet.getString("email"));
				profesor.setTelefono(resultSet.getString("telefono"));				
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}catch(Exception e){
			e.printStackTrace();
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
		try{
			Connection connection = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT legajo, dni, nombre, apellido, fechaNacimiento, direccion, nacionalidad, localidad, email, telefono FROM profesores WHERE email='"+email+"'AND contrasenia='"+contrasenia+"'"+" AND estado = true");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){					
				profesor.setLegajo(resultSet.getInt("legajo"));
				profesor.setDni(resultSet.getString("dni"));
				profesor.setNombre(resultSet.getString("nombre"));
				profesor.setApellido(resultSet.getString("apellido"));
				profesor.setFechaNacimiento(new java.util.Date(resultSet.getDate("fechaNacimiento").getTime()));
				profesor.setDireccion(resultSet.getString("direccion"));
				profesor.setNacionalidad(resultSet.getString("nacionalidad"));
				profesor.setLocalidad(resultSet.getString("localidad"));
				profesor.setEmail(resultSet.getString("email"));
				profesor.setTelefono(resultSet.getString("telefono"));				
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}catch(Exception e){
			e.printStackTrace();
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
			String query = "update profesores set  dni = ?, nombre = ?, apellido = ?, email = ?, contrasenia = ?, direccion = ?, localidad = ?, nacionalidad = ?, telefono = ? , contrasenia = ?, fechaNacimiento = ? where legajo = ?";
			cn = DriverManager.getConnection(host+dbName, user,pass);
			PreparedStatement miSentencia = cn.prepareStatement(query);
			
			miSentencia.setString(1, profesor.getDni());
			miSentencia.setString(2, profesor.getNombre());
			miSentencia.setString(3, profesor.getApellido());
			miSentencia.setString(4, profesor.getEmail());
			miSentencia.setString(5, profesor.getContrasenia());
			
			//System.out.println("Contraseña --> " + profesor.getContrasenia() ); 
			//pasa null 
			
			miSentencia.setString(6, profesor.getDireccion());
			miSentencia.setString(7, profesor.getLocalidad());
			miSentencia.setString(8, profesor.getNacionalidad());
			miSentencia.setString(9, profesor.getTelefono());
			miSentencia.setString(10, profesor.getContrasenia());
			miSentencia.setDate(11, new Date(profesor.getFechaNacimiento().getTime()));
			miSentencia.setInt(12, profesor.getLegajo());
			
			
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
	
	public void cambiarEstadoAlumno(int legajo) { /// ELIMINAR 
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
