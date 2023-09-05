package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	Connection conexion = null;
	
	public Conexion() {

	}

	public Connection dameconexion() {

		
		String usuario = "root";
		String contraseña = "breinner";
		String link = "jdbc:mysql://localhost:3306/pildoras";

		try {
			// crear coneixon
			conexion = DriverManager.getConnection(link, usuario, contraseña);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "no conecta a la base de datos");
			e.printStackTrace();

		}

		return conexion;
	}

}
