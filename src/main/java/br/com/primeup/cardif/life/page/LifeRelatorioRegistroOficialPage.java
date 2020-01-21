package br.com.primeup.cardif.life.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeRelatorioRegistroOficialMap;
import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class LifeRelatorioRegistroOficialPage  extends LifeRelatorioRegistroOficialMap{
	
	public LifeRelatorioRegistroOficialPage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(frameROPendente);
		PageFactory.initElements(driver, this);
	}
	
	public void gerarRelatorioRO(List<Map<String, String>> formulario, String tipoRelatorio) throws Exception {
		sfClick(listaParceiros);
		sfClick(parceiro.replace("@PARCEIRO", Utils.getValorFormulario("Parceiros", formulario)));
		sfClick(listaRamosAtividade);
		sfClick(ramoAtividade.replace("@RAMOATIVIDADE", Utils.getValorFormulario("Ramos de Atividade", formulario)));
		sfSendText(dataPesquisa, Utils.getValorFormulario("Data de Pesquisa", formulario));
		sfClick(frameROPendente);
		Utils.logPrint("Parametros Relatorio Registro Oficial ".concat(tipoRelatorio));
		sfClick(botaoGerarRelatorioExcel);
		if(!relatorioVazio(tipoRelatorio)) {
			Thread.sleep(5000);
			Utils.getRelatorio(TestRule.getPathDownloadArquivo());
		}
	}
	
	public boolean relatorioVazio(String descricaoTeste) {
			try {
				waitLoading(mensagem);
				Utils.logPrint(descricaoTeste+" Nenhum registro de RO foi localizado");
				return true;
			}catch (Exception e) {
				return false;
			}
	}
	
	
}
