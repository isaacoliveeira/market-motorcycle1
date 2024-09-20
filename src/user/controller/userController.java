package user.controller;

import user.model.*;
import user.service.UserService;

public class UserController {

    private ProfileUsername loggedUser;
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(ProfileName name, ProfileUsername username, ProfilePassword password) throws Exception {
        User user = new User(name, username, password);
        userService.addUser(user);
    }

    public Boolean loginUser(ProfileUsername username, ProfilePassword password) throws Exception {
        if(userService.login(username, password)){
            loggedUser = username;
            return true;
        } else{
            return false;
        }
    }

    public void editUser(ProfileName newName, ProfileUsername newUsername, ProfilePassword newPassword) throws Exception {
        User newUser = new User(newName, newUsername, newPassword);
        userService.editUser(loggedUser, newUser);
    }

    public void removeUser() throws Exception {
        userService.removeUser(loggedUser);
    }

    public void searchUser(ProfileUsername username) throws Exception {
        User user = userService.searchUser(username);
        System.out.println("Usuário encontrado: " + user);
    }
}
