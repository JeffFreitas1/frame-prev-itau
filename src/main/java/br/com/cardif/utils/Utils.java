package br.com.cardif.utils;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import br.com.cardif.SingletonStepDefinition;
import br.com.cardif.services.faker.FakerService;
import br.com.cardif.testrules.TestRule;

public class Utils {

	public static void logPrint(String log) {
		ExtentTest extentTest = TestRule.getExtentTest();

		try {
			efetuarPrintTela(log);
//			String screenshot = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
//			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot)
//					.build();
//			extentTest.log(Status.INFO, log, mediaModel);
			extentTest.log(Status.INFO, "Print: " +log);

		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}

	public static void logPrint(String log, WebDriver webDriver, String pathCenarioEvidencia, ExtentTest extentTest) {

		try {
			efetuarPrintTela(log, webDriver, pathCenarioEvidencia);
			String screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot)
					.build();
			extentTest.log(Status.INFO, log, mediaModel);

		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}
	
	
	public static void logPrintFullScreen(String log) {
		ExtentTest extentTest = TestRule.getExtentTest();

		try {
			efetuarPrintFullScreen(log);
			extentTest.log(Status.INFO, "Print: " +log);


		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}
	
	

	public static void logPrintPass(String log) {
		ExtentTest extentTest = TestRule.getExtentTest();
		try {
			efetuarPrintTela(log);
//			String screenshot = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
//			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot)
//					.build();
//			extentTest.log(Status.PASS, log, mediaModel);
			extentTest.log(Status.PASS, "Print: " +log);

		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}

	public static void logPrintFail(String log) {
		ExtentTest extentTest = TestRule.getExtentTest();
		try {
			efetuarPrintTela(log);
//			String screenshot = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
//			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot)
//					.build();
//			extentTest.log(Status.FAIL, log, mediaModel);
			extentTest.log(Status.FAIL, "Print: " +log);

		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}
	
	public static Rectangle getScreenArea() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;

		return new Rectangle(0, 0, width, height);

	}

	private static void efetuarPrintTela(String log) {

		try {
			TestRule.newPrint();
			File scrFile = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(TestRule.getPathCenarioEvidencia() + "\\" +TestRule.getQtdPrint()+log + ".png"));
			PDFHelper.addTextScreenshot(log, Files.readAllBytes(scrFile.toPath()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void efetuarPrintFullScreen(String log) {

		try {
			TestRule.newPrint();
			// Pega tamanho da tela
			 Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
			 BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(dimen));
			 File scrFile = new File(TestRule.getPathCenarioEvidencia() + "\\" +TestRule.getQtdPrint()+log + ".png");
			 ImageIO.write(screencapture,"png",scrFile);
	      	 PDFHelper.addTextScreenshot(log, Files.readAllBytes(scrFile.toPath()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void efetuarPrintTela(String log, WebDriver webDriver, String pathCenarioEvidencia) {

		try {

			TestRule.newPrint();
			File scrFile = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(TestRule.getPathCenarioEvidencia() + "\\" +TestRule.getQtdPrint()+log + ".png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void logData(String[][] data) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.info(MarkupHelper.createTable(data));
	}

	public static void logPass(String mensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.PASS, mensagem);
	}

	public static void logPass(String mensagem, ExtentTest extentTest) {
		extentTest.log(Status.PASS, mensagem);
	}

	public static void logFail(String mensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.FAIL, mensagem);

	}

	public static void logFail(String mensagem, ExtentTest extentTest) {
		extentTest.log(Status.FAIL, mensagem);
	}
	
	public static void logInfo(String mensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.INFO, mensagem);

	}
	
	public static void logError(Exception ex) {
		ExtentTest extentTest = TestRule.getExtentTest();
		if(ex.getCause()!=null) {
			extentTest.log(Status.ERROR, ex.getCause().getMessage());
		}else {
			extentTest.log(Status.ERROR, ex.getMessage());
		}
    }

	public static String getValorFormulario(String campoFormulario, List<Map<String, String>> formulario) {
		return formulario.stream().filter(campo -> campo.get("Campo").equals(campoFormulario)).findFirst().get()
				.get("Valor");
	}

	public static List<Map<String, String>> getFieldFaker(List<Map<String, String>> formulario) {

		SingletonStepDefinition config = SingletonStepDefinition.getInstance();
		FakerService fakerService = config.getFakerService();

		List<Map<String, String>> form = formulario.stream().map(e -> {
			Map<String, String> map = new HashMap<>();
			for (Map.Entry x : e.entrySet()) {
				if (x.getKey().equals("Valor")) {
					String campo = x.getValue().toString();

					if (campo.startsWith("!") && campo.endsWith("()")) {
						String novoValor = fakerService.processValue(x.getValue().toString(),50);
						map.put("Valor", novoValor);
					} else {
						map.put("Valor", x.getValue().toString());
					}

				} else {
					map.put("Campo", x.getValue().toString());
				}

			}

			return map;
		}).collect(Collectors.toList());


		return form;
	}

	public static void removeCabecalhoRelatorioXls(File relatorio, String nomeRelatorio) {

		try {
			FileInputStream excelFile = new FileInputStream(relatorio);
			HSSFSheet dataSheet = null;
			int qtdRow = 3;

			HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
			dataSheet = workbook.getSheet(nomeRelatorio);
			for (int i = 0; i < 3; i++) {
				HSSFRow row = dataSheet.getRow(i);
				if (row != null)
					dataSheet.removeRow(row);

			}
			// Loop through every merged region in the sheet
			for (int i = 0; i < dataSheet.getNumMergedRegions(); ++i) {
				// Delete the region
				dataSheet.removeMergedRegion(i);
			}
			dataSheet.removeMergedRegion(0);
			dataSheet.shiftRows(qtdRow, dataSheet.getLastRowNum(), -qtdRow);
			// save file
			FileOutputStream out = new FileOutputStream(relatorio);
			workbook.write(out);
			out.close();
			workbook.close();

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}

	public static void removeCabecalhoRelatorioXlsx(File relatorio, String nomeRelatorio) {

		try {
			FileInputStream excelFile = new FileInputStream(relatorio);
			XSSFSheet dataSheet = null;
			int qtdRow = 3;

			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			dataSheet = workbook.getSheet(nomeRelatorio);
			for (int i = 0; i < 3; i++) {
				XSSFRow row = dataSheet.getRow(i);
				if (row != null)
					dataSheet.removeRow(row);

			}
			// Loop through every merged region in the sheet
			for (int i = 0; i < dataSheet.getNumMergedRegions(); ++i) {
				// Delete the region
				dataSheet.removeMergedRegion(i);
			}
			dataSheet.removeMergedRegion(0);
			dataSheet.shiftRows(qtdRow, dataSheet.getLastRowNum(), -qtdRow);

			for (int nRow = 0; nRow <= dataSheet.getLastRowNum(); nRow++) {
				final XSSFRow row = dataSheet.getRow(nRow);
				if (row != null) {
					String msg = "Row[rownum=" + row.getRowNum()
							+ "] contains cell(s) included in a multi-cell array formula. "
							+ "You cannot change part of an array.";
					for (Cell c : row) {
						((XSSFCell) c).updateCellReferencesForShifting(msg);
					}
				}
			}
			// save file
			FileOutputStream out = new FileOutputStream(relatorio);
			workbook.write(out);
			out.close();
			workbook.close();

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}

	public static File getRelatorio(String path) throws Exception {
		Thread.sleep(3000);
		File relatorio = null;
		try {
			File folder = new File(path);
			if (folder.isDirectory()) {
				File[] files = folder.listFiles();
				for (File file : files) {
					FileUtils.copyFile(file, new File(TestRule.getPathCenarioEvidencia() + "\\" + file.getName()));
					relatorio = file;
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return relatorio;
	}

	public static boolean deleteTempFiles(String path) {
		try {
			File folder = new File(path);
			if (folder.isDirectory()) {
				File[] files = folder.listFiles();
				for (File toDelete : files) {
					toDelete.delete();
				}
			}
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean deleteTempFolder(String path) {

		try {
			File folder = new File(path);
			if (folder.exists())
				FileUtils.deleteDirectory(folder);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static void createTempFolder(String path) {
		File folder = new File(path);
		if (!folder.exists())
			System.out.println("Diretorio criado: "+folder.getName()+folder.mkdir());
	}

	public static String createTempCenarioFolder(String path, String scenarioId) {
		String scenarioFolder = "";
		try {
			File folder = new File(path);
			if (folder.isDirectory()) {
				boolean sucess = (new File(path.concat(scenarioId)).mkdir());
				if (sucess)
					scenarioFolder = path.concat(scenarioId);
			}
			return scenarioFolder;

		} catch (Exception e) {
			return "";
		}
	}

	public static boolean campoValido(String valor, String campo) {

		try {
			switch (valor) {
			case "PREENCHIDO":
				return (!campo.isEmpty());
			case "VAZIO":
				return campo.isEmpty();
			default:
				return (campo.equals(valor));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;

		fileWriter = new FileOutputStream(destZipFile);
		zip = new ZipOutputStream(fileWriter);

		addFolderToZip("", srcFolder, zip);
		zip.flush();
		zip.close();
	}

	static private void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws Exception {

		File folder = new File(srcFile);
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFile);
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
			while ((len = in.read(buf)) > 0) {
				zip.write(buf, 0, len);
			}
		}
	}

	static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);

		for (String fileName : folder.list()) {
			if (path.equals("")) {
				addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
			} else {
				addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
			}
		}
	}

}