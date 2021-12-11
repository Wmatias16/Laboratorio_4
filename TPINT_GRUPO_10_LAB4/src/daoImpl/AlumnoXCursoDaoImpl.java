package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public String recalcularRegularidad(double notaP1, double notaP2, double notaR1, double notaR2) {
		String regularidad;
		if(notaP1 >= 6 && notaP2 >=6) {
			regularidad = "Regular";
			return regularidad;
		}
		if(notaP1 >= 6 && notaP2 < 6 && notaR2 >= 6) {
			regularidad = "Regular";
			return regularidad;
		}
		if(notaP1 < 6 && notaP2 >= 6 && notaR1 >= 6) {
			regularidad = "Regular";
			return regularidad;
		}
		if(notaP1 < 6 && notaP2 < 6 && notaR1 >= 6 && notaR2 >= 6) {
			regularidad = "Regular";
			return regularidad;
		} else {
			regularidad = "Libre";
			return regularidad;
		}
		
	}
	
	public List<AlumnoXCurso> actualizarNotas(String[] notas) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < notas.length; i+=5) {
				Connection connection = DriverManager.getConnection(host+dbName,user,pass);
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alumnosxcurso SET notaPrimerParcial = ?, notaSegundoParcial = ?, notaPrimerRecuperatorio = ?, notaSegundoRecuperatorio = ?, regularidad = ? WHERE nroInscripcion = ?");
				preparedStatement.setDouble(1, Double.parseDouble(notas[i]));
				preparedStatement.setDouble(2, Double.parseDouble(notas[i+1]));
				preparedStatement.setDouble(3, Double.parseDouble(notas[i+2]));
				preparedStatement.setDouble(4, Double.parseDouble(notas[i+3]));
				preparedStatement.setString(5, recalcularRegularidad(Double.parseDouble(notas[i]), Double.parseDouble(notas[i+1]), Double.parseDouble(notas[i+2]), Double.parseDouble(notas[i+3])));
				preparedStatement.setInt(6, Integer.parseInt(notas[i+4]));
                preparedStatement.execute();
                preparedStatement.close();
                connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int idCurso = -1;
		try {
			Connection connection = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT idCurso FROM alumnosxcurso WHERE nroInscripcion = " +Integer.parseInt(notas[4]));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				idCurso =  resultSet.getInt(1);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<AlumnoXCurso> listaAlumnosXCurso = getAlumnosXCursoDelCurso(idCurso);
		return listaAlumnosXCurso;
	}

}
