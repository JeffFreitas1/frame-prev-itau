package br.com.cardif.life.tests.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.cardif.databaseutils.DatabaseName;
import br.com.cardif.databaseutils.jdbc.DatabaseUtils;
import br.com.cardif.databaseutils.jdbc.queries.Queries;
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
	String msgDataAviso;
	String labelPopUp;

	@Dado("^o acesso ao sistema life ambiente \"([^\"]*)\"$")
	public void o_acesso_ao_sistema_life_ambiente(String ambiente) throws Throwable {
		LifeLoginPage lifeLoginPage = new LifeLoginPage();
		lifeLoginPage.loginPortalLife(ambiente);

	}

	@E("^acessado o Menu Transacao - Clientes$")
	public void acessando_o_Menu_Transacao_Clientes() throws Throwable {
		LifeHomePage lifeHomePage = new LifeHomePage();
		lifeHomePage.acessarMenuTransacoesCliente();
	}
	
	@Dado("^preenchendo o Campo Certificado$")
	public void preenchendo_o_Campo_Certificado() throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		String certificadoDocumentoCardif = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_VIDA_DESEMPREGO_SEM_SINISTRO, DatabaseName.CARDIF);
	    lifeConsultaClientePage.pesquisarClienteCertificado(certificadoDocumentoCardif);
	}

	@E("^preenchendo o Campo Certificado com um numero aleatorio com o tipo de risco morte$")
	public void preenchendo_o_campo_certificado_com_um_numero_aleatorio_com_o_tipo_de_risco_morte() throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		String certificadoDocumentoCardif = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, DatabaseName.BVP);
		lifeConsultaClientePage.pesquisarClienteCertificado(certificadoDocumentoCardif);
	}
	
	@E("^preenchendo o Campo Certificado o numero de uma apolice especifica \"([^\"]*)\"$")
	public void preenchendo_o_Campo_Certificado_o_numero_de_uma_apolice_especifica(String apolice) throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		String certificadoDocumentoCardifApolice = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, null, apolice, DatabaseName.BVP);
		lifeConsultaClientePage.pesquisarClienteCertificado(certificadoDocumentoCardifApolice);
	}
	
	@Dado("^preenchendo o Campo Certificado com um numero especifico \"([^\"]*)\"$")
	public void preenchendo_o_Campo_Certificado_com_um_numero_especifico(String certificado) throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		String certificadoDocumentoEspecifico = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, certificado, null, DatabaseName.BVP);
		lifeConsultaClientePage.pesquisarClienteCertificado(certificadoDocumentoEspecifico);
	}
	@E("^preenchendo o Campo Certificado do ambiente BVP$")
	public void preenchendo_o_Cacmpo_Certifiado_do_ambiente_BVP() throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		String certificadoDocumentoBvp = DatabaseUtils
				.searchOneLineOneColumn(Queries.BUSCA_CERTIF_BVP_DESEMPREGO_INVOLUNT_SEM_SINISTRO, DatabaseName.BVP);
		lifeConsultaClientePage.pesquisarClienteCertificado(certificadoDocumentoBvp);

	}
	
	@Dado("^preenchendo o Campo Certificado do ambiente GARANTIAS$")
	public void preenchendo_o_Campo_Certificado_do_ambiente_GARANTIAS() throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		String certificadoDocumentoGarantias =
				DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_CERTIF_GARANTIAS_ROUBO_OU_FURTO_QUALIF_SEM_SINISTRO,
				DatabaseName.GARANTIAS);
		lifeConsultaClientePage.pesquisarClienteCertificado(certificadoDocumentoGarantias);
	}

	@E("^clicando no Botao Sinistro$")
	public void clicando_no_Botao_Sinistro() throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		lifeConsultaClientePage.abrirSinistro();

	}

	@Entao("^sera apresentada uma mensagem do sistema clickar no botao ok$")
	public void sera_apresentada_uma_mensagem_do_sistema_clickar_no_botao_ok() throws Throwable {
		LifeConsultaClientePage lifeConsultaClientePage = new LifeConsultaClientePage();
		lifeConsultaClientePage.fecharPopUpSinistroExistente();
	}

	@Entao("^a Janela Abertura de Sinistro sera aberta$")
	public void a_Janela_Abertura_de_Sinistro_sera_aberta() throws Throwable {
		lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		lifeAberturaSinistroPage.validaTituloPagina();

	}

	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario de risco desemprego$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_de_risco_desemprego(
			List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroDesemprego(formulario);
		Assert.assertFalse(nrSinistro.isEmpty());
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);

	}

	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario de risco desemprego involuntario$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_de_risco_desemprego_involuntario(
			List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroDesempregoInvoluntario(formulario);
		Assert.assertFalse(nrSinistro.isEmpty());
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);

	}

	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario de risco desemprego involuntario BVP$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_de_risco_desemprego_involuntario_BVP(
			List<Map<String, String>> formulario) throws Throwable {
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroDesempregoInvoluntario(formulario);
		Assert.assertFalse(nrSinistro.isEmpty());
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);
	}

	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco morte$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_morte(List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroMorte(formulario);
		Assert.assertFalse(nrSinistro.isEmpty());
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);
	}

	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco morte BVP$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_morte_BVP(List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroMorteBVP(formulario);
		Assert.assertFalse(nrSinistro.isEmpty());
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);
	}

	@Entao("^o sinistro devera ser preenchido com as informacoes do formulario com a data de aviso vazia$")
	public void o_sinistro_devera_ser_preenchido_com_as_informacoes_do_formulario_com_a_data_de_aviso_vazia(
			List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		labelPopUp = lifeAberturaSinistroPage.aberturaSinistroMorteSemDataAvisoNegativo(formulario);

	}
	
	@Entao("^o sinistro nao devera ser aberto devido a data de aviso nao ter sido preenchida exibindo a mensagem \"([^\"]*)\"$")
	public void o_sinistro_nao_devera_ser_aberto_devido_a_falta_de_aviso_nao_ter_sido_preenchida_exibindo_a_mensagem(String mensagemSemDataAviso) throws Throwable {
		Assert.assertEquals(mensagemSemDataAviso, labelPopUp);
		Utils.logInfo("O Sinistro n??o foi aberto devido a: " + labelPopUp);
	}
	
	@Entao("^o sinistro devera ser preenchido com as informacoes do formulario com a data de aviso maior que a atual$")
	public void o_sinistro_devera_ser_preenchido_com_as_informacoes_do_formulario_com_a_data_de_aviso_maior_que_a_atual(
			List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		labelPopUp = lifeAberturaSinistroPage.aberturaSinistroDataAvisoMaiorQueDataAtual(formulario);

	}

	@Entao("^o sinistro nao devera ser aberto devido a data de aviso ser maior que a data atual exibindo a mensagem \"([^\"]*)\"$")
	public void o_sinistro_nao_devera_ser_aberto_devido_a_data_de_aviso_ser_maior_que_a_data_atual_exibindo_a_mensagem(
			String mensagemDtOcoMaiorQueAtual) throws Throwable {
		Assert.assertEquals(mensagemDtOcoMaiorQueAtual, labelPopUp);
		Utils.logInfo("O Sinistro n??o foi aberto devido a: " + labelPopUp);
	}

	@Entao("^o sinistro devera ser preenchido com as informacoes do formulario sem preencher o campo natureza$")
	public void o_sinistro_devera_ser_preenchido_com_as_informacoes_do_formulario_sem_preencher_o_campo_natureza(
			List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		labelPopUp = lifeAberturaSinistroPage.aberturaSinistroNatuerzaNaoPreenchidaNegativo(formulario);
	}

	@Entao("^o sinistro nao devera ser aberto devido o campo natureza nao estar preenchido exibindo a mensagem \"([^\"]*)\"$")
	public void o_sinistro_nao_devera_ser_aberto_devido_o_campo_natureza_nao_estar_preenchido_exibindo_a_mensagem(
			String mensagemInformeNatureza) throws Throwable {
		Assert.assertEquals(mensagemInformeNatureza, labelPopUp);
		Utils.logInfo("O Sinistro n??o foi aberto devido a: " + labelPopUp);
	}

	@Entao("^o sinistro devera ser preenchido com as informacoes do formulario sem preencher o campo risco$")
	public void o_sinistro_devera_ser_preenchido_com_as_informacoes_do_formulario_sem_preencher_o_campo_risco(
			List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		labelPopUp = lifeAberturaSinistroPage.aberturaSinistroMorteSemRiscoNegativo(formulario);
	}

	@Entao("^o sinistro nao devera ser aberto devido o campo risco nao estar preenchido exibindo a mensagem \"([^\"]*)\"$")
	public void o_sinistro_nao_devera_ser_aberto_devido_o_campo_risco_nao_estar_preenchido_exibindo_a_mensagem(
			String mensagemInformeNatureza) throws Throwable {
		Assert.assertEquals(mensagemInformeNatureza, labelPopUp);
		Utils.logInfo("O Sinistro n??o foi aberto devido a: " + labelPopUp);
	}

	@E("^o sinistro com o campo a data aviso um dia antes da data de ocorrencia nao devera ser aberto$")
	public void o_sinistro_com_o_campo_a_data_aviso_um_dia_antes_da_data_de_ocorrencia_nao_devera_ser_aberto(
			List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		msgDataAviso = lifeAberturaSinistroPage.aberturaSinistroDataAvisoUmDiaAntesDaOcorrencia(formulario);
		Utils.logInfo("A Mensagem Retornada foi: " + msgDataAviso);

	}

	@Entao("^o sinistro nao devera ser aberto e exibe a mensagem \"([^\"]*)\"$")
	public void o_sinistro_nao_devera_ser_aberto_e_exibe_a_mensagem(String mesangem) throws Throwable {
		Assert.assertEquals(mesangem, msgDataAviso);
	}
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco iftt$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_iftt(List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroIftt(formulario);
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);
	}
	
	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco iftt sem natureza$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_iftt_sem_natureza(List<Map<String, String>> formulario) throws Throwable {
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroIfttNatuerzaNaoPreenchida(formulario);
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);
	}


	@Entao("^o sinistro devera ser aberto de acordo com as informacoes do formulario do risco Roubo ou Furto Qualificado do Aparelho Movel$")
	public void o_sinistro_devera_ser_aberto_de_acordo_com_as_informacoes_do_formulario_do_risco_Roubo_ou_Furto_Qualificado_do_Aparelho_Movel(List<Map<String, String>> formulario) throws Throwable {
		LifeAberturaSinistroPage lifeAberturaSinistroPage = new LifeAberturaSinistroPage();
		String nrSinistro = lifeAberturaSinistroPage.aberturaSinistroRouboOuFurto(formulario);
		Assert.assertFalse(nrSinistro.isEmpty());
		Utils.logInfo("Numero de Sinistro ??:" + nrSinistro);

	}
}
