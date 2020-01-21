package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeSinistroFavorecidosElementMap extends PageObjectUtils{
	
	//Tipo Pessoa
	protected String tipoPessoa= "//div[34]/div/ul/li[normalize-space(text()) = '@TIPOPESSOA']";
	//Tipo Conta
	protected String tipoConta="//div[35]/div/ul/li[normalize-space(text()) = '@TIPOCONTA']";
	//Banco
	protected String banco="//div[36]/div[2]/ul/li[normalize-space(text()) = '@BANCO']";
	
	@FindBy(xpath = "//span[@id='frmClaimMaintenance:tabs:dlgReceiver_title']")
	protected WebElement formularioBeneficiario;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:tabs:cmdAddReceiver']")
	protected WebElement botaoAdicionarFavorecido;
	@FindBy(xpath = "//button[contains(@name,'frmClaimMaintenance:tabs:cmdEditReceiver')]")
	protected WebElement botaoEditarFavorecido;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:tabs:cmdDelReceiver']")
	protected WebElement botaoExcluirFavorecido;
	@FindBy(xpath = "//body/div[1]/div[2]/form/div[1]/div/div[3]/div[2]/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div")
	protected WebElement tipoFavorecidoPrestadorServico;
	@FindBy(xpath = "//body/div[1]/div[2]/form/div[1]/div/div[3]/div[2]/div[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/div")
	protected WebElement tipoFavorecidoBeneficiario;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selReceiverPersonType_label']")
	protected WebElement opcoesTipoPessoa;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selReceiverAccountType_label']")
	protected WebElement opcoesTipoConta;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtReceiverSSN']")
	protected WebElement txtDocumento;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtReceiverName']")
	protected WebElement txtNomeFavorecido;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selReceiverBank_label']")
	protected WebElement listaBanco;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtReceiverBranchNumber']")
	protected WebElement txtAgenciaConta;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtReceiverBranchDV']")
	protected WebElement txtDVAgenciaConta;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtReceiverAccountNumber']")
	protected WebElement txtConta;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtReceiverAccountDV']")
	protected WebElement txtDVConta;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryPercSharing2']")
	protected WebElement txtPercentual;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:selReceiverBank_filter']")
	protected WebElement filtroBuscarBanco;
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdReceiverOK']")
	protected WebElement botaoSalvarFavorecido;
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdReceiverCancel']")
	protected WebElement botaoCancelarSalvarFavorecido;
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdReceiverInclude']")
	protected WebElement botaoIncluirNovoBeneficiario;
	
	
}
