package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeConsultaSinistroElementMap extends PageObjectUtils {

	// Xpath Menu Pesquisa Sinistro
	protected String menuPesquisaSinistro = "//legend[contains(.,'Pesquisa')]";
	// Xpath Menu Sinistro
	protected String menuSinistro = "//span[contains(.,'Manutenção de Sinistro')]";
	// Mensagem de Aviso
	protected String mensagemAviso = "//span[contains(.,'Algumas informações do Favorecido são obrigatórias, favor preenchê-las!')]";
	// Mensagem Salvo Com Sucesso
	protected String mensagemSalvoSucesso = "//span[contains(.,'Sinistro salvo com sucesso')]";
	// Confirmar mensagem
	protected String botaoOKAviso = "//*[@id=\"cmdMessagesOk\"]";
	@FindBy(xpath = "//form[@id='frmClaimSearch']//input[@id='frmClaimSearch:txtCPF']")
	protected WebElement cpf;
	@FindBy(xpath = "//form[@id='frmClaimSearch']//input[@id='frmClaimSearch:txtSinistro']")
	protected WebElement numeroSinistro;
	@FindBy(xpath = "//form[@id='frmClaimSearch']//div[@id='frmClaimSearch:chkExibirTodos']//span")
	protected WebElement exibirTodosSinistros;
	@FindBy(xpath = "//form[@id='frmClaimSearch']//button[@id='frmClaimSearch:btProcurar']")
	protected WebElement botaoConsultarSinistro;
	@FindBy(xpath = "//form[@id='frmClaimMaintenance']/div[@id='frmClaimMaintenance:tabs']/ul/li/a[text() = 'Sinistro']")
	protected WebElement abaSinistro;
	@FindBy(xpath = "//form[@id='frmClaimMaintenance']/div[@id='frmClaimMaintenance:tabs']/ul/li/a[text() = 'Cobertura/Valores']")
	protected WebElement abaCoberturaValores;
	@FindBy(xpath = "//form[@id='frmClaimMaintenance']/div[@id='frmClaimMaintenance:tabs']/ul/li/a[text() = 'Favorecidos']")
	protected WebElement abaFavorecidos;
	@FindBy(xpath = "//form[@id='frmClaimMaintenance']/div[@id='frmClaimMaintenance:tabs']/ul/li/a[text() = 'Pagamentos']")
	protected WebElement abaPagamentos;
	@FindBy(xpath = "//form[@id='frmClaimMaintenance']/div[@id='frmClaimMaintenance:tabs']/ul/li/a[text() = 'Despesas Extras']")
	protected WebElement abaDespesasExtras;
	@FindBy(xpath = "//form[@id='frmClaimMaintenance']/div[@id='frmClaimMaintenance:tabs']/ul/li/a[text() = 'Documentos do Processo']")
	protected WebElement abaDocumentosProcesso;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:cmdCloseClaimMaintenance']")
	protected WebElement botaoFecharDadosSinistro;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:cmdChangeClaimMaintenance']")
	protected WebElement botaoAlterarDadosSinistro;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:cmdCancelClaimMaintenance']")
	protected WebElement botaoCancelarAlteracaoSinistro;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:cmdSaveClaimMaintenance']")
	protected WebElement botaoSalvarAlteracaoSinistros;
	@FindBy(xpath = "//*[@id=\"frmQuestion:cmdYes\"]")
	protected WebElement botaoMarcarSinistroVisualizado;
	@FindBy(xpath = "//*[@id=\"frmQuestion:cmdNo\"]")
	protected WebElement botaoNaoMarcarSinistroVisualizado;

	// Xpath Razao Abertura
	protected String razaoAbertura = "//input[@id='frmClaimMaintenance:txtRazaoSolicitacao']";
	//Xpath Index Coluna Sinistro
	protected String indexColunaSinistro="//table/thead[@id='frmClaimSearch:claimTable_head']/tr/th[span[text() = '@NOME_COLUNA']]/preceding::th";
	//Xpath Valor Coluna Sinistro
	protected String valorColunaSinistro="//table/tbody[@id='frmClaimSearch:claimTable_data']/tr/td[@INDEX]";
	// Css cabecalho de consulta de sinistros
	protected String cabecalhoConsultaSinistro = ".ui-datatable-scrollable-header-box > table:nth-child(1)";
	// Css tabela de consulta de sinistros
	protected String registrosConsultaSinistro = ".ui-datatable-scrollable-body > table:nth-child(1)";

}
