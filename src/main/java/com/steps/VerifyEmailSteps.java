package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tools.ReadMailSample;

public class VerifyEmailSteps  extends ScenarioSteps {
	 private static final long serialVersionUID = 1L;

	ReadMailSample checkInMail = new ReadMailSample();

    @Step
	public void verifyEmail(String subject, String content) throws Exception {
		checkInMail.readMails(subject, content);
	}
}
