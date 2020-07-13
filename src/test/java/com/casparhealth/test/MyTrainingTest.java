package com.casparhealth.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTrainingTest extends BaseTest {
	
	@Test
	public void shouldStartNewTraining() {
		
		//Check if the training has been started
		Assert.assertTrue(home.goToTrainingSection().isTrainingStarted());
	}

	@Test
	public void shouldShowAllAvailableTrainings() {
	
		//Check if the total of training showed in home screen matches the total of exercises available
		Assert.assertEquals(home.getTotalExercises(), home.goToTrainingSection().getAllTrainings().size());
	}
}
