package anexos;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Tablabd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		marcobd ma = new marcobd();
		
		ma.setDefaultCloseOperation(3);
		
		ma.setVisible(true);
		
		
	}

}
class marcobd extends JFrame{  
	
	public marcobd() {
		
		setLayout(new BorderLayout());
		setTitle("productos");
		
		setBounds(100,100,350,350);
		
		JPanel superior = new JPanel();
		
		nombredetablas= new JComboBox();
		
		superior.add(nombredetablas);
		
		try {
			
		
			String usuario = "root";
			String contraseña = "breinner";
			String link = "jdbc:mysql://localhost/pildoras";

		

				conexion = DriverManager.getConnection(link, usuario, contraseña);
			
				datosBD =conexion.getMetaData();
		
				
				rs= datosBD.getTables("pildoras", null, null, new String []{"TABLE"});
				
				while(rs.next()) {
					
					nombredetablas.addItem(rs.getString("TABLE_NAME"));
					
				}
				
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		nombredetablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			 String tablaselecionada = (String) nombredetablas.getSelectedItem();
			 
			 try {
			 String consulta="select * from "+tablaselecionada;
			 
			 st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					  ResultSet.CONCUR_READ_ONLY);
			 rs=st.executeQuery(consulta);
			 
			/* while(rs.next()) {
				 
				 System.out.println(rs.getString(1));
			 } */
			 
			 modelo= new resulsettabla(rs);
			 
			 JTable tabla=new JTable(modelo);
			 
			 add(new JScrollPane(tabla),BorderLayout.CENTER);
			 
			 validate();
			 
			 }catch(Exception ee) {
				 
				 ee.printStackTrace();
			 }
			 
			 
			 
			}
			
			
			
		});
		
		add(superior,BorderLayout.NORTH);
		
		
   }
	private JComboBox nombredetablas;
	private DatabaseMetaData datosBD;
	private ResultSet rs;
	private Statement st;
	private Connection conexion;
	private  resulsettabla modelo;
}


class resulsettabla extends AbstractTableModel{

	public resulsettabla(ResultSet unResultset) {
		
		rsregistro=unResultset;
		
		try {
			resmd =rsregistro.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		try {
		rsregistro.last();
		
		
			return rsregistro.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return resmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		try {
			
			
			rsregistro.absolute(rowIndex +1);
			return rsregistro.getObject(columnIndex +1);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return null;
			
			
		}
		
		
	
	}
	
	public String getColumnName(int c) {
		
		
		try {
			
			return resmd.getColumnName(c+1);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	private ResultSet rsregistro;
	
	private ResultSetMetaData resmd;
	
	
}