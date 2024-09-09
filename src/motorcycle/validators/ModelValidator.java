package motorcycle.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import motorcycle.models.Model;


public class ModelValidator {
        static Pattern pattern = Pattern.compile("[a-zA-Z]{15}");
    public static boolean validateName(Model model){

        Matcher matcher = pattern.matcher(model.toString());
        return matcher.find();

    }
}