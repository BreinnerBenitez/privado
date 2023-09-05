package controlador;
import modelo.*;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorBotonEjecuta implements ActionListener {

	EjecutaConsultas obj= new EjecutaConsultas() ;
	private Marcoap marco;
	private ResultSet rsconsulta;
	
	
	public ControladorBotonEjecuta  (Marcoap marco) {
		this.marco=marco;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		marco.resultado.setText(""); // limpia todo el marco 
		try {
		String SeleccionaSeccion = (String)marco.secciones.getSelectedItem();
		String Seleccionapaises= (String)marco.paises.getSelectedItem();

		rsconsulta=obj.FiltraBD(SeleccionaSeccion, Seleccionapaises);
		
			//System.out.print("probando evento");
			while(rsconsulta.next()) {
				
				marco.resultado.append(rsconsulta.getString(1)+", "+rsconsulta.getString(2)+", "+rsconsulta.getDouble(3));
				marco.resultado.append("\n");
			}
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	/*	marco.resultado.append("\n"+obj.FiltraBD(SeleccionaSeccion, Seleccionapaises));
		*/
		
		
		
	}

	
	
	
}
