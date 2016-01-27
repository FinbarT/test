package UI;


import SeleniumLibrary.Browser;

import Util.GitUser;

import Pages.login;
import Pages.logout;


public class BaseTestUI {

	protected Browser browser;
	
    protected void gitHubLoginUI() {

    	browser.goToURL(login.URL);
    	browser.enterFormText(login.usernameTextField, GitUser.getUsername());
    	browser.enterFormText(login.passwordTextField, GitUser.getPassword());
    	browser.submit(login.loginBtn);
    }
    
    protected void gitHubLogoutUI() {

    	browser.goToURL(logout.URL);
    	browser.submit(logout.logoutBtn);
    }
}
