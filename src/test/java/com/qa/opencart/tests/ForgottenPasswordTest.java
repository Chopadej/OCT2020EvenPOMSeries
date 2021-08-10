package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.pages.ForgottenPasswordPage;
import com.qa.democart.utils.Constants;
import com.qa.opencart.base.BaseTest;

public class ForgottenPasswordTest extends BaseTest {

	@Test(priority=3)
	public void verifyForgotPasswordTest() {
		String header= forgotPwd.isForgotYourPwdTextExist();
		System.out.println("Forgot page header :"+ header);
		Assert.assertEquals(header, Constants.FORGOT_PASSWORD_TEXT);
	}
	
	@Test(priority=1)
	public void enterForgottenPwdTest() {
		forgotPwd.doEnterEmailAddress(prop.getProperty("username"));
	}
	@Test(priority=2)
	public void clickOnContinueTest() {
		forgotPwd.doClickOnforgotPwd();
	}
}
