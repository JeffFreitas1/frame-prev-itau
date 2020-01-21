package br.com.cardif.life.page;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeSinistroDetalhesElementMap;
import br.com.cardif.testrules.TestRule;

public class LifeSinistroDetalhesPage extends LifeSinistroDetalhesElementMap{
	
	public LifeSinistroDetalhesPage() throws Exception {
		driver=TestRule.getDriver();
		wait= TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void menuSinistro() throws Exception {
		
		System.out.println(txtContrato.getAttribute("value"));
		System.out.println(txtRazaoSolicitacao.getAttribute("value"));
		System.out.println(txtNumeroCertificado.getAttribute("value"));
		System.out.println(labelEndossoCertificado.getText());
		System.out.println(txtStatus.getAttribute("value"));
		System.out.println(txtNumeroMasterPolicy.getAttribute("value"));
		System.out.println(txtDtEfetivacao.getAttribute("value"));
		System.out.println(txtDtExpiracao.getAttribute("value"));
		System.out.println(txtDescricaoMasterPolicy.getAttribute("value"));
		System.out.println(txtContrato.getAttribute("value"));
		System.out.println(valorFinanciado.getText());
		System.out.println(valorPrestacao.getText());
		valorPrestacao.sendKeys("dsads");
		
	}
	
	
}
