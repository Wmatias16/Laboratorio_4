package dominio;

public class Seguros {
	private int idSeguro;
	private String descripcion;
	private TipoSeguros tipoSeguro;
	private Double costoContratacion;
	private Double costoAsegurado;
	
	public Seguros()
	{
		
	}
	
	public Seguros(int idSeguro, String descripcion, TipoSeguros tipoSeguro, Double costoContratacion, Double costoAsegurado) {
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
	public TipoSeguros getIdTipo() {
		return tipoSeguro;
	}
	public void setIdTipo(TipoSeguros tipo) {
		this.tipoSeguro = tipo;
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
		return "Seguros [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + tipoSeguro.getId()
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
	
	
}
