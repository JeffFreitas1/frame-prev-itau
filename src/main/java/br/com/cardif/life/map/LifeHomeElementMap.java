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
	protected String opcaoTrancacaoSinistro = "(//span[contains(.,'Sinistro')])[4]";
	protected String opcaoTrancacaoAutorizacaoPagamento = "(//span[@class='ui-menuitem-text'][contains(.,'Autorização de Pagamentos')])[1]";
	protected String abaAutorizacaoPagamento="(//a[contains(.,'Autorização de Pagamentos')])[3]";
	protected String botaoFecharAba = "//span[@class='ui-icon ui-icon-close']";
	protected String opcaoTransacaoCliente = "(//span[@class='ui-menuitem-text'][contains(.,'Clientes')])[2]";
	
	
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
