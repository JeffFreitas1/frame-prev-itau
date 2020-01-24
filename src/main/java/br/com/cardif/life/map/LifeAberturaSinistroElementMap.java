package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeAberturaSinistroElementMap extends PageObjectUtils {
	
	//Div abertura de sinistro
	protected String abaAberturaSinistro="//span[contains(.,'Abertura de Sinistro')]";
	@FindBy(xpath = "//input[@id='frmClaimOpen:txtSegurado']")
	protected WebElement txtSegurado;
	@FindBy(xpath = "//input[@id='frmClaimOpen:txtParceiro']")
	protected WebElement txtParceiro;
	@FindBy(xpath = "//label[@id='frmClaimOpen:selRazaoAbertura_label']")
	protected WebElement listaRazaoAbertura;
	//RazaoAbertura                  
	protected String razaoAbertura= "//li[contains(.,'@RAZAOABERTURA')]";
	@FindBy(xpath = "//input[@id='frmClaimOpen:dtDataOcorrencia_input']")
	protected WebElement dtDataOcorrencia;
	//DataOcorrenciaXpathBVP
	protected String xpathDtOcorrencia = "//input[contains(@name,'frmClaimOpen:dtDataOcorrencia_input')]";
	@FindBy(xpath = "//input[@id='frmClaimOpen:dtDataAviso_input']")
	protected WebElement dtDataAviso;
	@FindBy(xpath = "//input[@id='frmClaimOpen:dtDataAdmissao_input']")
	protected WebElement dtDataAdmissao;
	@FindBy(xpath = "//input[@id='frmClaimOpen:dtDataAvisoPrevio_input']")
	protected WebElement dtDataAvisoPrevio;
	@FindBy(xpath = "//input[@id='frmClaimOpen:txtPis']")
	protected WebElement txtPis;
	@FindBy(xpath = "//input[@id='frmClaimOpen:txtSsnCompanyOld']")
	protected WebElement txtCNPJ;
	@FindBy(xpath = "//label[@id='frmClaimOpen:selRisco_label']")
	protected WebElement listaRisco;
	//Risco
	protected String risco= "//li[@data-label='@RISCO']";
	@FindBy(xpath = "//label[@id='frmClaimOpen:selCID_label']")
	protected WebElement listaCID;
	//CID
	protected String cid= "//li[@data-label='@CID']";
	@FindBy(xpath = "//label[@id='frmClaimOpen:selResponsavel_label']")
	protected WebElement listaResponsavel;
	//Responsavel
	protected String responsavel= "//li[@data-label='@RESPONSAVEL']";
	@FindBy(xpath = "//input[@id='frmClaimOpen:txtReclamante']")
	protected WebElement txtReclamante;
	//ESTADOS
	protected String listaUF="//label[contains(@id,'frmClaimOpen:selUF_label')]" ;
	//UF
	protected String uf= "//li[@data-label='@UF']";
	@FindBy(xpath = "//label[@id='frmClaimOpen:selNatureza_label']")
	protected WebElement listaNatureza;
	//Natureza
	protected String natureza= "//li[@data-label='@NATUREZA']";
	@FindBy(xpath = "//label[@id='frmClaimOpen:selCausa_label']")
	protected WebElement listaCausa;
	//Motivos de Demissão
	@FindBy(xpath = "//label[contains(@id,'frmClaimOpen:selTipoDemissao_label')]")
	protected WebElement listaDemissao;
	protected String motivo= "//li[contains(@data-label,'@MOTIVO')]";
	//Causa
	protected String causa= "//li[@data-label='@CAUSA']";
	@FindBy(xpath = "//label[@id='frmClaimOpen:selTipoEvento_label']")
	protected WebElement listaTipoEvento;
	//TipoEvento
	protected String tipoevento= "//li[@data-label='@TIPOEVENTO']";
	@FindBy(xpath = "//textarea[@id='frmClaimOpen:txtParecer']")
	protected WebElement txtParecer;
	//Cabeçalho Certificados
	protected String indexPolicyCertificateTable="#frmClaimOpen\\:policyCertificateTable > div:nth-child(1) > div:nth-child(1) > table:nth-child(1)";
	// Tabela de Certificados
	protected String policyCertificateTable = "#frmClaimOpen\\:policyCertificateTable > div:nth-child(2) > table:nth-child(1)";
	@FindBy(xpath = "//*[@id=\"frmClaimOpen:btOK\"]")
	protected WebElement botaoOkAberturaSinistro;
	@FindBy(xpath = "//*[@id=\"frmClaimOpen:btCancelar\"]")
	protected WebElement botaoCancelarAberturaSinistro;
	@FindBy(xpath = "//*[@id=\"frmClaimOpen:btSair\"]")
	protected WebElement botaosairAberturaSinistro;
	@FindBy(xpath = "//*[@id=\"frmClaimOpen:btRegistrarEndereco\"]")
	protected WebElement botaoRegistrarEndereco;
	//Pop-up Data de aviso vazia
	@FindBy(xpath = "(//span[contains(.,'OK')])[2]")
	protected WebElement botaoOkDataDeAvisoVazia;
	//Label Pop-up Data de aviso vazia
	@FindBy(xpath = "//span[@class='ui-messages-warn-detail']")
	protected WebElement labelDataDeAvisoVazia;
	//Pop-up Natureza Não preenchida
	@FindBy(xpath = "(//span[contains(.,'OK')])[2]")
	protected WebElement botaoOkNaturezaVazia;
	//Pop-up Risco não informado
	@FindBy(xpath = "(//span[contains(.,'OK')])[2]")
	protected WebElement botaoOkRiscoNaoInformado;
	//Mensagens de erro

	
	
	
	
	
	
	
}
