package src.model;

import src.controller.profile.ProfileName;
import src.controller.profile.ProfilePassword;
import src.controller.profile.ProfileUsername;
import src.interfaces.ProfileInterface;

public class User implements ProfileInterface{
    ProfileName name;
    ProfileUsername username;
    ProfilePassword password;

    @Override
    public void Register(ProfileUsername username, ProfileName name, ProfilePassword password) {
        this.username = new ProfileUsername(username);
        this.name = new ProfileName(name);
        this.password = new ProfilePassword(password);
    }

    @Override
    public boolean login(ProfileUsername username, ProfilePassword password) {
        this.username = new ProfileUsername(username);
        this.password = new ProfilePassword(password);

        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
    
}
