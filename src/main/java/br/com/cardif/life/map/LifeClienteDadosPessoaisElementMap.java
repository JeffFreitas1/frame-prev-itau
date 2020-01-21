package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeClienteDadosPessoaisElementMap  extends PageObjectUtils{
	
	
	@FindBy(xpath = "//input[@id='frmClient:tabView:accordionPanel:txtBirthDate_input']")
	protected WebElement txtDataNascimento;
	@FindBy(xpath = "//*[@id=\"frmClient:tabView:accordionPanel:selGender_label\"]")
	protected WebElement txtSexo;
	@FindBy(xpath = "//input[@id='frmClient:tabView:accordionPanel:txtCpf']")
	protected WebElement txtCpf;
	@FindBy(xpath = "//input[@id='frmClient:tabView:accordionPanel:txtEmail']")
	protected WebElement txtEmail;
	//CssSelector campo Sexo
	protected String sexoCssSelector="#frmClient\\:tabView\\:accordionPanel\\:selGender_input";
	
	
}
