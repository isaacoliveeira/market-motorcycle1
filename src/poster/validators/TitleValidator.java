package poster.validators;

import poster.model.Title;

public class TitleValidator {
    public static boolean titleValidator(Title title){
        if(title.toString().length() > 60 || title.toString().length() < 2){
            return false;
        }
        return true;
    }
}
