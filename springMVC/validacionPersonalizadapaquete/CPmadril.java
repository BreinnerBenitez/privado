package validacionesPersonalizadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import java.lang.annotation.*;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy=CPostalColombiaValidacion.class) // futura clase que tendra la logica de la validacion
@Target({ElementType.METHOD, ElementType.FIELD}) // destino de validacion metodos y campos
@Retention(RetentionPolicy.RUNTIME) // chequea la anotacion en tiempo de ejecucion
public @interface CPmadril {
// difinir el c  postal por defecto 
	
	public String value () default "28";
	
	
	// definir el mensaje de error 
	
	public String Message() default "el c postal debe comenzar por 28";
	
	
	// definir los grupos
	
	
	 Class<?>[] groups() default {};
	
	
	 // definir los payloads

	 
	 Class<? extends Payload>[] payload() default {};

}
