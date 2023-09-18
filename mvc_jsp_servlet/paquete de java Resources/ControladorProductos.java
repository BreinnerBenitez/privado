package com.breinner.aprende;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ModeloProductos modeloproductos;
	@Resource(name = "jdbc/productos")
	private DataSource mipool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			modeloproductos = new ModeloProductos(mipool);

		} catch (Exception e) {

			throw new ServletException(e);

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// leer el parametro del formulario

		String elcomando = request.getParameter("instrucion");
		// si no se envia el parametro listar productos

		if (elcomando == null) {

			elcomando = "listar";

		}
		// redirigir el flujo de ejecucion al metodo adecuado

		switch (elcomando) {

		case "listar":
			obtenerproductos(request, response);
			break;
		case "insertarBBDD":

			insertarproductos(request, response);

			break;
			
		case "cargar":
			
			try {
				cargaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		    	break ;
		case "eliminar":
			
			try {
				eliminarproducto(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
			
		case "ActualizarBBDD":	
				
			try {
				actualizaProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		default:

			obtenerproductos(request, response);

		}

	}

	private void eliminarproducto(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
	
		// capturar el codigo articulo
		
		String codigoArticulo =request.getParameter("codigoarticulo");
		
		// borrar producto de la Base de datos
		
		modeloproductos.eliminarProducto(codigoArticulo);
		
		
		// volver a lista de productos 
		
		
	}

	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		
		//leer los datos al actualizar 
		
		
		String Codigoarticulo= request.getParameter("codigoarticulo");
		String seccion= request.getParameter("seccion");
		String nombrearticulo= request.getParameter("nombrearticulo");
		SimpleDateFormat formatofecha= new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = formatofecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double precio=Double.parseDouble(request.getParameter("precio"));
		String paisorigen= request.getParameter("paisorigen");
		
		// crear un objeto de tipo PRoducto con la info del formulario
		
		Productos productoactualizado = new Productos(Codigoarticulo,seccion,nombrearticulo,precio,fecha,paisorigen);
	
		// actualizar la BBDD con la info del obj Producto
		
		modeloproductos.actualizarProductos(productoactualizado);
		
		//volver al listado con la info actualizada
		
		obtenerproductos(request, response);
		
		
	}

	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// leer el cofigo aticulo que viene del listado
		
		String codigoart =request.getParameter("CArticulo");
		
		// enviar codigo articulo a modelo 
		
		 Productos elproducto = modeloproductos.getProductos(codigoart);
		
		
		// colocar atributo correspondiente al C Articulo 
		
		 request.setAttribute("ProductoActualizar", elproducto);
		
		//enviar producto al dormulario de actualizar (jsp)
		 
			RequestDispatcher miDispa = request.getRequestDispatcher("/actualizarProductos.jsp");

			miDispa.forward(request, response);
		 
		 
	}

	private void insertarproductos(HttpServletRequest request, HttpServletResponse response) {
	
		//leer la informacion que viene del formulario
		
		String Codigoarticulo= request.getParameter("codigoarticulo");
		String seccion= request.getParameter("seccion");
		String nombrearticulo= request.getParameter("nombrearticulo");
		SimpleDateFormat formatofecha= new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = formatofecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double precio=Double.parseDouble(request.getParameter("precio"));
		String paisorigen= request.getParameter("paisorigen");
		// crar un objeto de tipo Producto
		
		Productos nuevoproducto = new Productos(Codigoarticulo,seccion,nombrearticulo,precio,fecha,paisorigen);
		
		//enviar el objeto al modelo y despues inser el objeto producto en la Base de datos
		
		modeloproductos.agregarnuevop(nuevoproducto);
		
		//listar los productos
		obtenerproductos(request, response);
	}

	private void obtenerproductos(HttpServletRequest request, HttpServletResponse response) {

		List<Productos> productos;

		try {

			// obtener lista de produsctos desde del modelo

			productos = modeloproductos.getProductos();

			// agregar lista de productos al request

			request.setAttribute("listaProductos", productos);

			// enviar ese request al pagina jsp

			RequestDispatcher miDispa = request.getRequestDispatcher("/listaProductos.jsp");

			miDispa.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
