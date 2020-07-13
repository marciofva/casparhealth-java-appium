package com.casparhealth.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WeeklyKnowledgeTest extends BaseTest {
	
	@Test
	public void shouldShowWeekKnowledgeVideo() {

		//Check if weekly knowledge video is available
		Assert.assertTrue(home.visitWeeklyExercises()
						.seeListOfWeeklyKnowledge()
						.accessWeeklyVideoKnowledgeDetail()
						.isVideoKnowledgeVisible());
	}
}
