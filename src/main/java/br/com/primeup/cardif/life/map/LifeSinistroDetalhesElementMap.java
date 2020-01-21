package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeSinistroDetalhesElementMap extends PageObjectUtils{
	
	
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:txtRazaoSolicitacao']")
	protected WebElement txtRazaoSolicitacao;
	@FindBy(xpath = "//input[contains(@name,'frmClaimMaintenance:tabs:txtNumeroCertificado')]")
	protected WebElement txtNumeroCertificado;
	@FindBy(xpath = "//*[@id=\"frmClaimMaintenance:tabs:selEndorsement_label\"]")
	protected WebElement labelEndossoCertificado;
	@FindBy(xpath = "//input[contains(@id,'frmClaimMaintenance:tabs:txtStatus')]")
	protected WebElement txtStatus;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtNumeroMasterPolicy']")
	protected WebElement txtNumeroMasterPolicy;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtDtEfetivacao_input']")
	protected WebElement txtDtEfetivacao;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtDtExpiracao_input']")
	protected WebElement txtDtExpiracao;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtDescricaoMasterPolicy']")
	protected WebElement txtDescricaoMasterPolicy;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtContrato']")
	protected WebElement txtContrato;
	@FindBy(xpath = "(//td[@role='gridcell'])[86]")
	protected WebElement valorFinanciado;
	@FindBy(xpath = "(//td[@role='gridcell'])[87]")
	protected WebElement valorPrestacao;
	@FindBy(xpath = "(//td[@role='gridcell'])[88]")
	protected WebElement prazo;
	@FindBy(xpath = "(//td[@role='gridcell'])[89]")
	protected WebElement primeiroVencimento;
	
	
	
}
