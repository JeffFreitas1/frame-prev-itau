package br.com.cardif.life.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		waitElementInvisibility(LifeHomeElementMap.loading);
		waitLoadingCss(fechar);
		sfMoveToElementClickCss(fechar);
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
		List<WebElement> listabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("li"));
		List<LifePlano> listPlano = new ArrayList<LifePlano>();
		Double planoPremio=0.0;

		for (int index = 0; index < listabelaCabecalho.size(); index++) {

			if (listabelaCabecalho.get(index).findElement(By.cssSelector("span")).getText().equals(texto.trim())) {
				waitElementInvisibility(LifeHomeElementMap.loading);
				listabelaCabecalho.get(index).findElement(By.cssSelector("span")).click();
				waitElementInvisibility(LifeHomeElementMap.loading);
				sfMoveToElementClick(show);
				waitElementInvisibility(LifeHomeElementMap.loading);
				
				waitLoading(xpathCertificadoPlano);
				// pegando o valor do campo Risco
				Select selectRisco = new Select(sfGetElementByCss(cssrisco));
				WebElement webL = selectRisco.getFirstSelectedOption();
				String planoRisco = webL.getAttribute("text");

				// pegando o valor do campo cobertura
				Select selectCobertura = new Select(sfGetElementByCss(csscobertura));
				webL = selectCobertura.getFirstSelectedOption();
				sfMoveToElement(webL);
				String planoCobertura = webL.getAttribute("text");
				Utils.logPrint("Valores plano cobertura "+planoCobertura.replace("/", "-"));

				// pegando o valor do campo plano
				Select selectPlano = new Select(sfGetElementByCss(cssnomePlano));
				webL = selectPlano.getFirstSelectedOption();
				String planoNome = webL.getAttribute("text");

				// pegando o valor do campo premio
				//boolean tipoPlano = sfIsElementPresent(fieldName);
				if(sfIsElementPresentCss(csspremio)) {
					webL = driver.findElement(By.cssSelector(csspremio));
					
				}else {
					webL = driver.findElement(By.cssSelector(csspremioFator));
				}
				planoPremio = Double
				.parseDouble(StringUtils.converterVirgulaParaPonto(webL.getAttribute("value")));
				
				

				// pegando o valor do campo LMI
				webL = sfGetElementByCss(csslmi);
				String planoLmi = webL.getAttribute("value");

				listPlano.add(new LifePlano(planoRisco, planoCobertura, planoPremio, planoLmi, planoNome));
				sfMoveToElementClickCss(csscancelar);
			}
		}
		return listPlano;
	}
}
