package br.com.primeup.cardif.life.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeRelatorioRepasseElementMap;
import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class LifeRelatorioRepassePage extends LifeRelatorioRepasseElementMap{
	
	public LifeRelatorioRepassePage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(formularioRelatorio);
		PageFactory.initElements(driver, this);
	}
	
	public void gerarRelatorio(List<Map<String, String>> formulario, String descricaoTeste) throws Exception {
		sfSendText(dataInicio, Utils.getValorFormulario("Data Inicio", formulario));
		sfSendText(dataFim, Utils.getValorFormulario("Data Fim", formulario));
		Utils.logPrint(descricaoTeste.concat(" Parametros Relatorio Repasse"));
		sfClick(botaoGerarRelatorio);
	}
	
	public boolean relatorioVazio(String descricaoTeste) {
		try {
			waitLoading(mensagemRelatorio);
			Utils.logPrint(descricaoTeste+" Relatorio de Repasse sem registros");
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
