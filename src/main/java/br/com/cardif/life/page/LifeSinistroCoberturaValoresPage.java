package br.com.cardif.life.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeSinistroCoberturaValoresElementMap;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.StringUtils;

public class LifeSinistroCoberturaValoresPage extends LifeSinistroCoberturaValoresElementMap{
	
	public LifeSinistroCoberturaValoresPage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	public void consultarHistoricoValores() throws Exception{
		sfClick(botaoHistoricoValores);
	}
	
	public boolean validarPagamento() throws Exception {
		Map<String, Integer> cabecalho = new HashMap<>();
		double saldo=Double.valueOf(sfGetTextHiddenDisable(saldoPagar));
		double valorTotal=Double.valueOf(sfGetTextHiddenDisable(valorTotalPagar));
		double pagamentos=0;
		
		

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(cabecalhoHistoricoValores);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(registrosHistoricoValores);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			
			
			if(td.get(cabecalho.get("Evento")).getText().equals("P")) {
				
				pagamentos+=Double.valueOf(StringUtils.converterDecimalDoubleFormat(td.get(cabecalho.get("Valor")).getText().replace("-", "")));
			}
		}
				
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Historico de Valores");
		return (valorTotal==(pagamentos+saldo));
	}

}
