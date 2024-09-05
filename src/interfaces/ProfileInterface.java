package src.interfaces;

import src.user.models.ProfileName;
import src.user.models.ProfilePassword;
import src.user.models.ProfileUsername;


public interface ProfileInterface {
    public void Register(ProfileName name, ProfileUsername username, ProfilePassword password);
    public boolean login(ProfileUsername username, ProfilePassword password);
    public void update(ProfileUsername username);
}