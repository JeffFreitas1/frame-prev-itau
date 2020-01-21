package br.com.primeup.cardif.utils;

import java.text.Normalizer;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public StringUtils() {
	}

	public static String unAccent(String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("");
	}

	public static String removeCaracteresEspeciais(String doc) {
		if (doc.contains(".")) {
			doc = doc.replace(".", "");
		}
		if (doc.contains("-")) {
			doc = doc.replace("-", "");
		}
		if (doc.contains("/")) {
			doc = doc.replace("/", "");
		}
		return doc;
	}

	public static String parserPorcent(String expressao) {

		double porcentagem;
		String resultadoExpressao = expressao;

		Matcher valores = Pattern.compile("\\d+(\\.\\d+)?%").matcher(expressao);

		while (valores.find()) {

			for (int j = 0; j < valores.groupCount(); j++) {

				Matcher valorConverter = Pattern.compile("(\\d+(\\.\\d+)?)%").matcher(valores.group(j));
				valorConverter.find();
				porcentagem = Double.parseDouble(valorConverter.group(1)) / 100;
				resultadoExpressao = resultadoExpressao.replace(valores.group(j), "" + porcentagem + "");

			}

		}

		return resultadoExpressao;
	}
	
	public static String DateTimeNow() {
		return OffsetDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
	}
	
	
	public static double converteNumero(Double valor) {	
		valor = valor/100;
		return valor;
	}
	
	public static String limparPontoEVirgula(String campo) {
		campo = campo.replace(",", "");
		campo = campo.replace(".", "");
		return campo;
	}
	
	public static String converterDecimalDoubleFormat(String campo) {
		campo = campo.replace(".", "");
		campo = campo.replace(",", ".");
		return campo;
	}
	
	public static String converterVirgulaParaPonto(String valor) {
		valor = valor.replace(",", ".");
		return valor;
	}
	public static String convertePontoParaVigurgula(String valor) {
		valor = valor.replace(".", ",");
		return valor;
	}
	public static String format2F(double x) {
	    return String.format("%.2f", x);
	}

	public static String format1F(double x) {
	    return String.format("%.1f", x);
	}
}