package es.breinner.benitez;

import org.springframework.stereotype.Component;

@Component
public class Informefinan3 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "financiero 3 mi viejo ";
	}

}
