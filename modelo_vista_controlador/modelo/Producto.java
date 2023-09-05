package modelo;

public class Producto {

	public Producto() {
		
		N_articulo="";
		CodigoProducto="";
		seccion="";
		nombrearticulo="";
		precio=0;
		
	}
	
	public String getN_articulo() {
		return N_articulo;
	}
	public void setN_articulo(String n_articulo) {
		N_articulo = n_articulo;
	}
	public String getCodigoProducto() {
		return CodigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		CodigoProducto = codigoProducto;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getNombrearticulo() {
		return nombrearticulo;
	}
	public void setNombrearticulo(String nombrearticulo) {
		this.nombrearticulo = nombrearticulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getPaises() {
		return paises;
	}

	public void setPaises(String paises) {
		this.paises = paises;
	}
	
	
	private String N_articulo;
	private String CodigoProducto;
	private String seccion;
	private String nombrearticulo;
	private double precio;
	private String paises;

	
}

