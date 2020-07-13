package com.casparhealth.screen;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen {

	private static final int MAX_TIMEOUT = 40;
	protected AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	public BaseScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		this.wait = new WebDriverWait(driver, MAX_TIMEOUT);
	}

	protected void sendValue(MobileElement element, CharSequence value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	protected void clickOn(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected MobileElement waitForElementVisibility(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	protected boolean waitFortextToBePresent(MobileElement element, String text) {
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean isVisible(MobileElement element) {
		this.wait = new WebDriverWait(driver, 3);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected void waitForVisibilityAllElements(List<MobileElement> elements) {
		for (MobileElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}
}
