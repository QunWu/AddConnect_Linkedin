package linkedin.threads;

import linkedin.pageobject.PeopleByCompanyPage;
import linkedin.prep.Utils;

public class AddConnectByCompany extends Thread {
	private PeopleByCompanyPage searchResultPage = null;
	private int total = 0;
	private Utils utils = null;
	
	public AddConnectByCompany(PeopleByCompanyPage searchResultPage,Utils utils) {
		this.utils = utils;
		this.searchResultPage = searchResultPage;
	}

	@Override
	public void run() {
		int currCompanyIdx = 0;
		while (currCompanyIdx < Utils.COMPANIES_LIST.length) {
			try {
				total+=this.searchResultPage.clickAllConnectsInPage();
				Thread.sleep(2000);
				if(total > Utils.ADD_CONNECT_BY_COMPANY_STOP_POINT){
					total = 0;
					currCompanyIdx ++;
					if(currCompanyIdx < Utils.COMPANIES_LIST.length)
						this.searchResultPage = this.searchResultPage.searchPeopleByCompany(Utils.COMPANIES_LIST[currCompanyIdx]);
					Thread.sleep(5000);
				}else{
					this.searchResultPage.goToNextPage();
					Thread.sleep(3000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.utils.quitAddConnectByCompany();
		System.out.println("AddConnectByCompany - 30: total added is "+total);
	}
}
