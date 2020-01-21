package br.com.cardif.life.map;

import br.com.cardif.utils.PageObjectUtils;

public class LifeClienteEnderecosElementMap extends PageObjectUtils {

	// Cabecalho tabela Endereço
	protected String cabecalhoTabelaEndereco = "#frmClient\\:tabView\\:grdAddresses > div:nth-child(1) > div:nth-child(1) > table:nth-child(1)";
	// Registros Endereço cliente
	protected String registroEnderecoCliente = "#frmClient\\:tabView\\:grdAddresses > div:nth-child(2) > table:nth-child(1)";

}
