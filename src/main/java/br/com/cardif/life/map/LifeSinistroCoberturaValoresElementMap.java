package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeSinistroCoberturaValoresElementMap extends PageObjectUtils{
	
	//Tabela com variação de valores
	protected String tabelaVariacaoValor="//*[@id=\"frmClaimMaintenance:tabs:grdHistoricalValues_data\"]";
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdHistoricalValues']")
	protected WebElement botaoHistoricoValores;
	@FindBy(xpath = "//span[@id='frmClaimMaintenance:tabs:dlgHistoricalValues_title']")
	protected WebElement abaHistoricoValores;
	//Cabecalho do historico de valores
	protected String cabecalhoHistoricoValores="#frmClaimMaintenance\\:tabs\\:grdHistoricalValues > div:nth-child(1) > div:nth-child(1) > table:nth-child(1)";
	//Registros de historico de valores
	protected String registrosHistoricoValores="#frmClaimMaintenance\\:tabs\\:grdHistoricalValues > div:nth-child(2) > table:nth-child(1)";
	//Saldo a pagar
	protected String saldoPagar="//input[@id='frmClaimMaintenance:tabs:txtBalanceDue_hinput']";
	//Valor Total
	protected String valorTotalPagar="//input[@id='frmClaimMaintenance:tabs:txtValorTotalSerPago_hinput']";
	
}
