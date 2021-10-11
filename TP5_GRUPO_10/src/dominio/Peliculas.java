package dominio;

public class Peliculas {
	private final int id ;
	private String nombre;
	private Categorias categoria;	
	
	private static int contId = 1;
	
	
	public Peliculas() {
		this.id = contId;
		this.nombre = "";
		this.categoria = new Categorias();
		contId++;
	}
		
	public Peliculas(String nombre, Categorias categoria) {
		this.id = contId;
		this.nombre = nombre;
		this.categoria = categoria;
		contId++;
	}
	
	public int getId() {
		return id;
	}
	
	public static int getContId() {
		return contId;
	}

	public static void setContId(int contId) {
		Peliculas.contId = contId;
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
		return "ID = " + id + ", Nombre = " + nombre + ", Categoría = " + categoria.getNombre();
	}	
	
}
