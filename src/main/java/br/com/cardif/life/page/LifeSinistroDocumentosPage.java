package br.com.cardif.life.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.life.map.LifeSinistroDocumentosElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeSinistroDocumentosPage extends LifeSinistroDocumentosElementMap {
	
	public LifeSinistroDocumentosPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		//waitLoading(menuPesquisaSinistro);
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public void clicarBotaoAlterar() throws Exception {
		sfClick(botaoAlterarDadosSinistro);
	}

	public void selecionarDocumentoEmailProtocolo() throws Exception {
		waitElementInvisibility(LifeHomeElementMap.loading);
		// sfMoveToElement(botaoAlterarDadosSinistro);
		sfClick(botaoAdicionarDocumento);

	}
	public void preencherCampoDocumento () throws Exception {
	sfClick(dropDownDocumento);
	sfSendText(campoPesquisaTiposDocumentos, "Email/Protocolo");
	sfClick(botaoOkDocumento);

	}
}