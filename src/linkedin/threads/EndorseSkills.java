package linkedin.threads;

import linkedin.pageobject.PersonalViewPage;
import linkedin.prep.Utils;

public class EndorseSkills extends Thread {
	private int count = 0 ;
	private PersonalViewPage aConnect = null;
			
	public EndorseSkills(PersonalViewPage aConnect){
		this.aConnect = aConnect;
	}
	
	@Override
	public void run(){
		try{
			aConnect.clickEndorseSkillsForPersonalUnderView();
			Thread.sleep(2000);
			while (count < Utils.ENDORSE_SKILLS_STOP_POINT) {
				aConnect.clickEndorseSkillsForAssociateConnects();
				count++;
				Thread.sleep(1000);
			}
		}catch(Exception e){
			System.out.println("EndorseSkill Thread: endorse "+count+" skills");
			count = Integer.MAX_VALUE;
			e.printStackTrace();
		}
	}
	
}
