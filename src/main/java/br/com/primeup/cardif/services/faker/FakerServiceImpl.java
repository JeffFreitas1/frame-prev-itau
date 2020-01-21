package br.com.primeup.cardif.services.faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;


import br.com.primeup.cardif.utils.CPFUtils;
import br.com.primeup.cardif.utils.StringUtils;

@Service
public class FakerServiceImpl implements FakerService {
	private final Faker faker = new Faker(new Locale("pt", "BR"));
	

	@Override
	public String processValue(String value, int maxSize) {

		return getValue(value, maxSize, true);
	}

	@Override
	public String processValue(String formula) {

		return getValueFormula(formula);
	}

	@Override
	public String getValueDate(String regraData, SimpleDateFormat formatDate, String dataReferencia) {
		
		return getValueDateFormula(regraData, formatDate, dataReferencia);
	}

	@Override
	public String getValueDate(SimpleDateFormat formatDate, Date dataIni, Date dataFim) {
		
		return getDateRandom(formatDate,dataIni,dataFim);
	}
	
	@Override
	public String getValueDate(SimpleDateFormat formatDate, int size ,boolean valid) {
		
		return getDateRandom(formatDate,size,valid);
	}

	private String getValueDateFormula(String regraData, SimpleDateFormat formatDate, String dataReferencia) {
		String valorData = null;
		String condicao = regraData.substring(regraData.indexOf("("), regraData.indexOf(")") + 1);
		Matcher matchCampo = Pattern.compile("(\\w+)").matcher(condicao);
		Date dataLimite = new Date();

		// Atribuicao do campo gerar idade
		matchCampo.find();
		String campoData = matchCampo.group(0);

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {

			engine.put(campoData, "");
			engine.eval(
					"function regraData() {" + "do{" + campoData + "= Math.floor(Math.random() * (100 - 0 + 1)) + 0;"
							+ "}while(!" + condicao + ")" + "return parseInt("+campoData+");}");

			Invocable invocable = (Invocable) engine;
			Object funcResult = invocable.invokeFunction("regraData");
			// Retorno de idade
			if (regraData.contains("!I")) {
				valorData = funcResult.toString().replace(".0","");
			} else if (regraData.contains("!D")) {

				if (!dataReferencia.isEmpty()) {
					dataLimite = formatDate.parse(dataReferencia);
				} else {
					dataLimite.setTime(System.currentTimeMillis());
				}

				Date dataConvertida = new Date((long) (dataLimite.getTime())
						- (31556952000L * (long) Float.valueOf(funcResult.toString()).floatValue()));
				valorData = formatDate.format(dataConvertida);
			}

		} catch (Exception e) {
			return null;
		}

		return valorData;

	}

	private String getDateRandom(SimpleDateFormat formatDate, Date dataIni, Date dataFim) {
		
		
		Date randomDate;
		String data=null;
		
		try {
			randomDate = faker.date().between(dataIni, dataFim);
			data= formatDate.format(randomDate);
		}catch (Exception e) {
			return null;
		}
		
		return data;
	}
	
	private String getDateRandom(SimpleDateFormat formatDate, int size ,boolean valid) {
		
		Date randomDate = faker.date().between(new Date(1514772000000L), new Date(System.currentTimeMillis()));
		String value="";
		
		if (valid) {
			
			value = formatDate.format(randomDate);
		} else {
			formatDate.applyPattern("MMyyyyydd");
			
			value = formatDate.format(randomDate);
		}
		
		return value.length() > size ? value.substring(0, size) : value;
	}
	
	private String getValue(String value, int size, boolean valid) {
		Address a = null;

		switch (value.trim()) {
		case "!CPF()":
			if (valid) {
				return CPFUtils.geraCPF();
			} else {
				value = faker.number().digits(size);

				while (CPFUtils.validaCPF(value)) {
					value = faker.number().digits(size);
				}

			}
			break;
		case "!NOME()":
			if (valid) {
				Name name = faker.name();

				value = StringUtils.unAccent(name.firstName() + " " + name.lastName()).toUpperCase();
			} else {

				value = faker.regexify("[\\^|£]{" + String.valueOf(size) + "}");

			}
			break;
		case "!DATA()":
			Date randomDate = faker.date().between(new Date(1514772000000L), new Date(1524074970812L)); // between
			// 20180101
			// and
			// 20180418
			if (valid) {
				SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
				value = ft.format(randomDate);
			} else {
				SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyy");
				value = ft.format(randomDate);
			}
			break;
		case "!ENDERECO()":
			if (valid) {
				a = faker.address();
				value = StringUtils.unAccent(a.streetName() + " " + a.buildingNumber() + " ").toUpperCase();
			} else {

				value = faker.regexify("[\\^|£]{" + String.valueOf(size) + "}");

			}
			break;
		case "!BAIRRO()":
			if (valid) {
				a = faker.address();
				value = StringUtils.unAccent(a.streetSuffix()).toUpperCase();
			} else {

				value = faker.regexify("[\\^|£]{" + String.valueOf(size) + "}");

			}
			break;
		case "!CIDADE()":
			if (valid) {
				a = faker.address();
				value = StringUtils.unAccent(a.city()).toUpperCase();

			} else {

				value = faker.regexify("[\\^|£]{" + String.valueOf(size) + "}");

			}
			break;
		case "!ESTADO()":
			if (valid) {
				a = faker.address();
				value = StringUtils.unAccent(a.stateAbbr()).toUpperCase();
			} else {

				value = faker.regexify("[\\^|£]{" + String.valueOf(size) + "}");

			}
			break;
		case "!CEP()":
			if (valid) {
				a = faker.address();
				value = StringUtils.removeCaracteresEspeciais(StringUtils.unAccent(a.zipCode()).toUpperCase());
			} else {
				value = faker.regexify("[a-zA-Z]{" + String.valueOf(size) + "}");
			}
			break;
		case "!DDD()":
			if (valid) {
				value = faker.number().digits(2).toString();
			} else {
				value = faker.regexify("[a-zA-Z]{" + String.valueOf(size) + "}");
			}
			break;
		case "!TELEFONE()":
			if (valid) {
				value = faker.number().digits(8).toString();
			} else {
				value = faker.regexify("[a-zA-Z]{" + String.valueOf(size) + "}");
			}
			break;
		case "!CNPJ()":
			if (valid) {
				value = CPFUtils.cnpj(false);
			} else {
				value = faker.regexify("[a-zA-Z]{" + String.valueOf(size) + "}");

			}
			break;
		case "!NUMBER()":
			if (valid) {
				value = faker.number().digits(size).toString();
			} else {
				value = faker.regexify("[a-zA-Z]{" + String.valueOf(size) + "}");
			}
			break;
		case "!ALFA()":
			if (valid) {
				value = faker.regexify("[a-zA-Z0-9]{" + String.valueOf(size) + "}");
			} else {
				value = faker.regexify("[\\^|£]{" + String.valueOf(size) + "}");
			}
			break;
		default:
			break;
		}

		return value.length() > size ? value.substring(0, size) : value;
	}

	private String getValueFormula(String formula) {

		String resultado = null;
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		try {

			engine.eval("function regraTemplate() {" + "var valor=" + formula + ";" + "if(valor<0 || valor == Infinity)"
					+ "valor=null;" + "return valor.toFixed(2);" + "}");
			Invocable invocable = (Invocable) engine;
			Object funcResult = invocable.invokeFunction("regraTemplate");
			resultado = funcResult.toString().replace(".", "");

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;
		}

		return resultado;
	}

}
