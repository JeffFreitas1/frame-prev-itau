package br.com.primeup.cardif.webservice.model;

import java.util.List;
import java.util.Map;

import br.com.primeup.cardif.utils.Utils;

public class Veiculo {
	
	private String marca;
	private String modelo;
	private String anoModelo;
	private String anoFabricacao;
	private String combustivel;
	private String valorNotaFiscal;
	private String chassi;
	private String placa;
	private String quilometragem;
	private String dtInicioGarantiaFab;
	private String dtFimGarantiaFab;
	private String codMolicar;

	public Veiculo(String marca, String modelo, String anoModelo, String anoFabricacao, String combustivel,
			String valorNotaFiscal, String chassi, String placa, String quilometragem, String dtInicioGarantiaFab,
			String dtFimGarantiaFab, String codMolicar) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.combustivel = combustivel;
		this.valorNotaFiscal = valorNotaFiscal;
		this.chassi = chassi;
		this.placa = placa;
		this.quilometragem = quilometragem;
		this.dtInicioGarantiaFab = dtInicioGarantiaFab;
		this.dtFimGarantiaFab = dtFimGarantiaFab;
		this.codMolicar = codMolicar;
	}
	
	public Veiculo(List<Map<String, String>> formulario) {
		this.marca = Utils.getValorFormulario("marca", formulario);
		this.modelo = Utils.getValorFormulario("modelo", formulario);
		this.anoModelo = Utils.getValorFormulario("anoModelo", formulario);
		this.anoFabricacao = Utils.getValorFormulario("anoFabricacao", formulario);
		this.combustivel = Utils.getValorFormulario("combustivel", formulario);
		this.valorNotaFiscal = Utils.getValorFormulario("valorNotaFiscal", formulario);
		this.chassi = Utils.getValorFormulario("chassi", formulario);
		this.placa = Utils.getValorFormulario("placa", formulario);
		this.quilometragem = Utils.getValorFormulario("quilometragem", formulario);
		this.dtInicioGarantiaFab = Utils.getValorFormulario("dtInicioGarantiaFab", formulario);
		this.dtFimGarantiaFab = Utils.getValorFormulario("dtFimGarantiaFab", formulario);
		this.codMolicar = Utils.getValorFormulario("codMolicar", formulario);
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

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getValorNotaFiscal() {
		return valorNotaFiscal;
	}

	public void setValorNotaFiscal(String valorNotaFiscal) {
		this.valorNotaFiscal = valorNotaFiscal;
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

	public String getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(String quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getDtInicioGarantiaFab() {
		return dtInicioGarantiaFab;
	}

	public void setDtInicioGarantiaFab(String dtInicioGarantiaFab) {
		this.dtInicioGarantiaFab = dtInicioGarantiaFab;
	}

	public String getDtFimGarantiaFab() {
		return dtFimGarantiaFab;
	}

	public void setDtFimGarantiaFab(String dtFimGarantiaFab) {
		this.dtFimGarantiaFab = dtFimGarantiaFab;
	}

	public String getCodMolicar() {
		return codMolicar;
	}

	public void setCodMolicar(String codMolicar) {
		this.codMolicar = codMolicar;
	}

}
