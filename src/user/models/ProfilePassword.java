package user.models;


public class ProfilePassword {
    private String password;
    public ProfilePassword(ProfilePassword password){
        this.password = password.toString();
    }
    public boolean validateSenha(ProfilePassword profilePassword){
        profilePassword.validateSenha(profilePassword);
        return true;
    }
}