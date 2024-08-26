package src.interfaces;

import src.controller.profile.ProfileName;
import src.controller.profile.ProfilePassword;
import src.controller.profile.ProfileUsername;


public interface ProfileInterface {
    public void Register(ProfileName name, ProfileUsername username, ProfilePassword password);
    public boolean login(ProfileUsername username, ProfilePassword password);
}