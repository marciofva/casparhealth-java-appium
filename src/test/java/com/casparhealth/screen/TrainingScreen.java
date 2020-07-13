package com.casparhealth.screen;

import java.util.ArrayList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TrainingScreen extends BaseScreen {
	
	@AndroidFindBy(id = "ready_button")
	private MobileElement readyBtn;
	
	@AndroidFindBy(id = "yes_button")
	private MobileElement yesBtn;

	@AndroidFindBy(id = "skip_button")
	private MobileElement skipBtn;
	
	@AndroidFindBy(id = "start_button")
	private MobileElement startBtn;
	
	@AndroidFindBy(id = "count_down_text")
	private MobileElement countDownText;
	
	@AndroidFindBy(id = "skip")
	private MobileElement skipModalBtn;
	
	@AndroidFindBy(id = "exercise_title_text")
	private MobileElement exerciseTitleText;
	
	@AndroidFindBy(id = "exercise_count_text")
	private MobileElement exerciseCountText;
	
	@AndroidFindBy(id = "exercise_progress_text")
	private MobileElement exerciseProgressText;
	
	public static final String GO = "GO";

	public TrainingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	private void moveForwardProcess() {
		clickOn(readyBtn);
		clickOn(yesBtn);
	}
	
	private void skipModal() {
		clickOn(skipBtn);
		clickOn(skipModalBtn);
	}

	public boolean isTrainingStarted() {
		moveForwardProcess();
		clickOn(startBtn);
		return waitFortextToBePresent(countDownText, GO);		
	}
	
	private int getCountExercises() {
		waitForElementVisibility(exerciseCountText);
		return Integer.parseInt(exerciseCountText.getText().trim());
	}
	
	public ArrayList<String> getAllTrainings() {
		int countExercises = getCountExercises();
		
		moveForwardProcess();
		
		ArrayList<String> list = new ArrayList<String>(); 
		
		for(int i=0; i < countExercises; i++) {

			list.add(getExerciseTitle());

			if (isVisible(skipBtn)) {
				skipModal();
			}
		}
		return list;
	}
	
	public String getExerciseTitle() {
		return exerciseTitleText.getText().trim();
	}
}
