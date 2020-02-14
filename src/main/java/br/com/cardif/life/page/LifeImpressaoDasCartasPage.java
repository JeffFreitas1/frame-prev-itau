package br.com.cardif.life.page;

import java.awt.Robot;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeImpressaoDasCartasElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeImpressaoDasCartasPage extends LifeImpressaoDasCartasElementMap {
	
	public LifeImpressaoDasCartasPage () throws Exception {
		driver=TestRule.getDriver();
		wait= TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void preencherSolicitacaoDeDocumentos(String strNumeroSinistro) throws Exception {
		sfClick(botaoPorTipo);
		sfClick(tipoCartaDropDown);
		//sfMoveToElement(campoPesquisaTipoCarta);
		sfSendText(campoPesquisaTipoCarta, "Solicitacao de Documentos");
		sfClick(campoPesquisaSolicitacaoDocumentos);
		sfClick(botaoPorTipo);
		sfClick(codSinistro);
		sfSendText(codSinistro, strNumeroSinistro);
		sfClick(botaoGerarRelatorio);
		sfClick(botaoImrpimir);
		rbOkDownload();
		sfClick(botaoNaoEnviarCarta);
		
	}
	

}
