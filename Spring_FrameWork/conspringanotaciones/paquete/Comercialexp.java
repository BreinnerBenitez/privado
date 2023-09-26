package es.breinner.benitez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Comercialexp implements Empleados {
	@Autowired
	@Qualifier("informeFinanciero2")
	private CreacionInformeFinanciero informe;
	
	
	/*@Autowired
	public void setInforme(CreacionInformeFinanciero informe) {
		this.informe = informe;
	}*/

	
	/*@Autowired
	public Comercialexp(CreacionInformeFinanciero informe) {
		this.informe = informe;
	}*/

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return"vender , vender y vender mas";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		//return "informe genrado por el comercial";
		
		return informe.getInformeFinanciero();
	}

}
