package br.com.cardif.life.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeRelatorioContasTransitoriasElementMap;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.Utils;

public class LifeRelatorioContasTransitoriasPage extends LifeRelatorioContasTransitoriasElementMap{
	
	public LifeRelatorioContasTransitoriasPage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(opcoesRelatorio);
		PageFactory.initElements(driver, this);
	}
	
	public void gerarRelatorio(List<Map<String, String>> formulario, String descricaoTeste) throws Exception {
		sfSendText(dataInicio, Utils.getValorFormulario("Data Pesquisa", formulario));
		sfClick(filtro);
		sfClick(listaTipoEvento);
		sfClick(tipoEvento.replace("@TIPOEVENTO", Utils.getValorFormulario("Tipo Evento", formulario)));
		sfClick(filtro);
		Utils.logPrint(descricaoTeste.concat(" Parametros Relatorio Contas Transitorias"));
		sfClick(botaoGerarRelatorio);
				
	}
	
	public boolean relatorioVazio(String descricaoTeste) {
		try {
			waitLoading(mensagem);
			Utils.logPrint(descricaoTeste+" Relatorio Contas Transitorias sem registros");
			sfClick(fecharMensagem);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
