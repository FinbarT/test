package API;


import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class OpenCloseIssueAPI extends BaseTestAPI {

	int issueId;
	GHRepository repo;
	GHIssue issue;
	GHIssueState state;

	@BeforeClass
	public void setUp() {

		issueId = 3;
		ghClient.gitHubLogin();
		repo = ghClient.getRepo("FinbarT/test");
	}
	
	@Test(description="Asserts the issue state has changed from open to closed")
	public void OpenCloseIssueAPI_01() {

		issue = ghClient.getIssue(repo, issueId);
		state = issue.getState();
		ghClient.closeIssue(issue);
		Assert.assertNotEquals(ghClient.getIssue(repo, issueId).getState(), state);	
	}
	
	@Test(description="Asserts the issue state has changed from closed to open")
	public void OpenCloseIssueAPI_02() {

		issue = ghClient.getIssue(repo, issueId);
		state = issue.getState();
		ghClient.reOpenIssue(issue);
		Assert.assertNotEquals(ghClient.getIssue(repo, issueId).getState(), state);	
	}
}
