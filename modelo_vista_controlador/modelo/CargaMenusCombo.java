package modelo;
import java.sql.*;

import javax.swing.JOptionPane;

public class CargaMenusCombo {

	public CargaMenusCombo() {
		
		conexion = new Conexion();
		
		
	}
	
	public String getEjecutaConsultas() {
		
		Producto produc= null;
		
		Connection AcesoBD = conexion.dameconexion();
		
		try {
			
			Statement st_secciones = AcesoBD.createStatement();
			Statement st_paises = AcesoBD.createStatement();
			String consulta="select distinctrow seccion from producto";
			String consulta2="select distinctrow paisdeorigen from producto";
			 rs= st_secciones.executeQuery(consulta);
			 rs2=st_paises.executeQuery(consulta2);
			//while(rs.next()) {
				
				
				
				produc = new Producto();
				
				produc.setSeccion(rs.getString(1));
				produc.setPaises(rs2.getString(1));
			//	return produc.getSeccion();
			//}
			
			rs.close();
			rs2.close();
			
			AcesoBD.close();
			
		}catch(Exception e) {
			
			//JOptionPane.showMessageDialog(null, "llenando secciones");
			
			e.printStackTrace();
		}
		
		return produc.getSeccion();
		
		
	}
	
	
	
	public ResultSet rs ;
	Conexion conexion;
	public ResultSet rs2;
}
