package br.com.cardif.life.map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cardif.utils.PageObjectUtils;

public class LifeRelatorioRepasseElementMap  extends PageObjectUtils{
	
	    //Relatorio vazio
		protected String mensagemRelatorio="//span[contains(.,'Nenhum contrato foi localizado com os filtros informados.')]";
		//Form
		protected String formularioRelatorio="//form[@id='frmTransferReport']";
		//Filtro
		protected String filtro="//legend[contains(.,'Filtro')]";
		
		@FindBy(xpath = "//input[@id='frmTransferReport:dtStart_input']")
		protected WebElement dataInicio;
		@FindBy(xpath = "//input[@id='frmTransferReport:dtEnd_input']")
		protected WebElement dataFim;
		@FindBy(xpath = "//button[@id='frmTransferReport:j_id_o']")
		protected WebElement botaoGerarRelatorio;
		
}
