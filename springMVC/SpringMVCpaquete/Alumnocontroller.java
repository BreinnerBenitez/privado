package springMVC;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/alumno")
public class Alumnocontroller {

	@RequestMapping("/muestraformulario")
	public String muestraformulario (Model modelo) {
		
		
		Alumno elalumno= new Alumno();
				
		modelo.addAttribute("elalumno", elalumno);
		
		
		return "alumnoRegistroFormulario";
				
				
				
	}
	@InitBinder
	public void mibinder(WebDataBinder binder) {
		
		StringTrimmerEditor recortarespacios = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, recortarespacios);
		
	}
	
	@RequestMapping("/procesarFormulario")
	public  String procesarFormulario(@Valid @ModelAttribute("elalumno") Alumno alumno,BindingResult resultadovalidacion) {
		
		if (resultadovalidacion.hasErrors()) {
			
			
			return"alumnoRegistroFormulario";
			
		}else {
			
			return"confirmacionRegistroAlumno";
		}
		
		
		
		
	}
}
