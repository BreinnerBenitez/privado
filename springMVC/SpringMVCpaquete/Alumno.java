package springMVC;





import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import validacionesPersonalizadas.CPmadril;

public class Alumno {

	
	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudadesestudio() {
		return ciudadesestudio;
	}

	public void setCiudadesestudio(String ciudadesestudio) {
		this.ciudadesestudio = ciudadesestudio;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getOptativa() {
		return optativa;
	}

	public void setOptativa(String optativa) {
		this.optativa = optativa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}
	
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	@NotNull
	@Size(min=2,message="campo requerido ")
	private String nombre;
	
	private String Apellidos;
	
	private String optativa;
	
	private String ciudadesestudio;
	
	private String idiomas;
	@Min(value=10,message ="no se permiten edades menores de 10")
	@Max(value=100,message ="no se permiten edades mayores de 100")
	private int edad;
	
	@Email
	private String email;
	
	//@Pattern(regexp="[0-9]{5}",message="solo 5 valores numericos")
	@CPmadril
	private String codigopostal;
}
