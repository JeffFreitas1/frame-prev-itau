package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.cardif.utils.PageObjectUtils;

public class LifeMasterPolicyCobrancaElementMap extends PageObjectUtils{
	
	//@FindBy(xpath = "//*[@id=\"formMain:tabView:selBillingMp_input\"]")
	@FindBy(how =  How.CSS, using = "#formMain\\:tabView\\:selBillingMp_input")
	protected WebElement comboBillingMasterPolicy;
	

}
