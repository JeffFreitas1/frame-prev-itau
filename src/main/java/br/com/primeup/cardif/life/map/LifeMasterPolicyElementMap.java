package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeMasterPolicyElementMap extends PageObjectUtils {

	// Xpath Menu Pesquisa Sinistro
	protected String menuMasterPolicy = "// label[contains(.,'Master Policy:')]";
	@FindBy(xpath = "//label[contains(@id,'formMain:cbParceiro_label')]")
	protected WebElement listaParceiro;
	//Parceiro
	protected String parceiro = "//li[@data-label='@PARCEIRO']";
	
	@FindBy(xpath = "//input[@id='formMain:txtMasterPolicy']")
	protected WebElement txtMasterPolicy;
	@FindBy(xpath = "//*[@id=\"formMain:btOkMP\"]")
	protected WebElement botaoPesquisaMasterPolicy;
	@FindBy(xpath = "//a[@href='#formMain:tabView:tabSinistro'][contains(.,'Sinistro')]")
	protected WebElement abaSinistro;
	@FindBy(xpath = "//a[@href='#formMain:tabView:tabDados'][contains(.,'Dados')]")
	protected WebElement abaDados;
	@FindBy(xpath = "//a[@href='#formMain:tabView:tabComposicao'][contains(.,'Composição')]")
	protected WebElement abaComposicao;
	@FindBy(xpath = "//a[@href='#formMain:tabView:tabCobranca'][contains(.,'Cobrança')]")
	protected WebElement abaCobranca;
	@FindBy(xpath = "//a[@href='#formMain:tabView:tabBroker'][contains(.,'Broker')]")
	protected WebElement abaBroker;
	@FindBy(xpath = "//a[@href='#formMain:tabView:tabProLabore'][contains(.,'Pró-Labore')]")
	protected WebElement abaProLabora;
	@FindBy(xpath = "//a[@href='#formMain:tabView:tabItensCertificado'][contains(.,'Itens do Certificado')]")
	protected WebElement abaItensCertificados;
	
	
	
	
}
