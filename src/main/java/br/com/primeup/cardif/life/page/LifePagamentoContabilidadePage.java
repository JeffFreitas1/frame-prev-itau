package br.com.primeup.cardif.life.page;

import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifePagamentoContabilidadeElementMap;
import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class LifePagamentoContabilidadePage extends LifePagamentoContabilidadeElementMap{

	public LifePagamentoContabilidadePage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(detalhePagamentos);
		PageFactory.initElements(driver, this);

    }
	
	
	public void acessarProdutosIndividuais() throws Exception {
		sfClick(abaProdutosIndividuais);
	}
	
	public void acessarProcessamentoMensal() throws Exception {
		sfClick(abaProcessamentoMensal);
	}


	public void calcularProdIndividual() throws Exception {
	    sfClick(botaoCalcularIndividual);
		
	}


	public boolean processamentoEfetuado() throws Exception {
		try {
			waitLoading(mensagemProcessamentoIndividual);
			Utils.logPrint("Processamento Induvidual efetuado");
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}


	public void transmitirSun() throws Exception {
		  sfClick( botaoTransmitir);
		  waitLoading(mensagemTransmissaoIndividual);
	}
	
	public void transmitirRelatorioMensal(String data)  throws Exception{
		sfSendText(dataTransmissaoMensal, data);
		sfClick(botaoTransmitirMensal);
		sfSwitchAlertAccept();
		waitLoading(mensagemProcessamentoMensal);
		Utils.logPrint("Transmissão processamento Mensal");
	}
	
	
	
	
	
}
