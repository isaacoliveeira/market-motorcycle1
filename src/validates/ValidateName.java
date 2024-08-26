package src.validates;

import src.controller.profile.ProfileName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateName {
    static Pattern pattern = Pattern.compile("[a-zA-Z]{4,}");
    public static boolean validateName(ProfileName name){
        Matcher matcher = pattern.matcher(name.toString());
        return matcher.find();
    }
}