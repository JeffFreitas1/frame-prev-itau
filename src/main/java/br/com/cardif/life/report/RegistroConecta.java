package br.com.cardif.life.report;

import com.poiji.annotation.ExcelCellName;

public class RegistroConecta {
	
	
	@ExcelCellName("Numero Processo")
	private String numeroProcesso;
	@ExcelCellName("Identificacao do Registro")
	private String identificacaoRegistro;
	@ExcelCellName("Tipo de Operação")
	private String tipoOperacao;
	@ExcelCellName("Nome da Campanha")
	private String nomeCampanha;
	@ExcelCellName("Operacao")
	private String operacao;
	@ExcelCellName("Data da Operação")
	private String dataOperacao;
	@ExcelCellName("Nome do Cliente")
	private String nomeCliente;
	@ExcelCellName("Numero do CPF")
	private String numeroCPF;
	@ExcelCellName("Data do Nascimento")
	private String dataNascimento;
	@ExcelCellName("Sexo")
	private String sexo;
	@ExcelCellName("Estado Civil")
	private String estadoCivil;
	@ExcelCellName("Numero do Certificado")
	private String numeroCertificado;
	@ExcelCellName("Logradouro")
	private String logradouro;
	@ExcelCellName("Numero do Endereco")
	private String numeroEndereco;
	@ExcelCellName("Complemento")
	private String complemento;
	@ExcelCellName("Bairro")
	private String bairro;
	@ExcelCellName("Cidade")
	private String cidade;
	@ExcelCellName("CEP")
	private String cep;
	@ExcelCellName("UF")
	private String uf;
	@ExcelCellName("DDD Residencial")
	private String dddResidencial;
	@ExcelCellName("Telefone Residencial")
	private String telefoneResidencial;
	@ExcelCellName("DDD Comercial")
	private String dddComercial;
	@ExcelCellName("Nome do Cartao")
	private String nomeCartao;
	@ExcelCellName("Valor do Premio")
	private String valorPremio;
	@ExcelCellName("Tipo de Cobranca")
	private String codigoTipoCobranca;
	@ExcelCellName("Numero do Cartao")
	private String numeroCartao;
	@ExcelCellName("Codigo de Seguranca")
	private String codigoSeguranca;
	@ExcelCellName("Mes Ano Validade")
	private String mesAnoValidade;
	@ExcelCellName("Autorizacao")
	private String autorizacao;
	@ExcelCellName("Terminal")
	private String terminal;
	@ExcelCellName("Documento Autorizacao do Cartao")
	private String documentoAutorizacaoCartao;
	@ExcelCellName("Codigo do Banco")
	private String codigoBanco;
	@ExcelCellName("Dia de Debito")
	private String diaDebito;
	@ExcelCellName("Agencia Debito em Conta")
	private String agenciaDebitoConta;
	@ExcelCellName("Digito Agencia Debito em Conta")
	private String digitoAgenciaDebitoConta;
	@ExcelCellName("Conta para Debito")
	private String contaDebito;
	@ExcelCellName("Digito Conta para Debito")
	private String digitoContaDebito;
	@ExcelCellName("Numero da Parcela")
	private String numeroParcela;
	@ExcelCellName("Operadora")
	private String operadora;
	@ExcelCellName("Nome do Cartao 2")
	private String segundoNomeCartao;
	@ExcelCellName("Valor do premio 2")
	private String segundoValorPremio;
	@ExcelCellName("Tipo de cobranca 2")
	private String segundoTipoCobranca;
	@ExcelCellName("Numero do cartao 2")
	private String segundoNumeroCartao;
	@ExcelCellName("Codigo de seguranca 2")
	private String segundoCodigoSeguranca;
	@ExcelCellName("Mes Ano Validade 2")
	private String segundoMesAnoValidade;
	@ExcelCellName("Autorizacao 2")
	private String segundaAutorizacao;
	@ExcelCellName("Terminal 2")
	private String segundoTerminal;
	@ExcelCellName("Documento Autorizacao do Cartao 2")
	private String segundoDocumentoAutorizacaoCartao;
	@ExcelCellName("Documento")
	private String documento;
	@ExcelCellName("Frequencia de Pagamento")
	private String frequenciaPagamento;
	@ExcelCellName("Inicio da Vigencia")
	private String inicioVigencia;
	@ExcelCellName("Fim da Vigencia")
	private String fimVigencia;
	@ExcelCellName("Nome do Parceiro")
	private String nomeParceiro;
	@ExcelCellName("Codigo do Retorno")
	private String codigoRetorno;
	@ExcelCellName("Numero do convenio")
	private String NumeroConvenio;
	@ExcelCellName("Codigo da Operadora")
	private String codigoOperadora;
	@ExcelCellName("Certificado Complementar")
	private String certificadoComplementar;
	@ExcelCellName("Master Policy")
	private String masterPolicy;
	@ExcelCellName("CNPJ do Titular")
	private String cpnjTitular;
	@ExcelCellName("Numero de Parcelas a serem cobradas")
	private String numeroParcelasCobradas;
	@ExcelCellName("Empresa")
	private String empresa;
	@ExcelCellName("Data da Conciliação")
	private String dataConciliacao;
	@ExcelCellName("Produto Atuarial")
	private String produtoAtuarial;
	@ExcelCellName("Valor primeira  parcela")
	private String valorPrimeiraParcela;
	@ExcelCellName("CPF responsável  financeiro")
	private String cpfResponsavelFinanceiro;
	@ExcelCellName("DDD")
	private String ddd;
	@ExcelCellName("Telefone1")
	private String telefone1;
	@ExcelCellName("DDD2")
	private String segundoDDD;
	@ExcelCellName("Telefone2")
	private String segundoTelefone;
	@ExcelCellName("DDD3")
	private String terceiroDDD;
	@ExcelCellName("Telefone3")
	private String terceiroTelefone;
	@ExcelCellName("Numero do certificado Anterior")
	private String numeroCertificadoAnterior;
	@ExcelCellName("motivo de cancelamento")
	private String motivoCancelamento;
	@ExcelCellName("tipo de convenio")
	private String tipoConvenio;
	@ExcelCellName("tipo de cobrança")
	private String tipoCobranca;
	@ExcelCellName("taxa do cartão")
	private String taxaCartao;
	@ExcelCellName("codigo de operacao")
	private String codigoOperacao;
	@ExcelCellName("Adquirente")
	private String adquirente;
	
