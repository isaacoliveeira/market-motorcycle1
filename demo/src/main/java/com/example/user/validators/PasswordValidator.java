package com.example.user.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.user.model.ProfilePassword;

public class PasswordValidator {
    static Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z]{6,})(?=.*[0-9]{1,8})(?=.*[!@#$%^&*_-]).{8,}$");

    public static boolean validatePassword(ProfilePassword profilePassword) {
        Matcher matcher = pattern.matcher(profilePassword.getPassword());
        return matcher.find();
    }
}

/*
A senha deve conter pelo menos 6 letras (maiúsculas ou minúsculas).
Deve conter exatamente 1 caractere especial (nem mais, nem menos).
Deve conter pelo menos 1 número e no máximo 8.
A senha deve ser composta por letras, números e um caractere especial, sem outros caracteres.
*/
