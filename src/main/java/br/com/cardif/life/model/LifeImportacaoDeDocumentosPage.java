package br.com.cardif.life.model;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeSinistroImportacaoDocumentosElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeImportacaoDeDocumentosPage extends LifeSinistroImportacaoDocumentosElementMap {

	public void consultaSinistroImportacaoDocumentos() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void consultaCampoSinsitro(String strNumeroSinistro) throws Exception {
		sfSendText(campoNumeroSinsitro, strNumeroSinistro);
		sfClick(botaoImportar);
		rbUploadFile("C:\\Users\\d55443\\Downloads\\indice.jpg");
		sfClick(botaoGravar);
		sfClick(botaoOkArquivosImportados);
	
	}
}
