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

    @Override
    public String toString() {
        return "User [name=" + name + ", username=" + username + "]";
    }

    public ProfileName getName() {
        return this.name;
    }

    public void setName(ProfileName name) {
        this.name = name;
    }

    public ProfileUsername getUsername() {
        return this.username;
    }

    public void setUsername(ProfileUsername username) {
        this.username = username;
    }

    public ProfilePassword getPassword() {
        return this.password;
    }

    public void setPassword(ProfilePassword password) {
        this.password = password;
    }

}