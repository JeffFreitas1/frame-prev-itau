package br.com.cardif.life.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeClienteDetalheElementMap;
import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.StringUtils;
import br.com.cardif.utils.Utils;

public class LifeClienteDetalhePage extends LifeClienteDetalheElementMap {

	public LifeClienteDetalhePage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(detalheCliente);
		PageFactory.initElements(driver, this);
	}

	public void acessarEnderecos() throws Exception {
		waitLoading(detalheCliente);
		sfClick(abaEnderecos);
		waitElementInvisibility(LifeHomeElementMap.loading);
	}

	public void acessarHistoricoPagamentos() throws Exception {
		waitLoading(detalheCliente);
		sfClick(abaHistoricoPagamentos);
		waitElementInvisibility(loadingPagamento);
	}

	public void fecharDadosCliente() throws Exception {
		sfClick(botaoFecharDadosCliente);
		waitElementInvisibility(LifeHomeElementMap.loading);
	}

	public boolean validarCertificadoCancelado(String certificado) throws Exception {
		int indexCertificado = 0;
		int indexStatus = 0;
		boolean certificadoCancelado = false;
		WebElement tabelaCabecalho = driver.findElement(By.cssSelector(
				"#frmClient\\:tabView\\:grdPaymentLogs > div:nth-child(1) > div:nth-child(1) > table:nth-child(1)"));
		List<WebElement> th = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < th.size(); index++) {

			if (th.get(index).getText().contains("Certificado"))
				indexCertificado = index;
			if (th.get(index).getText().contains("Status"))
				indexStatus = index;
		}

		WebElement tabelaRegistros = driver.findElement(
				By.cssSelector("#frmClient\\:tabView\\:grdPaymentLogs > div:nth-child(2) > table:nth-child(1)"));

		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			if (td.get(indexCertificado).getText().replace("-", "").contains(certificado)) {
				certificadoCancelado = td.get(indexStatus).getText().equals("CANCELADO");
			}
		}
		if (!certificadoCancelado) {
			Utils.logPrint("Certificado " + certificado.trim() + " possui parcelas ativas");
		}

		return certificadoCancelado;

	}

	public boolean validarCertificadoRecebido(String certificado, String parcela) throws Exception {

		boolean parcelaRecebida = false;
		Map<String, Integer> cabecalho = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(cabecalhoTabelaHistoricoPagamentos);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(registrosHistoricoPagamentos);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));

			if (td.get(cabecalho.get("Certificado")).getText().replace("-", "").contains(certificado)
					&& td.get(cabecalho.get("Parcela")).getText().equals(parcela)) {
				// sfMoveToElement(linha);
				parcelaRecebida = (!(td.get(cabecalho.get("Data Vcto")).getText().isEmpty())
						&& !(td.get(cabecalho.get("Valor Pago")).getText().isEmpty()));
			}

		}

		return parcelaRecebida;

	}

	public boolean validarCertificadoBoletoRecebido(String certificado, String parcela) throws Exception {
		sfZoomOut();
		boolean parcelaRecebida = false;
		Map<String, Integer> cabecalho = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(cabecalhoTabelaHistoricoPagamentos);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(registrosHistoricoPagamentos);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));

			if (td.get(cabecalho.get("Certificado")).getText().replace("-", "").contains(certificado)
					&& td.get(cabecalho.get("Parcela")).getText().equals(parcela)) {
				// sfMoveToElement(linha);
				parcelaRecebida = (!(td.get(cabecalho.get("Venc. Boleto")).getText().isEmpty())
						&& !(td.get(cabecalho.get("Pagto. Parceiro")).getText().isEmpty())
						&& !(td.get(cabecalho.get("Nr.")).getText().isEmpty()));
			}

		}
		sfZoomIn();
		return parcelaRecebida;

	}

	public boolean validarDadosPagamentoCertificado(String masterPolicy, String valorReceber) throws Exception {
		boolean certificadoValido = false;

		Map<String, Integer> cabecalho = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(cabecalhoTabelaHistoricoPagamentos);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(registrosHistoricoPagamentos);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			
			if (td.get(cabecalho.get("Master Policy")).getText().replace("-", "").contains(masterPolicy)) {
				sfMoveToElement(linha);
				String valorReceberLife= StringUtils.converterDecimalDoubleFormat(td.get(cabecalho.get("Valor Receber")).getText());
				certificadoValido = (valorReceberLife.equals(valorReceber));
				Utils.logPrint("Validação de valor Master Policy");
			}
			
		}

		return certificadoValido;
	}

	public void acessarDadosPessoais() throws Exception {
		waitLoading(detalheCliente);
		sfClick(abaDadosPessoais);
		waitElementInvisibility(LifeHomeElementMap.loading);
	}

}
