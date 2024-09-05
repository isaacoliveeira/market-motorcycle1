package src.user.service;

import src.interfaces.ProfileInterface;
import src.user.User;
import src.user.models.ProfileName;
import src.user.models.ProfilePassword;
import src.user.models.ProfileUsername;

public class UserService implements ProfileInterface{

    @Override
    public void Register(ProfileName name, ProfileUsername username, ProfilePassword password) {
        User user = new User(name, username, password);
    }

    @Override
    public boolean login(ProfileUsername username, ProfilePassword password) {
        
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public void update(ProfileUsername username) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
