package br.com.cardif.life.steps;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.com.cardif.life.page.LifeConsultaClientePage;
import br.com.cardif.life.page.LifeHomePage;
import br.com.cardif.life.page.LifeLoginPage;
import br.com.cardif.life.report.RegistroGrafica;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.life.model.LifePlano;
import br.com.cardif.life.page.LifeCertificadoDetalhePage;
import br.com.cardif.life.page.LifeClienteDadosPessoaisPage;
import br.com.cardif.life.page.LifeClienteDetalhePage;
import br.com.cardif.life.page.LifeClienteEnderecosPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import br.com.cardif.utils.*;

public class LifeGraficaSteps {

	LifeLoginPage loginpage;
	String caminho;
	LifeConsultaClientePage lifeconsultacliente;
	LifeHomePage lifehomepage;
	LifeClienteDetalhePage lifeclientedetalhepage;
	LifeCertificadoDetalhePage lifecertificadodetalhepage;
	List<RegistroGrafica> list;
	RegistroGrafica reportRegistroGrafica;
	List<LifePlano> listPlanos;
	List<String> listaCertificados;
	StringUtils stringUtils;

	@Dado("^o acesso ao sistema life ambiente \"([^\"]*)\"$")
	public void o_acesso_ao_sistema_life_ambiente(String base) throws Throwable {
		loginpage = new LifeLoginPage();
		loginpage.loginPortalLife(base);
	}

	@Quando("^acessado a tela de consulta clientes e informado o caminho \"([^\"]*)\"$")
	public void acessado_a_tela_de_consulta_clientes_e_informado_o_caminho(String arquivo) throws Throwable {
		lifehomepage = new LifeHomePage();
		caminho = arquivo;
		reportRegistroGrafica = new RegistroGrafica();
		list = reportRegistroGrafica.registrosGrafica(caminho);
		lifehomepage.acessarMenuClientes();
	}

