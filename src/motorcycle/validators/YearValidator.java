package motorcycle.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import motorcycle.models.Year;

public class YearValidator {
    
    static Pattern pattern = Pattern.compile("[1,2]{1}[0,9]{1}[0-9]{2}");
    public static boolean validateName(Year year){

        Matcher matcher = pattern.matcher(year.toString());
        return matcher.find();

    }
}
