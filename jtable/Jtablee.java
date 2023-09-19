package anexos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Jtablee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		marcoo ma = new marcoo();
		ma.setDefaultCloseOperation(3);
		
		ma.setVisible(true);
	}

}

class marcoo extends JFrame{  
	
	public marcoo() {
		
		setLayout(new BorderLayout());
		setTitle("los planetas");
		
		setBounds(100,100,350,350);
		
		
		JTable tablaPlanetas =new JTable(datosfilas,nombrecolumnas);
		
		add(new JScrollPane(tablaPlanetas),BorderLayout.CENTER);
		
		JButton botonimpri = new JButton("imprimir tabla");
		
		botonimpri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					
					tablaPlanetas.print();
				}catch(Exception i) {
					
				i.printStackTrace();	
					
				}
				
			}
			
		
		
		
		});
		
		JPanel laminaboton = new JPanel();
		
		laminaboton.add(botonimpri);
		
		add(laminaboton,BorderLayout.SOUTH);
	}

	
	private String  []nombrecolumnas= { "nombre", "radio","lunas","gaseoso"};
	
	private Object [][] datosfilas= {
			
			{"mercurrio",244.0,0,false},
			{"tierra",6378.0,0,false},
			{"marte",3397.0,1,true}
	};
	
}


