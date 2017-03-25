package com.sqa.jf.core;

import org.testng.annotations.*;

public abstract class LoginTest extends BasicTest {

	public LoginTest(String baseURL) {
		super(baseURL);
	}

	public abstract void logIn();

	public abstract void logOut();

	@AfterMethod
	public void logOutTest() {
		logOut();
	}

	@BeforeMethod
	@Override
	public void setupTest() {
		super.setupTest();
		logIn();
	}
}
