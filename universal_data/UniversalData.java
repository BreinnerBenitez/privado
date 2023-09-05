package universaldata;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.sql.*;
import java.awt.event.*;
import java.io.*;
public class UniversalData {

	public static void main(String[] args) {
	
		MarcoBD marco = new MarcoBD();
		
		marco.setDefaultCloseOperation(3);

		marco.setVisible(true);
	}

}
class MarcoBD extends JFrame {
	
	public MarcoBD () {
		
		setTitle("UniversalData");
		
		setBounds(150,150,450,450);
		
		LaminaBD lamina = new LaminaBD();
		
		add(lamina);
		
		
		
		
	}
	
}

class LaminaBD extends JPanel  {
	private JComboBox tablas;
	private JTextArea areatexto;
	private Connection conexion;
	private FileReader entrada;
	private String datos [];
	public LaminaBD () {
		
		setLayout(new BorderLayout());
		
		tablas= new JComboBox();
		tablas.setEditable(false);
		add(tablas,BorderLayout.NORTH);
		tablas.addItem("seleciona");
	
		
		tablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			//	System.out.println("probando evento");
				areatexto.setText("");
				String entidadtabla=(String)tablas.getSelectedItem();
				
				Consultas(entidadtabla);
			
			}
			
			
			
			
			
		});
		
		areatexto = new JTextArea();
		areatexto.setEditable(false);
		add(areatexto, BorderLayout.CENTER);
		
		ConnectarBD();
		ObtenerTablas();
	}
	
	
	public void Consultas(String tabla) {
		
		ArrayList <String> campos = new ArrayList<String>();
		String consulta="select * from "+tabla;
		
		
		try {
			 
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			ResultSetMetaData metars= rs.getMetaData();
			for(int i=1;i<=metars.getColumnCount();i++) {
				
				campos.add(metars.getColumnLabel(i));
			}
			
			while(rs.next()) {
				
				for(String nombrecampo:campos) {
					
					areatexto.append(rs.getString(nombrecampo)+", ");
					
					
				}
				areatexto.append("\n");
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	public void ConnectarBD()  {
		
		String usuario="root";
		String contra="breinner";
		String link ="jdbc:mysql://localhost:3306/pildoras";
		
		 datos =new String[4];
		
		try {
			
			entrada = new FileReader("src/conecta/config_datos.txt");
			
			
		}catch(IOException e) {
			
			JOptionPane.showMessageDialog(null, "busca el archivo config_datos(src/conecta/config_datos.txt");
		   
			JFileChooser chooser = new JFileChooser();
		    
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivo de textos  ", "txt");
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		        
		        try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
					
					
				}
		    
		    }
			
		}
			
			
			BufferedReader buffer = new BufferedReader(entrada);
			
			
				
			try {	
				
				
				for(int i=0;i<4;i++) {
				datos[i]=buffer.readLine();
				
				}
				conexion=DriverManager.getConnection(datos[0], datos[1], datos[2]);
				
				entrada.close();
			}catch(Exception e) {
				
			}
				

		
		
	}

	public void ObtenerTablas()  {
		
		ResultSet rs= null;
		
		//String nombd= JOptionPane.showInputDialog("ingresa nombre de base de datos correctamente");
		try {
			DatabaseMetaData datosDB=conexion.getMetaData();
			rs=datosDB.getTables(datos[3], null, null, new String []{"TABLE"});
			while(rs.next()) {
				
				tablas.addItem(rs.getString("TABLE_NAME"));
				
			}
		}catch (Exception e ) {
			
			e.printStackTrace();
			
			
			
		}
		
	}
}


