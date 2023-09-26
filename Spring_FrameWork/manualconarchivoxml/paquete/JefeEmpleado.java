package es.breinner.inversiondecontrol;

public class JefeEmpleado implements Empleados{
	private  CreacionInforme InformeNuevo;
	
	
	public JefeEmpleado(CreacionInforme informeNuevo) {
		this.InformeNuevo = informeNuevo;
	}

	
	
	public String getTareas() {
		
		return "gestiono las cuestiones relativas inversion de control";
		
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "informe presentado por el jefe con arreglos:"+InformeNuevo.getInforme();
	}
	
	
	
}
