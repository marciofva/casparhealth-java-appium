package com.casparhealth.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {
	
	@AndroidFindBy(id = "my_training_arrow")
	private MobileElement myTrainingArrowBtn;
	
	@AndroidFindBy(id = "action_therapy_week")
	private MobileElement actionTherapyWeekMenu;
	
	@AndroidFindBy(id = "total_exercise_count_text")
	private MobileElement totalExerciseCountText;

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public TrainingScreen goToTrainingSection() {
		clickOn(myTrainingArrowBtn);
		return new TrainingScreen(driver);
	}
	
	public int getTotalExercises()  {
	waitForElementVisibility(myTrainingArrowBtn);
	return Integer.parseInt(totalExerciseCountText.getText().trim());
	}
	
	public TherapyWeekScreen visitWeeklyExercises() {
		clickOn(actionTherapyWeekMenu);
		return new TherapyWeekScreen(driver);
	}
}
