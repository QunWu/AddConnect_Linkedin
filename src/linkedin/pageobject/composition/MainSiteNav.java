package linkedin.pageobject.composition;

import linkedin.pageobject.ConnectionsPage;
import linkedin.pageobject.locator.MainSiteNavLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainSiteNav extends  MainSiteNavLocator{
	WebDriver driver = null;
	WebDriverWait wait = null;
	Actions action = null;
	
	public MainSiteNav(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait; 
		action = new Actions(driver);
	}
	
	public ConnectionsPage clickConnections(){
		wait.until(ExpectedConditions.presenceOfElementLocated(super.MY_NETWORK));
		WebElement connectionsUL = driver.findElement(super.MY_NETWORK);
		action.moveToElement(connectionsUL).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(super.CONNECTIONS));
		driver.findElement(super.CONNECTIONS).click();
		
		return new ConnectionsPage(driver, wait);
	}
}
