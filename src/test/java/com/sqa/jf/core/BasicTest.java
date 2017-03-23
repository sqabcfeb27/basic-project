package com.sqa.jf.core;

import java.util.concurrent.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;
import com.sqa.jf.helpers.*;

public abstract class BasicTest {

	private WebDriver driver;
	private String baseURL;
	private Logger logger = Logger.getLogger(BasicTest.class);

	public BasicTest(String baseURL) {
		super();
		this.baseURL = baseURL;
	}

	public String getBaseURL() {
		return this.baseURL;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLogger() {
		return this.logger;
	}

	@BeforeTest(enabled = false)
	public void setupChrome() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeTest(enabled = true)
	public void setupFirefox() {
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	}

	@BeforeTest(enabled = false)
	public void setupIE() {
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		this.driver = new InternetExplorerDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeTest(enabled = false)
	public void setupSafari() {
		this.driver = new SafariDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void setupTest() {
		this.driver.get(getBaseURL());
	}

	public boolean takeScreenshot(String fileName) {
		fileName = fileName.replace(" ", "_");
		fileName = fileName.replace("*", "");
		fileName = fileName.replace("\"", "");
		fileName = fileName.replace(",", "");
		return AutoBasics.takeScreenshot(getDriver(), "screenshots/" + fileName, getLogger());
	}
}
