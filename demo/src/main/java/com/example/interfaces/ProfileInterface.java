package interfaces;

import user.model.ProfileName;
import user.model.ProfilePassword;
import user.model.ProfileUsername;


public interface ProfileInterface {
    public void Register(ProfileName name, ProfileUsername username, ProfilePassword password);
    public boolean login(ProfileUsername username, ProfilePassword password);
    public void update(ProfileUsername username);
}