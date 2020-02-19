package br.com.cardif.life.page;


import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeSinistroFavorecidosElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeSinistroFavorecidosPage extends LifeSinistroFavorecidosElementMap{
	
	public LifeSinistroFavorecidosPage() throws Exception {
		driver=TestRule.getDriver();
		wait= TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void incluirFavorecidoBeneficiario() throws Exception {
		sfClick(botaoAdicionarFavorecido);
		sfClick(tipoFavorecidoBeneficiario);
		sfClick(opcoesTipoPessoa);
		sfClick(tipoPessoa.replace("@TIPOPESSOA", "Física"));
		sfSendText(txtDocumento, "878.791.352-60");
		sfClick(formularioBeneficiario);
		sfClick(opcoesTipoConta);
		sfClick(tipoConta.replace("@TIPOCONTA", "C/C INDIVIDUAL"));
		sfSendText(txtNomeFavorecido, "teste ISJ2");
		sfClick(listaBanco);
		sfSendText(filtroBuscarBanco, "Bradesco");
		sfClick(banco.replace("@BANCO", "Banco Bradesco S.A. (237)"));
		sfSendText(txtAgenciaConta, "58337");
		sfSendText(txtDVAgenciaConta, "5");
		sfSendText(txtConta, "354478");
		sfSendText(txtDVConta, "3");
		sfClick(botaoIncluirNovoBeneficiario);
		//LifeSinistroBeneficiarioInclusaoPage cadastroBeneficiario = new LifeSinistroBeneficiarioInclusaoPage();
		//cadastroBeneficiario.incluirNovoBeneficiario();
		sfClick(botaoSalvarFavorecido);
		
	}
	

}
