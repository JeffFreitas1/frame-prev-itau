package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeSinistroSituacaoSinistroElementMap extends PageObjectUtils {
	
	@FindBy(xpath = "//label[contains(@for,'frmClaimMaintenance:tabs:selStatus')]")
	protected WebElement statusDoSinistro;

}
