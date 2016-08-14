package linkedin.pageobject.locator;

import org.openqa.selenium.By;

public class PersonalViewLocator {
	protected final By ENDORSE_BUTTON = By.id("endorse-submit");
	protected final By CARDS = By.cssSelector(".card");
	protected final By FIRST_CONNECT_ENDORSE = By.cssSelector(".card:first-child .action-endorse");
}
