package user.validators;

import user.models.*;

public class UserValidator {

    public static boolean validate(User user) {
        return validateName(user.getName()) &&
               validateUsername(user.getUsername()) &&
               validatePassword(user.getPassword());
    }

    private static boolean validateName(ProfileName name) {
        return NameValidator.validateName(name);
    }

    private static boolean validateUsername(ProfileUsername username) {
        return UsernameValidator.validateUserName(username);
    }

    private static boolean validatePassword(ProfilePassword password) {
        return PasswordValidator.validatePassword(password);
    }
}
