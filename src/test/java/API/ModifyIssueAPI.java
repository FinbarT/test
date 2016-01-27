package API;


import org.kohsuke.github.GHRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ModifyIssueAPI extends BaseTestAPI {

	String comments = "";
	int issueId;
	GHRepository repo;

	@BeforeClass
	public void setUp() {

		issueId = 2;
		comments = Double.toString(Math.random());
		ghClient.gitHubLogin();
		repo = ghClient.getRepo("FinbarT/test");
	}
	
	@Test(description="Modify existing issue and assert the change")
	public void ModifyIssueAPI_01() {
		
		ghClient.setIssueBody(ghClient.getIssue(repo, issueId), comments);
		Assert.assertEquals(ghClient.getIssue(repo, issueId).getBody(), comments);	
	}
}
