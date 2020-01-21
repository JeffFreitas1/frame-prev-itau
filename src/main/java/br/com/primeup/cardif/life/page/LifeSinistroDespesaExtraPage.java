package br.com.primeup.cardif.life.page;


import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeSinistroDespesaExtraElementMap;
import br.com.primeup.cardif.testrules.TestRule;

public class LifeSinistroDespesaExtraPage extends LifeSinistroDespesaExtraElementMap{
	
	public LifeSinistroDespesaExtraPage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void adicionarDespesaExtra() throws Exception {
		sfClick(botaoAdicionarNovaDespesaExtra);
		sfClick(listaFavorecido);
		sfClick(favorecido.replace("@OPCAO", "Banco Honda S/A"));
		sfClick(listaTipoDespesa);
		sfClick(tipoDespesa.replace("@OPCAO", "Procon"));
		sfClick(listaFormaPagamento);
		sfClick(formaPagamento.replace("@OPCAO", "DOC"));
		txtDataPagamento.sendKeys("30/10/2018");
		txtValorDespesa.sendKeys("100");
		txtObsDespesaExtra.sendKeys("teste");
	}
}
