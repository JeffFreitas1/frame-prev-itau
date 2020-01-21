package br.com.cardif.webservice.model;

import java.util.List;
import java.util.Map;

import br.com.cardif.utils.Utils;

public class Proposta {

	private String dtOperacao;
	private String codConcessionaria;
	private String codGarantia;
	private String codPlano;
	private String vigenciaSeguro;
	private String idadeVeiculo;
	private String tipoProduto;
	private String contrato;
	private String valorPremio;
	private String dtInicioVigencia;
	private String dtFimVigencia;
	private String canalComercializacao;

	public Proposta(String dtOperacao, String codConcessionaria, String codGarantia, String codPlano,
			String vigenciaSeguro, String idadeVeiculo, String tipoProduto, String contrato, String valorPremio,
			String dtInicioVigencia, String dtFimVigencia, String canalComercializacao) {

		this.dtOperacao = dtOperacao;
		this.codConcessionaria = codConcessionaria;
		this.codGarantia = codGarantia;
		this.codPlano = codPlano;
		this.vigenciaSeguro = vigenciaSeguro;
		this.idadeVeiculo = idadeVeiculo;
		this.tipoProduto = tipoProduto;
		this.contrato = contrato;
		this.valorPremio = valorPremio;
		this.dtInicioVigencia = dtInicioVigencia;
		this.dtFimVigencia = dtFimVigencia;
		this.canalComercializacao = canalComercializacao;
	}
	
	
	public Proposta(List<Map<String, String>> formulario) {
			
		this.dtOperacao = Utils.getValorFormulario("dtOperacao", formulario);
		this.codConcessionaria = Utils.getValorFormulario("codConcessionaria", formulario);
		this.codGarantia = Utils.getValorFormulario("codGarantia", formulario);
		this.codPlano = Utils.getValorFormulario("codPlano", formulario);
		this.vigenciaSeguro = Utils.getValorFormulario("vigenciaSeguro", formulario);
		this.idadeVeiculo = Utils.getValorFormulario("idadeVeiculo", formulario);
		this.tipoProduto = Utils.getValorFormulario("tipoProduto", formulario);
		this.contrato = Utils.getValorFormulario("contrato", formulario);
		this.valorPremio = Utils.getValorFormulario("valorPremio", formulario);
		this.dtInicioVigencia = Utils.getValorFormulario("dtInicioVigencia", formulario);
		this.dtFimVigencia = Utils.getValorFormulario("dtFimVigencia", formulario);
		this.canalComercializacao = Utils.getValorFormulario("canalComercializacao", formulario);
	}

	public String getDtOperacao() {
		return dtOperacao;
	}

	public void setDtOperacao(String dtOperacao) {
		this.dtOperacao = dtOperacao;
	}

	public String getCodConcessionaria() {
		return codConcessionaria;
	}

	public void setCodConcessionaria(String codConcessionaria) {
		this.codConcessionaria = codConcessionaria;
	}

	public String getCodGarantia() {
		return codGarantia;
	}

	public void setCodGarantia(String codGarantia) {
		this.codGarantia = codGarantia;
	}

	public String getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(String codPlano) {
		this.codPlano = codPlano;
	}

	public String getVigenciaSeguro() {
		return vigenciaSeguro;
	}

	public void setVigenciaSeguro(String vigenciaSeguro) {
		this.vigenciaSeguro = vigenciaSeguro;
	}

	public String getIdadeVeiculo() {
		return idadeVeiculo;
	}

	public void setIdadeVeiculo(String idadeVeiculo) {
		this.idadeVeiculo = idadeVeiculo;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getValorPremio() {
		return valorPremio;
	}

	public void setValorPremio(String valorPremio) {
		this.valorPremio = valorPremio;
	}

	public String getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(String dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public String getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(String dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public String getCanalComercializacao() {
		return canalComercializacao;
	}

	public void setCanalComercializacao(String canalComercializacao) {
		this.canalComercializacao = canalComercializacao;
	}

}
