package br.com.primeup.cardif.life.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeHomeElementMap;
import br.com.primeup.cardif.life.map.LifeSinistroPagamentosElementMap;
import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class LifeSinistroPagamentosPage extends LifeSinistroPagamentosElementMap {

	public LifeSinistroPagamentosPage() {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}

	public void adicionarPagamento(List<Map<String, String>> formulario) throws Exception {
		sfClick(botaoAdicionarPagamento);
		waitElementInvisibility(LifeHomeElementMap.loading);
		if (sfIsElementPresent(mensagemAviso)) {
			sfMoveToElementClick(botaoOKAviso);
		}

		sfClick(listaFavorecido);
		sfClick(favorecido.replace("@FAVORECIDO", Utils.getValorFormulario("Nome Favorecido", formulario)));
		sfSendText(txtDataPagamento, Utils.getValorFormulario("Data Pagamento", formulario));
		sfClick(formularioPagamento);
		sfSendText(txtValorPagamento, Utils.getValorFormulario("Valor", formulario));
		sfSendText(txtParcelaSinistro, Utils.getValorFormulario("Parcela Sinistro", formulario));
		sfSendText(txtPrestacaoCoberta, Utils.getValorFormulario("Prestação Coberta", formulario));
		sfClick(listaFormaPagamento);
		selecionarFormaPagamento(Utils.getValorFormulario("Forma Pagamento", formulario));
		sfSendText(txtVencimentoBoleto, Utils.getValorFormulario("Vencimento Boleto", formulario));
		sfClick(formularioPagamento);
		sfClick(botaoConfirmarPagamento);
		sfClick(botaoAnalisarPagamento);
		sfSwitchAlertAccept();
		waitElementInvisibility(LifeHomeElementMap.loading);

	}

	public void selecionarFormaPagamento(String pagamento) throws Exception {
		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement listaFormaPagamento = sfGetElementByCss(formaPagamento);
		List<WebElement> li = listaFormaPagamento.findElements(By.cssSelector("li"));

		for (WebElement linha : li) {
			if(linha.getText().equals(pagamento)) {
				linha.click();
			}
		}
	}

	public boolean pagamentoCadastrado(List<Map<String, String>> formulario) throws Exception {

		Map<String, Integer> cabecalho = new HashMap<>();
		boolean pagamentoCadastrado = false;
		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(cabecalhoPagamento);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(registrosPagamentos);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));
			if (td.get(cabecalho.get("Status")).getText().equals("Analisado")
					&& td.get(cabecalho.get("Valor")).getText().equals(Utils.getValorFormulario("Valor", formulario))) {
				pagamentoCadastrado = true;
			}
		}

		if (pagamentoCadastrado) {
			sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Pagamento Cadastrado");
		}

		return pagamentoCadastrado;
	}

}
