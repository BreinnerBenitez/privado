package es.breinner.benitez;

import org.springframework.stereotype.Component;

@Component 
public class InformeFinan implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "presentacion de informe financiero";
	}

}
