package com.sqa.jf.core;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import com.sqa.jf.helpers.*;

public abstract class Core {

	protected WebDriver driver;
	private String baseURL;
	private Logger logger = Logger.getLogger(Core.class);

	public Core(WebDriver driver, String baseURL) {
		super();
		this.driver = driver;
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

	public abstract String getPropsLocation();

	public boolean isPresent(By locator) {
		return AutoBasics.isElementPresent(getDriver(), locator, getLogger());
	}

	public String pread(String property) {
		return AutoBasics.getProp(getPropsLocation(), property, getLogger());
	}

	public boolean takeScreenshot(String fileName) {
		fileName = fileName.replace(" ", "_");
		fileName = fileName.replace("*", "");
		fileName = fileName.replace("\"", "");
		fileName = fileName.replace(",", "");
		return AutoBasics.takeScreenshot(getDriver(), "screenshots/" + fileName, getLogger());
	}

	public boolean pwrite(String property, String value) {
		return AutoBasics.setProp(getPropsLocation(), property, value, this.logger, "Core Properties: " + getBaseURL());
	}
}
