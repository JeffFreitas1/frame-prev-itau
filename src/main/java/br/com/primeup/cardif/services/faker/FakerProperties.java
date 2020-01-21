package br.com.primeup.cardif.services.faker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Classe que armazena as propriedades do serviço de faker, como mapping
 * @author Fernando Silva
 *
 */
@ConfigurationProperties("faker")
public class FakerProperties {

	private Map<String, String> mapping = new HashMap<>();

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	

	
}
