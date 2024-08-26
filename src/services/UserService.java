package src.services;


import src.controller.profile.ProfileName;
import src.controller.profile.ProfilePassword;
import src.controller.profile.ProfileUsername;
import src.interfaces.ProfileInterface;
import src.model.User;

public class UserService implements ProfileInterface{

    @Override
    public void Register(ProfileName name, ProfileUsername username, ProfilePassword password) {
        User user = new User(name, username, password);
    }

    @Override
    public boolean login(ProfileUsername username, ProfilePassword password) {
        
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
