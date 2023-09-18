package com.breinner.aprende;

import java.util.Date;

public class Productos {

	private String codigo_articulo;
	private String seccion;
	private String mombre_articulo;
	private double precio;
	private Date fecha;
	private String pais_origen;
	
	
	public Productos(String codigo_articulo, String seccion, String mombre_articulo, double precio, Date fecha,
			String pais_origen) {
		
		this.codigo_articulo = codigo_articulo;
		this.seccion = seccion;
		this.mombre_articulo = mombre_articulo;
		this.precio = precio;
		this.fecha = fecha;
		this.pais_origen = pais_origen;
	}


	public Productos(String seccion, String mombre_articulo, double precio, Date fecha, String pais_origen) {
		
		this.seccion = seccion;
		this.mombre_articulo = mombre_articulo;
		this.precio = precio;
		this.fecha = fecha;
		this.pais_origen = pais_origen;
	}


	public String getCodigo_articulo() {
		return codigo_articulo;
	}


	public void setCodigo_articulo(String codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}


	public String getSeccion() {
		return seccion;
	}


	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}


	public String getMombre_articulo() {
		return mombre_articulo;
	}


	public void setMombre_articulo(String mombre_articulo) {
		this.mombre_articulo = mombre_articulo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getPais_origen() {
		return pais_origen;
	}


	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}


	@Override
	public String toString() {
		return "Productos [codigo_articulo=" + codigo_articulo + ", seccion=" + seccion + ", mombre_articulo="
				+ mombre_articulo + ", precio=" + precio + ", fecha=" + fecha + ", pais_origen=" + pais_origen + "]";
	}
	
	

	
	
}
