package br.com.cardif.life.page;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeSinistroImportacaoDocumentosElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeImportacaoDeDocumentosPage extends LifeSinistroImportacaoDocumentosElementMap {
	
	public LifeImportacaoDeDocumentosPage () throws Exception {
		driver=TestRule.getDriver();
		wait= TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void fazerUploadImagem(String strNumeroSinistro) throws Exception {
		sfSendText(campoNumeroSinsitro, strNumeroSinistro);
		sfMoveToElementClickJs(botaoImportar);
		rbUploadFile("C:\\Users\\d55443\\Downloads\\indice.jpg");
		sfClick(botaoDropdownSelecionarArquivo);
		sfSendText(campoPesquisaArquivo, "Email/Protocolo");
		sfClick(botaoEmailProtocolo);
		sfClick(botaoGravar);
		waitLoading(botaoOkArquivosImportados);
		sfClick(botaoOkArquivosImportados);
	

}
}
