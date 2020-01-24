package br.com.cardif.life.report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.poiji.annotation.ExcelCellName;
import com.poiji.bind.Poiji;

import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.Utils;

public class RegistroRepasse {

	@ExcelCellName("OPERAÇÃO")
	private String operacao;
	@ExcelCellName("TIPO")
	private String tipo;
	@ExcelCellName("TIPO DE COBRANÇA")
	private String tipoCobranca;
	@ExcelCellName("NOME DO CLIENTE")
	private String nomeCliente;
	@ExcelCellName("DOCUMENTO DO CLIENTE")
	private String documentoCliente;
	@ExcelCellName("TIPO CLIENTE")
	private String tipoCliente;
	@ExcelCellName("CONTRATO")
	private String contrato;
	@ExcelCellName("CÓDIGO DE COBRANÇA")
	private String codigoCobranca;
	@ExcelCellName("CERTIFICADO DO CLIENTE")
	private String certificadoCliente;
	@ExcelCellName("SISTEMA")
	private String sistema;
	@ExcelCellName("BANDEIRA")
	private String bandeira;
	@ExcelCellName("VALOR DA OPERAÇÃO")
	private Double valorOperacao;
	@ExcelCellName("VALOR DA TAXA")
	private Double valorTaxa;
	@ExcelCellName("VALOR TOTAL DO CONTRATO")
	private Double valorTotalContrato;
	@ExcelCellName("PARCELA")
	private String parcela;
	@ExcelCellName("DATA DE ADESÃO")
	private String dataAdesao;
	@ExcelCellName("DATA DE PAGAMENTO")
	private String dataPagamento;
	@ExcelCellName("DATA CRÉDITO")
	private String dataCredito;
	@ExcelCellName("DATA DE REPASSE")
	private String dataRepasse;
	@ExcelCellName("DATA DE ESTORNO")
	private String dataEstorno;
	@ExcelCellName("PARCEIRO")
	private String parceiro;
	@ExcelCellName("APÓLICE")
	private String apolice;
	@ExcelCellName("CONVÊNIO")
	private String convenio;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(String tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getCodigoCobranca() {
		return codigoCobranca;
	}

	public void setCodigoCobranca(String codigoCobranca) {
		this.codigoCobranca = codigoCobranca;
	}

	public String getCertificadoCliente() {
		return certificadoCliente;
	}

	public void setCertificadoCliente(String certificadoCliente) {
		this.certificadoCliente = certificadoCliente;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public Double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(Double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public Double getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(Double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

	public Double getValorTotalContrato() {
		return valorTotalContrato;
	}

	public void setValorTotalContrato(Double valorTotalContrato) {
		this.valorTotalContrato = valorTotalContrato;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getDataAdesao() {
		return dataAdesao;
	}

	public void setDataAdesao(String dataAdesao) {
		this.dataAdesao = dataAdesao;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(String dataCredito) {
		this.dataCredito = dataCredito;
	}

	public String getDataRepasse() {
		return dataRepasse;
	}

	public void setDataRepasse(String dataRepasse) {
		this.dataRepasse = dataRepasse;
	}

	public String getDataEstorno() {
		return dataEstorno;
	}

	public void setDataEstorno(String dataEstorno) {
		this.dataEstorno = dataEstorno;
	}

	public String getParceiro() {
		return parceiro;
	}

	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}

	public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Map<String, String> getCamposRegistro() {
		Map<String, String> campos = new HashMap<>();
		campos.put("OPERAÇÃO", getOperacao());
		campos.put("TIPO", getTipo());
		campos.put("TIPO DE COBRANÇA", getTipoCobranca());
		campos.put("NOME DO CLIENTE", getNomeCliente());
		campos.put("DOCUMENTO DO CLIENTE", getDocumentoCliente());
		campos.put("TIPO CLIENTE", getTipoCliente());
		campos.put("CERTIFICADO", getCertificadoCliente());
		campos.put("CONTRATO", getContrato());
		campos.put("CÓDIGO DE COBRANÇA", getCodigoCobranca());
		campos.put("CERTIFICADO DO CLIENTE", getCertificadoCliente());
		campos.put("SISTEMA", getSistema());
		campos.put("BANDEIRA", getBandeira());
		campos.put("VALOR DA OPERAÇÃO", String.valueOf(getValorOperacao()));
		campos.put("VALOR DA TAXA", String.valueOf(getValorTaxa()));
		campos.put("VALOR TOTAL DO CONTRATO", String.valueOf(getValorTotalContrato()));
		campos.put("PARCELA", getParcela());
		campos.put("DATA DE ADESÃO", getDataAdesao());
		campos.put("DATA DE PAGAMENTO", getDataPagamento());
		campos.put("DATA DE CREDITO", getDataCredito());
		campos.put("DATA DE REPASSE", getDataRepasse());
		campos.put("DATA DE ESTORNO", getDataEstorno());
		campos.put("PARCEIRO", getParceiro());
		campos.put("APÓLICE", getApolice());
		campos.put("CONVÊNIO", getConvenio());
		return campos;
	}

	public static List<RegistroRepasse> registrosRelatorio() throws Exception {
		File registrosRelatorio = Utils.getRelatorio(TestRule.getPathDownloadArquivo());
		Utils.removeCabecalhoRelatorioXls(registrosRelatorio, "Relatório de Repasse");
		return Poiji.fromExcel(registrosRelatorio, RegistroRepasse.class);
	}

	public static void limparPastaRelatorioRepasse() {
		Utils.deleteTempFiles(TestRule.getPathDownloadArquivo());
	}

	public static boolean validarRegistrosRepasse(List<RegistroRepasse> relatorio,
			List<Map<String, String>> padraoArquivo, Double valorContrato) throws IOException {

		FileWriter arquivoLog = new FileWriter(TestRule.getPathCenarioEvidencia().concat("\\logRelatorioRepasse.txt"),
				true);
		PrintWriter gravarArq = new PrintWriter(arquivoLog);
		final int cabecalhoRelatorio = 2;
		List<ContratoLife> contratos = new ArrayList<ContratoLife>();
		List<RegistroRepasse> certificadosValidos = relatorio.stream()
				.filter(x -> x.getConvenio().equals(Utils.getValorFormulario("CONVÊNIO", padraoArquivo))
						   && x.getParcela().equals(Utils.getValorFormulario("PARCELA", padraoArquivo))
						   && x.getOperacao().equals(Utils.getValorFormulario("OPERAÇÃO", padraoArquivo))
						)
				.collect(Collectors.toList());

		// Filtros dos certificados de acordo com a parcela
		certificadosValidos.stream().forEach(certificado -> {

			if (!contratos.stream()
					.anyMatch(contrato -> contrato.getNumeroContrato().equals(certificado.getContrato()))) {
				contratos.add(new ContratoLife(certificado.getContrato()));
			}
				

		});

		// Validação do valor total do contrato
		contratos.stream().forEach(contrato -> {
			Double valorCobertura = certificadosValidos.stream().filter(x -> x.getContrato().equals(contrato.getNumeroContrato()) )
					.collect(Collectors.summingDouble(y -> y.getValorTotalContrato()));

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
			RegistroRepasse registroRegistroRepasse = relatorio.get(indexRelatorio);
			Map<String, String> campos = registroRegistroRepasse.getCamposRegistro();
			int linhaRelatorio = indexRelatorio;

			if (registroRegistroRepasse.getConvenio().equals(Utils.getValorFormulario("CONVÊNIO", padraoArquivo))
					&& registroRegistroRepasse.getParcela().equals(Utils.getValorFormulario("PARCELA", padraoArquivo))
					&& registroRegistroRepasse.getOperacao().equals(Utils.getValorFormulario("OPERAÇÃO", padraoArquivo))) {

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
		File arquivoLeitura = new File(TestRule.getPathCenarioEvidencia().concat("\\logRelatorioRepasse.txt"));
		return (arquivoLeitura.length() > 0);

	}

}
