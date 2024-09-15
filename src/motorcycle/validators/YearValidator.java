package motorcycle.validators;


import java.time.Year;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

<<<<<<< HEAD
import motorcycle.models.Year;
=======
>>>>>>> origin/vinicius

public class YearValidator {
    
    static Pattern pattern = Pattern.compile("[1,2]{1}[0,9]{1}[0-9]{2}");
    public static boolean validateName(Year year){

        Matcher matcher = pattern.matcher(year.toString());
        return matcher.find();

    }
}
