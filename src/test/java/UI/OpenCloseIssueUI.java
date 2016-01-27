package UI;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Issue;
import Pages.TestRepoIssues;
import SeleniumLibrary.BrowserFactory;



public class OpenCloseIssueUI extends BaseTestUI {

	@BeforeClass
	public void setUp() {

		browser = BrowserFactory.getNewBrowser();
		gitHubLoginUI();
		browser.goToURL(TestRepoIssues.URL);
		browser.enterFormText(TestRepoIssues.issueSearchBar, "issue 3");
	}
	
	@Test(description="close issue")
	public void openCloseIssueUI_01() {

		browser.clickLink(TestRepoIssues.issue_three);
		browser.clickLink(Issue.closeIssueBtn);
		browser.sleep(5);
		Assert.assertEquals(browser.getElementText(Issue.issueClosedIcon), "Closed");
	}
	
	@Test(description="re-open issue")
	public void openCloseIssueUI_02() {

		browser.clickLink(Issue.reopenIssueBtn);
		browser.sleep(5);
		Assert.assertEquals(browser.getElementText(Issue.issueOpenIcon), "Open");
	}
	
	@AfterClass
	public void tearDown() {

		browser.goToURL(TestRepoIssues.URL);
		browser.enterFormText(TestRepoIssues.issueSearchBar, "issue 3");
		gitHubLogoutUI();
	    browser.close();
	}

}
