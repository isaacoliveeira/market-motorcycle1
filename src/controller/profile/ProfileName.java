package src.controller.profile;

public class ProfileName {
    private String name;
    public ProfileName(ProfileName name){
        this.name = name.toString();
    }
    public static boolean validateName(ProfileName name){
        validateName(name);
        return false;
    }
}