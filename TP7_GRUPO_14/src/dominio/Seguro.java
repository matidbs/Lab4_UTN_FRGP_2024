package dominio;

public class Seguro {
	private int idSeguro;
	private String descripcion;
	private TipoSeguro idTipo;
	private float costoContratacion;
	private float costoAsegurado;
	
	private static int contador = 0;
	
	public Seguro(){
		contador++;
		this.idSeguro = contador;
	}
	
	public Seguro (String desc, TipoSeguro idTipo, float costoC, float costoA){
		contador++;
		this.idSeguro = contador;
		this.descripcion = desc;
		this.idTipo = idTipo;
		this.costoContratacion = costoC;
		this.costoAsegurado = costoA;
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

	public TipoSeguro getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(TipoSeguro idTipo) {
		this.idTipo = idTipo;
	}

	public float getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public float getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Seguro.contador = contador;
	}
	
	
}
