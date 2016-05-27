package linkedin.pageobject;

import linkedin.pageobject.locator.LoginPageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import linkedin.prep.Utils;

public class LoginPage extends LoginPageLocator{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public LoginPage(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		driver.get(Utils.HOME_URL);
	}
	
	public void typeEmail(String email){
		wait.until(ExpectedConditions.elementToBeClickable(super.EMAIL));
		driver.findElement(super.EMAIL).sendKeys(email);
	}
	
	public void typePWD(String pwd){
		wait.until(ExpectedConditions.elementToBeClickable(super.PWD));
		driver.findElement(super.PWD).sendKeys(pwd);
	}
	
	public HomePage clickSubmit(){
		//wait.until(ExpectedConditions.elementToBeClickable(super.SUBMIT));
		driver.findElement(super.SUBMIT).click();
		
		return new HomePage(driver, wait);
	}
}
