package es.breinner.inversiondecontrol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsociclovidaBeans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 // cargar xml de configuracion 
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext3.xml");
	
	Empleados breinner = contexto.getBean("miEmpleado", Empleados.class);
	
	
	System.out.println(breinner.getInforme());

	
	// cerrar el contexto
	
	contexto.close();
	
	
	}

}
