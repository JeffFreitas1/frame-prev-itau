package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeSinistroPagamentosElementMap extends PageObjectUtils {

	// Mensagem de Aviso
	protected String mensagemAviso = "//*[@id=\"messages_title\"]";
	// Confirmar mensagem
	protected String botaoOKAviso = "//*[@id=\"cmdMessagesOk\"]";
	// Xpath Formulário Pagamento
	protected String abaPagamento = "//a[contains(.,'Pagamentos')]";
	@FindBy(xpath = "//*[@id=\"frmClaimMaintenance:tabs:cmdAddPayment\"]")
	protected WebElement botaoAdicionarPagamento;
	//@FindBy(xpath = "//span[@id='frmClaimMaintenance:tabs:dlgPayment_title']")
	protected String listaFavorecido="//label[contains(@id,'frmClaimMaintenance:tabs:selPaymentClaimReceiver_label')]";
	// Xpath Favorecido
	protected String favorecido = "//div[25]/div/ul/li[normalize-space(text()) = '@FAVORECIDO']";
	//Cabecalho Pagamentos
	protected String cabecalhoPagamento="#frmClaimMaintenance\\:tabs\\:grdPayments > div:nth-child(1) > div:nth-child(1) > table:nth-child(1)";
	//Registros Pagamentos
	protected String registrosPagamentos="#frmClaimMaintenance\\:tabs\\:grdPayments > div:nth-child(2) > table:nth-child(1)";
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtPaymentDate_input']")
	protected WebElement txtDataPagamento;
	@FindBy(xpath = "//span[@id='frmClaimMaintenance:tabs:dlgPayment_title']")
	protected WebElement formularioPagamento;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtPaymentValue_input']")
	protected WebElement txtValorPagamento;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtPaymentNumber']")
	protected WebElement txtParcelaSinistro;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtInstallmentCoverage']")
	protected WebElement txtPrestacaoCoberta;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selClaimMaintenancePaymentMode_label']")
	protected WebElement listaFormaPagamento;
	// Xpath FormaPagamento
	protected String formaPagamento = "#frmClaimMaintenance\\:tabs\\:selClaimMaintenancePaymentMode_panel > div:nth-child(1)";
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtbillDate_input']")
	protected WebElement txtVencimentoBoleto;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBillNumber']")
	protected WebElement txtNumeroBoleto;
	@FindBy(xpath = "//*[@id=\"frmClaimMaintenance:tabs:cmdClaimMaintenancePaymentOK\"]")
	protected WebElement botaoConfirmarPagamento;
	@FindBy(xpath = "//*[@id=\"frmClaimMaintenance:tabs:cmdClaimMaintenancePaymentCancel\"]")
	protected WebElement botaoCancelarPagamento;
	@FindBy(xpath = "//*[@id=\"frmClaimMaintenance:tabs:cmdAnalyzePayment\"]")
	protected WebElement botaoAnalisarPagamento;
	
	

}
