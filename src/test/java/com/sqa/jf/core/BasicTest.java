package com.sqa.jf.core;

import java.util.concurrent.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

public abstract class BasicTest extends Core {

	public BasicTest(String baseURL) {
		super(null, baseURL);
	}

	@AfterTest
	public void closeDriver() {
		this.driver.quit();
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
		getDriver().get(getBaseURL());
	}
}
