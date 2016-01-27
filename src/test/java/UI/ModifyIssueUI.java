package UI;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Issue;
import Pages.TestRepoIssues;
import SeleniumLibrary.BrowserFactory;


public class ModifyIssueUI extends BaseTestUI {

	String comments = "";
			
	@BeforeClass
	public void setUp() {

		browser = BrowserFactory.getNewBrowser();
		gitHubLoginUI();
		comments = Double.toString(Math.random());
		browser.goToURL(TestRepoIssues.URL);
	}

	@Test(description="Edit Comments Body")
	public void ModifyIssueUI_01() {

		browser.clickLink(TestRepoIssues.issue_two);
		browser.clickLink(Issue.issueEditBtn);
		browser.clearFormText(Issue.issueCommentsTextField);
		browser.enterFormText(Issue.issueCommentsTextField, comments);
		browser.clickLink(Issue.updateCommentBtn);
		browser.wait(5);
		Assert.assertEquals(browser.getElementText(Issue.commentBody), comments);
	}

	@AfterClass
	public void tearDown() {

		gitHubLogoutUI();
	    browser.close();
	}

}
