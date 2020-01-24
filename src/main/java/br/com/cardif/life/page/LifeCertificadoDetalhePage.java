package br.com.cardif.life.page;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.cardif.life.map.LifeCertificadoDetalheElementMap;
import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.life.model.LifePlano;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.StringUtils;
import br.com.cardif.utils.Utils;

public class LifeCertificadoDetalhePage extends LifeCertificadoDetalheElementMap {

	public LifeCertificadoDetalhePage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(xpathCertificadoPage);
		PageFactory.initElements(driver, this);
	}

	public void sairTelaDetalhes() throws Exception {

		sfMoveToElementClickCss(fechar);

	}

	public void validaCertifica() {

	}

	
	public void abrirAbaComposicao() throws Exception {
		sfMoveToElementClick(abaComposicao1);
		
		
	}
	
	public String getValorTotalPremio() throws Exception{
		waitLoading(totalDoPremio);
		String totalPremio = sfGetElement(totalDoPremio).getAttribute("value");
		return totalPremio;
	}

	public List<LifePlano> lerCertificado(String texto) throws Exception {

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCobertura);
		List<WebElement> litabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("li"));
		List<LifePlano> listPlano = new ArrayList<LifePlano>();

		for (int index = 0; index < litabelaCabecalho.size(); index++) {

			if (litabelaCabecalho.get(index).findElement(By.cssSelector("span")).getText().equals(texto.trim())) {
				waitElementInvisibility(LifeHomeElementMap.loading);
				litabelaCabecalho.get(index).findElement(By.cssSelector("span")).click();
				waitElementInvisibility(LifeHomeElementMap.loading);
				sfMoveToElementClick(show);
				waitElementInvisibility(LifeHomeElementMap.loading);

				// pegando o valor do campo Risco
				Select selectRisco = new Select(driver.findElement(By.cssSelector(risco)));
				WebElement WebL = selectRisco.getFirstSelectedOption();
				String planoRisco = WebL.getAttribute("text");

				// pegando o valor do campo cobertura
				Select selectCobertura = new Select(driver.findElement(By.cssSelector(cobertura)));
				WebL = selectCobertura.getFirstSelectedOption();
				String planoCobertura = WebL.getAttribute("text");
				Utils.logPrint("Valores plano cobertura "+planoCobertura);

				// pegando o valor do campo plano
				Select selectPlano = new Select(driver.findElement(By.cssSelector(nomePlano)));
				WebL = selectPlano.getFirstSelectedOption();
				String planoNome = WebL.getAttribute("text");

				// pegando o valor do campo premio
				WebL = driver.findElement(By.cssSelector(premio));
				Double planoPremio = Double
						.parseDouble(StringUtils.converterVirgulaParaPonto(WebL.getAttribute("value")));

				// pegando o valor do campo LMI
				WebL = driver.findElement(By.cssSelector(lmi));
				String planoLmi = WebL.getAttribute("value");

				listPlano.add(new LifePlano(planoRisco, planoCobertura, planoPremio, planoLmi, planoNome));
				sfMoveToElementClickCss(cancelar);
			}
		}
		return listPlano;
	}
}
