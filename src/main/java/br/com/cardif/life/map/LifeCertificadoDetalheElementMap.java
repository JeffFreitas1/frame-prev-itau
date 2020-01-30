package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeCertificadoDetalheElementMap extends PageObjectUtils {
	
	
	protected String xpathCertificadoPage = "//span[@id='dlgCertificado_title']";
	
	protected String xpathCertificadoPlano="//span[@id='frmCertificate:dlgComposicao_title']";
	

	// Quantidade de registros
	protected String quantidadeRegistros = "//label[contains(.,'Total de registros: 1')]";

	// Cabecalho tabela de certificados
	protected String tabelaCabecalhoCertificados = ".ui-datatable-scrollable-header-box > table:nth-child(1)";
	
	//Campos Certificados
	protected String tabelaCertificado = "#frmCertificate\\:tabsCertificado\\:treeComposicao\\:0 > ul:nth-child(2)";
	
	//Cabecalho tabela de Cobertura
	protected String tabelaCabecalhoCobertura = "#frmCertificate\\:tabsCertificado\\:treeComposicao\\:0";
	
	// Tabela de certificados
	protected String tabelaRegistrosCertificados = ".ui-datatable-scrollable-body > table:nth-child(1)";

	@FindBy(xpath = "//a[@href='#frmCertificate:tabsCertificado:tabComposicao']")
	protected WebElement abaComposicao;
	
//	protected String abaComposicao1 = "/html/body/div[2]/div[2]/form/div[1]/ul/li[2]/a";
	protected String abaComposicao1 = "/html/body/div[2]/div[2]/form/div[1]/ul/li[2]";
	
	protected String morte1= "span.ui-state-highlight";
	
	protected String show = "//*[@id=\"frmCertificate:tabsCertificado:btnShow\"]";
	
	
	//Total premio certificado

	protected String totalDoPremio = "//*[@id=\"frmCertificate:tabsCertificado:txtTotalPremio\"]"; 
	

	
	// btn fechar detalhes do certificado
	protected String fechar = "#frmCertificate\\:j_id_qg";
	
	
		
	
	// Campos do plano
	
	protected String cssrisco = "#frmCertificate\\:cboRisk_input" ;
	
	protected String csscobertura = "#frmCertificate\\:cboCoverage_input" ;
	
	protected String cssnomePlano = "#frmCertificate\\:cboPlan_input" ;
	
	protected String csspremio = "#frmCertificate\\:j_id_pr";
	
	protected String csspremioFator="#frmCertificate\\:j_id_pu";
		
	protected String csslmi = "#frmCertificate\\:inssuredAmount";

	protected String csscancelar = "#frmCertificate\\:j_id_q8";
	


}
