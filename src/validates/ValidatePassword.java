package src.validates;

import src.controller.profile.ProfilePassword;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {
    static Pattern pattern = Pattern.compile("[a-zA-Z]{6,}[1-9]{2,}");

    public static boolean validatePassword(ProfilePassword profilePassword) {
        Matcher matcher = pattern.matcher(profilePassword.toString());
        return matcher.find();
    }
}