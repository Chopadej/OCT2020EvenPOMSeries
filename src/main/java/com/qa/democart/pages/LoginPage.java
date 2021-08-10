package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//page locator: By locator: OR
	
	private By emailID= By.id("input-email");
	private By password= By.id("input-password");
	private By loginButton= By.cssSelector("input[value= 'Login']");
	private By forgotPwdLinks= By.linkText("Forgotten Password");
	private By registerLink= By.linkText("Register");
	
	//page constructor
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//page actions:
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	public boolean isForgotPwdLinkExist() {
		if(elementUtil.getElements(forgotPwdLinks).size()==Constants.FORGOTTEN_PWD_LINK_COUNT)
			return true;
		return false;
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with username :"+un + "and Password :"+pwd);
		
		elementUtil.doSendKeys(emailID, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}
