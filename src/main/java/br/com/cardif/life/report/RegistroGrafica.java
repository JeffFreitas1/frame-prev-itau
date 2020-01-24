package br.com.cardif.life.report;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import com.poiji.annotation.ExcelCellName;
import com.poiji.bind.Poiji;

public class RegistroGrafica {

	@ExcelCellName("Identificação da seção")
	private String ID;
	@ExcelCellName("Tipo de Impressão")
	private String tipoImpressao;
	@ExcelCellName("Apólice")
	private String apolice;
	@ExcelCellName("Boneco")
	private String boneco;
	@ExcelCellName("Nome")
	private String nome;
	@ExcelCellName("CPF/ CNPJ")
	private String cpfCnpj;
	@ExcelCellName("Data de Nascimento")
	private String dtNacimento;
	@ExcelCellName("Sexo")
	private String sexo;
	@ExcelCellName("Endereço")
	private String endereco;
	@ExcelCellName("Complemento")
	private String complemento;
	@ExcelCellName("Bairro")
	private String bairro;
	@ExcelCellName("Cidade")
	private String cidade;
	@ExcelCellName("Estado")
	private String estado;
	@ExcelCellName("CEP")
	private String cep;
	@ExcelCellName("E-mail")
	private String email;
	@ExcelCellName("Contrato")
	private String contrato;
	@ExcelCellName("Certificado")
	private String certificado;
	@ExcelCellName("Numero Certificado Acsele")
	private String numeroCertificadoAcsele;
	@ExcelCellName("Data Adesão")
	private String dtAdesao;
	@ExcelCellName("Vigência início")
	private String vigenciaInicio;
	@ExcelCellName("Vigência Fim")
	private String vingenciaFim;
	@ExcelCellName("Prêmio Periodicidade")
	private String premioPeriodicidade;
	@ExcelCellName("Prêmio Mensal")
	private String premioMensal;
	@ExcelCellName("Prêmio Total")
	private String premioTotal;
	@ExcelCellName("IOF")
	private String iof;
	@ExcelCellName("Plano/Cobertura Contratada")
	private String planoCoberturaContratada;
	@ExcelCellName("Prêmio Cobertura 1")
	private Double premioCobertura1;
	@ExcelCellName("LMI Cobertura 1")
	private String lmiCobertura1;
	@ExcelCellName("Prêmio Cobertura 2")
	private Double premioCobertura2;
	@ExcelCellName("LMI Cobertura 2")
	private String lmiCobertura2;
	@ExcelCellName("Prêmio Cobertura 3")
	private Double premioCobertura3;
	@ExcelCellName("LMI Cobertura 3")
	private String lmiCobertura3;
	@ExcelCellName("Prêmio Cobertura 4")
	private Double premioCobertura4;
	@ExcelCellName("LMI Cobertura 4")
	private String lmiCobertura4;
	@ExcelCellName("Prêmio Cobertura 5")
	private Double premioCobertura5;
	@ExcelCellName("LMI Cobertura 5")
	private String lmiCobertura5;
	@ExcelCellName("Prêmio Cobertura 6")
	private Double premioCobertura6;
	@ExcelCellName("LMI Cobertura 6")
	private String lmiCobertura6;
	@ExcelCellName("Prêmio Cobertura 7")
	private Double premioCobertura7;
	@ExcelCellName("LMI Cobertura 7")
	private String lmiCobertura7;
	@ExcelCellName("Prêmio Cobertura 8")
	private String premioCobertura8;
	@ExcelCellName("LMI Cobertura 8")
	private String lmiCobertura8;
	@ExcelCellName("Prêmio Cobertura 9")
	private String premioCobertura9;
	@ExcelCellName("LMI Cobertura 9")
	private String lmiCobertura9;
	@ExcelCellName("Prêmio Cobertura 10")
	private String premioCobertura10;
	@ExcelCellName("LMI Cobertura 10")
	private String lmiCobertura10;
	@ExcelCellName("LMI Cobertura Percentual 1")
	private String lmiCoberturaPercentual1;
	@ExcelCellName("LMI Cobertura Percentual 2")
	private String lmiCoberturaPercentual2;
	@ExcelCellName("LMI Parcelas 1")
	private String lmiParcelas1;
	@ExcelCellName("LMI Parcelas 2")
	private String lmiParcelas2;
	@ExcelCellName("LMI Parcelas 3")
	private String lmiParcelas3;
	@ExcelCellName("LMI Parcelas 4")
	private String lmiParcelas4;
	@ExcelCellName("LMI Parcelas 5")
	private String lmiParcelas5;
	@ExcelCellName("Beneficiário 1")
	private String Beneficiario1;
	@ExcelCellName("Beneficiário % Participação 1")
	private String BeneficiarioParticipacao1;
	@ExcelCellName("Beneficiário  Data Nascimento 1")
	private String BeneficiarioDtNacimento1;
	@ExcelCellName("Beneficiário Grau Parentesco 1")
	private String BeneficiarioGrauParentesco1;
	@ExcelCellName("Beneficiário 2")
	private String Beneficiario2;
	@ExcelCellName("Beneficiário % Participação 2")
	private String BeneficiarioParticipacao2;
	@ExcelCellName("Beneficiário  Data Nascimento 2")
	private String BeneficiarioDtNacimento2;
	@ExcelCellName("Beneficiário Grau Parentesco 2")
	private String BeneficiarioGrauParentesco2;
	@ExcelCellName("Beneficiário 3")
	private String Beneficiario3;
	@ExcelCellName("Beneficiário % Participação 3")
	private String BeneficiarioParticipacao3;
	@ExcelCellName("Beneficiário  Data Nascimento 3")
	private String BeneficiarioDtNacimento3;
	@ExcelCellName("Beneficiário Grau Parentesco 3")
	private String BeneficiarioGrauParentesco3;
	@ExcelCellName("Beneficiário 4")
	private String Beneficiario4;
	@ExcelCellName("Beneficiário % Participação 4")
	private String BeneficiarioParticipacao4;
	@ExcelCellName("Beneficiário  Data Nascimento 4")
	private String BeneficiarioDtNacimento4;
	@ExcelCellName("Beneficiário Grau Parentesco 4")
	private String BeneficiarioGrauParentesco4;
	@ExcelCellName("Beneficiário 5")
	private String Beneficiario5;
	@ExcelCellName("Beneficiário % Participação 5")
	private String BeneficiarioParticipacao5;
	@ExcelCellName("Beneficiário  Data Nascimento 5")
	private String BeneficiarioDtNacimento5;
	@ExcelCellName("Beneficiário Grau Parentesco 5")
	private String BeneficiarioGrauParentesco5;
	@ExcelCellName("Apólice Variável")
	private String apoliceVariavel;
	@ExcelCellName("Cap Periodicidade")
	private String capPeriodicidade;
	@ExcelCellName("Cap Vigência")
	private String capVigencia;
	@ExcelCellName("Cap Valor Bruto")
	private String capValorBruto;
	@ExcelCellName("Cap IR")
	private String ir;
	@ExcelCellName("Cap Valor Líquido")
	private String capValorLiquido;
	@ExcelCellName("Cap Número da Sorte")
	private String capNumeroDaSorte;
	@ExcelCellName("Assistência Plano")
	private String assistenciaPlano;
	@ExcelCellName("Marca")
	private String marca;
	@ExcelCellName("Modelo")
	private String modelo;
	@ExcelCellName("Ano/Modelo")
	private String anoModelo;
	@ExcelCellName("Veículo 0km")
	private String veiculo0Km;
	@ExcelCellName("Chassi")
	private String chassi;
	@ExcelCellName("Placa")
	private String placa;
	@ExcelCellName("Renavan")
	private String renavan;
	@ExcelCellName("Cor")
	private String cor;
	@ExcelCellName("Combustível")
	private String combustivel;
	@ExcelCellName("Código Referencia")
	private String codigoRefencia;
	@ExcelCellName("Região Circulação")
	private String regiaoCirculacao;
	@ExcelCellName("Nº Cartão")
	private String nCartao;
	@ExcelCellName("Valor Financiado")
	private String valorFinanciado;
	@ExcelCellName("Código Produto")
	private String codigoProduto;
	@ExcelCellName("Marca Produto")
	private String marcaProduto;
	@ExcelCellName("Modelo Produto")
	private String modeloProduto;
	@ExcelCellName("Descrição Produto")
	private String descicaoProduto;
	@ExcelCellName("Nº de Série ou Hexa")
	private String nDeSerieOuHexa;
	@ExcelCellName("Quantidade Produto")
	private String quantidadeProduto;
	@ExcelCellName("Garantia Fabricante Inicio")
	private String garantiaFabricanteInicio;
	@ExcelCellName("Garantia Fabricante Fim")
	private String garantiaFabricanteFim;
	@ExcelCellName("Vigência Garantia Fabricante")
	private String vigenciaGarantiaFabricante;
	@ExcelCellName("Endereço de Risco")
	private String enderecoDeRisco;
	@ExcelCellName("Complemento Risco")
	private String complementoRisco;
	@ExcelCellName("Bairro Risco")
	private String bairroRisco;
	@ExcelCellName("Cidade Risco")
	private String cidadeRisco;
	@ExcelCellName("Estado Risco")
	private String estadoRisco;
	@ExcelCellName("CEP Risco")
	private String cepRisco;
	@ExcelCellName("Estipulante")
	private String estipulante;
	@ExcelCellName("CNPJ Estipulante")
	private String cnpjEstipulante;
	@ExcelCellName("Pro-Labore %")
	private String proLabore;
	@ExcelCellName("Pro-Labore R$")
	private String proLaboreRS;
	@ExcelCellName("Subestipulante 1")
	private String subestipulante1;
	@ExcelCellName("CNPJ Subestipulante 1")
	private String cpnjSubestipulante1;
	@ExcelCellName("Pro-Labore %")
	private String proLabore2;
	@ExcelCellName("Pro-Labore R$")
	private String proLaboreRS2;
	@ExcelCellName("Subestipulante 2")
	private String subestipulante2;
	@ExcelCellName("CNPJ Subestipulante 2")
	private String cnpjsubestipulante2;
	@ExcelCellName("Pro-Labore %")
	private String proLabore3;
	@ExcelCellName("Pro-Labore R$")
	private String proLaboreRS3;
	@ExcelCellName("Cosseguradora")
	private String cosseguradora;
	@ExcelCellName("CNPJ")
	private String cnpj;
	@ExcelCellName("Participação % Seguradora")
	private String participacaoSeguradora;
	@ExcelCellName("Participação % Cosseguradora")
	private String participacaoCosseguradora;
	@ExcelCellName("Corretor")
	private String corretor;
	@ExcelCellName("CPF/CNPJ Corretor")
	private String cpfCnpjCorretor;
	@ExcelCellName("Registro SUSEP Corretor")
	private String registroSusepCorretor;
	@ExcelCellName("Endereço Corretor")
	private String enderecoCorretor;
	@ExcelCellName("Complemento Corretor")
	private String complementoCorretor;
	@ExcelCellName("Bairro Corretor")
	private String bairroCorretor;
	@ExcelCellName("Cidade Corretor")
	private String cidadeCorretor;
	@ExcelCellName("Estado Corretor")
	private String estadoCorretor;
	@ExcelCellName("CEP Corretor")
	private String cepCorretor;
	@ExcelCellName("DDD Corretor")
	private String dddCorretor;
	@ExcelCellName("Telefone Corretor")
	private String telefoneCorretor;
	@ExcelCellName("E-mail Complementar")
	private String emailComplementar;
	@ExcelCellName("Nacionalidade")
	private String nacionalidade;
	@ExcelCellName("Prêmio Liquido Mensal")
	private String premioLiquidoMensal;
	@ExcelCellName("Prêmio Liquido Total")
	private String premioLiquidoTotal;
	@ExcelCellName("Endereço Estipulante")
	private String enderecoEstipulante;
	@ExcelCellName("Complemento Estipulante")
	private String complementoEstipulante;
	@ExcelCellName("Bairro Estipulante")
	private String bairroEstipulante;
	@ExcelCellName("Cidade Estipulante")
	private String cidadeEstipulante;
	@ExcelCellName("Estado Estipulante")
	private String estadoEstipulante;
	@ExcelCellName("CEP Estipulante")
	private String cepEstipulante;
	@ExcelCellName("DDD Telefone Estipulante")
	private String dddTelefoneEstipulante;
	@ExcelCellName("Telefone Estipulante")
	private String telefoneEstipulante;
	@ExcelCellName("Endereço Subestipulante 1")
	private String enderecoSubestipulante1;
	@ExcelCellName("Complemento Subestipulante 1")
	private String complementoSubestipulante1;
	@ExcelCellName("Bairro Subestipulante 1")
	private String bairroSubestipulante1;
	@ExcelCellName("Cidade Subestipulante 1")
	private String cidadeSubestipulante1;
	@ExcelCellName("Estado Subestipulante 1")
	private String estadoSubestipulante1;
	@ExcelCellName("CEP Subestipulante 1")
	private String cepSubestipulante1;
	@ExcelCellName("DDD Subestipulante 1")
	private String dddSubestipulante1;
	@ExcelCellName("Telefone Subestipulante 1")
	private String telefoneSubestipulante1;
	@ExcelCellName("Endereço Subestipulante 2")
	private String enderecoSubestipulante2;
	@ExcelCellName("Complemento Subestipulante 2")
	private String complementoSubestipulante2;
	@ExcelCellName("Bairro Subestipulante 2")
	private String bairroSubestipulante2;
	@ExcelCellName("Cidade Subestipulante 2")
	private String cidadeSubestipulante2;
	@ExcelCellName("Estado Subestipulante 2")
	private String estadoSubestipulante2;
	@ExcelCellName("CEP Subestipulante 2")
	private String cepSubestipulante2;
	@ExcelCellName("DDD Subestipulante 2")
	private String dddSubestipulante2;
	@ExcelCellName("Telefone Subestipulante 2")
	private String telefoneSubestipulante2;
	@ExcelCellName("E-mail Corretor")
	private String emailCorretor;
	@ExcelCellName("Co-Corretor 1")
	private String coCorretor1;
	@ExcelCellName("CPF/CNPJ Co-Corretor 1")
	private String cpfCnpjCoCorretor1;
	@ExcelCellName("Registro SUSEP Co-Corretor 1")
	private String registroSusepCoCorretor1;
	@ExcelCellName("Endereço Co-Corretor 1")
	private String enderecoCoCorretor1;
	@ExcelCellName("Complemento Co-Corretor 1")
	private String complementoCoCorretor1;
	@ExcelCellName("Bairro Co-Corretor 1")
	private String bairroCoCorretor1;
	@ExcelCellName("Cidade Co-Corretor 1")
	private String cidadeCoCorretor1;
	@ExcelCellName("Estado Co-Corretor 1")
	private String estadoCoCorretor1;
	@ExcelCellName("CEP Co-Corretor 1")
	private String cepCoCorretor1;
	@ExcelCellName("DDD Co-Corretor 1")
	private String dddCoCorretor1;
	@ExcelCellName("Telefone Co-Corretor 1")
	private String telefoneCoCorretor1;
	@ExcelCellName("E-mail Co-Corretork 1")
	private String emailCoCorretor1;
	@ExcelCellName("Co-Corretor 2")
	private String coCorretor2;
	@ExcelCellName("CPF/CNPJ Co-Corretor 2")
	private String cpfCnpjCoCorretor2;
	@ExcelCellName("Registro SUSEP Co-Corretor 2")
	private String registroSusepCoCorretor2;
	@ExcelCellName("Endereço do Co-Corretor 2")
	private String enderecoDoCoCorretor2;
	@ExcelCellName("Complemento Co-Corretor 2")
	private String complementoCoCorretor2;
	@ExcelCellName("Bairro Co-Corretor 2")
	private String bairroCoCorretor2;
	@ExcelCellName("Cidade Co-Corretor 2")
	private String cidadeCoCorretor2;
	@ExcelCellName("Estado Co-Corretor 2")
	private String estadoCoCorretor2;
	@ExcelCellName("CEP Co-Corretor 2")
	private String cepCoCorretor2;
	@ExcelCellName("DDD Co-Corretor 2")
	private String dddCoCorretor2;
	@ExcelCellName("Telefone Co-Corretor 2")
	private String telefoneCoCorretor2;
	@ExcelCellName("E-mail Co-Corretor 2")
	private String emailCoCorretor2;
	@ExcelCellName("Co-Corretor 3")
	private String coCorretor3;
	@ExcelCellName("CPF/CNPJ Co-Corretor 3")
	private String cpfCnpjCoCorretor;
	@ExcelCellName("Registro SUSEP Co-Corretor 3")
	private String registroSusepCoCorretor3;
	@ExcelCellName("Endereço Co-Corretor 3")
	private String enderecoCoCorretor3;
	@ExcelCellName("Complemento Co-Corretor 3")
	private String complementoCoCorretor3;
	@ExcelCellName("Bairro Co-Corretor 3")
	private String bairroCoCorretor3;
	@ExcelCellName("Cidade Co-Corretor 3")
	private String cidadeCoCorretor3;
	@ExcelCellName("Estado Co-Corretor 3")
	private String estadoCoCorretor3;
	@ExcelCellName("CEP Co-Corretor 3")
	private String cepCoCorretor3;
	@ExcelCellName("DDD Co-Corretor 3")
	private String dddCoCorretor3;
	@ExcelCellName("Telefone Co-Corretor 3")
	private String telefoneCoCorretor3;
	@ExcelCellName("E-mail Co-Corretor 3")
	private String emailCoCorretor3;
	@ExcelCellName("Cap Modalidade")
	private String capModalidade;
	@ExcelCellName("Processo Susep 1")
	private String processoSusep1;
	@ExcelCellName("Processo Susep 2")
	private String processoSusep2;
	@ExcelCellName("Garantido 1")
	private String garantido1;
	@ExcelCellName("CPF/ CNPJ Garantido 1")
	private String cpfCnpjGarantido1;
	@ExcelCellName("Garantido 2")
	private String garantido2;
	@ExcelCellName("CPF/ CNPJ Garantido 2")
	private String cpfCnpjGarantido2;
	@ExcelCellName("Locatário Solidário 1")
	private String locatarioSolidario;
	@ExcelCellName("CPF/ CNPJ Locatário Solidário 1")
	private String cpfCnpjLocatarioSolidario1;
	@ExcelCellName("Locatário Solidário 2")
	private String locatarioSolidario2;
	@ExcelCellName("CPF/ CNPJ Locatário Solidário 2")
	private String cpfCnpjLocatarioSolidario2;
	@ExcelCellName("Locatário Solidário 3")
	private String locatarioSolidario3;
	@ExcelCellName("CPF/ CNPJ Locatário Solidário 3")
	private String cpjCnpjLocatarioSolidario3;
	@ExcelCellName("Locatário Solidário 4")
	private String locatarioSolidario4;
	@ExcelCellName("CPF/ CNPJ Locatário Solidário 4")
	private String cpfCnpjLocatarioSolidario4;
	@ExcelCellName("Locatário Solidário 5")
	private String locatarioSolidario5;
	@ExcelCellName("CPF/ CNPJ Locatário Solidário 5")
	private String cpfCnpjLocatarioSolidario5;
	@ExcelCellName("Locatário Solidário 6")
	private String locatarioSolidario6;
	@ExcelCellName("CPF/ CNPJ Locatário Solidário 6")
	private String cpfCnpjLocatarioSolidario6;
	@ExcelCellName("Procurador do Subscritor/ Titular")
	private String ProcuradorDoSubscritoTitular;
	@ExcelCellName("CPF/ CNPJ do Subscritor/ Titular")
	private String cpfCnpjDoSubscritorTitular;
	@ExcelCellName("Representante do Procurador")
	private String representanteDoProcurador;
	@ExcelCellName("CPF/ CNPJ do Subscritor/ Titular")
	private String cpfCnpjDoSuscritorTitular2;
	@ExcelCellName("Campo Texto 1")
	private String campoTexto1;
	@ExcelCellName("Campo Texto 2")
	private String campoTexto2;
	@ExcelCellName("Campo Texto 3")
	private String campoTexto3;
	@ExcelCellName("Campo Número 1")
	private String campoNumero1;
	@ExcelCellName("Campo Número 2")
	private String campoNumero2;
	@ExcelCellName("Campo Número 3")
	private String campoNumero3;
	@ExcelCellName("Código Rejeição")
	private String codigoRejeicao;

