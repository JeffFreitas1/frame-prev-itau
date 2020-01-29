package br.com.cardif;

import java.util.List;

import br.com.cardif.life.report.RegistroGrafica;
import br.com.cardif.services.faker.FakerService;

public class SingletonStepDefinition {

	private static SingletonStepDefinition instance;
	private FakerService fakerService;
	private List<RegistroGrafica> listRegistroGrafica;
	private RegistroGrafica report;

	private SingletonStepDefinition() {
		listRegistroGrafica = loadReportGrafica();
	}

	public static SingletonStepDefinition getInstance() {
		if (instance == null)
			instance = new SingletonStepDefinition();

		return instance;

	}
	
	private List<RegistroGrafica> loadReportGrafica(){
		report = new RegistroGrafica();
		return report.registrosGrafica("C:\\temp\\Arquivo Upload\\Massa_Grafica.xlsx");
				
	}
	
	public List<RegistroGrafica> getListRegistroGrafica(){
		return listRegistroGrafica;
	}

	public FakerService getFakerService() {
		return fakerService;
	}

	public void setFakerService(FakerService fakerService) {
		this.fakerService = fakerService;
	}

}
