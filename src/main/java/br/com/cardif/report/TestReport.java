package br.com.cardif.report;
//package br.com.cardif.report;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//
//import org.apache.poi.util.IOUtils;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//
//import br.com.cardif.utils.Utils;
//
//public class TestReport {
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		// final List<RegistroOficialPremioPendente> employeeList = new
//		// ArrayList<RegistroOficialPremioPendente>();
//		// String sheetPath = "C://temp//Relatorios
//		// Life//RELATORIO_RO1556645288305.xlsx";
//		String sheetPath = "C://temp//Relatorios Life//ArquivoUpload.xlsx";
//		String pathEvidencia = "C:\\TEMP\\Evidencias\\";
//		Utils.deleteTempFolder(pathEvidencia);
//
//	}
//
//	public static void closeInputStream(final InputStream inputStream) {
//		if (inputStream != null) {
//			try {
//				inputStream.close();
//			} catch (final IOException e) {
//				// logger.warn(e.getMessage(), e);
//				IOUtils.closeQuietly(inputStream);
//			}
//		}
//	}
//
//	public static RegistroOficialPremioPendente getObject(Row row) {
//		RegistroOficialPremioPendente roPendente = new RegistroOficialPremioPendente();
//		roPendente.setAgencCedido(getValueCell(row.getCell(0)));
//		roPendente.setAgencTotal(getValueCell(row.getCell(1)));
//		return roPendente;
//	}
//
//	public static void removeRow(int qtdRow, XSSFSheet dataSheet) {
//
//		for (int i = 0; i < qtdRow; i++) {
//			XSSFRow row = dataSheet.getRow(i);
//			if (row != null)
//				dataSheet.removeRow(row);
//
//		}
//		// Loop through every merged region in the sheet
//		for (int i = 0; i < dataSheet.getNumMergedRegions(); ++i) {
//			// Delete the region
//			dataSheet.removeMergedRegion(i);
//		}
//		dataSheet.removeMergedRegion(0);
//		dataSheet.shiftRows(qtdRow, dataSheet.getLastRowNum(), -qtdRow);
//
//		for (int nRow = 0; nRow <= dataSheet.getLastRowNum(); nRow++) {
//			final XSSFRow row = dataSheet.getRow(nRow);
//			if (row != null) {
//				String msg = "Row[rownum=" + row.getRowNum()
//						+ "] contains cell(s) included in a multi-cell array formula. "
//						+ "You cannot change part of an array.";
//				for (Cell c : row) {
//					((XSSFCell) c).updateCellReferencesForShifting(msg);
//				}
//			}
//		}
//	}
//
//	public static String getValueCell(Cell cell) {
//		String value = "";
//		switch (cell.getCellType()) {
//		case NUMERIC:
//			value = String.valueOf((long) cell.getNumericCellValue());
//			break;
//
//		default:
//			value = cell.getStringCellValue();
//			break;
//
//		}
//		return value;
//	}
//
//}
