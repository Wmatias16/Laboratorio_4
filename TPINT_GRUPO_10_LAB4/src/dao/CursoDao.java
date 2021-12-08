package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dominio.Alumno;
import dominio.Curso;
import dominio.Materia;
import dominio.Profesor;

public class CursoDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tpfinal?useSSL=false";
	private MateriaDao materiaDao = new MateriaDao();

	
	
	public int altaCurso(Curso curso) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas = 0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
						
			String query = "Insert into Cursos(idMateria,legajoDocente,semestre,anio) values ('"+curso.getMateria().getId()+"','"+curso.getProfesor().getLegajo()+"','"+curso.getSemestre()+"','"+curso.getAnio()+"')";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return filas;
	}
	
	public void altaCursoXalumno(int idCurso,String legajoAlumno) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
						
			String query = "Insert into AlumnosXcurso(idCurso,legajoAlumno,estado) values ('"+idCurso+"','"+legajoAlumno+"','"+1+"')";
			st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int buscarMaxId() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = 0;
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select max(idcurso) as id from cursos");
			while(rs.next()){
				id = rs.getInt("id");	
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
				
		return id;
	}
		
	
	public ArrayList<Materia> getCursos() {	
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
			
			ResultSet rs = st.executeQuery("Select * FROM cursos");

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
	
	public List<Curso> getCursosDelDocente(int legajo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Curso> cursos = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT idCurso, idMateria, legajoDocente, semestre, anio FROM cursos WHERE legajoDocente = " +legajo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Curso curso = new Curso();
				curso.setId(resultSet.getInt(1));
				curso.setMateria(materiaDao.getMateria(resultSet.getInt(2)));
				curso.setProfesor(new Profesor(resultSet.getInt(3)));
				curso.setSemestre(resultSet.getString(4));
				curso.setAnio(resultSet.getString(5));
				cursos.add(curso);				
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cursos;
	}
}
