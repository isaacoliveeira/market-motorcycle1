package interfaces;

import user.models.ProfileName;
import user.models.ProfilePassword;
import user.models.ProfileUsername;


public interface ProfileInterface {
    public void Register(ProfileName name, ProfileUsername username, ProfilePassword password);
    public boolean login(ProfileUsername username, ProfilePassword password);
    public void update(ProfileUsername username);
}