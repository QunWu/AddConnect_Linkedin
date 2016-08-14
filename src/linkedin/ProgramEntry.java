package linkedin;

import linkedin.pageobject.AddConnectsPage;
import linkedin.pageobject.ConnectionsPage;
import linkedin.pageobject.HomePage;
import linkedin.pageobject.LoginPage;
import linkedin.pageobject.PeopleByCompanyPage;
import linkedin.pageobject.PersonalViewPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import linkedin.prep.Utils;
import linkedin.threads.AddConnectByCompany;
import linkedin.threads.EndorseSkills;
import linkedin.threads.GenericAddConnect;

public class ProgramEntry {
	public static void main(String[] agrs){
		Utils utils = new Utils();
//		/***********************************************************
//		 * for add by company
//		 ***********************************************************/
//		WebDriver driver_AddByCompany = utils.getAddConnectByCompanyWebDriver();
//		WebDriverWait wait_AddByCompany= utils.getAddConnectByCompanyWebDriverWait();
//		
//		LoginPage loginPage_AddByCompany = new LoginPage(driver_AddByCompany,wait_AddByCompany);
//		loginPage_AddByCompany.typeEmail(Utils.EMAIL);
//		loginPage_AddByCompany.typePWD(Utils.PWD);
//		
//		HomePage home_AddByCompany = loginPage_AddByCompany.clickSubmit();
//		if (Utils.COMPANIES_LIST != null && Utils.COMPANIES_LIST.length != 0) {
//			PeopleByCompanyPage searchResultPage = home_AddByCompany.searchPeopleByCompany(Utils.COMPANIES_LIST[0]);
//			Thread addConnectByCompany = new AddConnectByCompany(searchResultPage, utils);
//			addConnectByCompany.start();
//		}
//		/***********************************************************
//		 * for generic add
//		 ***********************************************************/
//		WebDriver driver_GenericAdd = utils.getGenericAddConnectWebDriver();
//		WebDriverWait wait_GenericAdd= utils.getGenericAddConnectWebDriverWait();
//		
//		LoginPage loginPage_GenericAdd = new LoginPage(driver_GenericAdd,wait_GenericAdd);
//		loginPage_GenericAdd.typeEmail(Utils.EMAIL);
//		loginPage_GenericAdd.typePWD(Utils.PWD);
//		
//		HomePage home_GenericAdd = loginPage_GenericAdd.clickSubmit();
//		AddConnectsPage addConnectsPage = home_GenericAdd.clickAddConnectLink();
//		
//		Thread addConnect = new GenericAddConnect(addConnectsPage, utils);
//		addConnect.start();
		/***********************************************************
		 * for endorse
		 ***********************************************************/
		WebDriver driver_Endorse = utils.getEndorseWebDriver();
		WebDriverWait wait_Endorse= utils.getEndorseWebDriverWait();
		
		LoginPage loginPage_Endorse = new LoginPage(driver_Endorse,wait_Endorse);
		loginPage_Endorse.typeEmail(Utils.EMAIL);
		loginPage_Endorse.typePWD(Utils.PWD);
		
		HomePage home_Endorse = loginPage_Endorse.clickSubmit();
		ConnectionsPage connects = home_Endorse.getConnectionsPage();
		PersonalViewPage aConnect = connects.clickFirstConnect();
		
		Thread endorse = new EndorseSkills(aConnect);
		endorse.start();
	}
}
