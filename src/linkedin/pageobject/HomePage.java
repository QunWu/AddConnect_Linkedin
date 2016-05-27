package linkedin.pageobject;

import linkedin.pageobject.locator.HomePageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends HomePageLocator{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public HomePage(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}

	public AddConnectsPage clickAddConnectLink(){
		wait.until(ExpectedConditions.elementToBeClickable(super.ADD_CONNECT));
		driver.findElement(super.ADD_CONNECT).click();
		return new AddConnectsPage(driver,wait);
	}
}
