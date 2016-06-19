package linkedin.pageobject;

import linkedin.pageobject.composition.MsgNavigationBar;
import linkedin.pageobject.composition.SearchHeader;
import linkedin.pageobject.locator.HomePageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends HomePageLocator{
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	SearchHeader searchHeader = null;
	MsgNavigationBar msgNvgBar = null;
	
	public HomePage(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		
		searchHeader = new SearchHeader(driver,wait);
		msgNvgBar = new MsgNavigationBar(driver,wait);
	}

	public AddConnectsPage clickAddConnectLink(){
		return this.msgNvgBar.clickAddConnectLink();
	}
	
	public PeopleByCompanyPage searchPeopleByCompany(String companyName){
		return this.searchHeader.searchPeopleByCompanyTemplate(companyName);
	}
}
