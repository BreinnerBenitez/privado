package es.breinner.benitez;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Usoanotacion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Empleados breinner =contexto.getBean("comercialexp",Empleados.class);
		Empleados lucia =contexto.getBean("comercialexp",Empleados.class);
		
		
		if( breinner==lucia) {
			
			System.out.println("Apuntan al mismo lugar en memoria");
			System.out.print(breinner+" "+lucia);
		}else {
			
			
			System.out.print("lugar en memoria diferente");
		}
		
			contexto.close();
	
	}

}
