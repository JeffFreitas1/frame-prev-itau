package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeClienteDetalheElementMap extends PageObjectUtils {

	// Detalhe Cliente
	protected String detalheCliente = "//*[@id=\"dlgClientDetail\"]";
	// Tabela de pagamento
	protected String listaHistoricoPagamento = "//form[@name='frmClient']//div/div/div[6]/div/div[2]/table";
	// Registro de pagamento
	protected String registroHistoricoPagamento = listaHistoricoPagamento + "/tbody/tr";
	// Informação do Registro
	protected String dadoRegistroPagamento = listaHistoricoPagamento + "/tbody/tr/td";
	// Carregamento dos Pagamentos
	protected String loadingPagamento = "//*[@id=\"frmClient:tabView:imgPaymentLogs\"]";
	// Cabecalho tabela historico pagamentos
	protected String cabecalhoTabelaHistoricoPagamentos = "#frmClient\\:tabView\\:grdPaymentLogs > div:nth-child(1) > div:nth-child(1) > table:nth-child(1)";
	//Registros historico pagamento
	protected String registrosHistoricoPagamentos= "#frmClient\\:tabView\\:grdPaymentLogs > div:nth-child(2) > table:nth-child(1)";
	
	
	@FindBy(xpath = "//a[@href='#frmClient:tabView:tabPersonalData']")
	protected WebElement abaDadosPessoais;
	@FindBy(xpath = "//a[@href='#frmClient:tabView:tabAddress']")
	protected WebElement abaEnderecos;
	@FindBy(xpath = "//a[@href='#frmClient:tabView:tabAddressLogs']")
	protected WebElement abaHistoricoEnderecos;
	@FindBy(xpath = "//a[@href='#frmClient:tabView:tabPhones']")
	protected WebElement abaTelefones;
	@FindBy(xpath = "//a[@href='#frmClient:tabView:tabContactsLogs']")
	protected WebElement abaHistoricoContatos;
	@FindBy(xpath = "//a[@href='#frmClient:tabView:tabPaymentLogs']")
	protected WebElement abaHistoricoPagamentos;
	@FindBy(xpath = "//button[@name='frmClient:j_id_e9']")
	protected WebElement botaoFecharDadosCliente;
	@FindBy(xpath = "//button[@name='frmClient:cmdChange']")
	protected WebElement botaoAlterarDadosCliente;
	@FindBy(xpath = "//button[@name='frmClient:j_id_e8']")
	protected WebElement botaoCancelarAlteracaoCliente;
	@FindBy(xpath = "//button[@name='frmClient:j_id_e7']")
	protected WebElement botaoSalvarAlteracaoCliente;

}
