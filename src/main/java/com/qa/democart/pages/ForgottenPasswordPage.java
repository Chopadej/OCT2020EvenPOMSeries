package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class ForgottenPasswordPage {
	
	private ElementUtil elementUtil;
	
	//Page locator
	
	private By forgotPwdLink= By.xpath("//a[text()='Forgotten Password']");
	private By forgotYourPwd= By.cssSelector("div#content h1");
	private By emailAddress= By.id("input-email");
	private By clickOnContinue= By.xpath("//input[@type='submit']");
	

	public ForgottenPasswordPage(WebDriver driver) {
		elementUtil= new ElementUtil(driver);
	}
	
	//page actions
	public void doClickOnforgotPwd() {
		elementUtil.doClick(forgotPwdLink);
	}
	
	public String isForgotYourPwdTextExist() {
		if(elementUtil.doIsDisplayed(forgotYourPwd)) {
			return elementUtil.doGetText(forgotYourPwd);
		}
		return null;
				
	}
	
	public void doEnterEmailAddress(String un) {
		elementUtil.doSendKeys(emailAddress, un);
		elementUtil.doClick(clickOnContinue);
	}
}
