package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup?useSSL=false";

	
	public ArrayList<TipoSeguro> getAllTipoSeguro() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<TipoSeguro> lista = new ArrayList<TipoSeguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idTipo,descripcion FROM tipoSeguros");
			
			while(rs.next()){
				
				TipoSeguro tipoSeg = new TipoSeguro();
				tipoSeg.setId(rs.getInt("idTipo"));
				tipoSeg.setDescripcion(rs.getString("descripcion"));
				
				lista.add(tipoSeg);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	
}
