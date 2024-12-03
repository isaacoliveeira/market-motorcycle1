package com.example.interfaces;

import com.example.user.model.ProfileName;
import com.example.user.model.ProfilePassword;
import com.example.user.model.ProfileUsername;


public interface ProfileInterface {
    public void Register(ProfileName name, ProfileUsername username, ProfilePassword password);
    public boolean login(ProfileUsername username, ProfilePassword password);
    public void update(ProfileUsername username);
}