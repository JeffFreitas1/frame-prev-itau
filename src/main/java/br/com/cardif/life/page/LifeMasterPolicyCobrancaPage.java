package br.com.cardif.life.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.cardif.life.map.LifeMasterPolicyCobrancaElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeMasterPolicyCobrancaPage extends LifeMasterPolicyCobrancaElementMap{
	
	public LifeMasterPolicyCobrancaPage() {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this); 
	}
	
	public void teste() {
		// pegando o valor do campo Risco
		Select billingMasterPolicy = new Select(comboBillingMasterPolicy);
		WebElement WebL = billingMasterPolicy.getFirstSelectedOption();
		String planoRisco = WebL.getAttribute("text");
		System.out.println("Teste: "+ planoRisco);
	}

}
