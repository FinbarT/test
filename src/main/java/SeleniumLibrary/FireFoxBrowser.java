package SeleniumLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * @author finbar timmins
 */
public class FireFoxBrowser extends Browser {

	public FireFoxBrowser(String url){
		super(url);
		this.driver = new FirefoxDriver();
	    this.driver.manage().window().maximize();
	    this.driver.manage().timeouts().implicitlyWait(this.TIMEOUT, TimeUnit.SECONDS);
	    this.driver.get(url);
	}
}
