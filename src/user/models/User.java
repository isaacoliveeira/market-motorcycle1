package src.user.models;

public class User{
    private ProfileName name;
    private ProfileUsername username;
    private ProfilePassword password;

    public User(ProfileName name, ProfileUsername username, ProfilePassword password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", username=" + username + "]";
    }
}