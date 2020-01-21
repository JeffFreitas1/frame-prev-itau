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
import br.com.cardif.life.model.LifePlano;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.StringUtils;
import br.com.cardif.utils.Utils;

public class LifeCertificadoDetalhePage extends LifeCertificadoDetalheElementMap {

	private static LifePlano lifeplano;
	
	public LifeCertificadoDetalhePage() {
		
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	

	public void sairTelaDetalhes() throws Exception {
		
		sfMoveToElementClickCss(fechar);
		
	}
	
	
	public void validaCertifica() {
		
	}
	public void getClickCertificado(String certificado) throws Exception {

//		waitLoading(quantidadeRegistros);
		Thread.sleep(2000);
		Map<String, Integer> cabecalho = new HashMap<>();
		Utils.logPrint("Quantidade Registros");

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));
		Utils.logPrint("Tabela de certificados");
		
		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validacao desejada
		WebElement tabelaRegistros = sfGetElementByCss(tabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));
		Utils.logPrint("Tabela de certificados");
		
	
		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			if (td.get(cabecalho.get("Certificado")).getText().equals(certificado)) {
				Utils.logPrint("Certificado");
				sfDoubleClick(linha);
			}else {
			}
		}
	}
	public List<String> buscaCertificado() throws Exception{
		
		waitLoading(quantidadeRegistros);

		Map<String, Integer> cabecalho = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));
		Utils.logPrint("Tabela de certificado");		
		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validacao desejada
		WebElement tabelaRegistros = sfGetElementByCss(tabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));
		List<String> listaCertificado = new ArrayList<String>();
		Utils.logPrint("Leitura dos campos das linhas de acordo com a valida��o desejada");		
	
		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			listaCertificado.add(td.get(cabecalho.get("Certificado")).getText());
			Utils.logPrint("Certificado");		
		}
		return listaCertificado ;
	} 
	public String AbrirAbaComposicao() throws Exception {
		Thread.sleep(2000);
		sfMoveToElementClick(abaComposicao1);
		Utils.logPrint("abaComposicao1");	
		waitLoading(totalDoPremio);
		String totalPremio = sfGetElement(totalDoPremio).getAttribute("value");
		Utils.logPrint("Total do premio");	
		return totalPremio;		
		}
	public void teste() throws IOException {
		FileWriter arquivoLog = new FileWriter(
				TestRule.getPathCenarioEvidencia().concat("\\logRelatorioContasTransitorias.txt"), true);
		PrintWriter gravarArq = new PrintWriter(arquivoLog);
	}
	public List<LifePlano> LerCertificado(String texto) throws Exception {
	
		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCobertura);
		List<WebElement> litabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("li"));
		List<LifePlano> listPlano = new ArrayList<LifePlano>();

		for (int index = 0; index < litabelaCabecalho.size(); index++) {

			if (litabelaCabecalho.get(index).findElement(By.cssSelector("span")).getText()
					.equals(texto.trim())) {

				litabelaCabecalho.get(index).findElement(By.cssSelector("span")).click();
				Thread.sleep(1000);
				sfMoveToElementClick(show);
				Thread.sleep(2000);

				// pegando o valor do campo Risco
				Select selectRisco = new Select(driver.findElement(By.cssSelector(risco)));
				WebElement WebL = selectRisco.getFirstSelectedOption();
				String planoRisco = WebL.getAttribute("text");

				// pegando o valor do campo cobertura
				Select selectCobertura = new Select(driver.findElement(By.cssSelector(cobertura)));
				WebL = selectCobertura.getFirstSelectedOption();
				String planoCobertura = WebL.getAttribute("text");
				Utils.logPrint("Pegando o valor do campo cobertura");

				// pegando o valor do campo plano
				Select selectPlano = new Select(driver.findElement(By.cssSelector(nomePlano)));
				WebL = selectPlano.getFirstSelectedOption();
				String planoNome = WebL.getAttribute("text");
				Utils.logPrint("Pegando o valor do campo plano");
			

				System.out.println(driver.findElement(By.cssSelector(premio)).toString());
				// pegando o valor do campo premio
				WebL = driver.findElement(By.cssSelector(premio));
				Double planoPremio = Double.parseDouble(StringUtils.converterVirgulaParaPonto(WebL.getAttribute("value")));
				Utils.logPrint("Pegando o valor do campo premio");
						System.out.println();
						
				
				// pegando o valor do campo LMI
				WebL = driver.findElement(By.cssSelector(lmi));
				String planoLmi = WebL.getAttribute("value");

				listPlano.add(new LifePlano(planoRisco, planoCobertura, planoPremio, planoLmi, planoNome));
				Utils.logPrint("Pegando o valor do campo LMI");
				sfMoveToElementClickCss(cancelar);
			}
		}
		return listPlano;
	}
}
