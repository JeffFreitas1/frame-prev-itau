package br.com.primeup.cardif.webservice.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.com.primeup.cardif.utils.StringUtils;
import br.com.primeup.cardif.utils.Utils;

public class Segurado {

	private String nmSegurado;
	private String cpf;
	private String dtNascimento;
	private String sexo;
	private String estadoCivil;
	private String nacionalidade;
	private String endereco;
	private String numEnd;
	private String complEnd;
	private String bairro;
	private String cidade;
	private String cep;
	private String uf;
	private String dddResidencial;
	private String telResidencial;
	private String dddCelular;
	private String telCelular;
	private String email;

	public Segurado(String nmSegurado, String cpf, String dtNascimento, String sexo, String estadoCivil,
			String nacionalidade, String endereco, String numEnd, String complEnd, String bairro, String cidade,
			String cep, String uf, String dddResidencial, String telResidencial, String dddCelular, String telCelular,
			String email) {

		this.nmSegurado = nmSegurado;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.nacionalidade = nacionalidade;
		this.endereco = endereco;
		this.numEnd = numEnd;
		this.complEnd = complEnd;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.dddResidencial = dddResidencial;
		this.telResidencial = telResidencial;
		this.dddCelular = dddCelular;
		this.telCelular = telCelular;
		this.email = email;

	}

	public Segurado(List<Map<String, String>> formulario) {
		this.nmSegurado = Utils.getValorFormulario("nmSegurado", formulario);
		this.cpf = Utils.getValorFormulario("cpf", formulario);
		this.dtNascimento = Utils.getValorFormulario("dtNascimento", formulario);
		this.sexo = Utils.getValorFormulario("sexo", formulario);
		this.estadoCivil = Utils.getValorFormulario("estadoCivil", formulario);
		this.nacionalidade = Utils.getValorFormulario("nacionalidade", formulario);
		this.endereco = Utils.getValorFormulario("endereco", formulario);
		this.numEnd = Utils.getValorFormulario("numEnd", formulario);
		this.complEnd = Utils.getValorFormulario("complEnd", formulario);
		this.bairro = Utils.getValorFormulario("bairro", formulario);
		this.cidade = Utils.getValorFormulario("cidade", formulario);
		this.cep = Utils.getValorFormulario("cep", formulario);
		this.uf = Utils.getValorFormulario("uf", formulario);
		this.dddResidencial = Utils.getValorFormulario("dddResidencial", formulario);
		this.telResidencial = Utils.getValorFormulario("telResidencial", formulario);
		this.dddCelular = Utils.getValorFormulario("dddCelular", formulario);
		this.telCelular = Utils.getValorFormulario("telCelular", formulario);
		this.email = Utils.getValorFormulario("email", formulario);
	}

	public String getNmSegurado() {
		return nmSegurado;
	}

	public void setNmSegurado(String nmSegurado) {
		this.nmSegurado = nmSegurado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY");
		LocalDate date = LocalDate.parse(dtNascimento, DateTimeFormatter.BASIC_ISO_DATE);
		Date nascimento = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return formatDate.format(nascimento);
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {

		switch (sexo) {
		case "M":
			return "Masculino";
		case "F":
			return "Feminino";
		default:
			return sexo;
		}

	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumEnd() {
		return numEnd;
	}

	public void setNumEnd(String numEnd) {
		this.numEnd = numEnd;
	}

	public String getComplEnd() {
		return complEnd;
	}

	public void setComplEnd(String complEnd) {
		this.complEnd = complEnd;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDddResidencial() {
		return dddResidencial;
	}

	public void setDddResidencial(String dddResidencial) {
		this.dddResidencial = dddResidencial;
	}

	public String getTelResidencial() {
		return telResidencial;
	}

	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	public String getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(String dddCelular) {
		this.dddCelular = dddCelular;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
