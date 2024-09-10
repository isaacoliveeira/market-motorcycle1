package user.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user.models.ProfileUsername;

public class UsernameValidator {
    static Pattern pattern = Pattern.compile("[a-z]{4,}[0-9]{0,6}");

    public static boolean validateUserName(ProfileUsername profileUsername) {
        Matcher matcher = pattern.matcher(profileUsername.toString());
        return matcher.find();
    }
}
