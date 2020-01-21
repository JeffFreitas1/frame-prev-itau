package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeRelatorioTaxasElementMap extends PageObjectUtils {

	// Relatorio vazio
	protected String mensagemRelatorio = "//span[contains(.,'Nenhum contrato foi localizado com os filtros informados.')]";
	// Form
	protected String formularioRelatorio = "//form[@id='frmFeeReport']";
	// Filtro
	protected String filtro = "//legend[contains(.,'Filtro')]";

	@FindBy(xpath = "//input[@id='frmFeeReport:dtStart_input']")
	protected WebElement dataInicio;
	@FindBy(xpath = "//input[@id='frmFeeReport:dtEnd_input']")
	protected WebElement dataFim;
	@FindBy(xpath = "//button[@id='frmFeeReport:j_id_o']")
	protected WebElement botaoGerarRelatorio;
	
}
