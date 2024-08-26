package src.interfaces;

import src.controller.profile.ProfileName;
import src.controller.profile.ProfilePassword;
import src.controller.profile.ProfileUsername;


public interface ProfileInterface {
    public void Register(ProfileUsername username, ProfileName name, ProfilePassword password);
    public boolean login(ProfileUsername username, ProfilePassword password);
}