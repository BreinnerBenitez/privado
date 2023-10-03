package validacionesPersonalizadas;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import jakarta.validation.*;

public class CPostalColombiaValidacion implements ConstraintValidator< CPmadril, String> {

	@Override
    public void initialize(CPmadril elcodigo) {
    
		prefijocolombia=elcodigo.value();
		
	}
	
	
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		
		
		boolean valcodigo;
		
		if(arg0 != null) {
			
			valcodigo=arg0.startsWith(prefijocolombia);
		}else {
			
		return 	valcodigo=true;
			
			
		}
	
		return valcodigo;
	}

	
	private String prefijocolombia;
	
}
