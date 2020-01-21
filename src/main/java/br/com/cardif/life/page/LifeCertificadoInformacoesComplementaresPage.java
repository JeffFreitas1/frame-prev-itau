package br.com.cardif.life.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeCertificadoInformacoesComplementaresElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeCertificadoInformacoesComplementaresPage extends LifeCertificadoInformacoesComplementaresElementMap {

	public LifeCertificadoInformacoesComplementaresPage() {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}

	public String getInformacaoComplementar(String campo) throws Exception {
		WebElement informacoesComplementares = sfGetElementByCss(tabelaInformacoesComplementaresCssSelector);
		
		List<WebElement> registrosInformacoes = informacoesComplementares.findElements(By.cssSelector("tr"));
	
		for (WebElement linha : registrosInformacoes) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			if (td.get(0).getText().equals(campo)){
				return td.get(1).getText();
			}
		}
		
		return "";
	}

}
