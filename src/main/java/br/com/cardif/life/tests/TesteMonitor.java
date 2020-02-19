package br.com.cardif.life.tests;

import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class TesteMonitor {
	@Test
	public void testeMonitor () {
		//System.setProperty("webdriver.gecko.driver", "C:\\Temp\\driver\\geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.get("http://www.google.com");

		
		
	}

}
