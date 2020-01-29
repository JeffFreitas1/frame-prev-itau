package br.com.cardif.testrules;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assume;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.cardif.Home;
import br.com.cardif.SingletonStepDefinition;
import br.com.cardif.utils.PDFHelper;
import br.com.cardif.utils.SpecializedScreenRecorder;
import br.com.cardif.utils.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
	public static int qtdframe;
	public static int qtdCenario=0;
	public static int qtdPrint;
	public static String frameName;
	private static String pathCenarioEvidencia;
	private static String pathDownloadArquivo;
	private static String pathEvidencia;
	private static String logDesktop = "";
	private static Map<String, String> credenciaisLife;
	private static Map<String, String> credenciaisUpload;
	private static boolean failTest = false;
	private static boolean recordTest = false;
	boolean carga=false;
	private static ScreenRecorder screenRecorder;
	private static String recordPlace;
	private static Map<String, String> credenciaisPortalParceiro;
	private static Capabilities capabilities;

	public void setUpDriver(String driverName) throws Exception {

		switch (driverName.toLowerCase().trim()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\temp\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.addPreference("browser.download.folderList", 2);
			firefoxOptions.addPreference("disable-popup-blocking", true);
			//firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
			//firefoxOptions.addPreference("browser.download.dir", pathCenarioEvidencia);
//			firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
//					"application/csv, text/csv, text/plain,application/octet-stream doc xlsx pdf txt");
//			firefoxOptions.addPreference("pdfjs.disabled", true);
			
//			String usuario = System.getProperty("user.name");
//			System.setProperty("webdriver.firefox.bin",
//			"C:\\Users\\"+usuario+"\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

			// Inicialização das propriedades do navegador

			//System.setProperty("webdriver.gecko.driver", "C:\\temp\\driver\\geckodriver.exe");
			/*Servidor*/
			System.setProperty("webdriver.gecko.driver", "C:\\temp\\SeleniumServer\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxOptions);
									
			break;
		case "internetexplorer":
//			System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
			System.setProperty("webdriver.ie.driver", "C:\\temp\\SeleniumServer\\IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", "C:\\temp\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			throw new Exception("Nome do driver não encontrado: " + driverName);
		}

		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		capabilities = ((RemoteWebDriver) driver).getCapabilities();
	}

	@Before
	public void beforeCenario(Scenario cenario) throws Exception {

		
		qtdCenario++;
		//String cenarioFold= cenarioId.substring(0, 7);
		String cenarioFold= "CT-".concat(String.valueOf(qtdCenario));
		// Inicialização do relatorio de testes
		String cenarioId = cenarioFold+"-"+cenario.getId().replaceFirst("(.+?);", "");
		
	
	
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY");
	    TimeZone.setDefault(TimeZone.getTimeZone("America/Recife"));
	   	   	    
		if (failTest) {
			throw new Exception("Teste encerrado devido a falha");
		}

		String informacoes[] = cenario.getId().split(";");
		String nameFeature = informacoes[0];
		

		if (driver == null) {
			//setUpDriver("chrome");
			setUpDriver("firefox");
			//setUpDriver("internetexplorer");
		}
		

		if (extentReport == null) {
			credenciaisLife = new HashMap<>();
			credenciaisLife.put("Usuario", "joaquina");
			credenciaisLife.put("Senha", "123");
			credenciaisUpload = new HashMap<>();
			credenciaisUpload.put("Usuario", "c92494");
			credenciaisUpload.put("Senha", "Primeup@2019");
			credenciaisPortalParceiro = new HashMap<>();
			credenciaisPortalParceiro.put("Usuario", "90273915649");
			credenciaisPortalParceiro.put("Senha", "Cardif@2019");

			pathEvidencia = "C:\\temp\\Evidencias\\".concat(nameFeature + "-" + System.currentTimeMillis());
			Utils.createTempFolder(pathEvidencia);
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(pathEvidencia + "\\htmlReporter.html");
			htmlReporter.loadXMLConfig(new File("C:\\TEMP\\Config\\" + "\\extent-config.xml"), true);
			extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
			extentReport.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
			extentReport.setSystemInfo("Machine", "Windows 7" + " 64 Bit");
			extentReport.setSystemInfo("Ambiente", "Homologação");
			extentReport.setSystemInfo("Sistema", "http://saos101ws30t.br.xcd.net.intra:8080/partnerPortal");
			extentReport.setSystemInfo("Selenium", "3.9.1");
			extentReport.setSystemInfo("Maven", "4.0.0");
			extentReport.setSystemInfo("Java Version", "1.8.0_191");
			extentReport.attachReporter(htmlReporter);
			extentReport.setReportUsesManualConfiguration(false);
		
		}
		
		
		extentTest = extentReport.createTest(cenarioId);
		extentTest.assignAuthor("QA - Vitor-Reis");
		extentTest.assignDevice("Desktop");
		extentTest.getModel().setStartTime(new Date(System.currentTimeMillis()));
		
		if(carga) {
			cenarioFold = cenarioFold.concat("-"+System.currentTimeMillis());
		}
		
		pathCenarioEvidencia = Utils.createTempCenarioFolder(pathEvidencia.concat("\\"), cenarioFold);
		PDFHelper.initialize(pathCenarioEvidencia, cenarioFold, date);
		if (pathCenarioEvidencia.isEmpty())
		throw new Exception("Diretorio de Evidencias não foi criado");
					
			

		// GRAVANDO
		if (recordTest) {
			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration();

			screenRecorder = new SpecializedScreenRecorder(gc,
					new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, (int) 24, FrameRateKey,
							Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, (int) (15 * 60)),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
					null, new File(pathCenarioEvidencia), cenarioId);
			screenRecorder.start();
		}
	}

	@After
	public void afterCenario(Scenario cenario) throws Exception {

		switch (cenario.getStatus()) {
		case "passed":
			extentTest.log(Status.PASS, "Cenario " + cenario.getName() + " executado com sucesso");
			logDesktop = logDesktop + "Cenario " + cenario.getName() + " executado com sucesso" + "\n";
			PDFHelper.terminate(true);
			break;
		case "undefined":
			extentTest.log(Status.ERROR, "Cenario " + cenario.getName() + " não foi implementado");
			logDesktop = logDesktop + "Cenario " + cenario.getName() + " não foi implementado" + "\n";
			PDFHelper.terminate(false);
			break;

		case "pending":
			extentTest.log(Status.SKIP, " Cenario " + cenario.getName() + " não possui ação");
			logDesktop = logDesktop + "Cenario " + cenario.getName() + " não possui ação" + "\n";
			break;
		case "skipped":
			extentTest.log(Status.SKIP, " Cenario " + cenario.getName() + " não foi executado");
			logDesktop = logDesktop + "Cenario " + cenario.getName() + " não foi executado" + "\n";
			break;

		case "failed":
			extentTest.log(Status.FAIL, "Cenario " + cenario.getName() + " executado com falhas");

			if (driver != null && (!driver.getCurrentUrl().isEmpty())) {
				Utils.logPrintFail("Falha na execução do teste");
			}
			PDFHelper.terminate(false);
			// failTest=true;
			logDesktop = logDesktop + "Cenario " + cenario.getName() + " executado com falhas" + "\n";
			break;

		default:
			break;
		}

		if (recordTest) {
			screenRecorder.stop();

			List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();
			for (File movie : createdMovieFiles) {
				recordPlace = movie.getAbsolutePath();
			}
			extentTest.log(Status.INFO, "Video criado e armazenado em :" + recordPlace);
		}
		
		
		extentTest.getModel().setEndTime(new Date(System.currentTimeMillis()));
		extentReport.flush();
		driver.quit();
		driver = null;
		clearQtdPrint();
	}

	@Before("@cenario_pendente")
	public void cenarioPendente(Scenario cenario) {

		Assume.assumeTrue(false);
	}
	
	@Before("@cenario_manual")
	public void cenarioManual(Scenario cenario) {
		Assume.assumeTrue(false);
		extentTest.log(Status.SKIP, " Cenario " + cenario.getName() + " Manual");
		
	}

	public static void finishTest() {
		if (driver != null) {

			try {
				driver.quit();
			} catch (Exception e) {
				driver = null;
			}

		}

		Home.restore();
		Home.logar(logDesktop);

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

	public static Map<String, String> getCredenciaisPortalParceiro() {
		return credenciaisPortalParceiro;
	}

}
