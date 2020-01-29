package br.com.cardif.life.tests.steps;

import br.com.cardif.life.page.LifeConsultaSinistroPage;
import br.com.cardif.life.page.LifeHomePage;
import br.com.cardif.life.page.LifeLoginPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class RegulacaoSinistrosLife {

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
		lifeConsultaSinistroPage.consultarSinistro("1066220");
	}

	@Entao("^dar um duplo clique na linha apresentada$")
	public void dar_um_duplo_clique_na_linha_apresentada() throws Throwable {
		LifeConsultaSinistroPage lifeConsultaSinistroPage = new LifeConsultaSinistroPage();
		lifeConsultaSinistroPage.abrirDetalheSinistro();
	}

	@Entao("^na aba \"([^\"]*)\" validar o resultado esperado como \"([^\"]*)\"$")
	public void na_aba_validar_o_resultado_esperado_como(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^clicar no botao alterar$")
	public void clicar_no_botao_alterar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^na aba \"([^\"]*)\" Selacionar no campo \"([^\"]*)\" a opcao \"([^\"]*)\" e confirmar$")
	public void na_aba_Selacionar_no_campo_a_opcao_e_confirmar(String arg1, String arg2, String arg3) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^marcar o sinistro como visualizado clicando no botao \"([^\"]*)\"$")
	public void marcar_o_sinistro_como_visualizado_clicando_no_botao(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^consultar novamente o numero de sinistro validando o status \"([^\"]*)\"$")
	public void consultar_novamente_o_numero_de_sinistro_validando_o_status(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^acessar o menu Relatorios - Carta - Pendentes selecionar a opcao \"([^\"]*)\"$")
	public void acessar_o_menu_Relatorios_Carta_Pendentes_selecionar_a_opcao(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" informar \"([^\"]*)\"$")
	public void no_campo_informar(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" informe o numero do sinistro utilizado anteriormente e clicar no botao \"([^\"]*)\"$")
	public void no_campo_informe_o_numero_do_sinistro_utilizado_anteriormente_e_clicar_no_botao(String arg1,
			String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^sera apresentada uma linha de resultado$")
	public void sera_apresentada_uma_linha_de_resultado() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^clicar no botao \"([^\"]*)\" sera gerado um arquivo para download$")
	public void clicar_no_botao_sera_gerado_um_arquivo_para_download(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^clicar no botao \"([^\"]*)\" na caixa de atencao apresentada$")
	public void clicar_no_botao_na_caixa_de_atencao_apresentada(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^acessar o menu Transacao - Sinistro - Importacao de Documentos$")
	public void acessar_o_menu_Transacao_Sinistro_Importacao_de_Documentos() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^informar o numero de sinistro$")
	public void informar_o_numero_de_sinistro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^fazer o upload de uma imagem nos formatos aceitos$")
	public void fazer_o_upload_de_uma_imagem_nos_formatos_aceitos() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^clicar no botao \"([^\"]*)\"$")
	public void clicar_no_botao(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^validar a mensagem \"([^\"]*)\"$")
	public void validar_a_mensagem(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Validar se o Status do sinistro mudou para \"([^\"]*)\"$")
	public void validar_se_o_Status_do_sinistro_mudou_para(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^dar um dublo clique na linha apresentada$")
	public void dar_um_dublo_clique_na_linha_apresentada() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar no botao \"([^\"]*)\"$")
	public void clicar_no_botao(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^na aba favorecidos clicar no botao adicionar$")
	public void na_aba_favorecidos_clicar_no_botao_adicionar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^selecionar a opcao \"([^\"]*)\"$")
	public void selecionar_a_opcao(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^escolher \"([^\"]*)\"$")
	public void escolher(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^preencher todos os campos necessarios$")
	public void preencher_todos_os_campos_necessarios() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^clicar em \"([^\"]*)\"$")
	public void clicar_em(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^clicar em \"([^\"]*)\" novamente$")
	public void clicar_em_novamente(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^clicar na aba \"([^\"]*)\"$")
	public void clicar_na_aba(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^guardar o valor do campo \"([^\"]*)\"$")
	public void guardar_o_valor_do_campo(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" escolher o favorecido cadastro anteriormente$")
	public void no_campo_escolher_o_favorecido_cadastro_anteriormente(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^o no campo \"([^\"]*)\" selecionar um dia util dois dias a frente da data atual$")
	public void o_no_campo_selecionar_um_dia_util_dois_dias_a_frente_da_data_atual(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" informar metade do valor obtido no campo \"([^\"]*)\"$")
	public void no_campo_informar_metade_do_valor_obtido_no_campo(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" Informe \"([^\"]*)\"$")
	public void no_campo_Informe(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" informe \"([^\"]*)\" clicar em \"([^\"]*)\"$")
	public void no_campo_informe_clicar_em(String arg1, String arg2, String arg3) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^selecionar a linha de pagamento clicar em \"([^\"]*)\"$")
	public void selecionar_a_linha_de_pagamento_clicar_em(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Validar o status do pagamento que deve estar \"([^\"]*)\"$")
	public void validar_o_status_do_pagamento_que_deve_estar(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar em \"([^\"]*)\" \"([^\"]*)\" e \"([^\"]*)\"$")
	public void clicar_em_e(String arg1, String arg2, String arg3) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^realizar o login com um usuario coordenador$")
	public void realizar_o_login_com_um_usuario_coordenador() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^acessar o menu Transacoes - Sinistro - Autorizacao de Pagamentos$")
	public void acessar_o_menu_Transacoes_Sinistro_Autorizacao_de_Pagamentos() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" informar o numero de sinistro utilizado anteriormente$")
	public void no_campo_informar_o_numero_de_sinistro_utilizado_anteriormente(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^autorizar o pagamento clicando em \"([^\"]*)\"$")
	public void autorizar_o_pagamento_clicando_em(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^validar se o um checkbox aparece ao lado da coluna \"([^\"]*)\"$")
	public void validar_se_o_um_checkbox_aparece_ao_lado_da_coluna(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^acessar o menu Transacoes - Sinistro - Analise de sinistro$")
	public void acessar_o_menu_Transacoes_Sinistro_Analise_de_sinistro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Informar o sinistro e clicar em \"([^\"]*)\"$")
	public void informar_o_sinistro_e_clicar_em(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Verificar na linha de resultado se a situacao do sinistro mudou para \"([^\"]*)\"$")
	public void verificar_na_linha_de_resultado_se_a_situacao_do_sinistro_mudou_para(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^verificar na aba \"([^\"]*)\" validar o status \"([^\"]*)\"$")
	public void verificar_na_aba_validar_o_status(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar em \"([^\"]*)\" depois em \"([^\"]*)\"$")
	public void clicar_em_depois_em(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Selecionar o mesmo favorecido$")
	public void selecionar_o_mesmo_favorecido() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" informar a outra metade do valor obtido no campo \"([^\"]*)\"$")
	public void no_campo_informar_a_outra_metade_do_valor_obtido_no_campo(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" Informe \"([^\"]*)\" Na prestacao coberta informe \"([^\"]*)\"$")
	public void no_campo_Informe_Na_prestacao_coberta_informe(String arg1, String arg2, String arg3) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^selecionar a linha do pagamento clicar em \"([^\"]*)\"$")
	public void selecionar_a_linha_do_pagamento_clicar_em(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^o status devera mudar para \"([^\"]*)\"$")
	public void o_status_devera_mudar_para(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Salvar e Fechar a aba$")
	public void salvar_e_Fechar_a_aba() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Acessar o menu Transacoes > Sinistro > Autorizacao de pagamentos$")
	public void acessar_o_menu_Transacoes_Sinistro_Autorizacao_de_pagamentos() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^no campo \"([^\"]*)\" informar o numero de sinistro$")
	public void no_campo_informar_o_numero_de_sinistro(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar em pesquisar$")
	public void clicar_em_pesquisar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Selecionar a linha do resultado gerada clique em autorizar$")
	public void selecionar_a_linha_do_resultado_gerada_clique_em_autorizar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^devera aparecer um check ao lado do numero de sinistro$")
	public void devera_aparecer_um_check_ao_lado_do_numero_de_sinistro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^acessar o menu Transacoes - Sinistro - Analise de Sinistro$")
	public void acessar_o_menu_Transacoes_Sinistro_Analise_de_Sinistro() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^pesquisar o Sinistro clicando no botao \"([^\"]*)\"$")
	public void pesquisar_o_Sinistro_clicando_no_botao(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^validar o status do sinistro devera ser \"([^\"]*)\"$")
	public void validar_o_status_do_sinistro_devera_ser(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entao("^Clicar na aba \"([^\"]*)\" verificar o valor no campo \"([^\"]*)\" o valor devera ser de \"([^\"]*)\"$")
	public void clicar_na_aba_verificar_o_valor_no_campo_o_valor_devera_ser_de(String arg1, String arg2, String arg3)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
