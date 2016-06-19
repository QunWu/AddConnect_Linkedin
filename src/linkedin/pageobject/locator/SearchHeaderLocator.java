package linkedin.pageobject.locator;

import org.openqa.selenium.By;

public class SearchHeaderLocator {
	protected final By DROPDOWN_ENTRY_DIV_ID = By.id("control_gen_2") ;
	protected final By PEOPLE_OPTION = By.cssSelector("option.people");
	protected final By SEARCH_BAR = By.id("main-search-box");
	protected final By SUBMIT_BTN = By.cssSelector(".search-button");
}
