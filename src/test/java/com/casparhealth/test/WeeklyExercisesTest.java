package com.casparhealth.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WeeklyExercisesTest extends BaseTest {
	
	@Test
	public void shouldShowWeeklyExerciseVideo() {

		//Check if weekly exercise video is available
		Assert.assertTrue(home.visitWeeklyExercises()
							  .seeListOfWeeklyExercises()
							  .accessWeeklyVideoExerciseDetail()
							  .isVideoExerciseVisible());
	}
}
