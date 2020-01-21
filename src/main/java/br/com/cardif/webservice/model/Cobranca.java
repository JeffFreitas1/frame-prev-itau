package br.com.cardif.webservice.model;

import java.util.List;
import java.util.Map;

import br.com.cardif.utils.Utils;

public class Cobranca {
	
	 private String numeroOperadora;
	 private String nomeCartao;
	 private String numeroCartao;
	 private String vencimentoCartao;
	 private String cvvCartao;
	 private String valorParcela;
	 private String qtParcelas;
	 
	 
	public Cobranca(String numeroOperadora, String nomeCartao, String numeroCartao, String vencimentoCartao,
			String cvvCartao, String valorParcela, String qtParcelas) {
		
		this.numeroOperadora = numeroOperadora;
		this.nomeCartao = nomeCartao;
		this.numeroCartao = numeroCartao;
		this.vencimentoCartao = vencimentoCartao;
		this.cvvCartao = cvvCartao;
		this.valorParcela = valorParcela;
		this.qtParcelas = qtParcelas;
	}
	
	public Cobranca(List<Map<String, String>> formulario) {
		this.numeroOperadora = Utils.getValorFormulario("numeroOperadora", formulario);
		this.nomeCartao =  Utils.getValorFormulario("nomeCartao", formulario);
		this.numeroCartao =  Utils.getValorFormulario("numeroCartao", formulario);
		this.vencimentoCartao =  Utils.getValorFormulario("vencimentoCartao", formulario);
		this.cvvCartao =  Utils.getValorFormulario("cvvCartao", formulario);
		this.valorParcela =  Utils.getValorFormulario("valorParcela", formulario);
		this.qtParcelas =  Utils.getValorFormulario("qtParcelas", formulario);
	}


	public String getNumeroOperadora() {
		return numeroOperadora;
	}


	public void setNumeroOperadora(String numeroOperadora) {
		this.numeroOperadora = numeroOperadora;
	}


	public String getNomeCartao() {
		return nomeCartao;
	}


	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}


	public String getNumeroCartao() {
		return numeroCartao;
	}


	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}


	public String getVencimentoCartao() {
		return vencimentoCartao;
	}


	public void setVencimentoCartao(String vencimentoCartao) {
		this.vencimentoCartao = vencimentoCartao;
	}


	public String getCvvCartao() {
		return cvvCartao;
	}


	public void setCvvCartao(String cvvCartao) {
		this.cvvCartao = cvvCartao;
	}


	public String getValorParcela() {
		return valorParcela;
	}


	public void setValorParcela(String valorParcela) {
		this.valorParcela = valorParcela;
	}


	public String getQtParcelas() {
		return qtParcelas;
	}


	public void setQtParcelas(String qtParcelas) {
		this.qtParcelas = qtParcelas;
	}
	
	

}
