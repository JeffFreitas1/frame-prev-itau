package br.com.cardif.life.tests.steps;

import org.junit.Assert;

import br.com.cardif.databaseutils.DatabaseName;
import br.com.cardif.databaseutils.jdbc.DatabaseUtils;
import br.com.cardif.databaseutils.jdbc.queries.Queries;
import br.com.cardif.life.page.LifeConsultaSinistroPage;
import br.com.cardif.life.page.LifeHomePage;
import br.com.cardif.life.page.LifeImportacaoDeDocumentosPage;
import br.com.cardif.life.page.LifeImpressaoDasCartasPage;
import br.com.cardif.life.page.LifeLoginPage;
import br.com.cardif.life.page.LifeSinistroCoberturaValoresPage;
import br.com.cardif.life.page.LifeSinistroDocumentosPage;
import br.com.cardif.life.page.LifeSinistroFavorecidosPage;
import br.com.cardif.life.page.LifeSinistroSituacaoSinistroPage;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class RegulacaoSinistrosLife {
	String statusSinistro;
	String sinistroDemissao;
	LifeSinistroDocumentosPage lifeImporacaoDeDocumentosPage;
	double saldo;


	@Dado("^o acesso ao sistema life \"([^\"]*)\"$")
	public void o_acesso_ao_sistema_life_ambiente(String ambiente) throws Throwable {
		LifeLoginPage lifeLoginPage = new LifeLoginPage();
		lifeLoginPage.loginPortalLife(ambiente);
	}

	@E("^acessado o Menu Transacao - Sinistro - Analise de Sinistro$")
	public void acessado_o_Menu_Transacao_Sinistro_Analise_de_Sinistro() throws Throwable {
		LifeHomePage lifeHomePage = new LifeHomePage();
		lifeHomePage.acessarMenuTransacoesSinistroAnaliseSinistro();
	}

	@Entao("^o Numero do Sinistro devera ser consultado$")
	public void o_Numero_do_Sinistro_devera_ser_consultado() throws Throwable {
		LifeConsultaSinistroPage lifeConsultaSinistroPage = new LifeConsultaSinistroPage();
		sinistroDemissao = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_VIDA_DESEMPREGO,
				DatabaseName.CARDIF);
		lifeConsultaSinistroPage.consultarSinistro(sinistroDemissao);
	}

	@Entao("^dar um duplo clique na linha apresentada$")
	public void dar_um_duplo_clique_na_linha_apresentada() throws Throwable {
		LifeConsultaSinistroPage lifeConsultaSinistroPage = new LifeConsultaSinistroPage();
		lifeConsultaSinistroPage.abrirDetalheSinistro();
	}

	@Entao("^^acessar a aba Situacao de Sinistro$")
	public void acessar_a_aba_Situacao_de_Sinistro() throws Throwable {
		LifeConsultaSinistroPage lifeConsultaSinistroPage = new LifeConsultaSinistroPage();
		lifeConsultaSinistroPage.acessarSituacaoSinistro();
	}

	@Entao("^validar o status do sinistro como Aberto")
	public void validar_o_status_do_sinistro_como_Aberto() throws Throwable {
		LifeSinistroSituacaoSinistroPage lifeSinistroSituacaoSinistroPage = new LifeSinistroSituacaoSinistroPage();
		lifeSinistroSituacaoSinistroPage.validarStatusDoSinistro();
	}

	@Entao("^acessar a aba Documentos do Processo$")
	public void acessar_a_aba_Documentos_do_Processo() throws Throwable {
		LifeConsultaSinistroPage lifeConsultaSinistroPage = new LifeConsultaSinistroPage();
		lifeConsultaSinistroPage.acessarAbaDocumentosDoProcesso();
	}

	@Entao("^Clicar no botao alterar$")
	public void clicar_no_botao_alterar() throws Throwable {
		LifeSinistroDocumentosPage lifeSinistroDocumentosPage = new LifeSinistroDocumentosPage();
		lifeSinistroDocumentosPage.clicarBotaoAlterar();

	}

	@Entao("^Clicar no botao adicionar$")
	public void clicar_no_botao_adicionar() throws Throwable {
		LifeSinistroDocumentosPage lifeSinistroDocumentosPage = new LifeSinistroDocumentosPage();
		lifeSinistroDocumentosPage.selecionarDocumentoEmailProtocolo();
	}

	@Entao("^Selecionar no campo Documento a opcao Email/protocolo e confirmar$")
	public void selecionar_no_campo_Documento_a_opcao_Email_protocolo_e_confirmar() throws Throwable {
		LifeSinistroDocumentosPage lifeSinistroDocumentosPage = new LifeSinistroDocumentosPage();
		lifeSinistroDocumentosPage.preencherCampoDocumento();
	}

	@Entao("^consultar novamente o numero de sinistro validando o status Pendente por documentos$")
	public void consultar_novamente_o_numero_de_sinistro_validando_o_status_Pendente_por_documentos() throws Throwable {
		LifeSinistroSituacaoSinistroPage lifeSinistroSituacaoSinistroPage = new LifeSinistroSituacaoSinistroPage();
		lifeSinistroSituacaoSinistroPage.validarStatusDoSinistro();
	}

	@Entao("^acessar o menu Relatorios - Carta - Pendentes$")
	public void acessar_o_menu_Relatorios_Carta_Pendentes() throws Throwable {
		LifeHomePage lifeHomePage = new LifeHomePage();
		lifeHomePage.acessarMenuRelatoriosCartaPendentes();
	}

	@Entao("^selecionar a opcao por tipo no campo Tipo de Carta informar Solicitacao de Documentos preenchendo os campos solicitados clicando em imprimir$")
	public void selecionar_a_opcao_por_tipo_no_campo_Tipo_de_Carta_informar_Solicitacao_de_Documentos_preenchendo_os_campos_solicitados_clicando_em_imprimir()
			throws Throwable {
		LifeImpressaoDasCartasPage lifeImpressaoDasCartasPage = new LifeImpressaoDasCartasPage();
		lifeImpressaoDasCartasPage.preencherSolicitacaoDeDocumentos(sinistroDemissao);
	}

	@Entao("^acessar o menu Transacao - Sinistro - Importacao de Documentos$")
	public void acessar_o_menu_Transacao_Sinistro_Importacao_de_Documentos() throws Throwable {
		LifeHomePage lifeHomePage = new LifeHomePage();
		lifeHomePage.acessarMenuTransacoesSinistroImportacaoDeDocumentos();
	}

	@Entao("^fazer o upload de uma imagem nos formatos aceitos$")
	public void fazer_o_upload_de_uma_imagem_nos_formatos_aceitos() throws Throwable {
		LifeImportacaoDeDocumentosPage lifeImportacaoDeDocumentosPage = new LifeImportacaoDeDocumentosPage();
	    sinistroDemissao = DatabaseUtils.searchOneLineOneColumn(Queries.BUSCA_SINISTRO_VIDA_DESEMPREGO,
			DatabaseName.CARDIF);
	    lifeImportacaoDeDocumentosPage.fazerUploadImagem(sinistroDemissao);
	}

	@Entao("^Validar se o Status do sinistro mudou para Pendente de Visualizacao$")
	public void validar_se_o_Status_do_sinistro_mudou_para_Pendente_de_Visualizacao() throws Throwable {
		LifeSinistroSituacaoSinistroPage lifeSinistroSituacaoSinistroPage = new LifeSinistroSituacaoSinistroPage();
		lifeSinistroSituacaoSinistroPage.validarStatusDoSinistro();
	}

	@Entao("^Clicar no botao Alterar$")
	public void clicar_no_botao_Alterar() throws Throwable {
		LifeSinistroDocumentosPage lifeSinistroDocumentosPage = new LifeSinistroDocumentosPage();
		lifeSinistroDocumentosPage.clicarBotaoAlterar();
	}

	@Entao("^cadastrar um novo beneficiario$")
	public void cadastrar_um_novo_beneficiario() throws Throwable {
		LifeSinistroFavorecidosPage lifeSinistroFavorecidosPage = new LifeSinistroFavorecidosPage();
		lifeSinistroFavorecidosPage.incluirFavorecidoBeneficiario();
	}

	@Entao("^clicar na aba Cobertura/Valores$")
	public void clicar_na_aba_Cobertura_Valores() throws Throwable {
		LifeConsultaSinistroPage lifeConsultaSinistroPage = new LifeConsultaSinistroPage();
		lifeConsultaSinistroPage.acessarCoberturaValores();
	}

	@Entao("^guardar o valor do campo Saldo a pagar$")
	public void guardar_o_valor_do_campo_Saldo_a_pagar() throws Throwable {
		LifeSinistroCoberturaValoresPage lifeSinistroCoberturaValoresPage = new LifeSinistroCoberturaValoresPage();
		saldo = lifeSinistroCoberturaValoresPage.pegarValorSaldoPagar();
	}

	@Entao("^clicar na aba Pagamentos$")
	public void clicar_na_aba_Pagamentos() throws Throwable {
		LifeConsultaSinistroPage lifeConsultaSinistroPage = new LifeConsultaSinistroPage();
		lifeConsultaSinistroPage.acessarCoberturaValores();
	}

	@Entao("^clicar no botao Adicionar$")
	public void clicar_no_botao_Adicionar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo Nome Favorecido escolher o favorecido cadastro anteriormente$")
	public void no_campo_Nome_Favorecido_escolher_o_favorecido_cadastro_anteriormente() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^o no campo data de pagamento selecionar um dia util dois dias a frente da data atual$")
	public void o_no_campo_data_de_pagamento_selecionar_um_dia_util_dois_dias_a_frente_da_data_atual()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo Valor informar metade do valor obtido no campo saldo a pagar$")
	public void no_campo_Valor_informar_metade_do_valor_obtido_no_campo_saldo_a_pagar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo Parcela Sinistro Informe (\\d+)$")
	public void no_campo_Parcela_Sinistro_Informe(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo prestacao coberta informe (\\d+) clicar em Ok$")
	public void no_campo_prestacao_coberta_informe_clicar_em_Ok(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^selecionar a linha de pagamento clicar em Analisar$")
	public void selecionar_a_linha_de_pagamento_clicar_em_Analisar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Validar o status do pagamento que deve estar Analisado$")
	public void validar_o_status_do_pagamento_que_deve_estar_Analisado() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar em Salvar Fechar e Sair$")
	public void clicar_em_Salvar_Fechar_e_Sair() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo Sinistros informar o numero de sinistro utilizado anteriormente$")
	public void no_campo_Sinistros_informar_o_numero_de_sinistro_utilizado_anteriormente() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^autorizar o pagamento clicando em autorizar$")
	public void autorizar_o_pagamento_clicando_em_autorizar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^validar se o um checkbox aparece ao lado da coluna Sinistro$")
	public void validar_se_o_um_checkbox_aparece_ao_lado_da_coluna_Sinistro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Informar o sinistro e clicar em Procurar$")
	public void informar_o_sinistro_e_clicar_em_Procurar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Verificar na linha de resultado se a situacao do sinistro mudou para Liquidado Parcial$")
	public void verificar_na_linha_de_resultado_se_a_situacao_do_sinistro_mudou_para_Liquidado_Parcial()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^verificar na aba Pagamentos validar o status Pago$")
	public void verificar_na_aba_Pagamentos_validar_o_status_Pago() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar em alterar depois em Adicionar$")
	public void clicar_em_alterar_depois_em_Adicionar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo Valor informar a outra metade do valor obtido no campo saldo a pagar$")
	public void no_campo_Valor_informar_a_outra_metade_do_valor_obtido_no_campo_saldo_a_pagar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo Parcela Sinistro Informe (\\d+) Na prestacao coberta informe (\\d+)$")
	public void no_campo_Parcela_Sinistro_Informe_Na_prestacao_coberta_informe(int arg1, int arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^selecionar a linha do pagamento clicar em Analisar$")
	public void selecionar_a_linha_do_pagamento_clicar_em_Analisar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^o status devera mudar para Analisado$")
	public void o_status_devera_mudar_para_Analisado() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo sinistro informar o numero de sinistro$")
	public void no_campo_sinistro_informar_o_numero_de_sinistro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^pesquisar o Sinistro clicando no botao Procurar$")
	public void pesquisar_o_Sinistro_clicando_no_botao_Procurar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^validar o status do sinistro devera ser Liquidado Total$")
	public void validar_o_status_do_sinistro_devera_ser_Liquidado_Total() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar na aba Cobertura/Valores verificar o valor no campo Saldo a pagar o valor devera ser de (\\d+),(\\d+)$")
	public void clicar_na_aba_Cobertura_Valores_verificar_o_valor_no_campo_Saldo_a_pagar_o_valor_devera_ser_de(int arg1,
			int arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}