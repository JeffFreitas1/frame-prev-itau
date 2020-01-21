package br.com.primeup.cardif.report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.poiji.annotation.ExcelCellName;
import com.poiji.bind.Poiji;

import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class RegistroTaxas {

	@ExcelCellName("OPERAÇÃO")
	private String operacao;
	@ExcelCellName("ID PARCEIRO")
	private String idParceiro;
	@ExcelCellName("PARCEIRO")
	private String parceiro;
	@ExcelCellName("PRODUTO")
	private String produto;
	@ExcelCellName("APÓLICE")
	private String apolice;
	@ExcelCellName("CERTIFICADO")
	private String certificado;
	@ExcelCellName("BANDEIRA")
	private String bandeira;
	@ExcelCellName("CONVÊNIO")
	private String convenio;
	@ExcelCellName("COBRANÇA")
	private String cobranca;
	@ExcelCellName("PARCELA")
	private String parcela;
	@ExcelCellName("VALOR DA TAXA")
	private String valorTaxa;

	public String getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(String idParceiro) {
		this.idParceiro = idParceiro;
	}

	public String getParceiro() {
		return parceiro;
	}

	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getCobranca() {
		return cobranca;
	}

	public void setCobranca(String cobranca) {
		this.cobranca = cobranca;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(String valorTaxa) {
		this.valorTaxa = valorTaxa;
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
		campos.put("ID PARCEIRO", getIdParceiro());
		campos.put("PARCEIRO", getParceiro());
		campos.put("PRODUTO", getProduto());
		campos.put("APÓLICE", getApolice());
		campos.put("CERTIFICADO", getCertificado());
		campos.put("BANDEIRA", getBandeira());
		campos.put("CONVÊNIO", getConvenio());
		campos.put("COBRANÇA", getCobranca());
		campos.put("PARCELA", getParcela());
		campos.put("VALOR DA TAXA", getValorTaxa());
		return campos;
	}

	public static List<RegistroTaxas> registrosRelatorio() throws Exception {
		File registrosRelatorio = Utils.getRelatorio(TestRule.getPathDownloadArquivo());
		Utils.removeCabecalhoRelatorioXls(registrosRelatorio, "Relatório de Taxas");
		return Poiji.fromExcel(registrosRelatorio, RegistroTaxas.class);
	}

	public static void limparPastaRelatorioTaxas() {
		System.out.println("Pasta excluida " + Utils.deleteTempFiles(TestRule.getPathDownloadArquivo()));

	}

	public static boolean validarRegistrosTaxas(List<RegistroTaxas> relatorio, List<Map<String, String>> padraoArquivo,
			String convenioValidar) throws IOException {

		FileWriter arquivoLog = new FileWriter(TestRule.getPathCenarioEvidencia().concat("\\logRelatorioTaxas.txt"),
				true);
		PrintWriter gravarArq = new PrintWriter(arquivoLog);
		final int cabecalhoRelatorio = 2;
		
		for (int indexRelatorio = 0; indexRelatorio < relatorio.size(); indexRelatorio++) {
			RegistroTaxas registroRegistroTaxas = relatorio.get(indexRelatorio);
			Map<String, String> campos = relatorio.get(indexRelatorio).getCamposRegistro();
			final int registroRelatorio = indexRelatorio;

			if (registroRegistroTaxas.getConvenio().equals(Utils.getValorFormulario("CONVÊNIO", padraoArquivo))
					&& registroRegistroTaxas.getParcela().equals(Utils.getValorFormulario("PARCELA", padraoArquivo))
					&& registroRegistroTaxas.getOperacao().equals(Utils.getValorFormulario("OPERAÇÃO", padraoArquivo))) {

				padraoArquivo.stream().forEach(validacao -> {

					String campo = validacao.get("Campo");
					String valorEsperado = validacao.get("Valor");

					if (!Utils.campoValido(valorEsperado, campos.get(campo))) {
						String log = String.format(
								"Campo divergente: %1$-20s Valor esperado: %2$-15s Valor encontrado: %3$-15s linha: %4$-5s",
								campo, valorEsperado, campos.get(campo), (registroRelatorio + cabecalhoRelatorio));
						gravarArq.println(log);
					}

				});
			}

		}

		arquivoLog.close();
		File arquivoLeitura = new File(TestRule.getPathCenarioEvidencia().concat("\\logRelatorioTaxas.txt"));
		
		return (arquivoLeitura.length() > 0);

	}

}
