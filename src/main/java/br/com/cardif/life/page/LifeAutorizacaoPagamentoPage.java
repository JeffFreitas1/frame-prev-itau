package br.com.cardif.life.page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeAutorizacaoPagamentoElementMap;
import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeAutorizacaoPagamentoPage extends LifeAutorizacaoPagamentoElementMap {

	public LifeAutorizacaoPagamentoPage() {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}

	public void pesquisarNumeroSinistro(String numeroSinistro) throws Exception {
		sfClick(opcaoPagamentosBeneficios);
		sfSendText(txtListaSinistro, numeroSinistro);
		sfClick(botaoPesquisar);
		waitElementInvisibility(LifeHomeElementMap.loading);
    }

	public void autorizarPagamentoSinistro(String numeroSinistro) throws Exception {
		// Leitura dos campos das linhas de acordo com a valida��o desejada
		WebElement tabelaRegistros = sfGetElementByCss(tabelaRegistrosSinitros);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));
		Assert.assertTrue(tr.stream().findFirst().isPresent());
		sfMoveToElementClick(tr.stream().findFirst().get());
        sfClick(botaoAutorizarPagamento);
        waitElementInvisibility(LifeHomeElementMap.loading);
        sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Pagamento Autorizado");

	}

}
