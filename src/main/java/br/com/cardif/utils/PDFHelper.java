package br.com.cardif.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.cardif.testrules.TestRule;

public class PDFHelper {

	private static Document doc;
	private static Document docWeb;
	private static String testName;
	private static String genPath;
	private static String genWeb;
	private static String dateCal;
	private static String onlyPath;
	private static String testNamePath;
	private static Boolean textNewPage;
	private static Boolean newPageToText;
	private static List<String> msgTotal = new ArrayList<String>();

	public static void initialize(String path, String tName, SimpleDateFormat date) {
		doc = new Document();
		docWeb = new Document(PageSize.A4.rotate());

		dateCal = date.format(new Date());

		textNewPage = true;
		onlyPath = "";

		try {
			testName = tName;

//			String[] pathSplit = path.split("/");
//
//			for (int i = 0; i < pathSplit.length - 1; i++) {
//				onlyPath = onlyPath.concat(pathSplit[i].concat("/"));
//			}
//
//			testNamePath = pathSplit[pathSplit.length - 1];
			testNamePath = TestRule.getPathCenarioEvidencia();
			onlyPath=path;
			
			genWeb = path+"\\_old.pdf";
			PdfWriter.getInstance(docWeb, new FileOutputStream(genWeb));
			
			docWeb.open();

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (DocumentException e) {
			// e.printStackTrace();
		}
	}

	public static void addText(String msg) {

		if (doc == null || docWeb == null)
			return;

		try {
			if (textNewPage) {
				docWeb.newPage();
				Paragraph p = new Paragraph(80, msg);
				p.setAlignment(Element.ALIGN_CENTER);
				docWeb.add(p);
				msgTotal.add("XxTestxX");
				textNewPage = false;
			} else {
				Paragraph p = new Paragraph(80, msg);
				p.setAlignment(Element.ALIGN_CENTER);
				docWeb.add(p);
				msgTotal.add("XxTestxX");
			}
		} catch (DocumentException e) {
			// e.printStackTrace();
		}

	}

	public static void addScreenshot(byte[] img) {

		if (doc == null || docWeb == null)
			return;

		try {

			Image docImg;

			docImg = Image.getInstance(img);
			docImg.scaleAbsolute(800, 400);

			float xImg = (PageSize.A4.rotate().getWidth() - docImg.getScaledWidth()) / 2;

			docImg.setAbsolutePosition(xImg, 40f);

			doc.newPage();
			docWeb.add(docImg);
			textNewPage = true;

		} catch (BadElementException e) {
			// e.printStackTrace();
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (DocumentException e) {
			// e.printStackTrace();
		}

	}

	public static void addTextScreenshot(String msg, byte[] img) {

		if (doc == null || docWeb == null)
			return;

		try {
			msgTotal.add(msg);

			Image docImg;
			

			docImg = Image.getInstance(img);
			docImg.scaleAbsolute(800, 400);

			float xImg = (PageSize.A4.rotate().getWidth() - docImg.getScaledWidth()) / 2;

			docImg.setAbsolutePosition(xImg, 10f);

			docWeb.newPage();
			docWeb.add(docImg);
			textNewPage = true;

		} catch (BadElementException e) {
			// e.printStackTrace();
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (DocumentException e) {
			// e.printStackTrace();
		}

	}

	public static void addTextScreenshot_(String msg, byte[] img) {

		if (doc == null || docWeb == null)
			return;

		try {
			msgTotal.add(msg);

			Image docImg;

			docImg = Image.getInstance(img);
			docImg.scaleAbsolute(800, 400);

			float xImg = (PageSize.A4.rotate().getWidth() - docImg.getScaledWidth()) / 2;

			docImg.setAbsolutePosition(xImg, 10f);

			docWeb.newPage();
			docWeb.add(docImg);
			textNewPage = true;

		} catch (BadElementException e) {
			// e.printStackTrace();
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (DocumentException e) {
			// e.printStackTrace();
		}

	}

	public static void takeScreenshotPDF(String name, byte[] screenshot) {
		if (doc == null || docWeb == null)
			return;

		try {

			byte[] img = screenshot;
			Image docImg;

			docImg = Image.getInstance(img);
			docImg.scaleAbsolute(800, 400);

			float xImg = (PageSize.A4.rotate().getWidth() - docImg.getScaledWidth()) / 2;

			docImg.setAbsolutePosition(xImg, 10f);

			docWeb.newPage();
			msgTotal.add(name);
			docWeb.add(docImg);
			textNewPage = true;
		} catch (BadElementException e) {
			// e.printStackTrace();
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (DocumentException e) {
			// e.printStackTrace();
		}

	}

	public static void headerPdf(Boolean testPassed, List<String> msgs) throws IOException {

		String status;

		File logoCardif = new File("C:\\temp\\Config\\cardif.png");
		File logPass = new File("C:\\temp\\Config\\hdGreen.png");
		File logFail = new File("C:\\temp\\Config\\hdRed.png");
	
		
		if (testPassed) {
			status = "PASSED_";
		} else {
			status = "FAILED_";
		}

		try {
			PdfReader reader = new PdfReader(genWeb);
						
//			PdfStamper stamper = new PdfStamper(reader,
//					new FileOutputStream(onlyPath + status + testNamePath + ".pdf"));
			PdfStamper stamper = new PdfStamper(reader,
					new FileOutputStream(testNamePath +"\\_"+status +".pdf"));
			BaseFont bf = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

			// **********
			msgs.add("");
			msgs.add("");
			
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				
				PdfContentByte override = stamper.getOverContent(i);
				Image logoInm;
				Image logoCustomer;
				newPageToText = true;

//				ClassLoader loader = Thread.currentThread().getContextClassLoader();
//				InputStream imageInm = loader.getResourceAsStream("C:\\temp\\Config\\cardif.png");
				
				
				
				logoInm = Image.getInstance(Files.readAllBytes(logoCardif.toPath()));
//				logoInm = Image.getInstance(StreamUtil.inputStreamToArray(imageInm));
				logoCustomer = Image.getInstance("C:\\temp\\Config\\cardif.png");

				
				
				logoInm.scaleAbsolute(150, 50);
				logoInm.setAbsolutePosition(10, PageSize.A4.rotate().getHeight() - logoInm.getScaledHeight() * 1.25f);

				logoCustomer.scaleAbsolute(150, 50);
				logoCustomer.setAbsolutePosition(PageSize.A4.rotate().getWidth() - logoCustomer.getScaledWidth() - 10,
						PageSize.A4.rotate().getHeight() - logoCustomer.getScaledHeight() * 1.40f);

				if (testPassed) {
					Image passed;

//					loader = Thread.currentThread().getContextClassLoader();
//					InputStream imagePassed = loader.getResourceAsStream("C:\\temp\\Config\\hdGreen.png");
										 
//					passed = Image.getInstance(StreamUtil.inputStreamToArray(imagePassed));
					passed = Image.getInstance(Files.readAllBytes(logPass.toPath()));
					
					passed.scaleAbsolute(1400, 75);
					passed.setAbsolutePosition(0, PageSize.A4.rotate().getHeight() - passed.getScaledHeight());
					override.addImage(passed);
				} else {
					Image failed;

//					loader = Thread.currentThread().getContextClassLoader();
//					InputStream imageFailed = loader.getResourceAsStream("C:\\temp\\Config\\hdRed.png");

//					failed = Image.getInstance(StreamUtil.inputStreamToArray(imageFailed));
					failed = Image.getInstance(Files.readAllBytes(logFail.toPath()));
					failed.scaleAbsolute(1400, 75);
					failed.setAbsolutePosition(0, PageSize.A4.rotate().getHeight() - failed.getScaledHeight());
					override.addImage(failed);
				}

				override.beginText();
				override.setFontAndSize(bf, 14);

				// Date
				override.showTextAlignedKerned(Element.ALIGN_CENTER, dateCal, PageSize.A4.rotate().getWidth() - 90,
						PageSize.A4.rotate().getHeight() - logoInm.getScaledHeight() - 40, 0f);
				override.endText();

				override.addImage(logoInm);
				override.addImage(logoCustomer);

				// TestName
				Rectangle testNameRect = new Rectangle(165, 530, logoCustomer.getAbsoluteX() + 3, 580);
				testNameRect.setBorder(Rectangle.BOX);
				override.rectangle(testNameRect);

				ColumnText ctTest = new ColumnText(override);
				ctTest.setSimpleColumn(testNameRect);
				Font courierFontTN = new Font(Font.FontFamily.COURIER, 14);
				Paragraph pTestName = new Paragraph(testName, courierFontTN);
				pTestName.setAlignment(Element.ALIGN_CENTER);
				ctTest.addElement(pTestName);
				ctTest.go();

				// LogInfo
				Rectangle rect = new Rectangle(20, 420, 820, 500);
				rect.setBorder(Rectangle.BOX);
				override.rectangle(rect);

				ColumnText ct = new ColumnText(override);
				ct.setSimpleColumn(rect);
				Font catFont = new Font(Font.FontFamily.COURIER, 12);

				while (i - i < msgs.size() && msgs.get(i - i).equals("XxTestxX")
						|| i - i < msgs.size() && msgs.get(i - i).equals("Exception on scenario execution")) {
					msgs.remove(i - i);

					if (newPageToText) {
						override = stamper.getOverContent(i + 1);
						newPageToText = false;
					}
				}

				if (i - i < msgs.size() && newPageToText) {
					Paragraph p = new Paragraph(msgs.get(i - i), catFont);
					p.setAlignment(Element.ALIGN_CENTER);
					ct.addElement(p);
					ct.go();
					msgs.remove(i - i);
				}
			}
			stamper.close();
			
			msgs.clear();

		} catch (BadElementException e) {
			// e.printStackTrace();
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (DocumentException e) {
			// e.printStackTrace();
		}

	}

	public static void terminate(boolean testResult) throws Exception {

		
		if (docWeb == null) {
			return;
		}
			
		try {
			docWeb.close();
			PdfReader reader = new PdfReader(genWeb);
			
			if (reader.getNumberOfPages() == 0) {
				docWeb = null;

				clearTempFile();
			} else {
				docWeb.close();
				headerPdf(testResult, msgTotal);
				docWeb = null;
				clearTempFile();
				
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	public static void clearTempFile() throws Exception {
		File file = new File(genWeb);
		if (file.exists()) {
			file.delete();
		}
	}
}