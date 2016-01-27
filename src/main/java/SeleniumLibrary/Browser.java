package SeleniumLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



/*
 * @author finbar timmins
 */
public class Browser {
	
	public static Logger Log4 = LogManager.getLogger(Browser.class.getName());
	
    protected int TIMEOUT = 60;
	private String URL = "";
	protected WebDriver driver;
	public String backPage;

	/*
	 * constructor method
	 */
	public Browser(String url) {
		URL = url;
	}

	/**
	 * sets up log funciton
	 * @param msg
	 * @param reporterOut
	 * @param a_Screenshot
	 */
	public void Log(String msg, boolean reporterOut, boolean a_Screenshot) {

		System.out.println(msg);
		if (reporterOut) {
			Reporter.log(msg);
		}
	}
	
	/**
	 * 
	 * @param msg
	 */
	public void Log(String msg) {
		Log(msg, true, false);
	}

	/**
	 * 
	 */
	public void close(){
		driver.close();
	}

	/**
	 * 
	 */
	public WebDriver getDriver(){
		return driver;
	}
	
	/**
	 * 
	 */
	public void home(){
		backPage = driver.getCurrentUrl();
		driver.get(URL);
	}
	
	/**
	 * 
	 */
	public void goToTestPage(){
		backPage = driver.getCurrentUrl();
		driver.get(URL);
	}

	/**
	 * 
	 * @param url
	 */
	public void goToURL(String url){
		backPage = driver.getCurrentUrl();
		driver.get(url);
	}

