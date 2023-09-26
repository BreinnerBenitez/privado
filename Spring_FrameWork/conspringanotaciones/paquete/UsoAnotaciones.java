package es.breinner.benitez;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnotaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// cargar el contet.xml
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");

		
		// pedir un bean el contenedor
		
		
		Empleados breinner =contexto.getBean("comercialexp",Empleados.class);
		
	
	// usar el bean 
		
		System.out.println(breinner.getTareas());
		System.out.println(breinner.getInforme());
		
		contexto.close();
		
	
	}

}
