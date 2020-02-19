package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;

import br.com.cardif.utils.PageObjectUtils;

public class LifeSinistroImportacaoDocumentosElementMap extends PageObjectUtils {
	
	//Botoes
	protected String botaoImportar = "//input[contains(@multiple,'multiple')]";
	protected String botaoGravar = "//span[contains(.,'Gravar')]";
	protected String botaoOkArquivosImportados = "(//span[contains(.,'OK')])[1]";
	protected String botaoDropdownSelecionarArquivo = "//label[contains(@id,'frmClaimDocumentImport:doc_row:0:doc_type_label')]";
	protected String botaoEmailProtocolo = "(//li[contains(.,'Email/Protocolo - 163')])[1]";
	//Campos
	protected String campoNumeroSinsitro = "(//input[contains(@id,'frmClaimDocumentImport:txtNrSinistro')])[1]";
	protected String dropDownSelecionarArquivo = "//label[contains(@id,'frmClaimDocumentImport:doc_row:0:doc_type_label')]";
	protected String campoPesquisaArquivo = "//input[@name='frmClaimDocumentImport:doc_row:0:doc_type_filter']";
	

}
