package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.ControladorBotonEjecuta;
import controlador.ControladorMenuCombo;

public class Marcoap extends JFrame{

	public JComboBox secciones;
	public	JComboBox paises;
	public JTextArea resultado;
	
	public Marcoap(){
		
	setTitle("consulta bd-Breinner");

	setBounds(100, 100, 350, 350);

	setLayout(new BorderLayout());

	JPanel menus = new JPanel();

	secciones = new JComboBox();
	secciones.setEditable(false);
	secciones.addItem("todos");

	paises = new JComboBox();
	paises.setEditable(false);
	paises.addItem("todos");

	resultado = new JTextArea(4, 50);
	resultado.setEditable(false);

	menus.add(secciones);
	menus.add(paises);

	add(menus, BorderLayout.NORTH);
	add(resultado, BorderLayout.CENTER);

	JButton boton = new JButton("boton");
	
	add(boton,BorderLayout.SOUTH);
	boton.addActionListener(new ControladorBotonEjecuta(this));
	
	addWindowListener(new ControladorMenuCombo(this));
	
	
	
	}

	
	
}
