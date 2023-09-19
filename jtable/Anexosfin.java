package anexos;

import java.awt.BorderLayout;
import java.util.List;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Anexosfin {

	public static void main(String[] args) {
	
		
		marco ma = new marco();
		ma.setDefaultCloseOperation(3);
		
		ma.setVisible(true);
		
	}

}
class marco extends JFrame{
	
	
	public marco() {
	setTitle("probando jlist");
	
	setBounds(200,200,350,350);
	
	String []meses= {"enero","febrero","marzo","abril","mayo","junio",
			"julio","agosto","septiembre","octubre","noviembre","Diciembre"};
	
	
	listademeses= new JList<String>(meses);
	listademeses.setVisibleRowCount(4);
	
	JScrollPane laminadesplaza= new JScrollPane(listademeses); 
	laminadelista=new JPanel();
	
	laminadelista.add(laminadesplaza);
	listademeses.addListSelectionListener(new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			List<String> valores =  listademeses.getSelectedValuesList();
			
			StringBuilder texto = new StringBuilder("mes selecionado: ");
			
			for (String palabra: valores) {
				
				texto.append(palabra);
				
				texto.append(" ");
			}
			
			rotulo.setText(texto.toString());
		}
		
		
		
		
		
	});
	
	laminadetexto = new JPanel();
	rotulo=new JLabel("mes selecionado:" );
	laminadetexto.add(rotulo);
	
	add(laminadelista,BorderLayout.NORTH);
	add(laminadetexto,BorderLayout.SOUTH);
	
	}
	
	private JList<String> listademeses;
	private JPanel laminadelista, laminadetexto;
	private JLabel rotulo;
	
}