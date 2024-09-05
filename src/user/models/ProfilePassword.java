package src.user.models;

import src.validates.ValidatePassword;

public class ProfilePassword {
    private String password;
    public ProfilePassword(ProfilePassword password){
        this.password = password.toString();
    }
    public boolean validateSenha(ProfilePassword profilePassword){
        ValidatePassword.validatePassword(profilePassword);
        return true;
    }
}