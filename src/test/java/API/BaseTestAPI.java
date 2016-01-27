package API;

import Util.GitUser;
import GitClientLibrary.GitHubClient;


public class BaseTestAPI {
	
	GitHubClient ghClient = new GitHubClient(GitUser.getUsername(), GitUser.getPassword());
}
