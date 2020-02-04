package br.com.cardif.life.map;

import br.com.cardif.utils.PageObjectUtils;

public class LifeImpressaoDasCartasElementMap extends PageObjectUtils {
	
	//Botoes 
	protected String botaoPorTipo = "//label[contains(.,'Por tipo')]";
	protected String botaoGerarRelatorio = "//span[contains(.,'Gerar Relatório')]";
	protected String botaoImrpimir = "(//span[contains(.,'Imprimir')])[2]";
	//DropDown
	protected String tipoCartaDropDown = "//label[@id='frmLetterPrint:selLetterType_label']";
	//Campo Pesquisa
	protected String campoPesquisaTipoCarta = "//*[@id=\"frmLetterPrint:selLetterType_filter\"]";
	protected String codSinistro = "//input[contains(@name,'frmLetterPrint:txtNrSinistro')]";
	//Opcoes Campo Pesquisa
	protected String campoPesquisaSolicitacaoDocumentos = "//li[@data-label='Solicitacao de Documentos']";
	

}
