package user.controller;

import user.models.*;
import user.service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(ProfileName name, ProfileUsername username, ProfilePassword password) throws Exception {
        User user = new User(name, username, password);
        userService.addUser(user);
    }

    public void loginUser(ProfileUsername username, ProfilePassword password) throws Exception {
        userService.login(username, password);
    }

    public void editUser(ProfileUsername username, ProfileName newName, ProfileUsername newUsername, ProfilePassword newPassword) throws Exception {
        User newUser = new User(newName, newUsername, newPassword);
        userService.editUser(username, newUser);
    }

    public void removeUser(ProfileUsername username) throws Exception {
        userService.removeUser(username);
    }

    public void searchUser(ProfileUsername username) throws Exception {
        User user = userService.searchUser(username);
        System.out.println("Usuário encontrado: " + user);
    }
}
