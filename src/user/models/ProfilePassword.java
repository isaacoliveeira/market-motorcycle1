package user.models;

public class ProfilePassword {

    private String password;

    public ProfilePassword(ProfilePassword password){
        this.password = password.toString();
    }
}