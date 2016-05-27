package linkedin.pageobject.validators;
import linkedin.prep.Utils;
public class Validator {

      public static boolean toBeDismissValidator(String intro){
    	  intro = intro.toLowerCase();
            if (intro != null&& !intro.isEmpty())
                  for(String aKeyWord : Utils.KEYWORDS_TO_DISMISS_CONNECT)
                        if(intro.contains(aKeyWord))
                        	return true;
            return false;

      }

}
