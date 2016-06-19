package linkedin.threads;

import linkedin.exceptions.InvalidUpperBoundException;
import linkedin.pageobject.AddConnectsPage;
import linkedin.prep.Utils;

public class GenericAddConnect extends Thread {
	private AddConnectsPage addConnectsPage = null;
	private boolean needToContinue = true;
	private int total = 0;
	private int count = 0;
	private int upperBound = 0;
	private Utils utils = null;
	
	public GenericAddConnect(AddConnectsPage addConnectsPage, Utils utils) {
		this.addConnectsPage = addConnectsPage;
		this.utils = utils;
		this.upperBound = addConnectsPage.numberOfPeopleCard();
	}

	@Override
	public void run() {
		while (needToContinue) {
			try {
				this.addConnectsPage.addOneConnect();
				total++;
				count++;
				if (count >= upperBound) {
					this.addConnectsPage.scroll();
					Thread.sleep(4000);
					count = 0;
					upperBound = addConnectsPage.numberOfPeopleCard();
					if(upperBound <= 0 )
						throw new InvalidUpperBoundException("Invalid UpperBoundException:",upperBound);
				}
				Thread.sleep(2500);
			} catch (Exception e) {
				System.out.println("line 32, The total is : " + total);
				if(total >= Utils.GENERIC_ADD_CONNECT_STOP_POINT)
					needToContinue = false;
				this.addConnectsPage.refresh();
				upperBound = addConnectsPage.numberOfPeopleCard();
			}
		}

		System.out.println("GenericAddConect - 40: total added is "+total);
		this.utils.quitGenericAddConnect();
	}
}
