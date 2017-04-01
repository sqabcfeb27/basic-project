package com.sqa.jf.helpers;

import java.io.*;
import java.util.*;
import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

public class AutoBasics {

	public static String getProp(String fileLocation, String property, Logger logger) {
		String value = "";
		Properties props = new Properties();
		try {
			FileInputStream input = new FileInputStream(fileLocation);
			props.load(input);
			value = props.getProperty(property);
		} catch (IOException e) {
			logger.warn("Can not read file for property " + property);
		}
		return value;
	}

	public static boolean isElementPresent(WebDriver driver, By locator, Logger logger) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			logger.info("Element was not found [" + locator + "]");
			return false;
		}
	}

	public static boolean setProp(String fileLocation, String property, String value, Logger logger,
			String propsHeader) {
		Properties props = new Properties();
		try {
			FileInputStream input = new FileInputStream(fileLocation);
			props.load(input);
		} catch (IOException e1) {
			logger.info("Can not read file to load stored properties, may be first attempt to create properties file.");
		}
		props.setProperty(property, value);
		try {
			FileOutputStream output = new FileOutputStream(fileLocation);
			props.store(output, propsHeader);
		} catch (IOException e) {
			logger.warn("Can not write file for property " + property);
			return false;
		}
		return true;
	}

	public static boolean takeScreenshot(WebDriver driver, String targetLocation, Logger logger) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(targetLocation + ".jpg"));
		} catch (IOException e) {
			logger.warn("Can not take screenshot for " + targetLocation + ".");
			return false;
		}
		logger.info("A screenshot has been taken for " + targetLocation + ".");
		return true;
	}
}
