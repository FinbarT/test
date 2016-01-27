package UI;


import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.TestRepoIssues;

import SeleniumLibrary.BrowserFactory;


public class CheckIssuesUI extends BaseTestUI {

	@BeforeClass
	public void setUp() {

		browser = BrowserFactory.getNewBrowser();
		gitHubLoginUI();
		browser.goToURL(TestRepoIssues.URL);
	}
	
	@Test(description="Issue entitled: 'issue 3' exists")
	public void CheckIssuesUI_01() {
		Assert.assertTrue(browser.checkExists(TestRepoIssues.issue_three));
	}

	@Test(description="Issue entitled: 'issue 2' exists")
	public void CheckIssuesUI_02() {
		Assert.assertTrue(browser.checkExists(TestRepoIssues.issue_two));
	}
	
	@AfterClass
	public void tearDown() {

		gitHubLogoutUI();
	    browser.close();
	}

}
