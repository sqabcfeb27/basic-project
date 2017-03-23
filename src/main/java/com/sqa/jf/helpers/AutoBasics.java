package com.sqa.jf.helpers;

import java.io.*;
import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

public class AutoBasics {

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
