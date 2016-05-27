
package linkedin.prep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static final String EMAIL="Your_Email_Account";
	public static final String PWD = "Your Password";
	
	public static final int GENERIC_ADD_CONNECT_STOP_POINT = 1150;
	public static final String HOME_URL = "https://www.linkedin.com/";
	
	private static final String DRIVER_PATH = "S:/WorkSpaces/AddConnect_Linkedin/lib/chromedriver.exe";
	
	public static final String[] KEYWORDS_TO_DISMISS_CONNECT = {"student","school","university",
        "seeking","looking","college","graduate","grad","master","phd","ph.d","ms","m.s"};
	
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	public Utils(){
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 10);
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}
	
	public WebDriverWait getWebDriverWait(){
		return wait;
	}
	
	public void quit(){
		wait=null;
		driver.close();
		driver.quit();
	}
}
