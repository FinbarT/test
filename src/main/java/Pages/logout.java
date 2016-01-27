package Pages;

import SeleniumLibrary.ElementSelector;
import SeleniumLibrary.SELECTOR_TYPE;

public class logout {

	public static final String URL = "https://github.com/logout";
	
	public static final ElementSelector logoutBtn = new ElementSelector(
			SELECTOR_TYPE.CLASS, "btn");
}
