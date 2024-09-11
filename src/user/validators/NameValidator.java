package user.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user.models.ProfileName;

public class NameValidator {
    static Pattern pattern = Pattern.compile("^[a-zA-Z]{4,}(?: [a-zA-Z]*)*$");
    public static boolean validateName(ProfileName name){
        Matcher matcher = pattern.matcher(name.toString());
        return matcher.find();
    }
}

/*
 - O nome deve conter pelo menos 4 letras consecutivas antes de qualquer espaço.
 - Após o espaço, pode haver mais letras (opcionalmente).
 - Apenas letras e espaços são permitidos, sem números ou caracteres especiais.
 */