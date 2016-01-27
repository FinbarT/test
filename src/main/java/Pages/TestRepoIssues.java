package Pages;

import SeleniumLibrary.ElementSelector;
import SeleniumLibrary.SELECTOR_TYPE;

public class TestRepoIssues {
	
	public static final String URL = "https://github.com/FinbarT/test/issues";
	
	//example entries --> is:open is:issue is:closed
	public static final ElementSelector issueSearchBar = new ElementSelector(
			SELECTOR_TYPE.ID, "js-issues-search");
	
	public static final ElementSelector newIssueBtn = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//a[contains(text(), 'New Issue')]");
	
	public static final ElementSelector issue_three = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//a[contains(text(), 'issue 3')]");
	
	public static final ElementSelector issue_two = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//a[contains(text(), 'issue 2')]");
}
