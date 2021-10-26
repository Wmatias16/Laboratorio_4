package dominio;

public class Seguro {
	private int idSeguro;
	private String descripcion;
	private TipoSeguro tipoSeguro;
	private Double costoContratacion;
	private Double costoAsegurado;
	
	public Seguro()
	{
		
	}
	
	public Seguro(int idSeguro, String descripcion, TipoSeguro tipoSeguro, Double costoContratacion, Double costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.tipoSeguro = tipoSeguro;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public Double getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(Double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public Double getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(Double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + tipoSeguro.getId()
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
	
	
}
