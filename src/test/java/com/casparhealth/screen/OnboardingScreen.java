package com.casparhealth.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingScreen extends BaseScreen {
	
	@AndroidFindBy(id = "login_button")
	private MobileElement loginBtn;
	
	public OnboardingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public LoginScreen goToLogin() {
		clickOn(loginBtn);
		return new LoginScreen(driver);
	}
}
