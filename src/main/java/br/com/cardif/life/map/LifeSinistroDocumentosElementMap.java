package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeSinistroDocumentosElementMap extends PageObjectUtils {
	//Botões
	@FindBy(xpath = "//*[@id=\"frmClaimMaintenance:tabs:cmdAddDocument\"]")
	protected WebElement botaoAdicionarDocumento;
	@FindBy(xpath = "(//span[@class='ui-button-text ui-c'][contains(.,'OK')])[3]")
	protected WebElement botaoOkDocumento;
	@FindBy(xpath = "//span[@class='ui-button-text ui-c'][contains(.,'Alterar')]")
	protected WebElement botaoAlterarDadosSinistro;
	//Dropdowns
	@FindBy(xpath = "//label[contains(@id,'frmClaimMaintenance:tabs:selDocument_label')]")
	protected WebElement dropDownDocumento;
	@FindBy(xpath = "//input[contains(@name,'frmClaimMaintenance:tabs:selDocument_filter')]")
	protected WebElement campoPesquisaTiposDocumentos;

}
