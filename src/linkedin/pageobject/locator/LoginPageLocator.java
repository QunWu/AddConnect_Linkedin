package linkedin.pageobject.locator;

import org.openqa.selenium.By;

public class LoginPageLocator {
	protected final By EMAIL = By.id("login-email");
	protected final By PWD = By.id("login-password");
	protected final By SUBMIT = By.cssSelector("input[type='submit'][name='submit']");
}
