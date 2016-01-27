package Pages;

import SeleniumLibrary.ElementSelector;
import SeleniumLibrary.SELECTOR_TYPE;

public class TestRepoIssuesNew {

	public static final String URL = "https://github.com/FinbarT/test/issues/new";

	public static final ElementSelector issueTitleTextField = new ElementSelector(
			SELECTOR_TYPE.ID, "issue_title");
	
	public static final ElementSelector issueCommentTextField = new ElementSelector(
			SELECTOR_TYPE.ID, "issue_body");
	
	public static final ElementSelector writeIssueTab = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//a[contains(text(), 'Write')]");
	
	public static final ElementSelector previewIssueTab = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//a[contains(text(), 'Preview')]");
	
	public static final ElementSelector SubmitIssueBtn = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//button[contains(text(), 'Submit new issue')]");
	
	public static final ElementSelector previewIssueText = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//p[contains(text(), 'This is a comment on the issue')]");
}
