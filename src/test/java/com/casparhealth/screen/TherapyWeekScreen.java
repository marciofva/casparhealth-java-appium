package com.casparhealth.screen;

import java.util.List;
import java.util.Random;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TherapyWeekScreen extends BaseScreen {

	@AndroidFindBy(id = "exercise_arrow")
	private MobileElement exerciseArrow;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[2]")
	private MobileElement knowledgeArrow;

	@AndroidFindBy(id = "name")
	private List<MobileElement> listVideoTrainingName;

	@AndroidFindBy(id = "duration")
	private List<MobileElement> listVideoKnowledgeDuration;
	
	@AndroidFindBy(id = "video")
	private MobileElement video;

	@AndroidFindBy(id = "yes_button")
	private MobileElement yesBtn;

	@AndroidFindBy(id = "start_button")
	private MobileElement startBtn;
	
	public TherapyWeekScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public TherapyWeekScreen seeListOfWeeklyExercises() {
		clickOn(exerciseArrow);
		return this;
	}
	
	public TherapyWeekScreen seeListOfWeeklyKnowledge() {
		clickOn(knowledgeArrow);
		return this;
	}
	
	public TherapyWeekScreen accessWeeklyVideoExerciseDetail() {
		waitForVisibilityAllElements(listVideoTrainingName);
		
		int randomIndex = new Random().nextInt(listVideoTrainingName.size());
		clickOn(listVideoTrainingName.get(randomIndex));
		
		clickOn(yesBtn);
		return this;
	}
	
	public boolean isVideoExerciseVisible() {
		return isVisible(startBtn);
	}
	
	public TherapyWeekScreen accessWeeklyVideoKnowledgeDetail() {
		waitForVisibilityAllElements(listVideoKnowledgeDuration);
		
		int randomIndex = new Random().nextInt(listVideoKnowledgeDuration.size());
		clickOn(listVideoKnowledgeDuration.get(randomIndex));
		
		return this;
	}

	public boolean isVideoKnowledgeVisible() {
		return isVisible(video);
	}
}
