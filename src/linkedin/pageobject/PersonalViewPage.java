package linkedin.pageobject;

import linkedin.pageobject.locator.PersonalViewLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalViewPage extends PersonalViewLocator {
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public PersonalViewPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickEndorseSkillsForPersonalUnderView(){
		wait.until(ExpectedConditions.elementToBeClickable(super.ENDORSE_BUTTON));
		driver.findElement(ENDORSE_BUTTON).click();
	}
	
	public void clickEndorseSkillsForAssociateConnects(){
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CARDS));
		wait.until(ExpectedConditions.elementToBeClickable(super.FIRST_CONNECT_ENDORSE));
		driver.findElement(FIRST_CONNECT_ENDORSE).click();
	}
}
