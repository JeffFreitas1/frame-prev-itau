package br.com.primeup.cardif.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

	public static WebDriver driver;
	public static WebDriverWait wait;
	private static Actions action;
	private static String sfHighlightStyleTemp = "";
	private static String sfHighlightFieldTemp = "";
	private static WebElement sfHighlightElementTemp;

	public static void abrirURL(String strURL) {
		driver.get(strURL);
	}

	public static int sfGetXPathCount(String xpath) {
		int count = 0;
		try {
			count = driver.findElements(By.xpath(xpath)).size();
			return count;
		} catch (Exception ex) {
			return count;
		}
	}

	public static void sfSendText(String fieldName, String textFind) throws Exception {
		sfStepConfig(500, fieldName);
		sfGetElement(fieldName).clear();
		sfGetElement(fieldName).sendKeys(textFind);
	}

	public static void sfSendText(WebElement fieldName, String textSend) throws Exception {
		sfStepConfig(500, fieldName);
		fieldName.clear();
		fieldName.sendKeys(textSend);
	}

	public static void sfClick(String fieldName) throws Exception {
		sfStepConfig(500, fieldName);
		sfGetElement(fieldName).click();
	}

	public static void sfClick(WebElement element) throws Exception {
		sfStepConfig(500, element);
		element.click();
	}

	public static void sfDoubleClick(WebElement element) throws Exception {
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.doubleClick(element);
		action.perform();
	}

	public static void sfDoubleClick(String fieldName) throws Exception {
		sfStepConfig(200, fieldName);
		Actions action = new Actions(driver);
		action.doubleClick(sfGetElement(fieldName));
		action.perform();
	}

	public static void sfStepConfig(int time, String field) throws Exception {
		Thread.sleep(time);
		sfInternalHighlightClear();
		sfInternalHighlightClearElement();
		sfInternalHighlightElement(field);
	}

	public static void sfStepConfig(int time, WebElement element) throws Exception {
		Thread.sleep(time);
		sfInternalHighlightClear();
		sfInternalHighlightClearElement();
		sfInternalHighlightElement(element);
	}

	public static void sfInternalHighlightClear() throws Exception {
		if (!sfHighlightFieldTemp.isEmpty()) {
			try {
				sfSetJavaScriptExecute("arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "')",
						sfGetElement(sfHighlightFieldTemp));
			} catch (Exception ex) {
			}
		}
	}

	public static void sfInternalHighlightClearElement() throws Exception {
		if (!(sfHighlightElementTemp == null)) {
			try {
				sfSetJavaScriptExecute("arguments[0].setAttribute('style', '" + sfHighlightStyleTemp + "')",
						sfHighlightElementTemp);
			} catch (Exception ex) {
			}
		}
	}

	public static void sfInternalHighlightElement(String fieldName) {
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

	public static void sfInternalHighlightElement(WebElement element) {
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

	public static String sfGetAttributeValue(String fieldName, String attribute) throws Exception {
		return sfGetElement(fieldName).getAttribute(attribute);
	}

	public static String sfGetAttributeValue(WebElement element, String attribute) throws Exception {
		return element.getAttribute(attribute);
	}

	public static void sfSetJavaScriptExecute(String codeScript) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(codeScript);
		}
	}

	public static void sfSetJavaScriptExecute(String codeScript, Object args) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(codeScript, args);
		}
	}

	public static WebElement sfGetElement(String field) throws Exception {

		try {
			return driver.findElement(By.xpath(field));
		} catch (Exception ex) {
			return null;
		}
	}

	public static WebElement sfGetElementByCss(String field) throws Exception {
		try {
			return driver.findElement(By.cssSelector(field));
		} catch (Exception ex) {
			return null;
		}
	}
	public static void sfMoveToElementClickCss(String fieldName) throws Exception
	{
		Thread.sleep(1000);
		action= new Actions(driver);
		hoverClick.accept(By.cssSelector(fieldName));
	}
	public static boolean sfIsElementPresent(String fieldName) throws Exception {
		if (sfGetElement(fieldName) == null)
			return false;
		else
			return true;

	}

	public static boolean sfIsElementPresent(WebElement element) throws Exception {
		if (element.isDisplayed())
			return false;
		else
			return true;

	}
	
	public static void sfMoveScroll(String fieldName) throws Exception {
		WebElement scrollTable=sfGetElementByCss(".ui-datatable-scrollable-header");
		scrollTable.click();
        Actions move = new Actions(driver);
        move.moveToElement(scrollTable).clickAndHold();
        move.moveByOffset(500,0);
        move.release();
        move.perform();
	}

	public static void sfMoveToElement(String fieldName) throws Exception {
		sfStepConfig(300, fieldName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sfGetElement(fieldName));
	}

	public static void sfMoveToElement(WebElement element) throws Exception {
		sfStepConfig(300, element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void sfNavigateDropDownMenu(String menu) throws Exception {
		Thread.sleep(2000);
		action = new Actions(driver);
		hover.accept(By.xpath(menu));
	}

	public static void sfMoveToElementClick(String fieldName) throws Exception {
		Thread.sleep(1000);
		action = new Actions(driver);
		hoverClick.accept(By.xpath(fieldName));
	}

	public static void sfMoveToElementClick(WebElement element) throws Exception {
		Thread.sleep(1000);
		action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public static void waitLoading(String fieldName) throws Exception {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldName)));

	}

	public static void waitLoadingElement(WebElement element) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitElementInvisibility(String fieldName) throws Exception {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(fieldName)));
	}

	public static void waitLoadingText(WebElement element, String text) throws Exception {
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	public static void waitLoadingTextValue(WebElement element, String text) throws Exception {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void waitLoadPage() {
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static void sfSwitchFrame(String frame) {
		driver.switchTo().frame(frame);
	}

	public static void sfSwitchAlertAccept() throws InterruptedException {
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public static void sfZoomIn() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ADD);
		robot = null;
		Thread.sleep(2000);
	}

	public static void sfZoomOut() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot = null;
		Thread.sleep(2000);
	}

	public static void sfSwitchDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public static void sfPrintScreenSwitchFrame(String frame, String log) {
		sfSwitchDefaultFrame();
		Utils.logPrint(log);
		sfSwitchFrame(frame);
	}

	public static String sfGetText(String fieldName) throws Exception {
		sfStepConfig(300, fieldName);
		return sfGetElement(fieldName).getText();

	}

	public static String sfGetTextHiddenDisable(String fieldName) throws Exception {

		sfAttributeRemoveElement(fieldName, "disabled");
		sfAttributeRemoveElement(fieldName, "type");
		sfStepConfig(300, fieldName);
		return sfGetAttributeValue(fieldName, "value");

	}

	public static String sfGetText(WebElement element) throws Exception {
		return element.getText();
	}

	public static String sfGetText(String fieldName, boolean highLight) throws Exception {
		if (highLight)
			sfStepConfig(300, fieldName);
		return sfGetElement(fieldName).getText();

	}
	
	
	public static String sfGetSelectOptionValue(String cssField) {
		// pegando o valor do select
		Select selectRisco = new Select(driver.findElement(By.cssSelector(cssField)));
		WebElement webL = selectRisco.getFirstSelectedOption();
		return webL.getAttribute("text");
	}

	public static void jsRadioButtonChecked(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementById('" + id + "').checked = true";
		js.executeScript(script);
	}

	public static void jsAttributeSet(String id, String attributename, String attributevalue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementById('" + id + "').setAttribute('" + attributename + "', '" + attributevalue
				+ "')";
		js.executeScript(script);
	}

	public static void jsAttributeRemove(String id, String attributename) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementById('" + id + "').removeAttribute('" + attributename + "','"
				+ attributename + "')";
		js.executeScript(script);
	}

	public static void sfAttributeRemoveElement(String fieldName, String attributename) {
		try {
			if (sfIsElementPresent(fieldName)) {
				sfSetJavaScriptExecute("arguments[0].removeAttribute('" + attributename + "', '" + attributename + "')",
						sfGetElement(fieldName));
			}
		} catch (Exception ex) {
		}
	}

	public String jsGetValue(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) js.executeScript("return document.getElementById('" + id + "').text");
		return value;
	}

	public String jsGetText(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) js.executeScript("return document.getElementById('" + id + "').value");
		return value;
	}

	static Consumer<By> hover = (By by) -> {
		action.moveToElement(driver.findElement(by)).perform();
	};

	static Consumer<By> hoverClick = (By by) -> {
		action.moveToElement(driver.findElement(by)).click().perform();
	};
}
