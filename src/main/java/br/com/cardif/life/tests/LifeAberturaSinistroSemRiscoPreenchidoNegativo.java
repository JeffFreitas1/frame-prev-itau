package br.com.cardif.life.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "c:/temp/features/LifeAberturaSinistros/", tags = "@aberturasinistrocamporiscovazionegativo", glue = {
		"br.com.cardif.life.tests.steps", "br.com.cardif.testrules" }, monochrome = true, dryRun = false)
public class LifeAberturaSinistroSemRiscoPreenchidoNegativo {

}
