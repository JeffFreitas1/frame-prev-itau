package br.com.cardif.life.report;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.poiji.annotation.ExcelCellName;
import com.poiji.bind.Poiji;

import br.com.cardif.life.page.LifeConsultaClientePage;
import br.com.cardif.life.page.LifeHomePage;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.Utils;

public class RegistroOficialContasTransitoria {

	@ExcelCellName("APÓLICE")
	private String apolice;
	@ExcelCellName("ID DO PARCEIRO")
	private String idParceiro;
	@ExcelCellName("NOME DO PARCEIRO")
	private String nomeParceiro;
	@ExcelCellName("COBRANÇA")
	private String cobranca;
	@ExcelCellName("CONVÊNIO")
	private String convenio;
	@ExcelCellName("CERTIFICADO")
	private String certificado;
	@ExcelCellName("PARCELA")
	private String parcela;
	@ExcelCellName("DATA DE REPASSE")
	private String dataRepasse;
	@ExcelCellName("VALOR DO REPASSE")
	private double valorRepasse;
	@ExcelCellName("DATA DE ESTORNO")
	private String dataEstorno;
	@ExcelCellName("VALOR DO ESTORNO")
	private String valorEstorno;

	private String numeroContrato;

	public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

	public String getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(String idParceiro) {
		this.idParceiro = idParceiro;
	}

	public String getNomeParceiro() {
		return nomeParceiro;
	}

	public void setNomeParceiro(String nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}

	public String getCobranca() {
		return cobranca;
	}

	public void setCobranca(String cobranca) {
		this.cobranca = cobranca;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getDataRepasse() {
		return dataRepasse;
	}

	public void setDataRepasse(String dataRepasse) {
		this.dataRepasse = dataRepasse;
	}

	public double getValorRepasse() {
		return valorRepasse;
	}

	public void setValorRepasse(double valorRepasse) {
		this.valorRepasse = valorRepasse;
	}

	public String getDataEstorno() {
		return dataEstorno;
	}

	public void setDataEstorno(String dataEstorno) {
		this.dataEstorno = dataEstorno;
	}

	public String getValorEstorno() {
		return valorEstorno;
	}

	public void setValorEstorno(String valorEstorno) {
		this.valorEstorno = valorEstorno;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Map<String, String> getCamposRegistro() {
		Map<String, String> campos = new HashMap<>();
		campos.put("APÓLICE", getApolice());
		campos.put("ID DO PARCEIRO", getIdParceiro());
		campos.put("NOME DO PARCEIRO", getNomeParceiro());
		campos.put("COBRANÇA", getCobranca());
		campos.put("CONVÊNIO", getConvenio());
		campos.put("CERTIFICADO", getCertificado());
		campos.put("PARCELA", getParcela());
		campos.put("DATA DE REPASSE", getDataRepasse());
		campos.put("VALOR DO REPASSE", String.valueOf(getValorRepasse()));
		campos.put("DATA DE ESTORNO", getDataEstorno());
		campos.put("VALOR DO ESTORNO", String.valueOf(getValorEstorno()));
		return campos;
	}

	public static List<RegistroOficialContasTransitoria> registrosRelatorio() throws Exception {
		File registrosRelatorio = Utils.getRelatorio(TestRule.getPathDownloadArquivo());
		Utils.removeCabecalhoRelatorioXls(registrosRelatorio, "Relatório Contas Transitórias");
		return Poiji.fromExcel(registrosRelatorio, RegistroOficialContasTransitoria.class);
	}

	public static void limparPastaRelatorioContasTransitorias() {
		Utils.deleteTempFiles(TestRule.getPathDownloadArquivo());
	}

	public static boolean validarRegistrosContasTransitorias(List<RegistroOficialContasTransitoria> relatorio,
			List<Map<String, String>> padraoArquivo, Double valorContrato) throws Exception {

		FileWriter arquivoLog = new FileWriter(
				TestRule.getPathCenarioEvidencia().concat("\\logRelatorioContasTransitorias.txt"), true);
		PrintWriter gravarArq = new PrintWriter(arquivoLog);
		final int cabecalhoRelatorio = 2;
		List<ContratoLife> contratos = new ArrayList<ContratoLife>();
		LifeHomePage homepage = new LifeHomePage();
		homepage.acessarMenuClientes();
		LifeConsultaClientePage consultaCliente = new LifeConsultaClientePage();
				
		// Filtros dos certificados de acordo com a parcela
		List<RegistroOficialContasTransitoria> certificadosValidos = relatorio.stream()
				.filter(x -> x.getConvenio().equals(Utils.getValorFormulario("CONVÊNIO", padraoArquivo))
						&& x.getParcela().equals(Utils.getValorFormulario("PARCELA", padraoArquivo)))
				.collect(Collectors.toList());

		// Captura do numero do contrato para validação de valores
		certificadosValidos.stream().forEach(registro -> {
			try {
				consultaCliente.pesquisarClienteCertificado(registro.getCertificado().trim());
				registro.setNumeroContrato(consultaCliente.getNumeroContrato());
				String numeroContrato = consultaCliente.getNumeroContrato();
				if (!contratos.stream().anyMatch(contrato -> contrato.getNumeroContrato().equals(numeroContrato)))
					contratos.add(new ContratoLife(numeroContrato));
			} catch (Exception e) {
				Utils.logError(e);
				Utils.logPrintFail("Falha na captura do contrato certificado "+registro.getCertificado());
			}
		});
		
		// Validação do valor total do contrato
		contratos.stream().forEach(contrato -> {
			Double valorCobertura = certificadosValidos.stream()
					.filter(x -> x.getNumeroContrato().equals(contrato.getNumeroContrato()))
					.collect(Collectors.summingDouble(y -> y.getValorRepasse()));

			DecimalFormat df = new DecimalFormat("0.##");
			valorCobertura = Double.valueOf(df.format(valorCobertura));

			if (!valorContrato.toString().equals(valorCobertura.toString())) {
				String log = String.format(
						"Contrato: %1$-20s com valor total divergente Valor esperado: %2$-15s Valor encontrado: %3$-15s",
						contrato.getNumeroContrato(), valorContrato, valorCobertura);
				gravarArq.println(log);

			}

		});

		for (int indexRelatorio = 0; indexRelatorio < relatorio.size(); indexRelatorio++) {
			RegistroOficialContasTransitoria registroContasTransitoria = relatorio.get(indexRelatorio);
			Map<String, String> campos = registroContasTransitoria.getCamposRegistro();
			int linhaRelatorio = indexRelatorio;

			if (registroContasTransitoria.getConvenio().equals(Utils.getValorFormulario("CONVÊNIO", padraoArquivo))
					&& registroContasTransitoria.getParcela()
							.equals(Utils.getValorFormulario("PARCELA", padraoArquivo))) {

				padraoArquivo.stream().forEach(validacao -> {
					String campo = validacao.get("Campo");
					String valorEsperado = validacao.get("Valor");

					if (!Utils.campoValido(valorEsperado, campos.get(campo))) {
						String log = String.format(
								"Campo divergente: %1$-20s Valor esperado: %2$-15s Valor encontrado: %3$-15s linha: %4$-5s",
								campo, valorEsperado, campos.get(campo), (linhaRelatorio + cabecalhoRelatorio));
						gravarArq.println(log);
					}

				});

			}

		}

		arquivoLog.close();
		File arquivoLeitura = new File(
				TestRule.getPathCenarioEvidencia().concat("\\logRelatorioContasTransitorias.txt"));
		return (arquivoLeitura.length() > 0);

	}

}
