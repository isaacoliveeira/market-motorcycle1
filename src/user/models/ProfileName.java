package user.models;

public class ProfileName {

    private String name;

    public ProfileName(ProfileName name){
        this.name = name.toString();
    }

    //NÃO ENTENDO ESSE MÉTODO
    /*
    public static boolean validateName(ProfileName name){
        validateName(name);
        return false;
    }
    */
}