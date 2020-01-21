package br.com.cardif.life.page;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeSinistroBeneficiarioInclusaoElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeSinistroBeneficiarioInclusaoPage extends LifeSinistroBeneficiarioInclusaoElementMap{
	
	
	public LifeSinistroBeneficiarioInclusaoPage() throws Exception {
		driver=TestRule.getDriver();
		wait= TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void incluirNovoBeneficiario() throws Exception {
		sfSendText(txtNomeBenefiario, "teste ISJ2");
		sfSendText(txtDataNascimento, "05/12/1996");
		sfClick(opcaoSexo);
		sfClick(sexo.replace("@SEXO", "Masculino"));
		sfClick(opcaoGrauParentesco);	
		sfClick(grauParentesco.replace("@PARENTESCO", "Filho"));
		sfSendText(txtCpfBeneficiario, "878.791.352-60");
		sfSendText(txtTelefoneBeneficiario,"114207812");
		sfSendText(txtEndereco,"Rua Bom Principio");
		sfSendText(txtNumeroEndereco,"14");
		sfSendText(txtComplementoEndereco,"2");
		sfSendText(txtBairro,"Vilinha");
		sfSendText(txtCidade,"Imperatriz");
		sfClick(listaEstado);			
		sfClick(estado.replace("@ESTADO", "MA"));
		sfSendText(txtCodigoPostal,"65915540");
		sfSendText(txtCodigoIntercambio,"214");
		sfSendText(txtObsBeneficiario,"teste");
		sfClick(botaoSalvarBeneficiario);			
	}	

}
