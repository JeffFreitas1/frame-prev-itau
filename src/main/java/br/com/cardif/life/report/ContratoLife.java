package br.com.cardif.life.report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import br.com.cardif.testrules.TestRule;

public class ContratoLife {

	private String numeroContrato;
	private List<CertificadoLife> certificados;
	private FileWriter arquivoLog;
	
	public ContratoLife(String numeroContrato) {
		this.numeroContrato=numeroContrato;
	}
	
	public ContratoLife() {}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public List<CertificadoLife> getCertificados() {
		if (certificados == null)
			return Collections.emptyList();
		else
			return certificados;
	}

	public void setCertificados(List<CertificadoLife> certificados) {
		this.certificados = certificados;
	}
	
	public void limparCertificados() {
		if (certificados != null)
			certificados=Collections.emptyList();
	}
	
	public void criarArquivoValidacaoCancelamento() throws IOException {
		arquivoLog = new FileWriter(TestRule.getPathCenarioEvidencia().concat("\\logCancelamentosParcelas.txt"),
				true);
	}
	
	public void criarArquivoValidacaoRecebimento() throws IOException {
		arquivoLog = new FileWriter(TestRule.getPathCenarioEvidencia().concat("\\logRecebimentoParcelas.txt"),
				true);
	}
	
	public void criarArquivoValidacaoRecebimentoBoleto() throws IOException {
		arquivoLog = new FileWriter(TestRule.getPathCenarioEvidencia().concat("\\logRecebimentoBoletoParcelas.txt"),
				true);
	}

	public void gravarLogValidacaoCancelamento(String certificado) throws Exception {
		PrintWriter gravarArq = new PrintWriter(arquivoLog);
		String log = String.format(
				"Certificado: %1$-20s Contrato: %2$-15s possui parcelas ativas",
				certificado, numeroContrato);
		gravarArq.println(log);
	}
	
	
	public void gravarLogValidacaoRecebimento(String certificado) throws Exception {
		PrintWriter gravarArq = new PrintWriter(arquivoLog);
		String log = String.format(
				"Certificado: %1$-20s Contrato: %2$-15s contem recebimento de parcela divergente",
				certificado, numeroContrato);
		gravarArq.println(log);
	}
	
	public boolean validaCertificadosCancelados() {
		File arquivoLeitura = new File(TestRule.getPathCenarioEvidencia().concat("\\logCancelamentosParcelas.txt"));
		boolean possuiRegistros=(arquivoLeitura.length() > 0);
		return possuiRegistros;
	}
	
	public boolean validaCertificadosRecebido() {
		File arquivoLeitura = new File(TestRule.getPathCenarioEvidencia().concat("\\logRecebimentoParcelas.txt"));
		boolean possuiRegistros=(arquivoLeitura.length() > 0);
		return possuiRegistros;
	}
	
	public void salvarLogValidacao() throws IOException {
		arquivoLog.close();
	}

}
