package user.models;

public class User{
    private ProfileName name;
    private ProfileUsername username;
    private ProfilePassword password;

    public User(ProfileName name, ProfileUsername username, ProfilePassword password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public ProfileName getName() {
        return name;
    }

    public void setName(ProfileName name) {
        this.name = name;
    }

    public ProfileUsername getUsername() {
        return username;
    }

    public void setUsername(ProfileUsername username) {
        this.username = username;
    }

    public ProfilePassword getPassword() {
        return password;
    }

    public void setPassword(ProfilePassword password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", username=" + username + "]";
    }
}