package br.com.cardif.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectUtils {

	public WebDriver driver;
	public WebDriverWait wait;
	private Actions action;
	private String sfHighlightStyleTemp = "";
	private String sfHighlightFieldTemp = "";
	private WebElement sfHighlightElementTemp;
	private String winHandleBefore;
	private Random random = new Random();

	public void sfMoveToElementClickCss(String fieldName) throws Exception {
		waitLoadingCss(fieldName);
		action = new Actions(driver);
		hoverClick.accept(By.cssSelector(fieldName));
	}

	public void abrirURL(String strURL) {
		driver.get(strURL);
	}

	public void jsAttributeSet(String id, String attributename, String attributevalue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementById('" + id + "').setAttribute('" + attributename + "', '" + attributevalue
				+ "')";
		js.executeScript(script);
	}

	public void jsAttributeRemove(String id, String attributename) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementById('" + id + "').removeAttribute('" + attributename + "','"
				+ attributename + "')";
		js.executeScript(script);
	}

	public int sfGetXPathCount(String xpath) {
		int count = 0;
		try {
			count = driver.findElements(By.xpath(xpath)).size();
			return count;
		} catch (Exception ex) {
			return count;
		}
	}

	public void sfSendText(String fieldName, String textFind) throws Exception {
		waitLoadPage();
		sfStepConfig(500, fieldName);
		sfGetElement(fieldName).clear();
		sfGetElement(fieldName).sendKeys(textFind);
	}

	public void sfSendText(WebElement fieldName, String textSend) throws Exception {
		waitLoadPage();
		sfStepConfig(500, fieldName);
		fieldName.clear();
		fieldName.sendKeys(textSend);
	}

	public void jsSendText(WebElement fieldName, String textSend) throws Exception {
		waitLoadPage();
		sfStepConfig(500, fieldName);
		sfSetJavaScriptExecute("arguments[0].value='" + textSend + "'", fieldName);
	}

	public void sfClick(String fieldName) throws Exception {
		waitLoadPage();
		sfStepConfig(500, fieldName);
		sfGetElement(fieldName).click();
	}

	public void sfClick(WebElement element) throws Exception {
		waitLoadPage();
		sfStepConfig(1000, element);
		element.click();
	}

	public void sfClickElementPresentOtherElement(String element, String findElement) throws Exception {
		sfGetElement(element).findElement(By.xpath(findElement)).click();
	}

	public void sfClickRandomOption(List<WebElement> modelos) throws Exception {

		int indice = 0;

		if (modelos.size() != 0) {
			indice = random.nextInt((modelos.size() - 0) + 1) + 0;
			indice = (indice == modelos.size()) ? (indice - 1) : indice;
		}

		sfStepConfig(500, modelos.get(indice));
		modelos.get(indice).click();
	}

	public void sfDoubleClick(WebElement element) throws Exception {
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.doubleClick(element);
		action.perform();
	}

	public void sfDoubleClick(String fieldName) throws Exception {
		sfStepConfig(200, fieldName);
		Actions action = new Actions(driver);
		action.doubleClick(sfGetElement(fieldName));
		action.perform();
	}

	public void sfStepConfig(int time, String field) throws Exception {
		Thread.sleep(time);
		sfInternalHighlightClear();
		sfInternalHighlightClearElement();
		sfInternalHighlightElement(field);
	}

	public void sfStepConfig(int time, WebElement element) throws Exception {
		Thread.sleep(time);
		sfInternalHighlightClear();
		sfInternalHighlightClearElement();
		sfInternalHighlightElement(element);
	}

	public void sfInternalHighlightClear() throws Exception {
		if (!sfHighlightFieldTemp.isEmpty()) {
			try {
				sfSetJavaScriptExecute("arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "')",
						sfGetElement(sfHighlightFieldTemp));
			} catch (Exception ex) {
			}
		}
	}

	public void sfInternalHighlightClearElement() throws Exception {
		if (!(sfHighlightElementTemp == null)) {
			try {
				sfSetJavaScriptExecute("arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "')",
						sfHighlightElementTemp);
			} catch (Exception ex) {
			}
		}
	}

	public void sfInternalHighlightElement(String fieldName) {
		try {
			if (sfIsElementPresent(fieldName)) {
				sfSetJavaScriptExecute("arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "')",
						sfGetElement(fieldName));
			}
			sfHighlightStyleTemp = sfGetAttributeValue(fieldName, "style");

			sfHighlightFieldTemp = fieldName;
			sfSetJavaScriptExecute(
					"arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "outline: 4px solid yellow;')",
					sfGetElement(fieldName));

		} catch (Exception ex) {
		}
	}

	public void sfInternalHighlightElement(WebElement element) {
		try {
			if (sfIsElementPresent(element)) {
				sfSetJavaScriptExecute("arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "')", element);
			}
			sfHighlightStyleTemp = sfGetAttributeValue(element, "style");

			sfHighlightElementTemp = element;
			sfSetJavaScriptExecute(
					"arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "outline: 4px solid yellow;')",
					element);

		} catch (Exception ex) {
		}
	}

	public String sfGetAttributeValue(String fieldName, String attribute) throws Exception {
		return sfGetElement(fieldName).getAttribute(attribute);
	}

	public String sfGetAttributeValue(WebElement element, String attribute) throws Exception {
		return element.getAttribute(attribute);
	}

	public void sfSetJavaScriptExecute(String codeScript) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(codeScript);
		}
	}

	public void sfSetJavaScriptExecute(String codeScript, Object args) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(codeScript, args);
		}
	}

	public WebElement sfGetElement(String field) throws Exception {

		try {
			return driver.findElement(By.xpath(field));
		} catch (Exception ex) {
			return null;
		}
	}

	public WebElement sfGetElementPresentOtherElementCss(String element, String cssLocator) throws Exception {
		return sfGetElement(element).findElement(By.cssSelector(cssLocator));
	}

	public WebElement sfGetElementPresentOtherElementCss(WebElement element, String cssLocator) throws Exception {
		return element.findElement(By.cssSelector(cssLocator));
	}

	public List<WebElement> sfGetElementsByCss(String field) throws Exception {

		try {
			return driver.findElements(By.cssSelector(field));
		} catch (Exception ex) {
			return null;
		}
	}

	public List<WebElement> sfGetElementsByXpath(String field) throws Exception {

		try {
			return driver.findElements(By.xpath(field));
		} catch (Exception ex) {
			return null;
		}
	}

	public WebElement sfGetElementByCss(String field) throws Exception {
		try {
			return driver.findElement(By.cssSelector(field));
		} catch (Exception ex) {
			return null;
		}
	}

	public boolean sfIsElementPresent(String fieldName) throws Exception {
		waitLoadPage();
		waitLoading(fieldName);
		if (sfGetElement(fieldName) == null)
			return false;
		else
			return true;
	}
	
	public boolean sfIsElementPresentCss(String fieldName) throws Exception {
		waitLoadPage();
		if (sfGetElementCss(fieldName) == null)
			return false;
		else
			return true;
	}
	
	public boolean sfIsElementPresentOtherElement(String element, String findElement) throws Exception {
		return sfGetElement(element).findElement(By.xpath(findElement)).isEnabled();
	}

	public boolean sfIsElementPresent(WebElement element) throws Exception {

		return element.isDisplayed();

	}

	public boolean sfIsElementEnable(WebElement element) throws Exception {
		return element.isEnabled();
	}

	public boolean sfIsElementEnable(String element) throws Exception {
		return sfGetElement(element).isEnabled();
	}

	public boolean sfIsElementSelected(WebElement element) throws Exception {
		return element.isSelected();
	}

	public String sfGetText(String fieldName) throws Exception {
		sfStepConfig(300, fieldName);
		return sfGetElement(fieldName).getText();

	}

	public String sfGetText(WebElement element) throws Exception {
		sfStepConfig(300, element);
		return element.getText();

	}

	public String sfGetTextHiddenDisable(String fieldName) throws Exception {

		sfAttributeRemoveElement(fieldName, "disabled");
		sfAttributeRemoveElement(fieldName, "type");
		sfStepConfig(300, fieldName);
		return sfGetAttributeValue(fieldName, "value");

	}

	public void sfAttributeRemoveElement(String fieldName, String attributename) {
		try {
			if (sfIsElementPresent(fieldName)) {
				sfSetJavaScriptExecute("arguments[0].removeAttribute('" + attributename + "', '" + attributename + "')",
						sfGetElement(fieldName));
			}
		} catch (Exception ex) {
		}
	}

	public void sfAttributeRemoveElement(WebElement fieldName, String attributename) {
		try {
			if (sfIsElementPresent(fieldName)) {
				sfSetJavaScriptExecute("arguments[0].removeAttribute('" + attributename + "', '" + attributename + "')",
						fieldName);
			}
		} catch (Exception ex) {
			System.out.println("Não foi possivel retirar atributo");
		}
	}

	public void sfSwitchAlertAccept() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public void sfZoomIn() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_ADD);
		robot = null;
		Thread.sleep(2000);
	}

	public void sfZoomOut() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot = null;
		Thread.sleep(2000);
	}

	public void sfMoveToElementClick(WebElement element) throws Exception {
		Thread.sleep(1000);
		action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void sfMoveToElement(String fieldName) throws Exception {
		sfStepConfig(300, fieldName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sfGetElement(fieldName));
	}

	public void sfMoveToElementClickJs(String fieldName) throws Exception {
		sfStepConfig(300, fieldName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sfGetElement(fieldName));
	}

	public void sfMoveToElementClickJs(WebElement element) throws Exception {
		sfStepConfig(300, element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void sfMoveToElement(WebElement element) throws Exception {
		sfStepConfig(300, element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String sfGetSelectOptionValue(String cssField) {
		// pegando o valor do select
		Select selectRisco = new Select(driver.findElement(By.cssSelector(cssField)));
		WebElement webL = selectRisco.getFirstSelectedOption();
		return webL.getAttribute("text");
	}

	public void sfNavigateDropDownMenu(String menu) throws Exception {
		Thread.sleep(1000);
		action = new Actions(driver);
		hover.accept(By.xpath(menu));
	}

	public void sfMoveToElementClick(String fieldName) throws Exception {
		waitLoading(fieldName);
		sfStepConfig(500, fieldName);
		action = new Actions(driver);
		hoverClick.accept(By.xpath(fieldName));
	}

	public void waitLoading(String fieldName) throws Exception {
		waitLoadPage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldName)));
	}

	public void waitFrameLoad() throws Exception {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	}

	public void waitLoadingElement(WebElement element) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitElementInvisibility(String fieldName) throws Exception {
		waitLoadPage();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(fieldName)));
	}

	public void waitLoadingText(WebElement element, String text) throws Exception {
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	public void waitLoadingTextValue(WebElement element, String text) throws Exception {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitLoadPage() throws Exception{
		//Thread.sleep(500);
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public void waitLoadingCss(String fieldName) throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(fieldName)));
	}

	public WebElement sfGetElementCss(String field) throws Exception {

		try {
			return driver.findElement(By.cssSelector(field));
		} catch (Exception ex) {
			return null;
		}
	}

	public void sfPrintScreenSwitchFrame(String frame, String log) {
		sfSwitchDefaultFrame();
		Utils.logPrint(log);
		sfSwitchFrame(frame);
	}

	public void sfSwitchFrame(String frame) {
		driver.switchTo().frame(frame);
	}
		

	public void sfSwitchDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public void sfSwitchBrowserPage() {
		// Store the current window handle
		winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void sfSwitchDefautBrowserPage() {
		// Perform the actions on new window
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	public Map<String, Integer> sfGetIndiceColunas(WebElement table) {
		Map<String, Integer> cabecalho = new HashMap<>();
		List<WebElement> thtabelaCabecalho = table.findElements(By.cssSelector("th"));
		for (int index = 0; index < thtabelaCabecalho.size(); index++) {
			cabecalho.put(thtabelaCabecalho.get(index).getText().trim(), index);
		}
		return cabecalho;
	}
	
	public void sfUploadFileCss(String path, String cssSelector, boolean hiddenElement) throws Exception {
		WebElement upload=sfGetElementCss(cssSelector);
		if(hiddenElement){
		  sfAttributeRemoveElement(upload, "disable");
		}
		sfSendText(upload, path);		
	}

	public void rbUploadFile(String path) throws Exception {
			
		
		File file = new File(path);
		StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		clipboard.getData(DataFlavor.stringFlavor);
		Robot robot = new Robot();
		robot.delay(10000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot = null;
		clipboard = null;

	}

	public void rbOkDownload() throws Exception {
		Robot robot = new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot = null;
	}

	public List<WebElement> sfGetListTable(WebElement table) {
		try {
			sfStepConfig(1000, table);
			return table.findElement(By.cssSelector("tbody")).findElements(By.cssSelector("tr"));
		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	public List<WebElement> sfGetColumListTable(WebElement table) {
		try {
			return table.findElements(By.cssSelector("th"));
		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	Consumer<By> hover = (By by) -> {
		action.moveToElement(driver.findElement(by)).perform();
	};

	Consumer<By> hoverClick = (By by) -> {
		action.moveToElement(driver.findElement(by)).click().perform();
	};
}
