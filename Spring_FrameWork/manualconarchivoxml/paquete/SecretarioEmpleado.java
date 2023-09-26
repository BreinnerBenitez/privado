package es.breinner.inversiondecontrol;

public class SecretarioEmpleado implements Empleados {
	private  CreacionInforme InformeNuevo;
	
	public void setInformeNuevo(CreacionInforme informeNuevo) {
		this.InformeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		
		return "secretario agendan jefe";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "secreatio da este informe"+InformeNuevo.getInforme();
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
	
	private String email;
	private String nombreEmpresa;


}
