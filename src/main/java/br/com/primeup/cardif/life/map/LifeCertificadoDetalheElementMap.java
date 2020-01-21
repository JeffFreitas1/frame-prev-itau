package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeCertificadoDetalheElementMap extends PageObjectUtils {

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
	protected String fechar = "#frmCertificate\\:j_id_qh";
	
	
		
	
	// Campos do plano
	
	protected String risco = "#frmCertificate\\:cboRisk_input" ;
	
	protected String cobertura = "#frmCertificate\\:cboCoverage_input" ;
	
	protected String nomePlano = "#frmCertificate\\:cboPlan_input" ;
	
	protected String premio = "#frmCertificate\\:j_id_pr" ;
	
	protected String lmi = "#frmCertificate\\:inssuredAmount";

	protected String cancelar = "#frmCertificate\\:j_id_q9";
	


}
