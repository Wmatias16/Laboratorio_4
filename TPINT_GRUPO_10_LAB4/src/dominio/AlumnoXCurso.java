package dominio;

public class AlumnoXCurso {
	private int nroInscripcion;
	private Curso curso;
	private Alumno alumno;
	private double notaPrimerParcial;
	private double notaSegundoParcial;
	private double notaPrimerRecuperatorio;
	private double notaSegundoRecuperatorio;
	private String regularidad;
	private boolean estado;
	
	public AlumnoXCurso() {
		
	}

	public int getNroInscripcion() {
		return nroInscripcion;
	}

	public void setNroInscripcion(int nroInscripcion) {
		this.nroInscripcion = nroInscripcion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public double getNotaPrimerParcial() {
		return notaPrimerParcial;
	}

	public void setNotaPrimerParcial(double notaPrimerParcial) {
		this.notaPrimerParcial = notaPrimerParcial;
	}

	public double getNotaSegundoParcial() {
		return notaSegundoParcial;
	}

	public void setNotaSegundoParcial(double notaSegundoParcial) {
		this.notaSegundoParcial = notaSegundoParcial;
	}

	public double getNotaPrimerRecuperatorio() {
		return notaPrimerRecuperatorio;
	}

	public void setNotaPrimerRecuperatorio(double notaPrimerRecuperatorio) {
		this.notaPrimerRecuperatorio = notaPrimerRecuperatorio;
	}

	public double getNotaSegundoRecuperatorio() {
		return notaSegundoRecuperatorio;
	}

	public void setNotaSegundoRecuperatorio(double notaSegundoRecuperatorio) {
		this.notaSegundoRecuperatorio = notaSegundoRecuperatorio;
	}

	public String getRegularidad() {
		return regularidad;
	}

	public void setRegularidad(String regularidad) {
		this.regularidad = regularidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
