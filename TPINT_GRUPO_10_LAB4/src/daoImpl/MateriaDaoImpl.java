package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.IMateriaDao;
import dominio.Materia;

public class MateriaDaoImpl implements IMateriaDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
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
	
	public Materia getMateria(int idMateria) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Materia materia = new Materia();
		try {
			Connection connection = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT idMateria, idCarrera, nombre FROM materias WHERE idMateria = " +idMateria);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				materia.setId(resultSet.getInt(1));
				materia.setNombre(resultSet.getString(3));
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materia;
	}
	
}
