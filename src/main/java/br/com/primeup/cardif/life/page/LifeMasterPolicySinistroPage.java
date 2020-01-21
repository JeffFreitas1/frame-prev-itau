package br.com.primeup.cardif.life.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeHomeElementMap;
import br.com.primeup.cardif.life.map.LifeMasterPolicySinistroElementMap;
import br.com.primeup.cardif.testrules.TestRule;

public class LifeMasterPolicySinistroPage extends LifeMasterPolicySinistroElementMap {

	public LifeMasterPolicySinistroPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitElementInvisibility(LifeHomeElementMap.loading);
		PageFactory.initElements(driver, this);
	}

	public String getPercentual() throws Exception {
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfAttributeRemoveElement(reservaInicial, "disabled");
		sfAttributeRemoveElement(reservaInicial, "type");

		return sfGetAttributeValue(reservaInicial, "value");
	}

	public void selecionarCobertura(String cobertura) throws Exception {
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCobertura);
		List<WebElement> litabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("li"));

		for (int index = 0; index < litabelaCabecalho.size(); index++) {
			if (litabelaCabecalho.get(index).findElement(By.cssSelector("span")).getText().equals(cobertura)) {
				litabelaCabecalho.get(index).findElement(By.cssSelector("span")).click();
			}
		}

	}

}
