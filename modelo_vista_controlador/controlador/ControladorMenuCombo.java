package controlador;
import java.awt.event.*;

import javax.swing.JOptionPane;

import modelo.CargaMenusCombo;
import vista.Marcoap;
public class ControladorMenuCombo extends  WindowAdapter {

	public ControladorMenuCombo(Marcoap combo) {
		
		this.combo=combo;
		
	}
	
	public void windowOpened(WindowEvent e) {
		obj.getEjecutaConsultas();
		
		try {
			
			while (obj.rs.next()) {
				
				combo.secciones.addItem(obj.rs.getString(1));
				
		   while(obj.rs2.next()) {
			   
			   combo.paises.addItem(obj.rs2.getString(1));
		   }		
				
			}
			
		}catch(Exception e2) {
			
			JOptionPane.showMessageDialog(null, "conexion fallo en agregar Combobox");
			e2.printStackTrace();
		}
		
	}

	CargaMenusCombo obj = new CargaMenusCombo();
	private  Marcoap combo;
}
