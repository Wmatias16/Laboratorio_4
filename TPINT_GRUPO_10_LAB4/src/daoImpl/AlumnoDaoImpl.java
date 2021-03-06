package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import dao.IAlumnoDao;
import dominio.Alumno;

public class AlumnoDaoImpl implements IAlumnoDao{
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tpfinal?useSSL=false";

	
	public int agregarAlumno(Alumno alumno)
	{
		
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
			Statement st = cn.createStatement();
			int estado = 1;
			
			String dni = alumno.getDni();
			System.out.print(dni);
			
			String query = "Insert into alumnos(dni,nombre,apellido,email,fechaNacimiento,direccion,localidad,nacionalidad,telefono,estado) values ('"+alumno.getDni()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"','"+alumno.getEmail()+"','"+new Date(alumno.getFechaNacimiento().getTime())+"','"+alumno.getDireccion()+"','"+alumno.getLocalidad()+"','"+alumno.getNacionalidad()+"','"+alumno.getTelefono()+"','"+estado+"')";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}	
	
	public int modificarAlumno(Alumno alum)
	{		
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
			PreparedStatement miSentencia = cn.prepareStatement("update alumnos set  dni = ?, nombre = ?, apellido = ?, email = ?, direccion = ?, localidad = ?, nacionalidad = ?, telefono = ?, fechaNacimiento = ? where legajo = ?");
			
			miSentencia.setString(1, alum.getDni());
			miSentencia.setString(2, alum.getNombre());
			miSentencia.setString(3, alum.getApellido());
			miSentencia.setString(4, alum.getEmail());
			miSentencia.setString(5, alum.getDireccion());
			miSentencia.setString(6, alum.getLocalidad());
			miSentencia.setString(7, alum.getNacionalidad());
			miSentencia.setString(8, alum.getTelefono());
			miSentencia.setDate(9, new Date(alum.getFechaNacimiento().getTime()));
			miSentencia.setInt(10, alum.getLegajo());

			Validar = miSentencia.executeUpdate();
			
		    cn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		return Validar;
	}	
	
	public ArrayList<Alumno> getAlumnos() {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select legajo,dni,nombre,apellido,fechaNacimiento,direccion,nacionalidad,localidad,email,telefono FROM alumnos where estado = 1");

			while(rs.next()){
				
				Alumno usuarioRs = new Alumno();
				usuarioRs.setLegajo(rs.getInt("legajo"));
				usuarioRs.setDni(rs.getString("dni"));
				usuarioRs.setNombre(rs.getString("nombre"));
				usuarioRs.setApellido(rs.getString("apellido"));
				usuarioRs.setFechaNacimiento(new java.util.Date(rs.getDate("fechaNacimiento").getTime()));
				usuarioRs.setDireccion(rs.getString("direccion"));
				usuarioRs.setNacionalidad(rs.getString("nacionalidad"));
				usuarioRs.setLocalidad(rs.getString("localidad"));
				usuarioRs.setEmail(rs.getString("email"));
				usuarioRs.setTelefono(rs.getString("telefono"));
				
				lista.add(usuarioRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Alumno getAlumnoLegajo(String legajo) {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Alumno usuarioRs = new Alumno();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select legajo,dni,nombre,apellido,fechaNacimiento,direccion,nacionalidad,localidad,email,telefono FROM alumnos where legajo="+legajo);
			while(rs.next()){
				usuarioRs.setLegajo(rs.getInt("legajo"));
				usuarioRs.setDni(rs.getString("dni"));
				usuarioRs.setNombre(rs.getString("nombre"));
				usuarioRs.setApellido(rs.getString("apellido"));
				usuarioRs.setFechaNacimiento(new java.util.Date(rs.getDate("fechaNacimiento").getTime()));
				usuarioRs.setDireccion(rs.getString("direccion"));
				usuarioRs.setNacionalidad(rs.getString("nacionalidad"));
				usuarioRs.setLocalidad(rs.getString("localidad"));
				usuarioRs.setEmail(rs.getString("email"));
				usuarioRs.setTelefono(rs.getString("telefono"));				
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return usuarioRs;
	}
	
	public int cambiarEstadoAlumno(int legajo) {
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
			PreparedStatement miSentencia = cn.prepareStatement("update alumnos set  estado = false where legajo = ?");
			
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