	public String LimparName(String name) {
		name = name.replace(" ", "");
		return name;
	}

	public String LimpandoZero(String numero) {
		int x = Integer.parseInt(numero);
		String novoNumero = Integer.toString(x);
		return novoNumero;
	}

	public String LimparData(String data) {
		String newDate = data.substring(6);
		newDate = newDate + data.substring(4, 6);
		newDate = newDate + data.substring(0, 4);
		return newDate;
	}

	public void validar(String campo1, String campo2, String coluna, PrintWriter gravarArq, int linha)
			throws IOException {

		if (campo1.equals(campo2)) {
			System.out.println("Linha  : " + (linha + 2) + "  " + coluna + " Valido->" + " Valor encontrado no site : "
					+ campo1 + " valor recebido do arquivo :  " + campo2);
		} else {
			String log = String.format("Erro na linha : " + (linha + 2) + "  " + coluna + " Invalido->"
					+ " Valor encontrado no site : " + campo1 + " valor recebido do arquivo :  " + campo2);
			gravarArq.println(log);
		}
	}

	public List<RegistroGrafica> registrosGrafica(String sheetPath) {
		return Poiji.fromExcel(new File(sheetPath), RegistroGrafica.class);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTipoImpressao() {
		return tipoImpressao;
	}

	public void setTipoImpressao(String tipoImpressao) {
		this.tipoImpressao = tipoImpressao;
	}

	public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

	public String getBoneco() {
		return boneco;
	}

	public void setBoneco(String boneco) {
		this.boneco = boneco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getDtNacimento() {
		return dtNacimento;
	}

	public void setDtNacimento(String dtNacimento) {
		this.dtNacimento = dtNacimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getNumeroCertificadoAcsele() {
		return numeroCertificadoAcsele;
	}

	public void setNumeroCertificadoAcsele(String numeroCertificadoAcsele) {
		this.numeroCertificadoAcsele = numeroCertificadoAcsele;
	}

	public String getDtAdesao() {
		return dtAdesao;
	}

	public void setDtAdesao(String dtAdesao) {
		this.dtAdesao = dtAdesao;
	}

	public String getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(String vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public String getVingenciaFim() {
		return vingenciaFim;
	}

	public void setVingenciaFim(String vingenciaFim) {
		this.vingenciaFim = vingenciaFim;
	}

	public String getPremioPeriodicidade() {
		return premioPeriodicidade;
	}

	public void setPremioPeriodicidade(String premioPeriodicidade) {
		this.premioPeriodicidade = premioPeriodicidade;
	}

	public String getPremioMensal() {
		return premioMensal;
	}

	public void setPremioMensal(String premioMensal) {
		this.premioMensal = premioMensal;
	}

	public String getPremioTotal() {
		return premioTotal;
	}

	public void setPremioTotal(String premioTotal) {
		this.premioTotal = premioTotal;
	}

	public String getIof() {
		return iof;
	}

	public void setIof(String iof) {
		this.iof = iof;
	}

	public String getPlanoCoberturaContratada() {
		return planoCoberturaContratada;
	}

	public void setPlanoCoberturaContratada(String planoCoberturaContratada) {
		this.planoCoberturaContratada = planoCoberturaContratada;
	}

	public Double getPremioCobertura1() {
		return premioCobertura1;
	}

	public void setPremioCobertura1(Double premioCobertura1) {
		this.premioCobertura1 = premioCobertura1;
	}

	public String getLmiCobertura1() {
		return lmiCobertura1;
	}

	public void setLmiCobertura1(String lmiCobertura1) {
		this.lmiCobertura1 = lmiCobertura1;
	}

	public Double getPremioCobertura2() {
		return premioCobertura2;
	}

	public void setPremioCobertura2(Double premioCobertura2) {
		this.premioCobertura2 = premioCobertura2;
	}

	public String getLmiCobertura2() {
		return lmiCobertura2;
	}

	public void setLmiCobertura2(String lmiCobertura2) {
		this.lmiCobertura2 = lmiCobertura2;
	}

	public Double getPremioCobertura3() {
		return premioCobertura3;
	}

	public void setPremioCobertura3(Double premioCobertura3) {
		this.premioCobertura3 = premioCobertura3;
	}

	public String getLmiCobertura3() {
		return lmiCobertura3;
	}

	public void setLmiCobertura3(String lmiCobertura3) {
		this.lmiCobertura3 = lmiCobertura3;
	}

	public Double getPremioCobertura4() {
		return premioCobertura4;
	}

	public void setPremioCobertura4(Double premioCobertura4) {
		this.premioCobertura4 = premioCobertura4;
	}

	public String getLmiCobertura4() {
		return lmiCobertura4;
	}

	public void setLmiCobertura4(String lmiCobertura4) {
		this.lmiCobertura4 = lmiCobertura4;
	}

	public Double getPremioCobertura5() {
		return premioCobertura5;
	}

	public void setPremioCobertura5(Double premioCobertura5) {
		this.premioCobertura5 = premioCobertura5;
	}

	public String getLmiCobertura5() {
		return lmiCobertura5;
	}

	public void setLmiCobertura5(String lmiCobertura5) {
		this.lmiCobertura5 = lmiCobertura5;
	}

	public Double getPremioCobertura6() {
		return premioCobertura6;
	}

	public void setPremioCobertura6(Double premioCobertura6) {
		this.premioCobertura6 = premioCobertura6;
	}

	public String getLmiCobertura6() {
		return lmiCobertura6;
	}

	public void setLmiCobertura6(String lmiCobertura6) {
		this.lmiCobertura6 = lmiCobertura6;
	}

	public Double getPremioCobertura7() {
		return premioCobertura7;
	}

	public void setPremioCobertura7(Double premioCobertura7) {
		this.premioCobertura7 = premioCobertura7;
	}

	public String getLmiCobertura7() {
		return lmiCobertura7;
	}

	public void setLmiCobertura7(String lmiCobertura7) {
		this.lmiCobertura7 = lmiCobertura7;
	}

	public String getPremioCobertura8() {
		return premioCobertura8;
	}

	public void setPremioCobertura8(String premioCobertura8) {
		this.premioCobertura8 = premioCobertura8;
	}

	public String getLmiCobertura8() {
		return lmiCobertura8;
	}

	public void setLmiCobertura8(String lmiCobertura8) {
		this.lmiCobertura8 = lmiCobertura8;
	}

	public String getPremioCobertura9() {
		return premioCobertura9;
	}

	public void setPremioCobertura9(String premioCobertura9) {
		this.premioCobertura9 = premioCobertura9;
	}

	public String getLmiCobertura9() {
		return lmiCobertura9;
	}

	public void setLmiCobertura9(String lmiCobertura9) {
		this.lmiCobertura9 = lmiCobertura9;
	}

	public String getPremioCobertura10() {
		return premioCobertura10;
	}

	public void setPremioCobertura10(String premioCobertura10) {
		this.premioCobertura10 = premioCobertura10;
	}

	public String getLmiCobertura10() {
		return lmiCobertura10;
	}

	public void setLmiCobertura10(String lmiCobertura10) {
		this.lmiCobertura10 = lmiCobertura10;
	}

	public String getLmiCoberturaPercentual1() {
		return lmiCoberturaPercentual1;
	}

	public void setLmiCoberturaPercentual1(String lmiCoberturaPercentual1) {
		this.lmiCoberturaPercentual1 = lmiCoberturaPercentual1;
	}

	public String getLmiCoberturaPercentual2() {
		return lmiCoberturaPercentual2;
	}

	public void setLmiCoberturaPercentual2(String lmiCoberturaPercentual2) {
		this.lmiCoberturaPercentual2 = lmiCoberturaPercentual2;
	}

	public String getLmiParcelas1() {
		return lmiParcelas1;
	}

	public void setLmiParcelas1(String lmiParcelas1) {
		this.lmiParcelas1 = lmiParcelas1;
	}

	public String getLmiParcelas2() {
		return lmiParcelas2;
	}

	public void setLmiParcelas2(String lmiParcelas2) {
		this.lmiParcelas2 = lmiParcelas2;
	}

	public String getLmiParcelas3() {
		return lmiParcelas3;
	}

	public void setLmiParcelas3(String lmiParcelas3) {
		this.lmiParcelas3 = lmiParcelas3;
	}

	public String getLmiParcelas4() {
		return lmiParcelas4;
	}

	public void setLmiParcelas4(String lmiParcelas4) {
		this.lmiParcelas4 = lmiParcelas4;
	}

	public String getLmiParcelas5() {
		return lmiParcelas5;
	}

	public void setLmiParcelas5(String lmiParcelas5) {
		this.lmiParcelas5 = lmiParcelas5;
	}

	public String getBeneficiario1() {
		return Beneficiario1;
	}

	public void setBeneficiario1(String beneficiario1) {
		Beneficiario1 = beneficiario1;
	}

	public String getBeneficiarioParticipacao1() {
		return BeneficiarioParticipacao1;
	}

	public void setBeneficiarioParticipacao1(String beneficiarioParticipacao1) {
		BeneficiarioParticipacao1 = beneficiarioParticipacao1;
	}

	public String getBeneficiarioDtNacimento1() {
		return BeneficiarioDtNacimento1;
	}

	public void setBeneficiarioDtNacimento1(String beneficiarioDtNacimento1) {
		BeneficiarioDtNacimento1 = beneficiarioDtNacimento1;
	}

	public String getBeneficiarioGrauParentesco1() {
		return BeneficiarioGrauParentesco1;
	}

	public void setBeneficiarioGrauParentesco1(String beneficiarioGrauParentesco1) {
		BeneficiarioGrauParentesco1 = beneficiarioGrauParentesco1;
	}

	public String getBeneficiario2() {
		return Beneficiario2;
	}

	public void setBeneficiario2(String beneficiario2) {
		Beneficiario2 = beneficiario2;
	}

	public String getBeneficiarioParticipacao2() {
		return BeneficiarioParticipacao2;
	}

	public void setBeneficiarioParticipacao2(String beneficiarioParticipacao2) {
		BeneficiarioParticipacao2 = beneficiarioParticipacao2;
	}

	public String getBeneficiarioDtNacimento2() {
		return BeneficiarioDtNacimento2;
	}

	public void setBeneficiarioDtNacimento2(String beneficiarioDtNacimento2) {
		BeneficiarioDtNacimento2 = beneficiarioDtNacimento2;
	}

	public String getBeneficiarioGrauParentesco2() {
		return BeneficiarioGrauParentesco2;
	}

	public void setBeneficiarioGrauParentesco2(String beneficiarioGrauParentesco2) {
		BeneficiarioGrauParentesco2 = beneficiarioGrauParentesco2;
	}

	public String getBeneficiario3() {
		return Beneficiario3;
	}

	public void setBeneficiario3(String beneficiario3) {
		Beneficiario3 = beneficiario3;
	}

	public String getBeneficiarioParticipacao3() {
		return BeneficiarioParticipacao3;
	}

	public void setBeneficiarioParticipacao3(String beneficiarioParticipacao3) {
		BeneficiarioParticipacao3 = beneficiarioParticipacao3;
	}

	public String getBeneficiarioDtNacimento3() {
		return BeneficiarioDtNacimento3;
	}

	public void setBeneficiarioDtNacimento3(String beneficiarioDtNacimento3) {
		BeneficiarioDtNacimento3 = beneficiarioDtNacimento3;
	}

	public String getBeneficiarioGrauParentesco3() {
		return BeneficiarioGrauParentesco3;
	}

	public void setBeneficiarioGrauParentesco3(String beneficiarioGrauParentesco3) {
		BeneficiarioGrauParentesco3 = beneficiarioGrauParentesco3;
	}

	public String getBeneficiario4() {
		return Beneficiario4;
	}

	public void setBeneficiario4(String beneficiario4) {
		Beneficiario4 = beneficiario4;
	}

	public String getBeneficiarioParticipacao4() {
		return BeneficiarioParticipacao4;
	}

	public void setBeneficiarioParticipacao4(String beneficiarioParticipacao4) {
		BeneficiarioParticipacao4 = beneficiarioParticipacao4;
	}

	public String getBeneficiarioDtNacimento4() {
		return BeneficiarioDtNacimento4;
	}

	public void setBeneficiarioDtNacimento4(String beneficiarioDtNacimento4) {
		BeneficiarioDtNacimento4 = beneficiarioDtNacimento4;
	}

	public String getBeneficiarioGrauParentesco4() {
		return BeneficiarioGrauParentesco4;
	}

	public void setBeneficiarioGrauParentesco4(String beneficiarioGrauParentesco4) {
		BeneficiarioGrauParentesco4 = beneficiarioGrauParentesco4;
	}

	public String getBeneficiario5() {
		return Beneficiario5;
	}

	public void setBeneficiario5(String beneficiario5) {
		Beneficiario5 = beneficiario5;
	}

	public String getBeneficiarioParticipacao5() {
		return BeneficiarioParticipacao5;
	}

	public void setBeneficiarioParticipacao5(String beneficiarioParticipacao5) {
		BeneficiarioParticipacao5 = beneficiarioParticipacao5;
	}

	public String getBeneficiarioDtNacimento5() {
		return BeneficiarioDtNacimento5;
	}

	public void setBeneficiarioDtNacimento5(String beneficiarioDtNacimento5) {
		BeneficiarioDtNacimento5 = beneficiarioDtNacimento5;
	}

	public String getBeneficiarioGrauParentesco5() {
		return BeneficiarioGrauParentesco5;
	}

	public void setBeneficiarioGrauParentesco5(String beneficiarioGrauParentesco5) {
		BeneficiarioGrauParentesco5 = beneficiarioGrauParentesco5;
	}

	public String getApoliceVariavel() {
		return apoliceVariavel;
	}

	public void setApoliceVariavel(String apoliceVariavel) {
		this.apoliceVariavel = apoliceVariavel;
	}

	public String getCapPeriodicidade() {
		return capPeriodicidade;
	}

	public void setCapPeriodicidade(String capPeriodicidade) {
		this.capPeriodicidade = capPeriodicidade;
	}

	public String getCapVigencia() {
		return capVigencia;
	}

	public void setCapVigencia(String capVigencia) {
		this.capVigencia = capVigencia;
	}

	public String getCapValorBruto() {
		return capValorBruto;
	}

	public void setCapValorBruto(String capValorBruto) {
		this.capValorBruto = capValorBruto;
	}

	public String getIr() {
		return ir;
	}

	public void setIr(String ir) {
		this.ir = ir;
	}

	public String getCapValorLiquido() {
		return capValorLiquido;
	}

	public void setCapValorLiquido(String capValorLiquido) {
		this.capValorLiquido = capValorLiquido;
	}

	public String getCapNumeroDaSorte() {
		return capNumeroDaSorte;
	}

	public void setCapNumeroDaSorte(String capNumeroDaSorte) {
		this.capNumeroDaSorte = capNumeroDaSorte;
	}

	public String getAssistenciaPlano() {
		return assistenciaPlano;
	}

	public void setAssistenciaPlano(String assistenciaPlano) {
		this.assistenciaPlano = assistenciaPlano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getVeiculo0Km() {
		return veiculo0Km;
	}

	public void setVeiculo0Km(String veiculo0Km) {
		this.veiculo0Km = veiculo0Km;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCodigoRefencia() {
		return codigoRefencia;
	}

	public void setCodigoRefencia(String codigoRefencia) {
		this.codigoRefencia = codigoRefencia;
	}

	public String getRegiaoCirculacao() {
		return regiaoCirculacao;
	}

	public void setRegiaoCirculacao(String regiaoCirculacao) {
		this.regiaoCirculacao = regiaoCirculacao;
	}

	public String getnCartao() {
		return nCartao;
	}

	public void setnCartao(String nCartao) {
		this.nCartao = nCartao;
	}

	public String getValorFinanciado() {
		return valorFinanciado;
	}

	public void setValorFinanciado(String valorFinanciado) {
		this.valorFinanciado = valorFinanciado;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getModeloProduto() {
		return modeloProduto;
	}

	public void setModeloProduto(String modeloProduto) {
		this.modeloProduto = modeloProduto;
	}

	public String getDescicaoProduto() {
		return descicaoProduto;
	}

	public void setDescicaoProduto(String descicaoProduto) {
		this.descicaoProduto = descicaoProduto;
	}

	public String getnDeSerieOuHexa() {
		return nDeSerieOuHexa;
	}

	public void setnDeSerieOuHexa(String nDeSerieOuHexa) {
		this.nDeSerieOuHexa = nDeSerieOuHexa;
	}

	public String getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(String quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getGarantiaFabricanteInicio() {
		return garantiaFabricanteInicio;
	}

	public void setGarantiaFabricanteInicio(String garantiaFabricanteInicio) {
		this.garantiaFabricanteInicio = garantiaFabricanteInicio;
	}

	public String getGarantiaFabricanteFim() {
		return garantiaFabricanteFim;
	}

	public void setGarantiaFabricanteFim(String garantiaFabricanteFim) {
		this.garantiaFabricanteFim = garantiaFabricanteFim;
	}

	public String getVigenciaGarantiaFabricante() {
		return vigenciaGarantiaFabricante;
	}

	public void setVigenciaGarantiaFabricante(String vigenciaGarantiaFabricante) {
		this.vigenciaGarantiaFabricante = vigenciaGarantiaFabricante;
	}

	public String getEnderecoDeRisco() {
		return enderecoDeRisco;
	}

	public void setEnderecoDeRisco(String enderecoDeRisco) {
		this.enderecoDeRisco = enderecoDeRisco;
	}

	public String getComplementoRisco() {
		return complementoRisco;
	}

	public void setComplementoRisco(String complementoRisco) {
		this.complementoRisco = complementoRisco;
	}

	public String getBairroRisco() {
		return bairroRisco;
	}

	public void setBairroRisco(String bairroRisco) {
		this.bairroRisco = bairroRisco;
	}

	public String getCidadeRisco() {
		return cidadeRisco;
	}

	public void setCidadeRisco(String cidadeRisco) {
		this.cidadeRisco = cidadeRisco;
	}

	public String getEstadoRisco() {
		return estadoRisco;
	}

	public void setEstadoRisco(String estadoRisco) {
		this.estadoRisco = estadoRisco;
	}

	public String getCepRisco() {
		return cepRisco;
	}

	public void setCepRisco(String cepRisco) {
		this.cepRisco = cepRisco;
	}

	public String getEstipulante() {
		return estipulante;
	}

	public void setEstipulante(String estipulante) {
		this.estipulante = estipulante;
	}

	public String getCnpjEstipulante() {
		return cnpjEstipulante;
	}

	public void setCnpjEstipulante(String cnpjEstipulante) {
		this.cnpjEstipulante = cnpjEstipulante;
	}

	public String getProLabore() {
		return proLabore;
	}

	public void setProLabore(String proLabore) {
		this.proLabore = proLabore;
	}

	public String getProLaboreRS() {
		return proLaboreRS;
	}

	public void setProLaboreRS(String proLaboreRS) {
		this.proLaboreRS = proLaboreRS;
	}

	public String getSubestipulante1() {
		return subestipulante1;
	}

	public void setSubestipulante1(String subestipulante1) {
		this.subestipulante1 = subestipulante1;
	}

	public String getCpnjSubestipulante1() {
		return cpnjSubestipulante1;
	}

	public void setCpnjSubestipulante1(String cpnjSubestipulante1) {
		this.cpnjSubestipulante1 = cpnjSubestipulante1;
	}

	public String getProLabore2() {
		return proLabore2;
	}

	public void setProLabore2(String proLabore2) {
		this.proLabore2 = proLabore2;
	}

	public String getProLaboreRS2() {
		return proLaboreRS2;
	}

	public void setProLaboreRS2(String proLaboreRS2) {
		this.proLaboreRS2 = proLaboreRS2;
	}

	public String getSubestipulante2() {
		return subestipulante2;
	}

	public void setSubestipulante2(String subestipulante2) {
		this.subestipulante2 = subestipulante2;
	}

	public String getCnpjsubestipulante2() {
		return cnpjsubestipulante2;
	}

	public void setCnpjsubestipulante2(String cnpjsubestipulante2) {
		this.cnpjsubestipulante2 = cnpjsubestipulante2;
	}

	public String getProLabore3() {
		return proLabore3;
	}

	public void setProLabore3(String proLabore3) {
		this.proLabore3 = proLabore3;
	}

	public String getProLaboreRS3() {
		return proLaboreRS3;
	}

	public void setProLaboreRS3(String proLaboreRS3) {
		this.proLaboreRS3 = proLaboreRS3;
	}

	public String getCosseguradora() {
		return cosseguradora;
	}

	public void setCosseguradora(String cosseguradora) {
		this.cosseguradora = cosseguradora;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getParticipacaoSeguradora() {
		return participacaoSeguradora;
	}

	public void setParticipacaoSeguradora(String participacaoSeguradora) {
		this.participacaoSeguradora = participacaoSeguradora;
	}

	public String getParticipacaoCosseguradora() {
		return participacaoCosseguradora;
	}

	public void setParticipacaoCosseguradora(String participacaoCosseguradora) {
		this.participacaoCosseguradora = participacaoCosseguradora;
	}

	public String getCorretor() {
		return corretor;
	}

	public void setCorretor(String corretor) {
		this.corretor = corretor;
	}

	public String getCpfCnpjCorretor() {
		return cpfCnpjCorretor;
	}

	public void setCpfCnpjCorretor(String cpfCnpjCorretor) {
		this.cpfCnpjCorretor = cpfCnpjCorretor;
	}

	public String getRegistroSusepCorretor() {
		return registroSusepCorretor;
	}

	public void setRegistroSusepCorretor(String registroSusepCorretor) {
		this.registroSusepCorretor = registroSusepCorretor;
	}

	public String getEnderecoCorretor() {
		return enderecoCorretor;
	}

	public void setEnderecoCorretor(String enderecoCorretor) {
		this.enderecoCorretor = enderecoCorretor;
	}

	public String getComplementoCorretor() {
		return complementoCorretor;
	}

	public void setComplementoCorretor(String complementoCorretor) {
		this.complementoCorretor = complementoCorretor;
	}

	public String getBairroCorretor() {
		return bairroCorretor;
	}

	public void setBairroCorretor(String bairroCorretor) {
		this.bairroCorretor = bairroCorretor;
	}

	public String getCidadeCorretor() {
		return cidadeCorretor;
	}

	public void setCidadeCorretor(String cidadeCorretor) {
		this.cidadeCorretor = cidadeCorretor;
	}

	public String getEstadoCorretor() {
		return estadoCorretor;
	}

	public void setEstadoCorretor(String estadoCorretor) {
		this.estadoCorretor = estadoCorretor;
	}

	public String getCepCorretor() {
		return cepCorretor;
	}

	public void setCepCorretor(String cepCorretor) {
		this.cepCorretor = cepCorretor;
	}

	public String getDddCorretor() {
		return dddCorretor;
	}

	public void setDddCorretor(String dddCorretor) {
		this.dddCorretor = dddCorretor;
	}

	public String getTelefoneCorretor() {
		return telefoneCorretor;
	}

	public void setTelefoneCorretor(String telefoneCorretor) {
		this.telefoneCorretor = telefoneCorretor;
	}

	public String getEmailComplementar() {
		return emailComplementar;
	}

	public void setEmailComplementar(String emailComplementar) {
		this.emailComplementar = emailComplementar;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getPremioLiquidoMensal() {
		return premioLiquidoMensal;
	}

	public void setPremioLiquidoMensal(String premioLiquidoMensal) {
		this.premioLiquidoMensal = premioLiquidoMensal;
	}

	public String getPremioLiquidoTotal() {
		return premioLiquidoTotal;
	}

	public void setPremioLiquidoTotal(String premioLiquidoTotal) {
		this.premioLiquidoTotal = premioLiquidoTotal;
	}

	public String getEnderecoEstipulante() {
		return enderecoEstipulante;
	}

	public void setEnderecoEstipulante(String enderecoEstipulante) {
		this.enderecoEstipulante = enderecoEstipulante;
	}

	public String getComplementoEstipulante() {
		return complementoEstipulante;
	}

	public void setComplementoEstipulante(String complementoEstipulante) {
		this.complementoEstipulante = complementoEstipulante;
	}

	public String getBairroEstipulante() {
		return bairroEstipulante;
	}

	public void setBairroEstipulante(String bairroEstipulante) {
		this.bairroEstipulante = bairroEstipulante;
	}

	public String getCidadeEstipulante() {
		return cidadeEstipulante;
	}

	public void setCidadeEstipulante(String cidadeEstipulante) {
		this.cidadeEstipulante = cidadeEstipulante;
	}

	public String getEstadoEstipulante() {
		return estadoEstipulante;
	}

	public void setEstadoEstipulante(String estadoEstipulante) {
		this.estadoEstipulante = estadoEstipulante;
	}

	public String getCepEstipulante() {
		return cepEstipulante;
	}

	public void setCepEstipulante(String cepEstipulante) {
		this.cepEstipulante = cepEstipulante;
	}

	public String getDddTelefoneEstipulante() {
		return dddTelefoneEstipulante;
	}

	public void setDddTelefoneEstipulante(String dddTelefoneEstipulante) {
		this.dddTelefoneEstipulante = dddTelefoneEstipulante;
	}

	public String getTelefoneEstipulante() {
		return telefoneEstipulante;
	}

	public void setTelefoneEstipulante(String telefoneEstipulante) {
		this.telefoneEstipulante = telefoneEstipulante;
	}

	public String getEnderecoSubestipulante1() {
		return enderecoSubestipulante1;
	}

	public void setEnderecoSubestipulante1(String enderecoSubestipulante1) {
		this.enderecoSubestipulante1 = enderecoSubestipulante1;
	}

	public String getComplementoSubestipulante1() {
		return complementoSubestipulante1;
	}

	public void setComplementoSubestipulante1(String complementoSubestipulante1) {
		this.complementoSubestipulante1 = complementoSubestipulante1;
	}

	public String getBairroSubestipulante1() {
		return bairroSubestipulante1;
	}

	public void setBairroSubestipulante1(String bairroSubestipulante1) {
		this.bairroSubestipulante1 = bairroSubestipulante1;
	}

	public String getCidadeSubestipulante1() {
		return cidadeSubestipulante1;
	}

	public void setCidadeSubestipulante1(String cidadeSubestipulante1) {
		this.cidadeSubestipulante1 = cidadeSubestipulante1;
	}

	public String getEstadoSubestipulante1() {
		return estadoSubestipulante1;
	}

	public void setEstadoSubestipulante1(String estadoSubestipulante1) {
		this.estadoSubestipulante1 = estadoSubestipulante1;
	}

	public String getCepSubestipulante1() {
		return cepSubestipulante1;
	}

	public void setCepSubestipulante1(String cepSubestipulante1) {
		this.cepSubestipulante1 = cepSubestipulante1;
	}

	public String getDddSubestipulante1() {
		return dddSubestipulante1;
	}

	public void setDddSubestipulante1(String dddSubestipulante1) {
		this.dddSubestipulante1 = dddSubestipulante1;
	}

	public String getTelefoneSubestipulante1() {
		return telefoneSubestipulante1;
	}

	public void setTelefoneSubestipulante1(String telefoneSubestipulante1) {
		this.telefoneSubestipulante1 = telefoneSubestipulante1;
	}

	public String getEnderecoSubestipulante2() {
		return enderecoSubestipulante2;
	}

	public void setEnderecoSubestipulante2(String enderecoSubestipulante2) {
		this.enderecoSubestipulante2 = enderecoSubestipulante2;
	}

	public String getComplementoSubestipulante2() {
		return complementoSubestipulante2;
	}

	public void setComplementoSubestipulante2(String complementoSubestipulante2) {
		this.complementoSubestipulante2 = complementoSubestipulante2;
	}

	public String getBairroSubestipulante2() {
		return bairroSubestipulante2;
	}

	public void setBairroSubestipulante2(String bairroSubestipulante2) {
		this.bairroSubestipulante2 = bairroSubestipulante2;
	}

	public String getCidadeSubestipulante2() {
		return cidadeSubestipulante2;
	}

	public void setCidadeSubestipulante2(String cidadeSubestipulante2) {
		this.cidadeSubestipulante2 = cidadeSubestipulante2;
	}

	public String getEstadoSubestipulante2() {
		return estadoSubestipulante2;
	}

	public void setEstadoSubestipulante2(String estadoSubestipulante2) {
		this.estadoSubestipulante2 = estadoSubestipulante2;
	}

	public String getCepSubestipulante2() {
		return cepSubestipulante2;
	}

	public void setCepSubestipulante2(String cepSubestipulante2) {
		this.cepSubestipulante2 = cepSubestipulante2;
	}

	public String getDddSubestipulante2() {
		return dddSubestipulante2;
	}

	public void setDddSubestipulante2(String dddSubestipulante2) {
		this.dddSubestipulante2 = dddSubestipulante2;
	}

	public String getTelefoneSubestipulante2() {
		return telefoneSubestipulante2;
	}

	public void setTelefoneSubestipulante2(String telefoneSubestipulante2) {
		this.telefoneSubestipulante2 = telefoneSubestipulante2;
	}

	public String getEmailCorretor() {
		return emailCorretor;
	}

	public void setEmailCorretor(String emailCorretor) {
		this.emailCorretor = emailCorretor;
	}

	public String getCoCorretor1() {
		return coCorretor1;
	}

	public void setCoCorretor1(String coCorretor1) {
		this.coCorretor1 = coCorretor1;
	}

	public String getCpfCnpjCoCorretor1() {
		return cpfCnpjCoCorretor1;
	}

	public void setCpfCnpjCoCorretor1(String cpfCnpjCoCorretor1) {
		this.cpfCnpjCoCorretor1 = cpfCnpjCoCorretor1;
	}

	public String getRegistroSusepCoCorretor1() {
		return registroSusepCoCorretor1;
	}

	public void setRegistroSusepCoCorretor1(String registroSusepCoCorretor1) {
		this.registroSusepCoCorretor1 = registroSusepCoCorretor1;
	}

	public String getEnderecoCoCorretor1() {
		return enderecoCoCorretor1;
	}

	public void setEnderecoCoCorretor1(String enderecoCoCorretor1) {
		this.enderecoCoCorretor1 = enderecoCoCorretor1;
	}

	public String getComplementoCoCorretor1() {
		return complementoCoCorretor1;
	}

	public void setComplementoCoCorretor1(String complementoCoCorretor1) {
		this.complementoCoCorretor1 = complementoCoCorretor1;
	}

	public String getBairroCoCorretor1() {
		return bairroCoCorretor1;
	}

	public void setBairroCoCorretor1(String bairroCoCorretor1) {
		this.bairroCoCorretor1 = bairroCoCorretor1;
	}

	public String getCidadeCoCorretor1() {
		return cidadeCoCorretor1;
	}

	public void setCidadeCoCorretor1(String cidadeCoCorretor1) {
		this.cidadeCoCorretor1 = cidadeCoCorretor1;
	}

	public String getEstadoCoCorretor1() {
		return estadoCoCorretor1;
	}

	public void setEstadoCoCorretor1(String estadoCoCorretor1) {
		this.estadoCoCorretor1 = estadoCoCorretor1;
	}

	public String getCepCoCorretor1() {
		return cepCoCorretor1;
	}

	public void setCepCoCorretor1(String cepCoCorretor1) {
		this.cepCoCorretor1 = cepCoCorretor1;
	}

	public String getDddCoCorretor1() {
		return dddCoCorretor1;
	}

	public void setDddCoCorretor1(String dddCoCorretor1) {
		this.dddCoCorretor1 = dddCoCorretor1;
	}

	public String getTelefoneCoCorretor1() {
		return telefoneCoCorretor1;
	}

	public void setTelefoneCoCorretor1(String telefoneCoCorretor1) {
		this.telefoneCoCorretor1 = telefoneCoCorretor1;
	}

	public String getEmailCoCorretor1() {
		return emailCoCorretor1;
	}

	public void setEmailCoCorretor1(String emailCoCorretor1) {
		this.emailCoCorretor1 = emailCoCorretor1;
	}

	public String getCoCorretor2() {
		return coCorretor2;
	}

	public void setCoCorretor2(String coCorretor2) {
		this.coCorretor2 = coCorretor2;
	}

	public String getCpfCnpjCoCorretor2() {
		return cpfCnpjCoCorretor2;
	}

	public void setCpfCnpjCoCorretor2(String cpfCnpjCoCorretor2) {
		this.cpfCnpjCoCorretor2 = cpfCnpjCoCorretor2;
	}

	public String getRegistroSusepCoCorretor2() {
		return registroSusepCoCorretor2;
	}

	public void setRegistroSusepCoCorretor2(String registroSusepCoCorretor2) {
		this.registroSusepCoCorretor2 = registroSusepCoCorretor2;
	}

	public String getEnderecoDoCoCorretor2() {
		return enderecoDoCoCorretor2;
	}

	public void setEnderecoDoCoCorretor2(String enderecoDoCoCorretor2) {
		this.enderecoDoCoCorretor2 = enderecoDoCoCorretor2;
	}

	public String getComplementoCoCorretor2() {
		return complementoCoCorretor2;
	}

	public void setComplementoCoCorretor2(String complementoCoCorretor2) {
		this.complementoCoCorretor2 = complementoCoCorretor2;
	}

	public String getBairroCoCorretor2() {
		return bairroCoCorretor2;
	}

	public void setBairroCoCorretor2(String bairroCoCorretor2) {
		this.bairroCoCorretor2 = bairroCoCorretor2;
	}

	public String getCidadeCoCorretor2() {
		return cidadeCoCorretor2;
	}

	public void setCidadeCoCorretor2(String cidadeCoCorretor2) {
		this.cidadeCoCorretor2 = cidadeCoCorretor2;
	}

	public String getEstadoCoCorretor2() {
		return estadoCoCorretor2;
	}

	public void setEstadoCoCorretor2(String estadoCoCorretor2) {
		this.estadoCoCorretor2 = estadoCoCorretor2;
	}

	public String getCepCoCorretor2() {
		return cepCoCorretor2;
	}

	public void setCepCoCorretor2(String cepCoCorretor2) {
		this.cepCoCorretor2 = cepCoCorretor2;
	}

	public String getDddCoCorretor2() {
		return dddCoCorretor2;
	}

	public void setDddCoCorretor2(String dddCoCorretor2) {
		this.dddCoCorretor2 = dddCoCorretor2;
	}

	public String getTelefoneCoCorretor2() {
		return telefoneCoCorretor2;
	}

	public void setTelefoneCoCorretor2(String telefoneCoCorretor2) {
		this.telefoneCoCorretor2 = telefoneCoCorretor2;
	}

	public String getEmailCoCorretor2() {
		return emailCoCorretor2;
	}

	public void setEmailCoCorretor2(String emailCoCorretor2) {
		this.emailCoCorretor2 = emailCoCorretor2;
	}

	public String getCoCorretor3() {
		return coCorretor3;
	}

	public void setCoCorretor3(String coCorretor3) {
		this.coCorretor3 = coCorretor3;
	}

	public String getCpfCnpjCoCorretor() {
		return cpfCnpjCoCorretor;
	}

	public void setCpfCnpjCoCorretor(String cpfCnpjCoCorretor) {
		this.cpfCnpjCoCorretor = cpfCnpjCoCorretor;
	}

	public String getRegistroSusepCoCorretor3() {
		return registroSusepCoCorretor3;
	}

	public void setRegistroSusepCoCorretor3(String registroSusepCoCorretor3) {
		this.registroSusepCoCorretor3 = registroSusepCoCorretor3;
	}

	public String getEnderecoCoCorretor3() {
		return enderecoCoCorretor3;
	}

	public void setEnderecoCoCorretor3(String enderecoCoCorretor3) {
		this.enderecoCoCorretor3 = enderecoCoCorretor3;
	}

	public String getComplementoCoCorretor3() {
		return complementoCoCorretor3;
	}

	public void setComplementoCoCorretor3(String complementoCoCorretor3) {
		this.complementoCoCorretor3 = complementoCoCorretor3;
	}

	public String getBairroCoCorretor3() {
		return bairroCoCorretor3;
	}

	public void setBairroCoCorretor3(String bairroCoCorretor3) {
		this.bairroCoCorretor3 = bairroCoCorretor3;
	}

	public String getCidadeCoCorretor3() {
		return cidadeCoCorretor3;
	}

	public void setCidadeCoCorretor3(String cidadeCoCorretor3) {
		this.cidadeCoCorretor3 = cidadeCoCorretor3;
	}

	public String getEstadoCoCorretor3() {
		return estadoCoCorretor3;
	}

	public void setEstadoCoCorretor3(String estadoCoCorretor3) {
		this.estadoCoCorretor3 = estadoCoCorretor3;
	}

	public String getCepCoCorretor3() {
		return cepCoCorretor3;
	}

	public void setCepCoCorretor3(String cepCoCorretor3) {
		this.cepCoCorretor3 = cepCoCorretor3;
	}

	public String getDddCoCorretor3() {
		return dddCoCorretor3;
	}

	public void setDddCoCorretor3(String dddCoCorretor3) {
		this.dddCoCorretor3 = dddCoCorretor3;
	}

	public String getTelefoneCoCorretor3() {
		return telefoneCoCorretor3;
	}

	public void setTelefoneCoCorretor3(String telefoneCoCorretor3) {
		this.telefoneCoCorretor3 = telefoneCoCorretor3;
	}

	public String getEmailCoCorretor3() {
		return emailCoCorretor3;
	}

	public void setEmailCoCorretor3(String emailCoCorretor3) {
		this.emailCoCorretor3 = emailCoCorretor3;
	}

	public String getCapModalidade() {
		return capModalidade;
	}

	public void setCapModalidade(String capModalidade) {
		this.capModalidade = capModalidade;
	}

	public String getProcessoSusep1() {
		return processoSusep1;
	}

	public void setProcessoSusep1(String processoSusep1) {
		this.processoSusep1 = processoSusep1;
	}

	public String getProcessoSusep2() {
		return processoSusep2;
	}

	public void setProcessoSusep2(String processoSusep2) {
		this.processoSusep2 = processoSusep2;
	}

	public String getGarantido1() {
		return garantido1;
	}

	public void setGarantido1(String garantido1) {
		this.garantido1 = garantido1;
	}

	public String getCpfCnpjGarantido1() {
		return cpfCnpjGarantido1;
	}

	public void setCpfCnpjGarantido1(String cpfCnpjGarantido1) {
		this.cpfCnpjGarantido1 = cpfCnpjGarantido1;
	}

	public String getGarantido2() {
		return garantido2;
	}

	public void setGarantido2(String garantido2) {
		this.garantido2 = garantido2;
	}

	public String getCpfCnpjGarantido2() {
		return cpfCnpjGarantido2;
	}

	public void setCpfCnpjGarantido2(String cpfCnpjGarantido2) {
		this.cpfCnpjGarantido2 = cpfCnpjGarantido2;
	}

	public String getLocatarioSolidario() {
		return locatarioSolidario;
	}

	public void setLocatarioSolidario(String locatarioSolidario) {
		this.locatarioSolidario = locatarioSolidario;
	}

	public String getCpfCnpjLocatarioSolidario1() {
		return cpfCnpjLocatarioSolidario1;
	}

	public void setCpfCnpjLocatarioSolidario1(String cpfCnpjLocatarioSolidario1) {
		this.cpfCnpjLocatarioSolidario1 = cpfCnpjLocatarioSolidario1;
	}

	public String getLocatarioSolidario2() {
		return locatarioSolidario2;
	}

	public void setLocatarioSolidario2(String locatarioSolidario2) {
		this.locatarioSolidario2 = locatarioSolidario2;
	}

	public String getCpfCnpjLocatarioSolidario2() {
		return cpfCnpjLocatarioSolidario2;
	}

	public void setCpfCnpjLocatarioSolidario2(String cpfCnpjLocatarioSolidario2) {
		this.cpfCnpjLocatarioSolidario2 = cpfCnpjLocatarioSolidario2;
	}

	public String getLocatarioSolidario3() {
		return locatarioSolidario3;
	}

	public void setLocatarioSolidario3(String locatarioSolidario3) {
		this.locatarioSolidario3 = locatarioSolidario3;
	}

	public String getCpjCnpjLocatarioSolidario3() {
		return cpjCnpjLocatarioSolidario3;
	}

	public void setCpjCnpjLocatarioSolidario3(String cpjCnpjLocatarioSolidario3) {
		this.cpjCnpjLocatarioSolidario3 = cpjCnpjLocatarioSolidario3;
	}

	public String getLocatarioSolidario4() {
		return locatarioSolidario4;
	}

	public void setLocatarioSolidario4(String locatarioSolidario4) {
		this.locatarioSolidario4 = locatarioSolidario4;
	}

	public String getCpfCnpjLocatarioSolidario4() {
		return cpfCnpjLocatarioSolidario4;
	}

	public void setCpfCnpjLocatarioSolidario4(String cpfCnpjLocatarioSolidario4) {
		this.cpfCnpjLocatarioSolidario4 = cpfCnpjLocatarioSolidario4;
	}

	public String getLocatarioSolidario5() {
		return locatarioSolidario5;
	}

	public void setLocatarioSolidario5(String locatarioSolidario5) {
		this.locatarioSolidario5 = locatarioSolidario5;
	}

	public String getCpfCnpjLocatarioSolidario5() {
		return cpfCnpjLocatarioSolidario5;
	}

	public void setCpfCnpjLocatarioSolidario5(String cpfCnpjLocatarioSolidario5) {
		this.cpfCnpjLocatarioSolidario5 = cpfCnpjLocatarioSolidario5;
	}

	public String getLocatarioSolidario6() {
		return locatarioSolidario6;
	}

	public void setLocatarioSolidario6(String locatarioSolidario6) {
		this.locatarioSolidario6 = locatarioSolidario6;
	}

	public String getCpfCnpjLocatarioSolidario6() {
		return cpfCnpjLocatarioSolidario6;
	}

	public void setCpfCnpjLocatarioSolidario6(String cpfCnpjLocatarioSolidario6) {
		this.cpfCnpjLocatarioSolidario6 = cpfCnpjLocatarioSolidario6;
	}

	public String getProcuradorDoSubscritoTitular() {
		return ProcuradorDoSubscritoTitular;
	}

	public void setProcuradorDoSubscritoTitular(String procuradorDoSubscritoTitular) {
		ProcuradorDoSubscritoTitular = procuradorDoSubscritoTitular;
	}

	public String getCpfCnpjDoSubscritorTitular() {
		return cpfCnpjDoSubscritorTitular;
	}

	public void setCpfCnpjDoSubscritorTitular(String cpfCnpjDoSubscritorTitular) {
		this.cpfCnpjDoSubscritorTitular = cpfCnpjDoSubscritorTitular;
	}

	public String getRepresentanteDoProcurador() {
		return representanteDoProcurador;
	}

	public void setRepresentanteDoProcurador(String representanteDoProcurador) {
		this.representanteDoProcurador = representanteDoProcurador;
	}

	public String getCpfCnpjDoSuscritorTitular2() {
		return cpfCnpjDoSuscritorTitular2;
	}

	public void setCpfCnpjDoSuscritorTitular2(String cpfCnpjDoSuscritorTitular2) {
		this.cpfCnpjDoSuscritorTitular2 = cpfCnpjDoSuscritorTitular2;
	}

	public String getCampoTexto1() {
		return campoTexto1;
	}

	public void setCampoTexto1(String campoTexto1) {
		this.campoTexto1 = campoTexto1;
	}

	public String getCampoTexto2() {
		return campoTexto2;
	}

	public void setCampoTexto2(String campoTexto2) {
		this.campoTexto2 = campoTexto2;
	}

	public String getCampoTexto3() {
		return campoTexto3;
	}

	public void setCampoTexto3(String campoTexto3) {
		this.campoTexto3 = campoTexto3;
	}

	public String getCampoNumero1() {
		return campoNumero1;
	}

	public void setCampoNumero1(String campoNumero1) {
		this.campoNumero1 = campoNumero1;
	}

	public String getCampoNumero2() {
		return campoNumero2;
	}

	public void setCampoNumero2(String campoNumero2) {
		this.campoNumero2 = campoNumero2;
	}

	public String getCampoNumero3() {
		return campoNumero3;
	}

	public void setCampoNumero3(String campoNumero3) {
		this.campoNumero3 = campoNumero3;
	}

	public String getCodigoRejeicao() {
		return codigoRejeicao;
	}

	public void setCodigoRejeicao(String codigoRejeicao) {
		this.codigoRejeicao = codigoRejeicao;
	}

}
