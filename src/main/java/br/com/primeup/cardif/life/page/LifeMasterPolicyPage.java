package br.com.primeup.cardif.life.page;

import org.openqa.selenium.support.PageFactory;

import br.com.primeup.cardif.life.map.LifeHomeElementMap;
import br.com.primeup.cardif.life.map.LifeMasterPolicyElementMap;
import br.com.primeup.cardif.testrules.TestRule;
import br.com.primeup.cardif.utils.Utils;

public class LifeMasterPolicyPage extends LifeMasterPolicyElementMap {

	public LifeMasterPolicyPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		waitLoading(menuMasterPolicy);
		PageFactory.initElements(driver, this);
	}

	public void consultarMasterPolicy(String cobertura, String masterPolicy) throws Exception {
		sfSendText(txtMasterPolicy, masterPolicy);
		sfClick(botaoPesquisaMasterPolicy);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfClick(abaSinistro);
		LifeMasterPolicySinistroPage masterPolicySinistroPage = new LifeMasterPolicySinistroPage();
		masterPolicySinistroPage.selecionarCobertura(cobertura);
		sfPrintScreenSwitchFrame(LifeHomePage.getIdCurrentFrame(), "Validação Master Policy");
		Utils.logInfo("Valor percentual: " + masterPolicySinistroPage.getPercentual());
	}

	public void consultarMasterPolicy(String masterPolicy) throws Exception {
		sfSendText(txtMasterPolicy, masterPolicy);
		sfClick(botaoPesquisaMasterPolicy);
		waitElementInvisibility(LifeHomeElementMap.loading);
		sfClick(abaCobranca);
		waitElementInvisibility(LifeHomeElementMap.loading);
		LifeMasterPolicyCobrancaPage masterPolicyCobrancaPage = new LifeMasterPolicyCobrancaPage();
		masterPolicyCobrancaPage.teste();
	}

}
