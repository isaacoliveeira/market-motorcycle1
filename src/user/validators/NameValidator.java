package user.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user.models.ProfileName;

public class NameValidator {
    static Pattern pattern = Pattern.compile("[a-zA-Z]{4,}");
    public static boolean validateName(ProfileName name){
        Matcher matcher = pattern.matcher(name.toString());
        return matcher.find();
    }
}