	@Entao("^deve ser realizada a busca do cliente por Contrato e validado$")
	public void deve_ser_realizada_a_busca_do_cliente_por_Contrato_e_validado() throws Throwable {

		
		FileWriter arquivoLog = new FileWriter(
				TestRule.getPathCenarioEvidencia().concat("\\logRelatorioContasTransitorias.txt"), true);
		PrintWriter gravarArq = new PrintWriter(arquivoLog);
		boolean arquivoValido;
		lifeconsultacliente = new LifeConsultaClientePage();

		for (int indexRelatorio = 0; indexRelatorio < list.size(); indexRelatorio++) {
			Double totalDoPremio = 0.0;
			String contrato = list.get(indexRelatorio).getContrato().trim();
			lifeconsultacliente.waitLoadPage();
			lifeconsultacliente.pesquisarClienteContrato(contrato);
			Map<String, String> endereco = new HashMap<>();
			Map<String, String> dadosPessoais = new HashMap<>();
			dadosPessoais = lifeconsultacliente.getDadosPessoais();
			
			
			// Validando informa????es do cliente
			reportRegistroGrafica.validar(StringUtils.removeCaracteresEspeciais(dadosPessoais.get("Data de Nascimento")),
					reportRegistroGrafica.LimparData(list.get(indexRelatorio).getDtNacimento()), "Campo : dtNacimento", gravarArq, indexRelatorio);
			reportRegistroGrafica.validar(StringUtils.removeCaracteresEspeciais(dadosPessoais.get("CPF/CNPJ")),
					list.get(indexRelatorio).getCpfCnpj().trim(), "Campo : CPF", gravarArq, indexRelatorio);
			reportRegistroGrafica.validar(dadosPessoais.get("Nome").trim(), list.get(indexRelatorio).getNome().trim(),
					"Campo : Nome", gravarArq, indexRelatorio);

			// Validando endere??o.
			lifeconsultacliente.abrirDetalheCliente();
			lifeclientedetalhepage = new LifeClienteDetalhePage();
			lifeclientedetalhepage.acessarEnderecos();
			LifeClienteEnderecosPage lifeClienteEnderecosPage = new LifeClienteEnderecosPage();
			endereco = lifeClienteEnderecosPage.getEnderecoCorrespondencia();
			reportRegistroGrafica.validar(
					lifeClienteEnderecosPage.getLogradouro(endereco.get("Logradouro"), endereco.get("N??")).trim(),
					list.get(indexRelatorio).getEndereco().trim(), "Campo : Endereco", gravarArq, indexRelatorio);
			reportRegistroGrafica.validar(endereco.get("Complemento").trim(),
					list.get(indexRelatorio).getComplemento().trim(), "Campo : Complemento", gravarArq, indexRelatorio);
			reportRegistroGrafica.validar(endereco.get("Bairro").trim(), list.get(indexRelatorio).getBairro().trim(),
					"Campo : Bairro", gravarArq, indexRelatorio);
			reportRegistroGrafica.validar(endereco.get("Estado").trim(), list.get(indexRelatorio).getEstado().trim(),
					"Campo : Estado", gravarArq, indexRelatorio);
			reportRegistroGrafica.validar(endereco.get("Cidade").trim(), list.get(indexRelatorio).getCidade().trim(),
					"Campo : Cidade", gravarArq, indexRelatorio);
			reportRegistroGrafica.validar(endereco.get("CEP").trim(), list.get(indexRelatorio).getCep().trim(),
					"Campo : Cep", gravarArq, indexRelatorio);
			lifeclientedetalhepage.acessarDadosPessoais();
			LifeClienteDadosPessoaisPage lifeClienteDadosPessoaisPage = new LifeClienteDadosPessoaisPage();
			
			
			reportRegistroGrafica.validar(lifeClienteDadosPessoaisPage.getEmail().trim(),
					list.get(indexRelatorio).getEmail().trim(), "Campo : email", gravarArq, indexRelatorio);
			lifeclientedetalhepage.fecharDadosCliente();
//			reportRegistroGrafica.validar(
//					reportRegistroGrafica.LimparData(list.get(indexRelatorio).getVigenciaInicio()),
//					lifeconsultacliente.getDataEfetivacao(), "Campo : dtEfetiva????o", gravarArq, indexRelatorio);
//			reportRegistroGrafica.validar(reportRegistroGrafica.LimparData(list.get(indexRelatorio).getVingenciaFim()),
//					lifeconsultacliente.getDataExpiracao(), "Campo : dtExpira????o", gravarArq, indexRelatorio);
			
			listaCertificados = lifeconsultacliente.buscaCertificado();
			lifeconsultacliente.clickCertificado(list.get(indexRelatorio).getCertificado().trim());
			lifecertificadodetalhepage= new LifeCertificadoDetalhePage();
			lifecertificadodetalhepage.abrirAbaComposicao();
			String valor=lifecertificadodetalhepage.getValorTotalPremio();
		
			totalDoPremio = Double.parseDouble(
					StringUtils.converterVirgulaParaPonto(valor));
			listPlanos = lifecertificadodetalhepage
					.lerCertificado(list.get(indexRelatorio).getPlanoCoberturaContratada());
			 
			// Pegando informa????es de LMI e Premio de cobertura
			// E validando apenas a Cobertura 1 e 2
			Double premioSoma = 0.0;
			for (int index = 0; index < listPlanos.size(); index++) {

				if (listPlanos.get(index).getRisco().equals("Incapacidade F??sica Total Tempor??ria")) {
					premioSoma = premioSoma + listPlanos.get(index).getPremio();
				}
				if (listPlanos.get(index).getRisco().equals("Desemprego Involunt??rio")) {
					premioSoma = premioSoma + listPlanos.get(index).getPremio();
				}
				if (listPlanos.get(index).getRisco().equals("Morte")) {

					Double premio = StringUtils.converteNumero((list.get(indexRelatorio).getPremioCobertura1()));
					reportRegistroGrafica.validar(premio.toString(), listPlanos.get(index).getPremio().toString(),
							"Campo : Premio Cobertura1", gravarArq, indexRelatorio);
					reportRegistroGrafica.validar(StringUtils.limparPontoEVirgula(listPlanos.get(index).getLmi()),
							reportRegistroGrafica.LimpandoZero(list.get(indexRelatorio).getLmiCobertura1().trim()),
							"Campo : LMI Cobertura 1", gravarArq, indexRelatorio);
				}
				if (listPlanos.get(index).getRisco().equals("Invalidez Permanente Total por Acidente")) {

					Double premio = StringUtils.converteNumero(list.get(indexRelatorio).getPremioCobertura2());
					reportRegistroGrafica.validar(premio.toString(), listPlanos.get(index).getPremio().toString(),
							"Campo : Premio Cobertura 2", gravarArq, indexRelatorio);
					reportRegistroGrafica.validar(StringUtils.limparPontoEVirgula(listPlanos.get(index).getLmi()),
							reportRegistroGrafica.LimpandoZero(list.get(indexRelatorio).getLmiCobertura2().trim()),
							"Campo : LMI Cobertura 2", gravarArq, indexRelatorio);
				}
			}
			lifecertificadodetalhepage.sairTelaDetalhes();

			// Validando cobertura 3
			Double premioCobertura3 = StringUtils.converteNumero(list.get(indexRelatorio).getPremioCobertura3());
			reportRegistroGrafica.validar(StringUtils.format1F(premioSoma), premioCobertura3.toString(),
					"Campo : Premio Cobertura 3", gravarArq, indexRelatorio);

			// Acessando e coletando dados da cobertura numero 4
			List<LifePlano> cobertura4 = new ArrayList<LifePlano>();
			Double valorCobertura4 = 0.0;
			for (int index = 0; index < listaCertificados.size(); index++) {
				if (listaCertificados.get(index).toString()
						.equals(list.get(indexRelatorio).getCertificado().trim())) {
				} else {
					listPlanos.clear();
					lifeconsultacliente.clickCertificado(listaCertificados.get(index).toString().trim());
					lifecertificadodetalhepage= new LifeCertificadoDetalhePage();
					lifecertificadodetalhepage.abrirAbaComposicao();
					valor=lifecertificadodetalhepage.getValorTotalPremio();
					totalDoPremio = totalDoPremio + Double.parseDouble(
							StringUtils.converterVirgulaParaPonto(valor));

					listPlanos = lifecertificadodetalhepage
							.lerCertificado(list.get(indexRelatorio).getPlanoCoberturaContratada());
					cobertura4.add(listPlanos.get(0));
					valorCobertura4 = valorCobertura4 + cobertura4.get(index).getPremio();
					lifecertificadodetalhepage.sairTelaDetalhes();

					// Validando o LMI cobertura 3
					Double lmiCobertura4 = Double.parseDouble(StringUtils.limparPontoEVirgula(cobertura4.get(index)
							.getCobertura().toString()
							.substring(cobertura4.get(index).getCobertura().toString().indexOf("$") + 1).trim()));
					Double lmiCobertura42 = Double.parseDouble(list.get(indexRelatorio).getLmiCobertura3());
					reportRegistroGrafica.validar(lmiCobertura4.toString(), lmiCobertura42.toString(),
							"Campo : Lmi Cobertura 3", gravarArq, indexRelatorio);
				}
			}
			// Validando premio da cobertura 4.
			if (list.get(indexRelatorio).getPremioCobertura4().toString().length() != 0) {
				Double valorCoberturaList = StringUtils.converteNumero(list.get(indexRelatorio).getPremioCobertura4());
				reportRegistroGrafica.validar(valorCobertura4.toString(), valorCoberturaList.toString(),
						"Campo : Premio Cobertura 4", gravarArq, indexRelatorio);
			}

			Double totalDoPremioArquivo = StringUtils.converteNumero(Double.parseDouble(
					StringUtils.converterVirgulaParaPonto(list.get(indexRelatorio).getPremioTotal().toString())));

			reportRegistroGrafica.validar(StringUtils.format1F(totalDoPremio), totalDoPremioArquivo.toString(),
					"Campo : Premio Total", gravarArq, indexRelatorio);
		}

		arquivoLog.close();
		File arquivoLeitura = new File(TestRule.getPathCenarioEvidencia().concat("\\logRelatorioContasTransitorias.txt"));
		arquivoValido =  (arquivoLeitura.length() > 0);
		Assert.assertFalse(arquivoValido);

	}

}
