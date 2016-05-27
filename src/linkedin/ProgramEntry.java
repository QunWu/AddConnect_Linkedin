package linkedin;

import linkedin.pageobject.AddConnectsPage;
import linkedin.pageobject.HomePage;
import linkedin.pageobject.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import linkedin.prep.Utils;
import linkedin.threads.AddConnect;

public class ProgramEntry {
	public static void main(String[] agrs){
		Utils utils = new Utils();
		WebDriver driver = utils.getWebDriver();
		WebDriverWait wait= utils.getWebDriverWait();
		
		LoginPage loginPage = new LoginPage(driver,wait);
		loginPage.typeEmail(Utils.EMAIL);
		loginPage.typePWD(Utils.PWD);
		
		HomePage home = loginPage.clickSubmit();
		AddConnectsPage addConnectsPage = home.clickAddConnectLink();
		
		AddConnect addConnect = new AddConnect(addConnectsPage,utils);
		addConnect.start();
	}
}
