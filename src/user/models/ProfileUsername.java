package user.models;

public class ProfileUsername {

    private String userName;

    public ProfileUsername(ProfileUsername userName){
        this.userName = userName.toString().toLowerCase();
    }

    //NÃO ENTENDO ESSE MÉTODO
    /*
    public boolean validateUsername(ProfileUsername userName){
        return validateUsername(userName);
    }
    */
}