package br.com.primeup.cardif.life.page;


import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeHomeElementMap;
import br.com.primeup.cardif.testrules.TestRule;


public class LifeHomePage extends LifeHomeElementMap {

	public LifeHomePage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		sfSwitchDefaultFrame();
		waitLoading(sessaoLife);
		sfNavigateDropDownMenu(menuCarga);
		PageFactory.initElements(driver, this);
	}

	public void acessarMenuSinistro() throws Exception {
		sfSwitchDefaultFrame();
		sfClick(botaoMenuSinistro);
		sfSwitchFrame(getIdFrame());
	}
	
	public void sair() throws Exception {
		sfSwitchDefaultFrame();
		sfClick(botaoLogout);
	}
	
	public void acessarRelatorioPremioPendente() throws Exception{
		sfNavigateDropDownMenu(menuRelatorios);
		sfNavigateDropDownMenu(opcaoRegistroOficial);
		sfNavigateDropDownMenu(opcaoPremio);
		sfClick(opcaoPendentes);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarRelatorioPremioEmitido() throws Exception{
		sfNavigateDropDownMenu(menuRelatorios);
		sfNavigateDropDownMenu(opcaoRegistroOficial);
		sfNavigateDropDownMenu(opcaoPremio);
		sfClick(opcaoEmitidos);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarRelatorioPremioCobrados() throws Exception{
		sfNavigateDropDownMenu(menuRelatorios);
		sfNavigateDropDownMenu(opcaoRegistroOficial);
		sfNavigateDropDownMenu(opcaoPremio);
		sfClick(opcaoCobrados);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarRelatorioPremioRestituicao() throws Exception{
		sfNavigateDropDownMenu(menuRelatorios);
		sfNavigateDropDownMenu(opcaoRegistroOficial);
		sfNavigateDropDownMenu(opcaoPremio);
		sfClick(opcaoRestituicao);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarRelatorioContasTransitorias() throws Exception{
		sfNavigateDropDownMenu(menuRelatorios);
		sfClick(opcaoRelatorioContasTransitorias);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarRelatorioRepasse() throws Exception{
		sfNavigateDropDownMenu(menuRelatorios);
		sfClick(opcaoRelatorioRepasse);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarRelatorioTaxas() throws Exception{
		sfNavigateDropDownMenu(menuRelatorios);
		sfClick(opcaoRelatorioTaxas);
		sfSwitchFrame(getIdFrame());
	}
	
	
	public void acessarPagamentoContabilidade() throws Exception{
		sfNavigateDropDownMenu(menuFinanceiro);
		sfClick(opcaoPagamentoContabilidade);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarMenuClientes() throws Exception {
		sfClick(botaoMenuCliente);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarMenuMasterPolicy() throws Exception {
		sfSwitchDefaultFrame();
		sfClick(botaoMenuMasterPolicy);
		sfSwitchFrame(getIdFrame());
	}
	
	public void acessarTrancacoesAutorizacaoPagamento() throws Exception{
		sfNavigateDropDownMenu(menuTrancacoes);
		sfNavigateDropDownMenu(opcaoTrancacaoSinistro);
		sfClick(opcaoTrancacaoAutorizacaoPagamento);
		waitLoading(abaAutorizacaoPagamento);
		sfSwitchFrame(getIdFrame());
	}
	
	
	public void fecharAba() throws Exception{
		driver.navigate().refresh();
	}


	public static String getIdFrame() {
		TestRule.newframe();
		return idFrame+TestRule.getQtdFrame();
	}
	
	public static String getIdCurrentFrame() {
		return idFrame+TestRule.getQtdFrame();
	}
	
	public void clearIdFrame() {
		TestRule.clearQtdFrame();
	}

}
