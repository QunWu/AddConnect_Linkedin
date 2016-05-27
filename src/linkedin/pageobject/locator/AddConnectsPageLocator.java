package linkedin.pageobject.locator;

import org.openqa.selenium.By;

public class AddConnectsPageLocator {
	private final String firstConnectInList = "li[data-unique-id]:nth-child(1)";
	
	protected final By ALL_PEOPLE_CARD = By.cssSelector("li[data-unique-id]");
	protected final By INTRO_FOR_FIRST_PEOPLE_CARD = By.cssSelector(firstConnectInList+" p[class='headline']");
	protected final By CONNECT_BTN_FIRST_PEOPLE_CARD = By.cssSelector(firstConnectInList+" button.bt-request-buffed");
	protected final By DISMISS_BTN_FIRST_PEOPLE_CARD = By.cssSelector(firstConnectInList+" button.bt-close");
}
