package SeleniumLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import Util.OSValidator;

/*
 * @author finbar timmins
 */
public class ChromeBrowser extends Browser {
	
	/*
	 * 
	 */
	public ChromeBrowser(String url) {

		super(url);

		if (OSValidator.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		} else if (OSValidator.isMac()) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
		} else {
			throw new UnsupportedOperationException("This OS is not supported");
		}
		
		this.driver = new ChromeDriver();

		// chrome driver window resize hack 
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.open('','testwindow','width=400,height=200')");
		this.close();
		this.changeWindowByName("testwindow");
		js.executeScript("window.moveTo(0,0);");
		js.executeScript("window.resizeTo(1280,800);");
		this.driver.manage().timeouts().implicitlyWait(this.TIMEOUT, TimeUnit.SECONDS);
		driver.get(url);
	}
}
