package linkedin.pageobject.validators;
import linkedin.prep.Utils;
public class Validator {

      public static boolean toBeDismissValidator(String intro){
    	  intro = intro.toLowerCase();
            if (intro != null&& !intro.isEmpty())
                  for(String aKeyWord : Utils.KEYWORDS_TO_DISMISS_CONNECT_GENERIC_ADD_CONNECT)
                        if(intro.contains(aKeyWord))
                        	return true;
            return false;
      }
      
      public static boolean toAddConnectPositionValidator(String intro){
		intro = intro.toLowerCase().trim();
		if (intro != null && !intro.isEmpty())
			for (String aKeyWord : Utils.POSITIONS_FILTER_TO_ADD_CONNECT_BY_COMPANY)
				if (intro.contains(aKeyWord))
					return true;
		return false;
      }
      
      public static boolean toCheckBtnIsForConnect(String textOfBtn){
    	  if(Utils.CONNECT_BTN_TEXT_BY_COMPANY.equals(textOfBtn.toLowerCase().trim()))
    		  return true;
    	  
    	  return false;
      }
      
      public static boolean toCheckDemographicIsValidate(String demographic){
    	  for(String aValidateGraphic : Utils.POSITIONS_FILTER_TO_ADD_CONNECT_BY_COMPANY)
    		  if(demographic.toLowerCase().trim().contains(aValidateGraphic))
    			  return true;
    	  
    	  return false;
      }
      
      public static boolean toCheckCurrentJob(String expectedJob, String actualJob){
    	  if(expectedJob.toLowerCase().trim().equals(actualJob.toLowerCase().trim()))
    		  return true;
    	  return false;
      }
}
