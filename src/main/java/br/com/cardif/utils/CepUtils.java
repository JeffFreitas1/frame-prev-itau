package br.com.cardif.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CepUtils {
	
	public static String generateCEP() {
		
		List<String> enderecos = new ArrayList<>();
		//Sul
		enderecos.add("80030-000");
		enderecos.add("81050-360");
		enderecos.add("91040-650");
		
		//Suldeste
		enderecos.add("05311-010");
		enderecos.add("31310-630");
		enderecos.add("21340-380");
		
		//CentroOeste
		enderecos.add("79093-330");
		enderecos.add("78043-386");
		enderecos.add("77018-386");
		
		//Norte
		enderecos.add("69093-091");
		enderecos.add("69909-804");
		enderecos.add("76801-293");
		
		//Nordeste
		enderecos.add("41390-270");
		enderecos.add("64082-013");
		enderecos.add("60745-698");
		
		Random cep  = new Random();
		
		return enderecos.get(cep.nextInt((enderecos.size() - 1) + 1) + 0);
	}

}
