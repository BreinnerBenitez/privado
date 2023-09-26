package es.breinner.inversiondecontrol;

public class DirectorEmpleado implements Empleados {
		
	
	// creacion de campo tipo creacioninforme (interfaz)
	
	private  CreacionInforme InformeNuevo;
	// creacion de constructor que inyecta la dependecnia
	public DirectorEmpleado(CreacionInforme informenuevo) {
		
		this.InformeNuevo=informenuevo;
		
	}
	
	
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Director Empleados";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe creado por el director: "+InformeNuevo.getInforme();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public void metodoinit() {
		
		
		System.out.println("metodo init se ejcuta antes del que bean este listo");
		
		
	}
	public void metododestroy() {
		
		
		System.out.println("metodo destroy se ejcuta despues del que bean este realizado ");
		
		
	}
	
	//metodo init encargaado de ejcutar tareas  antes del que bean esete disponibles 
	// metodo destryo ejecutar tareas depues de que el eban haya sido utilizado 
	private String email;
	private String nombreEmpresa;

}
