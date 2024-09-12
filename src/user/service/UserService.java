package user.service;

import user.models.*;
import user.repository.UserRepository;
import user.validators.UserValidator;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) throws Exception {
        if (!UserValidator.validate(user)) {
            throw new Exception("Dados do usuário inválidos.");
        }
        userRepository.addUser(user);
    }

    public void removeUser(ProfileUsername username) throws Exception {
        User user = userRepository.searchUser(username); // Verifica se o usuário existe
        if (user != null) {
            userRepository.removeUser(user);
        }
    }

    public User searchUser(ProfileUsername username) throws Exception {
        return userRepository.searchUser(username);
    }

    public void editUser(ProfileUsername username, User newUserData) throws Exception {
        // Valida os novos dados do usuário
        if (!UserValidator.validate(newUserData)) {
            throw new Exception("Dados do usuário inválidos.");
        }
        User existingUser = userRepository.searchUser(username);
        if (existingUser != null) {
            userRepository.removeUser(existingUser);
            userRepository.addUser(newUserData);
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }
}
