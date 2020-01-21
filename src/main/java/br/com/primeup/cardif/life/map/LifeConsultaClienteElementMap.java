package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeConsultaClienteElementMap extends PageObjectUtils{
	
	
	//Quantidade de registros
	protected String quantidadeRegistros="//label[contains(.,'Total de registros: 1')]";
	
	//Cabecalho tabela de certificados
	protected String tabelaCabecalhoCertificados=".ui-datatable-scrollable-header-box > table:nth-child(1)";
	
	//Tabela de certificados
	protected String tabelaRegistrosCertificados=".ui-datatable-scrollable-body > table:nth-child(1)";
	
	protected String opcoesBuscaCliente="//form[@id='frmClientSearch']";
	@FindBy(xpath = "//input[@id='frmClientSearch:optCampoConsulta:0']")
	protected WebElement buscarNumeroCliente;
	@FindBy(xpath = "//input[@id='frmClientSearch:txtNumero']")
	protected WebElement txtNumeroCliente;
	@FindBy(xpath = "//input[@id='frmClientSearch:optCampoConsulta:1']")
	protected WebElement buscarCPF;
	@FindBy(xpath = "//input[@id='frmClientSearch:txtCpf']")
	protected WebElement txtCpf;
	@FindBy(xpath = "//input[@id='frmClientSearch:optCampoConsulta:2']")
	protected WebElement buscarCertificado;
	@FindBy(xpath = "//input[@id='frmClientSearch:txtCertificado']")
	protected WebElement txtCertificado;
	@FindBy(xpath = "//input[@id='frmClientSearch:optCampoConsulta:3']")
	protected WebElement buscarRg;
	@FindBy(xpath = "//input[@id='frmClientSearch:txtRg']")
	protected WebElement txtRg;
	@FindBy(xpath = "//input[@id='frmClientSearch:optCampoConsulta:4']")
	protected WebElement buscarNumCapitalizacao;
	@FindBy(xpath = "//input[contains(@id,'frmClientSearch:txtNumContrato')]")
	protected WebElement txtNumContrato;
	@FindBy(xpath = "//input[@id='frmClientSearch:txtNumCapitalizacao1']")
	protected WebElement txtNumCapitalizacaoInicio;
	@FindBy(xpath = "//input[@id='frmClientSearch:txtNumCapitalizacao2']")
	protected WebElement txtNumCapitalizacaoFim;
	//Buscar por contrato
	protected String checkBoxNumeroContrato="//*[@id=\"frmClientSearch:chkNumContrato_input\"]";
	//Exibir contratos cliente
	protected String checkBoxExibirTodos="//*[@id=\"frmClientSearch:chkExibirTodos_input\"]";
	@FindBy(xpath = "//*[@id=\"frmClientSearch:btnPesquisar\"]")
	protected WebElement botaoPesquisar;
	@FindBy(xpath = "//*[@id=\"frmClientSearch:btnLimpar\"]")
	protected WebElement botaoLimpar;
	@FindBy(xpath = "//*[@id=\"frmClientSearch:grdCertificados:btnSinistro\"]")
	protected WebElement botaoSinistro;
	@FindBy(xpath = "//a[@href='#frmCertificate:tabsCertificado:tabInfoComplementares']")
	protected WebElement abaInformacoesComplementares;
	@FindBy(xpath = "//*[@id=\"frmCertificate:j_id_qg\"]")
	protected WebElement botaoFecharCertificado;
	
	
	
	
}
