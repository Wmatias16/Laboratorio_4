package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IAlumnoXCursoDao;
import dominio.AlumnoXCurso;

public class AlumnoXCursoDaoImpl implements IAlumnoXCursoDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tpfinal?useSSL=false";
	private CursoDaoImpl cursoDaoImpl = new CursoDaoImpl();
	private AlumnoDaoImpl alumnoDaoImpl = new AlumnoDaoImpl();
	
	public List<AlumnoXCurso> getAlumnosXCursoDelCurso(int idCurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<AlumnoXCurso> listaAlumnosXCurso = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT nroInscripcion, idCurso, legajoAlumno, notaPrimerParcial, notaSegundoParcial, notaPrimerRecuperatorio, notaSegundoRecuperatorio, regularidad FROM alumnosxcurso WHERE estado = true AND idCurso = " +idCurso);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				AlumnoXCurso alumnoXCurso = new AlumnoXCurso();
				alumnoXCurso.setNroInscripcion(resultSet.getInt(1));
				alumnoXCurso.setCurso(cursoDaoImpl.getCursoById(resultSet.getInt(2)));
				alumnoXCurso.setAlumno(alumnoDaoImpl.getAlumnoLegajo(String.valueOf(resultSet.getInt(3))));
				alumnoXCurso.setNotaPrimerParcial(resultSet.getDouble(4));
				alumnoXCurso.setNotaSegundoParcial(resultSet.getDouble(5));
				alumnoXCurso.setNotaPrimerRecuperatorio(resultSet.getDouble(6));
				alumnoXCurso.setNotaSegundoRecuperatorio(resultSet.getDouble(7));
				alumnoXCurso.setRegularidad(resultSet.getString(8));
				listaAlumnosXCurso.add(alumnoXCurso);				
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlumnosXCurso;
	}

}
