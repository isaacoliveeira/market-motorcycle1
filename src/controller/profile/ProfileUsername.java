package src.controller.profile;

public class ProfileUsername {
    private String userName;
    public ProfileUsername(ProfileUsername userName){
        this.userName = userName.toString().toLowerCase();
    }
    public boolean validateUsername(ProfileUsername userName){
        return validateUsername(userName);
    }
}