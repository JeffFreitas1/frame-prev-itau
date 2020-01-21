package br.com.cardif.life.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.cardif.life.map.LifeClienteEnderecosElementMap;
import br.com.cardif.testrules.TestRule;
import br.com.cardif.utils.Utils;

public class LifeClienteEnderecosPage extends LifeClienteEnderecosElementMap {

	public LifeClienteEnderecosPage() throws Exception {
		driver = TestRule.getDriver();
		wait = TestRule.getWaitDriver();
		PageFactory.initElements(driver, this);
	}

	public boolean validaEndereco(List<Map<String, String>> formulario) throws Exception {
		Map<String, String> endereco = new HashMap<>();
		endereco = getEnderecoCorrespondencia();

		return (endereco.get("Logradouro").equals(Utils.getValorFormulario("endereco", formulario))
				&& endereco.get("Nº").equals(Utils.getValorFormulario("numEnd", formulario))
				&& endereco.get("Bairro").equals(Utils.getValorFormulario("bairro", formulario))
				&& endereco.get("Cidade").equals(Utils.getValorFormulario("cidade", formulario))
				&& endereco.get("Estado").equals(Utils.getValorFormulario("uf", formulario)));
	}

	public Map<String, String> getEnderecoCorrespondencia() throws Exception {

		Map<String, Integer> cabecalho = new HashMap<>();
		Map<String, String> endereco = new HashMap<>();

		// Mapeamento dos campos da tabela de certificados
		WebElement tabelaCabecalho = sfGetElementByCss(cabecalhoTabelaEndereco);
		List<WebElement> thtabelaCabecalho = tabelaCabecalho.findElements(By.cssSelector("th"));

		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);

		}

		// Leitura dos campos das linhas de acordo com a validação desejada
		WebElement tabelaRegistros = sfGetElementByCss(registroEnderecoCliente);
		List<WebElement> tr = tabelaRegistros.findElements(By.cssSelector("tr"));

		for (WebElement linha : tr) {
			List<WebElement> td = linha.findElements(By.cssSelector("td"));

			if (td.get(cabecalho.get("End. Correspondência")).getText().equals("Sim")) {

				for (int index = 0; index < td.size(); index++) {
					endereco.put(thtabelaCabecalho.get(index).getText().trim(), td.get(index).getText().trim());
				}
			}

		}
		return endereco;

	}

}
