package linkedin.pageobject.composition;

import linkedin.pageobject.AddConnectsPage;
import linkedin.pageobject.locator.MsgNavigationBarLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MsgNavigationBar extends MsgNavigationBarLocator{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public MsgNavigationBar(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public AddConnectsPage clickAddConnectLink(){
		wait.until(ExpectedConditions.elementToBeClickable(super.ADD_CONNECT));
		driver.findElement(super.ADD_CONNECT).click();
		return new AddConnectsPage(driver,wait);
	}
}
