package user.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user.models.ProfileUsername;

public class UsernameValidator {
    static Pattern pattern = Pattern.compile("^[a-z]{4,}[0-9]{0,4}$");

    public static boolean validateUserName(ProfileUsername profileUsername) {
        Matcher matcher = pattern.matcher(profileUsername.getUsername());
        return matcher.find();
    }
}

/*
- O nome de usuário deve conter pelo menos 4 letras minúsculas.
- Pode conter até 4 números.
- Não pode conter caracteres especiais ou letras maiúsculas. 
 */