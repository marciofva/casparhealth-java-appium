package com.casparhealth.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends BaseScreen {
	
	@AndroidFindBy(id = "email_text")
	private MobileElement emailInput;
	
	@AndroidFindBy(id = "password_text")
	private MobileElement passwordInput;
	
	@AndroidFindBy(id = "login_button")
	private MobileElement loginBtn;

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public HomeScreen loginSystem(String emailOrId, String password) {
		sendValue(emailInput, emailOrId);
		sendValue(passwordInput, password);
		clickOn(loginBtn);
		return new HomeScreen(driver);
	}
}
