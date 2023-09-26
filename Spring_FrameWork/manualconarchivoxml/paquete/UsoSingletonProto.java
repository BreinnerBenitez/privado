package es.breinner.inversiondecontrol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoSingletonProto {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//peticion de bean al contenedor Spring 
		SecretarioEmpleado maria=contexto.getBean("misecretario", SecretarioEmpleado.class);
		
		SecretarioEmpleado pedro=contexto.getBean("misecretario", SecretarioEmpleado.class);

		System.out.println(maria);
		System.out.println(pedro);
		
	}

}
