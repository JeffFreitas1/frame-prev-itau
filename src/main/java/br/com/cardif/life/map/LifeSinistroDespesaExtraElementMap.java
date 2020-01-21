package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeSinistroDespesaExtraElementMap extends PageObjectUtils{

	@FindBy(xpath = "//button[@name='frmClaimMaintenance:tabs:cmdAddExtraExpensive']")
	protected WebElement botaoAdicionarNovaDespesaExtra;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:tabs:cmdEditExtraExpensive']")
	protected WebElement botaoEditarDespesaExtra;
	@FindBy(xpath = "//button[@name='frmClaimMaintenance:tabs:cmdDelExtraExpensive']")
	protected WebElement botaoRemoverDespesaExtra;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selReceiver_label']")
	protected WebElement listaFavorecido;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtClaimExtraExpensiveVal']")
	protected WebElement txtValorDespesa;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtClaimExtraExpensiveDate_input']")
	protected WebElement txtDataPagamento;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selExpensiveType_label']")
	protected WebElement listaTipoDespesa;
	@FindBy(xpath = "//label[@id='frmClaimMaintenance:tabs:selExtraExpensePaymentMode_label']")
	protected WebElement listaFormaPagamento;
	@FindBy(xpath = "//input[@id='frmClaimMaintenance:tabs:txtExtraExpenseObs']")
	protected WebElement txtObsDespesaExtra;
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdExtraExpenseOk']")
	protected WebElement botaoIncluirDespesaExtra;
	@FindBy(xpath = "//button[@id='frmClaimMaintenance:tabs:cmdExtraExpenseCancel']")
	protected WebElement botaoCancelarInclusaoDespesaExtra;
	// Xpath Favorecido
	protected String favorecido = "//div[34]/div/ul/li[normalize-space(text()) = '@OPCAO']";
	// Xpath Tipo Despesa
	protected String tipoDespesa = "//div[35]/div/ul/li[normalize-space(text()) = '@OPCAO']";
	// Xpath Tipo Despesa
	protected String formaPagamento = "//div[36]/div/ul/li[normalize-space(text()) = '@OPCAO']";
	
	
}
