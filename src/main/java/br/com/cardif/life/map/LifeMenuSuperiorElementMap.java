package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeMenuSuperiorElementMap extends PageObjectUtils{
	
	// Xpath Menu Pesquisa Sinistro
	protected String menuPesquisaSinistro = "//span[@class='ui-menuitem-text'][contains(.,'Relatórios')]";
	@FindBy(xpath = "//span[contains(.,'Relatórios')]")
	protected WebElement menuRelatorios;
}
