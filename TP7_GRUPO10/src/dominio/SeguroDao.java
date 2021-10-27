package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup?useSSL=false";

	
	public int agregarSeguro(Seguro seguro)
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
			String query = "Insert into seguros(descripcion,idTipo,costoContratacion,costoAsegurado) values ('"+seguro.getDescripcion()+"','"+seguro.getTipoSeguro().getId()+"','"+seguro.getCostoContratacion()+"','"+seguro.getCostoAsegurado()+"')";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public List<Seguro> obtenerSeguros() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Seguro> lista = new ArrayList<>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * FROM seguros");
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt(1));
				seguroRs.setDescripcion(rs.getString(2));
				seguroRs.setTipoSeguro(obtenerTipoSeguro(rs.getInt(3)));
				seguroRs.setCostoContratacion(rs.getDouble(4));
				seguroRs.setCostoAsegurado(rs.getDouble(5));
				
				lista.add(seguroRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	
	public List<Seguro> obtenerSegurosPorTipo(int idTipo) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Seguro> lista = new ArrayList<>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement query = conn.prepareStatement("Select * FROM seguros where idTipo=?");
			query.setInt(1, idTipo); //Cargo el ID recibido
			ResultSet rs = query.executeQuery();		
			
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt(1));
				seguroRs.setDescripcion(rs.getString(2));
				seguroRs.setTipoSeguro(obtenerTipoSeguro(rs.getInt(3)));
				seguroRs.setCostoContratacion(rs.getDouble(4));
				seguroRs.setCostoAsegurado(rs.getDouble(5));
				
				lista.add(seguroRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	
	public TipoSeguro obtenerTipoSeguro (int idTipoSeguro) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TipoSeguro tipoSeguro = new TipoSeguro();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("Select * from tipoSeguros where idTipo = ?");
			miSentencia.setInt(1, idTipoSeguro); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			tipoSeguro.setId(resultado.getInt(1));
			tipoSeguro.setDescripcion(resultado.getString(2));
		    
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		return tipoSeguro;
	}
	
	public int UltimoID() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cant = 0 ;  
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("SELECT count(ifnull(idSeguro,1)) FROM seguros");
			
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			cant = resultado.getInt(1);
			
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
			
		return cant;
	}

	
	
}