	/**
	 * 	
	 * @param pageTitle
	 * @return boolean
	 */
	public boolean isat(String pageTitle) {
		
		if(driver.getTitle().equals(pageTitle)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 */
	public void goBack(){
		backPage = driver.getCurrentUrl();
		driver.navigate().back();
	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean checkExists(ElementSelector element) {

		if (getElements(element, false, TIMEOUT).size() != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean checkVisible(ElementSelector element) {

		if (getElement(element).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param element
	 */
	public void clickLink(ElementSelector element){
		backPage = driver.getCurrentUrl();
		getElement(element).click();
	}
	
	
	/**
	 * 
	 * @param element
	 */
	public void submit(ElementSelector element){
		backPage = driver.getCurrentUrl();
		getElement(element).submit();
	}
	
	/**
	 * 
	 * @param textFeild
	 * @param text
	 */
	public void enterFormText(ElementSelector textFeild, String text){
		getElement(textFeild).sendKeys(text);
	}

	/**
	 * 
	 * @param textFeild
	 * @param text
	 */
	public void clearFormText(ElementSelector textFeild){
		getElement(textFeild).clear();
	}
	
	/**
	 * 
	 * @param element
	 * @return String
	 */
	public String getElementText(ElementSelector element){
		return getElement(element).getText();
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getBrowserUrl(){
		return driver.getCurrentUrl();
	}

	/**
	 * 
	 * @return String
	 */
	public String getUrl(){
		return URL;
	}

	/**
	 * 
	 * @param secs
	 */
	public void wait(int secs) {

		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			System.out.println("My sleep was interupted");
		}
	}

	/**
	 * 
	 * @param selector
	 */
	public void mouseOver(ElementSelector selector){

		Actions action = new Actions(driver);
		action.moveToElement(getElement(selector));
		action.perform();
	}
	
	/**
	 * 
	 * @param href
	 * @param position
	 */
	public void clickLinkByHref(String href, int position) {
		
	    List<WebElement> anchors = driver.findElements(By.tagName("a"));
	    Iterator<WebElement> i = anchors.iterator();
	    
	    int j = 0;
	    while(i.hasNext()) {

	    	WebElement anchor = i.next();
	    	if(anchor.getAttribute("href").contains(href)) {
	            j++;
	        }
	    	if(anchor.getAttribute("href").contains(href) && j == position) {
	            anchor.click();
	            break;
	        }
	    }
	}

	/**
	 * 
	 * @param dropdown
	 * @return
	 */
	public List<WebElement> getDowndownOptions(ElementSelector dropdown){

		WebElement select = getElement(dropdown);
		return select.findElements(By.tagName("option"));
	}

	/**
	 * 
	 * @param selection
	 * @param menu
	 */
	public void selectFromDropdown(String selection, ElementSelector menu){

		List<WebElement> options = this.getDowndownOptions(menu);
		for (WebElement option : options) {
			if (option.equals(selection)) {
				option.click();
				break;
			} else {
				continue;
			}
		}
	}
	
	/**
	 * 
	 * @param secs
	 */
	public void sleep(int secs){

		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e){
			// raise exception here
		}
	}
	
	/**
	 * 
	 * @param windowName
	 */
	public void changeWindowByName(String windowName){
		driver.switchTo().window(windowName);
	}
	
	/**
	 * 
	 */
	public void waitForPageLoad() {

		WebDriverWait wait = new WebDriverWait(this.getDriver(), 30);

		wait.until(
			new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					return ((JavascriptExecutor) driver).executeScript(
							"return document.readyState"
					).equals("complete");
				}
			}
		);	
	}

	/**
	 * 
	 * @param element
	 */
	public void switchToFrame(ElementSelector element) {
		driver.switchTo().frame(getElement(element));
	}
	
	/**
	 * 
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * 
	 * @param element
	 */
	public void focusOnTextField(ElementSelector element){
		new Actions(driver).moveToElement(getElement(element)).click().perform();
	}
	
	/**
	 * Checks to see if a element is on the screen and returns the object if so, null otherwise.  Can search for hidden items as well
	 * @param lookupItem
	 * @return
	 */
	public WebElement getElement(ElementSelector lookupItem) {
		return getElement(lookupItem, false, TIMEOUT);
	}

	/**
	 * 
	 * @param el_selctor
	 * @param hidden
	 * @param sec
	 * @return WebElement
	 */
	public WebElement getElement(
		ElementSelector el_selctor, boolean hidden, int sec) {

		List<WebElement> foundObjects;
		WebDriverWait wait = new WebDriverWait(driver, sec);

		switch (el_selctor.getSelectorType()) {
			case NAME: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.name(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.name(el_selctor.getSelector()));
				return getfoundObject(foundObjects, el_selctor, hidden, sec);
			}
			case CLASS: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.className(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.className(el_selctor.getSelector()));
				return getfoundObject(foundObjects, el_selctor, hidden, sec);
			}	
			case TAG_NAME:{
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.tagName(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.tagName(el_selctor.getSelector()));
				return getfoundObject(foundObjects, el_selctor, hidden, sec);
			}
			case XPATH: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.xpath(el_selctor.getSelector()));
				return getfoundObject(foundObjects, el_selctor, hidden, sec);
			}
			case ID: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.id(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.id(el_selctor.getSelector()));
				return getfoundObject(foundObjects, el_selctor, hidden, sec);
			}
			default: {
				Log("Incompatible Selector Type:[ " 
						+ el_selctor.getSelector() 
						+ "] found for object: " 
						+ el_selctor.getDescription());
				break;
			}
		}
		return null; // never found a visible button
	}
	
	/**
	 * 
	 * @param foundObjects
	 * @param el_selctor
	 * @param hidden
	 * @param sec
	 * @return WebElement
	 */
	private WebElement getfoundObject(
			List<WebElement> foundObjects, ElementSelector el_selctor, 
			boolean hidden, int sec){
		
		for (WebElement foundObject : foundObjects) {
			if (foundObject.isDisplayed() || hidden) {
				Log("Found WebElement: " 
						+ el_selctor.getDescription() 
						+ " | Selector Type: " 
						+ el_selctor.getSelectorType() 
						+ " | Timeout: " 
						+ sec);
				return foundObject;
			}
		}
		return null; // never found a visible button
	}
	
	/**
	 * 
	 * @param el_selctor
	 * @param hidden
	 * @param sec
	 * @return WebElement
	 */
	public List<WebElement> getElements(
			ElementSelector el_selctor, boolean hidden, int sec) {          

		List<WebElement> foundObjects;
		List<WebElement> returnObjectsElements = new ArrayList<WebElement>();
		WebDriverWait wait = new WebDriverWait(driver, sec);

		switch (el_selctor.getSelectorType()) {
			case NAME: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.name(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.name(el_selctor.getSelector()));
				for (WebElement foundObject : foundObjects) {
					if (foundObject.isDisplayed() || hidden) {
						returnObjectsElements.add(foundObject);
					}
				}
				break;
			}
			case CLASS: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.className(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.className(el_selctor.getSelector()));
				for (WebElement foundObject : foundObjects) {
					if (foundObject.isDisplayed() || hidden) {
						returnObjectsElements.add(foundObject);
					}
				}
				break;
			}	
			case TAG_NAME: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.tagName(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.tagName(el_selctor.getSelector()));
				for (WebElement foundObject : foundObjects) {
					if (foundObject.isDisplayed() || hidden) {
						returnObjectsElements.add(foundObject);
					}
				}
				break;
			}
			case XPATH: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.xpath(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.xpath(el_selctor.getSelector()));
				for (WebElement foundObject : foundObjects) {
					if (foundObject.isDisplayed() || hidden) {
						returnObjectsElements.add(foundObject);
					}
				}
				break;
			}
			case ID: {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(
							By.id(el_selctor.getSelector())));
				} catch (TimeoutException TimeOut) {
					Log("Unable to find object within timout");
					break;
				}
				foundObjects = driver.findElements(By.id(el_selctor.getSelector()));
				for (WebElement foundObject : foundObjects) {
					if (foundObject.isDisplayed() || hidden) {
						returnObjectsElements.add(foundObject);
					}
				}
				break;
			}
			default: {
				Log("Incompatible Selector Type for object: " 
						+ el_selctor.getSelector() 
						+ " : " 
						+ el_selctor.getDescription());
				break;
			}
		}
		Log("Found " 
				+ returnObjectsElements.size() 
				+ " objects matching Element Selector: " 
				+ el_selctor.getDescription() 
				+ " : " 
				+ el_selctor.getSelector());
		return returnObjectsElements;
	}

}
