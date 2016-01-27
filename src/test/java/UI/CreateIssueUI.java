package UI;


import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.TestRepoIssues;
import Pages.TestRepoIssuesNew;

import SeleniumLibrary.BrowserFactory;
import SeleniumLibrary.ElementSelector;
import SeleniumLibrary.SELECTOR_TYPE;


public class CreateIssueUI extends BaseTestUI {

	String issue_title = "";
			
	@BeforeClass
	public void setUp() {
		
		browser = BrowserFactory.getNewBrowser();
		gitHubLoginUI();
		browser.goToURL(TestRepoIssuesNew.URL);
		issue_title = "New Issue Title" + Double.toString(Math.random());
	}
	
	@Test(description="Check the preview matches what it should")
	public void createIssueUI_01() {

		browser.enterFormText(TestRepoIssuesNew.issueTitleTextField, issue_title);
		browser.enterFormText(
				TestRepoIssuesNew.issueCommentTextField, "This is a comment on the issue");
		browser.clickLink(TestRepoIssuesNew.previewIssueTab);
		Assert.assertTrue(browser.checkExists(TestRepoIssuesNew.previewIssueText));
	}
	
	@Test(description="Submit and verify")
	public void createIssueUI_02() {

		browser.clickLink(TestRepoIssuesNew.SubmitIssueBtn);
		browser.wait(3);
		browser.goToURL(TestRepoIssues.URL);
		Assert.assertTrue(browser.checkExists(new ElementSelector(
						SELECTOR_TYPE.XPATH, ".//a[contains(text(), '"+issue_title+"')]")	));
	}
	
	@AfterClass
	public void tearDown() {

		gitHubLogoutUI();
	    browser.close();
	}
}
