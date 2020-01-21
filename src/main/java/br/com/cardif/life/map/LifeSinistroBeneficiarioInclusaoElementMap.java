package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeSinistroBeneficiarioInclusaoElementMap extends PageObjectUtils{

	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryName']")
	protected WebElement txtNomeBenefiario;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryBirthDate_input']")
	protected WebElement txtDataNascimento;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selBeneficiaryGender_label']")
	protected WebElement opcaoSexo;
	//Sexo
	protected String sexo= "//div[38]/div/ul/li[normalize-space(text()) = '@SEXO']";
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selBeneficiaryRelative_label']")
	protected WebElement opcaoGrauParentesco;
	//Grau Parentesco
	protected String grauParentesco= "//div[39]/div/ul/li[normalize-space(text()) = '@PARENTESCO']";
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryCPF']")
	protected WebElement txtCpfBeneficiario;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryPhone']")
	protected WebElement txtTelefoneBeneficiario;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryStreet']")
	protected WebElement txtEndereco;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryAddressNumber']")
	protected WebElement txtNumeroEndereco;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryAddressCompl']")
	protected WebElement txtComplementoEndereco;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryAddressNeigh']")
	protected WebElement txtBairro;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryAddressCity']")
	protected WebElement txtCidade;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selBeneficiaryAddressState_label']")
	protected WebElement listaEstado;
	//Estado
	protected String estado= "//div[40]/div/ul/li[normalize-space(text()) = '@ESTADO']";
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryAddressPostalCode']")
	protected WebElement txtCodigoPostal;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtBeneficiaryInterchangeCode']")
	protected WebElement txtCodigoIntercambio;
	@FindBy(xpath = "//textarea[@id='frmClaimMaintenance:tabs:txtBeneficiaryObs']")
	protected WebElement txtObsBeneficiario;
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdBeneficiarySave']")
	protected WebElement botaoSalvarBeneficiario;
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdBeneficiaryCancel']")
	protected WebElement botaoCancelarBeneficiario;
	
	
	
	
	
}
