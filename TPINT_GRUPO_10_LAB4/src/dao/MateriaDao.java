package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Materia;

public class MateriaDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "Root";
	private String dbName = "tpfinal?useSSL=false";

	
	public ArrayList<Materia> getMaterias() {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Materia> lista = new ArrayList<Materia>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idMateria,nombre FROM materias");

			while(rs.next()){
				
				Materia materiaRs = new Materia(rs.getInt("idMateria"),rs.getString("nombre"));				
				lista.add(materiaRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	
}
