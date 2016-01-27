package SeleniumLibrary;


/*
 * @author finbar timmins
 */
public class BrowserFactory {
 
    public static Browser getNewBrowser() {

    	String URL = System.getenv("URL");
    	String browser = System.getenv("BROWSER");

    	if(browser.equals("firefox")) {
			return new FireFoxBrowser(URL);
    	} else if (browser.equals("chrome")) {
    		return new ChromeBrowser(URL);
    	} else {
    		return null;
    	}
    }
}
