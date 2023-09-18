package com.breinner.aprende;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;
/**
 * Servlet implementation class servletPruebas
 */
@WebServlet("/servletPruebas")
public class servletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// definir o establecer el sataSource
	
	@Resource(name="jdbc/productos")
	
	private DataSource mipool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

	//crear el objeto printWrite
		
		PrintWriter salida= response.getWriter();
		
		response.setContentType("text/plain");
		
		// crear conexion con base de datos
		
		Connection conexion= null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			
			conexion=mipool.getConnection();
			
			String misql="select * from producto";
			
			st= conexion.createStatement();
			
			rs= st.executeQuery(misql);
			
			
			while (rs.next()) {
				
				String nombrearticulo=rs.getString(3);
				
				salida.println(nombrearticulo);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
