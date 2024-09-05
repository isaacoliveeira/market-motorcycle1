package src.validates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.user.models.ProfileName;

public class ValidateName {
    static Pattern pattern = Pattern.compile("[a-zA-Z]{4,}");
    public static boolean validateName(ProfileName name){
        Matcher matcher = pattern.matcher(name.toString());
        return matcher.find();
    }
}