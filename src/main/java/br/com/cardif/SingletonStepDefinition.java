package br.com.cardif;

import br.com.cardif.services.faker.FakerService;

public class SingletonStepDefinition {

	private static SingletonStepDefinition instance;
	private FakerService fakerService;

	private SingletonStepDefinition() {
	}

	public static SingletonStepDefinition getInstance() {
		if (instance == null)
			instance = new SingletonStepDefinition();

		return instance;

	}

	public FakerService getFakerService() {
		return fakerService;
	}

	public void setFakerService(FakerService fakerService) {
		this.fakerService = fakerService;
	}

}
