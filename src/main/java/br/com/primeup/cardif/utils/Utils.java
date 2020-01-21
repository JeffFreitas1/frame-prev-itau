package br.com.primeup.cardif.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.poiji.bind.Poiji;

import br.com.primeup.cardif.testrules.TestRule;



public class Utils {

	public static void logPrint(String log) {
		ExtentTest extentTest = TestRule.getExtentTest();
		
		try {
			efetuarPrintTela(log);
			String screenshot = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder
					.createScreenCaptureFromBase64String(screenshot)
					.build();
			extentTest.log(Status.INFO, log, mediaModel);

		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}

	public static void logPrintPass(String log) {
		ExtentTest extentTest = TestRule.getExtentTest();
		try {
			efetuarPrintTela(log);
			String screenshot = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder
					.createScreenCaptureFromBase64String(screenshot)
					.build();
			extentTest.log(Status.PASS, log, mediaModel);

		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}

	public static void logPrintFail(String log) {
		ExtentTest extentTest = TestRule.getExtentTest();
		try {
			efetuarPrintTela(log);
			String screenshot = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder
					.createScreenCaptureFromBase64String(screenshot)
					.build();
			extentTest.log(Status.FAIL, log, mediaModel);

		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.ERROR, "Erro de execucao: " + e.getMessage());
		}
	}

	private static void efetuarPrintTela(String log) {

		try {
			TestRule.newPrint();
			File scrFile = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(TestRule.getPathCenarioEvidencia() + "\\" +TestRule.getQtdPrint()+log + ".png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void logError(Exception ex) {
		ExtentTest extentTest = TestRule.getExtentTest();
		if(ex.getCause()!=null) {
			extentTest.log(Status.ERROR, ex.getCause().getMessage());
		}else {
			extentTest.log(Status.ERROR, ex.getMessage());
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

	public static void logFail(String mensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.FAIL, mensagem);

	}
	
	public static void logInfo(String mensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.INFO, mensagem);

	}

	public static String getValorFormulario(String campoFormulario, List<Map<String, String>> formulario) {
		return formulario.stream().filter(campo -> campo.get("Campo").equals(campoFormulario)).findFirst().get()
				.get("Valor");
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
					FileUtils.copyFile(file, new File(TestRule.getPathCenarioEvidencia() + "\\"+file.getName()));
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
			System.out.println(folder.mkdir());
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
	public static void Validar(String campo1, String campo2, String coluna, PrintWriter gravarArq, int linha) throws IOException {

		if (campo1.equals(campo2)) {
				System.out.println("Linha  : "+ (linha + 2)+"  "+ coluna + " Valido->" + " Valor encontrado no site : " + campo1 + " valor recebido do arquivo :  "
					+ campo2  );
		} else {
			String log = String.format("Erro na linha : "+ (linha + 2)+"  "+ coluna + " Invalido->" + " Valor encontrado no site : " + campo1 + " valor recebido do arquivo :  "
					+ campo2  );
			gravarArq.println(log);
		}
	}
	public static void Validar1(String campo1, String campo2, String coluna, PrintWriter gravarArq) throws IOException {

		if (campo1.equals(campo2)) {
				System.out.println("Erro  "+coluna + " Valido->" + " Valor encontrado no site : " + campo1 + " valor recebido do arquivo :  "
					+ campo2  );
		} else {
			String log = String.format("Erro  "+ coluna + " Invalido->" + " Valor encontrado no site : " + campo1 + " valor recebido do arquivo :  "
					+ campo2  );
			gravarArq.println(log);
		}
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

	  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
	      throws Exception {

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

	  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
	      throws Exception {
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