	public String getIdentificacaoRegistro() {
		return identificacaoRegistro;
	}
	public void setIdentificacaoRegistro(String identificacaoRegistro) {
		this.identificacaoRegistro = identificacaoRegistro;
	}
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public String getNomeCampanha() {
		return nomeCampanha;
	}
	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public String getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(String dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNumeroCPF() {
		return numeroCPF;
	}
	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
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
	public String getNumeroCertificado() {
		return numeroCertificado;
	}
	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumeroEndereco() {
		return numeroEndereco;
	}
	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getDddComercial() {
		return dddComercial;
	}
	public void setDddComercial(String dddComercial) {
		this.dddComercial = dddComercial;
	}
	public String getNomeCartao() {
		return nomeCartao;
	}
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	public String getValorPremio() {
		return valorPremio;
	}
	public void setValorPremio(String valorPremio) {
		this.valorPremio = valorPremio;
	}
	public String getCodigoTipoCobranca() {
		return codigoTipoCobranca;
	}
	public void setCodigoTipoCobranca(String codigoTipoCobranca) {
		this.codigoTipoCobranca = codigoTipoCobranca;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public String getMesAnoValidade() {
		return mesAnoValidade;
	}
	public void setMesAnoValidade(String mesAnoValidade) {
		this.mesAnoValidade = mesAnoValidade;
	}
	public String getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getDocumentoAutorizacaoCartao() {
		return documentoAutorizacaoCartao;
	}
	public void setDocumentoAutorizacaoCartao(String documentoAutorizacaoCartao) {
		this.documentoAutorizacaoCartao = documentoAutorizacaoCartao;
	}
	public String getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public String getDiaDebito() {
		return diaDebito;
	}
	public void setDiaDebito(String diaDebito) {
		this.diaDebito = diaDebito;
	}
	public String getAgenciaDebitoConta() {
		return agenciaDebitoConta;
	}
	public void setAgenciaDebitoConta(String agenciaDebitoConta) {
		this.agenciaDebitoConta = agenciaDebitoConta;
	}
	public String getDigitoAgenciaDebitoConta() {
		return digitoAgenciaDebitoConta;
	}
	public void setDigitoAgenciaDebitoConta(String digitoAgenciaDebitoConta) {
		this.digitoAgenciaDebitoConta = digitoAgenciaDebitoConta;
	}
	public String getContaDebito() {
		return contaDebito;
	}
	public void setContaDebito(String contaDebito) {
		this.contaDebito = contaDebito;
	}
	public String getDigitoContaDebito() {
		return digitoContaDebito;
	}
	public void setDigitoContaDebito(String digitoContaDebito) {
		this.digitoContaDebito = digitoContaDebito;
	}
	public String getNumeroParcela() {
		return numeroParcela;
	}
	public void setNumeroParcela(String numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public String getSegundoNomeCartao() {
		return segundoNomeCartao;
	}
	public void setSegundoNomeCartao(String segundoNomeCartao) {
		this.segundoNomeCartao = segundoNomeCartao;
	}
	public String getSegundoValorPremio() {
		return segundoValorPremio;
	}
	public void setSegundoValorPremio(String segundoValorPremio) {
		this.segundoValorPremio = segundoValorPremio;
	}
	public String getSegundoTipoCobranca() {
		return segundoTipoCobranca;
	}
	public void setSegundoTipoCobranca(String segundoTipoCobranca) {
		this.segundoTipoCobranca = segundoTipoCobranca;
	}
	public String getSegundoNumeroCartao() {
		return segundoNumeroCartao;
	}
	public void setSegundoNumeroCartao(String segundoNumeroCartao) {
		this.segundoNumeroCartao = segundoNumeroCartao;
	}
	public String getSegundoCodigoSeguranca() {
		return segundoCodigoSeguranca;
	}
	public void setSegundoCodigoSeguranca(String segundoCodigoSeguranca) {
		this.segundoCodigoSeguranca = segundoCodigoSeguranca;
	}
	public String getSegundoMesAnoValidade() {
		return segundoMesAnoValidade;
	}
	public void setSegundoMesAnoValidade(String segundoMesAnoValidade) {
		this.segundoMesAnoValidade = segundoMesAnoValidade;
	}
	public String getSegundaAutorizacao() {
		return segundaAutorizacao;
	}
	public void setSegundaAutorizacao(String segundaAutorizacao) {
		this.segundaAutorizacao = segundaAutorizacao;
	}
	public String getSegundoTerminal() {
		return segundoTerminal;
	}
	public void setSegundoTerminal(String segundoTerminal) {
		this.segundoTerminal = segundoTerminal;
	}
	public String getSegundoDocumentoAutorizacaoCartao() {
		return segundoDocumentoAutorizacaoCartao;
	}
	public void setSegundoDocumentoAutorizacaoCartao(String segundoDocumentoAutorizacaoCartao) {
		this.segundoDocumentoAutorizacaoCartao = segundoDocumentoAutorizacaoCartao;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getFrequenciaPagamento() {
		return frequenciaPagamento;
	}
	public void setFrequenciaPagamento(String frequenciaPagamento) {
		this.frequenciaPagamento = frequenciaPagamento;
	}
	public String getInicioVigencia() {
		return inicioVigencia;
	}
	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}
	public String getFimVigencia() {
		return fimVigencia;
	}
	public void setFimVigencia(String fimVigencia) {
		this.fimVigencia = fimVigencia;
	}
	public String getNomeParceiro() {
		return nomeParceiro;
	}
	public void setNomeParceiro(String nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}
	public String getCodigoRetorno() {
		return codigoRetorno;
	}
	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}
	public String getNumeroConvenio() {
		return NumeroConvenio;
	}
	public void setNumeroConvenio(String numeroConvenio) {
		NumeroConvenio = numeroConvenio;
	}
	public String getCodigoOperadora() {
		return codigoOperadora;
	}
	public void setCodigoOperadora(String codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}
	public String getCertificadoComplementar() {
		return certificadoComplementar;
	}
	public void setCertificadoComplementar(String certificadoComplementar) {
		this.certificadoComplementar = certificadoComplementar;
	}
	public String getMasterPolicy() {
		return masterPolicy;
	}
	public void setMasterPolicy(String masterPolicy) {
		this.masterPolicy = masterPolicy;
	}
	public String getCpnjTitular() {
		return cpnjTitular;
	}
	public void setCpnjTitular(String cpnjTitular) {
		this.cpnjTitular = cpnjTitular;
	}
	public String getNumeroParcelasCobradas() {
		return numeroParcelasCobradas;
	}
	public void setNumeroParcelasCobradas(String numeroParcelasCobradas) {
		this.numeroParcelasCobradas = numeroParcelasCobradas;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getDataConciliacao() {
		return dataConciliacao;
	}
	public void setDataConciliacao(String dataConciliacao) {
		this.dataConciliacao = dataConciliacao;
	}
	public String getProdutoAtuarial() {
		return produtoAtuarial;
	}
	public void setProdutoAtuarial(String produtoAtuarial) {
		this.produtoAtuarial = produtoAtuarial;
	}
	public String getValorPrimeiraParcela() {
		return valorPrimeiraParcela;
	}
	public void setValorPrimeiraParcela(String valorPrimeiraParcela) {
		this.valorPrimeiraParcela = valorPrimeiraParcela;
	}
	public String getCpfResponsavelFinanceiro() {
		return cpfResponsavelFinanceiro;
	}
	public void setCpfResponsavelFinanceiro(String cpfResponsavelFinanceiro) {
		this.cpfResponsavelFinanceiro = cpfResponsavelFinanceiro;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getSegundoDDD() {
		return segundoDDD;
	}
	public void setSegundoDDD(String segundoDDD) {
		this.segundoDDD = segundoDDD;
	}
	public String getSegundoTelefone() {
		return segundoTelefone;
	}
	public void setSegundoTelefone(String segundoTelefone) {
		this.segundoTelefone = segundoTelefone;
	}
	public String getTerceiroDDD() {
		return terceiroDDD;
	}
	public void setTerceiroDDD(String terceiroDDD) {
		this.terceiroDDD = terceiroDDD;
	}
	public String getTerceiroTelefone() {
		return terceiroTelefone;
	}
	public void setTerceiroTelefone(String terceiroTelefone) {
		this.terceiroTelefone = terceiroTelefone;
	}
	public String getNumeroCertificadoAnterior() {
		return numeroCertificadoAnterior;
	}
	public void setNumeroCertificadoAnterior(String numeroCertificadoAnterior) {
		this.numeroCertificadoAnterior = numeroCertificadoAnterior;
	}
	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}
	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}
	public String getTipoConvenio() {
		return tipoConvenio;
	}
	public void setTipoConvenio(String tipoConvenio) {
		this.tipoConvenio = tipoConvenio;
	}
	public String getTipoCobranca() {
		return tipoCobranca;
	}
	public void setTipoCobranca(String tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}
	public String getTaxaCartao() {
		return taxaCartao;
	}
	public void setTaxaCartao(String taxaCartao) {
		this.taxaCartao = taxaCartao;
	}
	public String getCodigoOperacao() {
		return codigoOperacao;
	}
	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}
	public String getAdquirente() {
		return adquirente;
	}
	public void setAdquirente(String adquirente) {
		this.adquirente = adquirente;
	}
	public String getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

}
