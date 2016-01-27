package API;


import java.util.List;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CheckIssuesAPI extends BaseTestAPI {

	GHRepository repo;
	List<GHIssue> issues;

	@BeforeClass
	public void setUp() {

		ghClient.gitHubLogin();
		repo = ghClient.getRepo("FinbarT/test");
		issues = ghClient.getRepoIssues(repo, null);
	}

	@Test(description="Checks for existance of issue 1")
	public void CheckIssuesAPI_01() {

		Assert.assertNotNull(issues.get(0));
	}
	
	@Test(description="Checks for existance of issue 2")
	public void CheckIssuesAPI_02() {

		Assert.assertNotNull(issues.get(1));
	}
	
	@Test(description="Checks for existance of issue 3")
	public void CheckIssuesAPI_03() {

		Assert.assertNotNull(issues.get(2));
	}
}
