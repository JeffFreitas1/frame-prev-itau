package br.com.primeup.cardif.life.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeLoginElementMap;
import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class LifeLoginPage extends LifeLoginElementMap {

	public LifeLoginPage() throws Exception {
		driver=TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		abrirURL("http://saos101ws06t.br.xcd.net.intra:28080/life/login.xhtml");
		waitLoading(labelLogin);
		Thread.sleep(5000);
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean loginPortalLife(List<Map<String, String>> credenciais ) throws Exception {
		try {
			sfSendText(usuario, Utils.getValorFormulario("Usuario", credenciais));
			sfSendText(senha, Utils.getValorFormulario("Senha", credenciais));
			sfClick(abrirOpcoes);
			sfClick(ambiente.replace("@BASE", Utils.getValorFormulario("Base", credenciais)));
			sfClick(botaoLogin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean loginPortalLife(String baseSistema) throws Exception {
		try {
			sfSendText(usuario, TestRule.getCredenciaisLife().get("Usuario"));
			sfSendText(senha, TestRule.getCredenciaisLife().get("Senha"));
			sfClick(abrirOpcoes);
			sfClick(ambiente.replace("@BASE", baseSistema));
			sfClick(botaoLogin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
