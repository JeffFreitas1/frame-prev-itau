package br.com.cardif.life.page;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeMenuSuperiorElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeMenuSuperiorPage extends LifeMenuSuperiorElementMap{

	public LifeMenuSuperiorPage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoadPage();
		PageFactory.initElements(driver, this);
	}
	
	public void acessarMenuRelatorios() throws Exception{
		sfNavigateDropDownMenu("Relatórios");
		sfNavigateDropDownMenu("Registro Oficial");
		sfNavigateDropDownMenu("Prêmio");
	}
}
