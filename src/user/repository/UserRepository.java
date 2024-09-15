package user.repository;

import java.util.ArrayList;
import java.util.List;

import user.models.ProfileName;
import user.models.ProfilePassword;
import user.models.ProfileUsername;
import user.models.User;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public void addUser(User user) throws Exception {
        for (User u : users) {
            if (u.matches(user)) {
                throw new Exception("Usuário já existe");
            }
        }
        users.add(user);
    }

    public void removeUser(User user) throws Exception {
        if (!users.remove(user)) {
            throw new Exception("Usuário não encontrado");
        }
    }

    public User searchUser(ProfileUsername username) throws Exception {
        for (User user : users) {
            if (user.matches(username)) {
                return user;
            }
        }
        throw new Exception("Usuário não encontrado");
    }

    public void updateUser(ProfileUsername username, ProfileName newName, ProfileUsername newUsername, ProfilePassword newPassword) throws Exception {
        User user = searchUser(username);
        user.update(newName, newUsername, newPassword);
    }

    public Boolean login(ProfileUsername username, ProfilePassword password) throws Exception {
        User user = searchUser(username);
        if (user != null && user.checkPassword(password)) {
            return true;
        } else {
            throw new Exception("Senha inválida");
        }
    }
        
}
