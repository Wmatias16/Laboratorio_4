package dominio;

public class Profesor extends Persona{
	private String contrasenia;

	
	public Profesor() {
		
	}
	
	public Profesor(int legajo) {
		super.setLegajo(legajo);
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
