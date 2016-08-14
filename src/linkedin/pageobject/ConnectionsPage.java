package linkedin.pageobject;

import linkedin.pageobject.locator.ConnectionsLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnectionsPage extends ConnectionsLocator {
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public ConnectionsPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public PersonalViewPage clickFirstConnect(){
		wait.until(ExpectedConditions.elementToBeClickable(super.FIRST_CONNECT));
		driver.findElement(FIRST_CONNECT).click();
		return new PersonalViewPage(driver, wait);
	}

}
