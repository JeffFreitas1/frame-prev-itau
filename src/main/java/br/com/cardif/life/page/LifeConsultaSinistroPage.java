package br.com.cardif.life.page;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeConsultaSinistroElementMap;
import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeConsultaSinistroPage extends LifeConsultaSinistroElementMap {

	public LifeConsultaSinistroPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(menuPesquisaSinistro);
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void consultarSinistro(String strNumeroSinistro) throws Exception {
		sfSendText(numeroSinistro, strNumeroSinistro);
		sfClick(exibirTodosSinistros);
		sfClick(botaoConsultarSinistro);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Consulta do Sinistro");
	}

	public void acessarPagamentos() throws Exception {
		sfClick(abaPagamentos);
		sfClick(botaoAlterarDadosSinistro);
	}

	public void abrirDetalheSinistro() throws Exception {
		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(registrosConsultaSinistro);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));
		sfDoubleClick(tr.stream().findFirst().get());
		waitLoading(menuSinistro);
		if (sfIsElementPresent(mensagemAviso)) {
			sfMoveToElementClick(botaoOKAviso);
		}
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Detalhes do Sinistro");
	}

	public boolean validarSituacaoSinistro(String situacao) throws Exception {
		boolean situacaoSinistro = false;
		
		// Mapeamento dos campos da tabela de certificados
		int indexStatusSinistro = sfGetXPathCount(indexColunaSinistro.replace("@NOME_COLUNA", "Status Sinistro")) + 1;

		sfMoveToElement(valorColunaSinistro.replaceAll("@INDEX",
				Integer.toString(indexStatusSinistro)));
		String valorStatusSinistro = sfGetText(valorColunaSinistro
				.replaceAll("@INDEX", Integer.toString(indexStatusSinistro))).trim();
		
		situacaoSinistro=valorStatusSinistro.equals(situacao);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Situação do Sinistro");
		return situacaoSinistro;
	}
	
	public boolean validarNumeroSinistro(String situacao) throws Exception {
		boolean situacaoSinistro = false;
		
		// Mapeamento dos campos da tabela de certificados
		int indexStatusSinistro = sfGetXPathCount(indexColunaSinistro.replace("@NOME_COLUNA", "Status Sinistro")) + 1;

		sfMoveToElement(valorColunaSinistro.replaceAll("@INDEX",
				Integer.toString(indexStatusSinistro)));
		String valorStatusSinistro = sfGetText(valorColunaSinistro
				.replaceAll("@INDEX", Integer.toString(indexStatusSinistro))).trim();
		
		situacaoSinistro=valorStatusSinistro.equals(situacao);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Situação do Sinistro");
		return situacaoSinistro;
	}

	public void salvarAlteracoesSinistro() throws Exception {
		sfClick(botaoSalvarAlteracaoSinistros);
		waitElementInvisibility(LifeHomeElementMap.loading);
		if(sfIsElementPresent(botaoMarcarSinistroVisualizado)) {
			sfClick(botaoMarcarSinistroVisualizado);
		}
		waitElementInvisibility(LifeHomeElementMap.loading);
		if (sfIsElementPresent(mensagemSalvoSucesso)) {
			sfMoveToElementClick(botaoOKAviso);
		}
	}

	public void acessarCoberturaValores() throws Exception {
		sfClick(abaCoberturaValores);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Cobertura Valores");
	}

}
