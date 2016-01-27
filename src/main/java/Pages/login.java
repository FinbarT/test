package Pages;

import SeleniumLibrary.ElementSelector;
import SeleniumLibrary.SELECTOR_TYPE;



public class login {

	public static final String URL = "https://github.com/login";
	
	public static final ElementSelector usernameTextField = new ElementSelector(
			SELECTOR_TYPE.ID, "login_field");
	
	public static final ElementSelector passwordTextField = new ElementSelector(
			SELECTOR_TYPE.ID, "password");
	
	public static final ElementSelector loginBtn = new ElementSelector(
			SELECTOR_TYPE.NAME, "login");
}
