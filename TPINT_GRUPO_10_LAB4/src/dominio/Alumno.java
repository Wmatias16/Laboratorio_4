package dominio;

public class Alumno extends Persona{
	private int nota;

	public Alumno() {
		
	}
	
	
	public Alumno(int nota) {
		this.nota = nota;
	}
	
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
