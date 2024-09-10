package user.models;

public class ProfilePassword {

    private String password;

    public ProfilePassword(ProfilePassword password){
        this.password = password.toString();
    }
    

    // NÃO ENTENDO ESSE MÉTODO
    /* 
    public boolean validatePassword(ProfilePassword profilePassword){
        profilePassword.validatePassword(profilePassword);
        return true;
    }
    */
}