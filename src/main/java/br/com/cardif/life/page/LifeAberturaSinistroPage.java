package br.com.cardif.life.page;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeAberturaSinistroElementMap;
import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.Utils;

public class LifeAberturaSinistroPage extends LifeAberturaSinistroElementMap {

	public LifeAberturaSinistroPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(abaAberturaSinistro);
		PageFactory.initElements(driver, this);

	}

	public void validaTituloPagina() throws Exception {
		assertTrue(sfGetElement(abaAberturaSinistro).isDisplayed());

	}

	public String aberturaSinistro(List<Map<String, String>> formulario) throws Exception {
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
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Date dateMes = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
		formatoData.format(dateMes);
		sfSendText(dtDataOcorrencia,formatoData.format(dateMes)); //Data afastamento
		Date dateAno = Date.from(ZonedDateTime.now().minusYears(2).toInstant());
		formatoData.format(dateAno);
		sfSendText(dtDataAdmissao, formatoData.format(dateAno));
		sfSendText(dtDataAvisoPrevio, formatoData.format(dateMes));
		sfSendText(txtPis, Utils.getValorFormulario("PIS", formulario));
		sfSendText(txtCNPJ, Utils.getValorFormulario("CNPJ", formulario));
		sfClick(txtCNPJ);
		sfClick(listaDemissao);
		sfClick(motivo.replace("@MOTIVO", Utils.getValorFormulario("Motivo", formulario)));
		sfClick(botaoOkAberturaSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();	
		}



	public String aberturaSinistroDesempregoInvoluntario(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Afastamento", formulario));
		sfSendText(dtDataAdmissao, Utils.getValorFormulario("Data Admissao", formulario));
		sfSendText(dtDataAvisoPrevio, Utils.getValorFormulario("Data Aviso Previo", formulario));
		sfSendText(txtPis, Utils.getValorFormulario("PIS", formulario));
		sfSendText(txtCNPJ, Utils.getValorFormulario("CNPJ", formulario));
		sfClick(txtCNPJ);
		sfClick(listaDemissao);
		sfClick(motivo.replace("@MOTIVO", Utils.getValorFormulario("Motivo", formulario)));
		sfClick(botaoOkAberturaSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();

	}

	public String aberturaSinistroMorte(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfClick(listaNatureza);
		sfClick(natureza.replace("@NATUREZA", Utils.getValorFormulario("Natureza", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		sfClick(botaoOkAberturaSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();

	}

	public String aberturaSinistroMorteBVP(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		if (sfGetText(listaNatureza).isEmpty()) {
			sfClick(listaNatureza);
			sfClick(natureza.replace("@NATUREZA", Utils.getValorFormulario("Natureza", formulario)));
			sfSendText(xpathDtOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
			sfClick(botaoOkAberturaSinistro);

		} else {
			sfSendText(xpathDtOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
			sfClick(botaoOkAberturaSinistro);
		}
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();

	}

	public String aberturaSinistroMorteSemDataAvisoNegativo(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		sfClick(dtDataAviso);
		dtDataAviso.clear();
		sfClick(botaoOkAberturaSinistro);
		//sfClick(botaoOkDataDeAvisoVazia);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return sfGetText(labelDataDeAvisoVazia);

	}
	
	public String aberturaSinistroMorteSemRiscoNegativo(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaNatureza);
		sfClick(natureza.replace("@NATUREZA", Utils.getValorFormulario("Natureza", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		sfClick(botaoOkAberturaSinistro);
		//sfClick(botaoOkDataDeAvisoVazia);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return sfGetText(labelDataDeAvisoVazia);

	}
	
	public String aberturaSinistroDataAvisoMaiorQueDataAtual(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Date date = Date.from(ZonedDateTime.now().plusDays(1).toInstant());
		formatoData.format(date);
		sfSendText(dtDataAviso,formatoData.format(date));
		sfClick(botaoOkAberturaSinistro);
		//sfClick(botaoOkDataDeAvisoVazia);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return sfGetText(labelDataDeAvisoVazia);

	}
	
	public String aberturaSinistroDataAvisoUmDiaAntesDaOcorrencia(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		//sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		//sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Date dataUmDiaAntes = Date.from(ZonedDateTime.now().minusDays(1).toInstant());
		Date dataDeHoje = Calendar.getInstance().getTime();
		formatoData.format(dataDeHoje);
		formatoData.format(dataUmDiaAntes);
		sfSendText(dtDataOcorrencia,formatoData.format(dataDeHoje));
		sfSendText(dtDataAviso,formatoData.format(dataUmDiaAntes));
		sfClick(listaNatureza);
		sfClick(natureza.replace("@NATUREZA", Utils.getValorFormulario("Natureza", formulario)));
		sfClick(botaoOkAberturaSinistro);
		//sfClick(botaoOkDataDeAvisoVazia);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getMensagemDataAvisoUmDiaAntes();

	}
	
	public String aberturaSinistroNatuerzaNaoPreenchidaNegativo(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		sfClick(botaoOkAberturaSinistro);
		//sfClick(botaoOkNaturezaVazia);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return sfGetText(labelDataDeAvisoVazia);

	}


	public String aberturaSinistroIfttNatuerzaNaoPreenchida(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		if (sfGetText(listaNatureza).isEmpty()) {
			sfClick(listaNatureza);
			sfClick(natureza.replace("@NATUREZA", Utils.getValorFormulario("Natureza", formulario)));
			sfClick(botaoOkAberturaSinistro);
		} else {
			sfClick(botaoOkAberturaSinistro);
		}
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();

	}
	
	public String aberturaSinistroIftt(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		sfClick(botaoOkAberturaSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();

	}

	public String aberturaSinistroRouboOuFurto(List<Map<String, String>> formulario) throws Exception {
		sfZoomOut();
		sfClick(listaRisco);
		sfSendText(dtDataOcorrencia, Utils.getValorFormulario("Data Ocorrencia", formulario));
		sfClick(risco.replace("@RISCO", Utils.getValorFormulario("Risco", formulario)));
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfClick(botaoOkAberturaSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Abertura de Sinistro");
		return getNumeroSinistro();

	}

	public String getNumeroSinistro() throws Exception {

		Map<String, Integer> cabecalho = new HashMap<>();
		String numeroSinistro = "";

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
	public String getMensagemDataAvisoUmDiaAntes() throws Exception {

		Map<String, Integer> cabecalho = new HashMap<>();
		String mensagemDataAvisoUmDiaAntes = null;

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
			if (!td.get(cabecalho.get("Mensagem")).getText().isEmpty()) {
				mensagemDataAvisoUmDiaAntes = td.get(cabecalho.get("Mensagem")).getText();
			}
		}
		return mensagemDataAvisoUmDiaAntes;
	}
	
	

}
