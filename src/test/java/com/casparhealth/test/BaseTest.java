package com.casparhealth.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.casparhealth.dataprovider.LoginCredentials;
import com.casparhealth.factory.DriverFactory;
import com.casparhealth.screen.HomeScreen;
import com.casparhealth.screen.OnboardingScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {
	
	public static AppiumDriver<MobileElement> driver;
	protected HomeScreen home;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "platform", "deviceName" })
	public void setup(String platform, String deviceName) {

		driver = DriverFactory.getInstance(platform, deviceName);
		home = new OnboardingScreen(driver).goToLogin()
											.loginSystem(LoginCredentials.patientUser().get("emailOrId"), 
														 LoginCredentials.patientUser().get("password"));
	}
	
	@AfterTest
	public void afterMethod() {
		driver.quit();
	}
}
