package br.com.cardif.life.page;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeClienteDadosPessoaisElementMap;
import br.com.cardif.life.map.LifeHomeElementMap;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.StringUtils;
import br.com.cardif.utils.Utils;
import br.com.cardif.webservice.model.RequestVolksJSON;

public class LifeClienteDadosPessoaisPage extends LifeClienteDadosPessoaisElementMap {

	public LifeClienteDadosPessoaisPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		Thread.sleep(5000);
		waitElementInvisibility(LifeHomeElementMap.loadingImage);
		PageFactory.initElements(driver, this);
	}

	public boolean validaDadosPessoais(List<Map<String, String>> formulario) throws Exception {

		return (sfGetAttributeValue(txtDataNascimento, "value")
				.equals(Utils.getValorFormulario("Data de Nascimento", formulario))
				&& sfGetAttributeValue(txtCpf, "value").equals(Utils.getValorFormulario("CPF", formulario))
				&& sfGetAttributeValue(txtEmail, "value").equals(Utils.getValorFormulario("Email", formulario))
				&& sfGetAttributeValue(txtSexo, "value").equals(Utils.getValorFormulario("Sexo", formulario)));
	}

	public boolean validaDadosPessoais(RequestVolksJSON request) throws Exception {
		
		return (sfGetAttributeValue(txtDataNascimento, "value").equals(request.getSegurado().getDtNascimento())
				&& StringUtils.removeCaracteresEspeciais(sfGetAttributeValue(txtCpf, "value"))
						.equals(request.getSegurado().getCpf())
				&& sfGetAttributeValue(txtEmail, "value").equals(request.getSegurado().getEmail())
				&& sfGetSelectOptionValue(sexoCssSelector).equals(request.getSegurado().getSexo()));
	}

}
