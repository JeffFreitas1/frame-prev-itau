package br.com.cardif.life.page;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeSinistroSituacaoSinistroElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeSinistroSituacaoSinistroPage extends LifeSinistroSituacaoSinistroElementMap {
	
	

	public LifeSinistroSituacaoSinistroPage () throws Exception {
		driver=TestRule.getDriver();
		wait= TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void validarStatusDoSinistro () throws Exception {
		statusDoSinistro.getText();
		
	}

}
