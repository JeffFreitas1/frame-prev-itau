package br.com.primeup.cardif.life.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeAberturaSinistroElementMap;
import br.com.primeup.cardif.life.map.LifeHomeElementMap;
import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class LifeAberturaSinistroPage extends LifeAberturaSinistroElementMap {

	public LifeAberturaSinistroPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(abaAberturaSinistro);
		PageFactory.initElements(driver, this);

	}

	public String aberturaSinistro(List<Map<String, String>> formulario) throws Exception {
	    sfZoomOut();
	    sfZoomOut();
		sfClick(listaRazaoAbertura);
		sfClick(razaoAbertura.replace("@RAZAOABERTURA", Utils.getValorFormulario("Razão Abertura", formulario)));
		sfSendText(dtDataAviso, Utils.getValorFormulario("Data Aviso", formulario));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrência", formulario));
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
//		sfClick(listaCID);
//		sfClick(cid.replace("@CID","SIDA" ));
//		sfClick(listaResponsavel);
//		sfClick(responsavel.replace("@RESPONSAVEL","Aline Moraes - Vida" ));
//		sfSendText(txtReclamante, "Ouvinte");
//		sfMoveToElementClick(listaUF);
//		sfClick(uf.replace("@UF","SP" ));
//		sfClick(listaNatureza);
//s		sfClick(natureza.replace("@NATUREZA", Utils.getValorFormulario("Natureza", formulario)));
//		sfClick(listaCausa);
//		sfClick(causa.replace("@CAUSA","ACIDENTE" ));
//		sfSendText(txtParecer, "Em Análise");
		sfClick(botaoOkAberturaSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		sfZoomIn();
		sfZoomIn();
		return getNumeroSinistro();

	}

	public String aberturaSinistroDesemprego(List<Map<String, String>> formulario) throws Exception {
		sfClick(listaRazaoAbertura);
		sfClick(razaoAbertura.replace("@RAZAOABERTURA", Utils.getValorFormulario("Razão Abertura", formulario)));
		sfSendText(dtDataAviso, Utils.getValorFormulario("Data Aviso", formulario));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Afastamento", formulario));
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfSendText(dtDataAdmissao, Utils.getValorFormulario("Data Admissão", formulario));
		sfSendText(dtDataAvisoPrevio, Utils.getValorFormulario("Data Aviso Previo", formulario));
		sfSendText(txtPis, Utils.getValorFormulario("PIS", formulario));
		sfSendText(txtCNPJ, Utils.getValorFormulario("CNPJ", formulario));

		sfClick(botaoOkAberturaSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();

	}

	public String getNumeroSinistro() throws Exception {

		Map<String, Integer> cabecalho = new HashMap<>();
		String numeroSinistro = null;

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(indexPolicyCertificateTable);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(policyCertificateTable);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			if (!td.get(cabecalho.get("Sinistro")).getText().isEmpty()) {
				numeroSinistro = td.get(cabecalho.get("Sinistro")).getText();
			}
		}
		return numeroSinistro;
	}

}
