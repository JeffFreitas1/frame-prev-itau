package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeLoginElementMap extends PageObjectUtils{
	
	//Login
	protected String labelLogin = "//span[contains(.,'Login')]";
	//Ambiente
	protected String ambiente= "//div/ul/li[normalize-space(text()) = '@BASE']";
	@FindBy(id = "frmLogin:username")
	protected WebElement usuario;
	@FindBy(id = "frmLogin:password")
	protected WebElement senha;
	@FindBy(xpath = "//div[label[@id='frmLogin:database_label']]/div[not(contains(@class,'hidden'))]")
	protected WebElement abrirOpcoes;
	@FindBy(id = "frmLogin:btnLogin")
	protected WebElement botaoLogin;
	
}
