package springMVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaAlumnosControlador {
	@RequestMapping("/muestraformulario")
	public String muestraformulario() { // proporciona el formulario 
		
		return "HolaAlumnosFormularios";
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario() {
		
		return"HolaAlumnosSpring";
		
	}
	
	@RequestMapping("/otroprocesoformulario")
	public String otroprocesoformulario(HttpServletRequest request, Model modelo) {
		
		
		String nombre=request.getParameter("nombreAlumno");
		
		nombre+=" es el mejor alumno";
		String mensajefinal ="quien es mejor alumno ? "+ nombre;
		
		//agregando info modelo
		
		modelo.addAttribute("mensajeClaro",mensajefinal);
		
		

		return"HolaAlumnosSpring";
		
	}
	
}

