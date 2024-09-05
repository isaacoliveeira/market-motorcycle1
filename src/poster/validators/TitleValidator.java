package src.poster.validators;

import src.poster.model.Title;

public class TitleValidator {
    public static boolean titleValidator(Title title){
        if(title.toString().length() > 50 || title.toString().length() < 2){
            return false;
        }
        return true;
    }
}
