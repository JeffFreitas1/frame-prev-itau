package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeHomeElementMap extends PageObjectUtils {

	// Menu Relatorios
	
	protected String menuRelatorios = "//span[@class='ui-menuitem-text'][contains(.,'Relatórios')]";
	protected String menuCarga = "//span[@class='ui-menuitem-text'][contains(.,'Carga')]";
	protected String menuFinanceiro = "(//span[contains(.,'Financeiro')])[3]";
	protected String menuTrancacoes = "//span[contains(.,'Transações')]";

	protected String opcaoRegistroOficial = "//a[@href='javascript:void(0)'][contains(.,'Registro Oficial')]";
	protected String opcaoPremio = "(//span[@class='ui-menuitem-text'][contains(.,'Prémio')])[1]";
	protected String opcaoPendentes = "(//span[@class='ui-menuitem-text'][contains(.,'Pendentes')])[4]";
	protected String opcaoEmitidos = "(//span[@class='ui-menuitem-text'][contains(.,'Emitidos')])[1]";
	protected String opcaoCobrados = "(//span[@class='ui-menuitem-text'][contains(.,'Cobrados')])[1]";
	protected String opcaoRestituicao = "(//span[@class='ui-menuitem-text'][contains(.,'Restituições')])[1]";
	protected String opcaoRelatorioContasTransitorias = "//span[contains(.,'Relatório Contas Transitórias')]";
	protected String opcaoRelatorioRepasse = "//span[contains(.,'Relatório Repasse')]";
	protected String opcaoPagamentoContabilidade = "//span[contains(.,'Pagamento/Contabilidade')]";
	protected String opcaoRelatorioTaxas = "//span[contains(.,'Relatório Taxas')]";
	protected String opcaoTransacaoSinistro = "(//span[contains(.,'Sinistro')])[4]";
	protected String opcaoImportacaoDeDocumentos = "//span[@class='ui-menuitem-text'][contains(.,'Importação de Documentos')]";
	protected String opcaoTrancacaoAutorizacaoPagamento = "(//span[@class='ui-menuitem-text'][contains(.,'Autorização de Pagamentos')])[1]";
	protected String opcaoCarta = "(//span[@class='ui-menuitem-text'][contains(.,'Carta')])[4]";
	protected String abaAutorizacaoPagamento="(//a[contains(.,'Autorização de Pagamentos')])[3]";
	protected String botaoFecharAba = "//span[@class='ui-icon ui-icon-close']";
	protected String botaoBeneficiario = "//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-hover']";
	protected String opcaoTransacaoCliente = "(//span[@class='ui-menuitem-text'][contains(.,'Clientes')])[2]";
	protected String opcaoAnaliseSinistro = "(//span[@class='ui-menuitem-text'][contains(.,'Análise de Sinistro')])";
	protected String opcaoCartasPendentes = "(//span[contains(.,'Pendentes')])[2]";
	protected String dropDownPessoa = "//label[@id='frmClaimMaintenance:tabs:selReceiverPersonType_label']";
	protected String opcapFisica = "//li[@data-label='Física']";
	protected String DropDownTipoConta = "//li[@data-label='C/C INDIVIDUAL']";
	protected String campoNome = "//input[contains(@name,'frmClaimMaintenance:tabs:txtReceiverName')]";
	protected String dropDownBanco = "//input[contains(@name,'frmClaimMaintenance:tabs:txtReceiverName')]";
	protected String campoPesquisaBanco = "//input[@name='frmClaimMaintenance:tabs:selReceiverBank_filter']";
	protected String campoAgencia = "//input[contains(@name,'frmClaimMaintenance:tabs:txtReceiverBranchNumber')]";
	protected String campoDigitoAgencia = "//input[contains(@name,'frmClaimMaintenance:tabs:txtReceiverBranchDV')]";
	protected String botaoOkCadastroFavorecido = "(//span[contains(@class,'ui-button-text ui-c')])[9]";
	protected String botaoSalvarCadastroFavorecido = "//span[@class='ui-button-icon-left ui-icon ui-c icon-save']";
	
	
	
	// Xpath Imagem carregamento
	public static String loading = "//div[@id and contains(@class,'ui-overlay-visible')][div/img[contains(@src,'loading')]]";
    //Xpath 
	
	public static String loadingImage="//*[@id='j_id_7j']";
	
	
	// Sessao Life
	protected String sessaoLife = "//div[@id='sessionInfo']";
	// Frame
	protected static String idFrame = "iframeID";
	@FindBy(id = "toolbarButtonClient")
	protected WebElement botaoMenuCliente;
	@FindBy(id = "toolbarButtonMasterPolicy")
	protected WebElement botaoMenuMasterPolicy;
	@FindBy(id = "toolbarButtonClaim")
	protected WebElement botaoMenuSinistro;
	@FindBy(id = "toolbarButtonExit")
	protected WebElement botaoLogout;
}
