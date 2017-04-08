package com.sqa.jf.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import com.sqa.jf.core.*;

public class BasicPage extends Core {

	public BasicPage(BasicTest test) {
		super(test.getDriver(), test.getBaseURL());
		PageFactory.initElements(getDriver(), this);
	}

	public BasicPage(WebDriver driver, String baseURL) {
		super(driver, baseURL);
		PageFactory.initElements(getDriver(), this);
	}

	@Override
	public String getPropsLocation() {
		return "src/main/resources/config.properties";
	}
}
