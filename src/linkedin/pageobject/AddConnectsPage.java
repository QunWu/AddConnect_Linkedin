package linkedin.pageobject;


import linkedin.pageobject.locator.AddConnectsPageLocator;
import linkedin.pageobject.validators.Validator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddConnectsPage extends AddConnectsPageLocator{
	
	private WebDriver driver= null;
	private WebDriverWait wait=null;
	private JavascriptExecutor jse = null;
	
	public AddConnectsPage(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		jse = (JavascriptExecutor)driver;
	}
	
	public void addOneConnect(){

		wait.until(ExpectedConditions.presenceOfElementLocated(super.INTRO_FOR_FIRST_PEOPLE_CARD));
		WebElement briefIntro = driver.findElement(super.INTRO_FOR_FIRST_PEOPLE_CARD);
		wait.until(ExpectedConditions.elementToBeClickable(super.CONNECT_BTN_FIRST_PEOPLE_CARD));
		WebElement connectBtn = driver.findElement(super.CONNECT_BTN_FIRST_PEOPLE_CARD);
		
		if(!Validator.toBeDismissValidator(briefIntro.getText()))
			connectBtn.click();
		else{
			briefIntro.click();
			driver.findElement(super.DISMISS_BTN_FIRST_PEOPLE_CARD).click();
		}
	}
	
	public int numberOfPeopleCard(){
		return driver.findElements(ALL_PEOPLE_CARD).size();
	}
	public void scroll(){
		jse.executeScript("window.scrollBy(0,500);setTimeout(function(){window.scrollBy(0,-500);},3000);");
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
}
