package modelo;
import java.sql.*;

import javax.swing.JOptionPane;
public class EjecutaConsultas {
	 
	public EjecutaConsultas() {
		
		conexion = new Conexion();		
	}
	public ResultSet FiltraBD(String seccion, String pais) {
		 
		Connection conecta= conexion.dameconexion();
	try {
		    //pruebas="gf";
		
		if (!seccion.equals("todos")&& pais.equals("todos")) {
			
		//	pruebas ="escogistes seccion";
			
			Enviaconsultaseccion = conecta.prepareStatement(consultaseccion);
			Enviaconsultaseccion.setString(1, seccion);
			rs= Enviaconsultaseccion.executeQuery();
			
			
			
		}else if(seccion.equals("todos")&& !pais.equals("todos")) {
			
			
			Enviaconsultapaises = conecta.prepareStatement(consultapaises);
			Enviaconsultapaises.setString(1, pais);
			rs= Enviaconsultapaises.executeQuery();
			
			
	//		pruebas="escogistes paises";
			
			
			
		}else if (!seccion.equals("todos")&& !pais.equals("todos")) {
			
		//	pruebas="escogistes ambos";
			
			Enviaambos= conecta.prepareStatement(consultapaises);
			Enviaambos.setString(1, seccion);
			Enviaambos.setString(1, pais);
			rs= Enviaambos.executeQuery();
			

		}else {
			
			JOptionPane.showMessageDialog(null, "señale alguna opcion porfavor");
			
		}
		
		
		
	}catch(Exception e) {
		
		
	}
		
	
		// return pruebas;
		return rs;
		
	}
	private String pruebas;
	private Conexion conexion;
	private ResultSet rs;
	private PreparedStatement Enviaambos;
	private PreparedStatement Enviaconsultapaises;
	private PreparedStatement Enviaconsultaseccion;
	private final String consultaseccion="select seccion, nombrearticulo,precio from producto where seccion = ? " ;
	private final String consultapaises="select seccion, nombrearticulo,precio from producto where paisdeorigen = ? ";
	private final String consultaambos="select seccion, nombrearticulo,precio from producto where seccion = ? and paisdeorigen= ? ";
}
