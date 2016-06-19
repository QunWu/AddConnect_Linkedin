package linkedin.pageobject;

import java.util.ArrayList;
import java.util.List;

import linkedin.exceptions.NumbersNotEqualException;
import linkedin.pageobject.composition.PersonPreView;
import linkedin.pageobject.composition.SearchHeader;
import linkedin.pageobject.locator.PeopleByCompanyPageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PeopleByCompanyPage extends PeopleByCompanyPageLocator{
	
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	private List<PersonPreView> pre_views = null;
	private String expectedCurrentJob = null;
	private SearchHeader searchHeader = null;
	
	public PeopleByCompanyPage(WebDriver driver, WebDriverWait wait,String expectedCurrentJob) {
		this.driver = driver;
		this.wait = wait;
		this.expectedCurrentJob = expectedCurrentJob;
		this.searchHeader = new SearchHeader(this.driver,this.wait);
	}
	
	private void initPersonPreViewList() throws NumbersNotEqualException{
		pre_views = new ArrayList<>();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(super.allActionBtns));
		List<WebElement> actionBtns = driver.findElements(super.allActionBtns);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(super.allDemographicIntros));
		List<WebElement> allDemographics = driver.findElements(super.allDemographicIntros);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(super.allCurrentJobs));
		List<WebElement> allCurrJobs = driver.findElements(super.allCurrentJobs);
		
		if(actionBtns.size() == allDemographics.size() && actionBtns.size() ==allCurrJobs.size())
			for( int idx = 0 ; idx < allCurrJobs.size() ; idx++)
				pre_views.add(new PersonPreView(actionBtns.get(idx),allDemographics.get(idx),allCurrJobs.get(idx),this.expectedCurrentJob));
		else
			throw new NumbersNotEqualException(actionBtns.size(),allDemographics.size(),allCurrJobs.size());
	}
	
	
	public int clickAllConnectsInPage() throws NumbersNotEqualException{
		this.initPersonPreViewList();
		int totalAddedInList = 0;
		for(PersonPreView aPreView : this.pre_views)
			if(aPreView.clickConnect())
				totalAddedInList++;
		
		return totalAddedInList;
	}
	
	public void goToNextPage(){
		this.driver.findElement(super.linkAfterActivedPaginationLink).click();
	}
	
	public PeopleByCompanyPage searchPeopleByCompany(String companyName){
		return this.searchHeader.searchPeopleByCompanyTemplate(companyName);
	}
}
