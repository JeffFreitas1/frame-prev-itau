package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifePagamentoContabilidadeElementMap extends PageObjectUtils{
	
	// Detalhe Cliente
	protected String detalhePagamentos = "//*[@id=\"tabReports\"]";
	protected String mensagemProcessamentoIndividual ="//span[contains(.,'Processamento Produtos Individuais executado com sucesso!')]";
	protected String mensagemTransmissaoIndividual ="//span[contains(.,'Transmissão do Arquivo (Processamento Individual) executado com sucesso!')]";
	protected String botaoCalcularIndividual="//*[@id=\"tabReports:j_id_1e:j_id_1u\"]";
	protected String botaoTransmitir= "//*[@id=\"tabReports:j_id_1e:j_id_1v\"]";
	protected String dataTransmissaoMensal="//*[@id=\"tabReports:frmBillingCancel:lastDateLastMonth_input\"]";
	protected String botaoTransmitirMensal="//*[@id=\"tabReports:frmBillingCancel:j_id_53\"]";
	protected String mensagemProcessamentoMensal="//div[@class='ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-top'][contains(.,'Mensagens do Sistema')]";
	
	@FindBy(xpath = "//a[@href='#tabReports:j_id_d'][contains(.,'Sinistros / Comissões / Cosseguro')]")
	protected WebElement abaSinistrosComissoesCosseguro;
	@FindBy(xpath = "//a[@href='#tabReports:j_id_1d'][contains(.,'Produtos Individuais')]")
	protected WebElement abaProdutosIndividuais;
	@FindBy(xpath = "//a[@href='#tabReports:j_id_1x'][contains(.,'Restituições Recuperações')]")
	protected WebElement abaRestituicoesRecuperacoes;
	@FindBy(xpath = "//a[@href='#tabReports:j_id_4m'][contains(.,'Processamento Mensal')]")
	protected WebElement abaProcessamentoMensal;
	
	
}
