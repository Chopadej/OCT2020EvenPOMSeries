package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class AccountsPage {

	private ElementUtil elementUtil;
	
	private By header= By.cssSelector("div#logo a");
	private By accountSectionHeaders= By.cssSelector("div#content h2");
	private By searchText= By.cssSelector("div#search input");
	private By searchButton= By.cssSelector("div#search button");
	private By serachItemsResult= By.cssSelector("div.product-layout .product-thumb");
	
	public AccountsPage(WebDriver driver) {
		elementUtil= new ElementUtil(driver); 
	}
	
	
	public String getAccountPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.ACCOUNT_PAGE_TITLE, 5);
	}
	
	public String getHeaderValue() {
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
		
	}
	
	public int getAccountSectionCount() {
		return elementUtil.getElements(accountSectionHeaders).size();
	}
	
	public List<String> getAccountSectionList() {
		List<String> accountList= new ArrayList<String>();
		List<WebElement> accSectionList= elementUtil.getElements(accountSectionHeaders);
		for(WebElement e: accSectionList) {
			String secText= e.getText();
			accountList.add(secText);
		}
		return accountList;
	}
	
	public boolean doSearch(String productName) {
		System.out.println("Searching for:"+productName);
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if(elementUtil.getElements(serachItemsResult).size()>0) {
			return true;
		}
		return false;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
