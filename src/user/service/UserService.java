package user.service;

import interfaces.ProfileInterface;
import user.models.User;
import user.models.ProfileName;
import user.models.ProfilePassword;
import user.models.ProfileUsername;

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
