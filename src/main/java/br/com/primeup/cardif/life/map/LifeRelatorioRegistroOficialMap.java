package br.com.primeup.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.primeup.cardif.utils.PageObjectUtils;

public class LifeRelatorioRegistroOficialMap extends PageObjectUtils{
	
		// Frame
		protected String frameROPendente = "//legend[contains(.,'Filtro')]";
		//Parceiros
		protected String parceiro= "//div[9]/div/ul/li[normalize-space(text()) = '@PARCEIRO']";
		//Relatorio vazio
		protected String mensagem="//span[contains(.,'Nenhum registro de RO foi localizado com os filtros informados')]";
		@FindBy(xpath = "//label[@id='frmRoReport:selPartner_label']")
		protected WebElement listaParceiros;
		//Ramo de Atividade
		protected String ramoAtividade= "//div[10]/div/ul/li[normalize-space(text()) = '@RAMOATIVIDADE']";
		@FindBy(xpath = "//label[@id='frmRoReport:selLob_label']")
		protected WebElement listaRamosAtividade;
		@FindBy(xpath = "//input[@id='frmRoReport:txtStartDate_input']")
		protected WebElement dataPesquisa;
		@FindBy(xpath = "//button[@id='frmRoReport:ckTypeIndividual_input']")
		protected WebElement checkBoxIndividual;
		@FindBy(xpath = "//button[@id='frmRoReport:j_id_10']")
		protected WebElement botaoGerarRelatorioExcel;
		@FindBy(xpath = "//button[@id='frmRoReport:j_id_x']")
		protected WebElement botaoGerarRelatorioPDF;
		
		
}
