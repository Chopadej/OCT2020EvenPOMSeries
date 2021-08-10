
package com.qa.opencart.tests;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.opencart.base.BaseTest;



public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void acoountPageSetUp() {
		accountsPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void accountsPageTitleTest() {
		String title= accountsPage.getAccountPageTitle();
		System.out.println("account page title is:"+title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyAccountPageHeaderTest() {
		String accHeader= accountsPage.getHeaderValue();
		System.out.println("account page header:"+accHeader);
		Assert.assertEquals(accHeader,  Constants.ACCOUNT_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyAccSectionsCountTest() {
		Assert.assertTrue(accountsPage.getAccountSectionCount()==Constants.ACC_SECTIONS_COUNT);
	}
	
	@Test(priority=4)
	public void verifyAccountsSectionsListTest() {
		List<String> accSecList= accountsPage.getAccountSectionList();
		Assert.assertEquals(accSecList, Constants.getExpectedAccountsSectionsList());
	}
	
	@DataProvider
	public Object[][] productTestData() {
		return new Object [][] {
								{ "iMac" },
								{ "Macbook" },
								{ "iPhone" },
								{ "shoes" }
								};
				
		}
	
	@Test(priority=5, dataProvider="productTestData")
	public void searchTest(String productName) {
		Assert.assertTrue(accountsPage.doSearch(productName));
	}
	
	
}
