package poster.validators;

import poster.model.Descrition;

public class DescritionValidator {
    public static boolean descritionValidator(Descrition descrition) {
        if(descrition.toString().length() > 50 || descrition.toString().length() < 2){
            return false;
        }
        return true;
    }
}
