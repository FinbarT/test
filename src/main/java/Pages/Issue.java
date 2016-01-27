package Pages;

import SeleniumLibrary.ElementSelector;
import SeleniumLibrary.SELECTOR_TYPE;

public class Issue {

	public static final ElementSelector closeIssueBtn = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//button[contains(text(), 'Close issue')]");

	public static final ElementSelector reopenIssueBtn = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//button[contains(text(), 'Reopen issue')]");
	
	public static final ElementSelector issueClosedIcon = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//*[@id='partial-discussion-header']/div[3]/div[1]/div");
	
	public static final ElementSelector issueOpenIcon = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//*[@id='partial-discussion-header']/div[3]/div[1]/div");
	
	public static final ElementSelector issueEditBtn = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//*[@id='issue-128990371']/div[1]/div[1]/a");	//changed from being /a/span to /a/svg/path overnight 27/1
	
	public static final ElementSelector issueCommentsTextField = new ElementSelector(
			SELECTOR_TYPE.ID, "issue-128990371-body");
	
	public static final ElementSelector updateCommentBtn = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//button[contains(text(), 'Update comment')]");
	
	public static final ElementSelector commentBody = new ElementSelector(
			SELECTOR_TYPE.XPATH, ".//*[@id='issue-128990371']/div[2]/div/div/p");
	
}