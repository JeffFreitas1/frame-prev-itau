package br.com.cardif.life.tests.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.cardif.life.page.LifeAberturaSinistroPage;
import br.com.cardif.life.page.LifeConsultaClientePage;
import br.com.cardif.life.page.LifeHomePage;
import br.com.cardif.life.page.LifeLoginPage;
import br.com.cardif.utils.Utils;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class AberturaSinistroStepDefinition {

	LifeHomePage lifeHomePage;
	LifeConsultaClientePage lifeConsultaClientePage;
	LifeAberturaSinistroPage lifeAberturaSinistroPage;

	@Dado("^o acesso ao sistema life ambiente \"([^\"]*)\"$")
	public void o_acesso_ao_sistema_life_ambiente(String ambiente) throws Throwable {
		LifeLoginPage lifeLoginPage = new LifeLoginPage();
		lifeLoginPage.loginPortalLife(ambiente);

	}

	@E("^acessado o Menu Transacao - Clientes$")
	public void acessando_o_Menu_Transacao_Clientes() throws Throwable {
		lifeHomePage = new LifeHomePage();
		lifeHomePage.acessarMenuTransacoesCliente();
	}

	@E("^preenchendo o Campo Certificado$")
	public void preenchendo_o_campo_certificado() throws Throwable {
		lifeConsultaClientePage = new LifeConsultaClientePage();
		lifeConsultaClientePage.pesquisarClienteCertificado("776006719");

	}

	@E("^clicando no Botao Sinistro$")
	public void clicando_no_Botao_Sinistro() throws Throwable {
		lifeConsultaClientePage = new LifeConsultaClientePage();
		lifeConsultaClientePage.abrirSinistro();

	}

	@Entao("^a Janela Abertura de Sinistro sera aberta$")
	public void a_Janela_Abertura_de_Sinistro_sera_aberta() throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		lifeAberturaSinistroPage.validaTituloPagina();

	}

	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario de risco desemprego$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_de_risco_desemprego(List<Map<String, String>> formulario) throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroDesemprego(formulario);
		Utils.logInfo("Numero de Sinistro é:" + nrSinistro);

	} 
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario de risco desemprego involuntario$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_de_risco_desemprego_involuntario(List<Map<String, String>> formulario) throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroDesempregoInvoluntario(formulario);
		Utils.logInfo("Numero de Sinistro é:" + nrSinistro);

	}
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario de risco desemprego involuntario BVP$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_de_risco_desemprego_involuntario_BVP(List<Map<String, String>> formulario) throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroDesempregoInvoluntario(formulario);
		Utils.logInfo("Numero de Sinistro é:" + nrSinistro);
	}
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco morte$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_morte(List<Map<String, String>> formulario) throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroMorte(formulario);
		Utils.logInfo("Numero de Sinistro é:" + nrSinistro);
	}
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco morte BVP$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_morte_BVP(List<Map<String, String>> formulario) throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroMorteBVP(formulario);
		Utils.logInfo("Numero de Sinistro é:" + nrSinistro);
	}
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco iftt$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_iftt(List<Map<String, String>> formulario) throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroIfttNatuerzaNaoPreenchida(formulario);
		Utils.logInfo("Numero de Sinistro é:" + nrSinistro);
	}
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco Roubo ou Furto Qualificado do Aparelho Movel$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_Roubo_ou_Furto_Qualificado_do_Aparelho_Movel(List<Map<String, String>> formulario) throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroRouboOuFurto(formulario);
		Utils.logInfo("Numero de Sinistro é:" + nrSinistro);

	}
}
