package br.com.cardif.life.page;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeConsultaClienteElementMap;
import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.life.report.CertificadoLife;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.Utils;

public class LifeConsultaClientePage extends LifeConsultaClienteElementMap {

	private CertificadoLife certificadoLife;

	public LifeConsultaClientePage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(opcoesBuscaCliente);
		PageFactory.initElements(driver, this);
		sfMoveToElementClick(checkBoxExibirTodos);
	}

	public void pesquisarClienteCertificado(String certificado) throws Exception {
		sfClick(botaoLimpar);
		sfClick(buscarCertificado);
		sfSendText(txtCertificado, certificado);
		sfClick(botaoPesquisar);
	}

	public void pesquisarClienteContrato(String contrato) throws Exception {
		sfClick(botaoLimpar);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfMoveToElementClick(checkBoxNumeroContrato);
		sfSendText(txtNumContrato, contrato);
		sfClick(botaoPesquisar);
		waitLoading(quantidadeRegistros);
	}

	public void abrirDetalheCliente() throws Exception {
		waitLoading(quantidadeRegistros);
		int indexColSinistro = sfGetXPathCount(
				"//table/thead[@id='frmClientSearch:grdClientes_head']/tr/th[span[text() = 'Nome']]/preceding::th");

		sfDoubleClick("//table/tbody[@id='frmClientSearch:grdClientes_data']/tr/td[" + indexColSinistro + "]");
	}

	public void marcarCertificado(String certificado) throws Exception {
		waitLoading(quantidadeRegistros);
		Map<String, Integer> cabecalho = new HashMap<>();
		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			if (td.get(cabecalho.get("Certificado")).getText().equals(certificado)) {
				td.get(0).click();
			}

		}
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Certificado Selecionado");

	}

	public void selecionarCertificado(String certificado) throws Exception {
		waitLoading(quantidadeRegistros);
		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));
		sfMoveToElementClick(tr.stream().findFirst().get());
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Certificado Selecionado");
	}

	public void abrirCertificadoDetalhe() throws Exception {
		waitLoading(quantidadeRegistros);
		sfDoubleClick(getRegistrosCertificados().stream().findFirst().get());
	}

	public void abrirAbaInformacoesComplementares() throws Exception {
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfClick(abaInformacoesComplementares);
	}

	public void abrirSinistro() throws Exception {
		sfClick(botaoSinistro);
	}

	public void fecharCertificadoDetalhe() throws Exception {
		sfClick(botaoFecharCertificado);
	}

	public String getNumeroContrato() throws Exception {
		waitLoading(quantidadeRegistros);
		Map<String, Integer> cabecalho = new HashMap<>();
		String contrato = "";
		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			contrato = td.get(cabecalho.get("Contrato")).getText();
		}

		return contrato;
	}

	public List<CertificadoLife> getCertificadosContrato() throws Exception {
		waitLoading(quantidadeRegistros);
		List<CertificadoLife> certificados = new ArrayList<>();
		Map<String, Integer> cabecalho = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			certificadoLife = new CertificadoLife();
			certificadoLife.setNumeroCertificado(td.get(cabecalho.get("Certificado")).getText());
			certificados.add(certificadoLife);

		}
		return certificados;
	}

	public boolean validarDadosContrato(String contrato, List<Map<String, String>> campos) throws Exception {
		waitLoading(quantidadeRegistros);
		// Mapeamento dos campos da tabela de certificados
		Map<String, Integer> cabecalho = getCabecalhoCertificado();
		List<WebElement> certificados = getRegistrosCertificados();
		FileWriter arquivoLog = new FileWriter(TestRule.getPathCenarioEvidencia().concat("\\logAdesaoCertificado.txt"),
				true);
		PrintWriter gravarArq = new PrintWriter(arquivoLog);

		for (WebElement certificado : certificados) {
			List<WebElement> coluna = certificado.findElements(By.cssSelector("td"));

			if (coluna.get(cabecalho.get("Contrato")).getText().equals(contrato)) {
				sfMoveToElement(certificado);

				campos.stream().forEach(validacao -> {
					String campo = validacao.get("Campo");
					String valorEsperado = validacao.get("Valor");
					String valorEncontrado = coluna.get(cabecalho.get(campo)).getText();

					if (!Utils.campoValido(valorEsperado, valorEncontrado)) {
						String log = String.format(
								"Contrato: %1$-16s com informação divergente Campo: %2$-15s Valor esperado: %3$-15s Valor encontrado: %4$-15s",
								contrato, campo, valorEsperado, valorEncontrado);
						gravarArq.println(log);
					}

				});

			}

		}

		arquivoLog.close();
		File arquivoLeitura = new File(TestRule.getPathCenarioEvidencia().concat("\\logAdesaoCertificado.txt"));
		return !(arquivoLeitura.length() > 0);
	}

	public Map<String, Integer> getCabecalhoCertificado() throws Exception {
		Map<String, Integer> cabecalho = new HashMap<>();
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		return cabecalho;
	}

	public List<WebElement> getRegistrosCertificados() throws Exception {
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosCertificados);
		return tabelaRegistros.findElements(By.cssSelector("tr"));
	}

	public Map<String, String> getDadosPessoais() throws Exception {
		Map<String, String> dadosPessoais = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(csstabelaDadosClienteCabecalho);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosDadosPessoais);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			sfMoveToElement(linha);
			Utils.logPrint("Dados Pessoais");
			
			for (int index = 0; index < td.size(); index++) {
				WebElement coluna = td.get(index);
				
				dadosPessoais.put(thtabelaCabecalho.get(index).getText().trim(),coluna.getText());
			}
						

		}
		return dadosPessoais;
	}
	
	public void clickCertificado(String certificado) throws Exception {

		Map<String, Integer> cabecalho = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validacao desejada
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			if (td.get(cabecalho.get("Certificado")).getText().equals(certificado)) {
				sfMoveToElement(linha);
				Utils.logPrint("Certificado");
				sfDoubleClick(linha);
			} else {
			}
		}
	}
	
	public List<String> buscaCertificado() throws Exception {

		waitLoading(quantidadeRegistros);

		Map<String, Integer> cabecalho = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(tabelaCabecalhoCertificados);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));
		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validacao desejada
		WebElement tabelaRegistros = sfGetElementByCss(csstabelaRegistrosCertificados);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));
		List<String> listaCertificado = new ArrayList<String>();

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			listaCertificado.add(td.get(cabecalho.get("Certificado")).getText());
		}
		return listaCertificado;
	}

}
