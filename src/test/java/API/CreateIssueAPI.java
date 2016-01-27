package API;


import org.kohsuke.github.GHRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreateIssueAPI extends BaseTestAPI {

	String issue_title;
	String issue_body;
	GHRepository repo;
	
	@BeforeClass
	public void setUp() {

		issue_title = "New Issue Title" + Double.toString(Math.random());
		issue_body = "";
		ghClient.gitHubLogin();
		repo = ghClient.getRepo("FinbarT/test");
	}
	
	@Test(description="Create Issue in repo FinbarT/test")
	public void createIssueAPI_01() {
		
		Assert.assertNotNull(
				ghClient.createIssue(repo, issue_title, "Made via API test"));
		
	}

}
