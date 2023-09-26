package es.breinner.inversiondecontrol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Usoempleados {

	public static void main(String[] args) {
	
	/*	// creacion de objetos tipo empleaado
		
		Empleados empleado1 = new DirectorEmpleado();
		
		// uso de los objetos creados 
	
		System.out.print(empleado1.getTareas());
		*/
		
		
	ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DirectorEmpleado Juan=contexto.getBean("miEmpleado", DirectorEmpleado.class);
		System.out.println(Juan.getTareas());
		System.out.println(Juan.getInforme());
		System.out.println(Juan.getEmail());
		System.out.println(Juan.getNombreEmpresa());
	
	 /* SecretarioEmpleado maria=contexto.getBean("misecretario", SecretarioEmpleado.class);
	  SecretarioEmpleado pablo=contexto.getBean("misecretario", SecretarioEmpleado.class);
	  System.out.println(maria.getTareas());
	  System.out.println(maria.getInforme());
		
	  System.out.println(maria.getEmail());
		
	  System.out.println(maria.getNombreEmpresa());
		
		
	  System.out.println("email de pablo "+pablo.getEmail());*/
		
	  contexto.close();
		
	}

}
