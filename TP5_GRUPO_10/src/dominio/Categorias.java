package dominio;

public class Categorias {
	private String nombre;
	
	public Categorias() {
		
	}
	
	public Categorias(String nombre) {
		this.nombre = nombre;
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categorias [nombre=" + nombre + "]";
	}		
	
}
