package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeAutorizacaoPagamentoElementMap extends PageObjectUtils{
	
	@FindBy(xpath = "//input[@value='PB']")
	protected WebElement opcaoPagamentosBeneficios;
	@FindBy(xpath = "//input[@value='DES']")
	protected WebElement opcaoDespesasExtrasSinistros;
	@FindBy(xpath = "//input[@value='PBPJ']")
	protected WebElement opcaoPagamentosBeneficiosProcessoJudiciais;
	@FindBy(xpath = "//input[@value='DESPJ']")
	protected WebElement opcaoDespesasExtrasSinistroProcessoJudicial;
	@FindBy(xpath = "//input[@value='PAM']")
	protected WebElement opcaoPagamentosAtualizacaoMonetaria;
	@FindBy(xpath = "//input[@id='frmPayment:txtDataInicial_input']")
	protected WebElement txtDataInicial;
	@FindBy(xpath = "//input[@id='frmPayment:txtDataFinal_input']")
	protected WebElement txtDataFinal;
	@FindBy(xpath = "//textarea[@id='frmPayment:inputClaim']")
	protected WebElement txtListaSinistro;
	@FindBy(xpath = "//*[@id=\"frmPayment:btnLimpar\"]")
	protected WebElement botaoLimparPesquisa;
	@FindBy(xpath = "//*[@id=\"frmPayment:btnPesquisar\"]")
	protected WebElement botaoPesquisar;
	@FindBy(xpath = "//*[@id=\"frmPayment:j_id_2w\"]")
	protected WebElement botaoAlterarDataPagamento;
	@FindBy(xpath = "//*[@id=\"frmPayment:btnReajusta\"]")
	protected WebElement botaoReajustarValor;
	@FindBy(xpath = "//*[@id=\"frmPayment:btnAutorizar\"]")
	protected WebElement botaoAutorizarPagamento;
	
	//Cabecalho tabela de sinistros
	protected String tabelaCabecalhoSinitros=".ui-datatable-scrollable-header-box > table:nth-child(1)";
	//Tabela de certificados
	protected String tabelaRegistrosSinitros=".ui-datatable-scrollable-body > table:nth-child(1)";
	
	

}
