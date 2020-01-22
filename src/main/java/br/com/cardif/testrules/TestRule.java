package br.com.cardif.testrules;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.cardif.utils.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
	public static int qtdframe;
	public static int qtdPrint;
	public static String frameName;
	protected static String pathCenarioEvidencia;
	protected static String pathDownloadArquivo;
	protected static String pathEvidencia;
	protected static String logDesktop = "";
	protected static Map<String, String> credenciaisLife;
	protected static Map<String, String> credenciaisUpload;
	protected static boolean failTest = false;

	@Before
	public void beforeCenario(Scenario cenario) throws Exception {

		// Inicialização do relatorio de testes
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		String cenarioId = cenario.getId().replaceFirst("(.+?);", "");
		pathDownloadArquivo = "C:\\TEMP\\Relatorios Life\\";

		if (failTest) {
			throw new Exception("Teste encerrado devido a falha");
		}

		String informacoes[] = cenario.getId().split(";");
		String nameFeature = informacoes[0];
		pathDownloadArquivo = "C:\\TEMP\\Relatorios Life\\";

		if (driver == null) {
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.download.dir", pathDownloadArquivo);
			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/csv, text/csv, text/plain,application/octet-stream doc xlsx pdf txt");
			firefoxProfile.setPreference("pdfjs.disabled", true);
			String usuario = System.getProperty("user.name");
			System.setProperty("webdriver.firefox.bin",
			"C:\\Users\\"+usuario+"\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

			// Inicialização das propriedades do navegador

			System.setProperty("webdriver.gecko.driver", "C:\\temp\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 5);
		}

		if (extentReport == null) {
			credenciaisLife = new HashMap<>();
			credenciaisLife.put("Usuario", "joaquina");
			credenciaisLife.put("Senha", "123");
			credenciaisUpload = new HashMap<>();
			credenciaisUpload.put("Usuario", "c92494");
			credenciaisUpload.put("Senha", "Primeup@2019");
			pathEvidencia = "C:\\temp\\Evidencias\\".concat(nameFeature + "-" + System.currentTimeMillis());
			Utils.createTempFolder(pathEvidencia);
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(pathEvidencia + "\\htmlReporter.html");
			htmlReporter.loadXMLConfig(new File("C:\\TEMP\\Config\\" + "\\extent-config.xml"), true);
			extentReport.attachReporter(htmlReporter);
		}

		extentTest = extentReport.createTest(cenarioId);
		pathCenarioEvidencia = Utils.createTempCenarioFolder(pathEvidencia.concat("\\"), cenarioId);
		if (pathCenarioEvidencia.isEmpty())
			throw new Exception("Diretorio de Evidencias não foi criado");
	}

	@After
	public void afterCenario(Scenario cenario) {

		if (cenario.isFailed()) {
			extentTest.log(Status.FAIL, "Cenario " + cenario.getName() + " executado com falhas");
			extentReport.flush();
			if(driver!=null && !driver.getCurrentUrl().isEmpty()) {
				Utils.logPrintFail("Falha na execução do teste");
				driver.quit();
				driver = null;
			}
			
			// failTest=true;
			logDesktop = logDesktop + "Cenario " + cenario.getName() + " executado com falhas" + "\n";

		} else {
			extentTest.log(Status.PASS, "Cenario " + cenario.getName() + " executado com sucesso");
			extentReport.flush();
			logDesktop = logDesktop + "Cenario " + cenario.getName() + " executado com sucesso" + "\n";
		}
		finishTest();
	}

	@After("@emissaoRelatorio")
	public void afterEmissaoRelatorio(Scenario cenario) {
		Utils.logPrint(cenario.getId());
	}

	public static void finishTest() {
		if (driver != null) {

			try {
				driver.quit();
			} catch (Exception e) {
				driver = null;
			}

		}



	}

	public static void newframe() {
		qtdframe++;
	}

	public static int getQtdFrame() {
		return qtdframe;
	}

	public static void clearQtdFrame() {
		qtdframe = 0;
	}

	public static void newPrint() {
		qtdPrint++;
	}

	public static String getQtdPrint() {
		return qtdPrint + "-";
	}

	public static void clearQtdPrint() {
		qtdPrint = 0;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriverWait getWaitDriver() {
		return wait;
	}

	public static ExtentTest getExtentTest() {
		return extentTest;
	}

	public static String getPathCenarioEvidencia() {
		return pathCenarioEvidencia;
	}

	public static String getPathDownloadArquivo() {
		return pathDownloadArquivo;
	}

	public static String getPathEvidencia() {
		return pathEvidencia;
	}

	public static Map<String, String> getCredenciaisLife() {
		return credenciaisLife;
	}

	public static Map<String, String> getCredenciaisUpload() {
		return credenciaisUpload;
	}

	public static void abrirURL(String strURL) {
		driver.get(strURL);
	}

	public static String getFrameName() {
		return frameName;
	}

	public static void setFrameName(String frameName) {
		TestRule.frameName = frameName;
	}

}
