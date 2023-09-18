package com.breinner.aprende;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {

	
	private DataSource origenDatos;
	
	
	public ModeloProductos(DataSource origenDatos) {
		
		
		this.origenDatos=origenDatos;
		
	}
	
	public List<Productos> getProductos() throws  Exception{
		
		List<Productos> productos = new ArrayList<>();
		
		Connection conexion=null;
		Statement st=null;
		ResultSet rs=null;
		
		
		// ----establecer la connecion 
		
		conexion =origenDatos.getConnection();
		
		
		// crear la sentencia sql 
		
		String consulta ="select * from producto";
		
		st=conexion.createStatement();
		
		rs=st.executeQuery(consulta);
		
		while(rs.next()) {
			
			String c_art=rs.getString("CODIGOPRODUCTO");
			String seccion=rs.getString("SECCION");
			String no_arti=rs.getString("NOMBREARTICULO");
			double precio =rs.getDouble("PRECIO");
			Date fecha=rs.getDate("FECHA");
			String paisOrige=rs.getString("PAISDEORIGEN");
			
			Productos tempro = new Productos(c_art,seccion,no_arti,precio,fecha,paisOrige);
			
			productos.add(tempro);
		}
		
		return productos;
	}

	public void agregarnuevop(Productos nuevoproducto) {
		
		Connection conexion=null;
		
		PreparedStatement st= null;
		
		
		
		//optener la conexion
		
		
		try {
			
			conexion=origenDatos.getConnection();
		
		
		
		// crear la instruccion sql
		
		String sql="insert into producto(CODIGOPRODUCTO,SECCION,NOMBREARTICULO,PRECIO,FECHA,PAISDEORIGEN)"
				+ "VALUES(?,?,?,?,?,?)";
		
		st=conexion.prepareStatement(sql);
		//establecer los parametros para el producto
		
		st.setString(1,nuevoproducto.getCodigo_articulo() );
		st.setString(2,nuevoproducto.getSeccion() );
		st.setString(3,nuevoproducto.getMombre_articulo() );
		st.setDouble(4,nuevoproducto.getPrecio() );
		java.util.Date utildate=nuevoproducto.getFecha();
		java.sql.Date fechaconver= new java.sql.Date(utildate.getTime());
		st.setDate(5,fechaconver);
		st.setString(6,nuevoproducto.getPais_origen());
		
		//ejecutar la instruccion
		st.executeUpdate();
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
	}

	public Productos getProductos(String codigoArr) {
	
		Productos elproducto =null;
		Connection conexion=null;
		PreparedStatement st= null;
		ResultSet rs =null;
		String codigoAR=codigoArr;
		
		//establecer la conxion base de datos
		
		
		try {
		
			
			conexion=origenDatos.getConnection();
			
		// crear sql que busque el producto
		
			String sql = "select * from producto where CODIGOPRODUCTO= ?";
			
			
	     // crear la consulta preparada 
			
			st =conexion.prepareStatement(sql);
			
		// establecer los parametros de esa consulta 
			
			st.setString(1, codigoAR);
		
		// ejecutar la consulta
		
			rs=st.executeQuery();
			
		// obtener los datos de repuesta
			
			if (rs.next()) {
				
				String c_art=rs.getString("CODIGOPRODUCTO");
				String seccion=rs.getString("SECCION");
				String no_arti=rs.getString("NOMBREARTICULO");
				double precio =rs.getDouble("PRECIO");
				Date fecha=rs.getDate("FECHA");
				String paisOrige=rs.getString("PAISDEORIGEN");
				
			 elproducto = new Productos(c_art,seccion,no_arti,precio,fecha,paisOrige);
				
				
			}else {
				
				throw new Exception ("no se encontro el producto de articulo "+codigoArr);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return elproducto;
	}

	public void actualizarProductos(Productos productoactualizado) {
		
		 Connection conexion=null;
		 PreparedStatement st=null;
		 
		
		
		// establecer la conexion 
		try {
			conexion = origenDatos.getConnection();
	
		
		// crear sestencia sql
		String sql ="update producto set seccion=?,nombrearticulo=?,precio=?"
				+ "fecha=?,paisdeorigen=? where codigoarticulo=?";
		
		// crear la consulta preparada
		
		  st=conexion.prepareStatement(sql);
		  
		
		// establecer los parametros
		
		  st.setString(1, productoactualizado.getSeccion());
		  st.setString(2, productoactualizado.getMombre_articulo());
		  st.setDouble(3, productoactualizado.getPrecio());
		  java.util.Date utildate=productoactualizado.getFecha();
		  java.sql.Date fechaconver= new java.sql.Date(utildate.getTime());
		  st.setDate(4,fechaconver);
		  st.setString(5, productoactualizado.getPais_origen());
		  st.setString(6, productoactualizado.getCodigo_articulo());
	
		
		// ejecutar la instruccion
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}

	public void eliminarProducto(String codigoArticulo) {
		
		
	
		
		
		Connection conexion=null;
		
		PreparedStatement st= null;
		
		
		
		//optener la conexion
		
		
		try {
		conexion=origenDatos.getConnection();
		
		
		// crear la instruccion sql
		
		String sql ="delete from productos where=?";
		
	
		
		// prepaparar la consulta
		
	    st=conexion.prepareStatement(sql);
		
		// establcer parameteros de consulta
		
	    st.setString(1, codigoArticulo);
	    
		// ejecutar sentencia
	    
	    st.executeUpdate();
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
}
