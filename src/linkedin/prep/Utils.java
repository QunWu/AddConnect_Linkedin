
package linkedin.prep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static final String EMAIL="Your account";
	public static final String PWD = "Your PWD for account";
	
	public static final int GENERIC_ADD_CONNECT_STOP_POINT = 1150;
	public static final int ADD_CONNECT_BY_COMPANY_STOP_POINT = 1000;
	public static final int ENDORSE_SKILLS_STOP_POINT = 50000;
	public static final String HOME_URL = "https://www.linkedin.com/";
	
	private static final String DRIVER_PATH = "C:/Users/Qun Wu/Documents/GitHub/AddConnect_Linkedin/lib/chromedriver.exe";
	
	public static final String[] KEYWORDS_TO_DISMISS_CONNECT_GENERIC_ADD_CONNECT = {"student","school","university","seek","look",
        "seeking","looking","college","graduate","grad","master","phd","ph.d","ms","m.s"};
	
	public static final String[] POSITIONS_FILTER_TO_ADD_CONNECT_BY_COMPANY = {"bay area","san francisco"};
	
	public static final String[] COMPANIES_LIST = {"google","facebook","ebay","twitter","linkedin"};
	
	public static final String CONNECT_BTN_TEXT_BY_COMPANY = "connect";
	
	private WebDriver driver_GenericAddConnect = null;
	private WebDriverWait wait_GenericAddConnect = null;
	
	private WebDriver driver_AddConnectByCompany = null;
	private WebDriverWait wait_AddConnectByCompany = null;
	
	private WebDriver driver_Endorse = null;
	private WebDriverWait wait_Endorse = null;
	
	public Utils(){
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
	}
	
	public WebDriver getGenericAddConnectWebDriver(){
		if(driver_GenericAddConnect == null)
			driver_GenericAddConnect = new ChromeDriver();
		return driver_GenericAddConnect;
	}
	
	public WebDriverWait getGenericAddConnectWebDriverWait(){
		if(wait_GenericAddConnect == null&&driver_GenericAddConnect != null)
			wait_GenericAddConnect = new WebDriverWait(driver_GenericAddConnect, 10);
		return wait_GenericAddConnect;
	}
	
	public WebDriver getAddConnectByCompanyWebDriver(){
		if(driver_AddConnectByCompany == null)
			driver_AddConnectByCompany = new ChromeDriver();
		return driver_AddConnectByCompany;
	}
	
	public WebDriverWait getAddConnectByCompanyWebDriverWait(){
		if(wait_AddConnectByCompany == null &&driver_AddConnectByCompany != null)
			wait_AddConnectByCompany =new WebDriverWait(driver_AddConnectByCompany, 10);
		return wait_AddConnectByCompany;
	}
	
	public WebDriver getEndorseWebDriver(){
		if(driver_Endorse == null)
			driver_Endorse = new ChromeDriver();
		return driver_Endorse;
	}
	
	public WebDriverWait getEndorseWebDriverWait(){
		if(wait_Endorse == null &&driver_Endorse != null)
			wait_Endorse =new WebDriverWait(driver_Endorse, 10);
		return wait_Endorse;
	}
	
	public void quitGenericAddConnect(){
		wait_GenericAddConnect=null;
		driver_GenericAddConnect.close();
		driver_GenericAddConnect.quit();
	}
	
	public void quitAddConnectByCompany(){
		wait_GenericAddConnect=null;
		driver_GenericAddConnect.close();
		driver_GenericAddConnect.quit();
	}
	
	public void quitEndorese(){
		wait_Endorse=null;
		driver_Endorse.close();
		driver_Endorse.quit();
	}
}
