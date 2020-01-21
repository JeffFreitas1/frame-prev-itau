package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeRelatorioContasTransitoriasElementMap extends PageObjectUtils{
	
	//Relatorio vazio
	protected String mensagem="//span[contains(.,'Nenhum contrato foi localizado com os filtros informados.')]";
	//Form
	protected String opcoesRelatorio="//form[@id='frmTransientAccountReport']";
	//Filtro
	protected String filtro="//legend[contains(.,'Filtro')]";
	//Fechar mensagem
	protected String fecharMensagem="(//span[contains(.,'OK')])[1]";
	
	
	@FindBy(xpath = "//input[@id='frmTransientAccountReport:txtStartDate_input']")
	protected WebElement dataInicio;
	@FindBy(xpath = "//input[@id='frmTransientAccountReport:dtEnd_input']")
	protected WebElement dataFim;
	//Tipo Evento
	protected String tipoEvento= "//div[10]/div/ul/li[normalize-space(text()) = '@TIPOEVENTO']";
	//@FindBy(xpath = "//label[@id='frmTransientAccountReport:j_id_n_label']")
	@FindBy(xpath = "//label[@id='frmTransientAccountReport:j_id_j_label']")
	protected WebElement listaTipoEvento;
	@FindBy(xpath = "//button[@id='frmTransientAccountReport:j_id_o']")
	protected WebElement botaoGerarRelatorio;
	
}
