package linkedin.pageobject.composition;

import linkedin.pageobject.PeopleByCompanyPage;
import linkedin.pageobject.locator.SearchHeaderLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHeader extends SearchHeaderLocator{
	WebDriver driver = null;
	WebDriverWait wait = null;

	public SearchHeader(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public final PeopleByCompanyPage searchPeopleByCompanyTemplate(String companyName){
		this.clickDropDown();
		this.selectFilter(super.PEOPLE_OPTION);
		this.typeInSearchKeyword(companyName);
		return this.clickSearchButton(companyName);
	}
	
	private void typeInSearchKeyword(String searchKeyword){
		this.wait.until(ExpectedConditions.presenceOfElementLocated(super.SEARCH_BAR));
		WebElement searchBar = this.driver.findElement(SEARCH_BAR);
		if(searchBar.getText()!=null)
			searchBar.clear();
		searchBar.sendKeys(searchKeyword);
	}
	
	private void clickDropDown(){
		wait.until(ExpectedConditions.elementToBeClickable(super.DROPDOWN_ENTRY_DIV_ID));
		driver.findElement(super.DROPDOWN_ENTRY_DIV_ID).click();
	}
	
	private void selectFilter(By optionLocator){
		wait.until(ExpectedConditions.elementToBeClickable(super.PEOPLE_OPTION));
		driver.findElement(super.PEOPLE_OPTION).click();
	}
	
	private PeopleByCompanyPage clickSearchButton(String expectedCurrentJob){
		this.driver.findElement(super.SUBMIT_BTN).click();
		return new PeopleByCompanyPage(this.driver,this.wait,expectedCurrentJob);
	}
	
}
