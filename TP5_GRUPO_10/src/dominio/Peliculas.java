package dominio;

public class Peliculas {
	private int id;
	private String nombre;
	private Categorias categoria;	

	public Peliculas() {
	
	}
		
	public Peliculas(int id, String nombre, Categorias categoria) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}	
	
	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + "]";
	}	
	
}
