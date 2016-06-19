package linkedin.pageobject.locator;

import org.openqa.selenium.By;

public class PeopleByCompanyPageLocator {
	protected final By allActionBtns = By.cssSelector("a.label");
	protected final By allDemographicIntros = By.cssSelector("dd bdi");
	protected final By allCurrentJobs = By.cssSelector("p b:nth-child(1)");
	protected final By linkAfterActivedPaginationLink = By.cssSelector("li.active + li");
}
